package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.TimeUtil;
import com.tencent.mfsdk.tools.PhoneUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.nearby.report.ODReportTask;
import com.tencent.mobileqq.troop.widget.BaseUsingTimeReport;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;

public class NearbyUsingTimeReport
  extends BaseUsingTimeReport
  implements QActivityLifecycleCallbacks
{
  protected long a;
  private NearbyAppInterface a;
  private long b;
  
  public NearbyUsingTimeReport(NearbyAppInterface paramNearbyAppInterface, String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  private void f()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    String str = TimeUtil.convertTimestampToDate(this.jdField_b_of_type_Long, null);
    QLog.d("NearbyUsingTimeReport", 4, "reportPageInTime: =" + this.jdField_b_of_type_Long + "-------date=" + str);
    new ODReportTask().b("nearby").e("now_jiehe").c("app_in").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).a("timestr", this.jdField_b_of_type_Long).a("qimei", VipComicReportUtils.a()).a("client_build", String.valueOf(DeviceUtils.a())).a("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount()).a("appid", 406).a("deviceid", PhoneUtil.a(BaseApplicationImpl.sApplication, QBaseActivity.sTopActivity)).a("imei", MobileInfoUtil.c()).a();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return;
    }
    long l = System.currentTimeMillis();
    QLog.d("NearbyUsingTimeReport", 4, "reportPageOutTime: mStartTime=" + this.jdField_b_of_type_Long + "---------stop: =" + l + "-----------time_long=" + (l - this.jdField_b_of_type_Long));
    new ODReportTask().b("nearby").e("now_jiehe").c("app_out").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).a("timestr", l).a("timelong", l - this.jdField_b_of_type_Long).a("qimei", VipComicReportUtils.a()).a("res1", this.jdField_b_of_type_Long).a("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount()).a("appid", 406).a("client_build", String.valueOf(DeviceUtils.a())).a("deviceid", PhoneUtil.a(BaseApplicationImpl.sApplication, QBaseActivity.sTopActivity)).a("imei", MobileInfoUtil.c()).a();
  }
  
  public UsingTimeReportManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return null;
    }
    return (UsingTimeReportManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(NearbyConstants.j);
  }
  
  public void a()
  {
    super.a();
    Foreground.addActivityLifeCallback(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return;
    }
    new ODReportTask().b("nearby").c("nearby_tab_staying").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).i(String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long)).f(String.valueOf(paramInt1)).g(String.valueOf(paramInt2)).a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("dc00899", this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.c, 0, 0, String.valueOf(paramLong), "", "", "");
    new ODReportTask().b("nearby").c("nearby_page_staying").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).i(String.valueOf(paramLong)).h(String.valueOf(MatchMakerPlugin.a())).a();
  }
  
  public void b()
  {
    super.b();
    Foreground.removeActivityLifeCallback(this);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onProcessBackground()
  {
    g();
  }
  
  public void onProcessForeground()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUsingTimeReport
 * JD-Core Version:    0.7.0.1
 */