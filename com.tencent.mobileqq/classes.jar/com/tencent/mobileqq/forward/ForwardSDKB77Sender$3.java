package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;

class ForwardSDKB77Sender$3
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardSDKB77Sender$3(ForwardSDKB77Sender paramForwardSDKB77Sender, long paramLong, Bundle paramBundle) {}
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "onError msg =", paramString });
    }
    return super.onError(paramInt, paramString, paramBundle);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = paramInt;
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_NORMAL_B77", bool);
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 10000L) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", timeout=", Boolean.valueOf(bool) });
    if (bool)
    {
      ForwardSDKB77Sender.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77Sender, new Object[] { Integer.valueOf(0), "", HardCodeUtil.a(2131704893), "" }, -6);
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      if ((l == -1L) || (l != ForwardSDKB77Sender.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77Sender)))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("handleGetMessageState currentRequestTime =");
        paramArrayOfByte.append(ForwardSDKB77Sender.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77Sender));
        paramArrayOfByte.append(", sendStamp = ");
        paramArrayOfByte.append(l);
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, paramArrayOfByte.toString());
        return;
      }
    }
    paramBundle = SdkShareReporter.a(this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"));
    Object localObject = SdkShareReporter.b(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ReportController.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, localStringBuilder.toString(), paramBundle, (String)localObject, str);
    if ((i == 0) && (paramArrayOfByte != null)) {
      ForwardSDKB77Sender.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77Sender, this.jdField_a_of_type_AndroidOsBundle);
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77Sender;
    localObject = ForwardUtils.a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      i = -7;
    }
    ForwardSDKB77Sender.a(paramBundle, (Object[])localObject, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77Sender.3
 * JD-Core Version:    0.7.0.1
 */