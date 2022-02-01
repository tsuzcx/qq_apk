package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapErrorType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType;
import com.tencent.thumbplayer.log.TPBaseLogger;
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
    int i = paramOnASyncCallResultInfo.callType;
    if (i != 1)
    {
      if (i != 2)
      {
        TPThumbPlayer.access$500(this.this$0, paramOnASyncCallResultInfo);
        return;
      }
      TPThumbPlayer.access$400(this.this$0);
      return;
    }
    TPThumbPlayer.access$300(this.this$0);
  }
  
  private void handleOnError(@TPCommonEnum.NativeErrorType int paramInt1, int paramInt2)
  {
    TPThumbPlayer.access$200(this.this$0).onError(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapErrorType.class, paramInt1), paramInt2, 0L, 0L);
  }
  
  private void handleOnInfoLong(TPThumbPlayer.OnInfoLongInfo paramOnInfoLongInfo)
  {
    int i = paramOnInfoLongInfo.infoType;
    if (i != 154)
    {
      if (i != 250)
      {
        TPThumbPlayer.access$800(this.this$0, paramOnInfoLongInfo.infoType, paramOnInfoLongInfo);
        return;
      }
      TPThumbPlayer.access$600(this.this$0, paramOnInfoLongInfo.lParam1, paramOnInfoLongInfo.lParam2);
      return;
    }
    TPThumbPlayer.access$700(this.this$0);
  }
  
  private void handleOnInfoObject(TPThumbPlayer.OnInfoObjectInfo paramOnInfoObjectInfo)
  {
    if (paramOnInfoObjectInfo.infoType != 502)
    {
      TPThumbPlayer.access$1000(this.this$0, paramOnInfoObjectInfo.infoType, paramOnInfoObjectInfo);
      return;
    }
    if ((paramOnInfoObjectInfo.objParam instanceof String))
    {
      TPThumbPlayer.access$900(this.this$0).subtitleData = ((String)paramOnInfoObjectInfo.objParam);
      TPThumbPlayer.access$200(this.this$0).onSubtitleData(TPThumbPlayer.access$900(this.this$0));
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((TPThumbPlayer)this.mWeakRef.get() == null)
    {
      TPThumbPlayer.access$000(this.this$0).error("mWeakRef is null");
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            TPBaseLogger localTPBaseLogger = TPThumbPlayer.access$000(this.this$0);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("message :");
            localStringBuilder.append(paramMessage.what);
            localStringBuilder.append("  not recognition");
            localTPBaseLogger.warn(localStringBuilder.toString());
            return;
          }
          paramMessage = (TPThumbPlayer.OnErrorInfo)paramMessage.obj;
          handleOnError(paramMessage.msgType, paramMessage.errorCode);
          return;
        }
        handleOnInfoObject((TPThumbPlayer.OnInfoObjectInfo)paramMessage.obj);
        return;
      }
      handleOnInfoLong((TPThumbPlayer.OnInfoLongInfo)paramMessage.obj);
      return;
    }
    handleOnAsyncCallResult((TPThumbPlayer.OnASyncCallResultInfo)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */