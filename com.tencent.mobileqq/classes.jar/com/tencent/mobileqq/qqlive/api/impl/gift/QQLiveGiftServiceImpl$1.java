package com.tencent.mobileqq.qqlive.api.impl.gift;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

class QQLiveGiftServiceImpl$1
  implements IQQLivePushCallback
{
  QQLiveGiftServiceImpl$1(QQLiveGiftServiceImpl paramQQLiveGiftServiceImpl, IQQLiveSDK paramIQQLiveSDK) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IQQLiveGiftService", 1, "get gift message push");
    }
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = QQLiveGiftServiceImpl.access$000(this.this$0).iterator();
      while (paramArrayOfByte.hasNext()) {
        ((ReceiveGiftMessageListener)paramArrayOfByte.next()).a(-1, "gift data is null");
      }
      return;
    }
    try
    {
      paramLiveMsgExtInfo = (IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class);
      paramArrayOfByte = paramLiveMsgExtInfo.covertPushDataToGiftMessage(paramLiveMsgExtInfo.getHighPriorityPushCmd(this.val$sdkImpl.getAppId()), paramLiveMsgExtInfo.getGiftPushSubCmd(this.val$sdkImpl.getAppId()), paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return;
      }
      paramLiveMsgExtInfo = QQLiveGiftServiceImpl.access$000(this.this$0).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((ReceiveGiftMessageListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
      }
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramLiveMsgExtInfo = QQLiveGiftServiceImpl.access$000(this.this$0).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((ReceiveGiftMessageListener)paramLiveMsgExtInfo.next()).a(-1, "gift data parse fail");
      }
      paramLiveMsgExtInfo = new StringBuilder();
      paramLiveMsgExtInfo.append("gift data parse error:");
      paramLiveMsgExtInfo.append(paramArrayOfByte.getMessage());
      QLog.e("IQQLiveGiftService", 1, paramLiveMsgExtInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */