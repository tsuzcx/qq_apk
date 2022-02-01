package com.tencent.mobileqq.qqlive.api.impl.pendant;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;

class QQLiveModulePendant$2
  implements IQQLivePushCallback
{
  QQLiveModulePendant$2(QQLiveModulePendant paramQQLiveModulePendant) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramInt != 210) {
      return;
    }
    QQLiveModulePendant.access$100(this.this$0, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.pendant.QQLiveModulePendant.2
 * JD-Core Version:    0.7.0.1
 */