package com.tencent.qqmini.sdk.launcher.core.proxy;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract interface ChannelProxy
{
  public abstract void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, String paramString4, String paramString5, AsyncResult paramAsyncResult);
  
  public abstract void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract void addGroupApp(IMiniAppContext paramIMiniAppContext, AsyncResult paramAsyncResult);
  
  public abstract void addPhoneNumber(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract void checkBindingState(String paramString1, String paramString2, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void checkSession(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void checkWxPayUrl(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult);
  
  public abstract String decodeQR(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void delPhoneNumber(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void downloadQQBrowser(String paramString);
  
  public abstract void ffmpegExecCommand(String[] paramArrayOfString, ChannelProxy.ICommandListenr paramICommandListenr);
  
  public abstract void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract void getAppInfoById(String paramString1, String paramString2, String paramString3, String paramString4, AsyncResult paramAsyncResult);
  
  public abstract void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult);
  
  public abstract void getAuthListForSubscribe(String paramString, AsyncResult paramAsyncResult);
  
  public abstract JSONArray getChooseMessageTempFilesArray(Intent paramIntent);
  
  public abstract void getContentAccelerate(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, AsyncResult paramAsyncResult);
  
  public abstract String getDeviceInfo();
  
  public abstract IFlutterProxy getFlutterProxy();
  
  public abstract void getFormId(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult);
  
  public abstract void getGdtAdInfo(String paramString1, int paramInt, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void getGroupAppStatus(IMiniAppContext paramIMiniAppContext, String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract IMediaPlayer getMediaPlayer();
  
  public abstract IMediaPlayerUtil getMediaPlayerUtil();
  
  public abstract void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, AsyncResult paramAsyncResult);
  
  public abstract MiniAIOEntranceProxy getMiniAIOEntranceView(Context paramContext, String paramString);
  
  public abstract void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getPhoneNumber(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getRobotUin(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult);
  
  public abstract void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult);
  
  public abstract void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract ChannelProxy.SoLoaderOption getTissueSoLoaderOption();
  
  public abstract void getUserAppInfo(COMM.StCommonExt paramStCommonExt, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserGroupInfo(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, long paramLong, AsyncResult paramAsyncResult);
  
  public abstract void getUserHealthData(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserSetting(String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract String getUserTheme();
  
  public abstract AbsVideoPlayer getVideoPlayer();
  
  public abstract void httpReport(Bundle paramBundle);
  
  public abstract void insertBookShelf(String paramString1, String paramString2, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract boolean isGooglePlayVersion();
  
  public abstract boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2);
  
  public abstract void launchAddPhoneNumberFragment(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void launchPhoneNumberManagementFragment(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void launchSubMsgPermissionSettingFragment(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void login(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean, CloudStorage.StInteractiveTemplate paramStInteractiveTemplate, AsyncResult paramAsyncResult);
  
  public abstract boolean openGroup(Context paramContext, String paramString, AsyncResult paramAsyncResult);
  
  public abstract boolean openPermissionSettingsActivity(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean openQzonePublish(IMiniAppContext paramIMiniAppContext, Activity paramActivity, String paramString, MiniAppInfo paramMiniAppInfo);
  
  public abstract boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2);
  
  public abstract void queryBookShelf(String paramString, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult);
  
  public abstract void realTimeLogReport(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ArrayList<RealTimeLogItem> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void reportBeacon(@NonNull ChannelProxy.BeaconReportCategory paramBeaconReportCategory, @NonNull String paramString, @Nullable Map<String, String> paramMap);
  
  public abstract void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void sendSmsCodeRequest(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void sendVerifySmsCodeRequest(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract void setAuth(String paramString, UserAuthInfo paramUserAuthInfo, AsyncResult paramAsyncResult);
  
  public abstract void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult);
  
  public abstract void setUserAppLike(boolean paramBoolean, COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult);
  
  public abstract void setUserAppTop(MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult);
  
  public abstract void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult);
  
  public abstract boolean setWebviewCookie(Context paramContext, String paramString);
  
  public abstract boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean startBrowserSupportHeaderActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt);
  
  public abstract boolean startChooseMessageFileActivityForResult(Activity paramActivity, int paramInt1, String paramString, int paramInt2);
  
  public abstract boolean startTransparentBrowserActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt);
  
  public abstract void syncForceGroundAndRefreshBadge(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt);
  
  public abstract boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult);
  
  public abstract void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult);
  
  public abstract void updateBookshelfReadtime(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract boolean updateEntryList(String paramString);
  
  public abstract void updateTouchInfoList(ArrayList<TouchInfo> paramArrayList);
  
  public abstract void updateUserSetting(String paramString, INTERFACE.StUserSettingInfo paramStUserSettingInfo, AsyncResult paramAsyncResult);
  
  public abstract void uploadUserLog(String paramString);
  
  public abstract void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult);
  
  public abstract void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy
 * JD-Core Version:    0.7.0.1
 */