package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IChatSettingForTroopApi
  extends QRouteApi
{
  public static final int APPID_TEACHERMESSAGE = 101847770;
  public static final int APPID_TOGETHEHIGH = 101872203;
  public static final int APPID_TOGETHERLISTEN = 101761547;
  public static final int APPID_TOGETHERSING = 101817424;
  public static final int APPID_TOGETHERWATCH = 101793773;
  
  public abstract void OpenTroopManagePluginActivity(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void StoryReportor(Activity paramActivity);
  
  public abstract void StoryReportorReportEvent(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs);
  
  public abstract void TroopNameEntry(Object paramObject, Activity paramActivity, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract Object actionSheetHelperCreateDialog(Context paramContext, View paramView);
  
  public abstract void addRecentTroopItemIntoRecentMsgList(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean appOnClick_Special(AppRuntime paramAppRuntime, Activity paramActivity, long paramLong, Object paramObject1, Object paramObject2);
  
  public abstract void bnrReport(AppInterface paramAppInterface, int paramInt);
  
  public abstract boolean checkPlugin(AppRuntime paramAppRuntime, Object paramObject);
  
  public abstract void clearChatRecordTaskRun(AppRuntime paramAppRuntime, String paramString1, String paramString2, Handler paramHandler, int paramInt);
  
  public abstract void clearTroopAssistTipTime(AppRuntime paramAppRuntime, String paramString);
  
  public abstract String configTroopStoryProfileFromAIO(Intent paramIntent, String paramString1, String paramString2);
  
  public abstract Dialog createQuestionDialog(Context paramContext);
  
  public abstract void deleteTroop(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void doReportTroop(Object paramObject1, Object paramObject2, AppRuntime paramAppRuntime);
  
  public abstract Intent getChatActivityIntent(Activity paramActivity);
  
  public abstract Intent getJumpActionIntent(Activity paramActivity);
  
  public abstract void getOpenID(AppInterface paramAppInterface, String paramString);
  
  public abstract String getQzoneHelperQunPhotoDataHasChange();
  
  public abstract SpannableString getSpannableStringFromColorNickText(CharSequence paramCharSequence, int paramInt);
  
  public abstract Intent getSplashActivityIntent(Activity paramActivity);
  
  public abstract Object getStrOpenIDFromCacheAndDB(AppInterface paramAppInterface, String paramString);
  
  public abstract int getTroopMask(AppRuntime paramAppRuntime, String paramString);
  
  public abstract String getTroopMemberName(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract Bundle getTroopProfileExtra(String paramString, int paramInt);
  
  public abstract Intent getTroopTagViewIntent(Activity paramActivity);
  
  public abstract String getUrlFromIndividuationUrlHelper_entryEffect();
  
  public abstract String getUrlFromIndividuationUrlHelper_keyWord();
  
  public abstract void gotoSettingOrShare(Activity paramActivity);
  
  public abstract void handleAppClick1101236949(Object paramObject, Activity paramActivity);
  
  public abstract void handleAppShareAction(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent);
  
  public abstract void handleTroopAppManageShortcutBar(AppRuntime paramAppRuntime, String paramString, Object paramObject);
  
  public abstract void hiddenChatShowGuideDialog(AppRuntime paramAppRuntime, Activity paramActivity);
  
  public abstract void hideJuhua(Object paramObject, String paramString);
  
  public abstract void initKeyword(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, Object paramObject);
  
  public abstract void initTroopShareUtility(Activity paramActivity, Object paramObject, AppRuntime paramAppRuntime);
  
  public abstract void inviteMember(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt);
  
  public abstract boolean isGrayTroopForTroopAssociations(String paramString, int paramInt, long paramLong);
  
  public abstract boolean isGrayTroopForTroopGameCard(String paramString);
  
  public abstract boolean isGroupEntranceSwitchOn();
  
  public abstract void jump2PayJoinTroopWeb(Context paramContext, String paramString1, String paramString2);
  
  public abstract void jumpRobotPage(Activity paramActivity, String paramString, boolean paramBoolean);
  
  public abstract boolean keyWordIsEnable();
  
  public abstract void launcherTroopShortcutFragment(Activity paramActivity, String paramString);
  
  public abstract void messageNotificationSettingFragmentLaunch(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean needAnswerQuestion(String paramString);
  
  public abstract void newReportTask(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract void newTroopShareUtility(Activity paramActivity, Object paramObject);
  
  public abstract void openAddTroopWeb(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void openTroopAssociationWebPage(Context paramContext, String paramString);
  
  public abstract void openTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt);
  
  public abstract void openTroopProfole(Activity paramActivity, Object paramObject, int paramInt);
  
  public abstract void openTroopmemberCard(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void preloadQunAlbum(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void reportClockTroopAppShowOrClick(Object paramObject, boolean paramBoolean);
  
  public abstract void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7);
  
  public abstract void reportDC00087(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void requestForPubAccountInfo(AppRuntime paramAppRuntime, long paramLong, int paramInt, Handler paramHandler);
  
  public abstract void secRecognize(boolean paramBoolean, View paramView);
  
  public abstract void sendBroadcastQunMsgUnreadCount(Activity paramActivity, int paramInt);
  
  public abstract void setAppIcon(Context paramContext, ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean);
  
  public abstract void setBooleanForQVipConfigManager_keyWordGuideClicked(AppRuntime paramAppRuntime);
  
  public abstract void setColorText(TextView paramTextView, Spannable paramSpannable, int paramInt);
  
  public abstract void setColorText(AppRuntime paramAppRuntime, TextView paramTextView, Spannable paramSpannable);
  
  public abstract void setStringForQVipConfigManager_keyWordExpireList(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract void setTroopMsgFilterToServer(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract void startActivityForTroop(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void startChatBackgroundSettingActivity(Activity paramActivity, AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract void startFansTroopIdolPage(Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract void startFansTroopIdolRank(Context paramContext, String paramString, int paramInt);
  
  public abstract void startGameSdkCallback(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2);
  
  public abstract Intent startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void startJumpAccountLogin(Activity paramActivity, Object paramObject);
  
  public abstract void startModifyHomeworkTroopNickname(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void startModifyLocationActivityForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void startTroop2DCode();
  
  public abstract void startTroopMemberCard(Activity paramActivity, AppRuntime paramAppRuntime, Object paramObject1, Object paramObject2, int paramInt);
  
  public abstract void startTroopRemarkActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract boolean troopNoticeFreezed(Activity paramActivity, Object paramObject);
  
  public abstract void troopShareUtilityDestroy();
  
  public abstract void updateEntryItem(AppRuntime paramAppRuntime, View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void updateHiddenChat(AppRuntime paramAppRuntime, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
 * JD-Core Version:    0.7.0.1
 */