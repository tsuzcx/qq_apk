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
    try
    {
      localDrawable1 = paramContext.getResources().getDrawable(paramInt);
    }
    catch (Exception localException)
    {
      Drawable localDrawable1;
      label50:
      Drawable localDrawable2;
      break label50;
    }
    localDrawable1 = null;
    localDrawable2 = localDrawable1;
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
    if ("com.tencent.mtt".equals(paramString)) {
      try
      {
        paramContext = e.a("application_icon");
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("getApkIcon Error:");
        paramString.append(Log.getStackTraceString(paramContext));
        Log.e("error", paramString.toString());
        return null;
      }
    }
    Object localObject = paramContext.getApplicationContext().getPackageManager();
    try
    {
      paramContext = ((PackageManager)localObject).getApplicationInfo(paramString, 128);
      if (paramContext == null) {
        return null;
      }
      paramString = ((PackageManager)localObject).getResourcesForApplication(paramContext);
      localObject = new TypedValue();
      paramString.getValue(paramContext.icon, (TypedValue)localObject, true);
      paramContext = ((TypedValue)localObject).string.toString();
      return null;
    }
    catch (Exception paramContext)
    {
      try
      {
        paramContext = Drawable.createFromResourceStream(paramString, (TypedValue)localObject, new BufferedInputStream(paramString.getAssets().openNonAssetFd(((TypedValue)localObject).assetCookie, paramContext).createInputStream()), null);
        return paramContext;
      }
      catch (Exception paramContext) {}
      paramContext = paramContext;
      paramString = new StringBuilder();
      paramString.append("e = ");
      paramString.append(paramContext);
      Log.e("sdk", paramString.toString());
      return null;
    }
  }
  
  public Drawable a()
  {
    Object localObject = this.c;
    if (localObject != null) {
      return localObject;
    }
    Drawable localDrawable = a(this.a, d());
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((ResolveInfo)localObject).loadIcon(this.a.getPackageManager());
      }
      localObject = this.c;
    }
    return localObject;
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
    ResolveInfo localResolveInfo = this.b;
    if (localResolveInfo != null) {
      return localResolveInfo.loadLabel(this.a.getPackageManager()).toString();
    }
    return this.d;
  }
  
  public ResolveInfo c()
  {
    return this.b;
  }
  
  public String d()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return ((ResolveInfo)localObject).activityInfo.packageName;
    }
    String str = this.f;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.b
 * JD-Core Version:    0.7.0.1
 */