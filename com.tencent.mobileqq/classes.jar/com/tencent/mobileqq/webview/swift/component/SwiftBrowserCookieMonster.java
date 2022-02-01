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
  public static volatile String a;
  public static volatile String b;
  public static volatile String c;
  public static volatile String d;
  public static volatile String e;
  public static final AtomicInteger f = new AtomicInteger(1);
  public static volatile SwiftBrowserCookieMonster.TicketRefreshListener s;
  private static final LruCache<String, SwiftBrowserCookieMonster> u = new LruCache(8);
  private static final byte[] w = new byte[0];
  public volatile String g;
  public volatile String h;
  final AtomicInteger i = new AtomicInteger(1);
  public volatile boolean j;
  public String k;
  public String l;
  public String m;
  public String n;
  public final String o;
  public final AuthorizeConfig p;
  final ConcurrentHashMap<String, CopyOnWriteArrayList<SetCookiesCallback>> q = new ConcurrentHashMap();
  boolean r = false;
  long t = 0L;
  private ArrayList<IBrowserCookieInjector> v = new ArrayList();
  
  SwiftBrowserCookieMonster(String paramString)
  {
    this.o = paramString;
    if (u.size() == 0) {
      CookieSyncManager.createInstance(MobileQQ.getContext());
    }
    this.p = AuthorizeConfig.a();
    u.put(paramString, this);
    f();
    k();
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int i1 = paramString.length();
        while (i1 < 10)
        {
          ((StringBuilder)localObject).append("0");
          i1 += 1;
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
  
  private void a(String paramString1, SetCookiesCallback paramSetCookiesCallback, AppRuntime paramAppRuntime, Intent paramIntent, String paramString2)
  {
    if (this.t > 0L)
    {
      i();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("some cookie goes wrong, errorCode: ");
      ((StringBuilder)localObject).append(this.t);
      QLog.e("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = CookieManager.getInstance().getCookie(paramString1);
    if (((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("skey="))) || ((!this.p.a(paramString1)) && (!e((String)localObject))))
    {
      if ((!this.r) && (this.t <= 0L))
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("hit cookie cache, just call onSetCookiesFinished ");
          paramString1.append(Util.b(paramString2, new String[0]));
          paramString1.append(", errorCode: ");
          paramString1.append(this.t);
          QLog.i("SwiftBrowserCookieMonster", 2, paramString1.toString());
        }
        paramSetCookiesCallback.a(paramString2, null, this.t);
        return;
      }
      if (this.r)
      {
        paramString1 = new StringBuilder();
        paramString1.append("cookie is wrong, need do jump ptlogin! ");
        paramString1.append(Util.b(paramString2, new String[0]));
        QLog.i("SwiftBrowserCookieMonster", 1, paramString1.toString());
      }
      paramSetCookiesCallback.a(paramString2, null, this.t);
      b();
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("some cookie goes wrong, retry set cookie: ");
    paramString2.append((String)localObject);
    paramString2.append("");
    QLog.e("SwiftBrowserCookieMonster", 1, paramString2.toString());
    a();
    a(paramString1, paramSetCookiesCallback, paramAppRuntime, paramIntent);
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
  
  @SuppressLint({"DefaultLocale"})
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    if (paramAppRuntime != null) {}
    for (;;)
    {
      try
      {
        if (!paramAppRuntime.isLogin()) {
          break label544;
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
          Object localObject3 = ((AuthorizeConfig)localObject1).m("pt4_token");
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
            break label551;
          }
          i1 = ((Set)localObject3).size();
          if (localObject1 == null) {
            break label556;
          }
          i2 = ((List)localObject1).size();
          localObject2 = new String[i1 + i2];
          if ((localObject3 == null) || (((Set)localObject3).size() <= 0)) {
            break label561;
          }
          localObject3 = ((Set)localObject3).iterator();
          i1 = 0;
          i2 = i1;
          if (((Iterator)localObject3).hasNext())
          {
            localObject2[i1] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
            i1 += 1;
            continue;
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2[i2] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), (String)((Iterator)localObject1).next() });
              i2 += 1;
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
          a(paramIntent, str, (String[])localObject2);
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
      int i1 = 1;
      continue;
      label544:
      paramIntent = null;
      i1 = 0;
      continue;
      label551:
      i1 = 0;
      continue;
      label556:
      int i2 = 0;
      continue;
      label561:
      i2 = 0;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, StringBuilder paramStringBuilder, TicketManager paramTicketManager, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String[] paramArrayOfString)
  {
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      if (!TextUtils.isEmpty(str)) {
        if (paramStringBuilder.length() == 0)
        {
          paramStringBuilder.append(str);
        }
        else
        {
          a(paramStringBuilder);
          boolean bool = str.startsWith("p_skey=");
          Object localObject = "fail";
          StringBuilder localStringBuilder;
          if ((bool) && (paramBoolean2))
          {
            if (TextUtils.isEmpty(this.g))
            {
              this.g = paramTicketManager.getPskey(paramString, this.p.e(this.o));
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("getCookie4WebSo: pSkey is miss and fetch result is ");
              if (!TextUtils.isEmpty(this.g)) {
                localObject = "success";
              }
              localStringBuilder.append((String)localObject);
              QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
            }
            a(paramStringBuilder, this.g, "p_skey=", str);
          }
          else if ((str.startsWith("skey=")) && (paramBoolean1))
          {
            if (TextUtils.isEmpty(a))
            {
              a = paramTicketManager.getSkey(paramString);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("getCookie4WebSo: sKey is miss and fetch result is ");
              if (!TextUtils.isEmpty(a)) {
                localObject = "success";
              }
              localStringBuilder.append((String)localObject);
              QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
            }
            if (!TextUtils.isEmpty(a))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("skey=");
              ((StringBuilder)localObject).append(a);
              QLog.i("SwiftBrowserCookieMonster", 1, Util.c(((StringBuilder)localObject).toString(), new String[0]));
            }
            else
            {
              QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
            }
            localObject = paramTicketManager.getLocalTicket(paramString, 4096);
            if (localObject != null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("last refresh skey time: ");
              localStringBuilder.append(((Ticket)localObject)._create_time);
              QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
            }
            a(paramStringBuilder, a, "skey=", str);
          }
          else if ((str.startsWith("pt4_token=")) && (paramBoolean3))
          {
            if (TextUtils.isEmpty(this.h))
            {
              this.h = b(paramAppRuntime, this.p.f(this.o));
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("getCookie4WebSo: pt4Token is miss and fetch result is ");
              if (!TextUtils.isEmpty(this.h)) {
                localObject = "success";
              }
              localStringBuilder.append((String)localObject);
              QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
            }
            a(paramStringBuilder, this.h, "pt4_token=", str);
          }
          else
          {
            paramStringBuilder.append(str);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private static void a(TicketManager paramTicketManager, String paramString, String[] paramArrayOfString)
  {
    paramTicketManager.getPskey(paramString, 16L, paramArrayOfString, new SwiftBrowserCookieMonster.4());
  }
  
  private boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, String paramString)
  {
    if (!TextUtils.isEmpty(this.l))
    {
      if (!TextUtils.isEmpty(this.h))
      {
        if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {
          paramString = a("pt4_token", this.h, this.l);
        } else {
          paramString = a("pt4_token", this.h, this.l, false);
        }
        paramCookiesMap.addCookie(this.o, paramString);
        return false;
      }
      paramCookiesMap = paramString;
      if (paramString == null) {
        paramCookiesMap = CookieManager.getInstance().getCookie(this.o);
      }
      if ((TextUtils.isEmpty(paramCookiesMap)) || (!paramCookiesMap.contains("pt4_token=")) || (paramCookiesMap.contains("pt4_token=;")))
      {
        this.t |= 0x40;
        paramCookiesMap = new StringBuilder();
        paramCookiesMap.append(this.l);
        paramCookiesMap.append(": get pt4Token fail!");
        QLog.e("SwiftBrowserCookieMonster", 1, paramCookiesMap.toString());
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("https://aq.qq.com/"))
    {
      paramCookiesMap.addCookie(paramString1, a("dvid1", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      paramString2 = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid5", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      }
      paramString2 = DeviceInfoUtil.c();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid4", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.d(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid2", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid3", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, StringBuilder paramStringBuilder, TicketManager paramTicketManager, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    if (!TextUtils.isEmpty(paramString4)) {
      if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("p_skey=")))
      {
        if (paramString1.contains("p_skey=")) {
          return true;
        }
      }
      else
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("p_uin=;")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uin");
          }
        }
        else if ((TextUtils.isEmpty(paramString1)) || (!paramString1.contains("p_uin=")))
        {
          a(paramStringBuilder);
          paramStringBuilder.append("p_uin=");
          paramStringBuilder.append(paramString3);
        }
        if (TextUtils.isEmpty(this.g))
        {
          this.g = paramTicketManager.getPskey(paramString2, paramString4);
          paramTicketManager = new StringBuilder();
          paramTicketManager.append("getCookie4WebSo: pSkey is miss and fetch result is ");
          if (TextUtils.isEmpty(this.g)) {
            paramString1 = "fail";
          } else {
            paramString1 = "success";
          }
          paramTicketManager.append(paramString1);
          QLog.i("SwiftBrowserCookieMonster", 1, paramTicketManager.toString());
        }
        a(paramStringBuilder, this.g, "p_skey=", "");
      }
    }
    return paramBoolean;
  }
  
  private boolean a(String paramString1, StringBuilder paramStringBuilder, TicketManager paramTicketManager, String paramString2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("skey=")))
    {
      if (paramString1.contains("skey=;"))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserCookieMonster", 2, "not need set skey");
          return paramBoolean;
        }
      }
      else if (paramString1.contains("skey=")) {
        return true;
      }
    }
    else
    {
      if (TextUtils.isEmpty(a))
      {
        a = paramTicketManager.getSkey(paramString2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCookie4WebSo: skey is miss and fetch result is ");
        if (TextUtils.isEmpty(a)) {
          paramString1 = "fail";
        } else {
          paramString1 = "success";
        }
        localStringBuilder.append(paramString1);
        QLog.i("SwiftBrowserCookieMonster", 1, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(a))
      {
        paramString1 = new StringBuilder();
        paramString1.append("skey=");
        paramString1.append(a);
        QLog.i("SwiftBrowserCookieMonster", 1, Util.c(paramString1.toString(), new String[0]));
      }
      else
      {
        QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
      }
      paramString1 = paramTicketManager.getLocalTicket(paramString2, 4096);
      if (paramString1 != null)
      {
        paramTicketManager = new StringBuilder();
        paramTicketManager.append("last refresh skey time: ");
        paramTicketManager.append(paramString1._create_time);
        QLog.i("SwiftBrowserCookieMonster", 1, paramTicketManager.toString());
      }
      a(paramStringBuilder, a, "skey=", "");
    }
    return paramBoolean;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (f.compareAndSet(1, 2))
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
  
  private boolean a(AppRuntime paramAppRuntime, String paramString1, StringBuilder paramStringBuilder, boolean paramBoolean, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("pt4_token=")))
      {
        if (paramString1.contains("pt4_token=")) {
          return true;
        }
      }
      else
      {
        if (TextUtils.isEmpty(this.h))
        {
          this.h = b(paramAppRuntime, paramString2);
          paramString1 = new StringBuilder();
          paramString1.append("getCookie4WebSo: pt4Token is miss and fetch result is ");
          if (TextUtils.isEmpty(this.h)) {
            paramAppRuntime = "fail";
          } else {
            paramAppRuntime = "success";
          }
          paramString1.append(paramAppRuntime);
          QLog.i("SwiftBrowserCookieMonster", 1, paramString1.toString());
        }
        a(paramStringBuilder, this.h, "pt4_token=", "");
      }
    }
    return paramBoolean;
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
  
  public static void b(AppRuntime arg0)
  {
    int i1 = f.get();
    if (3 != i1)
    {
      if (1 == i1)
      {
        AppRuntime localAppRuntime = ???;
        if (??? == null) {
          localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        a(localAppRuntime);
        return;
      }
      synchronized (f)
      {
        for (;;)
        {
          i1 = f.get();
          if (2 != i1) {
            break;
          }
          try
          {
            f.wait();
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
  
  public static void b(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    ThreadManager.postImmediately(new SwiftBrowserCookieMonster.6(paramAppRuntime, paramIntent), new SwiftBrowserCookieMonster.7(), false);
  }
  
  public static SwiftBrowserCookieMonster c(String paramString)
  {
    try
    {
      String str = b(paramString);
      if (!TextUtils.isEmpty(str))
      {
        SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = (SwiftBrowserCookieMonster)u.get(str);
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
  
  private void c(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((IBrowserCookieInjector)localIterator.next()).a(this.o);
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            paramCookiesMap.addCookie(this.o, str);
          }
        }
      }
      else
      {
        QLog.w("SwiftBrowserCookieMonster", 1, "collectBusinessCookie cookieList is empty");
      }
    }
  }
  
  static boolean c(AppRuntime paramAppRuntime)
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 >= 11)
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
  
  public static String d(String paramString)
  {
    SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = c(paramString);
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
  
  public static void d()
  {
    a = "";
    b = "";
    c = "";
    d = "";
    e = "";
    f.set(1);
    u.evictAll();
    s = null;
    QLog.i("SwiftBrowserCookieMonster", 1, "resetAllKeyAndCache");
  }
  
  static void f()
  {
    if (s == null) {
      ThreadManager.postImmediately(new SwiftBrowserCookieMonster.9(), null, false);
    }
  }
  
  public static boolean h()
  {
    return (!TextUtils.isEmpty(a)) && (!TextUtils.isEmpty(b)) && (!TextUtils.isEmpty(d)) && (!TextUtils.isEmpty(e)) && (!TextUtils.isEmpty(c));
  }
  
  private void k()
  {
    try
    {
      if (SwiftBrowserCookieInjectorUtil.a != null)
      {
        Iterator localIterator = SwiftBrowserCookieInjectorUtil.a.iterator();
        while (localIterator.hasNext())
        {
          IBrowserCookieInjector localIBrowserCookieInjector = (IBrowserCookieInjector)((Class)localIterator.next()).newInstance();
          this.v.add(localIBrowserCookieInjector);
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
      this.r = (b(paramIntent, paramAppRuntime) ^ true);
      c(paramIntent, paramAppRuntime);
    }
    else
    {
      d(paramIntent, paramAppRuntime);
    }
    a(paramIntent);
    c(paramIntent);
    return paramIntent;
  }
  
  String a(String paramString, AppRuntime paramAppRuntime)
  {
    if (this.r)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SwiftBrowserCookieMonster", 2, "Cookies is wrong, now do ptlogin jumping!");
      }
      if (!TextUtils.isEmpty(d))
      {
        boolean bool = c(paramAppRuntime);
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
      this.t |= 0x8;
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
    this.i.set(1);
    this.r = false;
    this.t = 0L;
  }
  
  public void a(SetCookiesCallback paramSetCookiesCallback)
  {
    if (paramSetCookiesCallback != null)
    {
      Iterator localIterator = this.q.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CopyOnWriteArrayList)this.q.get(localObject);
        if (((CopyOnWriteArrayList)localObject).contains(paramSetCookiesCallback)) {
          ((CopyOnWriteArrayList)localObject).remove(paramSetCookiesCallback);
        }
      }
    }
  }
  
  void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    String str = PropertiesUtils.b(MobileQQ.getContext(), "key_local_cache", "0");
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
    Iterator localIterator = this.p.m("skey").iterator();
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
    localIterator = this.p.m("pskey").iterator();
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
      this.t |= 0x80;
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
  
  public boolean a(String paramString, SetCookiesCallback paramSetCookiesCallback, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    Object localObject;
    if (this.i.get() == 3)
    {
      if (paramAppRuntime == null) {
        localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      } else {
        localObject = paramAppRuntime;
      }
      localObject = a(paramString, (AppRuntime)localObject);
      if (paramSetCookiesCallback != null)
      {
        a(paramString, paramSetCookiesCallback, paramAppRuntime, paramIntent, (String)localObject);
        return true;
      }
    }
    if (paramSetCookiesCallback != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.q.get(paramString);
      localObject = localCopyOnWriteArrayList;
      if (localCopyOnWriteArrayList == null)
      {
        localObject = new CopyOnWriteArrayList();
        this.q.put(paramString, localObject);
      }
      if (!((CopyOnWriteArrayList)localObject).contains(paramSetCookiesCallback)) {
        ((CopyOnWriteArrayList)localObject).add(paramSetCookiesCallback);
      }
      if (QLog.isColorLevel())
      {
        paramSetCookiesCallback = new StringBuilder();
        paramSetCookiesCallback.append("now add callback for ");
        paramSetCookiesCallback.append(Util.b(paramString, new String[0]));
        QLog.i("SwiftBrowserCookieMonster", 2, paramSetCookiesCallback.toString());
      }
    }
    Util.f("Web_qqbrowser_check_and_set_cookies");
    paramString = new SwiftBrowserCookieMonster.1(this, paramAppRuntime, paramIntent);
    if (this.i.compareAndSet(1, 2))
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
    this.q.clear();
    u.remove(this.o);
  }
  
  void b(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    Iterator localIterator = this.p.m("skey").iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramCookiesMap.addCookie(a(str, true), a("skey", "", str, false));
    }
    paramCookiesMap.addCookie(a("ptlogin2.qq.com", true), a("superkey", "", "ptlogin2.qq.com", true));
    if (!TextUtils.isEmpty(this.n)) {
      paramCookiesMap.addCookie(this.o, a("p_skey", "", this.n, false));
    }
    if (!TextUtils.isEmpty(this.k)) {
      paramCookiesMap.addCookie(this.o, a("a2", "", this.k, true));
    }
    if (QLog.isColorLevel())
    {
      paramCookiesMap = new StringBuilder();
      paramCookiesMap.append(Util.b(this.o, new String[0]));
      paramCookiesMap.append(" forbidden login state, remove all login key");
      QLog.d("SwiftBrowserCookieMonster", 2, paramCookiesMap.toString());
    }
  }
  
  boolean b(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    boolean bool = TextUtils.isEmpty(this.n);
    String str = "fail";
    Object localObject2;
    if ((!bool) && (TextUtils.isEmpty(this.g)))
    {
      this.g = a(paramAppRuntime, this.n);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("domain:");
      ((StringBuilder)localObject2).append(this.n);
      ((StringBuilder)localObject2).append(": pSkey is miss and fetch result is ");
      if (TextUtils.isEmpty(this.g)) {
        localObject1 = "fail";
      } else {
        localObject1 = "success";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject2).toString());
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("domain:");
      ((StringBuilder)localObject2).append(this.n);
      if (TextUtils.isEmpty(this.g))
      {
        localObject1 = "p_skey=null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" p_skey=");
        ((StringBuilder)localObject1).append(this.g);
        localObject1 = Util.c(((StringBuilder)localObject1).toString(), new String[0]);
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject2).toString());
    }
    if ((!TextUtils.isEmpty(this.l)) && (TextUtils.isEmpty(this.h)))
    {
      this.h = b(paramAppRuntime, this.l);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.l);
      ((StringBuilder)localObject1).append(": pt4Token is miss and fetch result is ");
      if (TextUtils.isEmpty(this.h)) {
        paramAppRuntime = str;
      } else {
        paramAppRuntime = "success";
      }
      ((StringBuilder)localObject1).append(paramAppRuntime);
      QLog.i("SwiftBrowserCookieMonster", 1, ((StringBuilder)localObject1).toString());
    }
    str = null;
    Object localObject1 = str;
    if (!TextUtils.isEmpty(this.n)) {
      if (!TextUtils.isEmpty(this.g))
      {
        if ((this.o != null) && (QzoneConfig.isNeedSecureVerifyAllBusiness()) && (this.o.contains("qzone.qq.com"))) {
          paramAppRuntime = a("p_skey", this.g, this.n);
        } else if ((this.o != null) && (QzoneConfig.isNeedSecureVerifyAllBusiness())) {
          paramAppRuntime = a("p_skey", this.g, this.n);
        } else {
          paramAppRuntime = a("p_skey", this.g, this.n, false);
        }
        paramCookiesMap.addCookie(this.o, paramAppRuntime);
        localObject2 = this.o;
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject1 = str;
          if (((String)localObject2).contains("http://"))
          {
            localObject1 = str;
            if (this.o.contains("qzone.qq.com"))
            {
              paramCookiesMap.addCookie(this.o.replace("http", "https"), paramAppRuntime);
              localObject1 = str;
            }
          }
        }
      }
      else
      {
        paramAppRuntime = CookieManager.getInstance().getCookie(this.o);
        if ((!TextUtils.isEmpty(paramAppRuntime)) && (paramAppRuntime.contains("p_skey=")))
        {
          localObject1 = paramAppRuntime;
          if (!paramAppRuntime.contains("p_skey=;")) {}
        }
        else
        {
          this.t |= 0x20;
          paramCookiesMap = new StringBuilder();
          paramCookiesMap.append(this.n);
          paramCookiesMap.append(": get pSkey fail!");
          QLog.e("SwiftBrowserCookieMonster", 1, paramCookiesMap.toString());
          return false;
        }
      }
    }
    if (a(paramCookiesMap, (String)localObject1)) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.n)) && (this.n.equals("docs.qq.com")))
    {
      paramAppRuntime = a("tdsourcetag", "s_qq_c2c_chatfiles", this.n, false);
      paramCookiesMap.addCookie(this.o, paramAppRuntime);
    }
    return true;
  }
  
  String c(AppRuntime paramAppRuntime, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    String str1 = paramAppRuntime.getAccount();
    String str2 = a(str1);
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    a(localStringBuilder);
    localStringBuilder.append("uin=");
    localStringBuilder.append(str2);
    boolean bool3 = a(paramString, localStringBuilder, localTicketManager, str1, false);
    boolean bool1;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_skey=;")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pskey");
      }
      bool1 = false;
    }
    else
    {
      bool1 = a(paramString, localStringBuilder, localTicketManager, str1, str2, false, this.p.e(this.o));
    }
    boolean bool2;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pt4_token=;")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pt4_token");
      }
      bool2 = false;
    }
    else
    {
      bool2 = a(paramAppRuntime, paramString, localStringBuilder, false, this.p.f(this.o));
    }
    if ((!bool3) && (!bool1))
    {
      paramString = localStringBuilder;
      if (!bool2) {}
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("getCookie4WebSo: cookie need update: isNeedReplaceSkey(");
      paramString.append(bool3);
      paramString.append("), isNeedReplacePskey(");
      paramString.append(bool1);
      paramString.append("), isNeedReplacePt4Token(");
      paramString.append(bool2);
      paramString.append(").");
      QLog.i("SwiftBrowserCookieMonster", 1, paramString.toString());
      str2 = localStringBuilder.toString().replaceAll(" ", "");
      localStringBuilder = new StringBuilder();
      paramString = localStringBuilder;
      if (str2.contains(";"))
      {
        a(paramAppRuntime, localStringBuilder, localTicketManager, str1, bool3, bool1, bool2, str2.split(";"));
        paramString = localStringBuilder;
      }
    }
    return paramString.toString();
  }
  
  void c()
  {
    try
    {
      if (!this.j)
      {
        if (this.o.startsWith("file:"))
        {
          this.m = "qq.com";
          this.l = "";
          this.k = "";
          this.n = "";
        }
        else
        {
          this.m = Util.d(this.o);
          this.k = this.p.p(this.o);
          this.n = this.p.e(this.o);
          this.l = this.p.f(this.o);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("CookieMonsterTask:topLevelDomain=");
            localStringBuilder.append(this.m);
            localStringBuilder.append(",pSkeyDomain=");
            localStringBuilder.append(this.n);
            localStringBuilder.append(",Pt4TokenDomain=");
            localStringBuilder.append(this.l);
            localStringBuilder.append(",a2Domain=");
            localStringBuilder.append(this.k);
            QLog.d("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
          }
        }
        this.j = true;
      }
      return;
    }
    finally {}
  }
  
  boolean c(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if (!h()) {
      b(paramAppRuntime);
    }
    Object localObject;
    if (!TextUtils.isEmpty(b))
    {
      try
      {
        paramAppRuntime = MessageDigest.getInstance("MD5");
        paramAppRuntime.update(b.getBytes());
        paramAppRuntime = paramAppRuntime.digest();
        int i1 = paramAppRuntime.length;
        c = Long.toString((paramAppRuntime[(i1 - 4)] & 0xFF) << 24 | (paramAppRuntime[(i1 - 3)] & 0xFF) << 16 | (paramAppRuntime[(i1 - 2)] & 0xFF) << 8 | paramAppRuntime[(i1 - 1)] & 0xFF);
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
        this.t |= 0x4;
      }
      paramAppRuntime = a("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, a("superkey", b, "ptlogin2.qq.com", true));
      paramCookiesMap.addCookie(paramAppRuntime, a("supertoken", c, "ptlogin2.qq.com", false));
      paramCookiesMap.addCookie(a("ptlogin2.qq.com", false), a("superkey", b, "ptlogin2.qq.com", true));
    }
    else
    {
      this.t |= 0x2;
    }
    if (!TextUtils.isEmpty(this.k))
    {
      if (!TextUtils.isEmpty(e))
      {
        paramAppRuntime = a("a2", e, this.k, true);
        paramCookiesMap.addCookie(this.o, paramAppRuntime);
      }
      else
      {
        this.t |= 0x10;
      }
      a(paramCookiesMap, this.o, this.k);
    }
    if (!TextUtils.isEmpty(a))
    {
      localObject = this.p.m("skey").iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramAppRuntime = (String)((Iterator)localObject).next();
        String str = a(paramAppRuntime, true);
        if (QzoneConfig.isNeedSecureVerifyAllBusiness()) {
          paramAppRuntime = a("skey", a, paramAppRuntime);
        } else {
          paramAppRuntime = a("skey", a, paramAppRuntime, false);
        }
        paramCookiesMap.addCookie(str, paramAppRuntime);
      }
    }
    this.t |= 1L;
    return true;
  }
  
  void d(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    String str1 = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis() + 10000L));
    String str2 = this.o;
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
    a(paramCookiesMap, this.o, "aq.qq.com");
  }
  
  public boolean e()
  {
    return this.i.get() == 3;
  }
  
  boolean e(String paramString)
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
        if (!TextUtils.isEmpty(this.n)) {
          if (!this.n.equals("docs.qq.com"))
          {
            bool1 = bool3;
            if (!this.n.equals("docx.qq.com")) {}
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
  
  @Deprecated
  public void g()
  {
    c();
    SwiftBrowserCookieMonster.CookiesMap localCookiesMap = new SwiftBrowserCookieMonster.CookiesMap();
    a(localCookiesMap, null);
    b(localCookiesMap);
    a(localCookiesMap, true);
    u.evictAll();
  }
  
  void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster
 * JD-Core Version:    0.7.0.1
 */