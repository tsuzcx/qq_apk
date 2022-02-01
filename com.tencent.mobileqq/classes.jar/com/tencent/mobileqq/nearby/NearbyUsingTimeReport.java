package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.tools.PhoneUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.BaseUsingTimeReport;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;

public class NearbyUsingTimeReport
  extends BaseUsingTimeReport
  implements QActivityLifecycleCallbacks
{
  protected long a = System.currentTimeMillis();
  private INearbyAppInterface e;
  private long f;
  
  public NearbyUsingTimeReport(INearbyAppInterface paramINearbyAppInterface, String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.e = paramINearbyAppInterface;
  }
  
  private String a(long paramLong, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "yyyy-MM-dd HH:mm:ss";
    }
    return new SimpleDateFormat(str).format(new Long(paramLong));
  }
  
  private void g()
  {
    this.f = System.currentTimeMillis();
    String str = a(this.f, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportPageInTime: =");
    localStringBuilder.append(this.f);
    localStringBuilder.append("-------date=");
    localStringBuilder.append(str);
    QLog.d("NearbyUsingTimeReport", 4, localStringBuilder.toString());
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby").setOperName("now_jiehe").setAction("app_in").setUin(this.e.getCurrentAccountUin()).addKeyValue("timestr", this.f).addKeyValue("qimei", ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).getQimei()).addKeyValue("client_build", String.valueOf(DeviceUtils.a())).addKeyValue("uin", this.e.getAccount()).addKeyValue("appid", 406).addKeyValue("deviceid", PhoneUtil.a(BaseApplicationImpl.sApplication, QBaseActivity.sTopActivity)).addKeyValue("imei", MobileInfoUtil.getImei()).report();
  }
  
  private void h()
  {
    if (this.e == null) {
      return;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportPageOutTime: mStartTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("---------stop: =");
    localStringBuilder.append(l);
    localStringBuilder.append("-----------time_long=");
    localStringBuilder.append(l - this.f);
    QLog.d("NearbyUsingTimeReport", 4, localStringBuilder.toString());
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby").setOperName("now_jiehe").setAction("app_out").setUin(this.e.getCurrentAccountUin()).addKeyValue("timestr", l).addKeyValue("timelong", l - this.f).addKeyValue("qimei", ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).getQimei()).addKeyValue("res1", this.f).addKeyValue("uin", this.e.getAccount()).addKeyValue("appid", 406).addKeyValue("client_build", String.valueOf(DeviceUtils.a())).addKeyValue("deviceid", PhoneUtil.a(BaseApplicationImpl.sApplication, QBaseActivity.sTopActivity)).addKeyValue("imei", MobileInfoUtil.getImei()).report();
  }
  
  public UsingTimeReportManager a()
  {
    INearbyAppInterface localINearbyAppInterface = this.e;
    if (localINearbyAppInterface == null) {
      return null;
    }
    return (UsingTimeReportManager)localINearbyAppInterface.getManager(NearbyConstants.l);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.e == null) {
      return;
    }
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby").setAction("nearby_tab_staying").setUin(this.e.getCurrentAccountUin()).setRes1(String.valueOf(System.currentTimeMillis() - this.a)).setExtCol1(String.valueOf(paramInt1)).setExtCol2(String.valueOf(paramInt2)).report();
    this.a = System.currentTimeMillis();
  }
  
  public void a(long paramLong)
  {
    INearbyAppInterface localINearbyAppInterface = this.e;
    if (localINearbyAppInterface == null) {
      return;
    }
    localINearbyAppInterface.nearbyReportClickEvent("dc00899", this.b, "", this.c, this.d, 0, 0, String.valueOf(paramLong), "", "", "");
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby").setAction("nearby_page_staying").setUin(this.e.getCurrentAccountUin()).setRes1(String.valueOf(paramLong)).setExtCol3(String.valueOf(MatchMakerPlugin.b())).report();
  }
  
  public void b()
  {
    super.b();
    Foreground.addActivityLifeCallback(this);
  }
  
  public void c()
  {
    super.c();
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
    h();
  }
  
  public void onProcessForeground()
  {
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUsingTimeReport
 * JD-Core Version:    0.7.0.1
 */