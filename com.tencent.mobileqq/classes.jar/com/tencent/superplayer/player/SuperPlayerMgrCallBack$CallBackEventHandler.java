package com.tencent.superplayer.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;

class SuperPlayerMgrCallBack$CallBackEventHandler
  extends Handler
{
  private WeakReference<SuperPlayerListenerMgr> mListenerManagerWeakReference;
  private WeakReference<ISuperPlayer> mPlayerMgrWeakReference;
  
  public SuperPlayerMgrCallBack$CallBackEventHandler(SuperPlayerMgrCallBack paramSuperPlayerMgrCallBack, ISuperPlayer paramISuperPlayer, SuperPlayerListenerMgr paramSuperPlayerListenerMgr, Looper paramLooper)
  {
    super(paramLooper);
    this.mPlayerMgrWeakReference = new WeakReference(paramISuperPlayer);
    this.mListenerManagerWeakReference = new WeakReference(paramSuperPlayerListenerMgr);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      SuperPlayerMgrCallBack.access$300(this.this$0);
      return;
    case 2: 
      paramMessage = (SuperPlayerMgrCallBack.OnErrorParams)paramMessage.obj;
      SuperPlayerMgrCallBack.access$400(this.this$0, paramMessage.module, paramMessage.errorType, paramMessage.errorCode, paramMessage.extraInfo);
      return;
    case 3: 
      paramMessage = (SuperPlayerMgrCallBack.OnInfoParams)paramMessage.obj;
      SuperPlayerMgrCallBack.access$500(this.this$0, paramMessage.what, paramMessage.arg1, paramMessage.arg2, paramMessage.extra);
      return;
    case 4: 
      SuperPlayerMgrCallBack.access$600(this.this$0);
      return;
    case 5: 
      SuperPlayerMgrCallBack.access$700(this.this$0);
      return;
    case 6: 
      paramMessage = (SuperPlayerMgrCallBack.OnCaptureImageSucceeParams)paramMessage.obj;
      SuperPlayerMgrCallBack.access$800(this.this$0, paramMessage.id, paramMessage.width, paramMessage.height, paramMessage.bitmap);
      return;
    case 7: 
      SuperPlayerMgrCallBack.access$900(this.this$0, paramMessage.arg1, paramMessage.arg2);
      return;
    }
    SuperPlayerMgrCallBack.access$1000(this.this$0, paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrCallBack.CallBackEventHandler
 * JD-Core Version:    0.7.0.1
 */