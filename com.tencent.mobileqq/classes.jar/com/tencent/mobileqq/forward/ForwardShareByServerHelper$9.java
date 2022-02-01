package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ForwardShareByServerHelper$9
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardShareByServerHelper$9(ForwardShareByServerHelper paramForwardShareByServerHelper, Bundle paramBundle) {}
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError msg =");
      localStringBuilder.append(paramString);
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, localStringBuilder.toString());
    }
    return super.onError(paramInt, paramString, paramBundle);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_NORMAL_B77", bool);
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(ForwardShareByServerHelper.b(this.b)), ", isFirstShow =", Boolean.valueOf(ForwardShareByServerHelper.c(this.b)) });
    if (!ForwardShareByServerHelper.c(this.b))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("notifyServerSendMessage return for isFirstShow =");
      paramArrayOfByte.append(ForwardShareByServerHelper.c(this.b));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, paramArrayOfByte.toString());
      return;
    }
    if (ForwardShareByServerHelper.b(this.b))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("notifyServerSendMessage return for isTimeOut =");
      paramArrayOfByte.append(ForwardShareByServerHelper.b(this.b));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, paramArrayOfByte.toString());
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      paramBundle = new StringBuilder();
      paramBundle.append("notifyServerSendMessage currentRequestTime =");
      paramBundle.append(ForwardShareByServerHelper.j(this.b));
      paramBundle.append(", sendStamp = ");
      paramBundle.append(l);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, paramBundle.toString());
      if ((l == -1L) || (l != ForwardShareByServerHelper.j(this.b)))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for sendStamp");
        return;
      }
    }
    ForwardShareByServerHelper.a(this.b, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    ForwardShareByServerHelper.k(this.b).removeMessages(94);
    this.b.c();
    paramBundle = ForwardShareByServerHelper.l(this.b);
    String str4 = SdkShareReporter.b(ForwardShareByServerHelper.a(this.b).getInt("req_type"));
    String str5 = SdkShareReporter.c(ForwardShareByServerHelper.a(this.b).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {
      paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;
    } else {
      paramBundle = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    ReportController.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, localStringBuilder.toString(), str4, str5, paramBundle);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      if (i != 0) {
        ForwardShareByServerHelper.b(this.b, str1);
      } else {
        ForwardShareByServerHelper.m(this.b);
      }
      ForwardShareByServerHelper.b(this.b, this.a);
      return;
    }
    ForwardShareByServerHelper.a(this.b, paramInt, str2, str3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.9
 * JD-Core Version:    0.7.0.1
 */