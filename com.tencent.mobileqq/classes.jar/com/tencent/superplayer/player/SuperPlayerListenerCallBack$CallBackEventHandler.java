package com.tencent.superplayer.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.superplayer.api.TVideoNetInfo;

class SuperPlayerListenerCallBack$CallBackEventHandler
  extends Handler
{
  public SuperPlayerListenerCallBack$CallBackEventHandler(SuperPlayerListenerCallBack paramSuperPlayerListenerCallBack, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      SuperPlayerListenerCallBack.access$600(this.this$0);
      return;
    case 2: 
      paramMessage = (SuperPlayerListenerCallBack.OnErrorParams)paramMessage.obj;
      SuperPlayerListenerCallBack.access$700(this.this$0, paramMessage.module, paramMessage.errorType, paramMessage.errorCode, paramMessage.extraInfo);
      return;
    case 3: 
      paramMessage = (SuperPlayerListenerCallBack.OnInfoParams)paramMessage.obj;
      SuperPlayerListenerCallBack.access$800(this.this$0, paramMessage.what, paramMessage.arg1, paramMessage.arg2, paramMessage.extra);
      return;
    case 4: 
      SuperPlayerListenerCallBack.access$900(this.this$0);
      return;
    case 5: 
      SuperPlayerListenerCallBack.access$1000(this.this$0);
      return;
    case 6: 
      paramMessage = (SuperPlayerListenerCallBack.OnCaptureImageSucceeParams)paramMessage.obj;
      SuperPlayerListenerCallBack.access$1100(this.this$0, paramMessage.id, paramMessage.width, paramMessage.height, paramMessage.bitmap);
      return;
    case 7: 
      paramMessage = (SuperPlayerListenerCallBack.OnCaptureImageFailedParams)paramMessage.obj;
      SuperPlayerListenerCallBack.access$1200(this.this$0, paramMessage.id, paramMessage.errCode);
      return;
    case 8: 
      paramMessage = (SuperPlayerListenerCallBack.OnVideoSizeParams)paramMessage.obj;
      SuperPlayerListenerCallBack.access$1300(this.this$0, paramMessage.width, paramMessage.height);
      return;
    case 9: 
      paramMessage = (SuperPlayerListenerCallBack.OnDefinitionInfoParams)paramMessage.obj;
      SuperPlayerListenerCallBack.access$1400(this.this$0, paramMessage.currentDefinition, paramMessage.definitionList);
      return;
    }
    SuperPlayerListenerCallBack.access$1500(this.this$0, (TVideoNetInfo)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerListenerCallBack.CallBackEventHandler
 * JD-Core Version:    0.7.0.1
 */