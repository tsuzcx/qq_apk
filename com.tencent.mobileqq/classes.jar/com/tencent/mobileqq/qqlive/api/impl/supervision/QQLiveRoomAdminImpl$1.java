package com.tencent.mobileqq.qqlive.api.impl.supervision;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.listener.supervision.OnAdminStatusChangedListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.PushMsg_AdminMsg;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.PushMsg_SetAdmin;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Charsets;

class QQLiveRoomAdminImpl$1
  implements IQQLivePushCallback
{
  QQLiveRoomAdminImpl$1(QQLiveRoomAdminImpl paramQQLiveRoomAdminImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramInt == 253) {}
    try
    {
      PushMsg_SetAdmin localPushMsg_SetAdmin = PushMsg_SetAdmin.a(paramArrayOfByte);
      paramLiveMsgExtInfo = new String(localPushMsg_SetAdmin.a, Charsets.UTF_8);
      paramArrayOfByte = paramLiveMsgExtInfo;
      if (TextUtils.isEmpty(paramLiveMsgExtInfo)) {
        paramArrayOfByte = "";
      }
      paramLiveMsgExtInfo = QQLiveRoomAdminImpl.access$000(this.this$0).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((OnAdminStatusChangedListener)paramLiveMsgExtInfo.next()).a(localPushMsg_SetAdmin.c, paramArrayOfByte);
      }
      if (paramInt != 255) {
        break label167;
      }
      paramLiveMsgExtInfo = new String(PushMsg_AdminMsg.a(paramArrayOfByte).b, Charsets.UTF_8);
      paramArrayOfByte = paramLiveMsgExtInfo;
      if (TextUtils.isEmpty(paramLiveMsgExtInfo)) {
        paramArrayOfByte = "";
      }
      paramLiveMsgExtInfo = QQLiveRoomAdminImpl.access$000(this.this$0).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((OnAdminStatusChangedListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
      }
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      label163:
      label167:
      break label163;
    }
    paramArrayOfByte.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveRoomAdminImpl.1
 * JD-Core Version:    0.7.0.1
 */