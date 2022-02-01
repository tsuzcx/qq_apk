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
    for (;;)
    {
      synchronized (TPBaseMediaCodecDecoder.access$400(this.this$0))
      {
        int j = paramMessage.what;
        int i = 0;
        boolean bool = false;
        switch (j)
        {
        case 1003: 
          i = TPBaseMediaCodecDecoder.access$800(this.this$0);
          break;
        case 1002: 
          i = TPBaseMediaCodecDecoder.access$700(this.this$0);
          break;
        case 1001: 
          i = TPBaseMediaCodecDecoder.access$600(this.this$0, (Surface)paramMessage.obj);
          break;
        case 1000: 
          TPBaseMediaCodecDecoder localTPBaseMediaCodecDecoder = this.this$0;
          i = paramMessage.arg1;
          if (paramMessage.arg2 == 1) {
            bool = true;
          }
          i = TPBaseMediaCodecDecoder.access$500(localTPBaseMediaCodecDecoder, i, bool);
          TPBaseMediaCodecDecoder.access$900(this.this$0, i);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.AsyncDecodeHandler
 * JD-Core Version:    0.7.0.1
 */