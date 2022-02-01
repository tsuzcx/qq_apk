package com.tencent.mobileqq.webview.swift.component;

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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.cookie.IBrowserCookieInjector;
import com.tencent.mobileqq.webview.cookie.SetCookiesCallback;
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
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

public class SwiftBrowserCookieMonster
{
  private static final LruCache<String, SwiftBrowserCookieMonster> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  public static volatile SwiftBrowserCookieMonster.TicketRefreshListener a;
  public static volatile String a;
  public static final AtomicInteger a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static volatile String b;
  public static volatile String c;
  public static volatile String d;
  public static volatile String e;
  long jdField_a_of_type_Long = 0L;
  public final AuthorizeConfig a;
  private ArrayList<IBrowserCookieInjector> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  final ConcurrentHashMap<String, CopyOnWriteArrayList<SetCookiesCallback>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
      CookieSyncManager.createInstance(MobileQQ.getContext());
    }
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, this);
    e();
    h();
  }
  
  /* Error */
  public static SwiftBrowserCookieMonster a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 103	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +34 -> 46
    //   15: getstatic 44	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   18: aload_2
    //   19: invokevirtual 113	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: ifnonnull +12 -> 41
    //   32: new 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 115	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:<init>	(Ljava/lang/String;)V
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
  
  static void a(List<String> paramList, SwiftPreloadCookieManager paramSwiftPreloadCookieManager)
  {
    ThreadManager.post(new SwiftBrowserCookieMonster.5(paramList, paramSwiftPreloadCookieManager), 5, null, false);
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
          localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
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
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    int m = 1;
    int n = 1;
    int i1 = 0;
    String str = null;
    if (paramAppRuntime != null) {}
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if (!paramAppRuntime.isLogin()) {
          break label539;
        }
        if (paramIntent != null)
        {
          m = n;
          if (paramIntent.getBooleanExtra("avoidLoginWeb", false)) {
            m = 0;
          }
          str = paramIntent.getStringExtra("url");
        }
        if (m != 0)
        {
          if (!TextUtils.isEmpty(str)) {
            break label521;
          }
          localObject1 = AuthorizeConfig.a();
          paramIntent = (TicketManager)paramAppRuntime.getManager(2);
          str = paramAppRuntime.getAccount();
          Object localObject3 = ((AuthorizeConfig)localObject1).a("pt4_token");
          localObject2 = new SwiftPreloadCookieManager(paramAppRuntime.getAppRuntime("modular_web"));
          localObject1 = ((SwiftPreloadCookieManager)localObject2).a("p_skey");
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("SwiftBrowserCookieMonster", 2, "p_skey top hosts: " + TextUtils.join(", ", (Iterable)localObject1));
            }
            a((List)localObject1, (SwiftPreloadCookieManager)localObject2);
            if (localObject3 != null)
            {
              m = ((Set)localObject3).size();
              if (localObject1 == null) {
                break label358;
              }
              n = ((List)localObject1).size();
              localObject2 = new String[n + m];
              m = i1;
              if (localObject3 == null) {
                break label363;
              }
              m = i1;
              if (((Set)localObject3).size() <= 0) {
                break label363;
              }
              localObject3 = ((Set)localObject3).iterator();
              m = 0;
              if (!((Iterator)localObject3).hasNext()) {
                break label363;
              }
              localObject2[m] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
              m += 1;
              continue;
            }
          }
          else
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("SwiftBrowserCookieMonster", 2, "no any top hosts for p_skey");
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramAppRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftBrowserCookieMonster", 2, "preGetKey exception:" + paramAppRuntime.toString());
        }
        paramAppRuntime.printStackTrace();
      }
      m = 0;
      continue;
      label358:
      n = 0;
      continue;
      label363:
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2[m] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), (String)((Iterator)localObject1).next() });
          m += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "now preGetPskey and pt4Token: " + TextUtils.join(",", (Object[])localObject2));
      }
      paramIntent.getPskey(str, 16L, (String[])localObject2, new SwiftBrowserCookieMonster.4());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "Batch load pt4_token when process preload");
      }
      for (;;)
      {
        a(paramAppRuntime);
        return;
        label521:
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserCookieMonster", 2, "Get tickets when load url");
        }
      }
      label539:
      m = 0;
    }
  }
  
  public static boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("https://aq.qq.com/"))
    {
      paramCookiesMap.addCookie(paramString1, a("dvid1", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      paramString2 = DeviceInfoUtil.a();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid5", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      }
      paramString2 = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid4", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid2", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.b(BaseApplication.getContext());
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
      Object localObject1 = (TicketManager)paramAppRuntime.getManager(2);
      long l1 = System.currentTimeMillis();
      Object localObject2 = paramAppRuntime.getAccount();
      String str = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), paramString });
      SwiftBrowserCookieMonster.8 local8 = new SwiftBrowserCookieMonster.8(paramString, l1);
      localObject2 = ((TicketManager)localObject1).getPskey((String)localObject2, 16L, new String[] { str }, local8);
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((Ticket)localObject2).getPt4Token(paramString);
      }
      new SwiftPreloadCookieManager(paramAppRuntime.getAppRuntime("modular_web")).a(paramString, "pt4_token");
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label213;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache success for " + paramString + ", token is: " + Util.c(new StringBuilder().append("pt4_token=").append((String)localObject1).toString(), new String[0]));
      }
      while (localObject1 != null)
      {
        return localObject1;
        label213:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache failed for " + paramString);
      }
      return "";
    }
    return "";
  }
  
  public static void b(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    ThreadManager.postImmediately(new SwiftBrowserCookieMonster.6(paramAppRuntime, paramIntent), new SwiftBrowserCookieMonster.7(), false);
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
          bool2 = MobileQQ.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("ptlogin_flag" + paramAppRuntime.getAccount(), false);
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
    //   1: invokestatic 530	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +201 -> 207
    //   9: getstatic 203	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   12: aconst_null
    //   13: invokevirtual 207	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +144 -> 164
    //   23: aload 4
    //   25: invokevirtual 227	mqq/app/AppRuntime:isLogin	()Z
    //   28: ifeq +136 -> 164
    //   31: aload 4
    //   33: invokevirtual 534	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   36: invokevirtual 538	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   39: invokestatic 84	com/tencent/smtt/sdk/CookieSyncManager:createInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   42: pop
    //   43: invokestatic 544	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   46: aload_0
    //   47: invokevirtual 547	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: astore_2
    //   53: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +55 -> 111
    //   59: ldc 176
    //   61: iconst_2
    //   62: new 122	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 549
    //   72: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: iconst_0
    //   77: anewarray 117	java/lang/String
    //   80: invokestatic 479	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   83: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 551
    //   89: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: iconst_0
    //   94: anewarray 117	java/lang/String
    //   97: invokestatic 553	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_1
    //   110: astore_2
    //   111: aload_3
    //   112: aload 4
    //   114: aload_2
    //   115: invokevirtual 555	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:c	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   118: areturn
    //   119: astore_0
    //   120: ldc_w 483
    //   123: astore_1
    //   124: ldc 176
    //   126: iconst_1
    //   127: new 122	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 557
    //   137: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 560	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 562
    //   150: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_1
    //   160: astore_2
    //   161: goto -50 -> 111
    //   164: ldc 176
    //   166: iconst_1
    //   167: new 122	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 564
    //   177: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: iconst_0
    //   182: anewarray 117	java/lang/String
    //   185: invokestatic 553	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   188: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 566
    //   194: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: ldc_w 483
    //   206: areturn
    //   207: ldc 176
    //   209: iconst_1
    //   210: new 122	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 564
    //   220: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: iconst_0
    //   225: anewarray 117	java/lang/String
    //   228: invokestatic 553	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   231: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 566
    //   237: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: ldc_w 483
    //   249: areturn
    //   250: astore_0
    //   251: goto -127 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramString	String
    //   50	110	1	str1	String
    //   52	109	2	str2	String
    //   4	108	3	localSwiftBrowserCookieMonster	SwiftBrowserCookieMonster
    //   16	97	4	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   31	51	119	java/lang/Throwable
    //   53	109	250	java/lang/Throwable
  }
  
  private void c(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((IBrowserCookieInjector)localIterator.next()).a(this.l);
      if (!TextUtils.isEmpty(str)) {
        paramCookiesMap.addCookie(this.l, str);
      }
    }
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
    jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$TicketRefreshListener = null;
    QLog.i("SwiftBrowserCookieMonster", 1, "resetAllKeyAndCache");
  }
  
  static void e()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$TicketRefreshListener == null) {
      ThreadManager.postImmediately(new SwiftBrowserCookieMonster.9(), null, false);
    }
  }
  
  private void h()
  {
    try
    {
      if (SwiftBrowserCookieInjectorUtil.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = SwiftBrowserCookieInjectorUtil.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          IBrowserCookieInjector localIBrowserCookieInjector = (IBrowserCookieInjector)((Class)localIterator.next()).newInstance();
          this.jdField_a_of_type_JavaUtilArrayList.add(localIBrowserCookieInjector);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftBrowserCookieMonster", 1, "registerBrowserCookieInjectors Fail,", localThrowable);
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
      c(paramIntent);
      return paramIntent;
      bool = false;
      break;
      a(paramIntent, paramAppRuntime);
    }
  }
  
  String a(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject = paramString;
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SwiftBrowserCookieMonster", 2, "Cookies is wrong, now do ptlogin jumping!");
      }
      if (TextUtils.isEmpty(d)) {
        break label187;
      }
      boolean bool = b(paramAppRuntime);
      StringBuilder localStringBuilder = new StringBuilder("http");
      if (!bool) {
        break label165;
      }
      localObject = "s";
      localStringBuilder = localStringBuilder.append((String)localObject).append("://");
      if (!bool) {
        break label173;
      }
      localObject = "ssl.";
      label84:
      localObject = localStringBuilder.append((String)localObject).append("ptlogin2.qq.com/jump?clientuin=").append(paramAppRuntime.getAccount()).append("&clientkey=").append(d).append("&keyindex=19&pt_mq=");
      if (!paramString.startsWith("https://s.p.qq.com")) {
        break label181;
      }
    }
    label165:
    label173:
    label181:
    for (paramAppRuntime = "1";; paramAppRuntime = "0")
    {
      localObject = paramAppRuntime + "&u1=" + URLEncoder.encode(paramString);
      return localObject;
      localObject = "";
      break;
      localObject = "";
      break label84;
    }
    label187:
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
      new SwiftPreloadCookieManager(paramAppRuntime.getAppRuntime("modular_web")).a(paramString, "p_skey");
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty(str)) {
          break label130;
        }
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("Get p_skey success for ").append(paramString).append(Util.c(" p_skey=" + str, new String[0]));
        QLog.d("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
      }
      while (str != null)
      {
        return str;
        label130:
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
  
  public void a(SetCookiesCallback paramSetCookiesCallback)
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
  
  void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    String str = PropertiesUtils.a(MobileQQ.getContext(), "key_local_cache", "0");
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
    String str = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis() + 10000L));
    localObject = this.l;
    if (paramAppRuntime == null) {}
    for (paramAppRuntime = "login_key_set_failed=NullRuntime; EXPIRES=" + str + ";";; paramAppRuntime = "login_key_set_failed=AlreadyLogout; EXPIRES=" + str + ";")
    {
      paramCookiesMap.addCookie((String)localObject, paramAppRuntime);
      a(paramCookiesMap, this.l, "aq.qq.com");
      return;
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
        CookieSyncManager.createInstance(MobileQQ.sMobileQQ);
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
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
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
      localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("pskey").iterator();
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
  
  public boolean a(String paramString, SetCookiesCallback paramSetCookiesCallback, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
    {
      if (paramAppRuntime == null)
      {
        localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject1 = a(paramString, (AppRuntime)localObject1);
        if (paramSetCookiesCallback == null) {
          break label328;
        }
        if (this.jdField_a_of_type_Long > 0L)
        {
          g();
          QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, errorCode: " + this.jdField_a_of_type_Long);
        }
        localObject2 = CookieManager.getInstance().getCookie(paramString);
        if (((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).contains("skey="))) && ((!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString)) && (!a((String)localObject2)))) {
          break label182;
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
        label182:
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
    label328:
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
    paramString = new SwiftBrowserCookieMonster.1(this, paramAppRuntime, paramIntent);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      CookieSyncManager.createInstance(MobileQQ.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "post thread to set all cookies");
      }
      ThreadManager.postImmediately(paramString, new SwiftBrowserCookieMonster.2(this), false);
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
  
  boolean b(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(this.k)) && (TextUtils.isEmpty(this.f)))
    {
      this.f = a(paramAppRuntime, this.k);
      StringBuilder localStringBuilder = new StringBuilder().append(this.k).append(": pSkey is miss and fetch result is ");
      if (TextUtils.isEmpty(this.f))
      {
        localObject = "fail";
        QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject);
        label84:
        if ((!TextUtils.isEmpty(this.i)) && (TextUtils.isEmpty(this.g)))
        {
          this.g = b(paramAppRuntime, this.i);
          localObject = new StringBuilder().append(this.i).append(": pt4Token is miss and fetch result is ");
          if (!TextUtils.isEmpty(this.g)) {
            break label458;
          }
          paramAppRuntime = "fail";
          QLog.i("SwiftBrowserCookieMonster", 1, paramAppRuntime);
        }
        label151:
        if (TextUtils.isEmpty(this.k)) {
          break label703;
        }
        if (TextUtils.isEmpty(this.f)) {
          break label515;
        }
        if ((this.l == null) || (!QzoneConfig.isNeedSecureVerifyAllBusiness()) || (!this.l.contains("qzone.qq.com"))) {
          break label465;
        }
        paramAppRuntime = a("p_skey", this.f, this.k);
        label226:
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
        if ((this.l == null) || (!this.l.contains("http://")) || (!this.l.contains("qzone.qq.com"))) {
          break label703;
        }
        paramCookiesMap.addCookie(this.l.replace("http", "https"), paramAppRuntime);
        paramAppRuntime = null;
      }
    }
    for (;;)
    {
      label288:
      if (!TextUtils.isEmpty(this.i))
      {
        if (TextUtils.isEmpty(this.g)) {
          break label616;
        }
        if (!QzoneConfig.isNeedSecureVerifyAllBusiness()) {
          break label598;
        }
        paramAppRuntime = a("pt4_token", this.g, this.i);
        label328:
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
      }
      label458:
      label465:
      label598:
      label616:
      do
      {
        if ((!TextUtils.isEmpty(this.k)) && (this.k.equals("docs.qq.com")))
        {
          paramAppRuntime = a("tdsourcetag", "s_qq_c2c_chatfiles", this.k, false);
          paramCookiesMap.addCookie(this.l, paramAppRuntime);
        }
        return true;
        localObject = "success";
        break;
        if (!QLog.isColorLevel()) {
          break label84;
        }
        QLog.d("SwiftBrowserCookieMonster", 1, this.k + Util.c(new StringBuilder().append(" p_skey=").append(this.f).toString(), new String[0]));
        break label84;
        paramAppRuntime = "success";
        break label151;
        if ((this.l != null) && (QzoneConfig.isNeedSecureVerifyAllBusiness()))
        {
          paramAppRuntime = a("p_skey", this.f, this.k);
          break label226;
        }
        paramAppRuntime = a("p_skey", this.f, this.k, false);
        break label226;
        localObject = CookieManager.getInstance().getCookie(this.l);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("p_skey=")))
        {
          paramAppRuntime = (AppRuntime)localObject;
          if (!((String)localObject).contains("p_skey=;")) {
            break label288;
          }
        }
        this.jdField_a_of_type_Long |= 0x20;
        QLog.e("SwiftBrowserCookieMonster", 1, this.k + ": get pSkey fail!");
        return false;
        paramAppRuntime = a("pt4_token", this.g, this.i, false);
        break label328;
        localObject = paramAppRuntime;
        if (paramAppRuntime == null) {
          localObject = CookieManager.getInstance().getCookie(this.l);
        }
      } while ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("pt4_token=")) && (!((String)localObject).contains("pt4_token=;")));
      label515:
      this.jdField_a_of_type_Long |= 0x40;
      QLog.e("SwiftBrowserCookieMonster", 1, this.i + ": get pt4Token fail!");
      return false;
      label703:
      paramAppRuntime = null;
    }
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
          break label496;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, Util.c("skey=" + jdField_a_of_type_JavaLangString, new String[0]));
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
      label258:
      boolean bool2;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_skey=;")))
      {
        if (!QLog.isColorLevel()) {
          break label1398;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pskey");
        bool2 = false;
      }
      for (;;)
      {
        label293:
        boolean bool3;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pt4_token=;")))
        {
          if (!QLog.isColorLevel()) {
            break label1392;
          }
          QLog.d("SwiftBrowserCookieMonster", 2, "not need set pt4_token");
          bool3 = false;
        }
        label903:
        label1042:
        for (;;)
        {
          label328:
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
                    break label926;
                  }
                  ((StringBuilder)localObject1).append((String)localObject3);
                }
                for (;;)
                {
                  m += 1;
                  break label445;
                  localObject1 = "success";
                  break;
                  label496:
                  QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                  break label192;
                  if (paramString.contains("skey=;"))
                  {
                    if (!QLog.isColorLevel()) {
                      break label1404;
                    }
                    QLog.d("SwiftBrowserCookieMonster", 2, "not need set skey");
                    bool1 = false;
                    break label258;
                  }
                  if (!paramString.contains("skey=")) {
                    break label1404;
                  }
                  bool1 = true;
                  break label258;
                  localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(this.l);
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label1398;
                  }
                  if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("p_skey=")))
                  {
                    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_uin=;")))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uin");
                      }
                      label625:
                      if (TextUtils.isEmpty(this.f))
                      {
                        this.f = localTicketManager.getPskey(str, (String)localObject1);
                        localObject3 = new StringBuilder().append("getCookie4WebSo: pSkey is miss and fetch result is ");
                        if (!TextUtils.isEmpty(this.f)) {
                          break label756;
                        }
                      }
                    }
                    label756:
                    for (localObject1 = "fail";; localObject1 = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject1);
                      a((StringBuilder)localObject2, this.f, "p_skey=", "");
                      bool2 = false;
                      break;
                      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_uin="))) {
                        break label625;
                      }
                      a((StringBuilder)localObject2);
                      ((StringBuilder)localObject2).append("p_uin=").append((String)localObject3);
                      break label625;
                    }
                  }
                  if (!paramString.contains("p_skey=")) {
                    break label1398;
                  }
                  bool2 = true;
                  break label293;
                  localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l);
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label1392;
                  }
                  if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("pt4_token=")))
                  {
                    if (TextUtils.isEmpty(this.g))
                    {
                      this.g = b(paramAppRuntime, (String)localObject1);
                      localObject1 = new StringBuilder().append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.g)) {
                        break label903;
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
                    break label1392;
                  }
                  bool3 = true;
                  break label328;
                  a((StringBuilder)localObject1);
                  if ((((String)localObject3).startsWith("p_skey=")) && (bool2))
                  {
                    if (TextUtils.isEmpty(this.f))
                    {
                      this.f = localTicketManager.getPskey(str, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(this.l));
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: pSkey is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.f)) {
                        break label1042;
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
                        label1114:
                        QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      }
                    }
                    else
                    {
                      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
                        break label1242;
                      }
                      QLog.i("SwiftBrowserCookieMonster", 1, Util.c("skey=" + jdField_a_of_type_JavaLangString, new String[0]));
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
                      break label1114;
                      label1242:
                      QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                    }
                  }
                  if ((((String)localObject3).startsWith("pt4_token=")) && (bool3))
                  {
                    if (TextUtils.isEmpty(this.g))
                    {
                      this.g = b(paramAppRuntime, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l));
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.g)) {
                        break label1360;
                      }
                    }
                    label1360:
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
          label445:
          for (paramAppRuntime = (AppRuntime)localObject1;; paramAppRuntime = (AppRuntime)localObject2) {
            return paramAppRuntime.toString();
          }
          label926:
          label1392:
          bool3 = false;
        }
        label1398:
        bool2 = false;
      }
      label1404:
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
    //   3: getfield 979	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Boolean	Z
    //   6: ifne +49 -> 55
    //   9: aload_0
    //   10: getfield 68	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   13: ldc_w 981
    //   16: invokevirtual 644	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19: ifeq +39 -> 58
    //   22: aload_0
    //   23: ldc_w 983
    //   26: putfield 985	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   29: aload_0
    //   30: ldc_w 483
    //   33: putfield 884	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   36: aload_0
    //   37: ldc_w 483
    //   40: putfield 870	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   43: aload_0
    //   44: ldc_w 483
    //   47: putfield 800	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 979	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_Boolean	Z
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 68	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   63: invokestatic 986	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   66: putfield 985	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 91	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   74: aload_0
    //   75: getfield 68	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   78: invokevirtual 988	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 870	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 91	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   89: aload_0
    //   90: getfield 68	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   93: invokevirtual 963	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;)Ljava/lang/String;
    //   96: putfield 800	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 91	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   104: aload_0
    //   105: getfield 68	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:l	Ljava/lang/String;
    //   108: invokevirtual 973	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 884	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   114: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -67 -> 50
    //   120: ldc 176
    //   122: iconst_2
    //   123: new 122	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 990
    //   133: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 985	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:j	Ljava/lang/String;
    //   140: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 992
    //   146: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: getfield 800	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:k	Ljava/lang/String;
    //   153: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 994
    //   159: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 884	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:i	Ljava/lang/String;
    //   166: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 996
    //   172: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: getfield 870	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:h	Ljava/lang/String;
    //   179: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -138 -> 50
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	SwiftBrowserCookieMonster
    //   191	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	191	finally
    //   50	55	191	finally
    //   58	188	191	finally
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
      localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster
 * JD-Core Version:    0.7.0.1
 */