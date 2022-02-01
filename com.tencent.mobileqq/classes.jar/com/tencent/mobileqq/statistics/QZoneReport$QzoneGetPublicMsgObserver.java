package com.tencent.mobileqq.statistics;

import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

class QZoneReport$QzoneGetPublicMsgObserver
  extends QZoneObserver
{
  protected void e(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof mobile_get_qzone_public_msg_rsp)))
    {
      int i = QZoneReport.a().decrementAndGet();
      QZoneReport.a(0);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      SharedPreferences.Editor localEditor = localAppRuntime.getPreferences().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localAppRuntime.getAccount());
      localStringBuilder.append("_");
      localStringBuilder.append("qzone_xp_req_left");
      localEditor.putInt(localStringBuilder.toString(), i).apply();
      QZoneReport.b(((mobile_get_qzone_public_msg_rsp)paramBundle).next_req_tmstamp);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("next req time: ");
        paramBundle.append(QZoneReport.b());
        paramBundle.append(", left: ");
        paramBundle.append(i);
        QLog.i("QZoneReport", 2, paramBundle.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X800915D", "0X800915D", 0, 0, "", "", "", "");
    }
    else
    {
      QZoneReport.c();
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "qzone report failed");
      }
    }
    QZoneReport.a().set(false);
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(QZoneReport.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QZoneReport.QzoneGetPublicMsgObserver
 * JD-Core Version:    0.7.0.1
 */