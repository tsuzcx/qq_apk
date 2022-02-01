package com.tencent.qqmini.sdk.launcher;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.annotation.BindClass;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.log.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IBuild;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.utils.ProcessUtil;
import java.lang.reflect.Field;
import java.util.HashMap;

@MiniKeep
public class AppLoaderFactory
{
  public static final String LOG_FLAG_LIFECYCLE = " [MiniLifecycle] ";
  public static final String TAG = "minisdk-start";
  private static volatile AppLoaderFactory instance;
  private static volatile byte[] lock = new byte[0];
  @BindClass(className="com.tencent.qqmini.sdk.ipc.AppBrandProxy")
  private IAppBrandProxy appBrandProxy;
  private BaselibLoader baselibLoader;
  @BindClass(className="com.tencent.qqmini.sdk.core.Build")
  private IBuild build;
  @BindClass(className="com.tencent.qqmini.sdk.manager.CommonManager")
  private ICommonManager commonManager;
  Context mContext;
  private String mProcessName;
  @BindClass(className="com.tencent.qqmini.sdk.core.MiniAppEnv")
  private IMiniAppEnv miniAppEnv;
  @BindClass(className="com.tencent.qqmini.sdk.cache.MiniCacheFreeManager")
  private IMiniCacheFreeManager miniCacheFreeManager;
  @BindClass(className="com.tencent.qqmini.sdk.log.LogImpl")
  private Log miniLog;
  @BindClass(className="com.tencent.qqmini.sdk.server.MiniServer")
  private IMiniServer miniServer;
  @BindClass(className="com.tencent.qqmini.sdk.core.proxy.FakeProxyManager")
  private IProxyManager proxyManager;
  
  private void bindFields()
  {
    bindLogField();
    Field[] arrayOfField = getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      AppBrandUtil.bindField(this, arrayOfField[i]);
      i += 1;
    }
  }
  
  private void bindLogField()
  {
    if (QMLog.getLog() != null) {
      return;
    }
    AppBrandUtil.bindField(this, "miniLog");
    QMLog.setLog(this.miniLog);
    QMLog.w("minisdk-start", "QMLog prepared through plan B !");
  }
  
  public static AppLoaderFactory g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new AppLoaderFactory();
        }
      }
    }
    return instance;
  }
  
  private void prepareQMLog()
  {
    try
    {
      Class localClass = Class.forName("com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope");
      Object localObject = localClass;
      if (localClass == null) {
        localObject = Class.forName("com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope");
      }
      localObject = ((Class)localObject).getDeclaredField("PROXY_SERVICES");
      ((Field)localObject).setAccessible(true);
      QMLog.setLog(new AppLoaderFactory.1(this, (LogProxy)((Class)((HashMap)((Field)localObject).get(null)).get(LogProxy.class)).newInstance()));
      QMLog.w("minisdk-start", "QMLog prepared!");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start", "bindLogField exception!", localThrowable);
    }
  }
  
  public Class findClass(String paramString)
  {
    return MiniAppDexLoader.g().findClass(paramString);
  }
  
  @Deprecated
  public IAppBrandProxy getAppBrandProxy()
  {
    return this.appBrandProxy;
  }
  
  public BaselibLoader getBaselibLoader()
  {
    return this.baselibLoader;
  }
  
  public ICommonManager getCommonManager()
  {
    return this.commonManager;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getCurrentProcessName()
  {
    return getProcessName();
  }
  
  public IMiniAppEnv getMiniAppEnv()
  {
    return this.miniAppEnv;
  }
  
  public IMiniCacheFreeManager getMiniCacheFreeManager()
  {
    return this.miniCacheFreeManager;
  }
  
  public IMiniServer getMiniServer()
  {
    return this.miniServer;
  }
  
  public IMiniServiceManager getMiniServiceManager()
  {
    if (isMainProcess()) {
      return getMiniServer().getMiniServiceManager();
    }
    return getMiniAppEnv().getMiniServiceManager();
  }
  
  public String getProcessName()
  {
    if (TextUtils.isEmpty(this.mProcessName)) {
      this.mProcessName = ProcessUtil.getProcessName(this.mContext);
    }
    return this.mProcessName;
  }
  
  public IProxyManager getProxyManager()
  {
    return this.proxyManager;
  }
  
  public IBuild getSDKBuild()
  {
    return this.build;
  }
  
  public void init(Context paramContext, Configuration paramConfiguration)
  {
    if (this.mContext != null) {
      return;
    }
    this.mContext = paramContext;
    prepareQMLog();
    Object localObject = MiniAppDexLoader.g();
    boolean bool;
    if (paramConfiguration != null) {
      bool = paramConfiguration.dexLoaderEnable;
    } else {
      bool = true;
    }
    ((MiniAppDexLoader)localObject).init(paramContext, bool, paramConfiguration.dexConfig);
    MiniAppDexLoader.g().loadDex();
    bindFields();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("packageName = ");
    ((StringBuilder)localObject).append(this.mContext.getPackageName());
    ((StringBuilder)localObject).append(", currentProcessName = ");
    ((StringBuilder)localObject).append(getCurrentProcessName());
    QMLog.d("minisdk-start", ((StringBuilder)localObject).toString());
    if (isMainProcess())
    {
      QMLog.i("minisdk-start", "main process. init MiniServer");
      this.miniServer.init(paramContext, paramConfiguration);
    }
    else
    {
      QMLog.i("minisdk-start", "sub process, init MiniAppEnv");
      this.miniAppEnv.init(paramContext, paramConfiguration);
    }
    this.appBrandProxy.init(paramContext);
  }
  
  public boolean isMainProcess()
  {
    return this.mContext.getPackageName().equals(getCurrentProcessName());
  }
  
  public void setBaselibLoader(BaselibLoader paramBaselibLoader)
  {
    if (paramBaselibLoader != null) {
      this.baselibLoader = paramBaselibLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppLoaderFactory
 * JD-Core Version:    0.7.0.1
 */