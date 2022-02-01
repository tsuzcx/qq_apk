package com.tencent.qqmini.sdk.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.action.CheckJsServiceAction;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.RequestServer;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.OpenDataDomainUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class OpenDataCommonJsPlugin
  extends BaseJsPlugin
{
  public static final String API_ON_INTERACTIVE_STORAGE_MODIFIED = "onInteractiveStorageModified";
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  private static final String TAG = "OpenDataCommonJsPlugin";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  private void doShareAppMsg(String paramString, boolean paramBoolean1, boolean paramBoolean2, InnerShareData.Builder paramBuilder)
  {
    if ((!StringUtil.isEmpty(paramString)) && ((paramBoolean1) || (paramBoolean2)))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
      {
        paramBuilder.setSharePicPath(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString)).setIsLocalPic(true).build().shareAppMessage();
        return;
      }
      paramBuilder.setSharePicPath(paramString).build().shareAppMessage();
      return;
    }
    getDefaultImg(new OpenDataCommonJsPlugin.9(this, paramBuilder));
  }
  
  private void getDefaultImg(GetScreenshot.Callback paramCallback)
  {
    if (paramCallback == null) {
      return;
    }
    if (this.mMiniAppContext.isMiniGame())
    {
      paramCallback.onGetScreenshot(WnsUtil.defaultShareImg());
      QMLog.e("OpenDataCommonJsPlugin", "[minigame]getDefaultImg, use default share image");
      return;
    }
    if (GetShareState.obtain(this.mMiniAppContext) != null)
    {
      if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot)
      {
        QMLog.e("OpenDataCommonJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
        return;
      }
      GetScreenshot.obtain(this.mMiniAppContext, new OpenDataCommonJsPlugin.12(this, paramCallback));
    }
  }
  
  private String getPath(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (this.mMiniAppInfo.isEngineTypeMiniGame()) {
        return "miniGamePath";
      }
      str = "";
    }
    return str;
  }
  
  private void getPotentialFriendListImpl(RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      paramRequestEvent.fail("appid is null");
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPotentialFriendList(null, str, new OpenDataCommonJsPlugin.11(this, paramRequestEvent));
  }
  
  private void getReactiveFriendListImpl(RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_REACTIVE_FRIEND_LIST error , no appid");
      paramRequestEvent.fail("appid is null");
      return;
    }
    String str = this.mMiniAppInfo.appId;
    RequestServer.getInstance().getReactiveFriendList(str, new OpenDataCommonJsPlugin.10(this, paramRequestEvent));
  }
  
  private void getUserInteractiveStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      paramRequestEvent.fail("appid is null");
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInteractiveStorage(null, str, paramArrayOfString, new OpenDataCommonJsPlugin.6(this, paramRequestEvent));
  }
  
  private boolean isFileExists(String paramString)
  {
    return new File(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString)).exists();
  }
  
  private boolean miniAppNotPageWebviewCall(RequestEvent paramRequestEvent)
  {
    if ((!this.mMiniAppContext.isMiniGame()) && (!CheckJsServiceAction.obtain(this.mMiniAppContext).isPageWebviewCall(paramRequestEvent.jsService)))
    {
      paramRequestEvent.fail("forbidden");
      QMLog.e("OpenDataCommonJsPlugin", "miniapp, not pagewebview call, return.");
      return true;
    }
    return false;
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2)
  {
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      paramRequestEvent.fail("appid is null.");
      return;
    }
    String str1 = this.mMiniAppInfo.appId;
    String str2 = this.mMiniAppInfo.shareId;
    if (!paramBoolean.booleanValue())
    {
      if (TextUtils.isEmpty(paramString3))
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no openid");
        paramRequestEvent.fail("openid is null.");
      }
    }
    else if (TextUtils.isEmpty(str2))
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      paramRequestEvent.fail("shareId is null.");
      return;
    }
    boolean bool = OpenDataDomainUtil.getInstance().isDomainValid(paramString6);
    int i;
    if ((!TextUtils.isEmpty(paramString6)) && (new File(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString6)).exists())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!StringUtil.isEmpty(paramString6)) && ((bool) || (i != 0)))
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2, str1, str2);
      return;
    }
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , image illegal");
    getDefaultImg(new OpenDataCommonJsPlugin.7(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2, str1, str2));
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2, String paramString10, String paramString11)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("");
    localHashMap.put(paramString1, ((StringBuilder)localObject).toString());
    localObject = new CloudStorage.StInteractiveTemplate();
    ((CloudStorage.StInteractiveTemplate)localObject).action.set(paramString8);
    ((CloudStorage.StInteractiveTemplate)localObject).object.set(paramString9);
    ((CloudStorage.StInteractiveTemplate)localObject).ratio.set(paramInt2);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).modifyFriendInteractiveStorage(null, paramString10, paramString3, paramString11, paramInt1, paramString2, localHashMap, paramBoolean.booleanValue(), (CloudStorage.StInteractiveTemplate)localObject, new OpenDataCommonJsPlugin.8(this, paramRequestEvent, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7, paramString1));
  }
  
  private void onInteractiveStorageModified(JSONObject paramJSONObject, RequestEvent paramRequestEvent, String paramString)
  {
    try
    {
      if (CheckJsServiceAction.obtain(this.mMiniAppContext).isServiceOrMainContext(paramRequestEvent.jsService))
      {
        paramJSONObject.put("key", paramString);
        paramRequestEvent = paramRequestEvent.jsService;
        paramJSONObject = paramJSONObject.toString();
        int i;
        if (this.mIsMiniGame) {
          i = -1;
        } else {
          i = PageAction.obtain(this.mMiniAppContext).getPageId();
        }
        paramRequestEvent.evaluateSubscribeJS("onInteractiveStorageModified", paramJSONObject, i);
        return;
      }
    }
    catch (Throwable paramJSONObject)
    {
      QMLog.e("OpenDataCommonJsPlugin", "onInteractiveStorageModified error,", paramJSONObject);
    }
  }
  
  private void reportOpenDataShareResultTo4239(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ThreadManager.getSubThreadHandler().post(new OpenDataCommonJsPlugin.19(this, paramIMiniAppContext, paramString1, paramString2, paramInt, paramString3));
  }
  
  private void shareMessageToFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, RequestEvent paramRequestEvent)
  {
    ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    paramString5 = "";
    String str = paramString5;
    if (localMiniAppInfo != null)
    {
      if (!TextUtils.isEmpty(this.mMiniAppInfo.friendMessageQuery))
      {
        paramString5 = new StringBuilder();
        paramString5.append("");
        paramString5.append(this.mMiniAppInfo.friendMessageQuery);
        paramString5 = paramString5.toString();
      }
      localShareState.shareAppid = this.mMiniAppInfo.appId;
      str = paramString5;
    }
    localShareState.shareEvent = paramRequestEvent.event;
    localShareState.shareCallbackId = paramRequestEvent.callbackId;
    localShareState.shareOpenid = paramString1;
    localShareState.requestEvent = paramRequestEvent;
    paramString5 = getPath(str);
    boolean bool2 = OpenDataDomainUtil.getInstance().isDomainValid(paramString4);
    boolean bool1;
    if ((!TextUtils.isEmpty(paramString4)) && (isFileExists(paramString4))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramString2 = new ShareChatModel(0, 0L, paramString2);
    doShareAppMsg(paramString4, bool2, bool1, new InnerShareData.Builder().setShareSource(11).setShareTarget(5).setTitle(this.mMiniAppInfo.name).setSummary(paramString3).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setEntryPath(paramString5).setShareChatModel(paramString2).setWithShareTicket(localShareState.withShareTicket).setRecvOpenId(paramString1).setShareInMiniProcess(localShareState.isShareInMiniProcess));
  }
  
  private void showConfirmModificationModel(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString9);
    ((StringBuilder)localObject).append(paramString8);
    String str = ((StringBuilder)localObject).toString();
    if (paramInt2 > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("确认");
      ((StringBuilder)localObject).append(paramString8);
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append(paramInt1 * paramInt2);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("确认");
      ((StringBuilder)localObject).append(paramString8);
      ((StringBuilder)localObject).append(paramString4);
    }
    ((StringBuilder)localObject).append(paramString9);
    ((StringBuilder)localObject).append("?");
    localObject = ((StringBuilder)localObject).toString();
    if (paramBoolean.booleanValue())
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("确认");
    localStringBuilder.append(paramString8);
    showQQCustomModel(str, (String)localObject, localStringBuilder.toString(), Boolean.valueOf(false), "", new OpenDataCommonJsPlugin.16(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2), null, new OpenDataCommonJsPlugin.17(this, paramRequestEvent));
  }
  
  private void showQQCustomModel(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppBrandTask.runTaskOnUiThread(new OpenDataCommonJsPlugin.18(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramBoolean, paramString4, paramOnClickListener2, paramOnCancelListener));
  }
  
  @JsEvent({"canUseComponent"})
  public void canUseComponent(RequestEvent paramRequestEvent)
  {
    if (this.mIsMiniGame)
    {
      paramRequestEvent.fail("not mini app");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("canUse", true);
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canUseComponent ");
      localStringBuilder.append(localThrowable);
      QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
  
  public void doShowFriendInteractiveDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, RequestEvent paramRequestEvent)
  {
    showQQCustomModel(paramString1, paramString2, "告诉他", Boolean.valueOf(true), "下次吧", new OpenDataCommonJsPlugin.13(this, paramString3, paramString4, paramString5, paramString6, paramString7, paramRequestEvent), new OpenDataCommonJsPlugin.14(this), new OpenDataCommonJsPlugin.15(this));
  }
  
  @JsEvent({"getFriendCloudStorage"})
  public void getFriendCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      if (miniAppNotPageWebviewCall(paramRequestEvent)) {
        return;
      }
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      int i = 0;
      if (localJSONArray != null)
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        for (;;)
        {
          localObject = arrayOfString;
          if (i >= localJSONArray.length()) {
            break;
          }
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      localObject = new String[0];
      getFriendCloudStorage((String[])localObject, paramRequestEvent);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest getFriendCloudStorage error ");
      ((StringBuilder)localObject).append(paramRequestEvent.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
    }
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFriendCloudStorage appid:");
    localStringBuilder.append(this.mMiniAppInfo.appId);
    localStringBuilder.append(", keys:");
    String str;
    if (paramArrayOfString != null) {
      str = Arrays.toString(paramArrayOfString);
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    QMLog.i("OpenDataCommonJsPlugin", localStringBuilder.toString());
    this.mChannelProxy.getFriendCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataCommonJsPlugin.2(this, paramRequestEvent));
  }
  
  @JsEvent({"getGroupCloudStorage"})
  public void getGroupCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      if (miniAppNotPageWebviewCall(paramRequestEvent)) {
        return;
      }
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("shareTicket");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyList");
      int i = 0;
      if (localJSONArray != null)
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        for (;;)
        {
          localObject = arrayOfString;
          if (i >= localJSONArray.length()) {
            break;
          }
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      localObject = new String[0];
      getGroupCloudStorage(str, (String[])localObject, paramRequestEvent);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest getUserCloudStorage error ");
      ((StringBuilder)localObject).append(paramRequestEvent.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
    }
  }
  
  public void getGroupCloudStorage(String paramString, String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("state", "fail");
        paramRequestEvent.fail(paramString, "当前小程序不是从群分享卡片打开");
        return;
      }
      catch (JSONException paramString)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("getGroupCloudStorage error ");
        paramArrayOfString.append(paramString.getMessage());
        QMLog.e("OpenDataCommonJsPlugin", paramArrayOfString.toString());
        paramRequestEvent.fail();
        return;
      }
    }
    this.mChannelProxy.getGroupCloudStorage(this.mMiniAppInfo.appId, paramString, paramArrayOfString, new OpenDataCommonJsPlugin.3(this, paramRequestEvent));
  }
  
  @JsEvent({"getPotentialFriendList"})
  public void getPotentialFriendList(RequestEvent paramRequestEvent)
  {
    try
    {
      getPotentialFriendListImpl(paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error ");
      localStringBuilder.append(localThrowable);
      QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
  
  @JsEvent({"getReactiveFriendList"})
  public void getReactiveFriendList(RequestEvent paramRequestEvent)
  {
    try
    {
      getReactiveFriendListImpl(paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error ");
      localStringBuilder.append(localThrowable);
      QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
  
  @JsEvent({"getUserCloudStorage"})
  public void getUserCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      if (miniAppNotPageWebviewCall(paramRequestEvent)) {
        return;
      }
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      int i = 0;
      if (localJSONArray != null)
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        for (;;)
        {
          localObject = arrayOfString;
          if (i >= localJSONArray.length()) {
            break;
          }
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      localObject = new String[0];
      getUserCloudStorage((String[])localObject, paramRequestEvent);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest getUserCloudStorage error ");
      ((StringBuilder)localObject).append(paramRequestEvent.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
    }
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserCloudStorage appid:");
    localStringBuilder.append(this.mMiniAppInfo.appId);
    localStringBuilder.append(", keys:");
    String str;
    if (paramArrayOfString != null) {
      str = Arrays.toString(paramArrayOfString);
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    QMLog.i("OpenDataCommonJsPlugin", localStringBuilder.toString());
    if (paramArrayOfString != null)
    {
      if (paramRequestEvent.jsService == null) {
        return;
      }
      paramRequestEvent = new OpenDataCommonJsPlugin.1(this, paramRequestEvent);
      this.mChannelProxy.getUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, paramRequestEvent);
    }
  }
  
  @JsEvent({"getUserInteractiveStorage"})
  public void getUserInteractiveStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      int i = 0;
      if (localJSONArray != null)
      {
        localObject2 = new String[localJSONArray.length()];
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= localJSONArray.length()) {
            break;
          }
          localObject2[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      Object localObject1 = new String[0];
      getUserInteractiveStorage((String[])localObject1, paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ");
      ((StringBuilder)localObject2).append(localThrowable);
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject2).toString());
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
  
  @JsEvent({"modifyFriendInteractiveStorage"})
  public void modifyFriendInteractiveStorage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        String str2 = ((JSONObject)localObject1).getString("key");
        int j = ((JSONObject)localObject1).getInt("opNum");
        String str3 = ((JSONObject)localObject1).getString("operation");
        String str4 = ((JSONObject)localObject1).optString("title");
        String str5 = ((JSONObject)localObject1).optString("imageUrl");
        String str6 = ((JSONObject)localObject1).optString("imageUrlId");
        Boolean localBoolean = Boolean.valueOf(((JSONObject)localObject1).optBoolean("quiet"));
        localObject2 = ((JSONObject)localObject1).optJSONObject("friendInfo");
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).getString("openid");
          localObject2 = ((JSONObject)localObject2).getString("nickname");
          if (TextUtils.isEmpty(this.mApkgInfo.mConfigStr)) {
            break label384;
          }
          localObject3 = new JSONObject(this.mApkgInfo.mConfigStr).optJSONArray("modifyFriendInteractiveStorageTemplates");
          if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
            break label384;
          }
          i = 0;
          if (i >= ((JSONArray)localObject3).length()) {
            break label384;
          }
          localObject4 = ((JSONArray)localObject3).getJSONObject(i);
          if (localObject4 == null) {
            break label377;
          }
          String str7 = ((JSONObject)localObject4).optString("key");
          if ((TextUtils.isEmpty(str7)) || (!str7.equals(str2))) {
            break label377;
          }
          i = ((JSONObject)localObject4).optInt("ratio");
          localObject3 = ((JSONObject)localObject4).optString("action");
          localObject4 = ((JSONObject)localObject4).optString("object");
          if (localBoolean.booleanValue())
          {
            modifyFriendInteractiveStorage(str2, j, str3, (String)localObject1, (String)localObject2, str4, str5, str6, localBoolean, paramRequestEvent, (String)localObject3, (String)localObject4, i);
            return;
          }
          showConfirmModificationModel(str2, j, str3, (String)localObject1, (String)localObject2, str4, str5, str6, localBoolean, paramRequestEvent, (String)localObject3, (String)localObject4, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject2).toString());
        paramRequestEvent.fail();
        return;
      }
      String str1 = "";
      Object localObject2 = str1;
      continue;
      label377:
      i += 1;
      continue;
      label384:
      Object localObject3 = "";
      Object localObject4 = localObject3;
      int i = -1;
    }
  }
  
  @JsEvent({"onMessage"})
  public void onMessage(RequestEvent paramRequestEvent)
  {
    if (!this.mIsMiniGame)
    {
      paramRequestEvent.fail("not mini game");
      return;
    }
    if (CheckJsServiceAction.obtain(this.mMiniAppContext).isServiceOrMainContext(paramRequestEvent.jsService))
    {
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      if ((localMiniAppInfo != null) && (localMiniAppInfo.whiteList != null) && (localMiniAppInfo.whiteList.contains("onMessage")))
      {
        paramRequestEvent.jsService.evaluateSubscribeJS("onMessage", paramRequestEvent.jsonParams, 0);
        return;
      }
      QMLog.e("OpenDataCommonJsPlugin", "开放域调用了未授权的私有API: postMessage -> onMessage");
      return;
    }
    paramRequestEvent.jsService.evaluateSubscribeJS("onMessage", paramRequestEvent.jsonParams, 0);
  }
  
  @JsEvent({"removeUserCloudStorage"})
  public void removeUserCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      int i = 0;
      if (localJSONArray != null)
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        for (;;)
        {
          localObject = arrayOfString;
          if (i >= localJSONArray.length()) {
            break;
          }
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      localObject = new String[0];
      removeUserCloudStorage((String[])localObject, paramRequestEvent);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest removeUserCloudStorage error ");
      ((StringBuilder)localObject).append(paramRequestEvent.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeUserCloudStorage appid:");
    localStringBuilder.append(this.mMiniAppInfo.appId);
    localStringBuilder.append(", keys:");
    String str;
    if (paramArrayOfString != null) {
      str = Arrays.toString(paramArrayOfString);
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    QMLog.i("OpenDataCommonJsPlugin", localStringBuilder.toString());
    this.mChannelProxy.removeUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataCommonJsPlugin.5(this, paramRequestEvent));
  }
  
  @JsEvent({"setMessageToFriendQuery"})
  public void setMessageToFriendQuery(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramRequestEvent.jsonParams).optInt("shareMessageToFriendScene", -1);
        if (i == -1) {
          paramRequestEvent.fail();
        }
        if (this.mMiniAppInfo != null)
        {
          localObject1 = this.mMiniAppInfo;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("shareMessageToFriendScene=");
          ((StringBuilder)localObject2).append(i);
          ((MiniAppInfo)localObject1).friendMessageQuery = ((StringBuilder)localObject2).toString();
          if (this.mMiniAppInfo.isEngineTypeMiniApp())
          {
            localObject1 = this.mMiniAppInfo;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(AppBrandUtil.getUrlWithoutParams(PageAction.obtain(this.mMiniAppContext).getPageUrl()));
            ((StringBuilder)localObject2).append("?");
            ((StringBuilder)localObject2).append(this.mMiniAppInfo.friendMessageQuery);
            ((MiniAppInfo)localObject1).friendMessageQuery = ((StringBuilder)localObject2).toString();
            localObject2 = AppBrandUtil.getQueryJson(PageAction.obtain(this.mMiniAppContext).getPageUrl());
            ((JSONObject)localObject2).put("shareMessageToFriendScene", i);
            StringBuilder localStringBuilder = new StringBuilder(AppBrandUtil.getUrlWithoutParams(PageAction.obtain(this.mMiniAppContext).getPageUrl()));
            Iterator localIterator = ((JSONObject)localObject2).keys();
            i = 0;
            if (localIterator.hasNext())
            {
              String str2 = (String)localIterator.next();
              if (TextUtils.isEmpty(str2)) {
                continue;
              }
              if (i != 0) {
                break label383;
              }
              localObject1 = "?";
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(str2);
              localStringBuilder.append("=");
              localStringBuilder.append(((JSONObject)localObject2).getString(str2));
              i += 1;
              continue;
            }
            this.mMiniAppInfo.friendMessageQuery = localStringBuilder.toString();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("friendMessageQuery : ");
            ((StringBuilder)localObject1).append(this.mMiniAppInfo.friendMessageQuery);
            QMLog.d("OpenDataCommonJsPlugin", ((StringBuilder)localObject1).toString());
          }
        }
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("success", true);
        paramRequestEvent.ok((JSONObject)localObject1);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error ", localThrowable);
        paramRequestEvent.fail(localThrowable.getMessage());
        return;
      }
      label383:
      String str1 = "&";
    }
  }
  
  @JsEvent({"setUserCloudStorage"})
  public void setUserCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("KVDataList");
      HashMap localHashMap = new HashMap();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          localHashMap.put(localJSONObject.get("key").toString(), localJSONObject.get("value").toString());
          i += 1;
        }
      }
      setUserCloudStorage(localHashMap, paramRequestEvent);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest setUserCloudStorage error ");
      ((StringBuilder)localObject).append(paramRequestEvent.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUserCloudStorage appid:");
    localStringBuilder.append(this.mMiniAppInfo.appId);
    localStringBuilder.append(", kvData:");
    String str;
    if (paramHashMap != null) {
      str = paramHashMap.toString();
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    QMLog.i("OpenDataCommonJsPlugin", localStringBuilder.toString());
    this.mChannelProxy.setUserCloudStorage(this.mMiniAppInfo.appId, paramHashMap, new OpenDataCommonJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"shareMessageToFriend"})
  public void shareMessageToFriend(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      localObject = localJSONObject.getJSONObject("friendInfo");
      shareMessageToFriend(((JSONObject)localObject).getString("openid"), ((JSONObject)localObject).getString("nickname"), localJSONObject.optString("title"), localJSONObject.optString("imageUrl"), localJSONObject.optString("imageUrlId"), paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error ");
      ((StringBuilder)localObject).append(localThrowable);
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */