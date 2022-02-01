package com.tencent.qqmini.sdk.core.proxy.service;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.HttpServer;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.request.AddPhoneNumberRequest;
import com.tencent.qqmini.sdk.request.BatchGetContactRequest;
import com.tencent.qqmini.sdk.request.BatchGetUserInfoRequest;
import com.tencent.qqmini.sdk.request.BookShelfInsertRequest;
import com.tencent.qqmini.sdk.request.BookShelfQueryRequest;
import com.tencent.qqmini.sdk.request.BookShelfUpdateRequest;
import com.tencent.qqmini.sdk.request.CheckBindingStateRequest;
import com.tencent.qqmini.sdk.request.CheckNavigateRightRequest;
import com.tencent.qqmini.sdk.request.CheckOfferIdRequest;
import com.tencent.qqmini.sdk.request.CheckSessionRequest;
import com.tencent.qqmini.sdk.request.CheckWxPayUrlRequest;
import com.tencent.qqmini.sdk.request.ContentAccelerateRequest;
import com.tencent.qqmini.sdk.request.DataReportRequest;
import com.tencent.qqmini.sdk.request.DcReportRequest;
import com.tencent.qqmini.sdk.request.DelPhoneNumberRequest;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.qqmini.sdk.request.GetAdRequest;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest;
import com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest;
import com.tencent.qqmini.sdk.request.GetAuthListsRequest;
import com.tencent.qqmini.sdk.request.GetCloudStorageRequest;
import com.tencent.qqmini.sdk.request.GetFirstPageByTypeRequest;
import com.tencent.qqmini.sdk.request.GetFormIdRequest;
import com.tencent.qqmini.sdk.request.GetFriendCloudStorageRequest;
import com.tencent.qqmini.sdk.request.GetGroupCloudStorageRequest;
import com.tencent.qqmini.sdk.request.GetLoginCodeRequest;
import com.tencent.qqmini.sdk.request.GetNativeAppInfoRequest;
import com.tencent.qqmini.sdk.request.GetNewBaseLibRequest;
import com.tencent.qqmini.sdk.request.GetPhoneNumberRequest;
import com.tencent.qqmini.sdk.request.GetPotentialFriendListRequest;
import com.tencent.qqmini.sdk.request.GetProfileRequest;
import com.tencent.qqmini.sdk.request.GetRobotUinRequest;
import com.tencent.qqmini.sdk.request.GetSDKOpenKeyTokenRequest;
import com.tencent.qqmini.sdk.request.GetShareInfoRequest;
import com.tencent.qqmini.sdk.request.GetTcbTicketRequest;
import com.tencent.qqmini.sdk.request.GetTransRoomIdRequest;
import com.tencent.qqmini.sdk.request.GetUserAppInfoRequest;
import com.tencent.qqmini.sdk.request.GetUserGroupInfoRequest;
import com.tencent.qqmini.sdk.request.GetUserHealthDataRequest;
import com.tencent.qqmini.sdk.request.GetUserInfoExtraRequest;
import com.tencent.qqmini.sdk.request.GetUserInteractiveStorageRequest;
import com.tencent.qqmini.sdk.request.GetUserSettingRequest;
import com.tencent.qqmini.sdk.request.JudgeTimingRequest;
import com.tencent.qqmini.sdk.request.MiniAppGetGroupShareInfoRequest;
import com.tencent.qqmini.sdk.request.ModifyFriendInteractiveStorageRequest;
import com.tencent.qqmini.sdk.request.PayRequest;
import com.tencent.qqmini.sdk.request.ProtoBufRequest;
import com.tencent.qqmini.sdk.request.QueryCurrencyRequest;
import com.tencent.qqmini.sdk.request.RealTimeLogReportRequest;
import com.tencent.qqmini.sdk.request.RemoveCloudStorageRequest;
import com.tencent.qqmini.sdk.request.ReportExecuteRequest;
import com.tencent.qqmini.sdk.request.ReportShareRequest;
import com.tencent.qqmini.sdk.request.SetAuthsRequest;
import com.tencent.qqmini.sdk.request.SetAvatarRequest;
import com.tencent.qqmini.sdk.request.SetCloudStorageRequest;
import com.tencent.qqmini.sdk.request.SetUserAppLikeRequest;
import com.tencent.qqmini.sdk.request.UseUserAppRequest;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@ProxyService(proxy=ChannelProxy.class)
public class ChannelProxyDefault
  implements ChannelProxy
{
  private static final String TAG = "ChannelProxyDefault";
  private boolean useHttpDirectly;
  
  public ChannelProxyDefault()
  {
    if ((QUAUtil.isAlienApp()) || (QUAUtil.isDemoApp())) {}
    for (boolean bool = true;; bool = false)
    {
      this.useHttpDirectly = bool;
      return;
    }
  }
  
  private int getGTK(String paramString)
  {
    int i = 5381;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.length();
      int j = 5381;
      i = 0;
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
      i = 0x7FFFFFFF & j;
    }
    return i;
  }
  
  private Map<String, String> getHeaderMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = null;
    if (paramJSONObject.has("header"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("header");
      Iterator localIterator = paramJSONObject.keys();
      localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramJSONObject.optString(str));
      }
    }
    return localHashMap;
  }
  
  private void handleRequest(ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = paramProtoBufRequest.encode();
      QMLog.w("ChannelProxyDefault", "sendData " + paramProtoBufRequest);
      if (this.useHttpDirectly)
      {
        sendDataByHttpServer(paramProtoBufRequest, paramAsyncResult, arrayOfByte);
        return;
      }
    }
    catch (Exception paramProtoBufRequest)
    {
      do
      {
        QMLog.e("ChannelProxyDefault", "handleRequest Exception", paramProtoBufRequest);
      } while (paramAsyncResult == null);
      paramProtoBufRequest = new JSONObject();
    }
    try
    {
      paramProtoBufRequest.put("retCode", -1);
      paramProtoBufRequest.put("errMsg", "数据编码错误");
      label93:
      paramAsyncResult.onReceiveResult(false, paramProtoBufRequest);
      return;
      sendDataByProxy(paramProtoBufRequest, paramAsyncResult, localMiniAppProxy, arrayOfByte);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label93;
    }
  }
  
  private void handleWnsCgiRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if (paramArrayOfByte == null) {
          break label136;
        }
        if (paramBoolean1)
        {
          localJSONObject.put("data", new JSONObject(new String(paramArrayOfByte)));
          localJSONObject.put("statusCode", paramInt);
          localJSONObject.put("wnsCode", 0);
          localJSONObject.put("header", JSONUtil.headerToJson(paramMap));
          paramAsyncResult.onReceiveResult(true, localJSONObject);
          return;
        }
        if (paramBoolean2)
        {
          paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
          localJSONObject.put("data", paramArrayOfByte);
          continue;
        }
        paramArrayOfByte = new String(paramArrayOfByte);
      }
      catch (Throwable paramArrayOfByte)
      {
        QMLog.e("ChannelProxyDefault", "handleMessage wnsCgiRequest exception ", paramArrayOfByte);
        paramAsyncResult.onReceiveResult(false, null);
        return;
      }
      continue;
      label136:
      localJSONObject.put("data", "");
    }
  }
  
  private void sendDataByHttpServer(ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult, byte[] paramArrayOfByte)
  {
    HttpServer.sendData(paramArrayOfByte, new ChannelProxyDefault.6(this, paramProtoBufRequest, paramAsyncResult));
  }
  
  private void sendDataByProxy(ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult, MiniAppProxy paramMiniAppProxy, byte[] paramArrayOfByte)
  {
    paramMiniAppProxy.sendData(paramArrayOfByte, new ChannelProxyDefault.5(this, paramProtoBufRequest, paramAsyncResult));
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new ReportExecuteRequest(paramString1, paramInt, paramString2, paramString3), paramAsyncResult);
  }
  
  public void addGroupApp(IMiniAppContext paramIMiniAppContext, AsyncResult paramAsyncResult) {}
  
  public void addPhoneNumber(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new AddPhoneNumberRequest(paramString1, paramString2, paramString3, paramInt), paramAsyncResult);
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new BatchGetContactRequest(paramArrayList), paramAsyncResult);
  }
  
  public void checkBindingState(String paramString1, String paramString2, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new CheckBindingStateRequest(paramString1, paramString2, paramInt), paramAsyncResult);
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new CheckNavigateRightRequest(paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new CheckOfferIdRequest(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new CheckSessionRequest(paramString), paramAsyncResult);
  }
  
  public void checkWxPayUrl(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new CheckWxPayUrlRequest(paramString1, paramString2), paramAsyncResult);
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    handleRequest(new DataReportRequest(paramArrayOfByte), paramAsyncResult);
  }
  
  public String decodeQR(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return null;
  }
  
  public void delPhoneNumber(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new DelPhoneNumberRequest(paramString1, paramString2), paramAsyncResult);
  }
  
  public void doGameRaffle(String paramString1, String paramString2, AsyncResult paramAsyncResult) {}
  
  public void downloadQQBrowser(String paramString) {}
  
  public void ffmpegExecCommand(String[] paramArrayOfString, ChannelProxy.ICommandListenr paramICommandListenr) {}
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetAppInfoByIdRequest(null, paramString1, 1, 0, paramString2, paramString3, null), paramAsyncResult);
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetAppInfoByIdRequest(null, paramString1, 1, 0, paramString2, paramString3, paramString4), paramAsyncResult);
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetAppInfoByLinkRequest(paramString, paramInt), paramAsyncResult);
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    paramString = new GetAuthListsRequest(null, paramString);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    handleRequest(paramString, new ChannelProxyDefault.1(this, paramAuthListResult));
  }
  
  public void getAuthListForSubscribe(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetAuthListsRequest(null, paramString), new ChannelProxyDefault.2(this, paramAsyncResult));
  }
  
  public JSONArray getChooseMessageTempFilesArray(Intent paramIntent)
  {
    return null;
  }
  
  public void getContentAccelerate(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new ContentAccelerateRequest(null, paramString1, paramString2, paramInt, paramMap), paramAsyncResult);
  }
  
  public String getDeviceInfo()
  {
    return QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext());
  }
  
  public IFlutterProxy getFlutterProxy()
  {
    return null;
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetFormIdRequest(paramString), paramAsyncResult);
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetFriendCloudStorageRequest(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getGameRaffleMaterial(String paramString1, String paramString2, AsyncResult paramAsyncResult) {}
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetAdRequest(paramString1, paramInt, paramString2, paramString3, paramString4, paramHashMap), paramAsyncResult);
  }
  
  public void getGdtAdInfo(String paramString1, int paramInt, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetAdInfoRequest(paramString1, paramInt, paramString2), paramAsyncResult);
  }
  
  public Drawable getGifDrawable(String paramString)
  {
    return null;
  }
  
  public void getGroupAppStatus(IMiniAppContext paramIMiniAppContext, String paramString, AsyncResult paramAsyncResult) {}
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetGroupCloudStorageRequest(paramArrayOfString, paramString2, paramString1), paramAsyncResult);
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new MiniAppGetGroupShareInfoRequest(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public IMediaPlayer getMediaPlayer()
  {
    return new DefaultMediaPlayer();
  }
  
  public IMediaPlayerUtil getMediaPlayerUtil()
  {
    return new ChannelProxyDefault.7(this);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new PayRequest(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString3, paramString4), paramAsyncResult);
  }
  
  public MiniAIOEntranceProxy getMiniAIOEntranceView(Context paramContext, String paramString)
  {
    return null;
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetFirstPageByTypeRequest(paramInt), paramAsyncResult);
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetNativeAppInfoRequest(null, paramString1, paramString2, paramString3, paramInt), paramAsyncResult);
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetPhoneNumberRequest(paramString), paramAsyncResult);
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetPotentialFriendListRequest(paramStCommonExt, paramString), paramAsyncResult);
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetRobotUinRequest(null, paramString), paramAsyncResult);
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetSDKOpenKeyTokenRequest(paramStCommonExt), paramAsyncResult);
  }
  
  public long getServerTime()
  {
    return 0L;
  }
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetShareInfoRequest(paramStAdaptShareInfoReq), paramAsyncResult);
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetTcbTicketRequest(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public ChannelProxy.SoLoaderOption getTissueSoLoaderOption()
  {
    return null;
  }
  
  public void getUserAppInfo(COMM.StCommonExt paramStCommonExt, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetUserAppInfoRequest(paramStCommonExt, paramArrayList), paramAsyncResult);
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetCloudStorageRequest(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getUserGroupInfo(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, long paramLong, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetUserGroupInfoRequest(paramString1, paramString2, paramLong, paramStCommonExt), paramAsyncResult);
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetUserHealthDataRequest(null, paramString), paramAsyncResult);
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetProfileRequest(paramString1, paramBoolean, paramString2), paramAsyncResult);
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetUserInfoExtraRequest(paramString), paramAsyncResult);
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new BatchGetUserInfoRequest(paramString1, paramString2, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetUserInteractiveStorageRequest(paramStCommonExt, paramString, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetUserSettingRequest(paramString1, paramString2, paramString3), paramAsyncResult);
  }
  
  public String getUserTheme()
  {
    return null;
  }
  
  public AbsVideoPlayer getVideoPlayer()
  {
    return new VideoPlayerDefault();
  }
  
  public void httpReport(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("log_key");
    paramBundle = paramBundle.getStringArray("data");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramBundle.length)
    {
      localStringBuilder.append(paramBundle[i]);
      if (i < paramBundle.length - 1) {
        localStringBuilder.append('|');
      }
      i += 1;
    }
    ((RequestProxy)ProxyManager.get(RequestProxy.class)).request("https://q.qq.com/report/dc/" + str, localStringBuilder.toString().getBytes(), null, "POST", 60, new ChannelProxyDefault.3(this));
  }
  
  public void insertBookShelf(String paramString1, String paramString2, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new BookShelfInsertRequest(paramString1, paramString2, paramArrayList), paramAsyncResult);
  }
  
  public boolean isGooglePlayVersion()
  {
    return false;
  }
  
  public void judgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, String paramString4, String paramString5, AsyncResult paramAsyncResult)
  {
    handleRequest(new JudgeTimingRequest(paramString1, paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramString2, paramInt5, paramString3, paramInt6, paramStCommonExt, paramString4, paramString5), paramAsyncResult);
  }
  
  public boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void launchAddPhoneNumberFragment(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    MiniFragmentLauncher.startForResult(paramActivity, paramIntent, paramInt, MiniFragmentLauncher.FragmentType.FRAGMENT_ADD_PHONE_NUMBER);
  }
  
  public void launchPhoneNumberManagementFragment(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    MiniFragmentLauncher.startForResult(paramActivity, paramIntent, paramInt, MiniFragmentLauncher.FragmentType.FRAGMENT_PHONE_NUMBER_MANAGEMENT);
  }
  
  public void launchSubMsgPermissionSettingFragment(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    MiniFragmentLauncher.startForResult(paramActivity, paramIntent, paramInt, MiniFragmentLauncher.FragmentType.FRAGMENT_SUB_MSG_PERMISSION_SETTING);
  }
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetLoginCodeRequest(paramString), paramAsyncResult);
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean, CloudStorage.StInteractiveTemplate paramStInteractiveTemplate, AsyncResult paramAsyncResult)
  {
    handleRequest(new ModifyFriendInteractiveStorageRequest(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap, paramBoolean, paramStInteractiveTemplate), paramAsyncResult);
  }
  
  public boolean openGroup(Context paramContext, String paramString, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean openPermissionSettingsActivity(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    MiniFragmentLauncher.startForResult((Activity)paramContext, localIntent, 5, MiniFragmentLauncher.FragmentType.FRAGMENT_PERMISSION_SETTING);
    return true;
  }
  
  public boolean openQzonePublish(IMiniAppContext paramIMiniAppContext, Activity paramActivity, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    return false;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void queryBookShelf(String paramString, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new BookShelfQueryRequest(paramString, paramArrayList), paramAsyncResult);
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    handleRequest(new QueryCurrencyRequest(null, paramString2, paramString1, paramInt1, paramInt2), paramAsyncResult);
  }
  
  public void realTimeLogReport(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ArrayList<RealTimeLogItem> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new RealTimeLogReportRequest(paramString1, paramString2, paramString3, paramArrayOfString, paramArrayList), paramAsyncResult);
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new RemoveCloudStorageRequest(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new DcReportRequest(paramArrayOfByte, paramString1, paramString2), paramAsyncResult);
  }
  
  public void reportBeacon(@NonNull ChannelProxy.BeaconReportCategory paramBeaconReportCategory, @NonNull String paramString, @Nullable Map<String, String> paramMap)
  {
    QMLog.d("ChannelProxyDefault", "reportBeacon() called with: category = [" + paramBeaconReportCategory + "], eventName = [" + paramString + "], param = [" + paramMap + "]");
  }
  
  public void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new ReportShareRequest(paramLong, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2), paramAsyncResult);
  }
  
  public void sendSmsCodeRequest(String paramString1, String paramString2, AsyncResult paramAsyncResult) {}
  
  public void sendVerifySmsCodeRequest(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult) {}
  
  public void setAuth(String paramString, UserAuthInfo paramUserAuthInfo, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(paramUserAuthInfo.scope);
    if (!TextUtils.isEmpty(paramUserAuthInfo.desc)) {
      localStUserAuthInfo.desc.set(paramUserAuthInfo.desc);
    }
    localStUserAuthInfo.authState.set(paramUserAuthInfo.authState);
    handleRequest(new SetAuthsRequest(null, paramString, localStUserAuthInfo), paramAsyncResult);
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new SetAvatarRequest(null, paramString1, paramString2, paramInt, paramString3, paramString4), paramAsyncResult);
  }
  
  public void setUserAppLike(boolean paramBoolean, COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      handleRequest(new SetUserAppLikeRequest(paramStCommonExt, paramString, i), paramAsyncResult);
      return;
    }
  }
  
  public void setUserAppTop(MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult) {}
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new SetCloudStorageRequest(paramHashMap, paramString), paramAsyncResult);
  }
  
  public boolean setWebviewCookie(Context paramContext, String paramString)
  {
    return false;
  }
  
  public void springHbReport(String paramString1, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString2) {}
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean startBrowserSupportHeaderActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    return false;
  }
  
  public boolean startChooseMessageFileActivityForResult(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    return false;
  }
  
  public void startDownloadX5(IMiniAppContext paramIMiniAppContext) {}
  
  public boolean startRedpacketTranslucentBrowserActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("key_orientation_landscape", false);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentLauncher.startTranslucentForResult(paramActivity, localIntent, paramInt, MiniFragmentLauncher.FragmentType.FRAGMENT_TRANSLUCENT_BROWSER);
    return true;
  }
  
  public boolean startTransparentBrowserActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentLauncher.startTranslucentForResult(paramActivity, localIntent, paramInt, MiniFragmentLauncher.FragmentType.FRAGMENT_TRANSLUCENT_BROWSER);
    return true;
  }
  
  public void syncForceGroundAndRefreshBadge(Activity paramActivity, String paramString1, String paramString2) {}
  
  public boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    return false;
  }
  
  public boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetTransRoomIdRequest(paramString1, paramString2), paramAsyncResult);
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    QMLog.i("ChannelProxyDefault", "[MiniEng] doUpdateBaseLib nocheck=" + paramBoolean1 + ", force=" + paramBoolean2);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l = StorageUtil.getPreference().getLong("baselib_min_update_time", 0L);
      if (System.currentTimeMillis() - l <= 0L)
      {
        QMLog.i("ChannelProxyDefault", "[MiniEng] updateBaseLib 在时间间隔内，暂时不更新");
        return false;
      }
    }
    handleRequest(new GetNewBaseLibRequest(paramString, 0), paramAsyncResult);
    return true;
  }
  
  public void updateBookshelfReadtime(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new BookShelfUpdateRequest(paramString1, paramString2, paramString3), paramAsyncResult);
  }
  
  public boolean updateEntryList(String paramString)
  {
    return false;
  }
  
  public void updateTouchInfoList(ArrayList<TouchInfo> paramArrayList) {}
  
  public void updateUserSetting(String paramString, INTERFACE.StUserSettingInfo paramStUserSettingInfo, AsyncResult paramAsyncResult) {}
  
  public void uploadUserLog(String paramString) {}
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new UseUserAppRequest(paramStCommonExt, paramString1, paramInt1, paramInt2, paramString2, paramString3), paramAsyncResult);
  }
  
  public void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, AsyncResult paramAsyncResult) {}
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    if (paramAsyncResult == null) {
      return false;
    }
    if (paramJSONObject == null)
    {
      paramAsyncResult.onReceiveResult(false, new JSONObject());
      return false;
    }
    for (;;)
    {
      try
      {
        Map localMap = getHeaderMap(paramJSONObject);
        String str2 = paramJSONObject.optString("url");
        if (paramJSONObject.has("data"))
        {
          str1 = paramJSONObject.optString("data");
          String str3 = paramJSONObject.optString("method", "GET");
          boolean bool1 = paramJSONObject.optString("dataType").equalsIgnoreCase("json");
          boolean bool2 = paramJSONObject.optString("responseType").equals("base64");
          if (TextUtils.isEmpty(str2))
          {
            paramAsyncResult.onReceiveResult(false, null);
            return false;
          }
          if (TextUtils.isEmpty(str3))
          {
            paramAsyncResult.onReceiveResult(false, null);
            return false;
          }
          RequestProxy localRequestProxy = (RequestProxy)ProxyManager.get(RequestProxy.class);
          if (str1 != null)
          {
            paramJSONObject = str1.getBytes();
            localRequestProxy.request(str2, paramJSONObject, localMap, str3, 60000, new ChannelProxyDefault.4(this, paramAsyncResult, bool1, bool2));
            return true;
          }
          paramJSONObject = null;
          continue;
        }
        String str1 = null;
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("ChannelProxyDefault", "performWnsCgiRequest ", paramJSONObject);
        paramAsyncResult.onReceiveResult(false, null);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault
 * JD-Core Version:    0.7.0.1
 */