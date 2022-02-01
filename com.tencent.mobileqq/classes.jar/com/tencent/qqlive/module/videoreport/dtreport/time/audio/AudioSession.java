package com.tencent.qqlive.module.videoreport.dtreport.time.audio;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.task.TimerTaskManager;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;

public class AudioSession
  implements IAudioSessionListener, ITimeProcessor
{
  private static final long DEFAULT_HEART_BEAT_INTERVAL = 60000L;
  private static final long DEFAULT_TIME_PIN_INTERVAL = 5000L;
  private static final long MIN_TIME_PIN_INTERVAL = 5000L;
  private AudioEntity mAudioEntity;
  private Object mAudioPage;
  private Object mAudioPlayer;
  private String mAudioSessionId;
  private long mBackgroundDuration;
  private HeartBeatProcessor mCurrentHeartBeatProcessor;
  private long mForegroundDuration;
  private long mHeartBeatInterval;
  private String mHeartBeatTaskKey;
  private boolean mIsInEndState = false;
  private PageManager.IPageListener mPageListener;
  private int mProcessorState = -1;
  private long mTimePinInterval;
  
  public AudioSession(Object paramObject)
  {
    this.mAudioPlayer = paramObject;
    this.mHeartBeatInterval = (VideoReportInner.getInstance().getConfiguration().getAudioReportHearBeatInterval() * 1000);
    this.mTimePinInterval = (VideoReportInner.getInstance().getConfiguration().getAudioTimePinInterval() * 1000);
    initHeartBeatProcessor();
    initListener();
    reset();
  }
  
  private Object getAudioPage()
  {
    if (this.mAudioEntity == null) {
      this.mAudioEntity = AudioDataManager.getInstance().getAudioInfo(this.mAudioPlayer);
    }
    if (this.mAudioEntity != null) {
      return this.mAudioEntity.getPageObject();
    }
    return null;
  }
  
  private void handlePageIn(@NonNull PageInfo paramPageInfo)
  {
    if (isAudioPage(paramPageInfo)) {
      setInForeground(true);
    }
  }
  
  private void handlePageOut(@NonNull PageInfo paramPageInfo)
  {
    if (isAudioPage(paramPageInfo)) {
      setInForeground(false);
    }
  }
  
  private void initHeartBeatProcessor()
  {
    if (this.mHeartBeatInterval <= 0L) {
      this.mHeartBeatInterval = 60000L;
    }
    if (this.mTimePinInterval <= 0L) {
      this.mTimePinInterval = 5000L;
    }
    if (this.mTimePinInterval < 5000L) {
      this.mTimePinInterval = 5000L;
    }
    if (this.mTimePinInterval > this.mHeartBeatInterval) {
      this.mHeartBeatInterval = this.mTimePinInterval;
    }
    this.mCurrentHeartBeatProcessor = new HeartBeatProcessor(isAudioInForeground(), this.mTimePinInterval);
    this.mCurrentHeartBeatProcessor.setHeartBeatCallback(new AudioSession.2(this));
  }
  
  private void initListener()
  {
    if (this.mPageListener == null) {
      this.mPageListener = new AudioSession.3(this);
    }
  }
  
  private boolean isAudioInForeground()
  {
    return (AudioDataManager.getInstance().isForeground(this.mAudioPlayer)) && (AppEventReporter.getInstance().isAppInForeground());
  }
  
  private boolean isAudioPage(PageInfo paramPageInfo)
  {
    if (this.mAudioPage == null) {
      this.mAudioPage = getAudioPage();
    }
    return (this.mAudioPage != null) && (paramPageInfo != null) && (paramPageInfo.getPage() == this.mAudioPage);
  }
  
  private void registerListener()
  {
    PageManager.getInstance().register(this.mPageListener);
  }
  
  private void startHeartBeatProcessor()
  {
    this.mAudioEntity = AudioDataManager.getInstance().getAudioInfo(this.mAudioPlayer);
    this.mAudioPage = getAudioPage();
    this.mCurrentHeartBeatProcessor.start();
  }
  
  private void triggerTiming()
  {
    try
    {
      this.mCurrentHeartBeatProcessor.stop();
      this.mForegroundDuration += this.mCurrentHeartBeatProcessor.getForegroundDuration();
      this.mBackgroundDuration += this.mCurrentHeartBeatProcessor.getBackgroundDuration();
      this.mCurrentHeartBeatProcessor.reset();
      if (this.mProcessorState == 0) {
        startHeartBeatProcessor();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void unRegisterListener()
  {
    PageManager.getInstance().unregister(this.mPageListener);
  }
  
  public void audioEnd()
  {
    this.mIsInEndState = true;
    stop();
    AudioEventReporter.reportAudioEnd(this.mAudioPlayer, this);
  }
  
  public void audioPause()
  {
    stop();
  }
  
  public void audioResume()
  {
    start();
  }
  
  public void audioStart()
  {
    this.mIsInEndState = false;
    start();
    AudioEventReporter.reportAudioStart(this.mAudioPlayer, this);
  }
  
  public AudioEntity getAudioEntity()
  {
    return this.mAudioEntity;
  }
  
  public String getAudioSessionId()
  {
    return this.mAudioSessionId;
  }
  
  public long getBackgroundDuration()
  {
    return this.mBackgroundDuration;
  }
  
  public long getForegroundDuration()
  {
    return this.mForegroundDuration;
  }
  
  public long getHeartBeatInterval()
  {
    return this.mHeartBeatInterval;
  }
  
  public long getTimePinInterval()
  {
    return this.mTimePinInterval;
  }
  
  public boolean isInEndState()
  {
    return this.mIsInEndState;
  }
  
  public void onBufferingEnd()
  {
    this.mCurrentHeartBeatProcessor.forbidTimePinTiming(false);
  }
  
  public void onBufferingStart()
  {
    this.mCurrentHeartBeatProcessor.forbidTimePinTiming(true);
  }
  
  public void reset()
  {
    if (this.mProcessorState == 0) {
      stop();
    }
    this.mAudioSessionId = ReportUtils.generateSessionId();
    this.mProcessorState = -1;
    this.mForegroundDuration = 0L;
    this.mBackgroundDuration = 0L;
    this.mHeartBeatTaskKey = null;
    this.mCurrentHeartBeatProcessor.reset();
    this.mCurrentHeartBeatProcessor.setSessionId(this.mAudioSessionId);
    this.mCurrentHeartBeatProcessor.forbidTimePinTiming(false);
  }
  
  public void setInForeground(boolean paramBoolean)
  {
    this.mCurrentHeartBeatProcessor.setInForeground(paramBoolean);
  }
  
  public void start()
  {
    if (this.mProcessorState == 0) {
      stop();
    }
    this.mProcessorState = 0;
    this.mHeartBeatTaskKey = TimerTaskManager.getInstance().addUIThreadTimerTask(new AudioSession.1(this), this.mHeartBeatInterval, this.mHeartBeatInterval);
    startHeartBeatProcessor();
    registerListener();
  }
  
  public void stop()
  {
    if (this.mProcessorState == 0)
    {
      this.mProcessorState = 1;
      TimerTaskManager.getInstance().cancelTimerTask(this.mHeartBeatTaskKey);
      this.mHeartBeatTaskKey = null;
      triggerTiming();
      unRegisterListener();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioSession
 * JD-Core Version:    0.7.0.1
 */