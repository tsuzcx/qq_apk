package com.tencent.mobileqq.webview.swift.component;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import anxf;
import bgwa;
import bgwb;
import bgwc;
import bgwd;
import bgwe;
import bgwf;
import bgxo;
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
import common.config.service.QzoneConfig;
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
import nko;
import npn;
import oicq.wlogin_sdk.request.Ticket;

public class SwiftBrowserCookieMonster
{
  private static final LruCache<String, SwiftBrowserCookieMonster> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  public static volatile bgwf a;
  public static volatile String a;
  public static final AtomicInteger a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static volatile String b;
  public static volatile String c;
  public static volatile String d;
  public static volatile String e;
  long jdField_a_of_type_Long = 0L;
  final ConcurrentHashMap<String, CopyOnWriteArrayList<bgwe>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public final nko a;
  public volatile boolean a;
  final AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  boolean jdField_b_of_type_Boolean = false;
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
    this.l = paramString;
    if (jdField_a_of_type_AndroidSupportV4UtilLruCache.size() == 0) {
      CookieSyncManager.createInstance(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    this.jdField_a_of_type_Nko = nko.a();
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
    //   4: invokestatic 98	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +34 -> 46
    //   15: getstatic 42	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   18: aload_2
    //   19: invokevirtual 108	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: ifnonnull +12 -> 41
    //   32: new 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 110	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:<init>	(Ljava/lang/String;)V
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
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure;", new Object[] { paramString1, paramString2, paramString3 });
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
  
  static void a(List<String> paramList, bgxo parambgxo)
  {
    ThreadManager.post(new SwiftBrowserCookieMonster.5(paramList, parambgxo), 5, null, false);
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
          break label541;
        }
        if (paramIntent == null) {
          break label534;
        }
        if (!paramIntent.getBooleanExtra("avoidLoginWeb", false)) {
          break label529;
        }
        m = 0;
        paramIntent = paramIntent.getStringExtra("url");
        if (m == 0) {
          break;
        }
        if (TextUtils.isEmpty(paramIntent))
        {
          paramIntent = nko.a();
          TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
          String str = paramAppRuntime.getAccount();
          Object localObject1 = paramIntent.a("pt4_token");
          paramIntent = paramAppRuntime.getAppRuntime("modular_web");
          if ((paramIntent instanceof AppInterface))
          {
            Object localObject2 = new bgxo((AppInterface)paramIntent);
            paramIntent = ((bgxo)localObject2).a("p_skey");
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "p_skey top hosts: " + TextUtils.join(", ", paramIntent));
              }
              a(paramIntent, (bgxo)localObject2);
              if (localObject1 == null) {
                break label551;
              }
              m = ((Set)localObject1).size();
              if (paramIntent == null) {
                break label556;
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
                break label548;
              }
              QLog.i("SwiftBrowserCookieMonster", 2, "no any top hosts for p_skey");
              break label548;
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
            localTicketManager.getPskey(str, 16L, (String[])localObject2, new bgwb());
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
      label529:
      int m = 1;
      continue;
      label534:
      m = 1;
      paramIntent = null;
      continue;
      label541:
      paramIntent = null;
      m = 0;
      continue;
      label548:
      continue;
      label551:
      m = 0;
      continue;
      label556:
      int n = 0;
    }
  }
  
