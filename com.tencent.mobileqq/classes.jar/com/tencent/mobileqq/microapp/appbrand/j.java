package com.tencent.mobileqq.microapp.appbrand;

import Wallet.ApkgConfig;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class j
  implements k
{
  FrameLayout a;
  private BaseActivity b;
  private LinkedList c;
  
  public j(BaseActivity paramBaseActivity, FrameLayout paramFrameLayout)
  {
    this.b = paramBaseActivity;
    this.c = new LinkedList();
    this.a = paramFrameLayout;
  }
  
  private void a(c paramc, Throwable paramThrowable)
  {
    if ((paramc == null) || (paramThrowable == null)) {}
    do
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scene", "AppBrandRuntimeContainer init");
        localJSONObject.put("miniAppId", paramc.d);
        if (paramc.b != null) {
          localJSONObject.put("page", paramc.b.f);
        }
        paramc = new StringBuilder(256);
        paramc.append(paramThrowable.toString());
        if (paramThrowable.getStackTrace() != null)
        {
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int i = 0;
          while ((i < arrayOfStackTraceElement.length) && (i < 16))
          {
            paramc.append("\n ");
            paramc.append(arrayOfStackTraceElement[i].toString());
            i += 1;
          }
        }
        paramc = paramc.toString();
        VACDReportUtil.a(localJSONObject.toString(), "MiniAppStat", "MiniAppCrashReport", "Catch", null, 88888, paramc);
        return;
      }
      catch (Throwable paramc) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppBrandRuntimeContainer", 2, paramThrowable, new Object[0]);
  }
  
  public final a a()
  {
    return (a)this.c.peek();
  }
  
  public a a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntimeContainer", 2, "getAppBrandRunTime appId=" + paramString + ",versionType=" + paramInt);
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((locala.a.equals(paramString)) && (paramInt == locala.b)) {
        return locala;
      }
    }
    return null;
  }
  
  public final void a(c paramc, String paramString)
  {
    if (paramc == null) {
      return;
    }
    a locala = a(paramc.d, paramc.f.getRuntimeType());
    if (locala != null)
    {
      locala.a(paramc);
      return;
    }
    try
    {
      locala = new a(this.b, this, paramc);
      locala.a(paramString, false);
      b(locala);
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AppBrandRuntimeContainer", 2, paramString, new Object[0]);
      }
      a(paramc, paramString);
      paramc = new b.a(-1, paramc.f.config.mini_appid, paramc.f.getRuntimeType(), null);
      b.a().a(paramc);
    }
  }
  
  public void a(a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntimeContainer", 2, "bringToFront appBrandRuntime=" + parama);
    }
    if (parama != null)
    {
      this.c.remove(parama);
      this.c.push(parama);
    }
  }
  
  public a b()
  {
    if (this.c.size() < 2) {
      return null;
    }
    return (a)this.c.get(1);
  }
  
  public final void b(a parama)
  {
    a locala = (a)this.c.peekLast();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntimeContainer", 2, "addAppBrandRunTime currSize=" + c() + ",insertAppBrandRunTime=" + parama + ",lastAppBrandRuntime=" + locala);
    }
    this.c.push(parama);
    this.a.addView(parama.g);
    if ((c() > 10) && (locala != null)) {
      locala.b();
    }
  }
  
  public final int c()
  {
    return this.c.size();
  }
  
  public final void c(a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntimeContainer", 2, "removeAppBrandRunTime r=" + parama);
    }
    if (parama != null)
    {
      this.a.removeView(parama.g);
      parama.a();
      this.c.remove(parama);
    }
  }
  
  public final void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntimeContainer", 2, "cleanup appRunTime size = " + c());
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null)
      {
        this.a.removeView(locala.g);
        locala.a();
        localIterator.remove();
      }
    }
  }
  
  public void e()
  {
    d();
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.j
 * JD-Core Version:    0.7.0.1
 */