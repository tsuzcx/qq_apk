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
    if (paramBoolean1) {
      paramBuilder.setSharePicPath(paramString1).setShareChatModel(paramShareChatModel).build().shareAppPictureMessage(this.mMiniAppContext);
    }
    do
    {
      return;
      if ((StringUtil.isEmpty(paramString1)) || ((!paramBoolean1) && (!paramBoolean2)))
      {
        handleShareAppWithDefaultPic(paramBuilder, paramShareChatModel);
        return;
      }
    } while ((paramBoolean1) || (!paramBoolean2));
    paramBuilder.setSharePicPath(paramString2).setShareChatModel(paramShareChatModel).setIsLocalPic(true).build().shareAppPictureMessage(this.mMiniAppContext);
  }
  
  private String fixPath(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (this.mMiniAppContext.isMiniGame()) {
        str = "miniGamePath";
      }
    }
    else {
      return str;
    }
    return this.mApkgInfo.getAppConfigInfo().entryPagePath;
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
      QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + paramJSONObject);
    }
    return null;
  }
  
  private EntryModel getShareQQDirectlyModel(int paramInt, JSONObject paramJSONObject, ShareState paramShareState)
  {
    paramShareState = null;
    if (paramInt == 2)
    {
      paramShareState = this.mMiniAppInfo;
      paramJSONObject = paramJSONObject.optString("entryDataHash");
      if ((paramJSONObject != null) && (paramShareState.launchParam.entryModel != null) && (paramJSONObject.equals(paramShareState.launchParam.entryModel.getEntryHash()))) {
        paramShareState = paramShareState.launchParam.entryModel;
      }
    }
    else
    {
      return paramShareState;
    }
    QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + paramJSONObject);
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
    if (paramInt == 0) {}
    do
    {
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
    } while ((paramInt == 5) || ((paramInt == 6) && ("shareAppMessageDirectlyToFriendList".equals(paramString))));
    if (MoreItem.isValidExtendedItemId(paramInt)) {
      return 6;
    }
    return -1;
  }
  
  private void handleShareAppWithDefaultPic(InnerShareData.Builder paramBuilder, ShareChatModel paramShareChatModel)
  {
    if (this.mMiniAppContext.isMiniGame()) {
      if (this.mMiniAppInfo != null) {
        paramBuilder.setSharePicPath(this.mMiniAppInfo.iconUrl).setShareChatModel(paramShareChatModel).build().shareAppPictureMessage(this.mMiniAppContext);
      }
    }
    ShareState localShareState;
    do
    {
      return;
      QMLog.e("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
      return;
      localShareState = GetShareState.obtain(this.mMiniAppContext);
    } while (localShareState == null);
    if (localShareState.isGettingScreenShot)
    {
      QMLog.e("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
      return;
    }
    GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.3(this, paramBuilder, paramShareChatModel));
  }
  
  private int handleShareDirectly(RequestEvent paramRequestEvent, int paramInt1, int paramInt2, ShareState paramShareState)
  {
    int j = 0;
    int i;
    if (!"shareAppMessageDirectly".equals(paramRequestEvent.event))
    {
      i = paramInt1;
      if (!"shareAppMessageDirectlyToFriendList".equals(paramRequestEvent.event)) {}
    }
    else
    {
      if (paramInt2 != -1) {
        break label76;
      }
      paramInt1 = this.mShareProxy.getDefaultShareTarget();
      if (!MoreItem.isValidExtendedItemId(paramInt1)) {
        break label68;
      }
      paramInt2 = 6;
    }
    label68:
    label76:
    for (;;)
    {
      paramShareState.fromShareMenuBtn = paramInt2;
      i = paramInt1;
      return i;
      paramInt2 = 0;
      paramInt1 = j;
    }
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
    if ((StringUtil.isEmpty(paramString)) || ((!bool1) && (!bool2)))
    {
      if (this.mMiniAppContext.isMiniGame())
      {
        paramBuilder.setSharePicPath(WnsUtil.defaultShareImg()).build().shareAppMessage();
        QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + paramString + "], use default share image");
      }
      while (GetShareState.obtain(this.mMiniAppContext) == null) {
        return;
      }
      if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot)
      {
        QMLog.e("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
        return;
      }
      GetScreenshot.obtain(this.mMiniAppContext, getScreenShotCallback(paramBuilder));
      return;
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
    {
      paramBuilder.setSharePicPath(paramString).build().shareAppMessage();
      return;
    }
    paramBuilder.setSharePicPath(localMiniAppFileManager.getAbsolutePath(paramString)).setIsLocalPic(true).build().shareAppMessage();
  }
  
  private void shareToQzone(String paramString, InnerShareData.Builder paramBuilder)
  {
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
    {
      paramBuilder.setSharePicPath(paramString).build().shareAppMessage();
      return;
    }
    paramString = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
    if (!StringUtil.isEmpty(paramString))
    {
      paramBuilder.setSharePicPath(paramString).setIsLocalPic(true).build().shareAppMessage();
      return;
    }
    GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.2(this, paramBuilder));
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
  
  /* Error */
  private void showSharePanelActionSheet(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: new 428	java/util/HashMap
    //   6: dup
    //   7: invokespecial 429	java/util/HashMap:<init>	()V
    //   10: astore 9
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 431	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:isParamEmpty	(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)Z
    //   17: ifeq +89 -> 106
    //   20: new 171	org/json/JSONObject
    //   23: dup
    //   24: invokespecial 432	org/json/JSONObject:<init>	()V
    //   27: ldc_w 434
    //   30: ldc_w 436
    //   33: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   36: pop
    //   37: aload_1
    //   38: invokevirtual 376	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   41: pop
    //   42: ldc 44
    //   44: new 194	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   51: aload_1
    //   52: getfield 276	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   55: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 442
    //   61: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 210	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: return
    //   71: astore 9
    //   73: ldc 44
    //   75: new 194	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   82: aload_1
    //   83: getfield 276	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   86: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 444
    //   92: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload 9
    //   100: invokestatic 447	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: goto -61 -> 42
    //   106: new 171	org/json/JSONObject
    //   109: dup
    //   110: aload_1
    //   111: getfield 313	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   114: invokespecial 291	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: ldc_w 449
    //   120: invokevirtual 453	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   123: checkcast 367	org/json/JSONArray
    //   126: astore 10
    //   128: aload 10
    //   130: ifnonnull +444 -> 574
    //   133: new 171	org/json/JSONObject
    //   136: dup
    //   137: invokespecial 432	org/json/JSONObject:<init>	()V
    //   140: ldc_w 434
    //   143: ldc_w 455
    //   146: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: aload_1
    //   151: invokevirtual 376	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   154: pop
    //   155: ldc 44
    //   157: new 194	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   164: aload_1
    //   165: getfield 276	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   168: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 457
    //   174: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 210	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: return
    //   184: astore 9
    //   186: aload 9
    //   188: invokevirtual 460	org/json/JSONException:printStackTrace	()V
    //   191: ldc 44
    //   193: aload 9
    //   195: invokevirtual 463	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   198: aload 9
    //   200: invokestatic 447	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload_1
    //   204: invokevirtual 376	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   207: pop
    //   208: return
    //   209: astore 9
    //   211: ldc 44
    //   213: new 194	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   220: aload_1
    //   221: getfield 276	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   224: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 444
    //   230: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload 9
    //   238: invokestatic 447	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: goto -86 -> 155
    //   244: iload 6
    //   246: aload 10
    //   248: invokevirtual 370	org/json/JSONArray:length	()I
    //   251: if_icmpge +127 -> 378
    //   254: aload 10
    //   256: iload 6
    //   258: invokevirtual 466	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   261: astore 11
    //   263: aload 11
    //   265: ldc 28
    //   267: invokevirtual 469	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   270: ifeq +20 -> 290
    //   273: aload 9
    //   275: ldc_w 471
    //   278: iload 6
    //   280: invokestatic 477	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: invokevirtual 480	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: iconst_1
    //   288: istore 5
    //   290: aload 11
    //   292: ldc 31
    //   294: invokevirtual 469	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   297: ifeq +20 -> 317
    //   300: aload 9
    //   302: ldc_w 482
    //   305: iload 6
    //   307: invokestatic 477	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: invokevirtual 480	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   313: pop
    //   314: iconst_1
    //   315: istore 4
    //   317: aload 11
    //   319: ldc 34
    //   321: invokevirtual 469	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   324: ifeq +19 -> 343
    //   327: aload 9
    //   329: ldc_w 484
    //   332: iload 6
    //   334: invokestatic 477	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: invokevirtual 480	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   340: pop
    //   341: iconst_1
    //   342: istore_3
    //   343: aload 11
    //   345: ldc 37
    //   347: invokevirtual 469	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   350: ifeq +19 -> 369
    //   353: aload 9
    //   355: ldc_w 486
    //   358: iload 6
    //   360: invokestatic 477	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: invokevirtual 480	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: iconst_1
    //   368: istore_2
    //   369: iload 6
    //   371: iconst_1
    //   372: iadd
    //   373: istore 6
    //   375: goto -131 -> 244
    //   378: iload 5
    //   380: iconst_m1
    //   381: if_icmpne +190 -> 571
    //   384: iconst_0
    //   385: istore 5
    //   387: iload 4
    //   389: istore 6
    //   391: iload 4
    //   393: iconst_m1
    //   394: if_icmpne +6 -> 400
    //   397: iconst_0
    //   398: istore 6
    //   400: iload_3
    //   401: istore 4
    //   403: iload_3
    //   404: iconst_m1
    //   405: if_icmpne +6 -> 411
    //   408: iconst_0
    //   409: istore 4
    //   411: iload_2
    //   412: istore_3
    //   413: iload_2
    //   414: iconst_m1
    //   415: if_icmpne +5 -> 420
    //   418: iconst_0
    //   419: istore_3
    //   420: aload_0
    //   421: getfield 81	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   424: invokestatic 251	com/tencent/qqmini/sdk/action/GetShareState:obtain	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)Lcom/tencent/qqmini/sdk/launcher/model/ShareState;
    //   427: astore 10
    //   429: aload 10
    //   431: iconst_1
    //   432: putfield 489	com/tencent/qqmini/sdk/launcher/model/ShareState:launchFrom	I
    //   435: iload 5
    //   437: iconst_1
    //   438: if_icmpne +115 -> 553
    //   441: iconst_1
    //   442: istore 7
    //   444: aload 10
    //   446: iload 7
    //   448: putfield 492	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQQ	Z
    //   451: iload 6
    //   453: iconst_1
    //   454: if_icmpne +105 -> 559
    //   457: iconst_1
    //   458: istore 7
    //   460: aload 10
    //   462: iload 7
    //   464: putfield 495	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQzone	Z
    //   467: iload 4
    //   469: iconst_1
    //   470: if_icmpne +95 -> 565
    //   473: iconst_1
    //   474: istore 7
    //   476: aload 10
    //   478: iload 7
    //   480: putfield 498	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatFriend	Z
    //   483: iload 8
    //   485: istore 7
    //   487: iload_3
    //   488: iconst_1
    //   489: if_icmpne +6 -> 495
    //   492: iconst_1
    //   493: istore 7
    //   495: aload 10
    //   497: iload 7
    //   499: putfield 501	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatMoment	Z
    //   502: aload 10
    //   504: iconst_1
    //   505: putfield 504	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareOthers	Z
    //   508: aload 10
    //   510: aload 9
    //   512: putfield 508	com/tencent/qqmini/sdk/launcher/model/ShareState:tapIndexMap	Ljava/util/HashMap;
    //   515: aload 10
    //   517: aload_1
    //   518: getfield 276	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   521: putfield 511	com/tencent/qqmini/sdk/launcher/model/ShareState:shareEvent	Ljava/lang/String;
    //   524: aload 10
    //   526: aload_1
    //   527: getfield 514	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:callbackId	I
    //   530: putfield 517	com/tencent/qqmini/sdk/launcher/model/ShareState:shareCallbackId	I
    //   533: aload 10
    //   535: aload_1
    //   536: putfield 521	com/tencent/qqmini/sdk/launcher/model/ShareState:requestEvent	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   539: aload_0
    //   540: getfield 61	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:mShareProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/ShareProxy;
    //   543: aload_0
    //   544: getfield 81	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   547: invokeinterface 524 2 0
    //   552: return
    //   553: iconst_0
    //   554: istore 7
    //   556: goto -112 -> 444
    //   559: iconst_0
    //   560: istore 7
    //   562: goto -102 -> 460
    //   565: iconst_0
    //   566: istore 7
    //   568: goto -92 -> 476
    //   571: goto -184 -> 387
    //   574: iconst_0
    //   575: istore 6
    //   577: iconst_m1
    //   578: istore_2
    //   579: iconst_m1
    //   580: istore_3
    //   581: iconst_m1
    //   582: istore 4
    //   584: iconst_m1
    //   585: istore 5
    //   587: goto -343 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	ShareJsPlugin
    //   0	590	1	paramRequestEvent	RequestEvent
    //   368	211	2	i	int
    //   342	239	3	j	int
    //   315	268	4	k	int
    //   288	298	5	m	int
    //   244	332	6	n	int
    //   442	125	7	bool1	boolean
    //   1	483	8	bool2	boolean
    //   10	1	9	localHashMap	java.util.HashMap
    //   71	28	9	localJSONException1	JSONException
    //   184	15	9	localJSONException2	JSONException
    //   209	302	9	localJSONException3	JSONException
    //   126	408	10	localObject	Object
    //   261	83	11	str	String
    // Exception table:
    //   from	to	target	type
    //   20	42	71	org/json/JSONException
    //   106	128	184	org/json/JSONException
    //   155	183	184	org/json/JSONException
    //   211	241	184	org/json/JSONException
    //   244	263	184	org/json/JSONException
    //   263	287	184	org/json/JSONException
    //   290	314	184	org/json/JSONException
    //   317	341	184	org/json/JSONException
    //   343	367	184	org/json/JSONException
    //   133	155	209	org/json/JSONException
  }
  
  @JsEvent({"hideShareMenu"})
  public void hideShareMenu(RequestEvent paramRequestEvent)
  {
    int i = -1;
    int k = 0;
    for (;;)
    {
      int j;
      int n;
      int m;
      try
      {
        localObject = (JSONArray)new JSONObject(paramRequestEvent.jsonParams).opt("hideShareItems");
        if (localObject != null) {
          break label201;
        }
        j = 0;
        n = 0;
        m = 0;
        i = k;
        k = n;
        localObject = GetShareState.obtain(this.mMiniAppContext);
        if (m == 0) {
          ((ShareState)localObject).withShareQQ = false;
        }
        if (k == 0) {
          ((ShareState)localObject).withShareQzone = false;
        }
        if (j == 0) {
          ((ShareState)localObject).withShareWeChatFriend = false;
        }
        if (i == 0) {
          ((ShareState)localObject).withShareWeChatMoment = false;
        }
        ((ShareState)localObject).withShareOthers = false;
        paramRequestEvent.ok();
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        Object localObject;
        String str;
        boolean bool;
        paramRequestEvent.printStackTrace();
        return;
      }
      if (n < ((JSONArray)localObject).length())
      {
        str = ((JSONArray)localObject).getString(n);
        if (str.equalsIgnoreCase("qq")) {
          m = 0;
        }
        if (str.equalsIgnoreCase("qzone")) {
          k = 0;
        }
        if (str.equalsIgnoreCase("wechatFriends")) {
          j = 0;
        }
        bool = str.equalsIgnoreCase("wechatMoment");
        if (bool) {
          i = 0;
        }
        n += 1;
      }
      else
      {
        continue;
        label201:
        n = 0;
        j = -1;
        k = -1;
        m = -1;
      }
    }
  }
  
  @JsEvent({"openQzonePublish"})
  public void openQzonePublish(RequestEvent paramRequestEvent)
  {
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openQzonePublish(this.mMiniAppContext, this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.jsonParams, this.mMiniAppInfo)) {
      MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中发表说说", 1);
    }
  }
  
  @JsEvent({"shareAppMessage", "shareAppMessageDirectlyToFriendList"})
  public void shareAppMessage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        if (!"shareAppMessageDirectly".equals(paramRequestEvent.event)) {
          break label445;
        }
        i = 1;
        localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        int j = ((JSONObject)localObject1).optInt("shareTarget", -1);
        int k = getShareType(j, paramRequestEvent.event);
        ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
        EntryModel localEntryModel = getShareQQDirectlyModel(j, (JSONObject)localObject1, localShareState);
        ShareChatModel localShareChatModel = getShareChatModel(j, (JSONObject)localObject1, localShareState);
        String str1 = ((JSONObject)localObject1).optString("shareTemplateId");
        String str2 = ((JSONObject)localObject1).optString("shareTemplateData");
        j = handleShareDirectly(paramRequestEvent, j, k, localShareState);
        localShareState.shareEvent = paramRequestEvent.event;
        localShareState.shareCallbackId = paramRequestEvent.callbackId;
        localShareState.requestEvent = paramRequestEvent;
        paramRequestEvent = ((JSONObject)localObject1).optString("shareActionName");
        if (!TextUtils.isEmpty(paramRequestEvent)) {
          localShareState.shareEvent = paramRequestEvent;
        }
        QMLog.d("ShareJsPlugin", "shareAppMessage param: " + ((JSONObject)localObject1).toString());
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
        if (i == 0) {
          break label450;
        }
        i = 11;
        paramRequestEvent = localBuilder.setShareSource(i).setShareTarget(j).setTitle(this.mMiniAppInfo.name).setSummary(str3).setEntryPath(paramRequestEvent).setWebUrl((String)localObject2).setTemplateId(str1).setTemplateData(str2).setEntryModel(localEntryModel).setShareChatModel(localShareChatModel).setWithShareTicket(localShareState.withShareTicket).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setShareInMiniProcess(localShareState.isShareInMiniProcess);
        if (localShareState.fromShareMenuBtn == 1)
        {
          shareToQzone((String)localObject1, paramRequestEvent);
          return;
        }
        if ((localShareState.fromShareMenuBtn == 3) || (localShareState.fromShareMenuBtn == 4))
        {
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
      shareToQQ((String)localObject1, paramRequestEvent);
      return;
      label445:
      int i = 0;
      continue;
      label450:
      i = 12;
    }
  }
  
  @JsEvent({"shareAppMessageDirectly"})
  public void shareAppMessageDirectly(RequestEvent paramRequestEvent)
  {
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp()))
    {
      shareAppMessage(paramRequestEvent);
      return;
    }
    GetShareState.obtain(this.mMiniAppContext).stagingJsonParams = paramRequestEvent.jsonParams;
    this.mShareProxy.showSharePanel(this.mMiniAppContext);
  }
  
  @JsEvent({"shareAppPictureMessage"})
  public void shareAppPictureMessage(RequestEvent paramRequestEvent)
  {
    int k = 0;
    label281:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        int i = localJSONObject.optInt("shareTarget", -1);
        int m = getShareType(i);
        ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
        int j = i;
        if ("shareAppPictureMessageDirectly".equals(paramRequestEvent.event))
        {
          if (m != -1) {
            break label281;
          }
          i = this.mShareProxy.getDefaultShareTarget();
          if (MoreItem.isValidExtendedItemId(i))
          {
            j = 6;
            localShareState.fromShareMenuBtn = j;
            j = i;
          }
        }
        else
        {
          i = localShareState.fromShareMenuBtn;
          localShareState.shareEvent = paramRequestEvent.event;
          localShareState.shareCallbackId = paramRequestEvent.callbackId;
          localShareState.requestEvent = paramRequestEvent;
          paramRequestEvent = localJSONObject.optString("title");
          String str1 = localJSONObject.optString("imageUrl");
          boolean bool = isNetworkImageUrl(str1);
          String str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str1);
          doShareAppPictureMessage(str1, bool, str2, isLocalResourceExists(str1, str2), new InnerShareData.Builder().setShareSource(11).setShareTarget(j).setTitle(this.mMiniAppInfo.name).setSummary(paramRequestEvent).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setShareInMiniProcess(localShareState.isShareInMiniProcess), getShareChatModel(j, localJSONObject, localShareState));
          return;
        }
        i = 0;
        j = k;
        continue;
        j = m;
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return;
      }
    }
  }
  
  @JsEvent({"shareAppPictureMessageDirectly"})
  public void shareAppPictureMessageDirectly(RequestEvent paramRequestEvent)
  {
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp()))
    {
      shareAppPictureMessage(paramRequestEvent);
      return;
    }
    this.mShareProxy.showSharePanel(this.mMiniAppContext);
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
  
  @JsEvent({"showShareMenu", "showShareMenuWithShareTicket"})
  public void showShareMenu(RequestEvent paramRequestEvent)
  {
    boolean bool3 = false;
    int n;
    Object localObject;
    if (isParamEmpty(paramRequestEvent))
    {
      i = 1;
      n = 1;
      k = 1;
      j = 1;
      bool1 = false;
      localObject = GetShareState.obtain(this.mMiniAppContext);
      if (j != 1) {
        break label406;
      }
      bool2 = true;
      label41:
      ((ShareState)localObject).withShareQQ = bool2;
      if (k != 1) {
        break label412;
      }
      bool2 = true;
      label57:
      ((ShareState)localObject).withShareQzone = bool2;
      if (n != 1) {
        break label418;
      }
    }
    label258:
    label406:
    label412:
    label418:
    for (bool2 = true;; bool2 = false)
    {
      ((ShareState)localObject).withShareWeChatFriend = bool2;
      bool2 = bool3;
      if (i == 1) {
        bool2 = true;
      }
      ((ShareState)localObject).withShareWeChatMoment = bool2;
      ((ShareState)localObject).withShareOthers = true;
      ((ShareState)localObject).withShareTicket = bool1;
      paramRequestEvent.ok();
      return;
      for (;;)
      {
        label242:
        int i3;
        for (;;)
        {
          int m;
          try
          {
            localObject = new JSONObject(paramRequestEvent.jsonParams);
            bool2 = ((JSONObject)localObject).optBoolean("withShareTicket", false);
          }
          catch (JSONException localJSONException1)
          {
            String str;
            int i1;
            int i2;
            label316:
            m = -1;
            k = -1;
            j = -1;
            bool1 = false;
            i = -1;
          }
          try
          {
            localObject = (JSONArray)((JSONObject)localObject).opt("showShareItems");
            if (localObject == null)
            {
              i = 1;
              n = 1;
              k = 1;
              j = 1;
              bool1 = bool2;
              break;
            }
            n = 0;
            m = -1;
            i = -1;
            k = -1;
            j = -1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              m = -1;
              k = -1;
              j = -1;
              i = -1;
              bool1 = bool2;
            }
          }
        }
        for (;;)
        {
          try
          {
            if (n < ((JSONArray)localObject).length())
            {
              str = ((JSONArray)localObject).getString(n);
              bool1 = str.equalsIgnoreCase("qq");
              if (!bool1) {
                continue;
              }
              j = 1;
            }
          }
          catch (JSONException localJSONException3)
          {
            bool1 = bool2;
            break label375;
            break;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("qzone");
            if (!bool1) {
              continue;
            }
            k = 1;
          }
          catch (JSONException localJSONException4)
          {
            bool1 = bool2;
            break label375;
            break label242;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("wechatFriends");
            if (!bool1) {
              continue;
            }
            i = 1;
          }
          catch (JSONException localJSONException5)
          {
            bool1 = bool2;
            break label375;
            break label258;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("wechatMoment");
            if (bool1) {
              m = 1;
            }
            n += 1;
          }
          catch (JSONException localJSONException6)
          {
            bool1 = bool2;
            break label375;
            i3 = i;
            break label316;
          }
        }
      }
      i1 = j;
      if (j == -1) {
        i1 = 0;
      }
      i2 = k;
      if (k == -1) {
        i2 = 0;
      }
      if (i != -1) {
        break label479;
      }
      i3 = 0;
      n = i3;
      i = m;
      k = i2;
      j = i1;
      bool1 = bool2;
      if (m != -1) {
        break;
      }
      i = 0;
      n = i3;
      k = i2;
      j = i1;
      bool1 = bool2;
      break;
      label375:
      localJSONException1.printStackTrace();
      QMLog.e("ShareJsPlugin", localJSONException1.getMessage(), localJSONException1);
      paramRequestEvent.fail();
      n = i;
      i = m;
      break;
      bool2 = false;
      break label41;
      bool2 = false;
      break label57;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */