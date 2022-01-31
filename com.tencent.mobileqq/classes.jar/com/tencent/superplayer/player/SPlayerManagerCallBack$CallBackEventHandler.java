package com.tencent.superplayer.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;

class SPlayerManagerCallBack$CallBackEventHandler
  extends Handler
{
  private WeakReference<SPlayerListenerManager> mListenerManagerWeakReference;
  private WeakReference<ISuperPlayer> mPlayerMgrWeakReference;
  
  public SPlayerManagerCallBack$CallBackEventHandler(SPlayerManagerCallBack paramSPlayerManagerCallBack, ISuperPlayer paramISuperPlayer, SPlayerListenerManager paramSPlayerListenerManager, Looper paramLooper)
  {
    super(paramLooper);
    this.mPlayerMgrWeakReference = new WeakReference(paramISuperPlayer);
    this.mListenerManagerWeakReference = new WeakReference(paramSPlayerListenerManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      SPlayerManagerCallBack.access$300(this.this$0);
      return;
    case 2: 
      paramMessage = (SPlayerManagerCallBack.OnErrorParams)paramMessage.obj;
      SPlayerManagerCallBack.access$400(this.this$0, paramMessage.module, paramMessage.errorType, paramMessage.errorCode, paramMessage.extraInfo);
      return;
    case 3: 
      paramMessage = (SPlayerManagerCallBack.OnInfoParams)paramMessage.obj;
      SPlayerManagerCallBack.access$500(this.this$0, paramMessage.what, paramMessage.arg1, paramMessage.arg2, paramMessage.extra);
      return;
    case 4: 
      SPlayerManagerCallBack.access$600(this.this$0);
      return;
    case 5: 
      SPlayerManagerCallBack.access$700(this.this$0);
      return;
    case 6: 
      paramMessage = (SPlayerManagerCallBack.OnCaptureImageSucceeParams)paramMessage.obj;
      SPlayerManagerCallBack.access$800(this.this$0, paramMessage.id, paramMessage.width, paramMessage.height, paramMessage.bitmap);
      return;
    case 7: 
      SPlayerManagerCallBack.access$900(this.this$0, paramMessage.arg1, paramMessage.arg2);
      return;
    }
    SPlayerManagerCallBack.access$1000(this.this$0, paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPlayerManagerCallBack.CallBackEventHandler
 * JD-Core Version:    0.7.0.1
 */