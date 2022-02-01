package com.tencent.mobileqq.subaccount.api.impl;

import QQService.BindUin;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.config.splashlogo.KandianConfigServlet;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.CardObserverCallback;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.FriendListObserverCallback;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverCallback;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountBindObserverInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountInfoProxy;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountUnReadItemProxy;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class SubAccountApiImpl
  implements ISubAccountApi
{
  public boolean cleanThirdQQUnreadMsgNum(SimpleAccount paramSimpleAccount)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanThirdQQUnreadMsgNum((AppInterface)localAppRuntime, paramSimpleAccount);
    }
    return false;
  }
  
  public void clearGestureData(Context paramContext, String paramString)
  {
    GesturePWDUtils.clearGestureData(paramContext, paramString);
  }
  
  public BusinessObserver createMessageObserver(ISubAccountApi.MessageObserverInterface paramMessageObserverInterface)
  {
    return new SubAccountApiImpl.4(this, paramMessageObserverInterface);
  }
  
  public BusinessObserver createSubAccountBindObserver(ISubAccountApi.SubAccountBindObserverInterface paramSubAccountBindObserverInterface)
  {
    return new SubAccountApiImpl.3(this, paramSubAccountBindObserverInterface);
  }
  
  public void deleteHistory(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ProxyManager localProxyManager = ((QQAppInterface)paramAppInterface).getProxyManager();
      if (localProxyManager != null)
      {
        localProxyManager.transSaveToDatabase();
        ((IFTSDBRuntimeService)paramAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).clearFTS(paramAppInterface, paramString, true);
        new MessageRecordManagerImpl().a(paramString);
        DBUtils.a().a(paramAppInterface.getApp(), paramString, false);
      }
    }
  }
  
  public String getAccountManagerName()
  {
    return AccountManageActivity.class.getSimpleName();
  }
  
  public List<ISubAccountApi.SubAccountInfoProxy> getAllSubAccountInfo()
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    ArrayList localArrayList = new ArrayList();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((ISubAccountService)((AppRuntime)localObject).getRuntimeService(ISubAccountService.class, "")).getAllSubAccountInfo().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new SubAccountApiImpl.2(this, (SubAccountInfo)((Iterator)localObject).next()));
      }
    }
    return localArrayList;
  }
  
  public BusinessObserver getCardObserver(ISubAccountApi.CardObserverCallback paramCardObserverCallback)
  {
    return new SubAccountApiImpl.7(this, paramCardObserverCallback);
  }
  
  public BusinessObserver getFriendListObserver(ISubAccountApi.FriendListObserverCallback paramFriendListObserverCallback)
  {
    return new SubAccountApiImpl.6(this, paramFriendListObserverCallback);
  }
  
  public boolean getKandianTabConfig(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong, boolean paramBoolean)
  {
    return KandianConfigServlet.a(paramAppRuntime, paramClass, paramLong, paramBoolean);
  }
  
  public BusinessObserver getMessageObserver(ISubAccountApi.MessageObserverCallback paramMessageObserverCallback)
  {
    return new SubAccountApiImpl.5(this, paramMessageObserverCallback);
  }
  
  public AbsSubAccountMessageProcessor getProcessor(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).getMsgHandler().a();
    }
    return null;
  }
  
  public void getQCircleTabConfig(AppRuntime paramAppRuntime, Class<?> paramClass)
  {
    QCircleThirdTabConfig.a().a(paramAppRuntime, paramClass);
  }
  
  public String getQRCodeKey()
  {
    return "qrcode";
  }
  
  public String getServerConfigValue(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getServerConfigValue(paramConfigType, paramString);
    }
    return null;
  }
  
  public String getTabIndex()
  {
    return "tab_index";
  }
  
  public ISubAccountApi.SubAccountUnReadItemProxy getUnreadCount(String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramString = ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getUnreadCount((QQAppInterface)localAppRuntime, paramString);
      if (paramString != null) {
        return new SubAccountApiImpl.1(this, paramString);
      }
    }
    return null;
  }
  
  public boolean getUseNewSettings(AppInterface paramAppInterface)
  {
    return SettingsConfigHelper.a(paramAppInterface);
  }
  
  public void loginSuccessInit(AppRuntime paramAppRuntime, String paramString)
  {
    BusinessUtils.a(paramAppRuntime, paramString);
  }
  
  public void notifyBusinessMessage(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).getMsgHandler().a().a(paramInt, paramBoolean, paramObject);
    }
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).getMsgHandler().notifyUI(paramInt, paramBoolean, paramObject);
    }
  }
  
  public void refreshConversation()
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
    }
  }
  
  public void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, ArrayList<BindUin> paramArrayList)
  {
    paramAppInterface = (FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppInterface != null) {
      paramAppInterface.setBindUinStatus(paramByte, paramArrayList);
    }
  }
  
  public void setDisplayThirdQQSwitch(AppInterface paramAppInterface, boolean paramBoolean)
  {
    ((CardHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).n(paramBoolean);
  }
  
  public void startAllSubMessageAccountMsg(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).startAllSubMessageAccountMsg(paramBoolean);
    }
  }
  
  public boolean startAllSubMessageAccountMsg(boolean paramBoolean, int paramInt)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).startAllSubMessageAccountMsg(paramBoolean, paramInt);
    }
    return false;
  }
  
  public int startGetThirdQQUnreadNum(boolean paramBoolean)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountApiImpl
 * JD-Core Version:    0.7.0.1
 */