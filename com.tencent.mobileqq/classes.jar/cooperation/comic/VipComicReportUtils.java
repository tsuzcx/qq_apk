package cooperation.comic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.utils.WebViewReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class VipComicReportUtils
{
  private static Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public static String a;
  private static ThreadLocal<char[]> jdField_a_of_type_JavaLangThreadLocal = new VipComicReportUtils.1();
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static AtomicInteger a;
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private static String b;
  public static AtomicInteger b;
  private static String c;
  private static String d;
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
    c = "";
    d = "";
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(d)) {}
    try
    {
      d = BaseApplicationImpl.getContext().getSharedPreferences("fileSystemInfo_", 4).getString("qimei_new", "");
      if (TextUtils.isEmpty(d)) {
        a();
      }
      return d;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("VipComicReportUtils", 1, "getQimei error", localThrowable);
      }
    }
  }
  
  @Deprecated
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {}
    try
    {
      jdField_b_of_type_JavaLangString = QQDeviceInfo.getIMEI("2240ca");
      if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        jdField_b_of_type_JavaLangString = a();
      }
      if (jdField_b_of_type_JavaLangString == null)
      {
        QLog.e("VipComicReportUtils", 1, "getImei finally encounter error and return empty");
        jdField_b_of_type_JavaLangString = "";
      }
      return jdField_b_of_type_JavaLangString;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e("VipComicReportUtils", 1, "telephonyManager.getDeviceId encounter error", paramContext);
      }
    }
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        jdField_a_of_type_JavaLangReflectField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if (jdField_a_of_type_JavaLangReflectField != null) {
        jdField_a_of_type_JavaLangReflectField.set(localStringBuilder, jdField_a_of_type_JavaLangThreadLocal.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  private static List<String> a(String paramString, List<String> paramList)
  {
    if ("3025".equals(paramString))
    {
      paramString = VipComicHelper.jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams.a();
      paramString.a("is_new", 22, "302598765432001");
    }
    for (;;)
    {
      return paramString.a(paramList);
      paramString = VipComicHelper.jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams;
    }
  }
  
  private static void a()
  {
    UserAction.getQimei(new VipComicReportUtils.3());
  }
  
  private static void a(Context paramContext)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      jdField_a_of_type_JavaLangString = paramContext.widthPixels + "*" + paramContext.heightPixels;
    }
  }
  
  public static void a(Intent paramIntent, WebViewDirector paramWebViewDirector)
  {
    if ((paramIntent == null) || (paramWebViewDirector == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "Invalid parameters in reportStartSpeed.");
      }
    }
    long l1;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("isFromJumpActivity", false));
      l1 = paramIntent.getLongExtra("reportLebaClick", 0L);
    } while (l1 == jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l1);
    int j = paramIntent.getIntExtra("reportSourceFrom", 0);
    int i = paramIntent.getIntExtra("reportProcessExistFlag", 0);
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
      i = 2;
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      long l2 = paramIntent.getLongExtra("reportJumpActivityOnCreate", 0L);
      long l3 = paramIntent.getLongExtra("reportDownloadTime", 0L);
      long l4 = paramIntent.getLongExtra("reportInstallTime", 0L);
      long l5 = paramIntent.getLongExtra("reportStartPluginTime", 0L);
      long l6 = paramIntent.getLongExtra("reportBrowserOnCreateStart", 0L);
      long l7 = paramIntent.getLongExtra("reportBrowserOnCreateEnd", 0L);
      if (QLog.isColorLevel())
      {
        paramIntent = "" + "totalTime:" + (l7 - l1);
        paramIntent = paramIntent + "&jumpActivityCreateTime:" + (l2 - l1);
        paramIntent = paramIntent + "&installTime:" + l4;
        paramIntent = paramIntent + "&downloadTime:" + l3;
        paramIntent = paramIntent + "&startPluginTime:" + (l5 - l2);
        paramIntent = paramIntent + "&startLaunchBrowser" + (l6 - l5);
        paramIntent = paramIntent + "&launchBrowser:" + (l7 - l6);
        paramIntent = paramIntent + "&processExistFlag:" + i;
        QLog.d("VipComicReportUtils", 2, paramIntent + "&sourceFrom:" + j);
      }
      WebViewReportUtils.a(l7 - l1, l2 - l1, l3, l4, l5 - l2, 0L, paramWebViewDirector.b, paramWebViewDirector.e, paramWebViewDirector.c, paramWebViewDirector.a, paramWebViewDirector.d, paramWebViewDirector.f, 2L, 0L, i, 0L, l6 - l5, l7 - l6 + "", Build.VERSION.RELEASE, j + "");
      return;
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        i = 1;
      } else if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
        i = 3;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, VipComicDC01327ReportData paramVipComicDC01327ReportData)
  {
    if (paramAppInterface == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause app == null");
      return;
    }
    Object localObject = paramAppInterface.getApp();
    if (localObject == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause context == null");
      return;
    }
    paramAppInterface = c();
    a((Context)localObject);
    localObject = paramVipComicDC01327ReportData.a();
    a(null, "dc01327", Arrays.asList(new String[] { "", "android", "201", Build.VERSION.RELEASE, "8.5.5", "", "android", paramAppInterface, jdField_a_of_type_JavaLangString, paramVipComicDC01327ReportData.p(), "", paramVipComicDC01327ReportData.a(), "", paramVipComicDC01327ReportData.b(), paramVipComicDC01327ReportData.c(), "", paramVipComicDC01327ReportData.e(), localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8], "", "", "", paramVipComicDC01327ReportData.j(), "", paramVipComicDC01327ReportData.n(), paramVipComicDC01327ReportData.d(), paramVipComicDC01327ReportData.f(), paramVipComicDC01327ReportData.g(), paramVipComicDC01327ReportData.k(), paramVipComicDC01327ReportData.h(), paramVipComicDC01327ReportData.l(), paramVipComicDC01327ReportData.i(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", localObject[0], localObject[9], paramVipComicDC01327ReportData.o(), "", "", paramVipComicDC01327ReportData.m(), paramVipComicDC01327ReportData.q() }));
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    String str = c();
    a(paramContext);
    paramContext = new String[10];
    paramContext[0] = "";
    paramContext[1] = "";
    paramContext[2] = "";
    paramContext[3] = "";
    paramContext[4] = "";
    paramContext[5] = "";
    paramContext[6] = "";
    paramContext[7] = "";
    paramContext[8] = "";
    paramContext[9] = "";
    int i = 0;
    while ((i < paramContext.length) && (i < paramVarArgs.length))
    {
      paramContext[i] = paramVarArgs[i];
      i += 1;
    }
    paramContext[5] = a();
    paramString1 = Arrays.asList(new String[] { "1", paramString1, a(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", VipComicHelper.e, "", "", paramString2, VipComicHelper.jdField_a_of_type_JavaLangString, paramString3, paramString4, paramString5, paramString6, "", "", "8.5.5", "", "", "", "", "", "android", str, jdField_a_of_type_JavaLangString, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8], "", VipComicHelper.f, "", "", "" });
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "dc00145", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    String str = c();
    a(paramContext);
    paramContext = new String[10];
    paramContext[0] = "";
    paramContext[1] = "";
    paramContext[2] = "";
    paramContext[3] = "";
    paramContext[4] = "";
    paramContext[5] = "";
    paramContext[6] = "";
    paramContext[7] = "";
    paramContext[8] = "";
    paramContext[9] = "";
    int i = 0;
    while ((i < paramContext.length) && (i < paramVarArgs.length))
    {
      paramContext[i] = paramVarArgs[i];
      i += 1;
    }
    paramContext[5] = a();
    paramString1 = Arrays.asList(new String[] { "1", paramString1, a(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", VipComicHelper.e, "", "", paramString2, VipComicHelper.jdField_a_of_type_JavaLangString, "", paramString3, paramString4, paramString5, "", "", "8.5.5", "", "", "", "", "", "android", str, jdField_a_of_type_JavaLangString, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8], "", VipComicHelper.f, "", "", "" });
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "dc00145", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String... paramVarArgs)
  {
    if ((paramAppInterface == null) || (paramAppInterface.getApp() == null) || (paramAppInterface.getCurrentAccountUin() == null)) {
      return;
    }
    String str = paramAppInterface.getCurrentAccountUin();
    Object localObject1 = paramAppInterface.getApp();
    Object localObject2 = c();
    a((Context)localObject1);
    localObject1 = new String[10];
    localObject1[0] = "";
    localObject1[1] = "";
    localObject1[2] = "";
    localObject1[3] = "";
    localObject1[4] = "";
    localObject1[5] = "";
    localObject1[6] = "";
    localObject1[7] = "";
    localObject1[8] = "";
    localObject1[9] = "";
    int i = 0;
    while ((i < localObject1.length) && (i < paramVarArgs.length))
    {
      localObject1[i] = paramVarArgs[i];
      i += 1;
    }
    localObject1[5] = a();
    if ((TextUtils.isEmpty(localObject1[7])) && (!TextUtils.isEmpty(VipComicHelper.j))) {
      localObject1[7] = VipComicHelper.j;
    }
    if (TextUtils.isEmpty(VipComicHelper.jdField_b_of_type_JavaLangString))
    {
      paramVarArgs = "";
      paramString5 = Arrays.asList(new String[] { "1", str, a(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", paramVarArgs, paramString9, "", "", paramString1, paramString5, "", paramString2, paramString3, paramString4, "", "", "8.5.5", "", "", paramString10, "", "", "android", localObject2, jdField_a_of_type_JavaLangString, "", localObject1[0], localObject1[1], localObject1[2], localObject1[3], localObject1[4], localObject1[5], localObject1[6], localObject1[7], localObject1[8], paramString7, paramString8, paramString6, "", "" });
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uin:").append(str).append(",").append("imei:").append(a()).append(",").append("domain:android,").append("domain_id:201,").append("biz_id:8001,").append("biz_subid:8001001,").append("obj_ownerid:").append(paramVarArgs).append(",").append("objPos:").append(paramString9).append(",").append("pageId:").append(paramString1).append(",").append("operObjType:").append(paramString2).append(",").append("operObjId:").append(paramString3).append(",").append("retId:").append(paramString4).append(",").append("sesId:").append(paramString10).append(",").append("ext1: ,").append("ext2:").append(localObject1[0]).append(",").append("ext3:").append(localObject1[1]).append(",").append("ext4:").append(localObject1[2]).append(",").append("ext5:").append(localObject1[3]).append(",").append("ext6:").append(localObject1[4]).append(",").append("ext7:").append(localObject1[5]).append(",").append("ext8:").append(localObject1[6]).append(",").append("ext9:").append(localObject1[7]).append(",").append("ext10:").append(localObject1[8]).append(",").append("land_page_id:").append(paramString7).append(",").append("detailpage_from:").append(paramString8).append(",").append("algo_id:").append(paramString6);
        QLog.d("VipComicReportUtils", 2, "dc DC00145_3 detail : " + ((StringBuilder)localObject2).toString());
      }
      paramString1 = a(paramString1, paramString5);
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label996;
      }
    }
    label996:
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "dc00145", paramString1);
      return;
      paramVarArgs = VipComicHelper.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    String[] arrayOfString = new String[10];
    System.arraycopy(paramVarArgs, 0, arrayOfString, 0, Math.min(10, paramVarArgs.length));
    int i = 0;
    int j = arrayOfString.length;
    while (i < j)
    {
      if (arrayOfString[i] == null) {
        arrayOfString[i] = "";
      }
      i += 1;
    }
    paramString1 = Arrays.asList(new String[] { "1", String.valueOf(System.currentTimeMillis() / 1000L), "ANDROID", Build.VERSION.RELEASE, paramString1, "8.5.5", paramString2, paramString3, paramString4, paramString5, paramString6, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4], arrayOfString[5], arrayOfString[6], arrayOfString[7], arrayOfString[8], arrayOfString[9] });
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "b_sng_qqvip_sqlite_profile_report|sqlite_profile_monitor_report", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    a(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp(), paramString1, paramString2, paramString3, paramString4, paramString5, paramVarArgs);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    a(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp(), paramString1, paramString2, paramString3, paramString4, paramVarArgs);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      localStringBuilder = a();
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i));
        if (i < j - 1) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
      paramList = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "dcId=" + paramString + ";detail=" + paramList);
      }
      DcReportUtil.a(paramQQAppInterface, paramString, paramList);
    }
    while (!QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      int j;
      int i;
      return;
    }
    QLog.d("VipComicReportUtils", 2, "params is null, dcId=" + paramString + ";detail=" + "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    a(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, paramString8, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10)
  {
    ThreadManager.executeOnNetWorkThread(new VipComicReportUtils.2(paramString1, paramString2, paramString3, paramString10, paramInt1, paramString4, paramString5, paramString6, paramInt2, paramString7, paramString9, paramString8));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, paramString8, 0, "", "");
  }
  
  public static String b(Context paramContext)
  {
    if (!StringUtil.a(c)) {
      return c;
    }
    if ((Build.VERSION.SDK_INT > 28) || ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))) {
      return a();
    }
    return c(paramContext);
  }
  
  private static String c()
  {
    int j = HttpUtil.getNetWorkType();
    int i;
    if (j >= 0)
    {
      i = j;
      if (j < AppConstants.NET_TYPE_NAME.length) {}
    }
    else
    {
      i = 0;
    }
    return AppConstants.NET_TYPE_NAME[i];
  }
  
  private static String c(Context paramContext)
  {
    try
    {
      QLog.d("VipComicReportUtils", 1, "get system imei from QQDeviceInfo");
      c = QQDeviceInfo.getIMEI("7aa880");
      return c;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        c = "";
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        c = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicReportUtils
 * JD-Core Version:    0.7.0.1
 */