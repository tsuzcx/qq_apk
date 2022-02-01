package com.tencent.mobileqq.troop.utils.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;

@QAPI(process={"all"})
public abstract interface ITroopUtilsApi
  extends QRouteApi
{
  public static final int MEMBER_HAS_CARD_HAS_ADD_BTN = 3;
  public static final int MEMBER_HAS_CARD_NO_ADD_BTN = 1;
  public static final int MEMBER_NO_CARD_HAS_ADD_BTN = 2;
  public static final int MEMBER_NO_CARD_NO_ADD_BTN = 0;
  public static final String SP_KEY_TROOP_INFO_EDIT_RED_SHOW_TAG = "red_tag_";
  public static final String SP_TROOP_INFO_EDIT_RED_SHOW = "sp_troop_info_edit_red_show_";
  public static final String TROOP_MANAGE_EDIT_CURRENT_UIN = "troop_manager_edit_current_uin";
  public static final String TROOP_MANAGE_EDIT_RED_NEED_SHOW = "troop_manager_edit_red_show";
  public static final int TYPE_GUEST_VISTOR = 2;
  public static final int TYPE_HOST_VISTOR = 1;
  public static final int TYPE_UNKNOW = -1;
  public static final String VISTOR_TYPE = "vistor_type";
  
  public abstract void calJoinTroop(TroopInfoData paramTroopInfoData, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void checkApiState(AppRuntime paramAppRuntime, Context paramContext, String paramString, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle);
  
  public abstract boolean checkIsShowCacheAppInfos(AppRuntime paramAppRuntime, String paramString, ArrayList<TroopAppInfo> paramArrayList);
  
  public abstract String constructParams(Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract EntryModel createEntryModel(TroopInfo paramTroopInfo, String paramString);
  
  public abstract int dp2px(float paramFloat, Resources paramResources);
  
  public abstract String encrypt(String paramString);
  
  public abstract String getDateString(long paramLong);
  
  public abstract String getDateString(Context paramContext, long paramLong);
  
  public abstract int getExposureSource();
  
  public abstract int getExposureSourceReportVal();
  
  public abstract String getLocalSkey(AppInterface paramAppInterface);
  
  public abstract int getMaxWidthForNameInTroopMemberListActivity(int paramInt);
  
  public abstract int getMessageHistoryCont(AppRuntime paramAppRuntime, String paramString, int paramInt, StringBuilder paramStringBuilder);
  
  public abstract int getSpecialCareRingRoamingSetting(AppRuntime paramAppRuntime);
  
  public abstract int getTroopGeneralSettingRing(AppRuntime paramAppRuntime);
  
  public abstract int getTroopGeneralSettingVibrate(AppRuntime paramAppRuntime);
  
  public abstract boolean getTroopInfoEditRedShow(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract int getTroopMask(AppRuntime paramAppRuntime, String paramString);
  
  public abstract Intent getTroopMemberListActivityLaunchIntent(Context paramContext, String paramString, int paramInt);
  
  public abstract void handleJoinTroopFailed(Activity paramActivity, int paramInt);
  
  public abstract TroopInfo initTroopInfo(AppRuntime paramAppRuntime, TroopInfoData paramTroopInfoData, Context paramContext);
  
  public abstract TroopInfoData initTroopInfoData(Bundle paramBundle, Context paramContext);
  
  public abstract boolean isEmptyRedPointSP(String paramString);
  
  public abstract boolean isShowKingTeamRedPoint(boolean paramBoolean, String paramString);
  
  public abstract boolean isShowRedPoint(boolean paramBoolean, String paramString);
  
  public abstract boolean isTroopAdmin(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract boolean isTroopEditInfoRedExist(AppRuntime paramAppRuntime, String paramString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt);
  
  public abstract boolean isTroopMark(AppRuntime paramAppRuntime, Message paramMessage);
  
  public abstract boolean isTroopMark(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract boolean isTroopTagNeedRedDot(long paramLong);
  
  public abstract boolean isUpdateBeforeSomeVersion(Context paramContext, String paramString);
  
  public abstract void joinGroupOneStep(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent, HttpWebCgiAsyncTask.Callback paramCallback);
  
  public abstract void notifyUser(Context paramContext, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void preloadWebProcess(AppRuntime paramAppRuntime);
  
  public abstract int readPictureDegree(String paramString);
  
  public abstract String replaceSpecialTag(String paramString, long paramLong, int paramInt, TroopInfoData paramTroopInfoData, AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void reportQunMiniApp(oidb_0xe83.AppInfo paramAppInfo, String paramString1, String paramString2);
  
  public abstract void requestTroopPrivilege(Context paramContext, AppInterface paramAppInterface, String paramString, structmsg.StructMsg paramStructMsg, TroopNotificationUtils.TroopPrivilegeCallback paramTroopPrivilegeCallback);
  
  public abstract String saveMemberUinStringToDB(AppRuntime paramAppRuntime, boolean paramBoolean, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList);
  
  public abstract void setExposureSource(int paramInt);
  
  public abstract void setRedPointSP(String paramString);
  
  public abstract void setSpecialCareRingRoamingSetting(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void setTroopGeneralSettingRing(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void setTroopGeneralSettingVibrate(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void setTroopInfoEditRedShow(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract long stringToLong(String paramString);
  
  public abstract JSONArray toJSONArray(Object paramObject);
  
  public abstract void updateRedPoint(boolean paramBoolean, TextView paramTextView);
  
  public abstract void updateRedPoint(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, TextView paramTextView);
  
  public abstract void updateTroopInfoToDB(TroopInfo paramTroopInfo, AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract Object wrap(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
 * JD-Core Version:    0.7.0.1
 */