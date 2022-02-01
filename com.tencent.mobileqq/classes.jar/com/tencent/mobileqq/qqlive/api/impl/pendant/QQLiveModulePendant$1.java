package com.tencent.mobileqq.qqlive.api.impl.pendant;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;

class QQLiveModulePendant$1
  implements IQQLivePushCallback
{
  QQLiveModulePendant$1(QQLiveModulePendant paramQQLiveModulePendant) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramInt != 209) {
      return;
    }
    QQLiveModulePendant.access$000(this.this$0, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.pendant.QQLiveModulePendant.1
 * JD-Core Version:    0.7.0.1
 */