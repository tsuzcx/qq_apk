package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class ShareJsPlugin
  extends BaseJsPlugin
{
  private static final int ACTION_SHEET_DEFAULT_TYPE = 0;
  private static final int ACTION_SHEET_SHARE_PANEL_TYPE = 1;
  public static final String API_OPEN_QZONE_PUBLISH = "openQzonePublish";
  public static final int ERRCODE_INVITE_CANCEL = 1;
  public static final int ERRCODE_INVITE_REQUIRE = 2;
  public static final String ERRMSG_INVITE_CANCEL = "用户取消";
  public static final String ERRMSG_INVITE_REQUIRE = "分享失败";
  public static final int NEED_HIDE = 0;
  public static final int NEED_SHOW = 1;
  public static final String SHARE_ITEM_QQ = "qq";
  public static final String SHARE_ITEM_QZONE = "qzone";
  public static final String SHARE_ITEM_WECHAT_FRIEND = "wechatFriends";
  public static final String SHARE_ITEM_WECHAT_MOMENT = "wechatMoment";
  public static final int SHARE_MENU_STATE_NEED_HIDE = 0;
  public static final int SHARE_MENU_STATE_NEED_SHOW = 1;
  public static final int SHARE_MENU_STATE_UNDEFINED = -1;
  private static final String TAG = "ShareJsPlugin";
  public static final int UNDEFINED = -1;
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  private void doShareAppPictureMessage(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, InnerShareData.Builder paramBuilder, ShareChatModel paramShareChatModel)
  {
    if (paramBoolean1)
    {
      paramBuilder.setSharePicPath(paramString1).setShareChatModel(paramShareChatModel).build().shareAppPictureMessage(this.mMiniAppContext);
      return;
    }
    if ((!StringUtil.isEmpty(paramString1)) && ((paramBoolean1) || (paramBoolean2)))
    {
      if ((!paramBoolean1) && (paramBoolean2)) {
        paramBuilder.setSharePicPath(paramString2).setShareChatModel(paramShareChatModel).setIsLocalPic(true).build().shareAppPictureMessage(this.mMiniAppContext);
      }
    }
    else {
      handleShareAppWithDefaultPic(paramBuilder, paramShareChatModel);
    }
  }
  
  private String fixPath(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (this.mMiniAppContext.isMiniGame()) {
        return "miniGamePath";
      }
      str = this.mApkgInfo.getAppConfigInfo().entryPagePath;
    }
    return str;
  }
  
  private GetScreenshot.Callback getScreenShotCallback(InnerShareData.Builder paramBuilder)
  {
    return new ShareJsPlugin.1(this, paramBuilder);
  }
  
  private ShareChatModel getShareChatModel(int paramInt, JSONObject paramJSONObject, ShareState paramShareState)
  {
    if (paramInt == 5)
    {
      paramJSONObject = paramJSONObject.optString("chatDataHash");
      paramShareState = paramShareState.shareChatModel;
      if ((paramShareState != null) && (paramShareState.getEntryHash().equals(paramJSONObject))) {
        return paramShareState;
      }
      paramShareState = new StringBuilder();
      paramShareState.append("shareAppMessageDirectly fail, entryDataHash is no match:");
      paramShareState.append(paramJSONObject);
      QMLog.e("ShareJsPlugin", paramShareState.toString());
    }
    return null;
  }
  
  private EntryModel getShareQQDirectlyModel(int paramInt, JSONObject paramJSONObject, ShareState paramShareState)
  {
    if (paramInt == 2)
    {
      paramShareState = this.mMiniAppInfo;
      paramJSONObject = paramJSONObject.optString("entryDataHash");
      if ((paramJSONObject != null) && (paramShareState.launchParam.entryModel != null) && (paramJSONObject.equals(paramShareState.launchParam.entryModel.getEntryHash()))) {
        return paramShareState.launchParam.entryModel;
      }
      paramShareState = new StringBuilder();
      paramShareState.append("shareAppMessageDirectly fail, entryDataHash is no match:");
      paramShareState.append(paramJSONObject);
      QMLog.e("ShareJsPlugin", paramShareState.toString());
    }
    return null;
  }
  
  private int getShareType(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return 0;
      if (paramInt == 1) {
        return 1;
      }
    } while (paramInt == 2);
    if (paramInt == 3) {
      return 3;
    }
    if (paramInt == 4) {
      return 4;
    }
    if (paramInt == 5) {
      return 5;
    }
    if (MoreItem.isValidExtendedItemId(paramInt)) {
      return 6;
    }
    return -1;
  }
  
  private int getShareType(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 0;
    }
    if (paramInt == 3) {
      return 3;
    }
    if (paramInt == 4) {
      return 4;
    }
    if (paramInt == 5) {
      return 0;
    }
    if ((paramInt == 6) && ("shareAppMessageDirectlyToFriendList".equals(paramString))) {
      return 0;
    }
    if (MoreItem.isValidExtendedItemId(paramInt)) {
      return 6;
    }
    return -1;
  }
  
  private void handleShareAppWithDefaultPic(InnerShareData.Builder paramBuilder, ShareChatModel paramShareChatModel)
  {
    if (this.mMiniAppContext.isMiniGame())
    {
      if (this.mMiniAppInfo != null)
      {
        paramBuilder.setSharePicPath(this.mMiniAppInfo.iconUrl).setShareChatModel(paramShareChatModel).build().shareAppPictureMessage(this.mMiniAppContext);
        return;
      }
      QMLog.e("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
      return;
    }
    ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
    if (localShareState != null)
    {
      if (localShareState.isGettingScreenShot)
      {
        QMLog.e("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
        return;
      }
      GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.3(this, paramBuilder, paramShareChatModel));
    }
  }
  
  private int handleShareDirectly(RequestEvent paramRequestEvent, int paramInt1, int paramInt2, ShareState paramShareState)
  {
    int i;
    if (!"shareAppMessageDirectly".equals(paramRequestEvent.event))
    {
      i = paramInt1;
      if (!"shareAppMessageDirectlyToFriendList".equals(paramRequestEvent.event)) {}
    }
    else
    {
      i = paramInt2;
      if (paramInt2 == -1)
      {
        paramInt1 = this.mShareProxy.getDefaultShareTarget();
        if (MoreItem.isValidExtendedItemId(paramInt1))
        {
          i = 6;
        }
        else
        {
          paramInt1 = 0;
          i = 0;
        }
      }
      paramShareState.fromShareMenuBtn = i;
      i = paramInt1;
    }
    return i;
  }
  
  private JSONObject handleStagingShareJsonParams(JSONObject paramJSONObject, ShareState paramShareState)
  {
    if (!TextUtils.isEmpty(paramShareState.stagingJsonParams))
    {
      paramJSONObject = new JSONObject(paramShareState.stagingJsonParams);
      paramShareState.stagingJsonParams = null;
    }
    return paramJSONObject;
  }
  
  private boolean isLocalResourceExists(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (new File(paramString2).exists());
  }
  
  private boolean isNetworkImageUrl(String paramString)
  {
    return (URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString));
  }
  
  private boolean isParamEmpty(RequestEvent paramRequestEvent)
  {
    return (paramRequestEvent.jsonParams == null) || ("null".equals(paramRequestEvent.jsonParams)) || ("{}".equals(paramRequestEvent.jsonParams));
  }
  
  private void shareToQQ(String paramString, InnerShareData.Builder paramBuilder)
  {
    MiniAppFileManager localMiniAppFileManager = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
    boolean bool1 = isNetworkImageUrl(paramString);
    boolean bool2 = isLocalResourceExists(paramString, localMiniAppFileManager.getAbsolutePath(paramString));
    if ((!StringUtil.isEmpty(paramString)) && ((bool1) || (bool2)))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
      {
        paramBuilder.setSharePicPath(localMiniAppFileManager.getAbsolutePath(paramString)).setIsLocalPic(true).build().shareAppMessage();
        return;
      }
      paramBuilder.setSharePicPath(paramString).build().shareAppMessage();
      return;
    }
    if (this.mMiniAppContext.isMiniGame())
    {
      paramBuilder.setSharePicPath(WnsUtil.defaultShareImg()).build().shareAppMessage();
      paramBuilder = new StringBuilder();
      paramBuilder.append("shareAppMessageDirectly fail, [isNetworkImageUrl=");
      paramBuilder.append(bool1);
      paramBuilder.append("] [isLocalResourceExists=");
      paramBuilder.append(bool2);
      paramBuilder.append("] [imageUrl=");
      paramBuilder.append(paramString);
      paramBuilder.append("], use default share image");
      QMLog.e("ShareJsPlugin", paramBuilder.toString());
      return;
    }
    if (GetShareState.obtain(this.mMiniAppContext) != null)
    {
      if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot)
      {
        QMLog.e("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
        return;
      }
      GetScreenshot.obtain(this.mMiniAppContext, getScreenShotCallback(paramBuilder));
    }
  }
  
  private void shareToQzone(String paramString, InnerShareData.Builder paramBuilder)
  {
    if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
    {
      paramString = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      if (!StringUtil.isEmpty(paramString))
      {
        paramBuilder.setSharePicPath(paramString).setIsLocalPic(true).build().shareAppMessage();
        return;
      }
      GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.2(this, paramBuilder));
      return;
    }
    paramBuilder.setSharePicPath(paramString).build().shareAppMessage();
  }
  
  private void showDefaultActionSheet(ActionSheet paramActionSheet, JSONObject paramJSONObject, JSONArray paramJSONArray, RequestEvent paramRequestEvent)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      if (paramJSONArray.isNull(i))
      {
        paramRequestEvent.fail();
        return;
      }
      paramActionSheet.addButton(paramJSONArray.optString(i), 9, paramJSONObject.optString("itemColor"));
      i += 1;
    }
    paramActionSheet.addCancelButton("取消");
    paramActionSheet.show();
    paramActionSheet.setOutsideDismissEnableCompat(true);
    paramActionSheet.setOnDismissListener(new ShareJsPlugin.5(this, paramRequestEvent));
    paramActionSheet.setOnCancelListener(new ShareJsPlugin.6(this, paramRequestEvent));
    paramActionSheet.setOnButtonClickListener(new ShareJsPlugin.7(this, paramRequestEvent, paramActionSheet));
  }
  
  private void showSharePanelActionSheet(RequestEvent paramRequestEvent)
  {
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (isParamEmpty(paramRequestEvent))
    {
      try
      {
        new JSONObject().put("errMsg", "param is null!");
        paramRequestEvent.fail();
      }
      catch (JSONException localJSONException1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramRequestEvent.event);
        ((StringBuilder)localObject).append(" error.");
        QMLog.e("ShareJsPlugin", ((StringBuilder)localObject).toString(), localJSONException1);
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramRequestEvent.event);
      localStringBuilder1.append(" return errMsg: param is null!");
      QMLog.e("ShareJsPlugin", localStringBuilder1.toString());
      return;
    }
    for (;;)
    {
      int n;
      int m;
      int k;
      int j;
      int i;
      try
      {
        localObject = (JSONArray)new JSONObject(paramRequestEvent.jsonParams).opt("itemList");
        if (localObject != null) {
          break label612;
        }
        try
        {
          new JSONObject().put("errMsg", "itemList is null!");
          paramRequestEvent.fail();
        }
        catch (JSONException localJSONException2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramRequestEvent.event);
          ((StringBuilder)localObject).append(" error.");
          QMLog.e("ShareJsPlugin", ((StringBuilder)localObject).toString(), localJSONException2);
        }
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramRequestEvent.event);
        localStringBuilder2.append(" return errMsg: itemList is null!");
        QMLog.e("ShareJsPlugin", localStringBuilder2.toString());
        return;
      }
      catch (JSONException localJSONException3)
      {
        StringBuilder localStringBuilder2;
        String str;
        boolean bool1;
        localJSONException3.printStackTrace();
        QMLog.e("ShareJsPlugin", localJSONException3.getMessage(), localJSONException3);
        paramRequestEvent.fail();
        return;
      }
      if (n < ((JSONArray)localObject).length())
      {
        str = ((JSONArray)localObject).getString(n);
        if (str.equalsIgnoreCase("qq"))
        {
          localStringBuilder2.put("tapIndexQQ", Integer.valueOf(n));
          m = 1;
        }
        if (str.equalsIgnoreCase("qzone"))
        {
          localStringBuilder2.put("tapIndexQZONE", Integer.valueOf(n));
          k = 1;
        }
        if (str.equalsIgnoreCase("wechatFriends"))
        {
          localStringBuilder2.put("tapIndexWX", Integer.valueOf(n));
          j = 1;
        }
        if (str.equalsIgnoreCase("wechatMoment"))
        {
          localStringBuilder2.put("tapIndexWXMoments", Integer.valueOf(n));
          i = 1;
        }
        n += 1;
      }
      else
      {
        n = m;
        if (m == -1) {
          n = 0;
        }
        m = k;
        if (k == -1) {
          m = 0;
        }
        k = j;
        if (j == -1) {
          k = 0;
        }
        j = i;
        if (i == -1) {
          j = 0;
        }
        localObject = GetShareState.obtain(this.mMiniAppContext);
        ((ShareState)localObject).launchFrom = 1;
        if (n == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((ShareState)localObject).withShareQQ = bool1;
        if (m == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((ShareState)localObject).withShareQzone = bool1;
        if (k == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((ShareState)localObject).withShareWeChatFriend = bool1;
        bool1 = bool2;
        if (j == 1) {
          bool1 = true;
        }
        ((ShareState)localObject).withShareWeChatMoment = bool1;
        ((ShareState)localObject).withShareOthers = true;
        ((ShareState)localObject).tapIndexMap = localStringBuilder2;
        ((ShareState)localObject).shareEvent = paramRequestEvent.event;
        ((ShareState)localObject).shareCallbackId = paramRequestEvent.callbackId;
        ((ShareState)localObject).requestEvent = paramRequestEvent;
        this.mShareProxy.showSharePanel(this.mMiniAppContext);
        return;
        label612:
        boolean bool2 = false;
        n = 0;
        m = -1;
        k = -1;
        j = -1;
        i = -1;
      }
    }
  }
  
  @JsEvent({"hideShareMenu"})
  public void hideShareMenu(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject = (JSONArray)new JSONObject(paramRequestEvent.jsonParams).opt("hideShareItems");
        if (localObject == null)
        {
          int i1 = 0;
          int i2 = 0;
          int i3 = 0;
          int i4 = 0;
          continue;
          i1 = i;
          i2 = j;
          i3 = k;
          i4 = m;
          if (n < ((JSONArray)localObject).length())
          {
            String str = ((JSONArray)localObject).getString(n);
            if (str.equalsIgnoreCase("qq")) {
              i = 0;
            }
            if (str.equalsIgnoreCase("qzone")) {
              j = 0;
            }
            if (str.equalsIgnoreCase("wechatFriends")) {
              k = 0;
            }
            if (!str.equalsIgnoreCase("wechatMoment")) {
              break label215;
            }
            m = 0;
            break label215;
          }
          localObject = GetShareState.obtain(this.mMiniAppContext);
          if (i1 == 0) {
            ((ShareState)localObject).withShareQQ = false;
          }
          if (i2 == 0) {
            ((ShareState)localObject).withShareQzone = false;
          }
          if (i3 == 0) {
            ((ShareState)localObject).withShareWeChatFriend = false;
          }
          if (i4 == 0) {
            ((ShareState)localObject).withShareWeChatMoment = false;
          }
          ((ShareState)localObject).withShareOthers = false;
          paramRequestEvent.ok();
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return;
      }
      int n = 0;
      int i = -1;
      int j = -1;
      int k = -1;
      int m = -1;
      continue;
      label215:
      n += 1;
    }
  }
  
  @JsEvent({"openQzonePublish"})
  public void openQzonePublish(RequestEvent paramRequestEvent)
  {
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openQzonePublish(this.mMiniAppContext, this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.jsonParams, this.mMiniAppInfo))
    {
      paramRequestEvent = this.mMiniAppContext.getAttachedActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("暂不支持在");
      localStringBuilder.append(QUAUtil.getApplicationName(this.mContext));
      localStringBuilder.append("中发表说说");
      MiniToast.makeText(paramRequestEvent, 0, localStringBuilder.toString(), 1);
    }
  }
  
  @JsEvent({"shareAppMessage", "shareAppMessageDirectlyToFriendList"})
  public void shareAppMessage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        boolean bool = "shareAppMessageDirectly".equals(paramRequestEvent.event);
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        i = ((JSONObject)localObject1).optInt("shareTarget", -1);
        int j = getShareType(i, paramRequestEvent.event);
        ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
        EntryModel localEntryModel = getShareQQDirectlyModel(i, (JSONObject)localObject1, localShareState);
        ShareChatModel localShareChatModel = getShareChatModel(i, (JSONObject)localObject1, localShareState);
        String str1 = ((JSONObject)localObject1).optString("shareTemplateId");
        String str2 = ((JSONObject)localObject1).optString("shareTemplateData");
        j = handleShareDirectly(paramRequestEvent, i, j, localShareState);
        localShareState.shareEvent = paramRequestEvent.event;
        localShareState.shareCallbackId = paramRequestEvent.callbackId;
        localShareState.requestEvent = paramRequestEvent;
        paramRequestEvent = ((JSONObject)localObject1).optString("shareActionName");
        if (!TextUtils.isEmpty(paramRequestEvent)) {
          localShareState.shareEvent = paramRequestEvent;
        }
        paramRequestEvent = new StringBuilder();
        paramRequestEvent.append("shareAppMessage param: ");
        paramRequestEvent.append(((JSONObject)localObject1).toString());
        QMLog.d("ShareJsPlugin", paramRequestEvent.toString());
        Object localObject2 = handleStagingShareJsonParams((JSONObject)localObject1, localShareState);
        localObject1 = ((JSONObject)localObject2).optString("path");
        paramRequestEvent = (RequestEvent)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramRequestEvent = ((JSONObject)localObject2).optString("query");
        }
        String str3 = ((JSONObject)localObject2).optString("title");
        localObject1 = ((JSONObject)localObject2).optString("imageUrl");
        localObject2 = ((JSONObject)localObject2).optString("generalWebpageUrl");
        paramRequestEvent = fixPath(paramRequestEvent);
        InnerShareData.Builder localBuilder = new InnerShareData.Builder();
        if (bool)
        {
          i = 11;
          paramRequestEvent = localBuilder.setShareSource(i).setShareTarget(j).setTitle(this.mMiniAppInfo.name).setSummary(str3).setEntryPath(paramRequestEvent).setWebUrl((String)localObject2).setTemplateId(str1).setTemplateData(str2).setEntryModel(localEntryModel).setShareChatModel(localShareChatModel).setWithShareTicket(localShareState.withShareTicket).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setShareInMiniProcess(localShareState.isShareInMiniProcess);
          if (localShareState.fromShareMenuBtn == 1)
          {
            shareToQzone((String)localObject1, paramRequestEvent);
            return;
          }
          if ((localShareState.fromShareMenuBtn != 3) && (localShareState.fromShareMenuBtn != 4))
          {
            shareToQQ((String)localObject1, paramRequestEvent);
            return;
          }
          paramRequestEvent.setSharePicPath(this.mMiniAppInfo.iconUrl).build().shareAppMessage();
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("ShareJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
        paramRequestEvent.printStackTrace();
        return;
      }
      int i = 12;
    }
  }
  
  @JsEvent({"shareAppMessageDirectly"})
  public void shareAppMessageDirectly(RequestEvent paramRequestEvent)
  {
    if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp()))
    {
      GetShareState.obtain(this.mMiniAppContext).stagingJsonParams = paramRequestEvent.jsonParams;
      this.mShareProxy.showSharePanel(this.mMiniAppContext);
      return;
    }
    shareAppMessage(paramRequestEvent);
  }
  
  @JsEvent({"shareAppPictureMessage"})
  public void shareAppPictureMessage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        j = localJSONObject.optInt("shareTarget", -1);
        int k = getShareType(j);
        ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
        i = j;
        if ("shareAppPictureMessageDirectly".equals(paramRequestEvent.event))
        {
          i = j;
          j = k;
          if (k == -1)
          {
            i = this.mShareProxy.getDefaultShareTarget();
            if (!MoreItem.isValidExtendedItemId(i)) {
              break label276;
            }
            j = 6;
          }
          localShareState.fromShareMenuBtn = j;
        }
        else
        {
          j = localShareState.fromShareMenuBtn;
          localShareState.shareEvent = paramRequestEvent.event;
          localShareState.shareCallbackId = paramRequestEvent.callbackId;
          localShareState.requestEvent = paramRequestEvent;
          paramRequestEvent = localJSONObject.optString("title");
          String str1 = localJSONObject.optString("imageUrl");
          boolean bool = isNetworkImageUrl(str1);
          String str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str1);
          doShareAppPictureMessage(str1, bool, str2, isLocalResourceExists(str1, str2), new InnerShareData.Builder().setShareSource(11).setShareTarget(i).setTitle(this.mMiniAppInfo.name).setSummary(paramRequestEvent).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setShareInMiniProcess(localShareState.isShareInMiniProcess), getShareChatModel(i, localJSONObject, localShareState));
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return;
      }
      label276:
      int i = 0;
      int j = 0;
    }
  }
  
  @JsEvent({"shareAppPictureMessageDirectly"})
  public void shareAppPictureMessageDirectly(RequestEvent paramRequestEvent)
  {
    if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp()))
    {
      this.mShareProxy.showSharePanel(this.mMiniAppContext);
      return;
    }
    shareAppPictureMessage(paramRequestEvent);
  }
  
  @JsEvent({"shareInvite"})
  public void shareInvite(RequestEvent paramRequestEvent)
  {
    ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
    localShareState.shareEvent = paramRequestEvent.event;
    localShareState.shareCallbackId = paramRequestEvent.callbackId;
    localShareState.requestEvent = paramRequestEvent;
    new InnerShareData.Builder().setShareSource(11).setShareTarget(7).setTemplateId("657667B4D8C04B3F84E4AAA3D046A903").setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setEvent(paramRequestEvent.event).setSubScene(4023).setCallbackId(paramRequestEvent.callbackId).build().shareAppMessage();
  }
  
  @JsEvent({"showActionSheet"})
  public void showActionSheet(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ShareJsPlugin.4(this, paramRequestEvent));
  }
  
  /* Error */
  @JsEvent({"showShareMenu", "showShareMenuWithShareTicket"})
  public void showShareMenu(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 431	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:isParamEmpty	(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)Z
    //   5: istore 13
    //   7: iconst_0
    //   8: istore 15
    //   10: iload 13
    //   12: ifeq +24 -> 36
    //   15: iconst_0
    //   16: istore 13
    //   18: iconst_1
    //   19: istore 4
    //   21: iconst_1
    //   22: istore 7
    //   24: iconst_1
    //   25: istore 8
    //   27: iconst_1
    //   28: istore_3
    //   29: iload 13
    //   31: istore 14
    //   33: goto +380 -> 413
    //   36: new 171	org/json/JSONObject
    //   39: dup
    //   40: aload_1
    //   41: getfield 313	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   44: invokespecial 291	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   47: astore 16
    //   49: aload 16
    //   51: ldc_w 700
    //   54: iconst_0
    //   55: invokevirtual 704	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   58: istore 13
    //   60: aload 16
    //   62: ldc_w 706
    //   65: invokevirtual 453	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   68: checkcast 367	org/json/JSONArray
    //   71: astore 16
    //   73: aload 16
    //   75: ifnonnull +6 -> 81
    //   78: goto -60 -> 18
    //   81: iconst_0
    //   82: istore 12
    //   84: iconst_m1
    //   85: istore 5
    //   87: iconst_m1
    //   88: istore 4
    //   90: iconst_m1
    //   91: istore_3
    //   92: iconst_m1
    //   93: istore_2
    //   94: iload 5
    //   96: istore 11
    //   98: iload 4
    //   100: istore 10
    //   102: iload_3
    //   103: istore 9
    //   105: iload 12
    //   107: aload 16
    //   109: invokevirtual 370	org/json/JSONArray:length	()I
    //   112: if_icmpge +154 -> 266
    //   115: iload 5
    //   117: istore 11
    //   119: iload 4
    //   121: istore 10
    //   123: iload_3
    //   124: istore 9
    //   126: aload 16
    //   128: iload 12
    //   130: invokevirtual 460	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   133: astore 17
    //   135: iload 5
    //   137: istore 6
    //   139: iload 5
    //   141: istore 11
    //   143: iload 4
    //   145: istore 10
    //   147: iload_3
    //   148: istore 9
    //   150: aload 17
    //   152: ldc 28
    //   154: invokevirtual 463	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   157: ifeq +6 -> 163
    //   160: iconst_1
    //   161: istore 6
    //   163: iload 4
    //   165: istore 7
    //   167: iload 6
    //   169: istore 11
    //   171: iload 4
    //   173: istore 10
    //   175: iload_3
    //   176: istore 9
    //   178: aload 17
    //   180: ldc 31
    //   182: invokevirtual 463	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   185: ifeq +6 -> 191
    //   188: iconst_1
    //   189: istore 7
    //   191: iload_3
    //   192: istore 8
    //   194: iload 6
    //   196: istore 11
    //   198: iload 7
    //   200: istore 10
    //   202: iload_3
    //   203: istore 9
    //   205: aload 17
    //   207: ldc 34
    //   209: invokevirtual 463	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   212: ifeq +6 -> 218
    //   215: iconst_1
    //   216: istore 8
    //   218: iload 6
    //   220: istore 11
    //   222: iload 7
    //   224: istore 10
    //   226: iload 8
    //   228: istore 9
    //   230: aload 17
    //   232: ldc 37
    //   234: invokevirtual 463	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   237: istore 14
    //   239: iload 14
    //   241: ifeq +5 -> 246
    //   244: iconst_1
    //   245: istore_2
    //   246: iload 12
    //   248: iconst_1
    //   249: iadd
    //   250: istore 12
    //   252: iload 6
    //   254: istore 5
    //   256: iload 7
    //   258: istore 4
    //   260: iload 8
    //   262: istore_3
    //   263: goto -169 -> 94
    //   266: iload 5
    //   268: istore 6
    //   270: iload 5
    //   272: iconst_m1
    //   273: if_icmpne +6 -> 279
    //   276: iconst_0
    //   277: istore 6
    //   279: iload 4
    //   281: istore 5
    //   283: iload 4
    //   285: iconst_m1
    //   286: if_icmpne +6 -> 292
    //   289: iconst_0
    //   290: istore 5
    //   292: iload_3
    //   293: istore 9
    //   295: iload_3
    //   296: iconst_m1
    //   297: if_icmpne +6 -> 303
    //   300: iconst_0
    //   301: istore 9
    //   303: iload 13
    //   305: istore 14
    //   307: iload 6
    //   309: istore 4
    //   311: iload 5
    //   313: istore 7
    //   315: iload 9
    //   317: istore 8
    //   319: iload_2
    //   320: istore_3
    //   321: iload_2
    //   322: iconst_m1
    //   323: if_icmpne +90 -> 413
    //   326: iconst_0
    //   327: istore_3
    //   328: iload 13
    //   330: istore 14
    //   332: iload 6
    //   334: istore 4
    //   336: iload 5
    //   338: istore 7
    //   340: iload 9
    //   342: istore 8
    //   344: goto +69 -> 413
    //   347: astore 16
    //   349: iload 11
    //   351: istore 4
    //   353: iload 10
    //   355: istore 7
    //   357: iload 9
    //   359: istore 8
    //   361: goto +24 -> 385
    //   364: astore 16
    //   366: goto +8 -> 374
    //   369: astore 16
    //   371: iconst_0
    //   372: istore 13
    //   374: iconst_m1
    //   375: istore 4
    //   377: iconst_m1
    //   378: istore 7
    //   380: iconst_m1
    //   381: istore 8
    //   383: iconst_m1
    //   384: istore_2
    //   385: aload 16
    //   387: invokevirtual 521	org/json/JSONException:printStackTrace	()V
    //   390: ldc 44
    //   392: aload 16
    //   394: invokevirtual 524	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   397: aload 16
    //   399: invokestatic 445	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   402: aload_1
    //   403: invokevirtual 376	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   406: pop
    //   407: iload_2
    //   408: istore_3
    //   409: iload 13
    //   411: istore 14
    //   413: aload_0
    //   414: getfield 81	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   417: invokestatic 251	com/tencent/qqmini/sdk/action/GetShareState:obtain	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)Lcom/tencent/qqmini/sdk/launcher/model/ShareState;
    //   420: astore 16
    //   422: iload 4
    //   424: iconst_1
    //   425: if_icmpne +9 -> 434
    //   428: iconst_1
    //   429: istore 13
    //   431: goto +6 -> 437
    //   434: iconst_0
    //   435: istore 13
    //   437: aload 16
    //   439: iload 13
    //   441: putfield 486	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQQ	Z
    //   444: iload 7
    //   446: iconst_1
    //   447: if_icmpne +9 -> 456
    //   450: iconst_1
    //   451: istore 13
    //   453: goto +6 -> 459
    //   456: iconst_0
    //   457: istore 13
    //   459: aload 16
    //   461: iload 13
    //   463: putfield 489	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQzone	Z
    //   466: iload 8
    //   468: iconst_1
    //   469: if_icmpne +9 -> 478
    //   472: iconst_1
    //   473: istore 13
    //   475: goto +6 -> 481
    //   478: iconst_0
    //   479: istore 13
    //   481: aload 16
    //   483: iload 13
    //   485: putfield 492	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatFriend	Z
    //   488: iload 15
    //   490: istore 13
    //   492: iload_3
    //   493: iconst_1
    //   494: if_icmpne +6 -> 500
    //   497: iconst_1
    //   498: istore 13
    //   500: aload 16
    //   502: iload 13
    //   504: putfield 495	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatMoment	Z
    //   507: aload 16
    //   509: iconst_1
    //   510: putfield 498	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareOthers	Z
    //   513: aload 16
    //   515: iload 14
    //   517: putfield 638	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareTicket	Z
    //   520: aload_1
    //   521: invokevirtual 532	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   524: pop
    //   525: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	this	ShareJsPlugin
    //   0	526	1	paramRequestEvent	RequestEvent
    //   93	315	2	i	int
    //   28	467	3	j	int
    //   19	407	4	k	int
    //   85	252	5	m	int
    //   137	196	6	n	int
    //   22	426	7	i1	int
    //   25	445	8	i2	int
    //   103	255	9	i3	int
    //   100	254	10	i4	int
    //   96	254	11	i5	int
    //   82	169	12	i6	int
    //   5	498	13	bool1	boolean
    //   31	485	14	bool2	boolean
    //   8	481	15	bool3	boolean
    //   47	80	16	localObject	Object
    //   347	1	16	localJSONException1	JSONException
    //   364	1	16	localJSONException2	JSONException
    //   369	29	16	localJSONException3	JSONException
    //   420	94	16	localShareState	ShareState
    //   133	98	17	str	String
    // Exception table:
    //   from	to	target	type
    //   105	115	347	org/json/JSONException
    //   126	135	347	org/json/JSONException
    //   150	160	347	org/json/JSONException
    //   178	188	347	org/json/JSONException
    //   205	215	347	org/json/JSONException
    //   230	239	347	org/json/JSONException
    //   60	73	364	org/json/JSONException
    //   36	60	369	org/json/JSONException
  }
  
  @JsEvent({"updateShareMenuShareTicket"})
  public void updateShareMenuShareTicket(RequestEvent paramRequestEvent)
  {
    try
    {
      boolean bool = new JSONObject(paramRequestEvent.jsonParams).optBoolean("withShareTicket", false);
      GetShareState.obtain(this.mMiniAppContext).withShareTicket = bool;
      paramRequestEvent.ok();
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("ShareJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      paramRequestEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */