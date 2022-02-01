package org.xwalk.core.resource;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;

public class XWalkContextWrapper
  extends ContextWrapper
{
  private static final String GENERATED_RESOURCE_CLASS = "org.xwalk.core.R";
  private static final String TAG = "XWalkLib";
  private static String mPackageName;
  private static HashMap<Long, Integer> mResourcessKeyIdMap;
  static PackageInfo sInfo;
  static String sLastInfoStr;
  static Resources sResources;
  public int apkVersion = 0;
  public String extractedCoreDir;
  public int forceDarkBehavior = 2;
  public boolean isForceDarkMode = false;
  private ApplicationInfo mApplicationInfo;
  private ClassLoader mClassLoader;
  private Context mContext;
  private boolean mHasAddFilterResources = false;
  private final LayoutInflater mLayoutInflater;
  private Resources mResources;
  private Resources.Theme mTheme;
  public boolean usingCustomContext = false;
  
  public XWalkContextWrapper(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.apkVersion = paramInt;
    String str = XWalkEnvironment.getDownloadApkPath(paramInt);
    this.extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(paramInt);
    this.mContext = paramContext;
    this.mLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).cloneInContext(this);
    Object localObject = new XWalkContextWrapper.XWalkLayoutInflaterFactory(null);
    ((XWalkContextWrapper.XWalkLayoutInflaterFactory)localObject).layoutInflater = this.mLayoutInflater;
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactorySet");
      localField.setAccessible(true);
      localField.setBoolean(this.mLayoutInflater, false);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("XWalkContextWrapper mFactorySet");
      localStringBuilder.append(localIllegalAccessException.getMessage());
      Log.e("XWalkLib", localStringBuilder.toString());
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("XWalkContextWrapper mFactorySet");
      localStringBuilder.append(localNoSuchFieldException.getMessage());
      Log.e("XWalkLib", localStringBuilder.toString());
    }
    this.mLayoutInflater.setFactory((LayoutInflater.Factory)localObject);
    this.usingCustomContext = XWalkEnvironment.getUsingCustomContext();
    if (this.usingCustomContext) {
      this.mResources = new XWalkResource(getResources(paramContext, str), paramContext);
    } else {
      this.mResources = getResources(paramContext, str);
    }
    if (XWalkEnvironment.isCurrentVersionSupportForceDarkMode())
    {
      this.isForceDarkMode = XWalkEnvironment.getForceDarkMode();
      this.forceDarkBehavior = XWalkEnvironment.getForceDarkBehavior();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("force dark mode suopported isForceDarkMode:");
      ((StringBuilder)localObject).append(this.isForceDarkMode);
      ((StringBuilder)localObject).append(", forceDarkBehavior:");
      ((StringBuilder)localObject).append(this.forceDarkBehavior);
      Log.i("XWalkLib", ((StringBuilder)localObject).toString());
    }
    else
    {
      Log.i("XWalkLib", "force dark mode not suopported");
    }
    localObject = this.mResources;
    if ((localObject != null) && (this.mApplicationInfo != null))
    {
      this.mTheme = ((Resources)localObject).newTheme();
      if (getPackageInfo(paramContext, str) != null)
      {
        paramContext = paramContext.getTheme();
        if (paramContext != null) {
          this.mTheme.setTo(paramContext);
        }
        this.mTheme.applyStyle(this.mApplicationInfo.theme, true);
      }
    }
  }
  
  private boolean checkResApkExist(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        return true;
      }
    }
    return false;
  }
  
  private PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      if (paramString.equals(sLastInfoStr))
      {
        paramContext = sInfo;
        return paramContext;
      }
      sLastInfoStr = paramString;
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
      sInfo = paramContext;
      return paramContext;
    }
    finally {}
  }
  
  private Intent getRealIntent(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    return paramIntent;
  }
  
  private Resources getResources(Context paramContext, String paramString)
  {
    if (sResources != null)
    {
      initByPath(paramContext, paramString);
      return sResources;
    }
    Object localObject;
    if (checkResApkExist(paramString))
    {
      this.mApplicationInfo = initByPath(paramContext, paramString);
      localObject = this.mApplicationInfo;
      if (localObject != null)
      {
        ((ApplicationInfo)localObject).sourceDir = paramString;
        ((ApplicationInfo)localObject).publicSourceDir = paramString;
      }
    }
    try
    {
      localObject = paramContext.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
      if (localObject != null)
      {
        sResources = (Resources)localObject;
        localObject = sResources;
        return localObject;
      }
    }
    catch (PackageManager.NameNotFoundException|Throwable localNameNotFoundException)
    {
      label80:
      break label80;
    }
    Log.i("XWalkLib", "XWalkContextWrapper try getResourcesNotWithReflect failed, use getResourcesWithReflect");
    sResources = getResourcesWithReflect(paramContext, paramString);
    Log.i("XWalkLib", "XWalkContextWrapper checkResApkExist false");
    return sResources;
  }
  
  private Resources getResourcesWithReflect(Context paramContext, String paramString)
  {
    try
    {
      paramContext = (AssetManager)AssetManager.class.newInstance();
      paramContext.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString });
      paramString = super.getResources();
      paramContext = new Resources(paramContext, paramString.getDisplayMetrics(), paramString.getConfiguration());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("XWalkContextWrapper getResourcesWithReflect error:");
      paramString.append(paramContext.getMessage());
      Log.e("XWalkLib", paramString.toString());
    }
    return null;
  }
  
  private ApplicationInfo initByPath(Context paramContext, String paramString)
  {
    paramContext = getPackageInfo(paramContext, paramString);
    if (paramContext != null)
    {
      mPackageName = paramContext.packageName;
      this.mApplicationInfo = paramContext.applicationInfo;
      paramContext = this.mApplicationInfo;
      if (paramContext != null)
      {
        paramContext.sourceDir = paramString;
        paramContext.publicSourceDir = paramString;
      }
    }
    return this.mApplicationInfo;
  }
  
  public Context getApplicationContext()
  {
    return this.mContext.getApplicationContext();
  }
  
  public AssetManager getAssets()
  {
    Resources localResources = getResources();
    if (localResources != null) {
      return localResources.getAssets();
    }
    return super.getAssets();
  }
  
  public Context getBaseContext()
  {
    return this.mContext;
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject = this.mClassLoader;
    if (localObject != null) {
      return localObject;
    }
    localObject = XWalkCoreWrapper.getInstance();
    if (localObject != null) {
      return ((XWalkCoreWrapper)localObject).getBridgeLoader();
    }
    return super.getClassLoader();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.mLayoutInflater;
  }
  
  public String getPackageName()
  {
    return this.mContext.getPackageName();
  }
  
  public Context getPlatformContext()
  {
    return this.mContext;
  }
  
  public Resources getResources()
  {
    if (!this.mHasAddFilterResources)
    {
      localResources = this.mResources;
      if (WebViewExtension.addFilterResources(localResources, getResourcesKeyIdMap(localResources))) {
        this.mHasAddFilterResources = true;
      } else {
        Log.e("XWalkLib", "mHasAddFilterResources = false");
      }
    }
    Resources localResources = this.mResources;
    if (localResources != null) {
      return localResources;
    }
    return super.getResources();
  }
  
  public HashMap<Long, Integer> getResourcesKeyIdMap(Resources paramResources)
  {
    localHashMap = mResourcessKeyIdMap;
    if (localHashMap != null) {
      return (HashMap)localHashMap.clone();
    }
    Log.i("XWalkLib", "getResourcesKeyIdMap start");
    localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        Class[] arrayOfClass = getClassLoader().loadClass("org.xwalk.core.R").getClasses();
        int m = arrayOfClass.length;
        i = 0;
        if (i < m)
        {
          Object localObject1 = arrayOfClass[i];
          if (((Class)localObject1).getSimpleName().equals("drawable"))
          {
            localObject1 = ((Class)localObject1).getFields();
            int n = localObject1.length;
            j = 0;
            if (j < n)
            {
              localObject2 = localObject1[j];
              if (Modifier.isFinal(localObject2.getModifiers())) {
                localObject2.setAccessible(true);
              }
            }
          }
        }
      }
      catch (Exception paramResources)
      {
        int i;
        int j;
        Object localObject2;
        Object localObject3;
        int k;
        long l;
        Log.e("XWalkLib", paramResources.getMessage());
        continue;
        Log.e("XWalkLib", "org.xwalk.core.Ris not found.");
        mResourcessKeyIdMap = localHashMap;
        paramResources = new StringBuilder();
        paramResources.append("getResourcesKeyIdMap end, size:");
        paramResources.append(mResourcessKeyIdMap.keySet().size());
        Log.i("XWalkLib", paramResources.toString());
        return (HashMap)mResourcessKeyIdMap.clone();
      }
      catch (ClassNotFoundException paramResources)
      {
        continue;
      }
      try
      {
        localObject3 = new TypedValue();
        k = localObject2.getInt(null);
      }
      catch (IllegalAccessException localIllegalAccessException1) {}catch (IllegalArgumentException localIllegalArgumentException1) {}catch (Resources.NotFoundException localNotFoundException1)
      {
        continue;
      }
      try
      {
        paramResources.getValue(k, (TypedValue)localObject3, true);
        l = ((TypedValue)localObject3).assetCookie;
        l = ((TypedValue)localObject3).data | l << 32;
        localHashMap.put(Long.valueOf(l), Integer.valueOf(k));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("name:");
        ((StringBuilder)localObject3).append(localObject2.getName());
        ((StringBuilder)localObject3).append(",id:");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append(",key:");
        ((StringBuilder)localObject3).append(l);
        Log.d("XWalkLib", ((StringBuilder)localObject3).toString());
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        continue;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        continue;
      }
      catch (Resources.NotFoundException localNotFoundException2)
      {
        continue;
        continue;
        continue;
      }
      k = 0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localObject2.getName());
      ((StringBuilder)localObject3).append(" is not found.");
      ((StringBuilder)localObject3).append(Integer.toHexString(k));
      Log.w("XWalkLib", ((StringBuilder)localObject3).toString());
      continue;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localObject2.getName());
      ((StringBuilder)localObject3).append(" is not int.");
      Log.w("XWalkLib", ((StringBuilder)localObject3).toString());
      continue;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localObject2.getName());
      ((StringBuilder)localObject3).append(" is not accessable.");
      Log.w("XWalkLib", ((StringBuilder)localObject3).toString());
      if (Modifier.isFinal(localObject2.getModifiers())) {
        localObject2.setAccessible(false);
      }
      j += 1;
      continue;
      i += 1;
    }
  }
  
  public Object getSystemService(String paramString)
  {
    if (paramString.equals("layout_inflater")) {
      return getLayoutInflater();
    }
    try
    {
      paramString = this.mContext.getSystemService(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSystemService failed ");
      localStringBuilder.append(paramString.getMessage());
      Log.e("XWalkLib", localStringBuilder.toString());
    }
    return null;
  }
  
  public Resources.Theme getTheme()
  {
    Resources.Theme localTheme = this.mTheme;
    if (localTheme != null) {
      return localTheme;
    }
    return super.getTheme();
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mContext.getTheme() != null)
    {
      this.mContext.getTheme().applyStyle(paramInt, true);
      return;
    }
    super.setTheme(paramInt);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(getRealIntent(paramIntent));
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return super.startService(getRealIntent(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkContextWrapper
 * JD-Core Version:    0.7.0.1
 */