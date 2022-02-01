package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.util.QLog;

final class ShareMsgHelper$3
  extends MessageObserver
{
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    if (paramStatictisInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramStatictisInfo.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramStatictisInfo.b);
      localStringBuilder.append("retryCount: " + paramStatictisInfo.c);
      localStringBuilder.append("detailErrorReason: " + paramStatictisInfo.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramStatictisInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareMsgHelper.3
 * JD-Core Version:    0.7.0.1
 */