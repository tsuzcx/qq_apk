package cooperation.comic;

import amjp;
import amjq;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.utils.WebViewReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class VipComicReportUtils
{
  public static TelephonyManager a;
  private static Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public static String a;
  private static ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new amjp();
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static AtomicInteger a;
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public static String b;
  public static AtomicInteger b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
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
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      if (jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
        jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      }
    }
    try
    {
      jdField_a_of_type_JavaLangString = jdField_a_of_type_AndroidTelephonyTelephonyManager.getDeviceId();
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = "";
      }
      int j = HttpUtil.a();
      if (j >= 0)
      {
        i = j;
        if (j < AppConstants.c.length) {}
      }
      else
      {
        i = 0;
      }
      String str = AppConstants.c[i];
      if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
      {
        paramContext = paramContext.getResources().getDisplayMetrics();
        jdField_b_of_type_JavaLangString = paramContext.widthPixels + "*" + paramContext.heightPixels;
      }
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
      paramString1 = Arrays.asList(new String[] { "1", paramString1, jdField_a_of_type_JavaLangString, "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", "", "", "", paramString2, "", "", paramString3, paramString4, paramString5, "", "", "7.6.3", "", "", "", "", "", "android", str, jdField_b_of_type_JavaLangString, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8] });
      if ((paramAppInterface instanceof QQAppInterface))
      {
        paramAppInterface = (QQAppInterface)paramAppInterface;
        a(paramAppInterface, "dc00145", paramString1);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        paramAppInterface = null;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String... paramVarArgs)
  {
    if (paramAppInterface == null) {}
    String str1;
    Object localObject;
    do
    {
      return;
      str1 = paramAppInterface.getCurrentAccountUin();
      localObject = paramAppInterface.getApp();
    } while ((str1 == null) || (localObject == null));
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      if (jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
        jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)((Context)localObject).getSystemService("phone");
      }
    }
    try
    {
      jdField_a_of_type_JavaLangString = jdField_a_of_type_AndroidTelephonyTelephonyManager.getDeviceId();
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = "";
      }
      int j = HttpUtil.a();
      if (j >= 0)
      {
        i = j;
        if (j < AppConstants.c.length) {}
      }
      else
      {
        i = 0;
      }
      String str2 = AppConstants.c[i];
      if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
      {
        localObject = ((Context)localObject).getResources().getDisplayMetrics();
        jdField_b_of_type_JavaLangString = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = new String[10];
      localObject[0] = "";
      localObject[1] = "";
      localObject[2] = "";
      localObject[3] = "";
      localObject[4] = "";
      localObject[5] = "";
      localObject[6] = "";
      localObject[7] = "";
      localObject[8] = "";
      localObject[9] = "";
      int i = 0;
      while ((i < localObject.length) && (i < paramVarArgs.length))
      {
        localObject[i] = paramVarArgs[i];
        i += 1;
      }
      if ((TextUtils.isEmpty(localObject[7])) && (!TextUtils.isEmpty(VipComicHelper.i))) {
        localObject[7] = VipComicHelper.i;
      }
      if (TextUtils.isEmpty(VipComicHelper.jdField_b_of_type_JavaLangString))
      {
        paramVarArgs = "";
        paramString2 = Arrays.asList(new String[] { "1", str1, jdField_a_of_type_JavaLangString, "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", paramVarArgs, paramString9, "", "", paramString1, paramString5, "", paramString2, paramString3, paramString4, "", "", "7.6.3", "", "", paramString10, "", "", "android", str2, jdField_b_of_type_JavaLangString, "", localObject[0], localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8], paramString7, paramString8, paramString6, "", "" });
        if (!"3025".equals(paramString1)) {
          break label690;
        }
        paramString1 = VipComicHelper.a.a();
        paramString1.a("is_new", 22, "302598765432001");
      }
      for (;;)
      {
        paramString1 = paramString1.a(paramString2);
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break label702;
        }
        paramAppInterface = (QQAppInterface)paramAppInterface;
        a(paramAppInterface, "dc00145", paramString1);
        return;
        paramVarArgs = VipComicHelper.jdField_b_of_type_JavaLangString;
        break;
        label690:
        paramString1 = VipComicHelper.a;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        label702:
        paramAppInterface = null;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    a(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp(), paramString1, paramString2, paramString3, paramString4, paramVarArgs);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List paramList)
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
        QLog.i("VipComicReportUtils", 2, "dcId=" + paramString + ";detail=" + paramList);
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
    QLog.i("VipComicReportUtils", 2, "params is null, dcId=" + paramString + ";detail=" + "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ThreadManager.executeOnNetWorkThread(new amjq(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, paramString6, paramString7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.VipComicReportUtils
 * JD-Core Version:    0.7.0.1
 */