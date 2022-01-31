package com.tencent.mobileqq.microapp.appbrand;

import Wallet.ApkgConfig;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.c.c;
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
  
  private void a(f paramf, Throwable paramThrowable)
  {
    if ((paramf == null) || (paramThrowable == null)) {}
    do
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scene", "AppBrandRuntimeContainer init");
        localJSONObject.put("miniAppId", paramf.d);
        if (paramf.b != null) {
          localJSONObject.put("page", paramf.b.b);
        }
        paramf = new StringBuilder(256);
        paramf.append(paramThrowable.toString());
        if (paramThrowable.getStackTrace() != null)
        {
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int i = 0;
          while ((i < arrayOfStackTraceElement.length) && (i < 16))
          {
            paramf.append("\n ");
            paramf.append(arrayOfStackTraceElement[i].toString());
            i += 1;
          }
        }
        paramf = paramf.toString();
        VACDReportUtil.a(localJSONObject.toString(), "MiniAppStat", "MiniAppCrashReport", "Catch", null, 88888, paramf);
        return;
      }
      catch (Throwable paramf) {}
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
  
  public final void a(f paramf, String paramString)
  {
    if (paramf == null) {
      return;
    }
    a locala = a(paramf.d, paramf.f.getRuntimeType());
    if (locala != null)
    {
      locala.a(paramf);
      return;
    }
    try
    {
      locala = new a(this.b, this, paramf);
      locala.a(paramString, false);
      b(locala);
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AppBrandRuntimeContainer", 2, paramString, new Object[0]);
      }
      a(paramf, paramString);
      paramf = new b.a(-1, paramf.f.config.mini_appid, paramf.f.getRuntimeType(), null);
      b.a().a(paramf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.j
 * JD-Core Version:    0.7.0.1
 */