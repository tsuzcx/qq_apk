package com.tencent.mobileqq.nearby.api;

import EncounterSvc.UserDetailLocalInfo;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.INearbyProcObserver;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

@QAPI(process={"all"})
public abstract interface INearbyAppInterface
  extends QRouteApi
{
  public abstract void addManager(int paramInt, Manager paramManager);
  
  public abstract void addNearbyProcObserver(INearbyProcObserver paramINearbyProcObserver);
  
  public abstract void addObserver(BusinessObserver paramBusinessObserver);
  
  public abstract void clearMyTabCardVisitorInfo();
  
  public abstract void finalize();
  
  public abstract String getAccount();
  
  public abstract BaseApplication getApp();
  
  public abstract int getAppid();
  
  public abstract MobileQQ getApplication();
  
  public abstract BusinessHandler getBusinessHandler(String paramString);
  
  public abstract String getCurrentAccountUin();
  
  public abstract String getCurrentNickname();
  
  public abstract EntityManagerFactory getEntityManagerFactory();
  
  public abstract EntityManagerFactory getEntityManagerFactory(String paramString);
  
  public abstract long getLongAccountUin();
  
  public abstract Manager getManager(int paramInt);
  
  public abstract MobileQQServiceBase getMobileQQService();
  
  public abstract String getModuleId();
  
  public abstract NearbyMyTabCard getMyTabCard();
  
  public abstract NearbyMyTabCard getMyTabCardCache();
  
  public abstract INearbyProcManager getNearbyProcManager();
  
  public abstract <T extends IRuntimeService> T getRuntimeService(Class<T> paramClass, String paramString);
  
  public abstract INearbyTransFileController getTransFileController();
  
  public abstract int getVoteRedDotState();
  
  public abstract int getmLastTabIndex();
  
  public abstract int getmPerfState();
  
  public abstract long getmPreLoadTime();
  
  public abstract int getmPreloadFrom();
  
  public abstract Object getmSelfRespEncounterInfo();
  
  public abstract IService getmService();
  
  public abstract UserDetailLocalInfo getmUdlInfo();
  
  public abstract boolean isCloseRn();
  
  public abstract boolean isSVip();
  
  public abstract boolean isVip();
  
  public abstract boolean ismNeedStoreAnchorage();
  
  public abstract void nearbyReportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void onBeforeExitProc();
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract boolean onReceiveAccountAction(String paramString, Intent paramIntent);
  
  public abstract boolean onReceiveLegalExitProcAction(Intent paramIntent);
  
  public abstract void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void removeNearbyProcObserver(INearbyProcObserver paramINearbyProcObserver);
  
  public abstract void removeObserver(BusinessObserver paramBusinessObserver);
  
  public abstract void reportClickEventAsync(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void saveSelfRespEncounterInfo(Object paramObject);
  
  @TargetApi(14)
  public abstract void setTalkbackSwitch();
  
  public abstract void setmLastTabIndex(int paramInt);
  
  public abstract void setmNeedStoreAnchorage(boolean paramBoolean);
  
  public abstract void setmPerfState(int paramInt);
  
  public abstract void setmPreLoadTime(long paramLong);
  
  public abstract void setmPreloadFrom(int paramInt);
  
  public abstract void setmSelfRespEncounterInfo(Object paramObject);
  
  public abstract void setmService(IService paramIService);
  
  public abstract void setmUdlInfo(UserDetailLocalInfo paramUserDetailLocalInfo);
  
  public abstract void start(boolean paramBoolean);
  
  public abstract void startServlet(NewIntent paramNewIntent);
  
  public abstract void updateMyTabCard(NearbyMyTabCard paramNearbyMyTabCard);
  
  public abstract void updatePerfState(int paramInt1, int paramInt2);
  
  public abstract void writeVoteRedDotState(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyAppInterface
 * JD-Core Version:    0.7.0.1
 */