package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import java.io.BufferedInputStream;

public class b
{
  private Context a;
  private ResolveInfo b;
  private Drawable c;
  private String d = "";
  private String e = "";
  private String f;
  private boolean g = false;
  private boolean h = false;
  private String i = "";
  
  b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != -1) {}
    for (;;)
    {
      try
      {
        Drawable localDrawable1 = paramContext.getResources().getDrawable(paramInt);
        Drawable localDrawable2 = localDrawable1;
        if (localDrawable1 == null) {
          localDrawable2 = e.a("application_icon");
        }
        this.a = paramContext.getApplicationContext();
        this.b = null;
        this.f = null;
        this.c = localDrawable2;
        this.d = paramString2;
        this.g = true;
        this.i = paramString1;
        return;
      }
      catch (Exception localException)
      {
        localObject = null;
        continue;
      }
      Object localObject = null;
    }
  }
  
  b(Context paramContext, ResolveInfo paramResolveInfo)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramResolveInfo;
    this.c = null;
    this.d = null;
    this.f = null;
  }
  
  b(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramContext.getApplicationContext();
    this.b = null;
    this.c = paramDrawable;
    this.d = paramString1;
    this.f = paramString2;
    this.h = true;
    this.e = paramString3;
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    TypedValue localTypedValue = null;
    if ("com.tencent.mtt".equals(paramString)) {}
    for (;;)
    {
      try
      {
        paramContext = e.a("application_icon");
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        Log.e("error", "getApkIcon Error:" + Log.getStackTraceString(paramContext));
        return null;
      }
      PackageManager localPackageManager = paramContext.getApplicationContext().getPackageManager();
      try
      {
        paramString = localPackageManager.getApplicationInfo(paramString, 128);
        paramContext = localTypedValue;
        if (paramString == null) {
          continue;
        }
        paramContext = localPackageManager.getResourcesForApplication(paramString);
        localTypedValue = new TypedValue();
        paramContext.getValue(paramString.icon, localTypedValue, true);
        paramString = localTypedValue.string.toString();
        return null;
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = Drawable.createFromResourceStream(paramContext, localTypedValue, new BufferedInputStream(paramContext.getAssets().openNonAssetFd(localTypedValue.assetCookie, paramString).createInputStream()), null);
          return paramContext;
        }
        catch (Exception paramContext) {}
        paramContext = paramContext;
        Log.e("sdk", "e = " + paramContext);
        return null;
      }
    }
  }
  
  public Drawable a()
  {
    Object localObject;
    if (this.c != null) {
      localObject = this.c;
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      localDrawable = a(this.a, d());
      localObject = localDrawable;
    } while (localDrawable != null);
    if (this.b != null) {
      return this.b.loadIcon(this.a.getPackageManager());
    }
    return this.c;
  }
  
  public void a(ResolveInfo paramResolveInfo)
  {
    this.b = paramResolveInfo;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.c = paramDrawable;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public String b()
  {
    if (this.b != null) {
      return this.b.loadLabel(this.a.getPackageManager()).toString();
    }
    return this.d;
  }
  
  public ResolveInfo c()
  {
    return this.b;
  }
  
  public String d()
  {
    if (this.b != null) {
      return this.b.activityInfo.packageName;
    }
    if (this.f == null) {
      return "";
    }
    return this.f;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.b
 * JD-Core Version:    0.7.0.1
 */