package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ForwardShareByServerHelper$9
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardShareByServerHelper$9(ForwardShareByServerHelper paramForwardShareByServerHelper, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ForwardStatisticsReporter.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper)), ", isFirstShow =", Boolean.valueOf(ForwardShareByServerHelper.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper)) });
      if (ForwardShareByServerHelper.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper)) {
        break;
      }
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isFirstShow =" + ForwardShareByServerHelper.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper));
      return;
    }
    if (ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper))
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isTimeOut =" + ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage currentRequestTime =" + ForwardShareByServerHelper.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper) + ", sendStamp = " + l);
      if ((l == -1L) || (l != ForwardShareByServerHelper.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper)))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for sendStamp");
        return;
      }
    }
    ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper).removeMessages(94);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper.c();
    paramBundle = ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper);
    String str4 = ForwardUtils.c(ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper).getInt("req_type"));
    String str5 = ForwardUtils.a(ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      ReportController.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      ForwardShareByServerHelper.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper, str1);
    }
    for (;;)
    {
      ForwardShareByServerHelper.c(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper);
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QLog.isColorLevel())) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.9
 * JD-Core Version:    0.7.0.1
 */