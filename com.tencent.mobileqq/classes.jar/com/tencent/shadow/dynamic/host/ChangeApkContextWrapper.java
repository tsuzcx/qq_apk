package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;

class ChangeApkContextWrapper
  extends ContextWrapper
{
  private final ClassLoader mClassloader;
  private LayoutInflater mLayoutInflater;
  private Resources mResources;
  
  ChangeApkContextWrapper(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    super(paramContext);
    this.mClassloader = paramClassLoader;
    this.mResources = createResources(paramString, paramContext);
  }
  
  private Resources createResources(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    PackageInfo localPackageInfo = paramContext.getPackageArchiveInfo(paramString, 128);
    localPackageInfo.applicationInfo.publicSourceDir = paramString;
    localPackageInfo.applicationInfo.sourceDir = paramString;
    try
    {
      paramString = paramContext.getResourcesForApplication(localPackageInfo.applicationInfo);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public AssetManager getAssets()
  {
    return this.mResources.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    return this.mClassloader;
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mLayoutInflater == null) {
        this.mLayoutInflater = ((LayoutInflater)super.getSystemService(paramString)).cloneInContext(this);
      }
      return this.mLayoutInflater;
    }
    return super.getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    return this.mResources.newTheme();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.ChangeApkContextWrapper
 * JD-Core Version:    0.7.0.1
 */