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
      StringBuilder localStringBuilder1 = new StringBuilder(256);
      localStringBuilder1.append("StatictisInfo[ ");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("appSeq: ");
      localStringBuilder2.append(paramStatictisInfo.jdField_a_of_type_Int);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("errCode: ");
      localStringBuilder2.append(paramStatictisInfo.b);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("retryCount: ");
      localStringBuilder2.append(paramStatictisInfo.c);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("detailErrorReason: ");
      localStringBuilder2.append(paramStatictisInfo.jdField_a_of_type_Long);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("timeoutReason: ");
      localStringBuilder2.append(paramStatictisInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append(" ]");
      paramStatictisInfo = new StringBuilder();
      paramStatictisInfo.append("onNotifyResultAfterSendRich isSuccess:");
      paramStatictisInfo.append(paramBoolean);
      paramStatictisInfo.append(",");
      paramStatictisInfo.append(localStringBuilder1.toString());
      QLog.d("RedPacketStructMsg", 1, paramStatictisInfo.toString());
      return;
    }
    paramStatictisInfo = new StringBuilder();
    paramStatictisInfo.append("onNotifyResultAfterSendRich isSuccess:");
    paramStatictisInfo.append(paramBoolean);
    paramStatictisInfo.append(",statictisInfo == null");
    QLog.d("RedPacketStructMsg", 1, paramStatictisInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareMsgHelper.3
 * JD-Core Version:    0.7.0.1
 */