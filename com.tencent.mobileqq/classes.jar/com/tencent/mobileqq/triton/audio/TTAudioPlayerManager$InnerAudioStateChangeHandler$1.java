package com.tencent.mobileqq.triton.audio;

import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;

class TTAudioPlayerManager$InnerAudioStateChangeHandler$1
  implements ITDownloadListener
{
  TTAudioPlayerManager$InnerAudioStateChangeHandler$1(TTAudioPlayerManager.InnerAudioStateChangeHandler paramInnerAudioStateChangeHandler) {}
  
  public void onCancel(String paramString)
  {
    if (this.this$1.callback != null) {
      this.this$1.callback.onError(10002);
    }
  }
  
  public void onFail(String paramString1, int paramInt, String paramString2)
  {
    if (this.this$1.callback != null) {
      this.this$1.callback.onError(10002);
    }
  }
  
  public void onProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onSuccess(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.this$1.localPath = paramString3;
    TTLog.i("[audio] TTAudioPlayerManager", "download rawPath:" + this.this$1.rawPath + " success, localPath:" + this.this$1.localPath);
    AudioHandleThread.getInstance().post(new TTAudioPlayerManager.InnerAudioStateChangeHandler.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.TTAudioPlayerManager.InnerAudioStateChangeHandler.1
 * JD-Core Version:    0.7.0.1
 */