package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.local.QCirclePluginEnter;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.biz.qqcircle.fragments.chat.QCircleChatGiftManager;
import com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetMainPageRequest;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QCircleServiceImpl
  implements IQCircleService
{
  private static final String TAG = "QCircleServiceImpl";
  private static QCircleServiceImpl mInstance;
  private List<MessageRecord> mMessageRecord = new LinkedList();
  
  public static IAccountRuntime getAccountApi()
  {
    return (IAccountRuntime)QRoute.api(IAccountRuntime.class);
  }
  
  public static AppInterface getAppInterface()
  {
    if ((getAppRunTime() instanceof AppInterface)) {
      return (AppInterface)getAppRunTime();
    }
    return null;
  }
  
  public static AppRuntime getAppRunTime()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static IQQAvatarDataService getAvatarDataService()
  {
    return (IQQAvatarDataService)getAppRunTime().getRuntimeService(IQQAvatarDataService.class, "");
  }
  
  public static IChatActivityApi getChatActivityApi()
  {
    return (IChatActivityApi)QRoute.api(IChatActivityApi.class);
  }
  
  public static IConversationFacade getConversationFacade()
  {
    if (getAppRunTime() != null) {
      return (IConversationFacade)getAppRunTime().getRuntimeService(IConversationFacade.class, "");
    }
    return (IConversationFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IConversationFacade.class, "");
  }
  
  public static EntityManager getEntityManager()
  {
    if (getAppRunTime() != null) {
      return getAppRunTime().getEntityManagerFactory(getAppRunTime().getAccount()).createEntityManager();
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    return localAppRuntime.getEntityManagerFactory(localAppRuntime.getAccount()).createEntityManager();
  }
  
  public static IForwardApi getForwardApi()
  {
    return (IForwardApi)QRoute.api(IForwardApi.class);
  }
  
  public static QCircleServiceImpl getInstance()
  {
    return mInstance;
  }
  
  public static IJumpApi getJumpApi()
  {
    return (IJumpApi)QRoute.api(IJumpApi.class);
  }
  
  public static IMessageFacade getMessageFacade()
  {
    return (IMessageFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
  }
  
  public static IQQBaseService getQQService()
  {
    return (IQQBaseService)QRoute.api(IQQBaseService.class);
  }
  
  public static IQZoneService getQZoneService()
  {
    if (getAppRunTime() != null) {
      return (IQZoneService)getAppRunTime().getRuntimeService(IQZoneService.class, "all");
    }
    return (IQZoneService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQZoneService.class, "all");
  }
  
  public static IStudyModeManager getStudyModeMgr()
  {
    return (IStudyModeManager)QRoute.api(IStudyModeManager.class);
  }
  
  public static IWXShareHelper getWXShareHelper()
  {
    return (IWXShareHelper)QRoute.api(IWXShareHelper.class);
  }
  
  public void downloadSkinPackage(String paramString)
  {
    QCircleSkinHelper.getInstance().downloadSkinPackage(paramString, null);
  }
  
  public void enterByScheme(Context paramContext, String paramString)
  {
    QCirclePluginEnter.enterByScheme(paramContext, paramString);
  }
  
  public void enterBySchemeAction(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    QCirclePluginEnter.enterBySchemeAction(paramContext, paramString, paramHashMap, null);
  }
  
  public void enterBySchemeAction(Context paramContext, String paramString, HashMap<String, String> paramHashMap, HashMap<String, byte[]> paramHashMap1)
  {
    QCirclePluginEnter.enterBySchemeAction(paramContext, paramString, paramHashMap, paramHashMap1);
  }
  
  public List<Entity> getAllMessages()
  {
    return ((IMessageFacade)getAppRunTime().getRuntimeService(IMessageFacade.class, "")).getAllMessages(AppConstants.QCIRCLE_CHAT_UIN, 10008, null);
  }
  
  public Pair<Integer, List<String>> getQCircleChatRedPointInfoFromMessageList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mMessageRecord == null)
    {
      RFLog.i("QCircleServiceImpl", RFLog.USR, "getQCircleChatList null");
      return new Pair(Integer.valueOf(0), localArrayList);
    }
    IConversationFacade localIConversationFacade = (IConversationFacade)getAppRunTime().getRuntimeService(IConversationFacade.class, "");
    Iterator localIterator = this.mMessageRecord.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      String str = localMessageRecord.senderuin;
      int j = localIConversationFacade.getUnreadCount(str, localMessageRecord.istroop);
      if (j > 0) {
        localArrayList.add(str);
      }
      i += j;
    }
    RFLog.i("QCircleServiceImpl", RFLog.USR, "getQCircleChatRedPointNum num:" + i + "getSenderList:" + localArrayList.toString());
    return new Pair(Integer.valueOf(i), localArrayList);
  }
  
  public void loadImage(Option paramOption, QCirclePicStateListener paramQCirclePicStateListener)
  {
    QCircleFeedPicLoader.g().loadImage(paramOption, paramQCirclePicStateListener);
  }
  
  public ArrayList<QCircleRecentDataInterface> makeRecentBaseDataList()
  {
    Object localObject = getAllMessages();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((MessageRecord)((Iterator)localObject).next());
      }
    }
    this.mMessageRecord = new LinkedList();
    this.mMessageRecord.addAll(localArrayList);
    Collections.reverse(this.mMessageRecord);
    return makeRecentBaseDataListInner(this.mMessageRecord);
  }
  
  protected ArrayList<QCircleRecentDataInterface> makeRecentBaseDataListInner(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord != null)
      {
        QCircleRecentChatListData localQCircleRecentChatListData = new QCircleRecentChatListData(localMessageRecord);
        localQCircleRecentChatListData.update((BaseQQAppInterface)getAppRunTime(), MobileQQ.sMobileQQ.getApplicationContext());
        localQCircleRecentChatListData.setGiftInfo(QCircleChatGiftManager.getInstance().getUserGiftInfo(localMessageRecord.senderuin));
        localArrayList.add(localQCircleRecentChatListData);
      }
    }
    return localArrayList;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    mInstance = this;
  }
  
  public void onDestroy()
  {
    mInstance = null;
  }
  
  public void openRewardActivity(Activity paramActivity, JSONObject paramJSONObject)
  {
    QCircleInvokeProxy.invoke(2, 4, new Object[] { paramActivity, paramJSONObject });
  }
  
  public void refreshMainPageFeed(String paramString, VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetMainPageRsp> paramonVSRspCallBack)
  {
    paramString = new QCircleGetMainPageRequest(paramString, null, 3);
    paramString.setEnableCache(false);
    VSNetworkHelper.getInstance().sendRequest(paramString, paramonVSRspCallBack);
  }
  
  public void releaseWhenExitQCircle()
  {
    QCircleInitInject.g().getPluginCallbacks().clear();
    QCircleShadow.a().b();
  }
  
  public void sendGetRainBowRequest()
  {
    QCirclePluginManager.a().a();
  }
  
  public void tryGetSplashVideoAsync()
  {
    QCircleConfig.getInstance().tryGetSplashVideoAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl
 * JD-Core Version:    0.7.0.1
 */