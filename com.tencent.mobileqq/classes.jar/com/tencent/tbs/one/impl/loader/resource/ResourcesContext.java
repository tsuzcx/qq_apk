package com.tencent.tbs.one.impl.loader.resource;

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
import com.tencent.tbs.one.impl.base.Logging;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ResourcesContext
  extends ContextWrapper
{
  private static final String ATLAS_RESOURCES_CLASS = "android.taobao.atlas.runtime.DelegateResources";
  private static Method sAddAssetPathMethod;
  private LayoutInflaterImpl mLayoutInflater;
  private String mPackageName;
  private Resources mResources;
  private Resources.Theme mTheme;
  
  static
  {
    try
    {
      sAddAssetPathMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public ResourcesContext(Context paramContext, String paramString)
  {
    super(paramContext);
    Object localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (localObject != null)
    {
      localObject = ((PackageInfo)localObject).applicationInfo;
      if (localObject != null)
      {
        this.mPackageName = ((ApplicationInfo)localObject).packageName;
        ((ApplicationInfo)localObject).sourceDir = paramString;
        ((ApplicationInfo)localObject).publicSourceDir = paramString;
      }
    }
    for (;;)
    {
      try
      {
        this.mResources = paramContext.getPackageManager().getResourcesForApplication((ApplicationInfo)localObject);
        if (this.mResources != null)
        {
          this.mTheme = this.mResources.newTheme();
          paramContext = getBaseContext().getTheme();
          if (paramContext != null) {
            this.mTheme.setTo(paramContext);
          }
          int i = ((ApplicationInfo)localObject).theme;
          if (i != 0) {
            this.mTheme.applyStyle(i, true);
          }
          this.mLayoutInflater = new LayoutInflaterImpl(this);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.mResources = newResources(paramContext, paramString);
        continue;
        Logging.w("Failed to create resource info from %s", new Object[] { paramString });
        continue;
      }
      Logging.w("Failed to get application info from %s", new Object[] { paramString });
      continue;
      Logging.w("Failed to get package info from %s", new Object[] { paramString });
    }
  }
  
  private Intent adjustIntent(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    return paramIntent;
  }
  
  public static Resources newResources(Context paramContext, String paramString)
  {
    if (sAddAssetPathMethod == null) {
      return null;
    }
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      sAddAssetPathMethod.invoke(localAssetManager, new Object[] { paramString });
      Object localObject = paramContext.getResources();
      paramContext = ((Resources)localObject).getDisplayMetrics();
      Configuration localConfiguration = ((Resources)localObject).getConfiguration();
      localObject = localObject.getClass();
      boolean bool = "android.taobao.atlas.runtime.DelegateResources".equals(((Class)localObject).getName());
      if (!bool) {
        try
        {
          localObject = (Resources)((Class)localObject).getConstructor(new Class[] { AssetManager.class, DisplayMetrics.class, Configuration.class }).newInstance(new Object[] { localAssetManager, paramContext, localConfiguration });
          return localObject;
        }
        catch (Throwable localThrowable) {}
      }
      paramContext = new Resources(localAssetManager, paramContext, localConfiguration);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logging.w("Failed to new resources from %s", new Object[] { paramString, paramContext });
    }
    return null;
  }
  
  public AssetManager getAssets()
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
  
  public LayoutInflaterImpl getLayoutInflater()
  {
    return this.mLayoutInflater;
  }
  
  public String getPackageName()
  {
    if (this.mPackageName != null) {
      return this.mPackageName;
    }
    return super.getPackageName();
  }
  
  public Resources getResources()
  {
    if (this.mResources != null) {
      return this.mResources;
    }
    return super.getResources();
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString)) {
      return this.mLayoutInflater;
    }
    return super.getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    if (this.mTheme != null) {
      return this.mTheme;
    }
    return super.getTheme();
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mTheme != null)
    {
      this.mTheme.applyStyle(paramInt, true);
      return;
    }
    super.setTheme(paramInt);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(adjustIntent(paramIntent));
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return super.startService(adjustIntent(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.resource.ResourcesContext
 * JD-Core Version:    0.7.0.1
 */