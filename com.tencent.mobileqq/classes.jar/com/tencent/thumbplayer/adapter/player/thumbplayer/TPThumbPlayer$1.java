package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.os.Message;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPThumbPlayer$1
  implements ITPNativePlayerMessageCallback
{
  TPThumbPlayer$1(TPThumbPlayer paramTPThumbPlayer) {}
  
  public void onASyncCallResult(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    TPLogUtil.i(TPThumbPlayer.access$000(), "onASyncCallResult, callType:" + paramInt1 + ", opaque:" + paramLong + ", errorType:" + paramInt2 + ", errorCode:" + paramInt3);
    TPThumbPlayer.OnASyncCallResultInfo localOnASyncCallResultInfo = new TPThumbPlayer.OnASyncCallResultInfo();
    localOnASyncCallResultInfo.callType = paramInt1;
    localOnASyncCallResultInfo.opaque = paramLong;
    localOnASyncCallResultInfo.errorType = paramInt2;
    localOnASyncCallResultInfo.errorCode = paramInt3;
    Message.obtain(TPThumbPlayer.access$100(this.this$0), 1, localOnASyncCallResultInfo).sendToTarget();
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(TPThumbPlayer.access$000(), "onError, msgType:" + paramInt1 + ", errorCode:" + paramInt2);
    TPThumbPlayer.OnErrorInfo localOnErrorInfo = new TPThumbPlayer.OnErrorInfo();
    localOnErrorInfo.msgType = paramInt1;
    localOnErrorInfo.errorCode = paramInt2;
    Message.obtain(TPThumbPlayer.access$100(this.this$0), 4, localOnErrorInfo).sendToTarget();
  }
  
  public void onInfoLong(int paramInt, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(TPThumbPlayer.access$000(), "onInfoLong, infoType:" + paramInt + ", lParam1:" + paramLong1 + ", lParam2:" + paramLong2);
    TPThumbPlayer.OnInfoLongInfo localOnInfoLongInfo = new TPThumbPlayer.OnInfoLongInfo();
    localOnInfoLongInfo.infoType = paramInt;
    localOnInfoLongInfo.lParam1 = paramLong1;
    localOnInfoLongInfo.lParam2 = paramLong2;
    Message.obtain(TPThumbPlayer.access$100(this.this$0), 2, localOnInfoLongInfo).sendToTarget();
  }
  
  public void onInfoObject(int paramInt, Object paramObject)
  {
    TPLogUtil.i(TPThumbPlayer.access$000(), "onInfoObject, infoType:" + paramInt + ", objParam:" + paramObject);
    TPThumbPlayer.OnInfoObjectInfo localOnInfoObjectInfo = new TPThumbPlayer.OnInfoObjectInfo();
    localOnInfoObjectInfo.infoType = paramInt;
    localOnInfoObjectInfo.objParam = paramObject;
    Message.obtain(TPThumbPlayer.access$100(this.this$0), 3, localOnInfoObjectInfo).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.1
 * JD-Core Version:    0.7.0.1
 */