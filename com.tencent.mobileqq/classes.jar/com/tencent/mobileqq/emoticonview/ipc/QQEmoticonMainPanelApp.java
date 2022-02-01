package com.tencent.mobileqq.emoticonview.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsEmoRuntimeServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.QQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class QQEmoticonMainPanelApp
  implements IEmoticonMainPanelApp
{
  private static final int GAMECENTER_MANAGER = ((IEmosmService)QRoute.api(IEmosmService.class)).getManagerID("GAMECENTER_MANAGER");
  private static final String TAG = "QQEmoticonMainPanelApp";
  private static boolean sInit = false;
  private BaseQQAppInterface mApp;
  protected EntityManager mEntityManager;
  protected EntityManagerFactory mEntityManagerFactory;
  protected int mExternalPanelheight;
  private QQMessageFacadeProxy mMessageFacadeProxy;
  private ConcurrentHashMap<String, AbsHandlerProxy<? extends BusinessHandler>> mProxyHandlerMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, AbsManagerProxy<? extends Manager>> mProxyManagerMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Class, AbsEmoRuntimeServiceProxy<? extends IRuntimeService>> mProxyRuntimeMap = new ConcurrentHashMap();
  private AppRuntime mRuntime;
  
  public QQEmoticonMainPanelApp()
  {
    this.mRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime localAppRuntime = this.mRuntime;
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      this.mApp = ((BaseQQAppInterface)localAppRuntime);
    }
    init();
  }
  
  public QQEmoticonMainPanelApp(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      this.mApp = paramBaseQQAppInterface;
      this.mRuntime = paramBaseQQAppInterface;
    }
    else
    {
      this.mRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramBaseQQAppInterface = this.mRuntime;
      if ((paramBaseQQAppInterface instanceof BaseQQAppInterface)) {
        this.mApp = ((BaseQQAppInterface)paramBaseQQAppInterface);
      }
    }
    init();
  }
  
  public QQEmoticonMainPanelApp(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    this.mRuntime = localAppRuntime;
    paramAppRuntime = this.mRuntime;
    if ((paramAppRuntime instanceof BaseQQAppInterface)) {
      this.mApp = ((BaseQQAppInterface)paramAppRuntime);
    }
    init();
  }
  
  private AbsHandlerProxy createHandlerProxy(String paramString)
  {
    if (CameraEmoRoamingHandler.a.equals(paramString)) {
      return new CameraEmoRoamingHandlerProxy(this.mApp);
    }
    if (EmoticonHandler.a.equals(paramString)) {
      return new EmoticonHandlerProxy(this.mApp);
    }
    if (VipComicMqqHandler.a.equals(paramString)) {
      return new VipComicMqqHandlerProxy(this.mApp);
    }
    if ((paramString != null) && (paramString.equals(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName()))) {
      return new SVIPHandlerProxy(this.mApp);
    }
    if (FavEmoRoamingHandler.a.equals(paramString)) {
      return new FavEmoRoamingHandlerProxy(this.mApp);
    }
    return null;
  }
  
  private AbsManagerProxy createMangerProxy(int paramInt)
  {
    if (GAMECENTER_MANAGER == paramInt) {
      return new GameCenterManagerImpProxy(this.mApp);
    }
    return null;
  }
  
  private AbsEmoRuntimeServiceProxy<? extends IRuntimeService> createRuntimeServiceProxy(Class paramClass)
  {
    if (paramClass == IEmotionSearchManagerService.class) {
      return new EmotionSearchManagerServiceProxy(this.mApp);
    }
    if (paramClass == IFavroamingManagerService.class) {
      return new FavroamingManagerServiceProxy(this.mApp);
    }
    if (paramClass == ICommercialDrainageManagerService.class) {
      return new CommercialDrainageManagerServiceProxy(this.mApp);
    }
    if (paramClass == IEmoticonManagerService.class) {
      return new EmoticonManagerServiceProxy(this.mApp, this.mEntityManager);
    }
    if (paramClass == ICameraEmotionRoamingDBManagerService.class) {
      return new CameraEmotionRoamingDBManagerServiceProxy(this.mApp);
    }
    if (paramClass == ICameraEmoRoamingManagerService.class) {
      return new CameraEmoRoamingManagerServiceProxy(this.mApp);
    }
    if (paramClass == IEmojiManagerService.class) {
      return new EmojiManagerServiceProxy(this.mApp);
    }
    if (paramClass == IFavroamingDBManagerService.class) {
      return new FavroamingDBManagerServiceProxy(this.mApp);
    }
    if (paramClass == IVipComicMqqManagerService.class) {
      return new VipComicMqqManagerServiceProxy(this.mApp);
    }
    if (paramClass == ICommonUsedSystemEmojiManagerService.class) {
      return new CommonUsedSystemEmojiManagerServiceProxy(this.mApp);
    }
    if (paramClass == IRedTouchManager.class) {
      return new RedTouchManagerProxy(this.mApp);
    }
    if (paramClass == IFontManagerService.class) {
      return new FontManagerProxy(this.mApp);
    }
    if (paramClass == IVasQuickUpdateService.class) {
      return new VasQuickUpdateManagerProxy(this.mApp);
    }
    return null;
  }
  
  private void init()
  {
    if (this.mApp == null)
    {
      this.mEntityManagerFactory = this.mRuntime.getEntityManagerFactory(getAccount());
      this.mEntityManager = this.mEntityManagerFactory.createEntityManager();
    }
  }
  
  public static boolean isMainProcess()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    if (localBaseQQAppInterface != null) {
      localBaseQQAppInterface.addObserver(paramBusinessObserver);
    }
  }
  
  public String getAccount()
  {
    return this.mRuntime.getAccount();
  }
  
  public Context getApp()
  {
    return this.mRuntime.getApplication();
  }
  
  public AppRuntime getAppRuntime()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    if (localBaseQQAppInterface != null) {
      return localBaseQQAppInterface;
    }
    return this.mRuntime;
  }
  
  public Context getApplication()
  {
    return this.mRuntime.getApplication();
  }
  
  public AbsHandlerProxy<? extends BusinessHandler> getBusinessHandler(String paramString)
  {
    AbsHandlerProxy localAbsHandlerProxy = (AbsHandlerProxy)this.mProxyHandlerMap.get(paramString);
    if (localAbsHandlerProxy == null) {
      try
      {
        localAbsHandlerProxy = (AbsHandlerProxy)this.mProxyHandlerMap.get(paramString);
        if (localAbsHandlerProxy != null) {
          return localAbsHandlerProxy;
        }
        localAbsHandlerProxy = createHandlerProxy(paramString);
        if (localAbsHandlerProxy != null) {
          this.mProxyHandlerMap.put(paramString, localAbsHandlerProxy);
        }
        return localAbsHandlerProxy;
      }
      finally {}
    }
    return localAbsHandlerProxy;
  }
  
  public String getCurrentAccountUin()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    if (localBaseQQAppInterface != null) {
      return localBaseQQAppInterface.getCurrentAccountUin();
    }
    return this.mRuntime.getAccount();
  }
  
  public String getCurrentUin()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    if (localBaseQQAppInterface != null) {
      return localBaseQQAppInterface.getCurrentUin();
    }
    return getQQCurrentUin();
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    if (localBaseQQAppInterface != null) {
      return localBaseQQAppInterface.getEntityManagerFactory();
    }
    return this.mEntityManagerFactory;
  }
  
  public int getExternalPanelheight()
  {
    if (this.mApp != null) {
      return ((IEmosmService)QRoute.api(IEmosmService.class)).getExternalPanelheight();
    }
    int i = this.mExternalPanelheight;
    if (i != 0) {
      return i;
    }
    this.mExternalPanelheight = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "externalpanel_height", null).data.getInt("height");
    return this.mExternalPanelheight;
  }
  
  public MqqHandlerProxy getHandler(Class paramClass)
  {
    return new MqqHandlerProxy(this.mApp, paramClass);
  }
  
  public AbsManagerProxy<? extends Manager> getManager(int paramInt)
  {
    AbsManagerProxy localAbsManagerProxy = (AbsManagerProxy)this.mProxyManagerMap.get(Integer.valueOf(paramInt));
    if (localAbsManagerProxy == null) {
      try
      {
        localAbsManagerProxy = (AbsManagerProxy)this.mProxyManagerMap.get(Integer.valueOf(paramInt));
        if (localAbsManagerProxy != null) {
          return localAbsManagerProxy;
        }
        localAbsManagerProxy = createMangerProxy(paramInt);
        if (localAbsManagerProxy != null) {
          this.mProxyManagerMap.put(Integer.valueOf(paramInt), localAbsManagerProxy);
        }
        return localAbsManagerProxy;
      }
      finally {}
    }
    return localAbsManagerProxy1;
  }
  
  public QQMessageFacadeProxy getMessageFacade()
  {
    if (this.mMessageFacadeProxy == null) {
      this.mMessageFacadeProxy = new QQMessageFacadeProxy(this.mApp);
    }
    return this.mMessageFacadeProxy;
  }
  
  public BaseQQAppInterface getQQAppInterface()
  {
    return this.mApp;
  }
  
  public String getQQCurrentUin()
  {
    if (!"0".equals(getCurrentAccountUin())) {
      return getCurrentAccountUin();
    }
    return "";
  }
  
  public AbsEmoRuntimeServiceProxy<? extends IRuntimeService> getRuntimeService(Class paramClass)
  {
    AbsEmoRuntimeServiceProxy localAbsEmoRuntimeServiceProxy = (AbsEmoRuntimeServiceProxy)this.mProxyRuntimeMap.get(paramClass);
    if (localAbsEmoRuntimeServiceProxy == null) {
      try
      {
        localAbsEmoRuntimeServiceProxy = (AbsEmoRuntimeServiceProxy)this.mProxyRuntimeMap.get(paramClass);
        if (localAbsEmoRuntimeServiceProxy != null) {
          return localAbsEmoRuntimeServiceProxy;
        }
        localAbsEmoRuntimeServiceProxy = createRuntimeServiceProxy(paramClass);
        if (localAbsEmoRuntimeServiceProxy != null) {
          this.mProxyRuntimeMap.put(paramClass, localAbsEmoRuntimeServiceProxy);
        }
        return localAbsEmoRuntimeServiceProxy;
      }
      finally {}
    }
    return localAbsEmoRuntimeServiceProxy;
  }
  
  public <T extends IRuntimeService> T getService(Class<T> paramClass)
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    if (localBaseQQAppInterface == null) {
      return null;
    }
    return localBaseQQAppInterface.getRuntimeService(paramClass, "");
  }
  
  public void registerOtherProcessCallback()
  {
    if (isMainProcess()) {
      return;
    }
    if (sInit) {
      return;
    }
    sInit = true;
    ThreadManager.getSubThreadHandler().post(new QQEmoticonMainPanelApp.1(this));
    QIPCClientHelper.getInstance().register(EmoticonMainPanelChildIpcModule.getInstance());
    Bundle localBundle = new Bundle();
    localBundle.putString("process_name", MobileQQ.processName);
    QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "other_rigister_callback", localBundle, new QQEmoticonMainPanelApp.2(this));
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    if (localBaseQQAppInterface != null) {
      localBaseQQAppInterface.removeObserver(paramBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp
 * JD-Core Version:    0.7.0.1
 */