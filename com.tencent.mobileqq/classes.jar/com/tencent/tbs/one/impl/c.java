package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.e.h;
import java.io.File;

public final class c
  extends TBSOneManager
{
  private final Object a = new Object();
  private String b;
  private h c;
  private boolean d;
  
  public c(Context paramContext, String paramString)
  {
    a.a(paramContext);
    f.a("[%s] Initializing %s (%s)", new Object[] { paramString, "0.0.1", "20201029172852" });
    this.b = paramString;
    this.c = a.a(paramContext, paramString);
  }
  
  private void a()
  {
    synchronized (this.a)
    {
      this.d = true;
      return;
    }
  }
  
  public final void configure(String paramString, Object paramObject)
  {
    f.a("[%s] Configuring %s = %s", new Object[] { this.b, paramString, paramObject });
    this.c.a(paramString, paramObject);
  }
  
  public final String getBuildNumber()
  {
    return "20201029172852";
  }
  
  public final TBSOneDebugger getDebugger()
  {
    return this.c.d();
  }
  
  public final int[] getInstalledVersionCodesOfComponent(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public final TBSOneComponent getLoadedComponent(String paramString)
  {
    return this.c.e(paramString);
  }
  
  public final TBSOneOnlineService getOnlineService()
  {
    a();
    return this.c.c();
  }
  
  public final int getVersionCode()
  {
    return 1;
  }
  
  public final String getVersionName()
  {
    return "0.0.1";
  }
  
  public final void installComponent(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    f.a("[%s] Installing component %s with options %s", new Object[] { this.b, paramString, paramBundle });
    a();
    m.a(new c.2(this, paramString, paramBundle, paramTBSOneCallback));
  }
  
  public final void installComponent(String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    installComponent(paramString, null, paramTBSOneCallback);
  }
  
  public final boolean isComponentInstalled(String paramString)
  {
    return this.c.b(paramString);
  }
  
  public final void loadComponentAsync(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    f.a("[%s] Loading component %s asynchronously", new Object[] { this.b, paramString });
    a();
    m.a(new c.3(this, paramString, paramBundle, paramTBSOneCallback));
  }
  
  public final void loadComponentAsync(String paramString, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    loadComponentAsync(paramString, null, paramTBSOneCallback);
  }
  
  public final TBSOneComponent loadComponentSync(String paramString, long paramLong)
  {
    return loadComponentSync(paramString, null, paramLong);
  }
  
  public final TBSOneComponent loadComponentSync(String paramString, Bundle paramBundle, long paramLong)
  {
    f.a("[%s] Loading component %s synchronously", new Object[] { this.b, paramString });
    if (!m.b())
    {
      a();
      b localb = new b();
      m.a(new c.4(this, paramString, paramBundle, localb));
      localb.a(paramLong);
      if (localb.b == 0) {
        return (TBSOneComponent)localb.a;
      }
      throw new TBSOneException(localb.b, localb.c);
    }
    throw new RuntimeException("TBSOneManager.loadComponentSync must not be called on TBSOne thread.");
  }
  
  public final void setAutoUpdateEnabled(boolean paramBoolean)
  {
    String str2 = this.b;
    String str1;
    if (paramBoolean) {
      str1 = "Enabling";
    } else {
      str1 = "Disabling";
    }
    f.a("[%s] %s auto update", new Object[] { str2, str1 });
    this.c.a(paramBoolean);
  }
  
  public final void setDelegate(TBSOneDelegate paramTBSOneDelegate)
  {
    f.a("[%s] Setting delegate %s", new Object[] { this.b, paramTBSOneDelegate });
    m.a(new c.1(this, paramTBSOneDelegate));
  }
  
  public final void setPolicy(TBSOneManager.Policy paramPolicy)
  {
    f.a("[%s] Setting policy %s", new Object[] { this.b, paramPolicy });
    synchronized (this.a)
    {
      if (this.d)
      {
        Log.println(5, "TBSOne", Log.getStackTraceString(new Throwable("TBSOneManager.setPolicy should be called before doing any other operations.")));
        return;
      }
      this.c.d = paramPolicy;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c
 * JD-Core Version:    0.7.0.1
 */