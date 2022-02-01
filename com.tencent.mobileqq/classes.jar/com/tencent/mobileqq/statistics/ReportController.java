package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.bridge.report.service.IReportService;
import com.tencent.mobileqq.bridge.report.service.ITouchEventService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class ReportController
{
  public static final HashMap<String, ReportController.BusinessDataReporter> a = new HashMap();
  
  static
  {
    Object localObject = ReportControllerServiceHolder.a();
    if ((localObject != null) && (((IReportDataProviderService)localObject).a() != null))
    {
      localObject = (ReportController.BusinessDataReporter)((IReportDataProviderService)localObject).a();
      a.put("dc01160", localObject);
    }
  }
  
  private static String a()
  {
    int i = DeviceInfoUtil.b();
    long l = DeviceInfoUtil.a() / 1024L / 1024L;
    long[] arrayOfLong = DeviceInfoUtil.a();
    String str2 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkOperator();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = String.format("%.2f", new Object[] { Double.valueOf(DeviceInfoUtil.a()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i).append(";").append(l).append(";").append(arrayOfLong[0]).append(";").append(arrayOfLong[1]).append(";").append(str1.replaceAll(";", "")).append(";").append(str2).append(";").append(DeviceInfoUtil.i()).append(";").append(DeviceInfoUtil.j()).append(";");
    str1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "getExtraDeviceInfo=" + str1);
    }
    return str1;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localStringBuilder.append(paramString2).append('|');
    }
    if (paramString1.equals("dc01440")) {
      localStringBuilder.append("0").append('|');
    }
    localStringBuilder.append(paramString3).append('|');
    localStringBuilder.append(paramString4).append('|');
    localStringBuilder.append(paramString5).append('|');
    localStringBuilder.append(paramString6).append('|');
    localStringBuilder.append(paramInt1).append('|');
    localStringBuilder.append("${count_unknown}").append('|');
    localStringBuilder.append(paramInt3).append('|');
    localStringBuilder.append(paramString7).append('|');
    localStringBuilder.append(paramString8).append('|');
    localStringBuilder.append(paramString9).append('|');
    localStringBuilder.append(paramString10).append('|');
    return localStringBuilder.toString();
  }
  
  private static String a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    String str = "";
    if (paramBoolean) {
      str = NetConnInfoCenter.getSystemNetStateString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime()).append("|").append(AppSetting.a()).append("|").append("android").append("|").append(paramString1).append("|").append(paramString2).append("|").append(paramString3).append("|").append(paramString4).append("|").append(paramString5).append("|").append(paramInt).append("|").append(paramString6).append("|").append(DeviceInfoUtil.a()).append("|").append("|").append(DeviceInfoUtil.h()).append("|").append(DeviceInfoUtil.i()).append("|").append(str).append("|").append(DeviceInfoUtil.e()).append("|").append(ROMUtil.getRomDetailInfo()).append("|").append(paramString7).append("|").append(paramString8).append("|").append(paramString9).append("|").append(paramString10).append("|").append(paramString11).append("|").append(paramString12).append("|").append(paramString13).append("|").append(paramString14).append("|");
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "getDC04272ReportDetail=" + paramString1);
    }
    return paramString1;
  }
  
  public static void a(MotionEvent paramMotionEvent)
  {
    ITouchEventService localITouchEventService = ReportControllerServiceHolder.a();
    if (localITouchEventService != null) {
      localITouchEventService.a(paramMotionEvent);
    }
  }
  
  public static void a(PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime.setClickEventReportor(new ReportController.1());
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "stopReportLooper");
    }
    IReportDataProviderService localIReportDataProviderService = ReportControllerServiceHolder.a();
    ReportController localReportController = null;
    if (localIReportDataProviderService != null) {
      localReportController = (ReportController)localIReportDataProviderService.a(paramAppRuntime);
    }
    if (localReportController != null) {
      localReportController.b();
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    b(paramAppRuntime, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = paramString2;
    if (paramString2.contains("${uin_unknown}"))
    {
      String str = paramAppRuntime.getAccount();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = paramString2.replace("${uin_unknown}", (CharSequence)localObject);
    }
    paramString2 = ((String)localObject).replace("${count_unknown}", Integer.toString(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "ReportRuntime: " + paramString1 + ", " + paramString2);
    }
    for (;;)
    {
      localObject = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString1);
      ((NewIntent)localObject).putExtra("content", paramString2);
      ((NewIntent)localObject).setWithouLogin(true);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return;
      if (!paramAppRuntime.isLogin()) {
        QLog.d("ReportController", 1, "ReportRuntime: " + paramString1 + ", " + paramString2);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, "", "", "", "", "", "", "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    b(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, a(), paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    IReportService localIReportService = ReportControllerServiceHolder.a();
    AppRuntime localAppRuntime = paramAppRuntime;
    if (localIReportService != null) {
      localAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (localAppRuntime == null)
    {
      paramAppRuntime = a(true, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramAppRuntime);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 1);
      BaseApplication.getContext().sendBroadcast(paramString1);
      return;
    }
    a(localAppRuntime, "dc04272", a(true, localAppRuntime.getAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    IReportService localIReportService = ReportControllerServiceHolder.a();
    AppRuntime localAppRuntime = paramAppRuntime;
    if (localIReportService != null) {
      localAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (localAppRuntime == null)
    {
      paramAppRuntime = a(paramString1, paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt3, paramInt2, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramAppRuntime);
      paramString2.putExtra("reporting_count", paramInt3);
      paramString2.putExtra("is_runtime", 1);
      BaseApplication.getContext().sendBroadcast(paramString2);
      if (localIReportService != null) {
        localIReportService.a(paramString1, paramString4, paramAppRuntime);
      }
      return;
    }
    Object localObject = new ArrayList();
    paramAppRuntime = new ArrayList();
    IReportDataProviderService localIReportDataProviderService = ReportControllerServiceHolder.a();
    if (localIReportDataProviderService != null)
    {
      localObject = localIReportDataProviderService.a();
      paramAppRuntime = localIReportDataProviderService.b();
    }
    if ((((List)localObject).contains(paramString4)) || (paramAppRuntime.contains(paramString4))) {
      paramAppRuntime = "";
    }
    for (;;)
    {
      paramAppRuntime = a(paramString1, paramString2, paramString3, paramAppRuntime, paramString4, paramString5, paramInt1, paramInt3, paramInt2, paramString6, paramString7, paramString8, paramString9);
      a(localAppRuntime, paramString1, paramAppRuntime, paramInt3);
      if (localIReportService == null) {
        break;
      }
      localIReportService.a(paramString1, paramString4, paramAppRuntime);
      return;
      localObject = localAppRuntime.getAccount();
      paramAppRuntime = paramString3;
      paramString3 = (String)localObject;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, 1, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    IReportService localIReportService = ReportControllerServiceHolder.a();
    AppRuntime localAppRuntime = paramAppRuntime;
    if (localIReportService != null) {
      localAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (localAppRuntime == null)
    {
      paramAppRuntime = a(paramBoolean, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramAppRuntime);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 1);
      BaseApplication.getContext().sendBroadcast(paramString1);
      return;
    }
    a(localAppRuntime, "dc04272", a(paramBoolean, localAppRuntime.getAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if (("P_CliOper".equals(paramString)) || ("CliOper".equals(paramString)) || ("on_off".equals(paramString)) || ("CliStatus".equals(paramString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "startReportLooper");
    }
    IReportDataProviderService localIReportDataProviderService = ReportControllerServiceHolder.a();
    if (localIReportDataProviderService != null) {}
    for (paramAppRuntime = (ReportController)localIReportDataProviderService.a(paramAppRuntime);; paramAppRuntime = null)
    {
      if (paramAppRuntime != null) {
        if (paramBoolean) {
          break label51;
        }
      }
      label51:
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramAppRuntime.a(paramBoolean);
        return true;
      }
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      Object localObject = ReportControllerServiceHolder.a();
      ReportController localReportController = null;
      if (localObject != null) {
        localReportController = (ReportController)((IReportDataProviderService)localObject).a(paramAppRuntime);
      }
      if (localReportController != null)
      {
        localObject = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          localObject = paramString2.replace("${uin_unknown}", paramAppRuntime.getAccount());
        }
        localReportController.a(paramString1, (String)localObject, paramInt);
      }
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, a(), "", "", "", "", "", "", "");
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    IReportService localIReportService = ReportControllerServiceHolder.a();
    AppRuntime localAppRuntime = paramAppRuntime;
    if (localIReportService != null) {
      localAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (localAppRuntime == null)
    {
      paramAppRuntime = a(true, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramAppRuntime);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 0);
      BaseApplication.getContext().sendBroadcast(paramString1);
      return;
    }
    b(localAppRuntime, "dc04272", a(true, localAppRuntime.getAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    IReportService localIReportService = ReportControllerServiceHolder.a();
    AppRuntime localAppRuntime = paramAppRuntime;
    if (localIReportService != null) {
      localAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (localAppRuntime == null)
    {
      paramAppRuntime = a(paramString1, paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramAppRuntime);
      paramString2.putExtra("reporting_count", paramInt2);
      paramString2.putExtra("is_runtime", 0);
      BaseApplication.getContext().sendBroadcast(paramString2);
      if (localIReportService != null) {
        localIReportService.a(paramString1, paramString4, paramAppRuntime);
      }
    }
    do
    {
      return;
      paramAppRuntime = a(paramString1, paramString2, localAppRuntime.getAccount(), paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      b(localAppRuntime, paramString1, paramAppRuntime, paramInt2);
    } while (localIReportService == null);
    localIReportService.a(paramString1, paramString4, paramAppRuntime);
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, 1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  protected ReportController.BusinessDataReporter a(String paramString)
  {
    if (a.containsKey(paramString)) {
      return (ReportController.BusinessDataReporter)a.get(paramString);
    }
    return null;
  }
  
  protected void a()
  {
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ReportController.BusinessDataReporter)a.get(localObject);
      if (localObject != null) {
        ((ReportController.BusinessDataReporter)localObject).a();
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void b() {}
  
  protected boolean b(String paramString)
  {
    IReportDataProviderService localIReportDataProviderService = ReportControllerServiceHolder.a();
    return (localIReportDataProviderService != null) && (localIReportDataProviderService.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportController
 * JD-Core Version:    0.7.0.1
 */