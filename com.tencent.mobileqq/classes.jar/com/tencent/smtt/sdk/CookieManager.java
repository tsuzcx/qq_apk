package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class CookieManager
{
  public static String LOGTAG = "CookieManager";
  private static CookieManager d;
  CopyOnWriteArrayList<CookieManager.b> a;
  String b;
  CookieManager.a c = CookieManager.a.a;
  private boolean e = false;
  private boolean f = false;
  
  public static CookieManager getInstance()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new CookieManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static int getROMCookieDBVersion(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    } else {
      i = 0;
    }
    return paramContext.getSharedPreferences("cookiedb_info", i).getInt("db_version", -1);
  }
  
  public static void setROMCookieDBVersion(Context paramContext, int paramInt)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    } else {
      i = 0;
    }
    paramContext = paramContext.getSharedPreferences("cookiedb_info", i).edit();
    paramContext.putInt("db_version", paramInt);
    paramContext.commit();
  }
  
  void a()
  {
    try
    {
      this.f = true;
      if ((this.a != null) && (this.a.size() != 0))
      {
        Object localObject1 = x.a();
        if ((localObject1 != null) && (((x)localObject1).b())) {
          localObject1 = this.a.iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (CookieManager.b)((Iterator)localObject1).next();
          int i = ((CookieManager.b)localObject3).a;
          if (i != 1)
          {
            if (i == 2) {
              setCookie(((CookieManager.b)localObject3).b, ((CookieManager.b)localObject3).c);
            }
          }
          else
          {
            setCookie(((CookieManager.b)localObject3).b, ((CookieManager.b)localObject3).c, ((CookieManager.b)localObject3).d);
            continue;
            localObject1 = this.a.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject4 = (CookieManager.b)((Iterator)localObject1).next();
              i = ((CookieManager.b)localObject4).a;
              if (i != 1)
              {
                if (i == 2) {
                  android.webkit.CookieManager.getInstance().setCookie(((CookieManager.b)localObject4).b, ((CookieManager.b)localObject4).c);
                }
              }
              else if (Build.VERSION.SDK_INT >= 21)
              {
                localObject3 = android.webkit.CookieManager.getInstance();
                String str1 = ((CookieManager.b)localObject4).b;
                String str2 = ((CookieManager.b)localObject4).c;
                localObject4 = ((CookieManager.b)localObject4).d;
                i.a(localObject3, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { str1, str2, localObject4 });
              }
            }
          }
        }
        this.a.clear();
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      long l2;
      long l1;
      Object localObject1;
      boolean bool1;
      int k;
      int j;
      try
      {
        if ((this.c != CookieManager.a.a) && (paramContext != null) && (TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")) && (!this.e))
        {
          l2 = System.currentTimeMillis();
          l1 = 0L;
          localObject1 = LOGTAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("compatiableCookieDatabaseIfNeed,isX5Inited:");
          ((StringBuilder)localObject2).append(paramBoolean1);
          ((StringBuilder)localObject2).append(",useX5:");
          ((StringBuilder)localObject2).append(paramBoolean2);
          TbsLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
          if ((!paramBoolean1) && (!QbSdk.getIsSysWebViewForcedByOuter()) && (!QbSdk.a))
          {
            x.a().a(paramContext, null);
            return;
          }
          bool1 = QbSdk.getIsSysWebViewForcedByOuter();
          paramBoolean1 = false;
          if ((bool1) || (QbSdk.a)) {
            break label609;
          }
          bool1 = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "usex5.txt");
          localObject1 = LOGTAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("usex5 : mUseX5LastProcess->");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(",useX5:");
          ((StringBuilder)localObject2).append(paramBoolean2);
          TbsLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
          TbsExtensionFunctionManager.getInstance().setFunctionEnable(paramContext, "usex5.txt", paramBoolean2);
          if (bool1 == paramBoolean2) {
            return;
          }
          localObject1 = TbsLogReport.getInstance(paramContext).tbsLogInfo();
          if (!TextUtils.isEmpty(this.b))
          {
            if (p.a().j(paramContext) > 0)
            {
              i = p.a().j(paramContext);
              if (i < 36001) {
                return;
              }
            }
            if (bool1)
            {
              k = j.d(paramContext);
              j = k;
              if (k > 0)
              {
                int m = getROMCookieDBVersion(paramContext);
                j = k;
                i = m;
                if (m > 0) {
                  continue;
                }
                paramBoolean1 = true;
                j = k;
                i = m;
                continue;
              }
            }
            else
            {
              i = j.d(paramContext);
              j = i;
              if (i > 0)
              {
                localObject2 = p.a().d(paramContext, "cookies_database_version");
                boolean bool2 = TextUtils.isEmpty((CharSequence)localObject2);
                j = i;
                if (bool2) {}
              }
            }
          }
        }
      }
      finally {}
      try
      {
        k = Integer.parseInt((String)localObject2);
        j = i;
        i = k;
      }
      catch (Exception localException)
      {
        j = i;
        continue;
      }
      int i = 0;
      if ((!paramBoolean1) && ((j <= 0) || (i <= 0)))
      {
        ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(702);
      }
      else if (i >= j)
      {
        ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(703);
      }
      else
      {
        j.a(paramContext, this.c, this.b, paramBoolean1, paramBoolean2);
        ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(704);
        l1 = System.currentTimeMillis() - l2;
        continue;
        ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(701);
        j = 0;
        i = 0;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("x5->sys:");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" from:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(" to:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",timeused:");
      ((StringBuilder)localObject2).append(l1);
      ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail(((StringBuilder)localObject2).toString());
      TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, (TbsLogReport.TbsLogInfo)localObject1);
      return;
      return;
      label609:
      paramBoolean2 = false;
    }
  }
  
  public boolean acceptCookie()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().d();
    }
    return android.webkit.CookieManager.getInstance().acceptCookie();
  }
  
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    try
    {
      Object localObject = x.a();
      boolean bool;
      if ((localObject != null) && (((x)localObject).b()))
      {
        localObject = ((x)localObject).c().b();
        paramWebView = paramWebView.getView();
        paramWebView = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[] { Object.class }, new Object[] { paramWebView });
        if (paramWebView != null)
        {
          bool = ((Boolean)paramWebView).booleanValue();
          return bool;
        }
        return true;
      }
      int i = Build.VERSION.SDK_INT;
      if (i < 21) {
        return true;
      }
      localObject = android.webkit.CookieManager.getInstance();
      paramWebView = paramWebView.getView();
      paramWebView = i.a(localObject, "acceptThirdPartyCookies", new Class[] { android.webkit.WebView.class }, new Object[] { paramWebView });
      if (paramWebView != null)
      {
        bool = ((Boolean)paramWebView).booleanValue();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public void flush()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    i.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
  }
  
  public String getCookie(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().a(paramString);
    }
    try
    {
      paramString = android.webkit.CookieManager.getInstance().getCookie(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean hasCookies()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().h();
    }
    return android.webkit.CookieManager.getInstance().hasCookies();
  }
  
  @Deprecated
  public void removeAllCookie()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
    localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      ((x)localObject).c().e();
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
    localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      ((x)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    i.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  @Deprecated
  public void removeExpiredCookie()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
  }
  
  @Deprecated
  public void removeSessionCookie()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    i.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    try
    {
      x localx = x.a();
      if ((localx != null) && (localx.b())) {
        localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      } else {
        try
        {
          android.webkit.CookieManager.getInstance().setAcceptCookie(paramBoolean);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      return;
    }
    finally {}
  }
  
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    try
    {
      Object localObject = x.a();
      Class localClass;
      if ((localObject != null) && (((x)localObject).b()))
      {
        localObject = ((x)localObject).c().b();
        localClass = Boolean.TYPE;
        paramWebView = paramWebView.getView();
        ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[] { Object.class, localClass }, new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
      }
      else
      {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
          return;
        }
        localObject = android.webkit.CookieManager.getInstance();
        localClass = Boolean.TYPE;
        paramWebView = paramWebView.getView();
        i.a(localObject, "setAcceptThirdPartyCookies", new Class[] { android.webkit.WebView.class, localClass }, new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
      }
      return;
    }
    finally {}
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      setCookie(paramString1, paramString2, false);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    try
    {
      Object localObject = x.a();
      if ((localObject != null) && (((x)localObject).b()))
      {
        ((x)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
      }
      else
      {
        if (!x.a().d())
        {
          localObject = new CookieManager.b(this);
          ((CookieManager.b)localObject).a = 1;
          ((CookieManager.b)localObject).b = paramString1;
          ((CookieManager.b)localObject).c = paramString2;
          ((CookieManager.b)localObject).d = paramValueCallback;
          if (this.a == null) {
            this.a = new CopyOnWriteArrayList();
          }
          this.a.add(localObject);
        }
        if (this.f)
        {
          int i = Build.VERSION.SDK_INT;
          if (i < 21) {
            return;
          }
          i.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
        }
      }
      return;
    }
    finally {}
  }
  
  public void setCookie(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Object localObject = x.a();
      if ((localObject != null) && (((x)localObject).b()))
      {
        ((x)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
      }
      else
      {
        if ((this.f) || (paramBoolean)) {
          android.webkit.CookieManager.getInstance().setCookie(paramString1, paramString2);
        }
        if (!x.a().d())
        {
          localObject = new CookieManager.b(this);
          ((CookieManager.b)localObject).a = 2;
          ((CookieManager.b)localObject).b = paramString1;
          ((CookieManager.b)localObject).c = paramString2;
          ((CookieManager.b)localObject).d = null;
          if (this.a == null) {
            this.a = new CopyOnWriteArrayList();
          }
          this.a.add(localObject);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean setCookieCompatialbeMode(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramContext != null) && (TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")))
    {
      this.c = parama;
      if (paramString != null) {
        this.b = paramString;
      }
      if ((this.c != CookieManager.a.a) && (paramBoolean) && (!x.a().d())) {
        x.a().a(paramContext, null);
      }
      return true;
    }
    return false;
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    Object localObject = x.a();
    boolean bool;
    if ((localObject != null) && (((x)localObject).b())) {
      bool = ((x)localObject).c().a(paramMap);
    } else {
      bool = false;
    }
    if (!bool)
    {
      localObject = paramMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        String[] arrayOfString = (String[])paramMap.get(str);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          setCookie(str, arrayOfString[i]);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */