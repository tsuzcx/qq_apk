package com.tencent.thumbplayer.core.decoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;

class TPBaseMediaCodecDecoder$AsyncDecodeHandler
  extends Handler
{
  TPBaseMediaCodecDecoder$AsyncDecodeHandler(TPBaseMediaCodecDecoder paramTPBaseMediaCodecDecoder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    int i = 0;
    for (;;)
    {
      synchronized (TPBaseMediaCodecDecoder.access$400(this.this$0))
      {
        switch (paramMessage.what)
        {
        case 1000: 
          TPBaseMediaCodecDecoder.access$900(this.this$0, i);
          return;
          TPBaseMediaCodecDecoder localTPBaseMediaCodecDecoder = this.this$0;
          i = paramMessage.arg1;
          if (paramMessage.arg2 == 1) {
            bool = true;
          }
          i = TPBaseMediaCodecDecoder.access$500(localTPBaseMediaCodecDecoder, i, bool);
          break;
        case 1001: 
          i = TPBaseMediaCodecDecoder.access$600(this.this$0, (Surface)paramMessage.obj);
          break;
        case 1002: 
          i = TPBaseMediaCodecDecoder.access$700(this.this$0);
          break;
        case 1003: 
          i = TPBaseMediaCodecDecoder.access$800(this.this$0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.AsyncDecodeHandler
 * JD-Core Version:    0.7.0.1
 */