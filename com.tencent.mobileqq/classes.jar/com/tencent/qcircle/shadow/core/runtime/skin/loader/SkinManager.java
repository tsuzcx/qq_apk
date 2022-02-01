package com.tencent.qcircle.shadow.core.runtime.skin.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcircle.shadow.core.runtime.skin.listener.ISkinLoader;
import com.tencent.qcircle.shadow.core.runtime.skin.listener.ISkinUpdate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkinManager
  implements ISkinLoader
{
  public static final String TAG = "SkinManager";
  private static volatile SkinManager sInstance;
  private final List<ISkinUpdate> mSkinObservers = new ArrayList();
  private String mSkinPackageName;
  private Resources mSkinResource;
  private SkinPkgInfo mSkinResourceData;
  
  private SkinManager()
  {
    setSkinResource(null, null, SkinResFactory.createResourceData(5));
  }
  
  public static int getColor(int paramInt)
  {
    return SkinResLoader.getColor(paramInt, null);
  }
  
  public static int getColor(String paramString)
  {
    return SkinResLoader.getColor(paramString);
  }
  
  public static Drawable getDrawable(int paramInt)
  {
    return SkinResLoader.getDrawable(paramInt, null);
  }
  
  public static Drawable getDrawable(String paramString)
  {
    return SkinResLoader.getDrawable(paramString);
  }
  
  public static SkinManager getsInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new SkinManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static void setContext(Context paramContext)
  {
    ContextHolder.setContext(paramContext);
  }
  
  private void setSkinResource(Resources paramResources, String paramString, SkinPkgInfo paramSkinPkgInfo)
  {
    this.mSkinResource = paramResources;
    this.mSkinPackageName = paramString;
    this.mSkinResourceData = paramSkinPkgInfo;
  }
  
  public void attach(ISkinUpdate paramISkinUpdate)
  {
    if (!this.mSkinObservers.contains(paramISkinUpdate)) {
      this.mSkinObservers.add(paramISkinUpdate);
    }
  }
  
  public void detach(ISkinUpdate paramISkinUpdate)
  {
    this.mSkinObservers.remove(paramISkinUpdate);
  }
  
  public String getPackageName()
  {
    return this.mSkinPackageName;
  }
  
  public SkinPkgInfo getSkinResouceData()
  {
    return this.mSkinResourceData;
  }
  
  public Resources getSkinResource()
  {
    return this.mSkinResource;
  }
  
  public boolean loadSkinFile(SkinPkgInfo paramSkinPkgInfo)
  {
    String str = paramSkinPkgInfo.getSkinName();
    if (!new File(str).exists())
    {
      Log.e(TAG, "load file failed : no skin file or skinFilePath is Empty");
      return false;
    }
    try
    {
      localObject = ContextHolder.getContext().getPackageManager();
      PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageArchiveInfo(str, 1);
      if (localPackageInfo != null)
      {
        localPackageInfo.applicationInfo.publicSourceDir = str;
        localPackageInfo.applicationInfo.sourceDir = str;
        setSkinResource(((PackageManager)localObject).getResourcesForApplication(localPackageInfo.applicationInfo), localPackageInfo.packageName, paramSkinPkgInfo);
        notifySkinUpdate();
        return true;
      }
      return false;
    }
    catch (Exception paramSkinPkgInfo)
    {
      paramSkinPkgInfo.printStackTrace();
      str = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load file failed : ");
      ((StringBuilder)localObject).append(paramSkinPkgInfo);
      Log.e(str, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void loadSkinResource(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setSkinResource(null, null, SkinResFactory.createResourceData(5));
      return;
    }
    paramString = new SkinPkgInfo(15, paramString);
    getsInstance().loadSkinFile(paramString);
  }
  
  public void notifySkinUpdate()
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifySkinUpdate: ");
    localStringBuilder.append(this.mSkinObservers.size());
    Log.d((String)localObject, localStringBuilder.toString());
    localObject = this.mSkinObservers.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ISkinUpdate)((Iterator)localObject).next()).onThemeUpdate();
    }
  }
  
  public void restoreDefaultTheme()
  {
    setSkinResource(null, null, SkinResFactory.createResourceData(5));
    notifySkinUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.skin.loader.SkinManager
 * JD-Core Version:    0.7.0.1
 */