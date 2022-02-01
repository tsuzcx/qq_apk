package com.tencent.qqmini.sdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.manager.ApkgLoader;
import com.tencent.qqmini.sdk.core.manager.impl.InternalBaselibLoader;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.Configuration.ProcessInfo;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.annotation.BindClass;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniServiceFetcher;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppInterface;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.launcher.shell.IShareManager;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@MiniKeep
public class MiniAppEnv
  implements IMiniAppEnv
{
  private static final String GAME_UI_PROXY_CLASS_NAME = "com.tencent.qqmini.minigame.ui.GameUIProxy";
  private static final String TAG = "MiniAppEnv";
  @BindClass(className="com.tencent.qqmini.sdk.core.manager.ActivityResultManagerFaker")
  private IActivityResultManager activityResultManager;
  @BindClass(className="com.tencent.qqmini.sdk.runtime.AppUIProxy")
  private IUIProxy appInternalUIProxy;
  @BindClass(className="com.tencent.qqmini.sdk.runtime.AppUIProxy")
  private IUIProxy appUIProxy;
  protected ApkgLoader mApkgLoader = ApkgLoader.g();
  private Map<String, AuthState> mAuthStateMap = new HashMap();
  protected Context mContext;
  private LoginInfo mLoginInfo = new LoginInfo();
  private String mMenuStyle = "light";
  private IMiniServiceManager mMiniServiceManager;
  private List<MiniProcessorConfig> mProcessList;
  private Map<String, WeakReference<IUIProxy>> mUIProxyMap = new HashMap();
  @BindClass(className="com.tencent.qqmini.sdk.manager.MiniAppInterface")
  private IMiniAppInterface miniAppInterface;
  @BindClass(className="com.tencent.qqmini.sdk.receiver.MainReceiverProxy")
  private IReceiverProxy receiverProxy;
  protected BaselibLoader sBaselibLoader = new InternalBaselibLoader();
  @BindClass(className="com.tencent.qqmini.sdk.core.manager.ShareManager")
  private IShareManager shareManager;
  
  private void bindFields()
  {
    Field[] arrayOfField = getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      AppBrandUtil.bindField(this, arrayOfField[i]);
      i += 1;
    }
  }
  
  public static MiniAppEnv g()
  {
    return (MiniAppEnv)AppLoaderFactory.g().getMiniAppEnv();
  }
  
  private void initLoginInfo(Intent paramIntent)
  {
    try
    {
      paramIntent = (LoginInfo)paramIntent.getParcelableExtra("KEY_LOGININFO");
      if (paramIntent != null)
      {
        this.mLoginInfo = paramIntent;
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QMLog.i("minisdk-start", "parse loginInfo error", paramIntent);
    }
  }
  
  private void initMiniServiceManager(Intent paramIntent)
  {
    try
    {
      paramIntent = (MiniServiceFetcher)paramIntent.getParcelableExtra("KEY_MINI_SERVICE_MANAGER");
      if (paramIntent != null)
      {
        this.mMiniServiceManager = paramIntent.getMiniServiceManager();
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QMLog.i("minisdk-start", "parse loginInfo error", paramIntent);
    }
  }
  
  private void processConfiguration(Configuration paramConfiguration)
  {
    if (this.mContext == null)
    {
      QMLog.e("MiniAppEnv", "processConfiguration with Context is null!");
      return;
    }
    if (paramConfiguration == null)
    {
      QMLog.e("MiniAppEnv", "processConfiguration with Configuration is null!");
      return;
    }
    this.mProcessList = new ArrayList();
    paramConfiguration = paramConfiguration.processInfoList.iterator();
    while (paramConfiguration.hasNext())
    {
      Object localObject = (Configuration.ProcessInfo)paramConfiguration.next();
      localObject = new MiniProcessorConfig(((Configuration.ProcessInfo)localObject).processType, ((Configuration.ProcessInfo)localObject).name, ((Configuration.ProcessInfo)localObject).uiClass, ((Configuration.ProcessInfo)localObject).internalUIClass, ((Configuration.ProcessInfo)localObject).receiverClass, ((Configuration.ProcessInfo)localObject).supportRuntimeType);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createConfiguration. Add processor config: ");
      localStringBuilder.append(localObject);
      QMLog.i("MiniAppEnv", localStringBuilder.toString());
      this.mProcessList.add(localObject);
    }
  }
  
  public IActivityResultManager getActivityResultManager()
  {
    return this.activityResultManager;
  }
  
  public ApkgLoader getApkgLoader()
  {
    return this.mApkgLoader;
  }
  
  public AuthState getAuthSate(String paramString)
  {
    if (this.mAuthStateMap.containsKey(paramString)) {
      return (AuthState)this.mAuthStateMap.get(paramString);
    }
    synchronized (this.mAuthStateMap)
    {
      AuthState localAuthState = (AuthState)this.mAuthStateMap.get(paramString);
      Object localObject = localAuthState;
      if (localAuthState == null)
      {
        localObject = LoginManager.getInstance().getAccount();
        localObject = new AuthState(getContext(), paramString, (String)localObject);
        this.mAuthStateMap.put(paramString, localObject);
      }
      return localObject;
    }
  }
  
  public BaselibLoader getBaselibLoader()
  {
    if (AppLoaderFactory.g().getBaselibLoader() != null) {
      return AppLoaderFactory.g().getBaselibLoader();
    }
    return this.sBaselibLoader;
  }
  
  public Context getContext()
  {
    Context localContext = this.mContext;
    if (localContext != null) {
      return localContext;
    }
    throw new RuntimeException("Should call init() first!");
  }
  
  public MiniProcessorConfig getCurrentProcessConfig()
  {
    if (this.mProcessList == null) {
      return null;
    }
    String str = AppLoaderFactory.g().getProcessName();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Iterator localIterator = this.mProcessList.iterator();
    while (localIterator.hasNext())
    {
      MiniProcessorConfig localMiniProcessorConfig = (MiniProcessorConfig)localIterator.next();
      if ((localMiniProcessorConfig != null) && (str.equals(localMiniProcessorConfig.processName))) {
        return localMiniProcessorConfig;
      }
    }
    return null;
  }
  
  public LoginInfo getLoginInfo()
  {
    return this.mLoginInfo;
  }
  
  public String getMenuStyle()
  {
    return this.mMenuStyle;
  }
  
  public IMiniServiceManager getMiniServiceManager()
  {
    return this.mMiniServiceManager;
  }
  
  public IReceiverProxy getReceiverProxy()
  {
    return this.receiverProxy;
  }
  
  public IShareManager getShareManager()
  {
    return this.shareManager;
  }
  
  public IUIProxy getUIProxy(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("MiniAppEnv", "Failed to getAppUIProxy, miniAppInfo is null, return default appUIProxy");
      return this.appUIProxy;
    }
    if (paramMiniAppInfo.isEngineTypeMiniGame())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramMiniAppInfo.verType);
      String str = ((StringBuilder)localObject).toString();
      paramMiniAppInfo = (WeakReference)this.mUIProxyMap.get(str);
      if (paramMiniAppInfo != null)
      {
        localObject = (IUIProxy)paramMiniAppInfo.get();
        if (localObject != null)
        {
          paramMiniAppInfo = (MiniAppInfo)localObject;
          if (!((IUIProxy)localObject).isDestroyed()) {
            break label135;
          }
        }
      }
      paramMiniAppInfo = (IUIProxy)MiniAppDexLoader.g().create("com.tencent.qqmini.minigame.ui.GameUIProxy");
      this.mUIProxyMap.put(str, new WeakReference(paramMiniAppInfo));
      label135:
      return paramMiniAppInfo;
    }
    if (paramMiniAppInfo.isInternalApp()) {
      return this.appInternalUIProxy;
    }
    return this.appUIProxy;
  }
  
  public void init(Context paramContext, Configuration paramConfiguration)
  {
    this.mContext = paramContext;
    processConfiguration(paramConfiguration);
    bindFields();
    this.miniAppInterface.onCreate(paramContext, paramConfiguration);
    paramContext = new StringBuilder();
    paramContext.append("Init MiniAppEnv. MiniSdkVersion:1.19.0_232_c8d4d7a QUA:");
    paramContext.append(QUAUtil.getQUA());
    paramContext.append(" PlatformQUA:");
    paramContext.append(QUAUtil.getPlatformQUA());
    QMLog.i("MiniAppEnv", paramContext.toString());
  }
  
  public void setApkgLoader(ApkgLoader paramApkgLoader)
  {
    this.mApkgLoader = paramApkgLoader;
  }
  
  @Deprecated
  public void setBaselibLoader(BaselibLoader paramBaselibLoader)
  {
    this.sBaselibLoader = paramBaselibLoader;
  }
  
  public void setMenuStyle(String paramString)
  {
    this.mMenuStyle = paramString;
  }
  
  public void setupWithIntent(Intent paramIntent)
  {
    initMiniServiceManager(paramIntent);
    initLoginInfo(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.MiniAppEnv
 * JD-Core Version:    0.7.0.1
 */