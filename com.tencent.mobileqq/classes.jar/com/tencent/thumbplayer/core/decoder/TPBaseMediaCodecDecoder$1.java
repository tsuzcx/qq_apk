package com.tencent.thumbplayer.core.decoder;

import com.tencent.tmediacodec.callback.SimpleCodecCallback;

class TPBaseMediaCodecDecoder$1
  extends SimpleCodecCallback
{
  TPBaseMediaCodecDecoder$1(TPBaseMediaCodecDecoder paramTPBaseMediaCodecDecoder) {}
  
  public void onReuseCodecAPIException(String paramString, Throwable paramThrowable)
  {
    super.onReuseCodecAPIException(paramString, paramThrowable);
    TPMediaCodecManager.onMediaCodecException(this.this$0.mCodecId, paramString);
  }
  
  public void onStarted(Boolean paramBoolean, String paramString)
  {
    super.onStarted(paramBoolean, paramString);
    TPMediaCodecManager.onMediaCodecReady(this.this$0.mCodecId, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.1
 * JD-Core Version:    0.7.0.1
 */