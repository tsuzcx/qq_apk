package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.GlobalSearchConfBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pic.StructMsgPicPreDelegate;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.TroopAssistantSearchInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SearchPieceFetcherImpl
  implements ISearchPieceFetcher
{
  public boolean bEnableFtsTroop()
  {
    return SearchConfigUtils.d();
  }
  
  public int enterChatWin(Context paramContext, AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    return RecentUtil.a(paramContext, (QQAppInterface)paramAppInterface, paramString1, paramInt, paramString2, paramBoolean);
  }
  
  public void enterTroopTmpChatWin(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    RecentUtil.a(paramContext, paramString1, paramString2, paramInt, paramString3, paramBoolean, paramBundle, paramArrayOfIntent);
  }
  
  public boolean filterQidianMasterSearch(AppInterface paramAppInterface, Friends paramFriends, int paramInt)
  {
    return QidianManager.a(paramAppInterface, paramFriends, paramInt);
  }
  
  public int getAladdinKandianSearchUitype()
  {
    return 313;
  }
  
  public String getBuddyName(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    return ContactUtils.a(paramAppInterface, paramString, paramBoolean);
  }
  
  public String getBuddyNickName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    return ContactUtils.b(paramAppRuntime, paramString, paramBoolean);
  }
  
  public String getCurrKeyword()
  {
    return UniteSearchActivity.g;
  }
  
  public DownloadParams.DecodeHandler getDecodeHandler()
  {
    return URLDrawableDecodeHandler.b;
  }
  
  public Pair<Integer, Integer> getFaceTypeAndResId(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    return RecentFaceDecoder.a((QQAppInterface)paramAppInterface, paramInt, paramString);
  }
  
  public int getFromForHistoryCode()
  {
    return UniteSearchActivity.f;
  }
  
  public String getJumpUrl(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramContext);
    int j = 0;
    int i = j;
    if (bool)
    {
      i = ((UniteSearchActivity)paramContext).b;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            i = j;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    paramContext = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramContext = SearchConfigUtils.a(paramString1, i, "group");
    }
    return paramContext;
  }
  
  public int getMostUseConstantsReportContact()
  {
    return 1;
  }
  
  public int getQQStoryDynamicSearch()
  {
    return 24;
  }
  
  public String getRealTroopName(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    return ContactUtils.b(paramAppInterface, paramString, paramBoolean);
  }
  
  public String getSearchPlanReportString()
  {
    return UniteSearchReportController.a();
  }
  
  public int getShoppingAccount()
  {
    return 36;
  }
  
  public List<TroopAssistantSearchInfo> getTroopAssistantSearchInfos(AppInterface paramAppInterface)
  {
    Object localObject = TroopAssistantManager.a().n((QQAppInterface)paramAppInterface);
    paramAppInterface = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopAssistantData localTroopAssistantData = (TroopAssistantData)((Iterator)localObject).next();
        TroopAssistantSearchInfo localTroopAssistantSearchInfo = new TroopAssistantSearchInfo();
        localTroopAssistantSearchInfo.b = localTroopAssistantData.lastmsgtime;
        localTroopAssistantSearchInfo.a = localTroopAssistantData.troopUin;
        paramAppInterface.add(localTroopAssistantSearchInfo);
      }
    }
    return paramAppInterface;
  }
  
  public String getTroopName(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    return ContactUtils.a(paramAppInterface, paramString, paramBoolean);
  }
  
  public Bundle getTroopProfileExtra(String paramString, int paramInt)
  {
    return TroopInfoActivity.a(paramString, paramInt);
  }
  
  public String getUinByPhoneNum(AppInterface paramAppInterface, String paramString)
  {
    return ContactUtils.b(paramAppInterface, paramString);
  }
  
  public byte[] inflateConfigString(byte[] paramArrayOfByte)
  {
    return OlympicUtil.a(paramArrayOfByte);
  }
  
  public void initAssistTroopCache(AppInterface paramAppInterface)
  {
    TroopAssistantManager.a().p((QQAppInterface)paramAppInterface);
  }
  
  public boolean isHippyEngineOn()
  {
    return SearchEntryHippyEngine.isHippyOn();
  }
  
  public boolean isQQAppInterface(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime instanceof QQAppInterface;
  }
  
  public boolean isQidianMaster(byte paramByte)
  {
    return QidianManager.b(paramByte);
  }
  
  public boolean isRobotUin(String paramString)
  {
    return SearchUtil.a(paramString);
  }
  
  public boolean isSpecialCareInfo(String paramString)
  {
    return ((FriendsManager)MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.FRIENDS_MANAGER)).y(paramString) != null;
  }
  
  public boolean isUinInAssist(String paramString)
  {
    return TroopAssistantManager.a().a(paramString);
  }
  
  public boolean isUniteSearchActivity(Context paramContext)
  {
    return paramContext instanceof UniteSearchActivity;
  }
  
  public void joinFriendProfileIntentWithTroopMemberCardIntent(Context paramContext, AppInterface paramAppInterface, Intent paramIntent, int paramInt)
  {
    TroopMemberCardUtils.a(paramContext, (QQAppInterface)paramAppInterface, paramIntent, paramInt);
  }
  
  public void jumpQQBrowserActivity(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public void markEnterAioFromSearch()
  {
    RecentUtil.a = true;
  }
  
  public void onClickReportHelper(Intent paramIntent)
  {
    RecentUtil.a(paramIntent);
  }
  
  public void openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    RobotUtils.a(paramContext, paramString1, paramString2);
  }
  
  public void refreshFavList(Activity paramActivity, String paramString, long paramLong)
  {
    QfavHelper.a(paramActivity, paramString, paramLong);
  }
  
  public void saveCurrentSearchKeyword(AppInterface paramAppInterface, String paramString)
  {
    SearchHistoryManager.a((QQAppInterface)paramAppInterface, paramString);
  }
  
  public void setContactSearchRecentAndHistroy(Context paramContext, AppInterface paramAppInterface, String paramString1, Friends paramFriends, String paramString2, View paramView)
  {
    RecentUtil.a = true;
    paramAppInterface = (QQAppInterface)paramAppInterface;
    RecentUtil.a(paramContext, paramAppInterface, paramString1, 0, ContactUtils.a(paramFriends), false);
    SearchUtils.a(paramString2, 20, 1, paramView);
    SearchHistoryManager.a(paramAppInterface, paramString2);
  }
  
  public void setGlobalSearchConfNeedSeparate()
  {
    Object localObject = (GlobalSearchConfBean)QConfigManager.b().b(414);
    if (localObject != null)
    {
      SearchConfigManager.needSeparate = ((GlobalSearchConfBean)localObject).a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("need separate:");
        ((StringBuilder)localObject).append(SearchConfigManager.needSeparate);
        QLog.i("SearchConfigManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void setStructMsgPicPreDelegateSwitch(int paramInt)
  {
    StructMsgPicPreDelegate.a(paramInt);
  }
  
  public void startActivateFriendsForModelTroop(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ActivateFriendActivity.class);
    localIntent.putExtra("af_key_from", 5);
    paramContext.startActivity(localIntent);
  }
  
  public void startDataLinePCForModelTroop(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, LiteActivity.class);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
    ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
    ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).onClickReportHelper(localIntent);
    paramContext.startActivity(localIntent);
  }
  
  public void startECShopAssistForModelTroop(AppInterface paramAppInterface, Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, EcshopWebActivity.class);
    localIntent.putExtra("from_search", true);
    localIntent.setFlags(67108864);
    paramAppInterface = (EcShopAssistantManager)paramAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (paramAppInterface != null) {
      paramAppInterface.a(localIntent, paramContext, -1);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void startMsgBoxListActForModelTroop(Context paramContext)
  {
    MsgBoxListActivity.startMsgBoxListActivity(paramContext, 1001, String.valueOf(9999L));
  }
  
  public void startRecommendContactForModelTroop(Context paramContext)
  {
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).startActivity(paramContext, null, 0);
  }
  
  public void startServiceAccountFolderForModelTroop(Context paramContext)
  {
    SubscribeLaucher.a(paramContext, 9005, null);
  }
  
  public void startSubAccountAssistantForModelTroop(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).forwardTo(paramAppInterface, paramContext, paramString);
    ((QQAppInterface)paramAppInterface).getMessageFacade().a(paramString, paramInt);
  }
  
  public void startTroopAssistantForModelTroop(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, TroopAssistantActivity.class);
    localIntent.setFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  public void startTroopBarAssistForModelTroop(AppInterface paramAppInterface, Context paramContext)
  {
    TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
    paramAppInterface = (QQAppInterface)paramAppInterface;
    localTroopBarAssistantManager.e(paramAppInterface, false);
    localTroopBarAssistantManager.d(paramAppInterface, false);
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) {
      paramAppInterface = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchSubscriptionActivity(paramContext, 0, 1);
    } else {
      paramAppInterface = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchSubscriptionActivity(paramContext, -1, 1);
    }
    paramAppInterface.putExtra("come_from", 1);
    paramAppInterface.setFlags(67108864);
    paramContext.startActivity(paramAppInterface);
  }
  
  public void startTroopNotificationForModelTroop(AppInterface paramAppInterface, Context paramContext)
  {
    paramContext = new Intent();
    paramContext.putExtra("key_tab_mode", 2);
    int j = GroupSystemMsgController.a().b(paramAppInterface);
    int i = j;
    if (j <= 0) {
      i = RecommendTroopUtils.b(paramAppInterface);
    }
    ((QQAppInterface)paramAppInterface).getConversationFacade().e(AppConstants.TROOP_NOTIFICATION_UIN, 9000, -i);
    ((ILaunchTroopSysMsgUIUtilApi)QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).launchTroopNotificationFragment(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.SearchPieceFetcherImpl
 * JD-Core Version:    0.7.0.1
 */