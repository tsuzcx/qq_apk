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
  
  public static SwiftBrowserCookieMonster a(String paramString)
  {
    try
    {
      String str = b(paramString);
      if (!TextUtils.isEmpty(str))
      {
        SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = (SwiftBrowserCookieMonster)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
        paramString = localSwiftBrowserCookieMonster;
        if (localSwiftBrowserCookieMonster == null) {
          paramString = new SwiftBrowserCookieMonster(str);
        }
        return paramString;
      }
      return null;
    }
    finally {}
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
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("o");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
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
      if (paramStringBuilder.toString().endsWith(";"))
      {
        paramStringBuilder.append(" ");
        return;
      }
      if (!paramStringBuilder.toString().endsWith("; ")) {
        paramStringBuilder.append("; ");
      }
    }
  }
  
  static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      a(paramStringBuilder);
      paramStringBuilder.append(paramString2);
      paramStringBuilder.append(paramString1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("is empty");
      QLog.d("SwiftBrowserCookieMonster", 2, paramString1.toString());
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      a(paramStringBuilder);
      paramStringBuilder.append(paramString2);
      paramStringBuilder.append(paramString3);
    }
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
        return;
      }
      synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        for (;;)
        {
          m = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
          if (2 != m) {
            break;
          }
          try
          {
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        return;
      }
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    if (paramAppRuntime != null) {}
    for (;;)
    {
      try
      {
        if (!paramAppRuntime.isLogin()) {
          break label554;
        }
        if (paramIntent == null) {
          continue;
        }
        boolean bool = paramIntent.getBooleanExtra("avoidLoginWeb", false) ^ true;
        paramIntent = paramIntent.getStringExtra("url");
        if (!bool) {
          continue;
        }
        if (TextUtils.isEmpty(paramIntent))
        {
          Object localObject1 = AuthorizeConfig.a();
          paramIntent = (TicketManager)paramAppRuntime.getManager(2);
          String str = paramAppRuntime.getAccount();
          Object localObject3 = ((AuthorizeConfig)localObject1).a("pt4_token");
          Object localObject2 = new SwiftPreloadCookieManager(paramAppRuntime.getAppRuntime("modular_web"));
          localObject1 = ((SwiftPreloadCookieManager)localObject2).a("p_skey");
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("p_skey top hosts: ");
              localStringBuilder.append(TextUtils.join(", ", (Iterable)localObject1));
              QLog.i("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
            }
            a((List)localObject1, (SwiftPreloadCookieManager)localObject2);
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("SwiftBrowserCookieMonster", 2, "no any top hosts for p_skey");
          }
          if (localObject3 == null) {
            break label561;
          }
          m = ((Set)localObject3).size();
          if (localObject1 == null) {
            break label566;
          }
          n = ((List)localObject1).size();
          localObject2 = new String[m + n];
          if ((localObject3 == null) || (((Set)localObject3).size() <= 0)) {
            break label571;
          }
          localObject3 = ((Set)localObject3).iterator();
          m = 0;
          n = m;
          if (((Iterator)localObject3).hasNext())
          {
            localObject2[m] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
            m += 1;
            continue;
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2[n] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), (String)((Iterator)localObject1).next() });
              n += 1;
              continue;
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("now preGetPskey and pt4Token: ");
            ((StringBuilder)localObject1).append(TextUtils.join(",", (Object[])localObject2));
            QLog.i("SwiftBrowserCookieMonster", 2, ((StringBuilder)localObject1).toString());
          }
          paramIntent.getPskey(str, 16L, (String[])localObject2, new SwiftBrowserCookieMonster.4());
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserCookieMonster", 2, "Batch load pt4_token when process preload");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserCookieMonster", 2, "Get tickets when load url");
        }
        a(paramAppRuntime);
        return;
      }
      catch (Exception paramIntent)
      {
        continue;
      }
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("preGetKey exception:");
        paramAppRuntime.append(paramIntent.toString());
        QLog.e("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
      }
      paramIntent.printStackTrace();
      return;
      paramIntent = null;
      int m = 1;
      continue;
      label554:
      paramIntent = null;
      m = 0;
      continue;
      label561:
      m = 0;
      continue;
      label566:
      int n = 0;
      continue;
      label571:
      n = 0;
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
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.postImmediately(paramAppRuntime, null, false);
        return true;
      }
      paramAppRuntime.run();
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject1 = Uri.parse(paramString);
        localObject2 = ((Uri)localObject1).getScheme();
        if ((("http".equals(localObject2)) || ("https".equals(localObject2))) && (((Uri)localObject1).isHierarchical()))
        {
          localObject1 = a(((Uri)localObject1).getHost(), "http".equals(localObject2));
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getCookieHost[");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("] error:");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject2).toString());
      }
    }
    return null;
  }
  
  public static String b(AppRuntime paramAppRuntime, String paramString)
  {
    String str1 = "";
    Object localObject2 = str1;
    if (paramAppRuntime != null)
    {
      localObject2 = str1;
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject1 = (TicketManager)paramAppRuntime.getManager(2);
        long l1 = System.currentTimeMillis();
        localObject2 = paramAppRuntime.getAccount();
        String str2 = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), paramString });
        SwiftBrowserCookieMonster.8 local8 = new SwiftBrowserCookieMonster.8(paramString, l1);
        localObject1 = ((TicketManager)localObject1).getPskey((String)localObject2, 16L, new String[] { str2 }, local8);
        if (localObject1 != null) {
          localObject1 = ((Ticket)localObject1).getPt4Token(paramString);
        } else {
          localObject1 = null;
        }
        new SwiftPreloadCookieManager(paramAppRuntime.getAppRuntime("modular_web")).a(paramString, "pt4_token");
        if (QLog.isColorLevel()) {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("Get pt4_token cache success for ");
            paramAppRuntime.append(paramString);
            paramAppRuntime.append(", token is: ");
            paramString = new StringBuilder();
            paramString.append("pt4_token=");
            paramString.append((String)localObject1);
            paramAppRuntime.append(Util.c(paramString.toString(), new String[0]));
            QLog.d("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
          }
          else
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("Get pt4_token cache failed for ");
            paramAppRuntime.append(paramString);
            QLog.d("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
          }
        }
        localObject2 = str1;
        if (localObject1 != null) {
          localObject2 = localObject1;
        }
      }
    }
    return localObject2;
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
    int m = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (m >= 11)
    {
      bool1 = bool2;
      if (paramAppRuntime != null)
      {
        bool1 = bool2;
        if (paramAppRuntime.isLogin())
        {
          Object localObject = MobileQQ.getContext().getSharedPreferences("mobileQQ", 4);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ptlogin_flag");
          localStringBuilder.append(paramAppRuntime.getAccount());
          bool2 = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("account: ");
            ((StringBuilder)localObject).append(paramAppRuntime.getAccount());
            ((StringBuilder)localObject).append(", mPtloginFlag: ");
            ((StringBuilder)localObject).append(bool2);
            QLog.d("SwiftBrowserCookieMonster", 2, ((StringBuilder)localObject).toString());
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public static String c(String paramString)
  {
    SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = a(paramString);
    Object localObject2 = "";
    if (localSwiftBrowserCookieMonster != null)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localAppRuntime != null) && (localAppRuntime.isLogin()))
      {
        localObject1 = localObject2;
        Object localObject3;
        try
        {
          CookieSyncManager.createInstance(localAppRuntime.getApplication().getApplicationContext());
          localObject1 = localObject2;
          localObject2 = CookieManager.getInstance().getCookie(paramString);
          localObject1 = localObject2;
          localObject3 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject2;
            localObject3 = new StringBuilder();
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append("Get cookie:");
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append(Util.c((String)localObject2, new String[0]));
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append(" from ");
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append(Util.b(paramString, new String[0]));
            localObject1 = localObject2;
            QLog.d("SwiftBrowserCookieMonster", 2, ((StringBuilder)localObject3).toString());
            localObject3 = localObject2;
          }
        }
        catch (Throwable paramString)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getCookie4WebSoOrSonic error:");
          ((StringBuilder)localObject2).append(paramString.getMessage());
          ((StringBuilder)localObject2).append(".");
          QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject2).toString());
          localObject3 = localObject1;
        }
        return localSwiftBrowserCookieMonster.c(localAppRuntime, (String)localObject3);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getCookie4WebSoOrSonic error:get cookieMonster fail, url=[");
      ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
      ((StringBuilder)localObject1).append("].");
      QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject1).toString());
      return "";
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getCookie4WebSoOrSonic error:get cookieMonster fail, url=[");
    ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
    ((StringBuilder)localObject1).append("].");
    QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject1).toString());
    return "";
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
    paramIntent = new SwiftBrowserCookieMonster.CookiesMap();
    if (!a(paramIntent, paramAppRuntime)) {
      QLog.e("SwiftBrowserCookieMonster", 1, "setCookies error: collectUinRelatedCookies return false.");
    }
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin()))
    {
      this.jdField_b_of_type_Boolean = (b(paramIntent, paramAppRuntime) ^ true);
      c(paramIntent, paramAppRuntime);
    }
    else
    {
      a(paramIntent, paramAppRuntime);
    }
    a(paramIntent);
    c(paramIntent);
    return paramIntent;
  }
  
  String a(String paramString, AppRuntime paramAppRuntime)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SwiftBrowserCookieMonster", 2, "Cookies is wrong, now do ptlogin jumping!");
      }
      if (!TextUtils.isEmpty(d))
      {
        boolean bool = b(paramAppRuntime);
        StringBuilder localStringBuilder = new StringBuilder("http");
        String str2 = "";
        if (bool) {
          str1 = "s";
        } else {
          str1 = "";
        }
        localStringBuilder.append(str1);
        localStringBuilder.append("://");
        String str1 = str2;
        if (bool) {
          str1 = "ssl.";
        }
        localStringBuilder.append(str1);
        localStringBuilder.append("ptlogin2.qq.com/jump?clientuin=");
        localStringBuilder.append(paramAppRuntime.getAccount());
        localStringBuilder.append("&clientkey=");
        localStringBuilder.append(d);
        localStringBuilder.append("&keyindex=19&pt_mq=");
        if (paramString.startsWith("https://s.p.qq.com")) {
          paramAppRuntime = "1";
        } else {
          paramAppRuntime = "0";
        }
        localStringBuilder.append(paramAppRuntime);
        localStringBuilder.append("&u1=");
        localStringBuilder.append(URLEncoder.encode(paramString));
        return localStringBuilder.toString();
      }
      if (QLog.isColorLevel()) {
        QLog.w("SwiftBrowserCookieMonster", 2, "Can't do ptlogin jumping because STwxWeb is empty!");
      }
      this.jdField_a_of_type_Long |= 0x8;
    }
    return paramString;
  }
  
  String a(AppRuntime paramAppRuntime, String paramString)
  {
    String str1 = "";
    Object localObject = str1;
    if (paramAppRuntime != null)
    {
      localObject = str1;
      if (!TextUtils.isEmpty(paramString))
      {
        String str2 = ((TicketManager)paramAppRuntime.getManager(2)).getPskey(paramAppRuntime.getAccount(), paramString);
        new SwiftPreloadCookieManager(paramAppRuntime.getAppRuntime("modular_web")).a(paramString, "p_skey");
        if (QLog.isColorLevel()) {
          if (!TextUtils.isEmpty(str2))
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("Get p_skey success for ");
            paramAppRuntime.append(paramString);
            paramString = new StringBuilder();
            paramString.append(" p_skey=");
            paramString.append(str2);
            paramAppRuntime.append(Util.c(paramString.toString(), new String[0]));
            QLog.d("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
          }
          else
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("Get p_skey failed for ");
            paramAppRuntime.append(paramString);
            QLog.d("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
          }
        }
        localObject = str1;
        if (str2 != null) {
          localObject = str2;
        }
      }
    }
    return localObject;
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
    if ("0".equals(str))
    {
      QLog.e("SwiftBrowserCookieMonster", 1, "addLocaleIdCookie, localeIdStr = 0");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qq_locale_id=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(';');
    str = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addLocaleIdCookie, cookie = ");
      ((StringBuilder)localObject).append(str);
      QLog.d("SwiftBrowserCookieMonster", 2, ((StringBuilder)localObject).toString());
    }
    localObject = paramCookiesMap.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramCookiesMap.addCookie((String)((Iterator)localObject).next(), str);
    }
  }
  
  void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    String str1 = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis() + 10000L));
    String str2 = this.l;
    if (paramAppRuntime == null)
    {
      localObject = new StringBuilder();
      paramAppRuntime = "login_key_set_failed=NullRuntime; EXPIRES=";
    }
    else
    {
      localObject = new StringBuilder();
      paramAppRuntime = "login_key_set_failed=AlreadyLogout; EXPIRES=";
    }
    ((StringBuilder)localObject).append(paramAppRuntime);
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(";");
    paramCookiesMap.addCookie(str2, ((StringBuilder)localObject).toString());
    a(paramCookiesMap, this.l, "aq.qq.com");
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
    String str1;
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin())) {
      str1 = a(paramAppRuntime.getAccount());
    } else {
      str1 = "";
    }
    paramAppRuntime = a("ptlogin2.qq.com", true);
    paramCookiesMap.addCookie(paramAppRuntime, a("superuin", str1, "ptlogin2.qq.com", false));
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
    String str2;
    while (localIterator.hasNext())
    {
      paramAppRuntime = (String)localIterator.next();
      str2 = a(paramAppRuntime, true);
      if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {
        paramAppRuntime = a("uin", str1, paramAppRuntime);
      } else {
        paramAppRuntime = a("uin", str1, paramAppRuntime, false);
      }
      paramCookiesMap.addCookie(str2, paramAppRuntime);
      paramAppRuntime = str2;
    }
    localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("pskey").iterator();
    while (localIterator.hasNext())
    {
      paramAppRuntime = (String)localIterator.next();
      str2 = a(paramAppRuntime, true);
      if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {
        paramAppRuntime = a("p_uin", str1, paramAppRuntime);
      } else {
        paramAppRuntime = a("p_uin", str1, paramAppRuntime, false);
      }
      paramCookiesMap.addCookie(str2, paramAppRuntime);
      paramAppRuntime = str2;
    }
    if (TextUtils.isEmpty(str1))
    {
      this.jdField_a_of_type_Long |= 0x80;
      if (QLog.isColorLevel())
      {
        paramCookiesMap = new StringBuilder();
        paramCookiesMap.append("cookieUin isempty，url:");
        paramCookiesMap.append(paramAppRuntime);
        QLog.d("SwiftBrowserCookieMonster", 2, paramCookiesMap.toString());
      }
      return false;
    }
    return true;
  }
  
  boolean a(String paramString)
  {
    boolean bool4 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (!bool4)
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
      if (paramAppRuntime == null) {
        localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      } else {
        localObject1 = paramAppRuntime;
      }
      localObject1 = a(paramString, (AppRuntime)localObject1);
      if (paramSetCookiesCallback != null)
      {
        if (this.jdField_a_of_type_Long > 0L)
        {
          g();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("some cookie goes wrong, errorCode: ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
          QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject2).toString());
        }
        localObject2 = CookieManager.getInstance().getCookie(paramString);
        if (((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("skey="))) || ((!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString)) && (!a((String)localObject2))))
        {
          if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long <= 0L))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("hit cookie cache, just call onSetCookiesFinished ");
              paramString.append(Util.b((String)localObject1, new String[0]));
              paramString.append(", errorCode: ");
              paramString.append(this.jdField_a_of_type_Long);
              QLog.i("SwiftBrowserCookieMonster", 2, paramString.toString());
            }
            paramSetCookiesCallback.a((String)localObject1, null, this.jdField_a_of_type_Long);
            return true;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            paramString = new StringBuilder();
            paramString.append("cookie is wrong, need do jump ptlogin! ");
            paramString.append(Util.b((String)localObject1, new String[0]));
            QLog.i("SwiftBrowserCookieMonster", 1, paramString.toString());
          }
          paramSetCookiesCallback.a((String)localObject1, null, this.jdField_a_of_type_Long);
          b();
          return true;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("some cookie goes wrong, retry set cookie: ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("");
        QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject1).toString());
        a();
        a(paramString, paramSetCookiesCallback, paramAppRuntime, paramIntent);
        return true;
      }
    }
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
      if (QLog.isColorLevel())
      {
        paramSetCookiesCallback = new StringBuilder();
        paramSetCookiesCallback.append("now add callback for ");
        paramSetCookiesCallback.append(Util.b(paramString, new String[0]));
        QLog.i("SwiftBrowserCookieMonster", 2, paramSetCookiesCallback.toString());
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
    if (QLog.isColorLevel())
    {
      paramCookiesMap = new StringBuilder();
      paramCookiesMap.append(Util.b(this.l, new String[0]));
      paramCookiesMap.append(" forbidden login state, remove all login key");
      QLog.d("SwiftBrowserCookieMonster", 2, paramCookiesMap.toString());
    }
  }
  
  boolean b(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    boolean bool = TextUtils.isEmpty(this.k);
    String str = "fail";
    Object localObject2;
    Object localObject1;
    if ((!bool) && (TextUtils.isEmpty(this.f)))
    {
      this.f = a(paramAppRuntime, this.k);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.k);
      ((StringBuilder)localObject2).append(": pSkey is miss and fetch result is ");
      if (TextUtils.isEmpty(this.f)) {
        localObject1 = "fail";
      } else {
        localObject1 = "success";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject2).toString());
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.k);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" p_skey=");
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject1).append(Util.c(((StringBuilder)localObject2).toString(), new String[0]));
      QLog.d("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject1).toString());
    }
    if ((!TextUtils.isEmpty(this.i)) && (TextUtils.isEmpty(this.g)))
    {
      this.g = b(paramAppRuntime, this.i);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.i);
      ((StringBuilder)localObject1).append(": pt4Token is miss and fetch result is ");
      if (TextUtils.isEmpty(this.g)) {
        paramAppRuntime = str;
      } else {
        paramAppRuntime = "success";
      }
      ((StringBuilder)localObject1).append(paramAppRuntime);
      QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject1).toString());
    }
    str = null;
    paramAppRuntime = str;
    if (!TextUtils.isEmpty(this.k)) {
      if (!TextUtils.isEmpty(this.f))
      {
        if ((this.l != null) && (QzoneConfig.isNeedSecureVerifyAllBusiness()) && (this.l.contains("qzone.qq.com"))) {
          localObject1 = a("p_skey", this.f, this.k);
        } else if ((this.l != null) && (QzoneConfig.isNeedSecureVerifyAllBusiness())) {
          localObject1 = a("p_skey", this.f, this.k);
        } else {
          localObject1 = a("p_skey", this.f, this.k, false);
        }
        paramCookiesMap.addCookie(this.l, (String)localObject1);
        localObject2 = this.l;
        paramAppRuntime = str;
        if (localObject2 != null)
        {
          paramAppRuntime = str;
          if (((String)localObject2).contains("http://"))
          {
            paramAppRuntime = str;
            if (this.l.contains("qzone.qq.com"))
            {
              paramCookiesMap.addCookie(this.l.replace("http", "https"), (String)localObject1);
              paramAppRuntime = str;
            }
          }
        }
      }
      else
      {
        localObject1 = CookieManager.getInstance().getCookie(this.l);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("p_skey=")))
        {
          paramAppRuntime = (AppRuntime)localObject1;
          if (!((String)localObject1).contains("p_skey=;")) {}
        }
        else
        {
          this.jdField_a_of_type_Long |= 0x20;
          paramCookiesMap = new StringBuilder();
          paramCookiesMap.append(this.k);
          paramCookiesMap.append(": get pSkey fail!");
          QLog.e("SwiftBrowserCookieMonster", 1, paramCookiesMap.toString());
          return false;
        }
      }
    }
    if (!TextUtils.isEmpty(this.i)) {
      if (!TextUtils.isEmpty(this.g))
      {
        if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {
          paramAppRuntime = a("pt4_token", this.g, this.i);
        } else {
          paramAppRuntime = a("pt4_token", this.g, this.i, false);
        }
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
      }
      else
      {
        localObject1 = paramAppRuntime;
        if (paramAppRuntime == null) {
          localObject1 = CookieManager.getInstance().getCookie(this.l);
        }
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).contains("pt4_token=")) || (((String)localObject1).contains("pt4_token=;")))
        {
          this.jdField_a_of_type_Long |= 0x40;
          paramCookiesMap = new StringBuilder();
          paramCookiesMap.append(this.i);
          paramCookiesMap.append(": get pt4Token fail!");
          QLog.e("SwiftBrowserCookieMonster", 1, paramCookiesMap.toString());
          return false;
        }
      }
    }
    if ((!TextUtils.isEmpty(this.k)) && (this.k.equals("docs.qq.com")))
    {
      paramAppRuntime = a("tdsourcetag", "s_qq_c2c_chatfiles", this.k, false);
      paramCookiesMap.addCookie(this.l, paramAppRuntime);
    }
    return true;
  }
  
  String c(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject3 = new StringBuilder();
    Object localObject2 = (TicketManager)paramAppRuntime.getManager(2);
    String str = paramAppRuntime.getAccount();
    Object localObject4 = a(str);
    if (!TextUtils.isEmpty(paramString)) {
      ((StringBuilder)localObject3).append(paramString);
    }
    a((StringBuilder)localObject3);
    ((StringBuilder)localObject3).append("uin=");
    ((StringBuilder)localObject3).append((String)localObject4);
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("skey=")))
    {
      if (paramString.contains("skey=;"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserCookieMonster", 2, "not need set skey");
        }
      }
      else if (paramString.contains("skey="))
      {
        bool1 = true;
        break label360;
      }
    }
    else
    {
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        jdField_a_of_type_JavaLangString = ((TicketManager)localObject2).getSkey(str);
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("getCookie4WebSo: skey is miss and fetch result is ");
        if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          localObject1 = "fail";
        } else {
          localObject1 = "success";
        }
        ((StringBuilder)localObject5).append((String)localObject1);
        QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject5).toString());
      }
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("skey=");
        ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
        QLog.i("SwiftBrowserCookieMonster", 1, Util.c(((StringBuilder)localObject1).toString(), new String[0]));
      }
      else
      {
        QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
      }
      localObject1 = ((TicketManager)localObject2).getLocalTicket(str, 4096);
      if (localObject1 != null)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("last refresh skey time: ");
        ((StringBuilder)localObject5).append(((Ticket)localObject1)._create_time);
        QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject5).toString());
      }
      a((StringBuilder)localObject3, jdField_a_of_type_JavaLangString, "skey=", "");
    }
    boolean bool1 = false;
    label360:
    Object localObject5 = "last refresh skey time: ";
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_skey=;")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pskey");
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(this.l);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_skey=")))
        {
          if (paramString.contains("p_skey="))
          {
            bool2 = true;
            break label637;
          }
        }
        else
        {
          if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_uin=;")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uin");
            }
          }
          else if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("p_uin=")))
          {
            a((StringBuilder)localObject3);
            ((StringBuilder)localObject3).append("p_uin=");
            ((StringBuilder)localObject3).append((String)localObject4);
          }
          if (TextUtils.isEmpty(this.f))
          {
            this.f = ((TicketManager)localObject2).getPskey(str, (String)localObject1);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("getCookie4WebSo: pSkey is miss and fetch result is ");
            if (TextUtils.isEmpty(this.f)) {
              localObject1 = "fail";
            } else {
              localObject1 = "success";
            }
            ((StringBuilder)localObject4).append((String)localObject1);
            QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject4).toString());
          }
          a((StringBuilder)localObject3, this.f, "p_skey=", "");
        }
      }
    }
    boolean bool2 = false;
    label637:
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pt4_token=;")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pt4_token");
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pt4_token=")))
        {
          if (paramString.contains("pt4_token="))
          {
            bool3 = true;
            break label824;
          }
        }
        else
        {
          if (TextUtils.isEmpty(this.g))
          {
            this.g = b(paramAppRuntime, (String)localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getCookie4WebSo: pt4Token is miss and fetch result is ");
            if (TextUtils.isEmpty(this.g)) {
              paramString = "fail";
            } else {
              paramString = "success";
            }
            ((StringBuilder)localObject1).append(paramString);
            QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject1).toString());
          }
          a((StringBuilder)localObject3, this.g, "pt4_token=", "");
        }
      }
    }
    boolean bool3 = false;
    label824:
    if ((!bool1) && (!bool2))
    {
      paramString = (String)localObject3;
      if (!bool3) {}
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("getCookie4WebSo: cookie need update: isNeedReplaceSkey(");
      paramString.append(bool1);
      paramString.append("), isNeedReplacePskey(");
      paramString.append(bool2);
      paramString.append("), isNeedReplacePt4Token(");
      paramString.append(bool3);
      paramString.append(").");
      QLog.i("SwiftBrowserCookieMonster", 1, paramString.toString());
      paramString = ((StringBuilder)localObject3).toString().replaceAll(" ", "");
      localObject4 = new StringBuilder();
      if (paramString.contains(";"))
      {
        localObject3 = paramString.split(";");
        int m = localObject3.length;
        int n = 0;
        paramString = (String)localObject5;
        localObject1 = localObject2;
        localObject2 = localObject3;
        while (n < m)
        {
          localObject5 = localObject2[n];
          if (!TextUtils.isEmpty((CharSequence)localObject5)) {
            if (((StringBuilder)localObject4).length() == 0)
            {
              ((StringBuilder)localObject4).append((String)localObject5);
            }
            else
            {
              a((StringBuilder)localObject4);
              StringBuilder localStringBuilder;
              if ((((String)localObject5).startsWith("p_skey=")) && (bool2))
              {
                if (TextUtils.isEmpty(this.f))
                {
                  this.f = ((TicketManager)localObject1).getPskey(str, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(this.l));
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("getCookie4WebSo: pSkey is miss and fetch result is ");
                  if (TextUtils.isEmpty(this.f)) {
                    localObject3 = "fail";
                  } else {
                    localObject3 = "success";
                  }
                  localStringBuilder.append((String)localObject3);
                  QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
                }
                a((StringBuilder)localObject4, this.f, "p_skey=", (String)localObject5);
              }
              else if ((((String)localObject5).startsWith("skey=")) && (bool1))
              {
                if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
                {
                  jdField_a_of_type_JavaLangString = ((TicketManager)localObject1).getSkey(str);
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("getCookie4WebSo: sKey is miss and fetch result is ");
                  if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
                    localObject3 = "fail";
                  } else {
                    localObject3 = "success";
                  }
                  localStringBuilder.append((String)localObject3);
                  QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
                }
                if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("skey=");
                  ((StringBuilder)localObject3).append(jdField_a_of_type_JavaLangString);
                  QLog.i("SwiftBrowserCookieMonster", 1, Util.c(((StringBuilder)localObject3).toString(), new String[0]));
                }
                else
                {
                  QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                }
                localObject3 = ((TicketManager)localObject1).getLocalTicket(str, 4096);
                if (localObject3 != null)
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(paramString);
                  localStringBuilder.append(((Ticket)localObject3)._create_time);
                  QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
                }
                a((StringBuilder)localObject4, jdField_a_of_type_JavaLangString, "skey=", (String)localObject5);
              }
              else if ((((String)localObject5).startsWith("pt4_token=")) && (bool3))
              {
                if (TextUtils.isEmpty(this.g))
                {
                  this.g = b(paramAppRuntime, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l));
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                  if (TextUtils.isEmpty(this.g)) {
                    localObject3 = "fail";
                  } else {
                    localObject3 = "success";
                  }
                  localStringBuilder.append((String)localObject3);
                  QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
                }
                a((StringBuilder)localObject4, this.g, "pt4_token=", (String)localObject5);
              }
              else
              {
                ((StringBuilder)localObject4).append((String)localObject5);
              }
            }
          }
          n += 1;
        }
      }
      paramString = (String)localObject4;
    }
    return paramString.toString();
  }
  
  void c()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.l.startsWith("file:"))
        {
          this.j = "qq.com";
          this.i = "";
          this.h = "";
          this.k = "";
        }
        else
        {
          this.j = Util.b(this.l);
          this.h = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(this.l);
          this.k = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(this.l);
          this.i = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("CookieMonsterTask:topLevelDomain=");
            localStringBuilder.append(this.j);
            localStringBuilder.append(",pSkeyDomain=");
            localStringBuilder.append(this.k);
            localStringBuilder.append(",Pt4TokenDomain=");
            localStringBuilder.append(this.i);
            localStringBuilder.append(",a2Domain=");
            localStringBuilder.append(this.h);
            QLog.d("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
          }
        }
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  boolean c(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if (!b()) {
      a(paramAppRuntime);
    }
    Object localObject;
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      try
      {
        paramAppRuntime = MessageDigest.getInstance("MD5");
        paramAppRuntime.update(jdField_b_of_type_JavaLangString.getBytes());
        paramAppRuntime = paramAppRuntime.digest();
        int m = paramAppRuntime.length;
        c = Long.toString((paramAppRuntime[(m - 4)] & 0xFF) << 24 | (paramAppRuntime[(m - 3)] & 0xFF) << 16 | (paramAppRuntime[(m - 2)] & 0xFF) << 8 | paramAppRuntime[(m - 1)] & 0xFF);
      }
      catch (NoSuchAlgorithmException paramAppRuntime)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Super key hash failed:");
          ((StringBuilder)localObject).append(paramAppRuntime.getMessage());
          QLog.w("SwiftBrowserCookieMonster", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_Long |= 0x4;
      }
      paramAppRuntime = a("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, a("superkey", jdField_b_of_type_JavaLangString, "ptlogin2.qq.com", true));
      paramCookiesMap.addCookie(paramAppRuntime, a("supertoken", c, "ptlogin2.qq.com", false));
      paramCookiesMap.addCookie(a("ptlogin2.qq.com", false), a("superkey", jdField_b_of_type_JavaLangString, "ptlogin2.qq.com", true));
    }
    else
    {
      this.jdField_a_of_type_Long |= 0x2;
    }
    if (!TextUtils.isEmpty(this.h))
    {
      if (!TextUtils.isEmpty(e))
      {
        paramAppRuntime = a("a2", e, this.h, true);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
      }
      else
      {
        this.jdField_a_of_type_Long |= 0x10;
      }
      a(paramCookiesMap, this.l, this.h);
    }
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramAppRuntime = (String)((Iterator)localObject).next();
        String str = a(paramAppRuntime, true);
        if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {
          paramAppRuntime = a("skey", jdField_a_of_type_JavaLangString, paramAppRuntime);
        } else {
          paramAppRuntime = a("skey", jdField_a_of_type_JavaLangString, paramAppRuntime, false);
        }
        paramCookiesMap.addCookie(str, paramAppRuntime);
      }
    }
    this.jdField_a_of_type_Long |= 1L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster
 * JD-Core Version:    0.7.0.1
 */