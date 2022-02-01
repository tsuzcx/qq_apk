package com.tencent.qqmini.miniapp.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LameMp3Recorder
{
  public static final int MSG_PLAY_ERROR = -11;
  public static final int MSG_PLAY_FINISH = 106;
  public static final int MSG_PLAY_PAUSE = 102;
  public static final int MSG_PLAY_RESUME = 103;
  public static final int MSG_PLAY_START = 101;
  public static final int MSG_PLAY_STOP = 105;
  public static final int MSG_PLAY_UPDATE = 104;
  public static final int MSG_RECORD_ERROR = -10;
  public static final int MSG_RECORD_FRAME = 6;
  public static final int MSG_RECORD_PAUSE = 2;
  public static final int MSG_RECORD_RESUME = 3;
  public static final int MSG_RECORD_START = 1;
  public static final int MSG_RECORD_STOP = 5;
  public static final int MSG_RECORD_UPDATE = 4;
  public static final String TAG = "com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder";
  private final AudioManager mAudioManger;
  private LameMp3Recorder.AudioRecordListener mAudioRecordListener;
  private int mCallbackFrameSize = 50;
  private int mCallbackTime = 500;
  private final LameMp3EncodeThread mEncodeThread = new LameMp3EncodeThread(this, this.mMainHandler);
  private final Handler mMainHandler = new LameMp3Recorder.MHandler(this);
  private int mMaxRecordTime = 30;
  private long mPauseTime;
  private List<Integer> mPauseTimeList = new ArrayList();
  private long mStartPlayTime;
  private long mStartTime;
  private LameMp3Recorder.OnErrorListener onErrorListener;
  private LameMp3Recorder.AudioPlayerListener onPlayListener;
  
  public LameMp3Recorder(Context paramContext)
  {
    this.mAudioManger = ((AudioManager)paramContext.getSystemService("audio"));
  }
  
  private void callOnRecordStop()
  {
    LameMp3Recorder.AudioRecordListener localAudioRecordListener = this.mAudioRecordListener;
    if (localAudioRecordListener != null) {
      localAudioRecordListener.onRecordStop(getRecordFilPath(), getRecordDuration(), getRecordFileSize());
    }
    if (this.mMainHandler.hasMessages(4)) {
      this.mMainHandler.removeMessages(4);
    }
  }
  
  public static Message generatePlayErrMsg(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = -11;
    localMessage.obj = paramString;
    return localMessage;
  }
  
  public static Message generateRecordErrMsg(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = -10;
    localMessage.obj = paramString;
    return localMessage;
  }
  
  private static void onMsgRecordFrame(Message paramMessage, LameMp3Recorder paramLameMp3Recorder)
  {
    if (paramLameMp3Recorder.mAudioRecordListener != null)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      int i = paramMessage.arg1;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramLameMp3Recorder.mAudioRecordListener.onRecordFrame(arrayOfByte, bool);
    }
  }
  
  private static void onMsgRecordResume(LameMp3Recorder paramLameMp3Recorder)
  {
    LameMp3Recorder.AudioRecordListener localAudioRecordListener = paramLameMp3Recorder.mAudioRecordListener;
    if (localAudioRecordListener != null) {
      localAudioRecordListener.onRecordResume();
    }
    if (!paramLameMp3Recorder.mMainHandler.hasMessages(4)) {
      paramLameMp3Recorder.mMainHandler.sendEmptyMessage(4);
    }
  }
  
  public LameMp3Recorder.AudioRecordListener getAudioRecordListener()
  {
    return this.mAudioRecordListener;
  }
  
  public int getCallbackFrameSize()
  {
    return this.mCallbackFrameSize;
  }
  
  public int getCallbackTime()
  {
    return this.mCallbackTime;
  }
  
  public int getMaxRecordTime()
  {
    return this.mMaxRecordTime;
  }
  
  public int getPlayTime()
  {
    return (int)((System.currentTimeMillis() - this.mStartPlayTime) / 1000L);
  }
  
  public long getRecordDuration()
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    Iterator localIterator = this.mPauseTimeList.iterator();
    while (localIterator.hasNext()) {
      l -= ((Integer)localIterator.next()).intValue();
    }
    return l;
  }
  
  public String getRecordFilPath()
  {
    return this.mEncodeThread.getRecordFilPath();
  }
  
  public long getRecordFileSize()
  {
    return new File(getRecordFilPath()).length();
  }
  
  public long getRecordTime()
  {
    return this.mEncodeThread.getRecordTime();
  }
  
  public int getTime()
  {
    return (int)(getRecordDuration() / 1000L);
  }
  
  public int getVoiceLevel()
  {
    return this.mEncodeThread.getVoiceLevel();
  }
  
  public boolean isPause()
  {
    if (!this.mEncodeThread.isRecording()) {
      return false;
    }
    return this.mEncodeThread.isPause();
  }
  
  public boolean isRecording()
  {
    return this.mEncodeThread.isRecording();
  }
  
  public void onDestory()
  {
    LameMp3EncodeThread localLameMp3EncodeThread = this.mEncodeThread;
    if (localLameMp3EncodeThread != null) {
      localLameMp3EncodeThread.onDestory();
    }
  }
  
  public void playPause()
  {
    if (this.mEncodeThread.playPause()) {
      this.mMainHandler.sendEmptyMessage(102);
    }
  }
  
  public void playResume()
  {
    if (this.mEncodeThread.playResume()) {
      this.mMainHandler.sendEmptyMessage(103);
    }
  }
  
  public void playStart(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e(TAG, "请先设置音频播放路径");
      return;
    }
    this.mEncodeThread.setFilePlayPath(paramString);
    this.mEncodeThread.play();
  }
  
  public void playStop()
  {
    if (this.mEncodeThread.stopPlay()) {
      this.mMainHandler.sendEmptyMessage(105);
    }
  }
  
  public void recordPause()
  {
    if (this.mEncodeThread.isPause()) {
      return;
    }
    if (getTime() < 1)
    {
      this.mMainHandler.sendMessage(generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_too_short)));
      recordStop();
    }
    this.mPauseTime = System.currentTimeMillis();
    this.mEncodeThread.setPause(true);
    this.mMainHandler.sendEmptyMessage(2);
  }
  
  public void recordResume()
  {
    if (!this.mEncodeThread.isPause()) {
      return;
    }
    int i = (int)(System.currentTimeMillis() - this.mPauseTime);
    if (i > 0) {
      this.mPauseTimeList.add(Integer.valueOf(i));
    }
    this.mEncodeThread.setPause(false);
    this.mMainHandler.sendEmptyMessage(3);
  }
  
  public void recordStart()
  {
    this.mPauseTimeList.clear();
    this.mEncodeThread.startRecord();
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void recordStop()
  {
    if (this.mEncodeThread.isRecording()) {
      this.mEncodeThread.restoreRecording();
    }
  }
  
  public void setAudioRecordListener(LameMp3Recorder.AudioRecordListener paramAudioRecordListener)
  {
    this.mAudioRecordListener = paramAudioRecordListener;
  }
  
  public void setAudioSource(String paramString)
  {
    this.mEncodeThread.setAudioSource(paramString);
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    this.mCallbackFrameSize = paramInt;
    this.mEncodeThread.setCallbackFrameSize(paramInt);
  }
  
  public void setCallbackTime(int paramInt)
  {
    this.mCallbackTime = paramInt;
  }
  
  public void setEncodingPcmFormat(int paramInt)
  {
    this.mEncodeThread.setEncodingPcmFormat(paramInt);
  }
  
  public void setInSampleRate(int paramInt)
  {
    this.mEncodeThread.setInSampleRate(paramInt);
  }
  
  public void setMaxRecordTime(int paramInt)
  {
    this.mMaxRecordTime = paramInt;
  }
  
  public void setOnErrorListener(LameMp3Recorder.OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  public void setOnPlayListener(LameMp3Recorder.AudioPlayerListener paramAudioPlayerListener)
  {
    this.onPlayListener = paramAudioPlayerListener;
  }
  
  public void setOutBitRate(int paramInt)
  {
    this.mEncodeThread.setOutBitRate(paramInt);
  }
  
  public void setOutChannel(int paramInt)
  {
    this.mEncodeThread.setOutChannel(paramInt);
  }
  
  public void setOutSampleRate(int paramInt)
  {
    this.mEncodeThread.setOutSampleRate(paramInt);
  }
  
  public void setPlayMode(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mAudioManger.setSpeakerphoneOn(false);
      this.mAudioManger.setMode(3);
      this.mEncodeThread.getMediaPlayer().setAudioStreamType(0);
      return;
    }
    this.mAudioManger.setMode(0);
    this.mAudioManger.setSpeakerphoneOn(true);
    this.mEncodeThread.getMediaPlayer().setAudioStreamType(3);
  }
  
  public void setQuality(int paramInt)
  {
    this.mEncodeThread.setQuality(paramInt);
  }
  
  public void setRecordFilPath(String paramString)
  {
    this.mEncodeThread.setRecordFilPath(paramString);
  }
  
  public void setRecordFileFormat(String paramString)
  {
    this.mEncodeThread.setRecordFileFormat(paramString);
  }
  
  public void setRecordTime(long paramLong)
  {
    this.mEncodeThread.setRecordTime(paramLong);
  }
  
  public void setSampleRate(int paramInt)
  {
    setInSampleRate(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder
 * JD-Core Version:    0.7.0.1
 */