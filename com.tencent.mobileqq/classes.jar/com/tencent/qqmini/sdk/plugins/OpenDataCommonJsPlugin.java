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
    if ((StringUtil.isEmpty(paramString)) || ((!paramBoolean1) && (!paramBoolean2)))
    {
      getDefaultImg(new OpenDataCommonJsPlugin.9(this, paramBuilder));
      return;
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
    {
      paramBuilder.setSharePicPath(paramString).build().shareAppMessage();
      return;
    }
    paramBuilder.setSharePicPath(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString)).setIsLocalPic(true).build().shareAppMessage();
  }
  
  private void getDefaultImg(GetScreenshot.Callback paramCallback)
  {
    if (paramCallback == null) {}
    do
    {
      return;
      if (this.mMiniAppContext.isMiniGame())
      {
        paramCallback.onGetScreenshot(WnsUtil.defaultShareImg());
        QMLog.e("OpenDataCommonJsPlugin", "[minigame]getDefaultImg, use default share image");
        return;
      }
    } while (GetShareState.obtain(this.mMiniAppContext) == null);
    if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot)
    {
      QMLog.e("OpenDataCommonJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
      return;
    }
    GetScreenshot.obtain(this.mMiniAppContext, new OpenDataCommonJsPlugin.12(this, paramCallback));
  }
  
  private String getPath(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (this.mMiniAppInfo.isEngineTypeMiniGame()) {
        str = "miniGamePath";
      }
    }
    else {
      return str;
    }
    return "";
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
    if ((!TextUtils.isEmpty(paramString6)) && (new File(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString6)).exists())) {}
    for (int i = 1; (StringUtil.isEmpty(paramString6)) || ((!bool) && (i == 0)); i = 0)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , image illegal");
      getDefaultImg(new OpenDataCommonJsPlugin.7(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2, str1, str2));
      return;
    }
    modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2, str1, str2);
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2, String paramString10, String paramString11)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramInt1 + "");
    CloudStorage.StInteractiveTemplate localStInteractiveTemplate = new CloudStorage.StInteractiveTemplate();
    localStInteractiveTemplate.action.set(paramString8);
    localStInteractiveTemplate.object.set(paramString9);
    localStInteractiveTemplate.ratio.set(paramInt2);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).modifyFriendInteractiveStorage(null, paramString10, paramString3, paramString11, paramInt1, paramString2, localHashMap, paramBoolean.booleanValue(), localStInteractiveTemplate, new OpenDataCommonJsPlugin.8(this, paramRequestEvent, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7, paramString1));
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
        if (this.mIsMiniGame) {}
        for (int i = -1;; i = PageAction.obtain(this.mMiniAppContext).getPageId())
        {
          paramRequestEvent.evaluateSubscribeJS("onInteractiveStorageModified", paramJSONObject, i);
          return;
        }
      }
      return;
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
    paramString5 = "";
    ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
    String str = paramString5;
    if (this.mMiniAppInfo != null)
    {
      if (!TextUtils.isEmpty(this.mMiniAppInfo.friendMessageQuery)) {
        paramString5 = "" + this.mMiniAppInfo.friendMessageQuery;
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
    if ((!TextUtils.isEmpty(paramString4)) && (isFileExists(paramString4))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString2 = new ShareChatModel(0, 0L, paramString2);
      doShareAppMsg(paramString4, bool2, bool1, new InnerShareData.Builder().setShareSource(11).setShareTarget(5).setTitle(this.mMiniAppInfo.name).setSummary(paramString3).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setEntryPath(paramString5).setShareChatModel(paramString2).setWithShareTicket(localShareState.withShareTicket).setRecvOpenId(paramString1).setShareInMiniProcess(localShareState.isShareInMiniProcess));
      return;
    }
  }
  
  private void showConfirmModificationModel(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2)
  {
    String str2 = paramString9 + paramString8;
    if (paramInt2 > 0) {}
    for (String str1 = "确认" + paramString8 + paramString4 + paramInt1 * paramInt2 + paramString9 + "?"; paramBoolean.booleanValue(); str1 = "确认" + paramString8 + paramString4 + paramString9 + "?")
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2);
      return;
    }
    showQQCustomModel(str2, str1, "确认" + paramString8, Boolean.valueOf(false), "", new OpenDataCommonJsPlugin.16(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9, paramInt2), null, new OpenDataCommonJsPlugin.17(this, paramRequestEvent));
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
      QMLog.e("OpenDataCommonJsPlugin", "canUseComponent " + localThrowable);
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
    label117:
    for (;;)
    {
      try
      {
        if (miniAppNotPageWebviewCall(paramRequestEvent)) {
          return;
        }
        JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
        if (localJSONArray != null)
        {
          arrayOfString = new String[localJSONArray.length()];
          int i = 0;
          if (i >= localJSONArray.length()) {
            break label117;
          }
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
          continue;
          getFriendCloudStorage(arrayOfString, paramRequestEvent);
          return;
        }
      }
      catch (Throwable paramRequestEvent)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest getFriendCloudStorage error " + paramRequestEvent.getMessage());
        return;
      }
      String[] arrayOfString = new String[0];
    }
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      QMLog.i("OpenDataCommonJsPlugin", str);
      this.mChannelProxy.getFriendCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataCommonJsPlugin.2(this, paramRequestEvent));
      return;
    }
  }
  
  @JsEvent({"getGroupCloudStorage"})
  public void getGroupCloudStorage(RequestEvent paramRequestEvent)
  {
    label130:
    for (;;)
    {
      try
      {
        if (miniAppNotPageWebviewCall(paramRequestEvent)) {
          return;
        }
        localObject = new JSONObject(paramRequestEvent.jsonParams);
        String str = ((JSONObject)localObject).optString("shareTicket");
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyList");
        if (localJSONArray != null)
        {
          localObject = new String[localJSONArray.length()];
          int i = 0;
          if (i >= localJSONArray.length()) {
            break label130;
          }
          localObject[i] = ((String)localJSONArray.get(i));
          i += 1;
          continue;
          getGroupCloudStorage(str, (String[])localObject, paramRequestEvent);
          return;
        }
      }
      catch (Throwable paramRequestEvent)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest getUserCloudStorage error " + paramRequestEvent.getMessage());
        return;
      }
      Object localObject = new String[0];
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
        QMLog.e("OpenDataCommonJsPlugin", "getGroupCloudStorage error " + paramString.getMessage());
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
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable);
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
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable);
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
  
  @JsEvent({"getUserCloudStorage"})
  public void getUserCloudStorage(RequestEvent paramRequestEvent)
  {
    label117:
    for (;;)
    {
      try
      {
        if (miniAppNotPageWebviewCall(paramRequestEvent)) {
          return;
        }
        JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
        if (localJSONArray != null)
        {
          arrayOfString = new String[localJSONArray.length()];
          int i = 0;
          if (i >= localJSONArray.length()) {
            break label117;
          }
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
          continue;
          getUserCloudStorage(arrayOfString, paramRequestEvent);
          return;
        }
      }
      catch (Throwable paramRequestEvent)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest getUserCloudStorage error " + paramRequestEvent.getMessage());
        return;
      }
      String[] arrayOfString = new String[0];
    }
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      QMLog.i("OpenDataCommonJsPlugin", str);
      if ((paramArrayOfString != null) && (paramRequestEvent.jsService != null)) {
        break;
      }
      return;
    }
    paramRequestEvent = new OpenDataCommonJsPlugin.1(this, paramRequestEvent);
    this.mChannelProxy.getUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, paramRequestEvent);
  }
  
  @JsEvent({"getUserInteractiveStorage"})
  public void getUserInteractiveStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getUserInteractiveStorage(arrayOfString, paramRequestEvent);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable);
      paramRequestEvent.fail(localThrowable.getMessage());
      return;
    }
  }
  
  @JsEvent({"modifyFriendInteractiveStorage"})
  public void modifyFriendInteractiveStorage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        String str6 = ((JSONObject)localObject).getString("key");
        int m = ((JSONObject)localObject).getInt("opNum");
        String str7 = ((JSONObject)localObject).getString("operation");
        String str8 = ((JSONObject)localObject).optString("title");
        String str9 = ((JSONObject)localObject).optString("imageUrl");
        String str10 = ((JSONObject)localObject).optString("imageUrlId");
        Boolean localBoolean = Boolean.valueOf(((JSONObject)localObject).optBoolean("quiet"));
        String str1 = "";
        String str2 = "";
        int k = -1;
        String str4 = "";
        String str5 = "";
        localObject = ((JSONObject)localObject).optJSONObject("friendInfo");
        if (localObject != null)
        {
          str1 = ((JSONObject)localObject).getString("openid");
          str2 = ((JSONObject)localObject).getString("nickname");
        }
        String str3 = str4;
        localObject = str5;
        int j = k;
        if (!TextUtils.isEmpty(this.mApkgInfo.mConfigStr))
        {
          JSONArray localJSONArray = new JSONObject(this.mApkgInfo.mConfigStr).optJSONArray("modifyFriendInteractiveStorageTemplates");
          str3 = str4;
          localObject = str5;
          j = k;
          if (localJSONArray != null)
          {
            str3 = str4;
            localObject = str5;
            j = k;
            if (localJSONArray.length() > 0)
            {
              i = 0;
              str3 = str4;
              localObject = str5;
              j = k;
              if (i < localJSONArray.length())
              {
                localObject = localJSONArray.getJSONObject(i);
                if (localObject == null) {
                  break label416;
                }
                str3 = ((JSONObject)localObject).optString("key");
                if ((TextUtils.isEmpty(str3)) || (!str3.equals(str6))) {
                  break label416;
                }
                j = ((JSONObject)localObject).optInt("ratio");
                str3 = ((JSONObject)localObject).optString("action");
                localObject = ((JSONObject)localObject).optString("object");
              }
            }
          }
        }
        if (localBoolean.booleanValue())
        {
          modifyFriendInteractiveStorage(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, paramRequestEvent, str3, (String)localObject, j);
          return;
        }
        showConfirmModificationModel(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, paramRequestEvent, str3, (String)localObject, j);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        paramRequestEvent.fail();
        return;
      }
      label416:
      i += 1;
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
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        removeUserCloudStorage(arrayOfString, paramRequestEvent);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest removeUserCloudStorage error " + paramRequestEvent.getMessage());
      return;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      QMLog.i("OpenDataCommonJsPlugin", str);
      this.mChannelProxy.removeUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataCommonJsPlugin.5(this, paramRequestEvent));
      return;
    }
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
          this.mMiniAppInfo.friendMessageQuery = ("shareMessageToFriendScene=" + i);
          if (this.mMiniAppInfo.isEngineTypeMiniApp())
          {
            this.mMiniAppInfo.friendMessageQuery = (AppBrandUtil.getUrlWithoutParams(PageAction.obtain(this.mMiniAppContext).getPageUrl()) + "?" + this.mMiniAppInfo.friendMessageQuery);
            JSONObject localJSONObject = AppBrandUtil.getQueryJson(PageAction.obtain(this.mMiniAppContext).getPageUrl());
            localJSONObject.put("shareMessageToFriendScene", i);
            StringBuilder localStringBuilder = new StringBuilder(AppBrandUtil.getUrlWithoutParams(PageAction.obtain(this.mMiniAppContext).getPageUrl()));
            Iterator localIterator = localJSONObject.keys();
            i = 0;
            if (localIterator.hasNext())
            {
              String str2 = (String)localIterator.next();
              if (TextUtils.isEmpty(str2)) {
                break label338;
              }
              if (i != 0) {
                break label341;
              }
              localObject = "?";
              localStringBuilder.append((String)localObject).append(str2).append("=").append(localJSONObject.getString(str2));
              i += 1;
              break label338;
            }
            this.mMiniAppInfo.friendMessageQuery = localStringBuilder.toString();
            QMLog.d("OpenDataCommonJsPlugin", "friendMessageQuery : " + this.mMiniAppInfo.friendMessageQuery);
          }
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("success", true);
        paramRequestEvent.ok((JSONObject)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error ", localThrowable);
        paramRequestEvent.fail(localThrowable.getMessage());
        return;
      }
      label338:
      continue;
      label341:
      String str1 = "&";
    }
  }
  
  @JsEvent({"setUserCloudStorage"})
  public void setUserCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("KVDataList");
      HashMap localHashMap = new HashMap();
      if (localJSONArray != null)
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localHashMap.put(localJSONObject.get("key").toString(), localJSONObject.get("value").toString());
          i += 1;
        }
      }
      setUserCloudStorage(localHashMap, paramRequestEvent);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest setUserCloudStorage error " + paramRequestEvent.getMessage());
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      QMLog.i("OpenDataCommonJsPlugin", str);
      this.mChannelProxy.setUserCloudStorage(this.mMiniAppInfo.appId, paramHashMap, new OpenDataCommonJsPlugin.4(this, paramRequestEvent));
      return;
    }
  }
  
  @JsEvent({"shareMessageToFriend"})
  public void shareMessageToFriend(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("friendInfo");
      shareMessageToFriend(localJSONObject2.getString("openid"), localJSONObject2.getString("nickname"), localJSONObject1.optString("title"), localJSONObject1.optString("imageUrl"), localJSONObject1.optString("imageUrlId"), paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable);
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */