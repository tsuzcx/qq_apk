package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class HWVideoDecoder$PlayHandler
  extends Handler
{
  public HWVideoDecoder$PlayHandler(HWVideoDecoder paramHWVideoDecoder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.this$0.handlePlay();
      return;
    case 2: 
      this.this$0.handleSeek(paramMessage.arg2);
      return;
    }
    this.this$0.handleSeekNext(paramMessage.arg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder.PlayHandler
 * JD-Core Version:    0.7.0.1
 */