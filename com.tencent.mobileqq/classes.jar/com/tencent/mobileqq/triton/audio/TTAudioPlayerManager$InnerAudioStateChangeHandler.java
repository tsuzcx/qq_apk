package com.tencent.mobileqq.triton.audio;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import java.io.File;
import java.lang.ref.WeakReference;

public class TTAudioPlayerManager$InnerAudioStateChangeHandler
  implements IAudioStateChangeListener
{
  final int MAX_RETRY_COUNT = 3;
  int audioId;
  volatile boolean callPaly;
  IAudioStateChangeListener callback;
  volatile String localPath;
  WeakReference<TTAudioPlayerManager> managerReference;
  String rawPath;
  volatile int retryCount;
  String src;
  
  public TTAudioPlayerManager$InnerAudioStateChangeHandler(TTAudioPlayerManager paramTTAudioPlayerManager1, TTAudioPlayerManager paramTTAudioPlayerManager2, int paramInt, IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    this.managerReference = new WeakReference(paramTTAudioPlayerManager2);
    this.audioId = paramInt;
    this.callback = paramIAudioStateChangeListener;
    this.retryCount = 0;
  }
  
  private void downloadAndPlayAudio()
  {
    TTAudioPlayerManager.access$300(this.this$0).getQQEnv().download(this.rawPath, new TTAudioPlayerManager.InnerAudioStateChangeHandler.1(this));
    TTLog.i("[audio] TTAudioPlayerManager", "downloadAndPlayAudio rawPath:" + this.rawPath);
  }
  
  private boolean isFileExists(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists());
  }
  
  private void prepareAndPlayLocalAudio(boolean paramBoolean)
  {
    if (isFileExists(TTAudioPlayerManager.access$300(this.this$0).getQQEnv().getResPath(this.localPath, null, null)))
    {
      if ((this.managerReference != null) && (this.managerReference.get() != null))
      {
        TTAudioPlayerManager localTTAudioPlayerManager = (TTAudioPlayerManager)this.managerReference.get();
        TTLog.i("[audio] TTAudioPlayerManager", "audioId:" + this.audioId + ", playLocalAudio localPath:" + this.localPath);
        localTTAudioPlayerManager.setMusicPath(null, this.audioId, this.localPath);
        if (paramBoolean) {
          localTTAudioPlayerManager.playMusic(this.audioId);
        }
      }
      return;
    }
    TTLog.e("[audio] TTAudioPlayerManager", "playLocalAudio localPath:" + this.localPath + " not exists");
  }
  
  public boolean hasCallPlay()
  {
    return this.callPaly;
  }
  
  public void onCanPlay()
  {
    if (this.callback != null) {
      this.callback.onCanPlay();
    }
  }
  
  public void onEnded()
  {
    if (this.callback != null) {
      this.callback.onEnded();
    }
  }
  
  public void onError(int paramInt)
  {
    TTLog.e("[audio] TTAudioPlayerManager", this + " onError retryCount:" + this.retryCount + ", audioId:" + this.audioId);
    if ((URLUtil.isNetworkUrl(this.rawPath)) && (this.retryCount < 3))
    {
      this.retryCount += 1;
      if (isFileExists(this.localPath)) {
        prepareAndPlayLocalAudio(hasCallPlay());
      }
    }
    do
    {
      return;
      downloadAndPlayAudio();
      return;
      this.localPath = this.src;
      if ((this.retryCount < 3) && (isFileExists(TTAudioPlayerManager.access$300(this.this$0).getQQEnv().getResPath(this.localPath, null, null))))
      {
        this.retryCount += 1;
        AudioHandleThread.getInstance().postDelayed(new TTAudioPlayerManager.InnerAudioStateChangeHandler.2(this), this.retryCount * 500);
        return;
      }
    } while (this.callback == null);
    this.callback.onError(paramInt);
  }
  
  public void onPause()
  {
    if (this.callback != null) {
      this.callback.onPause();
    }
  }
  
  public void onPlay()
  {
    if (this.callback != null) {
      this.callback.onPlay();
    }
  }
  
  public void onSeeked()
  {
    if (this.callback != null) {
      this.callback.onSeeked();
    }
  }
  
  public void onSeeking()
  {
    if (this.callback != null) {
      this.callback.onSeeking();
    }
  }
  
  public void onStop()
  {
    if (this.callback != null) {
      this.callback.onStop();
    }
  }
  
  public void onTimeUpdate()
  {
    if (this.callback != null) {
      this.callback.onTimeUpdate();
    }
  }
  
  public void onWaiting()
  {
    if (this.callback != null) {
      this.callback.onWaiting();
    }
  }
  
  public void setCallPlay(boolean paramBoolean)
  {
    this.callPaly = paramBoolean;
  }
  
  public void setPath(String paramString1, String paramString2)
  {
    this.src = paramString1;
    this.rawPath = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.TTAudioPlayerManager.InnerAudioStateChangeHandler
 * JD-Core Version:    0.7.0.1
 */