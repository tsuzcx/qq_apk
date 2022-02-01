package com.tencent.mobileqq.subaccount.api;

import QQService.BindUin;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;

@QAPI(process={"all"})
public abstract interface ISubAccountApi
  extends QRouteApi
{
  public abstract boolean cleanThirdQQUnreadMsgNum(SimpleAccount paramSimpleAccount);
  
  public abstract void clearGestureData(Context paramContext, String paramString);
  
  public abstract BusinessObserver createMessageObserver(ISubAccountApi.MessageObserverInterface paramMessageObserverInterface);
  
  public abstract BusinessObserver createSubAccountBindObserver(ISubAccountApi.SubAccountBindObserverInterface paramSubAccountBindObserverInterface);
  
  public abstract void deleteHistory(AppInterface paramAppInterface, String paramString);
  
  public abstract String getAccountManagerName();
  
  public abstract List<ISubAccountApi.SubAccountInfoProxy> getAllSubAccountInfo();
  
  public abstract BusinessObserver getCardObserver(ISubAccountApi.CardObserverCallback paramCardObserverCallback);
  
  public abstract BusinessObserver getFriendListObserver(ISubAccountApi.FriendListObserverCallback paramFriendListObserverCallback);
  
  public abstract boolean getKandianTabConfig(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong, boolean paramBoolean);
  
  public abstract BusinessObserver getMessageObserver(ISubAccountApi.MessageObserverCallback paramMessageObserverCallback);
  
  public abstract AbsSubAccountMessageProcessor getProcessor(AppInterface paramAppInterface);
  
  public abstract void getQCircleTabConfig(AppRuntime paramAppRuntime, Class<?> paramClass);
  
  public abstract String getQRCodeKey();
  
  public abstract String getServerConfigValue(ServerConfigManager.ConfigType paramConfigType, String paramString);
  
  public abstract String getTabIndex();
  
  public abstract ISubAccountApi.SubAccountUnReadItemProxy getUnreadCount(String paramString);
  
  public abstract void loginSuccessInit(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void notifyBusinessMessage(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void refreshConversation();
  
  public abstract void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, ArrayList<BindUin> paramArrayList);
  
  public abstract void setDisplayThirdQQSwitch(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void startAllSubMessageAccountMsg(boolean paramBoolean);
  
  public abstract boolean startAllSubMessageAccountMsg(boolean paramBoolean, int paramInt);
  
  public abstract int startGetThirdQQUnreadNum(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountApi
 * JD-Core Version:    0.7.0.1
 */