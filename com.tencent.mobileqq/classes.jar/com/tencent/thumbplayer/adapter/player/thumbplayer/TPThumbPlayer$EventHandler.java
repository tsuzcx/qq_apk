package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.ref.WeakReference;

class TPThumbPlayer$EventHandler
  extends Handler
{
  private WeakReference<TPThumbPlayer> mWeakRef;
  
  public TPThumbPlayer$EventHandler(TPThumbPlayer paramTPThumbPlayer1, Looper paramLooper, TPThumbPlayer paramTPThumbPlayer2)
  {
    super(paramLooper);
    this.mWeakRef = new WeakReference(paramTPThumbPlayer2);
  }
  
  private void handleOnAsyncCallResult(TPThumbPlayer.OnASyncCallResultInfo paramOnASyncCallResultInfo)
  {
    switch (paramOnASyncCallResultInfo.callType)
    {
    default: 
      TPThumbPlayer.access$500(this.this$0, paramOnASyncCallResultInfo);
      return;
    case 1: 
      TPThumbPlayer.access$300(this.this$0);
      return;
    }
    TPThumbPlayer.access$400(this.this$0);
  }
  
  private void handleOnError(int paramInt1, int paramInt2)
  {
    TPThumbPlayer.access$200(this.this$0).onError(TPThumbPlayerUtils.convert2TPErrorType(paramInt1), paramInt2, 0L, 0L);
  }
  
  private void handleOnInfoLong(TPThumbPlayer.OnInfoLongInfo paramOnInfoLongInfo)
  {
    switch (paramOnInfoLongInfo.infoType)
    {
    default: 
      TPThumbPlayer.access$800(this.this$0, paramOnInfoLongInfo.infoType, paramOnInfoLongInfo);
      return;
    case 250: 
      TPThumbPlayer.access$600(this.this$0, paramOnInfoLongInfo.lParam1, paramOnInfoLongInfo.lParam2);
      return;
    }
    TPThumbPlayer.access$700(this.this$0);
  }
  
  private void handleOnInfoObject(TPThumbPlayer.OnInfoObjectInfo paramOnInfoObjectInfo)
  {
    switch (paramOnInfoObjectInfo.infoType)
    {
    default: 
      TPThumbPlayer.access$1000(this.this$0, paramOnInfoObjectInfo.infoType, paramOnInfoObjectInfo);
    }
    do
    {
      return;
    } while (!(paramOnInfoObjectInfo.objParam instanceof String));
    TPThumbPlayer.access$900(this.this$0).subtitleData = ((String)paramOnInfoObjectInfo.objParam);
    TPThumbPlayer.access$200(this.this$0).onSubtitleData(TPThumbPlayer.access$900(this.this$0));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((TPThumbPlayer)this.mWeakRef.get() == null)
    {
      TPLogUtil.e(TPThumbPlayer.access$000(this.this$0), "mWeakRef is null");
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      TPLogUtil.w(TPThumbPlayer.access$000(this.this$0), "message :" + paramMessage.what + "  not recognition");
      return;
    case 1: 
      handleOnAsyncCallResult((TPThumbPlayer.OnASyncCallResultInfo)paramMessage.obj);
      return;
    case 2: 
      handleOnInfoLong((TPThumbPlayer.OnInfoLongInfo)paramMessage.obj);
      return;
    case 3: 
      handleOnInfoObject((TPThumbPlayer.OnInfoObjectInfo)paramMessage.obj);
      return;
    }
    paramMessage = (TPThumbPlayer.OnErrorInfo)paramMessage.obj;
    handleOnError(paramMessage.msgType, paramMessage.errorCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */