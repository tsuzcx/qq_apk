package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.os.Message;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.log.TPBaseLogger;

class TPThumbPlayer$1
  implements ITPNativePlayerMessageCallback
{
  TPThumbPlayer$1(TPThumbPlayer paramTPThumbPlayer) {}
  
  private void sendMessage(int paramInt, Object paramObject)
  {
    if (TPThumbPlayer.access$100(this.this$0) != null) {
      Message.obtain(TPThumbPlayer.access$100(this.this$0), paramInt, paramObject).sendToTarget();
    }
  }
  
  public void onASyncCallResult(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject = TPThumbPlayer.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onASyncCallResult, callType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", opaque:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", errorType:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errorCode:");
    localStringBuilder.append(paramInt3);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = new TPThumbPlayer.OnASyncCallResultInfo();
    ((TPThumbPlayer.OnASyncCallResultInfo)localObject).callType = paramInt1;
    ((TPThumbPlayer.OnASyncCallResultInfo)localObject).opaque = paramLong;
    ((TPThumbPlayer.OnASyncCallResultInfo)localObject).errorType = paramInt2;
    ((TPThumbPlayer.OnASyncCallResultInfo)localObject).errorCode = paramInt3;
    sendMessage(1, localObject);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    Object localObject = TPThumbPlayer.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError, msgType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errorCode:");
    localStringBuilder.append(paramInt2);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = new TPThumbPlayer.OnErrorInfo();
    ((TPThumbPlayer.OnErrorInfo)localObject).msgType = paramInt1;
    ((TPThumbPlayer.OnErrorInfo)localObject).errorCode = paramInt2;
    sendMessage(4, localObject);
  }
  
  public void onInfoLong(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = TPThumbPlayer.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInfoLong, infoType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", lParam1:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", lParam2:");
    localStringBuilder.append(paramLong2);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = new TPThumbPlayer.OnInfoLongInfo();
    ((TPThumbPlayer.OnInfoLongInfo)localObject).infoType = paramInt;
    ((TPThumbPlayer.OnInfoLongInfo)localObject).lParam1 = paramLong1;
    ((TPThumbPlayer.OnInfoLongInfo)localObject).lParam2 = paramLong2;
    sendMessage(2, localObject);
  }
  
  public void onInfoObject(int paramInt, Object paramObject)
  {
    Object localObject = TPThumbPlayer.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInfoObject, infoType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", objParam:");
    localStringBuilder.append(paramObject);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = new TPThumbPlayer.OnInfoObjectInfo();
    ((TPThumbPlayer.OnInfoObjectInfo)localObject).infoType = paramInt;
    ((TPThumbPlayer.OnInfoObjectInfo)localObject).objParam = paramObject;
    sendMessage(3, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.1
 * JD-Core Version:    0.7.0.1
 */