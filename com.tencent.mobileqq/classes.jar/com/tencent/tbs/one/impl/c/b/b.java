package com.tencent.tbs.one.impl.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import com.tencent.tbs.one.impl.a.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class b
  extends ContextWrapper
{
  private static Method b;
  public a a;
  private Resources c;
  private Resources.Theme d;
  private String e;
  
  static
  {
    try
    {
      b = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public b(Context paramContext, String paramString)
  {
    super(paramContext);
    Object localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (localObject != null)
    {
      localObject = ((PackageInfo)localObject).applicationInfo;
      if (localObject != null)
      {
        this.e = ((ApplicationInfo)localObject).packageName;
        ((ApplicationInfo)localObject).sourceDir = paramString;
        ((ApplicationInfo)localObject).publicSourceDir = paramString;
      }
    }
    try
    {
      this.c = paramContext.getPackageManager().getResourcesForApplication((ApplicationInfo)localObject);
    }
    catch (Throwable localThrowable)
    {
      label70:
      int i;
      break label70;
    }
    this.c = a(paramContext, paramString);
    paramContext = this.c;
    if (paramContext != null)
    {
      this.d = paramContext.newTheme();
      paramContext = getBaseContext().getTheme();
      if (paramContext != null) {
        this.d.setTo(paramContext);
      }
      i = ((ApplicationInfo)localObject).theme;
      if (i != 0) {
        this.d.applyStyle(i, true);
      }
    }
    else
    {
      f.b("Failed to create resource info from %s", new Object[] { paramString });
      break label183;
      f.b("Failed to get application info from %s", new Object[] { paramString });
      break label183;
      f.b("Failed to get package info from %s", new Object[] { paramString });
    }
    label183:
    this.a = new a(this);
  }
  
  private Intent a(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    return paramIntent;
  }
  
  private static Resources a(Context paramContext, String paramString)
  {
    if (b == null) {
      return null;
    }
    try
    {
      localAssetManager = (AssetManager)AssetManager.class.newInstance();
      b.invoke(localAssetManager, new Object[] { paramString });
      localObject = paramContext.getResources();
      paramContext = ((Resources)localObject).getDisplayMetrics();
      localConfiguration = ((Resources)localObject).getConfiguration();
      localObject = localObject.getClass();
      boolean bool = "android.taobao.atlas.runtime.DelegateResources".equals(((Class)localObject).getName());
      if (bool) {}
    }
    catch (Throwable paramContext)
    {
      AssetManager localAssetManager;
      Object localObject;
      Configuration localConfiguration;
      label126:
      f.b("Failed to new resources from %s", new Object[] { paramString, paramContext });
      return null;
    }
    try
    {
      localObject = (Resources)((Class)localObject).getConstructor(new Class[] { AssetManager.class, DisplayMetrics.class, Configuration.class }).newInstance(new Object[] { localAssetManager, paramContext, localConfiguration });
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      break label126;
    }
    paramContext = new Resources(localAssetManager, paramContext, localConfiguration);
    return paramContext;
  }
  
  public final AssetManager getAssets()
  {
    Object localObject = getResources();
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getAssets();
      if (localObject != null) {
        return localObject;
      }
    }
    return super.getAssets();
  }
  
  public final String getPackageName()
  {
    String str = this.e;
    if (str != null) {
      return str;
    }
    return super.getPackageName();
  }
  
  public final Resources getResources()
  {
    Resources localResources = this.c;
    if (localResources != null) {
      return localResources;
    }
    return super.getResources();
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString)) {
      return this.a;
    }
    return super.getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    Resources.Theme localTheme = this.d;
    if (localTheme != null) {
      return localTheme;
    }
    return super.getTheme();
  }
  
  public final void setTheme(int paramInt)
  {
    Resources.Theme localTheme = this.d;
    if (localTheme != null)
    {
      localTheme.applyStyle(paramInt, true);
      return;
    }
    super.setTheme(paramInt);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    super.startActivity(a(paramIntent));
  }
  
  public final ComponentName startService(Intent paramIntent)
  {
    return super.startService(a(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.b
 * JD-Core Version:    0.7.0.1
 */