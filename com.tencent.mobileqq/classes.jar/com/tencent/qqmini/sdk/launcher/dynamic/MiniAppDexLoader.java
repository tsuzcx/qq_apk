package com.tencent.qqmini.sdk.launcher.dynamic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniCrashHandler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

@MiniKeep
public class MiniAppDexLoader
{
  public static final String MAIN_KEY_MINI_APP = "qqminiapp";
  public static final String MINI_APP_GOOGLE_PLAY_LOAD_SO_SWITCH = "mini_app_google_play_load_so_switch";
  public static final String TAG = "minisdk-MiniAppDexLoader";
  private static volatile MiniAppDexLoader instance;
  private static volatile byte[] lock = new byte[0];
  protected Context mContext;
  private MiniDexConfig mDexConfig;
  private String mDexConfigStr;
  private boolean mDexEnable = true;
  private boolean mDexLoaded = false;
  private ClassLoader mNewClassLoader;
  
  public static MiniAppDexLoader g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new MiniAppDexLoader();
        }
      }
    }
    return instance;
  }
  
  private String getDexPath()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("sdk.jar");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      return localObject;
    }
    if (TextUtils.isEmpty(this.mDexConfigStr))
    {
      QMLog.w("minisdk-MiniAppDexLoader", "Dex Config is empty.");
      return null;
    }
    MiniDynamicManager.g().updateDexConfig(this.mDexConfigStr);
    localObject = MiniDynamicManager.g().getValidDexConfig();
    if (localObject != null)
    {
      this.mDexConfig = ((MiniDexConfig)localObject);
      return ((MiniDexConfig)localObject).getDexPath();
    }
    return null;
  }
  
  public Object create(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (this.mNewClassLoader == null)
      {
        localObject1 = localObject2;
        loadDex();
      }
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(" MiniAppDexLoader : ");
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(paramString);
      localObject1 = localObject2;
      QMLog.i("minisdk-MiniAppDexLoader", ((StringBuilder)localObject3).toString());
      localObject1 = localObject2;
      if (this.mNewClassLoader != null)
      {
        localObject1 = localObject2;
        localObject2 = Reflect.on(paramString, this.mNewClassLoader).create().get();
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(" MiniAppDexLoader : ");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(paramString);
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(" obj:");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(localObject2);
        localObject1 = localObject2;
        QMLog.i("minisdk-MiniAppDexLoader", ((StringBuilder)localObject3).toString());
        return localObject2;
      }
      localObject1 = localObject2;
      localObject2 = Reflect.on(paramString, getClass().getClassLoader()).create().get();
      return localObject2;
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" MiniAppDexLoader create: ");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(" failed.");
      ((StringBuilder)localObject3).append(localException.getMessage());
      QMLog.w("minisdk-MiniAppDexLoader", ((StringBuilder)localObject3).toString());
    }
    try
    {
      localObject3 = Reflect.on(paramString, getClass().getClassLoader()).create().get();
      return localObject3;
    }
    catch (Throwable localThrowable)
    {
      label245:
      break label245;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(" MiniAppDexLoader create: ");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(" failed.");
    QMLog.w("minisdk-MiniAppDexLoader", ((StringBuilder)localObject3).toString(), localException);
    return localObject1;
  }
  
  public Class findClass(String paramString)
  {
    Class localClass2 = null;
    Class localClass1 = localClass2;
    try
    {
      if (this.mNewClassLoader == null)
      {
        localClass1 = localClass2;
        loadDex();
      }
      localClass1 = localClass2;
      localObject = new StringBuilder();
      localClass1 = localClass2;
      ((StringBuilder)localObject).append(" MiniAppDexLoader findClass: ");
      localClass1 = localClass2;
      ((StringBuilder)localObject).append(paramString);
      localClass1 = localClass2;
      QMLog.i("minisdk-MiniAppDexLoader", ((StringBuilder)localObject).toString());
      localClass1 = localClass2;
      if (this.mNewClassLoader != null)
      {
        localClass1 = localClass2;
        localClass2 = this.mNewClassLoader.loadClass(paramString);
        localClass1 = localClass2;
        localObject = new StringBuilder();
        localClass1 = localClass2;
        ((StringBuilder)localObject).append(" MiniAppDexLoader findClass: ");
        localClass1 = localClass2;
        ((StringBuilder)localObject).append(paramString);
        localClass1 = localClass2;
        ((StringBuilder)localObject).append(" Class:");
        localClass1 = localClass2;
        ((StringBuilder)localObject).append(localClass2);
        localClass1 = localClass2;
        QMLog.i("minisdk-MiniAppDexLoader", ((StringBuilder)localObject).toString());
        return localClass2;
      }
      localClass1 = localClass2;
      localClass2 = getClass().getClassLoader().loadClass(paramString);
      return localClass2;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" MiniAppDexLoader findClass: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" failed.");
      ((StringBuilder)localObject).append(localException.getMessage());
      QMLog.w("minisdk-MiniAppDexLoader", ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = getClass().getClassLoader().loadClass(paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label227:
      break label227;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" MiniAppDexLoader findClass: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" failed.");
    QMLog.w("minisdk-MiniAppDexLoader", ((StringBuilder)localObject).toString(), localException);
    return localClass1;
  }
  
  public MiniDexConfig getDexConfig()
  {
    return this.mDexConfig;
  }
  
  public boolean hasNewDex()
  {
    String str = getDexPath();
    if (TextUtils.isEmpty(str))
    {
      QMLog.i("minisdk-MiniAppDexLoader", "There's not a dex to be loaded.");
      return false;
    }
    if (new File(str).exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load dexPath : ");
      localStringBuilder.append(str);
      QMLog.i("minisdk-MiniAppDexLoader", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void init(Context paramContext, boolean paramBoolean, String paramString)
  {
    this.mContext = paramContext;
    this.mDexEnable = paramBoolean;
    this.mDexConfigStr = paramString;
    paramContext = new StringBuilder();
    paramContext.append("enableDex: ");
    paramContext.append(paramBoolean);
    paramContext.append(" dexConfig:");
    paramContext.append(this.mDexConfigStr);
    QMLog.w("minisdk-MiniAppDexLoader", paramContext.toString());
  }
  
  public void loadDex()
  {
    try
    {
      if ((this.mDexEnable) && (!this.mDexLoaded) && (this.mContext != null))
      {
        if ((hasNewDex()) && (this.mNewClassLoader == null)) {
          this.mNewClassLoader = new MiniAppClassloader(getDexPath(), this.mContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader());
        }
        if (!AppLoaderFactory.g().isMainProcess()) {
          Thread.setDefaultUncaughtExceptionHandler(new MiniCrashHandler());
        }
        this.mDexLoaded = true;
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader
 * JD-Core Version:    0.7.0.1
 */