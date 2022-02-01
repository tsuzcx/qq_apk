package com.tencent.mobileqq.qbosssplash.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qbosssplash.model.SplashItem;
import com.tencent.mobileqq.qbosssplash.model.SplashItem.Builder;
import com.tencent.mobileqq.servlet.QbossReportServlet;
import com.tencent.mobileqq.vfs.VFSSourcePathConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.s2c.msgtype0x210.submsgtype0x113.SubMsgType0x113.MsgBody;

public class QbossSplashUtil
{
  public static SplashItem a;
  public static final String a;
  public static HashMap<String, SplashItem> a;
  public static boolean a;
  public static final String b;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSSourcePathConfig.jdField_b_of_type_JavaLangString;
    jdField_b_of_type_JavaLangString = AppConstants.SDCARD_PATH + "qbdownres";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.parseInt(paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "StringToInt exception" + paramString.toString());
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.parseLong(paramString);
      }
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "StringToLong exception" + paramString.toString());
    }
    return 0L;
  }
  
  public static SharedPreferences a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("qboss_banner_refresh_sp_" + str, 0);
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qboss_splash_ad_pref_" + paramString, 0);
  }
  
  public static String a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    int j = 0;
    int k = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        Object localObject2 = ((SharedPreferences)localObject1).getString(paramString2 + paramLong, "");
        StringBuffer localStringBuffer = new StringBuffer();
        String str = "";
        localObject1 = str;
        int i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = str;
          i = j;
          if (!TextUtils.isEmpty(paramString1))
          {
            localObject2 = ((String)localObject2).split(",");
            j = 0;
            i = k;
            localObject1 = str;
            if (j + 2 < localObject2.length)
            {
              str = localObject2[j];
              if ((i == 0) && (paramString1.equals(str)))
              {
                i = 1;
                localObject1 = str;
                break label395;
              }
              localStringBuffer.append(localObject2[j]).append(",").append(localObject2[(j + 1)]).append(",").append(localObject2[(j + 2)]).append(",");
              break label395;
            }
            str = "";
            if (localStringBuffer.length() != 0) {
              str = localStringBuffer.substring(0, localStringBuffer.length() - 1);
            }
            QLog.i("QSplash@QbossSplashUtil", 1, "removeHasShowAdIDs result=" + str + "removeid = " + paramString1 + paramString2);
            localEditor.putString(paramString2 + paramLong, str);
            localEditor.apply();
          }
        }
        paramString2 = "";
        paramString1 = paramString2;
        if (paramBoolean)
        {
          paramString1 = paramString2;
          if (i != 0) {
            paramString1 = a(BaseApplicationImpl.getContext(), paramLong + "").getString("qboss_splash_info_report_" + (String)localObject1, "");
          }
        }
        return paramString1;
      }
      catch (Exception paramString1)
      {
        QLog.i("QSplash@QbossSplashUtil", 1, "removeHasShowAdIDs exception");
        return null;
      }
      label395:
      j += 3;
    }
  }
  
  public static String a(Set<String> paramSet)
  {
    String str = "";
    Object localObject = str;
    if (paramSet != null)
    {
      localObject = str;
      if (paramSet.size() > 0)
      {
        localObject = new StringBuffer();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
          ((StringBuffer)localObject).append((String)paramSet.next()).append(",");
        }
        localObject = ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1);
      }
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "getLocalAdIds  adids =" + (String)localObject);
    return localObject;
  }
  
  public static HashMap<String, SplashItem> a(String paramString, SharedPreferences paramSharedPreferences, Set<String> paramSet)
  {
    if (paramSharedPreferences == null) {
      return jdField_a_of_type_JavaUtilHashMap;
    }
    try
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str1 = (String)paramSet.next();
        String str2 = paramSharedPreferences.getString("qboss_splash_ad_begin_time_" + str1, "");
        String str3 = paramSharedPreferences.getString("qboss_splash_ad_end_time_" + str1, "");
        int i = paramSharedPreferences.getInt("qbosss_plash_ad_content_type_" + str1, -1);
        String str4 = paramSharedPreferences.getString("qbosss_splash_ad_download_url_" + str1, "");
        int j = paramSharedPreferences.getInt("qbosss_splash_ad_jumptype_" + str1, -1);
        String str5 = paramSharedPreferences.getString("qbosss_splash_ad_jump_h5_url_" + str1, "");
        int k = paramSharedPreferences.getInt("qboss_splash_ad_exposure_platform_" + str1, 0);
        String str6 = paramSharedPreferences.getString("qboss_exposure_url_" + str1, "");
        boolean bool1 = paramSharedPreferences.getBoolean("qboss_exposure_is_low_device_limit_" + str1, false);
        boolean bool2 = paramSharedPreferences.getBoolean("qboss_splash_ad_is_limited_" + str1, false);
        int m = paramSharedPreferences.getInt("qboss_splash_ad_showpriority_" + str1, 0);
        String str7 = paramSharedPreferences.getString("qboss_splash_info_report_" + str1, "");
        String str8 = paramSharedPreferences.getString("qboss_splash_resource_md5_" + str1, "");
        String str9 = paramSharedPreferences.getString("qboss_splash_union_banner_type_" + str1, "-1");
        int n = paramSharedPreferences.getInt("qboss_splash_should_show_ad_mark_" + str1, 0);
        SplashItem.Builder localBuilder = new SplashItem.Builder();
        localBuilder.h(paramString).b(str1).c(str2).d(str3).c(i).e(str4).e(k).g(str6).f(str5).d(j).b(bool1).a(bool2).b(m).i(str7).j(str8).a(n).a(str9);
        QLog.i("QSplash@QbossSplashUtil", 1, "buildADEntryFromSP  adid =" + str1);
        jdField_a_of_type_JavaUtilHashMap.put(str1, localBuilder.a());
      }
      return jdField_a_of_type_JavaUtilHashMap;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "buildADEntryFromSP exception" + paramString.toString());
    }
  }
  
  public static List<String> a(Context paramContext, long paramLong)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext);
    try
    {
      paramContext = ((SharedPreferences)localObject).getString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong, "");
      localObject = ((SharedPreferences)localObject).getString("tianshu_splash_ad_ids_with_showdate_with_priority_" + paramLong, "");
      localObject = paramContext + (String)localObject;
      QLog.i("QSplash@QbossSplashUtil", 1, "idsWithTime = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = new ArrayList();
      }
      String[] arrayOfString;
      int i;
      label225:
      Context localContext;
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        arrayOfString = ((String)localObject).split(",");
        i = 0;
        for (;;)
        {
          localObject = paramContext;
          if (i + 2 >= arrayOfString.length) {
            break;
          }
          localObject = arrayOfString[i];
          if (a(arrayOfString[(i + 1)], arrayOfString[(i + 2)]))
          {
            paramContext.add(localObject);
            QLog.i("QSplash@QbossSplashUtil", 1, "permittedAdIDs = " + (String)localObject);
          }
          i += 3;
        }
        localException1 = localException1;
        paramContext = null;
      }
      catch (Exception localException2)
      {
        break label225;
      }
      QLog.e("QSplash@QbossSplashUtil", 1, "getPermittedAdIDs exception" + localException1.toString());
      localContext = paramContext;
      return localContext;
    }
  }
  
  public static Set<String> a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString).getString("splash_ad_ids", "");
    paramString = new HashSet();
    if (!TextUtils.isEmpty(paramContext)) {
      paramString.addAll(Arrays.asList(paramContext.split(",")));
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "getLocalAdIds frosm sp  adids =" + paramString);
    return paramString;
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("qboss_banner_refresh_sp_" + paramLong, 0).edit();
      paramContext.putLong("qbossNextRequestTime_2742", 0L);
      paramContext.apply();
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanRefreshSp ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanRefreshSp exception" + paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      localEditor.remove("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong);
      localEditor.remove("qboss_splash_ad_ids_with_showdate_with_priority_0");
      localEditor.apply();
      if (paramBoolean) {
        a(paramContext, paramLong);
      }
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanAllConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanAllConfig exception" + paramContext.toString());
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanOldSplashResDir sub" + paramString);
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanOldSplashResDir exception" + paramString.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      QLog.i("QSplash@QbossSplashUtil", 4, " sendQbossSplashReportExpose sqbosstrace:" + paramString1);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), QbossReportServlet.class);
      try
      {
        localNewIntent.putExtra("uin", Long.parseLong(localAppRuntime.getAccount()));
        localNewIntent.putExtra("qua", QUA.getQUA3());
        localNewIntent.putExtra("sQBosstrace", paramString1);
        localNewIntent.putExtra("iOperType", paramInt);
        localNewIntent.putExtra("sUserID", paramString2);
        localAppRuntime.startServlet(localNewIntent);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "sendQbossSplashReportExpose exception" + paramString1.toString());
    }
  }
  
  public static void a(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      Object localObject = new SubMsgType0x113.MsgBody();
      ((SubMsgType0x113.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      int i = ((SubMsgType0x113.MsgBody)localObject).int32_app_id.get();
      int j = ((SubMsgType0x113.MsgBody)localObject).int32_task_id.get();
      int k = ((SubMsgType0x113.MsgBody)localObject).enum_task_op.get();
      if (i == 2742)
      {
        if (k == 1)
        {
          localObject = a(j + "", paramLong, true, "qboss_splash_ad_ids_with_showdate_with_priority_");
          paramArrayOfByte = (byte[])localObject;
          if (localObject == null) {
            paramArrayOfByte = "";
          }
          a(paramArrayOfByte, null, 10);
          QLog.i("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 removeid " + j + paramArrayOfByte);
        }
      }
      else if ((i == 2783) && (k == 1))
      {
        b(String.valueOf(paramLong));
        QLog.i("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 cleanConfigAndResDir");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 exception" + paramArrayOfByte.toString());
    }
  }
  
  /* Error */
  public static boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: invokestatic 119	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: lload_0
    //   10: invokestatic 487	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Landroid/content/Context;J)Ljava/util/List;
    //   13: astore 7
    //   15: iload 4
    //   17: istore_3
    //   18: aload 7
    //   20: ifnull +348 -> 368
    //   23: aload 7
    //   25: invokeinterface 488 1 0
    //   30: istore_2
    //   31: iload 4
    //   33: istore_3
    //   34: iload_2
    //   35: ifle +333 -> 368
    //   38: ldc 67
    //   40: iconst_1
    //   41: new 21	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 490
    //   51: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: lload_0
    //   55: ldc2_w 491
    //   58: lrem
    //   59: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: invokestatic 119	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   71: new 21	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   78: lload_0
    //   79: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc 97
    //   84: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 182	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   93: astore 9
    //   95: invokestatic 119	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   98: new 21	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   105: lload_0
    //   106: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: ldc 97
    //   111: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 495	cooperation/vip/ad/TianshuSplashUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   120: astore 6
    //   122: invokestatic 119	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   125: new 21	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   132: lload_0
    //   133: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   136: ldc 97
    //   138: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 497	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;
    //   147: astore 10
    //   149: invokestatic 119	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   152: new 21	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   159: lload_0
    //   160: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   163: ldc 97
    //   165: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 498	cooperation/vip/ad/TianshuSplashUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;
    //   174: astore 8
    //   176: new 21	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   183: lload_0
    //   184: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: ldc 97
    //   189: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload 9
    //   197: aload 10
    //   199: invokestatic 500	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Ljava/lang/String;Landroid/content/SharedPreferences;Ljava/util/Set;)Ljava/util/HashMap;
    //   202: astore 9
    //   204: aload 9
    //   206: new 21	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   213: lload_0
    //   214: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   217: ldc 97
    //   219: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: aload 6
    //   227: aload 8
    //   229: invokestatic 500	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Ljava/lang/String;Landroid/content/SharedPreferences;Ljava/util/Set;)Ljava/util/HashMap;
    //   232: invokevirtual 504	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   235: aconst_null
    //   236: astore 6
    //   238: aload 7
    //   240: invokeinterface 505 1 0
    //   245: astore 10
    //   247: aload 10
    //   249: invokeinterface 202 1 0
    //   254: ifeq +107 -> 361
    //   257: aload 10
    //   259: invokeinterface 206 1 0
    //   264: checkcast 145	java/lang/String
    //   267: astore 7
    //   269: aload 9
    //   271: aload 7
    //   273: invokevirtual 508	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   276: ifeq +145 -> 421
    //   279: aload 9
    //   281: aload 7
    //   283: invokevirtual 511	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: checkcast 513	com/tencent/mobileqq/qbosssplash/model/SplashItem
    //   289: astore 8
    //   291: ldc 67
    //   293: iconst_1
    //   294: new 21	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 515
    //   304: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 8
    //   309: invokevirtual 516	com/tencent/mobileqq/qbosssplash/model/SplashItem:toString	()Ljava/lang/String;
    //   312: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload 8
    //   323: invokevirtual 518	com/tencent/mobileqq/qbosssplash/model/SplashItem:a	()Z
    //   326: ifeq +95 -> 421
    //   329: aload 6
    //   331: ifnonnull +10 -> 341
    //   334: aload 8
    //   336: astore 7
    //   338: goto +76 -> 414
    //   341: aload 8
    //   343: astore 7
    //   345: aload 8
    //   347: getfield 521	com/tencent/mobileqq/qbosssplash/model/SplashItem:d	I
    //   350: aload 6
    //   352: getfield 521	com/tencent/mobileqq/qbosssplash/model/SplashItem:d	I
    //   355: if_icmpgt +59 -> 414
    //   358: goto +63 -> 421
    //   361: aload 6
    //   363: putstatic 523	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:jdField_a_of_type_ComTencentMobileqqQbosssplashModelSplashItem	Lcom/tencent/mobileqq/qbosssplash/model/SplashItem;
    //   366: iconst_1
    //   367: istore_3
    //   368: iload_3
    //   369: ireturn
    //   370: astore 6
    //   372: iload 5
    //   374: istore_3
    //   375: ldc 67
    //   377: iconst_1
    //   378: new 21	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 525
    //   388: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 6
    //   393: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   396: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: iload_3
    //   406: ireturn
    //   407: astore 6
    //   409: iconst_1
    //   410: istore_3
    //   411: goto -36 -> 375
    //   414: aload 7
    //   416: astore 6
    //   418: goto -171 -> 247
    //   421: aload 6
    //   423: astore 7
    //   425: goto -11 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramLong	long
    //   30	5	2	i	int
    //   17	394	3	bool1	boolean
    //   4	28	4	bool2	boolean
    //   1	372	5	bool3	boolean
    //   120	242	6	localSharedPreferences	SharedPreferences
    //   370	22	6	localException1	Exception
    //   407	1	6	localException2	Exception
    //   416	6	6	localObject1	Object
    //   13	411	7	localObject2	Object
    //   174	172	8	localObject3	Object
    //   93	187	9	localObject4	Object
    //   147	111	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	370	java/lang/Exception
    //   23	31	370	java/lang/Exception
    //   38	235	407	java/lang/Exception
    //   238	247	407	java/lang/Exception
    //   247	329	407	java/lang/Exception
    //   345	358	407	java/lang/Exception
    //   361	366	407	java/lang/Exception
  }
  
  public static boolean a(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(String paramString)
  {
    long l = a(paramString);
    return NetConnInfoCenter.getServerTime() > l;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    long l1 = a(paramString2);
    long l2 = a(paramString1);
    long l3 = NetConnInfoCenter.getServerTime();
    return (l2 < l3) && (l3 < l1);
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    try
    {
      a(paramContext, paramLong + "").edit().clear().apply();
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanQbossSPConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanQbossSPConfig exception" + paramContext.toString());
    }
  }
  
  public static void b(String paramString)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("qboss_pre_download_pref_" + paramString, 0).edit().clear().apply();
    a(new File(jdField_b_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qbosssplash.common.QbossSplashUtil
 * JD-Core Version:    0.7.0.1
 */