package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.CheckJsServiceAction;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class OpenDataCommonJsPlugin
  extends BaseJsPlugin
{
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  private static final String TAG = "OpenDataCommonJsPlugin";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
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
      paramString1 = new InnerShareData.Builder().setShareSource(11).setShareTarget(5).setTitle(this.mMiniAppInfo.name).setSummary(paramString3).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setEntryPath(paramString5).setShareChatModel(paramString2).setWithShareTicket(localShareState.withShareTicket).setRecvOpenId(paramString1).setShareInMiniProcess(localShareState.isShareInMiniProcess);
      if ((!StringUtil.isEmpty(paramString4)) && ((bool2) || (bool1))) {
        break;
      }
      paramString1.setSharePicPath(WnsUtil.defaultShareImg()).build().shareAppMessage();
      QMLog.e("OpenDataCommonJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool2 + "] [isLocalResourceExists=" + bool1 + "] [imageUrl=" + paramString4 + "], use default share image");
      return;
    }
    if ((paramString4.startsWith("http")) || (paramString4.startsWith("https")))
    {
      paramString1.setSharePicPath(paramString4).build().shareAppMessage();
      return;
    }
    paramString1.setSharePicPath(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString4)).setIsLocalPic(true).build().shareAppMessage();
  }
  
  @JsEvent({"canUseComponent"})
  public void canUseComponent(RequestEvent paramRequestEvent)
  {
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
      this.mChannelProxy.getFriendCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataCommonJsPlugin.3(this, paramRequestEvent));
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
    this.mChannelProxy.getGroupCloudStorage(this.mMiniAppInfo.appId, paramString, paramArrayOfString, new OpenDataCommonJsPlugin.2(this, paramRequestEvent));
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
                break label334;
              }
              if (i != 0) {
                break label337;
              }
              localObject = "?";
              localStringBuilder.append((String)localObject).append(str2).append("=").append(localJSONObject.getString(str2));
              i += 1;
              break label334;
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
        paramRequestEvent.fail();
        return;
      }
      label334:
      continue;
      label337:
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
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */