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
    if ((localObject != null) && (((IReportDataProviderService)localObject).c() != null))
    {
      localObject = (ReportController.BusinessDataReporter)((IReportDataProviderService)localObject).c();
      a.put("dc01160", localObject);
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    a(paramString1, paramString2, paramString5, paramString6);
    a(paramString1, paramInt2, paramString7, paramString8);
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
    }
    if (paramString1.equals("dc01440"))
    {
      localStringBuilder.append("0");
      localStringBuilder.append('|');
    }
    localStringBuilder.append(paramString3);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString4);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString5);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString6);
    localStringBuilder.append('|');
    localStringBuilder.append(paramInt1);
    localStringBuilder.append('|');
    localStringBuilder.append("${count_unknown}");
    localStringBuilder.append('|');
    localStringBuilder.append(paramInt3);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString7);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString8);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString9);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString10);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
  
  private static String a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    String str;
    if (paramBoolean) {
      str = NetConnInfoCenter.getSystemNetStateString();
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime());
    localStringBuilder.append("|");
    localStringBuilder.append(AppSetting.d());
    localStringBuilder.append("|");
    localStringBuilder.append("android");
    localStringBuilder.append("|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString6);
    localStringBuilder.append("|");
    localStringBuilder.append(DeviceInfoUtil.b());
    localStringBuilder.append("|");
    localStringBuilder.append("|");
    localStringBuilder.append(DeviceInfoUtil.t());
    localStringBuilder.append("|");
    localStringBuilder.append(DeviceInfoUtil.u());
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    localStringBuilder.append(DeviceInfoUtil.g());
    localStringBuilder.append("|");
    localStringBuilder.append(ROMUtil.getRomDetailInfo());
    localStringBuilder.append("|");
    localStringBuilder.append(paramString7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString8);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString9);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString10);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString11);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString12);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString13);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString14);
    localStringBuilder.append("|");
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getDC04272ReportDetail=");
      paramString2.append(paramString1);
      QLog.d("ReportController", 2, paramString2.toString());
    }
    return paramString1;
  }
  
  public static void a(MotionEvent paramMotionEvent)
  {
    ITouchEventService localITouchEventService = ReportControllerServiceHolder.b();
    if (localITouchEventService != null) {
      localITouchEventService.a(paramMotionEvent);
    }
  }
  
  public static void a(PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime.setClickEventReportor(new ReportController.1());
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReportRuntime: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ReportController", 2, ((StringBuilder)localObject).toString());
    }
    else if (!paramAppRuntime.isLogin())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReportRuntime: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ReportController", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", paramString1);
    ((NewIntent)localObject).putExtra("content", paramString2);
    ((NewIntent)localObject).setWithouLogin(true);
    paramAppRuntime.startServlet((NewIntent)localObject);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, "", "", "", "", "", "", "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    b(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, c(), paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    IReportService localIReportService = ReportControllerServiceHolder.c();
    if (localIReportService != null) {
      paramAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (paramAppRuntime == null)
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
    a(paramAppRuntime, "dc04272", a(true, paramAppRuntime.getAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    IReportService localIReportService = ReportControllerServiceHolder.c();
    if (localIReportService != null) {
      paramAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (paramAppRuntime == null)
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
    }
    else
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      IReportDataProviderService localIReportDataProviderService = ReportControllerServiceHolder.a();
      if (localIReportDataProviderService != null)
      {
        localObject1 = localIReportDataProviderService.a();
        localObject2 = localIReportDataProviderService.b();
      }
      if ((!((List)localObject1).contains(paramString4)) && (!((List)localObject2).contains(paramString4)))
      {
        localObject1 = paramAppRuntime.getAccount();
        localObject2 = paramString3;
      }
      else
      {
        localObject2 = "";
        localObject1 = paramString3;
      }
      paramString2 = a(paramString1, paramString2, (String)localObject1, (String)localObject2, paramString4, paramString5, paramInt1, paramInt3, paramInt2, paramString6, paramString7, paramString8, paramString9);
      a(paramAppRuntime, paramString1, paramString2, paramInt3);
      if (localIReportService != null) {
        localIReportService.a(paramString1, paramString4, paramString2);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, 1, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    IReportService localIReportService = ReportControllerServiceHolder.c();
    if (localIReportService != null) {
      paramAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (paramAppRuntime == null)
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
    a(paramAppRuntime, "dc04272", a(paramBoolean, paramAppRuntime.getAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static boolean a(String paramString)
  {
    return ("P_CliOper".equals(paramString)) || ("CliOper".equals(paramString)) || ("on_off".equals(paramString)) || ("CliStatus".equals(paramString));
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "startReportLooper");
    }
    IReportDataProviderService localIReportDataProviderService = ReportControllerServiceHolder.a();
    ReportController localReportController = null;
    if (localIReportDataProviderService != null) {
      localReportController = (ReportController)localIReportDataProviderService.a(paramAppRuntime);
    }
    if (localReportController != null) {
      localReportController.a(paramBoolean ^ true);
    }
    return true;
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
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, c(), "", "", "", "", "", "", "");
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    IReportService localIReportService = ReportControllerServiceHolder.c();
    if (localIReportService != null) {
      paramAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (paramAppRuntime == null)
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
    b(paramAppRuntime, "dc04272", a(true, paramAppRuntime.getAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    IReportService localIReportService = ReportControllerServiceHolder.c();
    if (localIReportService != null) {
      paramAppRuntime = localIReportService.a(paramAppRuntime);
    }
    if (paramAppRuntime == null)
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
    else
    {
      paramString2 = a(paramString1, paramString2, paramAppRuntime.getAccount(), paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      b(paramAppRuntime, paramString1, paramString2, paramInt2);
      if (localIReportService != null) {
        localIReportService.a(paramString1, paramString4, paramString2);
      }
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, 1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  private static String c()
  {
    int i = DeviceInfoUtil.h();
    long l = DeviceInfoUtil.a() / 1024L / 1024L;
    long[] arrayOfLong = DeviceInfoUtil.p();
    Object localObject2 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkOperator();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = String.format("%.2f", new Object[] { Double.valueOf(DeviceInfoUtil.T()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(";");
    localStringBuilder.append(l);
    localStringBuilder.append(";");
    localStringBuilder.append(arrayOfLong[0]);
    localStringBuilder.append(";");
    localStringBuilder.append(arrayOfLong[1]);
    localStringBuilder.append(";");
    localStringBuilder.append(((String)localObject1).replaceAll(";", ""));
    localStringBuilder.append(";");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(";");
    localStringBuilder.append(DeviceInfoUtil.D());
    localStringBuilder.append(";");
    localStringBuilder.append(DeviceInfoUtil.E());
    localStringBuilder.append(";");
    localObject1 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getExtraDeviceInfo=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReportController", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
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
  
  protected ReportController.BusinessDataReporter c(String paramString)
  {
    if (a.containsKey(paramString)) {
      return (ReportController.BusinessDataReporter)a.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportController
 * JD-Core Version:    0.7.0.1
 */