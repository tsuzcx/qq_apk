package com.tencent.mobileqq.qqlive.api.impl.supervision;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.PushMsg_KickOutSomebody;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Charsets;

class QQLiveKickOutImpl$1
  implements IQQLivePushCallback
{
  QQLiveKickOutImpl$1(QQLiveKickOutImpl paramQQLiveKickOutImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramInt != 254) {
      return;
    }
    try
    {
      paramArrayOfByte = PushMsg_KickOutSomebody.a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        QLog.d("QQLiveKickOutImpl", 1, "receive a push msg kick out msg 254");
        paramArrayOfByte = new String(paramArrayOfByte.a, Charsets.UTF_8);
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          paramLiveMsgExtInfo = QQLiveKickOutImpl.access$000(this.this$0).iterator();
          while (paramLiveMsgExtInfo.hasNext()) {
            ((OnKickedOutOfRoomListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
          }
        }
      }
      return;
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveKickOutImpl.1
 * JD-Core Version:    0.7.0.1
 */