  public static boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("https://aq.qq.com/"))
    {
      paramCookiesMap.addCookie(paramString1, a("dvid1", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      paramString2 = DeviceInfoUtil.getIMEI();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid5", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      }
      paramString2 = DeviceInfoUtil.getIMSI();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid4", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.getLocalMacAddress(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid2", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.getBSSID(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid3", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      paramAppRuntime = new SwiftBrowserCookieMonster.3(paramAppRuntime);
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
  
  public static String b(String paramString)
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
      bgwd localbgwd = new bgwd(paramString, l1);
      localObject = ((TicketManager)localObject).getPskey(str1, 16L, new String[] { str2 }, localbgwd);
      if (localObject == null) {
        break label258;
      }
    }
    label258:
    for (Object localObject = ((Ticket)localObject).getPt4Token(paramString);; localObject = null)
    {
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      if ((paramAppRuntime instanceof AppInterface)) {
        new bgxo((AppInterface)paramAppRuntime).a(paramString, "pt4_token");
      }
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label223;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache success for " + paramString + ", token is: " + npn.c(new StringBuilder().append("pt4_token=").append((String)localObject).toString(), new String[0]));
      }
      while (localObject != null)
      {
        return localObject;
        label223:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache failed for " + paramString);
      }
      return "";
      return "";
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    ThreadManager.postImmediately(new SwiftBrowserCookieMonster.6(paramAppRuntime, paramIntent), new bgwc(), false);
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
    //   1: invokestatic 545	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +198 -> 204
    //   9: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: invokevirtual 198	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +143 -> 162
    //   22: aload 4
    //   24: invokevirtual 236	mqq/app/AppRuntime:isLogin	()Z
    //   27: ifeq +135 -> 162
    //   30: aload 4
    //   32: invokevirtual 548	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   35: invokevirtual 551	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   38: invokestatic 81	com/tencent/smtt/sdk/CookieSyncManager:createInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   41: pop
    //   42: invokestatic 557	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   45: aload_0
    //   46: invokevirtual 560	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: astore_2
    //   52: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +55 -> 110
    //   58: ldc 171
    //   60: iconst_2
    //   61: new 117	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 562
    //   71: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: iconst_0
    //   76: anewarray 112	java/lang/String
    //   79: invokestatic 499	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 564
    //   88: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: iconst_0
    //   93: anewarray 112	java/lang/String
    //   96: invokestatic 566	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   99: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_1
    //   109: astore_2
    //   110: aload_3
    //   111: aload 4
    //   113: aload_2
    //   114: invokevirtual 568	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:c	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   117: areturn
    //   118: astore_0
    //   119: ldc 217
    //   121: astore_1
    //   122: ldc 171
    //   124: iconst_1
    //   125: new 117	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 570
    //   135: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: invokevirtual 573	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 575
    //   148: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_1
    //   158: astore_2
    //   159: goto -49 -> 110
    //   162: ldc 171
    //   164: iconst_1
    //   165: new 117	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 577
    //   175: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: iconst_0
    //   180: anewarray 112	java/lang/String
    //   183: invokestatic 566	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   186: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 579
    //   192: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: ldc 217
    //   203: areturn
    //   204: ldc 171
    //   206: iconst_1
    //   207: new 117	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 577
    //   217: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: iconst_0
    //   222: anewarray 112	java/lang/String
    //   225: invokestatic 566	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   228: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 579
    //   234: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: ldc 217
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
    jdField_a_of_type_Bgwf = null;
    QLog.i("SwiftBrowserCookieMonster", 1, "resetAllKeyAndCache");
  }
  
  static void e()
  {
    if (jdField_a_of_type_Bgwf == null) {
      ThreadManager.postImmediately(new SwiftBrowserCookieMonster.9(), null, false);
    }
  }
  
  SwiftBrowserCookieMonster.CookiesMap a(Intent paramIntent, AppRuntime paramAppRuntime)
  {
    boolean bool = true;
    paramIntent = new SwiftBrowserCookieMonster.CookiesMap();
    if (!a(paramIntent, paramAppRuntime)) {
      QLog.e("SwiftBrowserCookieMonster", 1, "setCookies error: collectUinRelatedCookies return false.");
    }
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin())) {
      if (!b(paramIntent, paramAppRuntime))
      {
        this.jdField_b_of_type_Boolean = bool;
        c(paramIntent, paramAppRuntime);
      }
    }
    for (;;)
    {
      a(paramIntent);
      return paramIntent;
      bool = false;
      break;
      a(paramIntent, paramAppRuntime);
    }
  }
  
  String a(String paramString, AppRuntime paramAppRuntime)
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
      if (!paramString.startsWith("https://s.p.qq.com")) {
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
        new bgxo((AppInterface)paramAppRuntime).a(paramString, "p_skey");
      }
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty(str)) {
          break label142;
        }
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("Get p_skey success for ").append(paramString).append(npn.c(" p_skey=" + str, new String[0]));
        QLog.d("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
      }
      while (str != null)
      {
        return str;
        label142:
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
  
  public void a(bgwe parambgwe)
  {
    if (parambgwe != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (((CopyOnWriteArrayList)localObject).contains(parambgwe)) {
          ((CopyOnWriteArrayList)localObject).remove(parambgwe);
        }
      }
    }
  }
  
  void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    String str = anxf.a(BaseApplicationImpl.getContext(), "key_local_cache", "0");
    if ("0".equals(str)) {
      QLog.e("SwiftBrowserCookieMonster", 1, "addLocaleIdCookie, localeIdStr = 0");
    }
    for (;;)
    {
      return;
      str = "qq_locale_id=" + str + ';';
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "addLocaleIdCookie, cookie = " + str);
      }
      Iterator localIterator = paramCookiesMap.keySet().iterator();
      while (localIterator.hasNext()) {
        paramCookiesMap.addCookie((String)localIterator.next(), str);
      }
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
  
  void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, boolean paramBoolean)
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
      Iterator localIterator = this.jdField_a_of_type_Nko.a("skey").iterator();
      String str2;
      if (localIterator.hasNext())
      {
        paramAppRuntime = (String)localIterator.next();
        str2 = a(paramAppRuntime, true);
        if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {}
        for (paramAppRuntime = a("uin", str1, paramAppRuntime);; paramAppRuntime = a("uin", str1, paramAppRuntime, false))
        {
          paramCookiesMap.addCookie(str2, paramAppRuntime);
          paramAppRuntime = str2;
          break;
        }
      }
      localIterator = this.jdField_a_of_type_Nko.a("pskey").iterator();
      if (localIterator.hasNext())
      {
        paramAppRuntime = (String)localIterator.next();
        str2 = a(paramAppRuntime, true);
        if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {}
        for (paramAppRuntime = a("p_uin", str1, paramAppRuntime);; paramAppRuntime = a("p_uin", str1, paramAppRuntime, false))
        {
          paramCookiesMap.addCookie(str2, paramAppRuntime);
          paramAppRuntime = str2;
          break;
        }
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
  
  boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      bool2 = bool1;
      if (!paramString.contains("p_skey"))
      {
        bool1 = bool3;
        if (!TextUtils.isEmpty(this.k)) {
          if (!this.k.equals("docs.qq.com"))
          {
            bool1 = bool3;
            if (!this.k.equals("docx.qq.com")) {}
          }
          else
          {
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          QLog.i("SwiftBrowserCookieMonster", 1, "isNeedPskey we should re - setAllCookies");
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public boolean a(String paramString, bgwe parambgwe, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
    {
      if (paramAppRuntime == null)
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = a(paramString, (AppRuntime)localObject1);
        if (parambgwe == null) {
          break label326;
        }
        if (this.jdField_a_of_type_Long > 0L)
        {
          g();
          QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, errorCode: " + this.jdField_a_of_type_Long);
        }
        localObject2 = CookieManager.getInstance().getCookie(paramString);
        if (((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).contains("skey="))) && ((!this.jdField_a_of_type_Nko.a(paramString)) && (!a((String)localObject2)))) {
          break label180;
        }
        QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, retry set cookie: " + (String)localObject2 + "");
        a();
        a(paramString, parambgwe, paramAppRuntime, paramIntent);
      }
      for (;;)
      {
        return true;
        localObject1 = paramAppRuntime;
        break;
        label180:
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long > 0L))
        {
          if (this.jdField_b_of_type_Boolean) {
            QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + npn.b((String)localObject1, new String[0]));
          }
          parambgwe.onSetCookiesFinished((String)localObject1, null, this.jdField_a_of_type_Long);
          b();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "hit cookie cache, just call onSetCookiesFinished " + npn.b((String)localObject1, new String[0]) + ", errorCode: " + this.jdField_a_of_type_Long);
          }
          parambgwe.onSetCookiesFinished((String)localObject1, null, this.jdField_a_of_type_Long);
        }
      }
    }
    label326:
    if (parambgwe != null)
    {
      localObject2 = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
      }
      if (!((CopyOnWriteArrayList)localObject1).contains(parambgwe)) {
        ((CopyOnWriteArrayList)localObject1).add(parambgwe);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "now add callback for " + npn.b(paramString, new String[0]));
      }
    }
    npn.a("Web_qqbrowser_check_and_set_cookies");
    paramString = new SwiftBrowserCookieMonster.1(this, paramAppRuntime, paramIntent);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      CookieSyncManager.createInstance(BaseApplicationImpl.getApplication().getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "post thread to set all cookies");
      }
      ThreadManager.postImmediately(paramString, new bgwa(this), false);
    }
    return true;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.l);
  }
  
  void b(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    Iterator localIterator = this.jdField_a_of_type_Nko.a("skey").iterator();
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
      QLog.d("SwiftBrowserCookieMonster", 2, npn.b(this.l, new String[0]) + " forbidden login state, remove all login key");
    }
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
        label87:
        if ((!TextUtils.isEmpty(this.i)) && (TextUtils.isEmpty(this.g)))
        {
          this.g = b(paramAppRuntime, this.i);
          localObject1 = new StringBuilder().append(this.i).append(": pt4Token is miss and fetch result is ");
          if (!TextUtils.isEmpty(this.g)) {
            break label507;
          }
          paramAppRuntime = "fail";
          QLog.i("SwiftBrowserCookieMonster", 1, paramAppRuntime);
        }
        label154:
        paramAppRuntime = localObject2;
        if (!TextUtils.isEmpty(this.k))
        {
          VipUtils.a(null, "webview_report", "0X80060AB", "0X80060AB", 0, 0, new String[] { this.l, this.k });
          if (TextUtils.isEmpty(this.f)) {
            break label564;
          }
          if ((this.l == null) || (!QzoneConfig.isNeedSecureVerify()) || (!this.l.contains("qzone.qq.com"))) {
            break label514;
          }
          localObject1 = a("p_skey", this.f, this.k);
          label264:
          paramCookiesMap.addCookie(this.l, (String)localObject1);
          paramAppRuntime = localObject2;
          if (this.l != null)
          {
            paramAppRuntime = localObject2;
            if (this.l.contains("http://"))
            {
              paramAppRuntime = localObject2;
              if (this.l.contains("qzone.qq.com"))
              {
                paramCookiesMap.addCookie(this.l.replace("http", "https"), (String)localObject1);
                paramAppRuntime = localObject2;
              }
            }
          }
        }
        label336:
        if (!TextUtils.isEmpty(this.i))
        {
          if (TextUtils.isEmpty(this.g)) {
            break label666;
          }
          if (!QzoneConfig.isNeedSecureVerifyAllBusiness()) {
            break label647;
          }
          paramAppRuntime = a("pt4_token", this.g, this.i);
          label377:
          paramCookiesMap.addCookie(this.l, paramAppRuntime);
        }
      }
    }
    label507:
    do
    {
      if ((!TextUtils.isEmpty(this.k)) && (this.k.equals("docs.qq.com")))
      {
        paramAppRuntime = a("tdsourcetag", "s_qq_c2c_chatfiles", this.k, false);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
      }
      return true;
      localObject1 = "success";
      break;
      if (!QLog.isColorLevel()) {
        break label87;
      }
      QLog.d("SwiftBrowserCookieMonster", 1, this.k + npn.c(new StringBuilder().append(" p_skey=").append(this.f).toString(), new String[0]));
      break label87;
      paramAppRuntime = "success";
      break label154;
      if ((this.l != null) && (QzoneConfig.isNeedSecureVerifyAllBusiness()))
      {
        localObject1 = a("p_skey", this.f, this.k);
        break label264;
      }
      localObject1 = a("p_skey", this.f, this.k, false);
      break label264;
      localObject1 = CookieManager.getInstance().getCookie(this.l);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("p_skey=")))
      {
        paramAppRuntime = (AppRuntime)localObject1;
        if (!((String)localObject1).contains("p_skey=;")) {
          break label336;
        }
      }
      this.jdField_a_of_type_Long |= 0x20;
      QLog.e("SwiftBrowserCookieMonster", 1, this.k + ": get pSkey fail!");
      return false;
      paramAppRuntime = a("pt4_token", this.g, this.i, false);
      break label377;
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null) {
        localObject1 = CookieManager.getInstance().getCookie(this.l);
      }
    } while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("pt4_token=")) && (!((String)localObject1).contains("pt4_token=;")));
    label514:
    label564:
    this.jdField_a_of_type_Long |= 0x40;
    label647:
    label666:
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
        QLog.i("SwiftBrowserCookieMonster", 1, npn.c("skey=" + jdField_a_of_type_JavaLangString, new String[0]));
        localObject1 = localTicketManager.getLocalTicket(str, 4096);
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
                  localObject1 = this.jdField_a_of_type_Nko.d(this.l);
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
                  localObject1 = this.jdField_a_of_type_Nko.e(this.l);
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
                      this.f = localTicketManager.getPskey(str, this.jdField_a_of_type_Nko.d(this.l));
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
                      QLog.i("SwiftBrowserCookieMonster", 1, npn.c("skey=" + jdField_a_of_type_JavaLangString, new String[0]));
                    }
                    for (;;)
                    {
                      paramString = localTicketManager.getLocalTicket(str, 4096);
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
                      this.g = b(paramAppRuntime, this.jdField_a_of_type_Nko.e(this.l));
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
  void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 984	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Boolean	Z
    //   6: ifne +46 -> 52
    //   9: aload_0
    //   10: getfield 61	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   13: ldc_w 986
    //   16: invokevirtual 640	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19: ifeq +36 -> 55
    //   22: aload_0
    //   23: ldc_w 988
    //   26: putfield 990	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   29: aload_0
    //   30: ldc 217
    //   32: putfield 619	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   35: aload_0
    //   36: ldc 217
    //   38: putfield 872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   41: aload_0
    //   42: ldc 217
    //   44: putfield 617	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 984	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Boolean	Z
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 61	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   60: invokestatic 991	npn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 990	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 88	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Nko	Lnko;
    //   71: aload_0
    //   72: getfield 61	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   75: invokevirtual 993	nko:f	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 88	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Nko	Lnko;
    //   86: aload_0
    //   87: getfield 61	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   90: invokevirtual 968	nko:d	(Ljava/lang/String;)Ljava/lang/String;
    //   93: putfield 617	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 88	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Nko	Lnko;
    //   101: aload_0
    //   102: getfield 61	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   105: invokevirtual 978	nko:e	(Ljava/lang/String;)Ljava/lang/String;
    //   108: putfield 619	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   111: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -67 -> 47
    //   117: ldc 171
    //   119: iconst_2
    //   120: new 117	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 995
    //   130: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 990	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   137: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 997
    //   143: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 617	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   150: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 999
    //   156: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: getfield 619	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   163: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 1001
    //   169: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: getfield 872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   176: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
          label225:
          Iterator localIterator;
          label264:
          String str;
          if (QLog.isColorLevel()) {
            QLog.w("SwiftBrowserCookieMonster", 2, "Super key hash failed:" + paramAppRuntime.getMessage());
          }
          this.jdField_a_of_type_Long |= 0x4;
        }
      }
      paramAppRuntime = a("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, a("superkey", jdField_b_of_type_JavaLangString, "ptlogin2.qq.com", true));
      paramCookiesMap.addCookie(paramAppRuntime, a("supertoken", c, "ptlogin2.qq.com", false));
      paramCookiesMap.addCookie(a("ptlogin2.qq.com", false), a("superkey", jdField_b_of_type_JavaLangString, "ptlogin2.qq.com", true));
      if (!TextUtils.isEmpty(this.h))
      {
        if (TextUtils.isEmpty(e)) {
          break label385;
        }
        paramAppRuntime = a("a2", e, this.h, true);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
        a(paramCookiesMap, this.l, this.h);
      }
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        break label415;
      }
      localIterator = this.jdField_a_of_type_Nko.a("skey").iterator();
      if (!localIterator.hasNext()) {
        break label425;
      }
      paramAppRuntime = (String)localIterator.next();
      str = a(paramAppRuntime, true);
      if (!QzoneConfig.isNeedSecureVerifyAllBusiness()) {
        break label400;
      }
    }
    label385:
    label400:
    for (paramAppRuntime = a("skey", jdField_a_of_type_JavaLangString, paramAppRuntime);; paramAppRuntime = a("skey", jdField_a_of_type_JavaLangString, paramAppRuntime, false))
    {
      paramCookiesMap.addCookie(str, paramAppRuntime);
      break label264;
      this.jdField_a_of_type_Long |= 0x2;
      break;
      this.jdField_a_of_type_Long |= 0x10;
      break label225;
    }
    label415:
    this.jdField_a_of_type_Long |= 1L;
    label425:
    return true;
  }
  
  @Deprecated
  public void f()
  {
    c();
    SwiftBrowserCookieMonster.CookiesMap localCookiesMap = new SwiftBrowserCookieMonster.CookiesMap();
    a(localCookiesMap, null);
    b(localCookiesMap);
    a(localCookiesMap, true);
    jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster
 * JD-Core Version:    0.7.0.1
 */