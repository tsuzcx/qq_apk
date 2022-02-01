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
    int i = paramMessage.arg1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          this.this$0.handleSeekNext(paramMessage.arg2);
          return;
        }
        this.this$0.handleSeek(paramMessage.arg2);
      }
    }
    else {
      this.this$0.handlePlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder.PlayHandler
 * JD-Core Version:    0.7.0.1
 */