package com.tencent.mtt.hippy.views.audioview;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class AudioView
  extends HippyViewGroup
  implements HippyViewBase, AudioPlayManager.AudioManagerListener
{
  private AudioPlayManager mAudioPlayerManager = AudioPlayManager.getInstance();
  private String mCurrentPlayAudio = "";
  final HippyEngineContext mHippyContext;
  private boolean mOnPlayCompleteCallBack = false;
  private boolean mOnPlayErrorCallBack = false;
  private boolean mOnPlayPauseCallBack = false;
  private boolean mOnPlayProgressCallBack = false;
  private boolean mOnPlayResumeCallBack = false;
  private boolean mOnPlayStartCallBack = false;
  private int mUniqPlayId = AudioPlayManager.globalUiqPlayId();
  
  public AudioView(Context paramContext)
  {
    super(paramContext);
    this.mHippyContext = ((HippyInstanceContext)paramContext).getEngineContext();
  }
  
  public void onPlayBuffering(String paramString)
  {
    LogUtils.d("AudioView", "onPlayBuffering");
  }
  
  public void onPlayComplete(String paramString)
  {
    if (this.mOnPlayCompleteCallBack)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("playAudioUrl", paramString);
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onEnded", localHippyMap);
    }
  }
  
  public void onPlayError(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mOnPlayErrorCallBack)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("currentSrc", paramString);
      localHippyMap.pushInt("what", paramInt1);
      localHippyMap.pushInt("extra", paramInt2);
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onError", localHippyMap);
    }
  }
  
  public void onPlayPause(String paramString)
  {
    if (this.mOnPlayPauseCallBack)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("currentSrc", paramString);
      localHippyMap.pushInt("size", 0);
      localHippyMap.pushInt("current", this.mAudioPlayerManager.currentPlayAudioPosition());
      localHippyMap.pushInt("length", this.mAudioPlayerManager.currentPlayAudioDuration());
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onPause", localHippyMap);
    }
  }
  
  public void onPlayProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mOnPlayProgressCallBack)
    {
      paramString = new HippyMap();
      paramString.pushInt("playTimeMs", paramInt1);
      paramString.pushInt("current", paramInt1);
      paramString.pushInt("length", paramInt2);
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onProgress", paramString);
    }
  }
  
  public void onPlayResume(String paramString)
  {
    if (this.mOnPlayResumeCallBack)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("currentSrc", paramString);
      localHippyMap.pushInt("size", 0);
      localHippyMap.pushInt("current", this.mAudioPlayerManager.currentPlayAudioPosition());
      localHippyMap.pushInt("length", this.mAudioPlayerManager.currentPlayAudioDuration());
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onPlaying", localHippyMap);
    }
  }
  
  public void onPlayStart(String paramString)
  {
    if (this.mOnPlayStartCallBack)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("currentSrc", paramString);
      localHippyMap.pushInt("size", 0);
      localHippyMap.pushInt("current", this.mAudioPlayerManager.currentPlayAudioPosition());
      localHippyMap.pushInt("length", this.mAudioPlayerManager.currentPlayAudioDuration());
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onPlaying", localHippyMap);
    }
  }
  
  public void pauseAudio()
  {
    this.mAudioPlayerManager.pauseAudio(this.mUniqPlayId);
  }
  
  public void playAudio()
  {
    this.mAudioPlayerManager.playAudio(this.mUniqPlayId);
  }
  
  public void releaseAudio()
  {
    this.mAudioPlayerManager.releaseAudio(this.mUniqPlayId);
  }
  
  public void seekTo(int paramInt)
  {
    this.mAudioPlayerManager.seekTo(this.mUniqPlayId, paramInt);
  }
  
  public void setAudioAutoPlay(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.mCurrentPlayAudio))) {
      this.mAudioPlayerManager.playAudio(this.mUniqPlayId);
    }
  }
  
  public void setAudioPlayUrl(String paramString)
  {
    this.mCurrentPlayAudio = paramString;
    this.mAudioPlayerManager.setAudioPlayUrl(this.mUniqPlayId, paramString, this);
  }
  
  public void setOnPlayComplete(boolean paramBoolean)
  {
    this.mOnPlayCompleteCallBack = paramBoolean;
  }
  
  public void setOnPlayError(boolean paramBoolean)
  {
    this.mOnPlayErrorCallBack = paramBoolean;
  }
  
  public void setOnPlayPause(boolean paramBoolean)
  {
    this.mOnPlayPauseCallBack = paramBoolean;
  }
  
  public void setOnPlayProgress(boolean paramBoolean)
  {
    this.mOnPlayProgressCallBack = paramBoolean;
  }
  
  public void setOnPlayResume(boolean paramBoolean)
  {
    this.mOnPlayResumeCallBack = paramBoolean;
  }
  
  public void setOnPlayStart(boolean paramBoolean)
  {
    this.mOnPlayStartCallBack = paramBoolean;
  }
  
  public void stopAudio()
  {
    this.mAudioPlayerManager.stopAudio(this.mUniqPlayId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioView
 * JD-Core Version:    0.7.0.1
 */