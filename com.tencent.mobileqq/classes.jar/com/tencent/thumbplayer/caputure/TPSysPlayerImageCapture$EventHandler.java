package com.tencent.thumbplayer.caputure;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSysPlayerImageCapture$EventHandler
  extends Handler
{
  public TPSysPlayerImageCapture$EventHandler(TPSysPlayerImageCapture paramTPSysPlayerImageCapture, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
    }
    do
    {
      return;
      TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
      paramMessage = (TPSysPlayerImageCapture.CaptureMsg)paramMessage.obj;
      TPSysPlayerImageCapture.access$700(this.this$0, paramMessage);
      return;
      TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
    } while (TPSysPlayerImageCapture.access$800(this.this$0) == null);
    TPSysPlayerImageCapture.access$800(this.this$0).release();
    TPSysPlayerImageCapture.access$802(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPSysPlayerImageCapture.EventHandler
 * JD-Core Version:    0.7.0.1
 */