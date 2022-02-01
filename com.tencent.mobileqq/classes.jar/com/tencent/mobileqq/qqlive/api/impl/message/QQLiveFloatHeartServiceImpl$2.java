package com.tencent.mobileqq.qqlive.api.impl.message;

import android.util.Log;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.mobileqq.qqlive.utils.InBuffer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.BroadcastFreeLove;

class QQLiveFloatHeartServiceImpl$2
  implements IQQLivePushCallback
{
  QQLiveFloatHeartServiceImpl$2(QQLiveFloatHeartServiceImpl paramQQLiveFloatHeartServiceImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    try
    {
      paramArrayOfByte = new InBuffer(paramArrayOfByte);
      paramInt = (int)paramArrayOfByte.c();
      paramLiveMsgExtInfo = new StringBuilder();
      paramLiveMsgExtInfo.append("收到礼物消息，dwAppId=");
      paramLiveMsgExtInfo.append(paramInt);
      Log.d("QQLiveFloatHeartService", paramLiveMsgExtInfo.toString());
      if (paramInt != 3012) {
        return;
      }
      paramArrayOfByte.c();
      paramLiveMsgExtInfo = new byte[paramArrayOfByte.b()];
      paramArrayOfByte.a(paramLiveMsgExtInfo);
      paramArrayOfByte = new InBuffer(paramLiveMsgExtInfo);
      paramArrayOfByte.a();
      paramLiveMsgExtInfo = new byte[paramArrayOfByte.b()];
      paramArrayOfByte.a(paramLiveMsgExtInfo);
      paramArrayOfByte = BroadcastFreeLove.a(paramLiveMsgExtInfo);
      QQLiveFloatHeartServiceImpl.access$000(this.this$0, paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramLiveMsgExtInfo = new StringBuilder();
      paramLiveMsgExtInfo.append("[initPush] onRecv error:");
      paramLiveMsgExtInfo.append(paramArrayOfByte.getMessage());
      QLog.e("QQLiveFloatHeartService", 1, paramLiveMsgExtInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFloatHeartServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */