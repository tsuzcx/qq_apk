package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginManager;
import com.tencent.biz.qqcircle.fragments.chat.QCircleChatGiftManager;
import com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.auto.engine.enter.ASEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetMainPageRequest;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
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
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Intent localIntent = new Intent(paramContext, QCircleHostClassHelper.getJumpActivityClass());
      localIntent.setData(Uri.parse(paramString));
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
    }
  }
  
  public void enterBySchemeAction(Context paramContext, String paramString, @NonNull HashMap<String, String> paramHashMap)
  {
    if ("openfolder".equals(paramString)) {
      QCirclePeriodCollect.record("enter_click");
    }
    ASEngineEnter.a(new ASEnterBean("qcircle-app").setSchemeAction(paramString).setAttrs(paramHashMap));
  }
  
  public void enterBySchemeAction(Context paramContext, String paramString, @NonNull HashMap<String, String> paramHashMap, @Nullable HashMap<String, byte[]> paramHashMap1)
  {
    if ("openfolder".equals(paramString)) {
      QCirclePeriodCollect.record("enter_click");
    }
    ASEngineEnter.a(new ASEnterBean("qcircle-app").setSchemeAction(paramString).setAttrs(paramHashMap).setByteAttrs(paramHashMap1));
  }
  
  public List<MessageRecord> getAllMessages()
  {
    return ((IMessageFacade)getAppRunTime().getRuntimeService(IMessageFacade.class, "")).getAllMessages(AppConstants.QCIRCLE_CHAT_UIN, 10008, null);
  }
  
  public Pair<Integer, List<String>> getQCircleChatRedPointInfoFromMessageList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mMessageRecord;
    int i = 0;
    if (localObject == null)
    {
      QLog.i("QCircleServiceImpl", 1, "getQCircleChatList null");
      return new Pair(Integer.valueOf(0), localArrayList);
    }
    localObject = (IConversationFacade)getAppRunTime().getRuntimeService(IConversationFacade.class, "");
    Iterator localIterator = this.mMessageRecord.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      String str = localMessageRecord.senderuin;
      int k = ((IConversationFacade)localObject).getUnreadCount(str, localMessageRecord.istroop);
      int j = i + k;
      i = j;
      if (k > 0)
      {
        localArrayList.add(str);
        i = j;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getQCircleChatRedPointNum num:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("getSenderList:");
    ((StringBuilder)localObject).append(localArrayList.toString());
    QLog.i("QCircleServiceImpl", 1, ((StringBuilder)localObject).toString());
    return new Pair(Integer.valueOf(i), localArrayList);
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
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
  
  public void releaseWhenExitQCircle() {}
  
  public void sendGetRainBowRequest()
  {
    QCirclePluginManager.a().b();
  }
  
  public void tryGetSplashVideoAsync()
  {
    QCircleConfig.getInstance().tryGetSplashVideoAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl
 * JD-Core Version:    0.7.0.1
 */