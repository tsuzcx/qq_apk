package com.tencent.qqmini.sdk.core.proxy;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public abstract interface ChannelProxy
{
  public abstract void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult);
  
  public abstract void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void checkSession(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult);
  
  public abstract void downloadQQBrowser(String paramString);
  
  public abstract void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult);
  
  public abstract String getDeviceInfo();
  
  public abstract void getFormId(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult);
  
  public abstract void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract IMediaPlayer getMediaPlayer();
  
  public abstract IMediaPlayerUtil getMediaPlayerUtil();
  
  public abstract void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, AsyncResult paramAsyncResult);
  
  public abstract void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getPhoneNumber(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getRobotUin(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult);
  
  public abstract void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult);
  
  public abstract void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract ChannelProxy.SoLoaderOption getTissueSoLoaderOption();
  
  public abstract void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserHealthData(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract void httpReport(Bundle paramBundle);
  
  public abstract boolean isGooglePlayVersion();
  
  public abstract boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2);
  
  public abstract void login(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult);
  
  public abstract boolean openGroup(Context paramContext, String paramString, AsyncResult paramAsyncResult);
  
  public abstract boolean openPermissionSettingsActivity(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2);
  
  public abstract void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult);
  
  public abstract void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void setAuth(String paramString, UserAuthInfo paramUserAuthInfo, AsyncResult paramAsyncResult);
  
  public abstract void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult);
  
  public abstract void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult);
  
  public abstract boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean startTransparentBrowserActivityForResult(Activity paramActivity, String paramString, int paramInt);
  
  public abstract boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt);
  
  public abstract boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult);
  
  public abstract void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult);
  
  public abstract boolean updateEntryList(String paramString);
  
  public abstract void updateUserSetting(String paramString, UserSettingInfo paramUserSettingInfo, AsyncResult paramAsyncResult);
  
  public abstract void uploadUserLog(String paramString);
  
  public abstract void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult);
  
  public abstract void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.ChannelProxy
 * JD-Core Version:    0.7.0.1
 */