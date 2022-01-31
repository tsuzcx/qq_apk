package com.tencent.mobileqq.webview.swift.component;

import akvt;
import akvv;
import akvw;
import akvx;
import akvy;
import akvz;
import akwa;
import akwb;
import akwc;
import akwd;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.utils.Md5Utils;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

public class SwiftBrowserCookieMonster
{
  public static volatile akwd a;
  private static final LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  public static volatile String a;
  public static final AtomicInteger a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static volatile String b;
  public static volatile String c;
  public static volatile String d;
  public static volatile String e;
  public long a;
  public final AuthorizeConfig a;
  public final ConcurrentHashMap a;
  public volatile boolean a;
  public final AtomicInteger b;
  public boolean b;
  public volatile String f;
  public volatile String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public final String l;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  }
  
  SwiftBrowserCookieMonster(String paramString)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.l = paramString;
    if (jdField_a_of_type_AndroidSupportV4UtilLruCache.size() == 0) {
      CookieSyncManager.createInstance(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, this);
    e();
  }
  
  /* Error */
  public static SwiftBrowserCookieMonster a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 96	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +34 -> 46
    //   15: getstatic 40	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   18: aload_2
    //   19: invokevirtual 106	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: ifnonnull +12 -> 41
    //   32: new 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 108	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: aconst_null
    //   47: astore_0
    //   48: goto -7 -> 41
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   25	4	1	localSwiftBrowserCookieMonster	SwiftBrowserCookieMonster
    //   7	30	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	26	51	finally
    //   32	41	51	finally
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int m = paramString.length();
        while (m < 10)
        {
          ((StringBuilder)localObject).append("0");
          m += 1;
        }
        localObject = paramString;
      }
    }
    else {
      return localObject;
    }
    return "o" + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { paramString1, paramString2, paramString3 });
    }
    return String.format("%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure; HttpOnly;", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.format("http://%s/", new Object[] { paramString });
    }
    return String.format("https://%s/", new Object[] { paramString });
  }
  
  static void a(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (paramStringBuilder.length() > 0))
    {
      if (!paramStringBuilder.toString().endsWith(";")) {
        break label31;
      }
      paramStringBuilder.append(" ");
    }
    label31:
    while (paramStringBuilder.toString().endsWith("; ")) {
      return;
    }
    paramStringBuilder.append("; ");
  }
  
  static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      a(paramStringBuilder);
      paramStringBuilder.append(paramString2).append(paramString1);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, paramString2 + "is empty");
      }
    } while (TextUtils.isEmpty(paramString3));
    a(paramStringBuilder);
    paramStringBuilder.append(paramString2).append(paramString3);
  }
  
  static void a(List paramList, SwiftPreloadCookieManager paramSwiftPreloadCookieManager)
  {
    ThreadManager.post(new akvy(paramList, paramSwiftPreloadCookieManager), 5, null, false);
  }
  
  public static void a(AppRuntime arg0)
  {
    int m = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (3 != m)
    {
      if (1 == m)
      {
        AppRuntime localAppRuntime = ???;
        if (??? == null) {
          localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        }
        a(localAppRuntime);
      }
    }
    else {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      for (;;)
      {
        m = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        if (2 == m) {
          try
          {
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      m = 0;
      if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        break label166;
      }
    }
    label166:
    for (int n = 0;; n = 1)
    {
      VipUtils.a(null, "webview_report", "0X800619D", "0X800619D", 0, 0, new String[] { "" + m, "" + n });
      return;
      m = 1;
      break;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramAppRuntime != null) {}
    for (;;)
    {
      try
      {
        if (!paramAppRuntime.isLogin()) {
          break label540;
        }
        if (paramIntent == null) {
          break label533;
        }
        if (!paramIntent.getBooleanExtra("avoidLoginWeb", false)) {
          break label528;
        }
        m = 0;
        paramIntent = paramIntent.getStringExtra("url");
        if (m == 0) {
          break;
        }
        if (TextUtils.isEmpty(paramIntent))
        {
          paramIntent = AuthorizeConfig.a();
          TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
          String str = paramAppRuntime.getAccount();
          Object localObject1 = paramIntent.a("pt4_token");
          paramIntent = paramAppRuntime.getAppRuntime("modular_web");
          if ((paramIntent instanceof AppInterface))
          {
            Object localObject2 = new SwiftPreloadCookieManager((AppInterface)paramIntent);
            paramIntent = ((SwiftPreloadCookieManager)localObject2).a("p_skey");
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "p_skey top hosts: " + TextUtils.join(", ", paramIntent));
              }
              a(paramIntent, (SwiftPreloadCookieManager)localObject2);
              if (localObject1 == null) {
                break label550;
              }
              m = ((Set)localObject1).size();
              if (paramIntent == null) {
                break label555;
              }
              n = paramIntent.size();
              localObject2 = new String[n + m];
              m = i2;
              if (localObject1 != null)
              {
                m = i2;
                if (((Set)localObject1).size() > 0)
                {
                  localObject1 = ((Set)localObject1).iterator();
                  n = i1;
                  m = n;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2[n] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject1).next() });
                    n += 1;
                    continue;
                  }
                }
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label547;
              }
              QLog.i("SwiftBrowserCookieMonster", 2, "no any top hosts for p_skey");
              break label547;
            }
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              if (paramIntent.hasNext())
              {
                localObject2[m] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), (String)paramIntent.next() });
                m += 1;
                continue;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("SwiftBrowserCookieMonster", 2, "now preGetPskey and pt4Token: " + TextUtils.join(",", (Object[])localObject2));
            }
            localTicketManager.GetPskey(str, 16L, (String[])localObject2, new akvx());
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserCookieMonster", 2, "Batch load pt4_token when process preload");
            }
            a(paramAppRuntime);
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SwiftBrowserCookieMonster", 2, "Get tickets when load url");
          continue;
        }
        paramIntent = null;
      }
      catch (Exception paramAppRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftBrowserCookieMonster", 2, "preGetKey exception:" + paramAppRuntime.toString());
        }
        paramAppRuntime.printStackTrace();
        return;
      }
      continue;
      label528:
      int m = 1;
      continue;
      label533:
      m = 1;
      paramIntent = null;
      continue;
      label540:
      paramIntent = null;
      m = 0;
      continue;
      label547:
      continue;
      label550:
      m = 0;
      continue;
      label555:
      int n = 0;
    }
  }
  
  public static boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("https://aq.qq.com/"))
    {
      paramCookiesMap.addCookie(paramString1, a("dvid1", HexUtil.a(NetConnInfoCenter.GUID), paramString2, true));
      paramString2 = DeviceInfoUtil.a();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid5", HexUtil.a(NetConnInfoCenter.GUID), paramString2, true));
      }
      paramString2 = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid4", HexUtil.a(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid2", HexUtil.a(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.b(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid3", HexUtil.a(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      paramAppRuntime = new akvw(paramAppRuntime);
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.postImmediately(paramAppRuntime, null, false);
      }
    }
    else
    {
      return true;
    }
    paramAppRuntime.run();
    return true;
  }
  
  static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = Uri.parse(paramString);
        String str = ((Uri)localObject).getScheme();
        if ((("http".equals(str)) || ("https".equals(str))) && (((Uri)localObject).isHierarchical()))
        {
          localObject = a(((Uri)localObject).getHost(), "http".equals(str));
          return localObject;
        }
      }
      catch (Exception localException)
      {
        QLog.e("SwiftBrowserCookieMonster", 1, "getCookieHost[" + paramString + "] error:" + localException.toString());
      }
    }
    return null;
  }
  
  public static String b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (TicketManager)paramAppRuntime.getManager(2);
      long l1 = System.currentTimeMillis();
      String str1 = paramAppRuntime.getAccount();
      String str2 = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), paramString });
      akwb localakwb = new akwb(paramString, l1);
      localObject = ((TicketManager)localObject).GetPskey(str1, 16L, new String[] { str2 }, localakwb);
      if (localObject == null) {
        break label257;
      }
    }
    label257:
    for (Object localObject = ((Ticket)localObject).getPt4Token(paramString);; localObject = null)
    {
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      if ((paramAppRuntime instanceof AppInterface)) {
        new SwiftPreloadCookieManager((AppInterface)paramAppRuntime).a(paramString, "pt4_token");
      }
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label222;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache success for " + paramString + ", token is: " + Util.c(new StringBuilder().append("pt4_token=").append((String)localObject).toString(), new String[0]));
      }
      while (localObject != null)
      {
        return localObject;
        label222:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache failed for " + paramString);
      }
      return "";
      return "";
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    ThreadManager.postImmediately(new akvz(paramAppRuntime, paramIntent), new akwa(), false);
  }
  
  public static boolean b()
  {
    return (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(d)) && (!TextUtils.isEmpty(e)) && (!TextUtils.isEmpty(c));
  }
  
  static boolean b(AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      bool1 = bool2;
      if (paramAppRuntime != null)
      {
        bool1 = bool2;
        if (paramAppRuntime.isLogin())
        {
          bool2 = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("ptlogin_flag" + paramAppRuntime.getAccount(), false);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("SwiftBrowserCookieMonster", 2, "account: " + paramAppRuntime.getAccount() + ", mPtloginFlag: " + bool2);
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  public static String c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 533	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +198 -> 204
    //   9: invokestatic 69	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: invokevirtual 191	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +143 -> 162
    //   22: aload 4
    //   24: invokevirtual 229	mqq/app/AppRuntime:isLogin	()Z
    //   27: ifeq +135 -> 162
    //   30: aload 4
    //   32: invokevirtual 536	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   35: invokevirtual 539	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   38: invokestatic 79	com/tencent/smtt/sdk/CookieSyncManager:createInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   41: pop
    //   42: invokestatic 545	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   45: aload_0
    //   46: invokevirtual 548	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: astore_2
    //   52: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +55 -> 110
    //   58: ldc 166
    //   60: iconst_2
    //   61: new 115	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 550
    //   71: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: iconst_0
    //   76: anewarray 110	java/lang/String
    //   79: invokestatic 487	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 552
    //   88: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: iconst_0
    //   93: anewarray 110	java/lang/String
    //   96: invokestatic 554	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   99: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_1
    //   109: astore_2
    //   110: aload_3
    //   111: aload 4
    //   113: aload_2
    //   114: invokevirtual 556	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:c	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   117: areturn
    //   118: astore_0
    //   119: ldc 210
    //   121: astore_1
    //   122: ldc 166
    //   124: iconst_1
    //   125: new 115	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 558
    //   135: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: invokevirtual 561	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 563
    //   148: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_1
    //   158: astore_2
    //   159: goto -49 -> 110
    //   162: ldc 166
    //   164: iconst_1
    //   165: new 115	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 565
    //   175: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: iconst_0
    //   180: anewarray 110	java/lang/String
    //   183: invokestatic 554	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   186: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 567
    //   192: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: ldc 210
    //   203: areturn
    //   204: ldc 166
    //   206: iconst_1
    //   207: new 115	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 565
    //   217: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: iconst_0
    //   222: anewarray 110	java/lang/String
    //   225: invokestatic 554	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   228: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 567
    //   234: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: ldc 210
    //   245: areturn
    //   246: astore_0
    //   247: goto -125 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramString	String
    //   49	109	1	str1	String
    //   51	108	2	str2	String
    //   4	107	3	localSwiftBrowserCookieMonster	SwiftBrowserCookieMonster
    //   15	97	4	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   30	50	118	java/lang/Throwable
    //   52	108	246	java/lang/Throwable
  }
  
  public static void d()
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    c = "";
    d = "";
    e = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    jdField_a_of_type_Akwd = null;
    QLog.i("SwiftBrowserCookieMonster", 1, "resetAllKeyAndCache");
  }
  
  static void e()
  {
    if (jdField_a_of_type_Akwd == null) {
      ThreadManager.postImmediately(new akwc(), null, false);
    }
  }
  
  public SwiftBrowserCookieMonster.CookiesMap a(Intent paramIntent, AppRuntime paramAppRuntime)
  {
    boolean bool = true;
    paramIntent = new SwiftBrowserCookieMonster.CookiesMap();
    if (!a(paramIntent, paramAppRuntime)) {
      QLog.e("SwiftBrowserCookieMonster", 1, "setCookies error: collectUinRelatedCookies return false.");
    }
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin()))
    {
      if (!b(paramIntent, paramAppRuntime)) {}
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        c(paramIntent, paramAppRuntime);
        return paramIntent;
        bool = false;
      }
    }
    a(paramIntent, paramAppRuntime);
    return paramIntent;
  }
  
  public String a(String paramString, AppRuntime paramAppRuntime)
  {
    int n = 2;
    Object localObject = paramString;
    int m;
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SwiftBrowserCookieMonster", 2, "Cookies is wrong, now do ptlogin jumping!");
      }
      if (TextUtils.isEmpty(d)) {
        break label243;
      }
      if (this.k == null) {
        break label212;
      }
      m = 1;
      if (this.i == null) {
        break label217;
      }
      label53:
      VipUtils.a(null, "webview_report", "0X80060AC", "0X80060AC", 0, m | n, new String[] { paramString });
      boolean bool = b(paramAppRuntime);
      StringBuilder localStringBuilder = new StringBuilder("http");
      if (!bool) {
        break label223;
      }
      localObject = "s";
      label106:
      localStringBuilder = localStringBuilder.append((String)localObject).append("://");
      if (!bool) {
        break label230;
      }
      localObject = "ssl.";
      label131:
      localObject = localStringBuilder.append((String)localObject).append("ptlogin2.qq.com/jump?clientuin=").append(paramAppRuntime.getAccount()).append("&clientkey=").append(d).append("&keyindex=19&pt_mq=");
      if (!paramString.startsWith("http://s.p.qq.com")) {
        break label237;
      }
    }
    label212:
    label217:
    label223:
    label230:
    label237:
    for (paramAppRuntime = "1";; paramAppRuntime = "0")
    {
      localObject = paramAppRuntime + "&u1=" + URLEncoder.encode(paramString);
      return localObject;
      m = 0;
      break;
      n = 0;
      break label53;
      localObject = "";
      break label106;
      localObject = "";
      break label131;
    }
    label243:
    if (QLog.isColorLevel()) {
      QLog.w("SwiftBrowserCookieMonster", 2, "Can't do ptlogin jumping because STwxWeb is empty!");
    }
    this.jdField_a_of_type_Long |= 0x8;
    return paramString;
  }
  
  String a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      String str = ((TicketManager)paramAppRuntime.getManager(2)).getPskey(paramAppRuntime.getAccount(), paramString);
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      if ((paramAppRuntime instanceof AppInterface)) {
        new SwiftPreloadCookieManager((AppInterface)paramAppRuntime).a(paramString, "p_skey");
      }
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty(str)) {
          break label108;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "Get p_skey success for " + paramString);
      }
      while (str != null)
      {
        return str;
        label108:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get p_skey failed for " + paramString);
      }
      return "";
    }
    return "";
  }
  
  void a()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramCookiesMap.addCookie(a(str, true), a("skey", "", str, false));
    }
    paramCookiesMap.addCookie(a("ptlogin2.qq.com", true), a("superkey", "", "ptlogin2.qq.com", true));
    if (!TextUtils.isEmpty(this.k)) {
      paramCookiesMap.addCookie(this.l, a("p_skey", "", this.k, false));
    }
    if (!TextUtils.isEmpty(this.h)) {
      paramCookiesMap.addCookie(this.l, a("a2", "", this.h, true));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserCookieMonster", 2, Util.b(this.l, new String[0]) + " forbidden login state, remove all login key");
    }
  }
  
  void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    localObject = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis() + 10000L));
    String str = this.l;
    if (paramAppRuntime == null)
    {
      localObject = "login_key_set_failed=NullRuntime; EXPIRES=" + (String)localObject + ";";
      paramCookiesMap.addCookie(str, (String)localObject);
      a(paramCookiesMap, this.l, "aq.qq.com");
      if (paramAppRuntime != null) {
        break label168;
      }
    }
    label168:
    for (int m = 1;; m = 0)
    {
      VipUtils.a(null, "webview_report", "0X8006117", "0X8006117", m, 0, new String[] { this.l });
      return;
      localObject = "login_key_set_failed=AlreadyLogout; EXPIRES=" + (String)localObject + ";";
      break;
    }
  }
  
  public void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    paramCookiesMap = paramCookiesMap.entrySet().iterator();
    while (paramCookiesMap.hasNext())
    {
      Object localObject = (Map.Entry)paramCookiesMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ArrayList)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localHashMap.put(str, ((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]));
      }
    }
    if (localHashMap.size() > 0)
    {
      CookieManager.getInstance().setCookies(localHashMap);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
        CookieSyncManager.getInstance().sync();
      }
    }
  }
  
  public void a(SwiftBrowserCookieMonster.SetCookiesCallback paramSetCookiesCallback)
  {
    if (paramSetCookiesCallback != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (((CopyOnWriteArrayList)localObject).contains(paramSetCookiesCallback)) {
          ((CopyOnWriteArrayList)localObject).remove(paramSetCookiesCallback);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3;
  }
  
  boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin())) {}
    for (String str1 = a(paramAppRuntime.getAccount());; str1 = "")
    {
      paramAppRuntime = a("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, a("superuin", str1, "ptlogin2.qq.com", false));
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
      String str2;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        paramAppRuntime = a(str2, true);
        paramCookiesMap.addCookie(paramAppRuntime, a("uin", str1, str2, false));
      }
      localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("pskey").iterator();
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        paramAppRuntime = a(str2, true);
        paramCookiesMap.addCookie(paramAppRuntime, a("p_uin", str1, str2, false));
      }
      if (TextUtils.isEmpty(str1))
      {
        this.jdField_a_of_type_Long |= 0x80;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserCookieMonster", 2, "cookieUin isempty，url:" + paramAppRuntime);
        }
        return false;
      }
      return true;
    }
  }
  
  public boolean a(String paramString, SwiftBrowserCookieMonster.SetCookiesCallback paramSetCookiesCallback, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
    {
      if (paramAppRuntime == null)
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = a(paramString, (AppRuntime)localObject1);
        if (paramSetCookiesCallback == null) {
          break label317;
        }
        if (this.jdField_a_of_type_Long > 0L)
        {
          g();
          QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, errorCode: " + this.jdField_a_of_type_Long);
        }
        localObject2 = CookieManager.getInstance().getCookie(paramString);
        if (((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("skey="))) || (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString))) {
          break label171;
        }
        QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, retry set cookie: " + (String)localObject2 + "");
        a();
        a(paramString, paramSetCookiesCallback, paramAppRuntime, paramIntent);
      }
      for (;;)
      {
        return true;
        localObject1 = paramAppRuntime;
        break;
        label171:
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long > 0L))
        {
          if (this.jdField_b_of_type_Boolean) {
            QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + Util.b((String)localObject1, new String[0]));
          }
          paramSetCookiesCallback.a((String)localObject1, null, this.jdField_a_of_type_Long);
          b();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "hit cookie cache, just call onSetCookiesFinished " + Util.b((String)localObject1, new String[0]) + ", errorCode: " + this.jdField_a_of_type_Long);
          }
          paramSetCookiesCallback.a((String)localObject1, null, this.jdField_a_of_type_Long);
        }
      }
    }
    label317:
    if (paramSetCookiesCallback != null)
    {
      localObject2 = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
      }
      if (!((CopyOnWriteArrayList)localObject1).contains(paramSetCookiesCallback)) {
        ((CopyOnWriteArrayList)localObject1).add(paramSetCookiesCallback);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "now add callback for " + Util.b(paramString, new String[0]));
      }
    }
    Util.a("Web_qqbrowser_check_and_set_cookies");
    paramString = new akvt(this, paramAppRuntime, paramIntent);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      CookieSyncManager.createInstance(BaseApplicationImpl.getApplication().getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "post thread to set all cookies");
      }
      ThreadManager.postImmediately(paramString, new akvv(this), false);
    }
    return true;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.l);
  }
  
  boolean b(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((!TextUtils.isEmpty(this.k)) && (TextUtils.isEmpty(this.f)))
    {
      this.f = a(paramAppRuntime, this.k);
      StringBuilder localStringBuilder = new StringBuilder().append(this.k).append(": pSkey is miss and fetch result is ");
      if (TextUtils.isEmpty(this.f))
      {
        localObject1 = "fail";
        QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject1);
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(this.i)) && (TextUtils.isEmpty(this.g)))
      {
        this.g = b(paramAppRuntime, this.i);
        localObject1 = new StringBuilder().append(this.i).append(": pt4Token is miss and fetch result is ");
        if (!TextUtils.isEmpty(this.g)) {
          break label304;
        }
        paramAppRuntime = "fail";
        label154:
        QLog.i("SwiftBrowserCookieMonster", 1, paramAppRuntime);
      }
      paramAppRuntime = localObject2;
      if (!TextUtils.isEmpty(this.k))
      {
        VipUtils.a(null, "webview_report", "0X80060AB", "0X80060AB", 0, 0, new String[] { this.l, this.k });
        if (TextUtils.isEmpty(this.f)) {
          break label311;
        }
        paramAppRuntime = a("p_skey", this.f, this.k, false);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
        paramAppRuntime = localObject2;
      }
      label251:
      if (!TextUtils.isEmpty(this.i))
      {
        if (TextUtils.isEmpty(this.g)) {
          break label394;
        }
        paramAppRuntime = a("pt4_token", this.g, this.i, false);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
      }
    }
    label304:
    label311:
    do
    {
      return true;
      localObject1 = "success";
      break;
      paramAppRuntime = "success";
      break label154;
      localObject1 = CookieManager.getInstance().getCookie(this.l);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("p_skey=")))
      {
        paramAppRuntime = (AppRuntime)localObject1;
        if (!((String)localObject1).contains("p_skey=;")) {
          break label251;
        }
      }
      this.jdField_a_of_type_Long |= 0x20;
      QLog.e("SwiftBrowserCookieMonster", 1, this.k + ": get pSkey fail!");
      return false;
      paramCookiesMap = paramAppRuntime;
      if (paramAppRuntime == null) {
        paramCookiesMap = CookieManager.getInstance().getCookie(this.l);
      }
    } while ((!TextUtils.isEmpty(paramCookiesMap)) && (paramCookiesMap.contains("pt4_token=")) && (!paramCookiesMap.contains("pt4_token=;")));
    label394:
    this.jdField_a_of_type_Long |= 0x40;
    QLog.e("SwiftBrowserCookieMonster", 1, this.i + ": get pt4Token fail!");
    return false;
  }
  
  String c(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject2 = new StringBuilder();
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    String str = paramAppRuntime.getAccount();
    Object localObject3 = a(str);
    if (!TextUtils.isEmpty(paramString)) {
      ((StringBuilder)localObject2).append(paramString);
    }
    a((StringBuilder)localObject2);
    ((StringBuilder)localObject2).append("uin=").append((String)localObject3);
    StringBuilder localStringBuilder;
    Object localObject1;
    label192:
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("skey="))) {
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        jdField_a_of_type_JavaLangString = localTicketManager.getSkey(str);
        localStringBuilder = new StringBuilder().append("getCookie4WebSo: skey is miss and fetch result is ");
        if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
        {
          localObject1 = "fail";
          QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject1);
        }
      }
      else
      {
        if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          break label494;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, Util.c("skey=" + jdField_a_of_type_JavaLangString, new String[0]));
        localObject1 = localTicketManager.GetLocalTicket(str, 4096);
        if (localObject1 != null) {
          QLog.i("SwiftBrowserCookieMonster", 1, "last refresh skey time: " + ((Ticket)localObject1)._create_time);
        }
        a((StringBuilder)localObject2, jdField_a_of_type_JavaLangString, "skey=", "");
        bool1 = false;
      }
    }
    for (;;)
    {
      label257:
      boolean bool2;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_skey=;")))
      {
        if (!QLog.isColorLevel()) {
          break label1394;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pskey");
        bool2 = false;
      }
      for (;;)
      {
        label292:
        boolean bool3;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pt4_token=;")))
        {
          if (!QLog.isColorLevel()) {
            break label1388;
          }
          QLog.d("SwiftBrowserCookieMonster", 2, "not need set pt4_token");
          bool3 = false;
        }
        label899:
        label1038:
        for (;;)
        {
          label327:
          if ((bool1) || (bool2) || (bool3))
          {
            QLog.i("SwiftBrowserCookieMonster", 1, "getCookie4WebSo: cookie need update: isNeedReplaceSkey(" + bool1 + "), isNeedReplacePskey(" + bool2 + "), isNeedReplacePt4Token(" + bool3 + ").");
            paramString = ((StringBuilder)localObject2).toString().replaceAll(" ", "");
            localObject1 = new StringBuilder();
            if (paramString.contains(";"))
            {
              localObject2 = paramString.split(";");
              int n = localObject2.length;
              int m = 0;
              if (m < n)
              {
                localObject3 = localObject2[m];
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  if (((StringBuilder)localObject1).length() != 0) {
                    break label922;
                  }
                  ((StringBuilder)localObject1).append((String)localObject3);
                }
                for (;;)
                {
                  m += 1;
                  break label443;
                  localObject1 = "success";
                  break;
                  label494:
                  QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                  break label192;
                  if (paramString.contains("skey=;"))
                  {
                    if (!QLog.isColorLevel()) {
                      break label1400;
                    }
                    QLog.d("SwiftBrowserCookieMonster", 2, "not need set skey");
                    bool1 = false;
                    break label257;
                  }
                  if (!paramString.contains("skey=")) {
                    break label1400;
                  }
                  bool1 = true;
                  break label257;
                  localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l);
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label1394;
                  }
                  if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("p_skey=")))
                  {
                    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_uin=;")))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uin");
                      }
                      label623:
                      if (TextUtils.isEmpty(this.f))
                      {
                        this.f = localTicketManager.getPskey(str, (String)localObject1);
                        localObject3 = new StringBuilder().append("getCookie4WebSo: pSkey is miss and fetch result is ");
                        if (!TextUtils.isEmpty(this.f)) {
                          break label753;
                        }
                      }
                    }
                    label753:
                    for (localObject1 = "fail";; localObject1 = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject1);
                      a((StringBuilder)localObject2, this.f, "p_skey=", "");
                      bool2 = false;
                      break;
                      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_uin="))) {
                        break label623;
                      }
                      a((StringBuilder)localObject2);
                      ((StringBuilder)localObject2).append("p_uin=").append((String)localObject3);
                      break label623;
                    }
                  }
                  if (!paramString.contains("p_skey=")) {
                    break label1394;
                  }
                  bool2 = true;
                  break label292;
                  localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(this.l);
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label1388;
                  }
                  if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("pt4_token=")))
                  {
                    if (TextUtils.isEmpty(this.g))
                    {
                      this.g = b(paramAppRuntime, (String)localObject1);
                      localObject1 = new StringBuilder().append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.g)) {
                        break label899;
                      }
                    }
                    for (paramString = "fail";; paramString = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      a((StringBuilder)localObject2, this.g, "pt4_token=", "");
                      bool3 = false;
                      break;
                    }
                  }
                  if (!paramString.contains("pt4_token=")) {
                    break label1388;
                  }
                  bool3 = true;
                  break label327;
                  a((StringBuilder)localObject1);
                  if ((((String)localObject3).startsWith("p_skey=")) && (bool2))
                  {
                    if (TextUtils.isEmpty(this.f))
                    {
                      this.f = localTicketManager.getPskey(str, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l));
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: pSkey is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.f)) {
                        break label1038;
                      }
                    }
                    for (paramString = "fail";; paramString = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      a((StringBuilder)localObject1, this.f, "p_skey=", (String)localObject3);
                      break;
                    }
                  }
                  if ((((String)localObject3).startsWith("skey=")) && (bool1))
                  {
                    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
                    {
                      jdField_a_of_type_JavaLangString = localTicketManager.getSkey(str);
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: sKey is miss and fetch result is ");
                      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
                      {
                        paramString = "fail";
                        label1110:
                        QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      }
                    }
                    else
                    {
                      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
                        break label1238;
                      }
                      QLog.i("SwiftBrowserCookieMonster", 1, Util.c("skey=" + jdField_a_of_type_JavaLangString, new String[0]));
                    }
                    for (;;)
                    {
                      paramString = localTicketManager.GetLocalTicket(str, 4096);
                      if (paramString != null) {
                        QLog.i("SwiftBrowserCookieMonster", 1, "last refresh skey time: " + paramString._create_time);
                      }
                      a((StringBuilder)localObject1, jdField_a_of_type_JavaLangString, "skey=", (String)localObject3);
                      break;
                      paramString = "success";
                      break label1110;
                      label1238:
                      QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                    }
                  }
                  if ((((String)localObject3).startsWith("pt4_token=")) && (bool3))
                  {
                    if (TextUtils.isEmpty(this.g))
                    {
                      this.g = b(paramAppRuntime, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(this.l));
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.g)) {
                        break label1356;
                      }
                    }
                    label1356:
                    for (paramString = "fail";; paramString = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      a((StringBuilder)localObject1, this.g, "pt4_token=", (String)localObject3);
                      break;
                    }
                  }
                  ((StringBuilder)localObject1).append((String)localObject3);
                }
              }
            }
          }
          label443:
          for (paramAppRuntime = (AppRuntime)localObject1;; paramAppRuntime = (AppRuntime)localObject2) {
            return paramAppRuntime.toString();
          }
          label922:
          label1388:
          bool3 = false;
        }
        label1394:
        bool2 = false;
      }
      label1400:
      bool1 = false;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 922	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Boolean	Z
    //   6: ifne +46 -> 52
    //   9: aload_0
    //   10: getfield 59	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   13: ldc_w 924
    //   16: invokevirtual 625	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19: ifeq +36 -> 55
    //   22: aload_0
    //   23: ldc_w 926
    //   26: putfield 928	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   29: aload_0
    //   30: ldc 210
    //   32: putfield 604	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   35: aload_0
    //   36: ldc 210
    //   38: putfield 655	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   41: aload_0
    //   42: ldc 210
    //   44: putfield 602	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 922	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Boolean	Z
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 59	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   60: invokestatic 929	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 928	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 86	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   71: aload_0
    //   72: getfield 59	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   75: invokevirtual 931	com/tencent/biz/AuthorizeConfig:f	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 655	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 86	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   86: aload_0
    //   87: getfield 59	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   90: invokevirtual 906	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   93: putfield 602	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 86	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   101: aload_0
    //   102: getfield 59	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   105: invokevirtual 916	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   108: putfield 604	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   111: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -67 -> 47
    //   117: ldc 166
    //   119: iconst_2
    //   120: new 115	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 933
    //   130: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 928	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   137: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 935
    //   143: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 602	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   150: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 937
    //   156: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: getfield 604	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   163: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 939
    //   169: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: getfield 655	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   176: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: goto -138 -> 47
    //   188: astore_1
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	SwiftBrowserCookieMonster
    //   188	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	188	finally
    //   47	52	188	finally
    //   55	185	188	finally
  }
  
  boolean c(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if (!b()) {
      a(paramAppRuntime);
    }
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      try
      {
        paramAppRuntime = MessageDigest.getInstance("MD5");
        paramAppRuntime.update(jdField_b_of_type_JavaLangString.getBytes());
        paramAppRuntime = paramAppRuntime.digest();
        int m = paramAppRuntime.length;
        long l1 = paramAppRuntime[(m - 4)] & 0xFF;
        long l2 = (paramAppRuntime[(m - 3)] & 0xFF) << 16;
        long l3 = (paramAppRuntime[(m - 2)] & 0xFF) << 8;
        c = Long.toString(paramAppRuntime[(m - 1)] & 0xFF | l1 << 24 | l2 | l3);
      }
      catch (NoSuchAlgorithmException paramAppRuntime)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SwiftBrowserCookieMonster", 2, "Super key hash failed:" + paramAppRuntime.getMessage());
          }
          this.jdField_a_of_type_Long |= 0x4;
        }
      }
      paramAppRuntime = a("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, a("superkey", jdField_b_of_type_JavaLangString, "ptlogin2.qq.com", true));
      paramCookiesMap.addCookie(paramAppRuntime, a("supertoken", c, "ptlogin2.qq.com", false));
      if (!TextUtils.isEmpty(this.h))
      {
        if (TextUtils.isEmpty(e)) {
          break label350;
        }
        paramAppRuntime = a("a2", e, this.h, true);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
      }
    }
    for (;;)
    {
      a(paramCookiesMap, this.l, this.h);
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        break label365;
      }
      paramAppRuntime = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
      while (paramAppRuntime.hasNext())
      {
        String str = (String)paramAppRuntime.next();
        paramCookiesMap.addCookie(a(str, true), a("skey", jdField_a_of_type_JavaLangString, str, false));
      }
      this.jdField_a_of_type_Long |= 0x2;
      break;
      label350:
      this.jdField_a_of_type_Long |= 0x10;
    }
    label365:
    this.jdField_a_of_type_Long |= 1L;
    return true;
  }
  
  @Deprecated
  public void f()
  {
    c();
    SwiftBrowserCookieMonster.CookiesMap localCookiesMap = new SwiftBrowserCookieMonster.CookiesMap();
    a(localCookiesMap, null);
    a(localCookiesMap);
    a(localCookiesMap, true);
    jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster
 * JD-Core Version:    0.7.0.1
 */