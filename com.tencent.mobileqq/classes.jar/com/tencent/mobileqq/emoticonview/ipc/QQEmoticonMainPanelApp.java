package com.tencent.mobileqq.emoticonview.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.DownloaderFactoryProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.QQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.widget.XPanelContainer;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class QQEmoticonMainPanelApp
  implements IEmoticonMainPanelApp
{
  private static final String TAG = "QQEmoticonMainPanelApp";
  private static boolean sInit = false;
  private QQAppInterface mApp;
  protected EntityManager mEntityManager;
  protected QQEntityManagerFactoryProxy mEntityManagerFactoryProxy;
  private QQMessageFacadeProxy mMessageFacadeProxy;
  private ConcurrentHashMap<String, AbsHandlerProxy<? extends BusinessHandler>> mProxyHandlerMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, AbsManagerProxy<? extends Manager>> mProxyManagerMap = new ConcurrentHashMap();
  private AppRuntime mRuntime;
  
  public QQEmoticonMainPanelApp()
  {
    this.mRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((this.mRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)this.mRuntime);
    }
    init();
  }
  
  public QQEmoticonMainPanelApp(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.mApp = paramQQAppInterface;
      this.mRuntime = paramQQAppInterface;
    }
    for (;;)
    {
      init();
      return;
      this.mRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((this.mRuntime instanceof QQAppInterface)) {
        this.mApp = ((QQAppInterface)this.mRuntime);
      }
    }
  }
  
  public QQEmoticonMainPanelApp(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    }
    this.mRuntime = localAppRuntime;
    if ((this.mRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)this.mRuntime);
    }
    init();
  }
  
  @Nullable
  private AbsHandlerProxy<? extends BusinessHandler> createHandlerProxy(String paramString)
  {
    if (BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER.equals(paramString)) {
      return new CameraEmoRoamingHandlerProxy(this.mApp);
    }
    if (BusinessHandlerFactory.HANDLER_EMOSM.equals(paramString)) {
      return new EmoticonHandlerProxy(this.mApp);
    }
    if (BusinessHandlerFactory.MQQ_COMIC_HANDLER.equals(paramString)) {
      return new VipComicMqqHandlerProxy(this.mApp);
    }
    if (BusinessHandlerFactory.SVIP_HANDLER.equals(paramString)) {
      return new SVIPHandlerProxy(this.mApp);
    }
    if (BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER.equals(paramString)) {
      return new FavEmoRoamingHandlerProxy(this.mApp);
    }
    return null;
  }
  
  @Nullable
  private AbsManagerProxy<? extends Manager> createMangerProxy(int paramInt)
  {
    if (QQManagerFactory.EMOTION_SEARCH_MANAGER == paramInt) {
      return new EmotionSearchManagerProxy(this.mApp);
    }
    if (QQManagerFactory.FAV_ROAMING_MANAGER == paramInt) {
      return new FavroamingManagerProxy(this.mApp);
    }
    if (QQManagerFactory.COMMERCIAL_DRAINAGE_MANAGER == paramInt) {
      return new CommercialDrainageManagerProxy(this.mApp);
    }
    if (QQManagerFactory.EMOTICON_MANAGER == paramInt) {
      return new EmoticonManagerProxy(this.mApp, this.mEntityManager);
    }
    if (QQManagerFactory.CAMERA_EMOTION_DB_MANAGER == paramInt) {
      return new CameraEmotionRoamingDBManagerProxy(this.mApp);
    }
    if (QQManagerFactory.CAMERA_EMOTION_MANAGER == paramInt) {
      return new CameraEmoRoamingManagerProxy(this.mApp);
    }
    if (QQManagerFactory.CHAT_EMOTION_MANAGER == paramInt) {
      return new EmojiManagerProxy(this.mApp);
    }
    if (QQManagerFactory.FAVROAMING_DB_MANAGER == paramInt) {
      return new FavroamingDBManagerProxy(this.mApp);
    }
    if (QQManagerFactory.MQQ_COMIC_MANAGER == paramInt) {
      return new VipComicMqqManagerProxy(this.mApp);
    }
    if (QQManagerFactory.MGR_RED_TOUCH == paramInt) {
      return new RedTouchManagerProxy(this.mApp);
    }
    if (QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT == paramInt) {
      return new CommonUsedSystemEmojiManagerProxy(this.mApp);
    }
    if (QQManagerFactory.VAS_QUICKUPDATE_MANAGER == paramInt) {
      return new VasQuickUpdateManagerProxy(this.mApp);
    }
    if (QQManagerFactory.DOWNLOADER_FACTORY == paramInt) {
      return new DownloaderFactoryProxy(this.mApp);
    }
    if (QQManagerFactory.GAMECENTER_MANAGER == paramInt) {
      return new GameCenterManagerImpProxy(this.mApp);
    }
    if (QQManagerFactory.CHAT_FONT_MANAGER == paramInt) {
      return new FontManagerProxy(this.mApp);
    }
    return null;
  }
  
  private void init()
  {
    if (this.mApp == null)
    {
      this.mEntityManagerFactoryProxy = QQEntityManagerFactoryProxy.a(getAccount());
      this.mEntityManager = this.mEntityManagerFactoryProxy.createEntityManager();
    }
  }
  
  public static boolean isMainProcess()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.mApp != null) {
      this.mApp.addObserver(paramBusinessObserver);
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
    if (this.mApp != null) {
      return this.mApp;
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
        this.mProxyHandlerMap.put(paramString, localAbsHandlerProxy);
        return localAbsHandlerProxy;
      }
      finally {}
    }
    return localAbsHandlerProxy;
  }
  
  public String getCurrentAccountUin()
  {
    if (this.mApp != null) {
      return this.mApp.getCurrentAccountUin();
    }
    return this.mRuntime.getAccount();
  }
  
  public String getCurrentUin()
  {
    if (this.mApp != null) {
      return this.mApp.getCurrentUin();
    }
    return getQQCurrentUin();
  }
  
  public QQEntityManagerFactoryProxy getEntityManagerFactory()
  {
    if (this.mApp != null) {
      return this.mApp.getEntityManagerFactory();
    }
    return this.mEntityManagerFactoryProxy;
  }
  
  public int getExternalPanelheight()
  {
    if (this.mApp != null) {
      return XPanelContainer.a;
    }
    if (XPanelContainer.a != 0) {
      return XPanelContainer.a;
    }
    XPanelContainer.a = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "externalpanel_height", null).data.getInt("height");
    return XPanelContainer.a;
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
        this.mProxyManagerMap.put(Integer.valueOf(paramInt), localAbsManagerProxy);
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
  
  public QQAppInterface getQQAppInterface()
  {
    return this.mApp;
  }
  
  public String getQQCurrentUin()
  {
    String str = "";
    if (!"0".equals(getCurrentAccountUin())) {
      str = getCurrentAccountUin();
    }
    return str;
  }
  
  public IRuntimeService getService(Class paramClass)
  {
    if (this.mApp == null) {
      return null;
    }
    return this.mApp.getRuntimeService(paramClass, "");
  }
  
  public void registerOtherProcessCallback()
  {
    if (isMainProcess()) {}
    while (sInit) {
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
    if (this.mApp != null) {
      this.mApp.removeObserver(paramBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp
 * JD-Core Version:    0.7.0.1
 */