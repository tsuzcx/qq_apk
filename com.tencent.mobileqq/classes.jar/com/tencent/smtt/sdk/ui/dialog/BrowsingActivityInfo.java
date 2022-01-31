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
import java.util.Map;

public class BrowsingActivityInfo
{
  private Context mApp;
  private Drawable mIcon;
  private String mLabel;
  private String mPackageName;
  private int mProgress = 0;
  private ResolveInfo mResolveInfo;
  
  BrowsingActivityInfo(Context paramContext, ResolveInfo paramResolveInfo)
  {
    this.mApp = paramContext.getApplicationContext();
    this.mResolveInfo = paramResolveInfo;
    this.mIcon = null;
    this.mLabel = null;
    this.mPackageName = null;
  }
  
  BrowsingActivityInfo(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2)
  {
    this.mApp = paramContext.getApplicationContext();
    this.mResolveInfo = null;
    this.mIcon = paramDrawable;
    this.mLabel = paramString1;
    this.mPackageName = paramString2;
  }
  
  public static Drawable getApkIcon(Context paramContext, String paramString)
  {
    TypedValue localTypedValue = null;
    if ("com.tencent.mtt".equals(paramString)) {}
    for (;;)
    {
      try
      {
        paramContext = TBSResources.getDrawable("application_icon");
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
  
  public Drawable getIcon()
  {
    return getIcon(null);
  }
  
  public Drawable getIcon(Map<String, Drawable> paramMap)
  {
    Drawable localDrawable = getApkIcon(this.mApp, getPackageName());
    paramMap = localDrawable;
    if (localDrawable == null)
    {
      if (this.mResolveInfo != null) {
        paramMap = this.mResolveInfo.loadIcon(this.mApp.getPackageManager());
      }
    }
    else {
      return paramMap;
    }
    return this.mIcon;
  }
  
  public String getLabel()
  {
    if (this.mResolveInfo != null) {
      return this.mResolveInfo.loadLabel(this.mApp.getPackageManager()).toString();
    }
    return this.mLabel;
  }
  
  public String getPackageName()
  {
    if (this.mResolveInfo != null) {
      return this.mResolveInfo.activityInfo.packageName;
    }
    if (this.mPackageName == null) {
      return "";
    }
    return this.mPackageName;
  }
  
  public ResolveInfo getResolveInfo()
  {
    return this.mResolveInfo;
  }
  
  public void setResolveInfo(ResolveInfo paramResolveInfo)
  {
    this.mResolveInfo = paramResolveInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.BrowsingActivityInfo
 * JD-Core Version:    0.7.0.1
 */