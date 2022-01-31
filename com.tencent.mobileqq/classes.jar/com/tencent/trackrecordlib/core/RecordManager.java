package com.tencent.trackrecordlib.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import com.tencent.trackrecordlib.g.f;
import org.json.JSONObject;

public class RecordManager
{
  private static final String c = RecordManager.class.getSimpleName();
  private static boolean d = false;
  public Context a;
  public boolean b = false;
  private com.tencent.trackrecordlib.e.a e;
  private com.tencent.trackrecordlib.e.a f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private IRecordCallback j;
  
  private void a(Context paramContext, IRecordConfig paramIRecordConfig, IRecordCallback paramIRecordCallback)
  {
    com.tencent.trackrecordlib.g.c.a = paramContext.getPackageName();
    if ((paramIRecordConfig != null) && (paramIRecordConfig.getTitleBarId() != null)) {
      com.tencent.trackrecordlib.g.c.c = paramIRecordConfig.getTitleBarId();
    }
    if ((paramIRecordConfig != null) && (paramIRecordConfig.isEnableRelease())) {
      this.g = paramIRecordConfig.isEnableRelease();
    }
    if ((paramIRecordConfig != null) && (paramIRecordConfig.getCachedEventSize() > 0)) {
      c.a().a(paramIRecordConfig.getCachedEventSize());
    }
    if ((paramIRecordConfig != null) && (paramIRecordConfig.isFilterUGC())) {
      this.b = paramIRecordConfig.isFilterUGC();
    }
    if (paramIRecordCallback != null) {
      this.j = paramIRecordCallback;
    }
  }
  
  private boolean a()
  {
    Log.i(c, "SDK_INT: " + Build.VERSION.SDK_INT);
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private boolean a(Context paramContext)
  {
    return (paramContext != null) && ((paramContext instanceof Application));
  }
  
  private boolean a(Object paramObject)
  {
    return ((paramObject instanceof Dialog)) || ((paramObject instanceof View));
  }
  
  private void b()
  {
    new b().start();
  }
  
  private boolean b(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int k = paramContext.getApplicationInfo().flags;
      if ((k & 0x2) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private void c()
  {
    new d().start();
  }
  
  private void d()
  {
    a.a().a(this.a);
  }
  
  private void e()
  {
    this.e = new com.tencent.trackrecordlib.e.b(this.a);
    this.e.a();
  }
  
  private void f()
  {
    this.f = new com.tencent.trackrecordlib.e.c(this.a);
    this.f.a();
  }
  
  public static RecordManager getInstance()
  {
    return RecordManager.a.a();
  }
  
  @TargetApi(21)
  public String getUserEvents()
  {
    return c.a().b();
  }
  
  public boolean isEnableExposure()
  {
    return this.h;
  }
  
  public boolean isEnableRecord()
  {
    return d;
  }
  
  public void recordEvent(com.tencent.trackrecordlib.c.b paramb)
  {
    if (d)
    {
      paramb = paramb.e().toString();
      Log.d(c, "eventMsg: " + paramb);
      if (this.j != null) {
        this.j.onRecordEvent(paramb);
      }
    }
  }
  
  public void setElementId(Object paramObject, String paramString)
  {
    if (!this.h) {}
    while (!a(paramObject)) {
      return;
    }
    com.tencent.trackrecordlib.d.a.e.a(paramObject, paramString);
  }
  
  public void setEnableExposure(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return;
    }
    finally {}
  }
  
  public void setEnableRecord(boolean paramBoolean)
  {
    try
    {
      d = paramBoolean;
      return;
    }
    finally {}
  }
  
  public void setRecentActivityName(Activity paramActivity)
  {
    if (this.i) {
      return;
    }
    com.tencent.trackrecordlib.g.b.a(paramActivity);
    try
    {
      this.i = true;
      return;
    }
    finally {}
  }
  
  @TargetApi(21)
  public void startRecord(Context paramContext)
  {
    startRecord(paramContext, null, null);
  }
  
  @TargetApi(21)
  public void startRecord(Context paramContext, IRecordConfig paramIRecordConfig, IRecordCallback paramIRecordCallback)
  {
    Log.d(c, "start record!");
    if ((d) || (!a())) {}
    for (;;)
    {
      return;
      if (!a(paramContext))
      {
        Log.e(c, "start record failed without Application Context!");
        return;
      }
      this.a = paramContext.getApplicationContext();
      a(this.a, paramIRecordConfig, paramIRecordCallback);
      if ((!b(this.a)) && (!this.g)) {
        continue;
      }
      try
      {
        d = true;
        b();
        c();
        d();
        if (!com.tencent.trackrecordlib.g.e.b(this.a)) {
          continue;
        }
        f.a(this.a);
        e();
        f();
        return;
      }
      finally {}
    }
  }
  
  @TargetApi(21)
  public void stopRecord()
  {
    Log.d(c, "stop record!");
    if (d) {}
    try
    {
      d = false;
      if (this.a != null)
      {
        a.a().b(this.a);
        f.b(this.a);
      }
      if (this.e != null) {
        this.e.b();
      }
      if (this.f != null) {
        this.f.b();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.RecordManager
 * JD-Core Version:    0.7.0.1
 */