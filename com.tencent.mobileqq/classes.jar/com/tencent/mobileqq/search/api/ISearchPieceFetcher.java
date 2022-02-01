package com.tencent.mobileqq.search.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.TroopAssistantSearchInfo;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ISearchPieceFetcher
  extends QRouteApi
{
  public abstract boolean bEnableFtsTroop();
  
  public abstract int enterChatWin(Context paramContext, AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean);
  
  public abstract void enterTroopTmpChatWin(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean, Bundle paramBundle, Intent[] paramArrayOfIntent);
  
  public abstract boolean filterQidianMasterSearch(AppInterface paramAppInterface, Friends paramFriends, int paramInt);
  
  public abstract int getAladdinKandianSearchUitype();
  
  public abstract String getBuddyName(AppInterface paramAppInterface, String paramString, boolean paramBoolean);
  
  public abstract String getBuddyNickName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
  
  public abstract String getCurrKeyword();
  
  public abstract DownloadParams.DecodeHandler getDecodeHandler();
  
  public abstract Pair<Integer, Integer> getFaceTypeAndResId(AppInterface paramAppInterface, int paramInt, String paramString);
  
  public abstract int getFromForHistoryCode();
  
  public abstract String getJumpUrl(Context paramContext, String paramString1, String paramString2);
  
  public abstract int getMostUseConstantsReportContact();
  
  public abstract int getQQStoryDynamicSearch();
  
  public abstract String getRealTroopName(AppInterface paramAppInterface, String paramString, boolean paramBoolean);
  
  public abstract String getSearchPlanReportString();
  
  public abstract int getShoppingAccount();
  
  public abstract List<TroopAssistantSearchInfo> getTroopAssistantSearchInfos(AppInterface paramAppInterface);
  
  public abstract String getTroopName(AppInterface paramAppInterface, String paramString, boolean paramBoolean);
  
  public abstract Bundle getTroopProfileExtra(String paramString, int paramInt);
  
  public abstract String getUinByPhoneNum(AppInterface paramAppInterface, String paramString);
  
  public abstract byte[] inflateConfigString(byte[] paramArrayOfByte);
  
  public abstract void initAssistTroopCache(AppInterface paramAppInterface);
  
  public abstract boolean isHippyEngineOn();
  
  public abstract boolean isQQAppInterface(AppRuntime paramAppRuntime);
  
  public abstract boolean isQidianMaster(byte paramByte);
  
  public abstract boolean isRobotUin(String paramString);
  
  public abstract boolean isSpecialCareInfo(String paramString);
  
  public abstract boolean isUinInAssist(String paramString);
  
  public abstract boolean isUniteSearchActivity(Context paramContext);
  
  public abstract void joinFriendProfileIntentWithTroopMemberCardIntent(Context paramContext, AppInterface paramAppInterface, Intent paramIntent, int paramInt);
  
  public abstract void jumpQQBrowserActivity(Context paramContext, String paramString);
  
  public abstract void markEnterAioFromSearch();
  
  public abstract void onClickReportHelper(Intent paramIntent);
  
  public abstract void openRobotProfileCard(Context paramContext, String paramString1, String paramString2);
  
  public abstract void refreshFavList(Activity paramActivity, String paramString, long paramLong);
  
  public abstract void saveCurrentSearchKeyword(AppInterface paramAppInterface, String paramString);
  
  public abstract void setContactSearchRecentAndHistroy(Context paramContext, AppInterface paramAppInterface, String paramString1, Friends paramFriends, String paramString2, View paramView);
  
  public abstract void setGlobalSearchConfNeedSeparate();
  
  public abstract void setStructMsgPicPreDelegateSwitch(int paramInt);
  
  public abstract void startActivateFriendsForModelTroop(Context paramContext);
  
  public abstract void startDataLinePCForModelTroop(Context paramContext);
  
  public abstract void startECShopAssistForModelTroop(AppInterface paramAppInterface, Context paramContext);
  
  public abstract void startMsgBoxListActForModelTroop(Context paramContext);
  
  public abstract void startRecommendContactForModelTroop(Context paramContext);
  
  public abstract void startServiceAccountFolderForModelTroop(Context paramContext);
  
  public abstract void startSubAccountAssistantForModelTroop(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt);
  
  public abstract void startTroopAssistantForModelTroop(Context paramContext);
  
  public abstract void startTroopBarAssistForModelTroop(AppInterface paramAppInterface, Context paramContext);
  
  public abstract void startTroopNotificationForModelTroop(AppInterface paramAppInterface, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.ISearchPieceFetcher
 * JD-Core Version:    0.7.0.1
 */