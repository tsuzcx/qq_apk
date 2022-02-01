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
  private final int ACTION_SHEET_SHARE_PANEL_TYPE = 1;
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
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
        break label75;
      }
      paramInt1 = this.mShareProxy.getDefaultShareTarget();
      if (!MoreItem.isValidExtendedItemId(paramInt1)) {
        break label67;
      }
      paramInt2 = 6;
    }
    label67:
    label75:
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
  
  private void shareToQQ(String paramString, InnerShareData.Builder paramBuilder)
  {
    boolean bool3 = false;
    MiniAppFileManager localMiniAppFileManager = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
    boolean bool1;
    if ((URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)))
    {
      bool1 = true;
      boolean bool2 = bool3;
      if (!TextUtils.isEmpty(paramString))
      {
        bool2 = bool3;
        if (new File(localMiniAppFileManager.getAbsolutePath(paramString)).exists()) {
          bool2 = true;
        }
      }
      if ((!StringUtil.isEmpty(paramString)) && ((bool1) || (bool2))) {
        break label220;
      }
      if (!this.mMiniAppContext.isMiniGame()) {
        break label171;
      }
      paramBuilder.setSharePicPath(WnsUtil.defaultShareImg()).build().shareAppMessage();
      QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + paramString + "], use default share image");
    }
    label171:
    while (GetShareState.obtain(this.mMiniAppContext) == null)
    {
      return;
      bool1 = false;
      break;
    }
    if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot)
    {
      QMLog.e("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
      return;
    }
    GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.1(this, paramBuilder));
    return;
    label220:
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
    //   3: new 384	java/util/HashMap
    //   6: dup
    //   7: invokespecial 385	java/util/HashMap:<init>	()V
    //   10: astore 9
    //   12: aload_1
    //   13: getfield 388	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   16: ifnull +29 -> 45
    //   19: ldc_w 390
    //   22: aload_1
    //   23: getfield 388	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   26: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifne +16 -> 45
    //   32: ldc_w 392
    //   35: aload_1
    //   36: getfield 388	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   39: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +89 -> 131
    //   45: new 131	org/json/JSONObject
    //   48: dup
    //   49: invokespecial 393	org/json/JSONObject:<init>	()V
    //   52: ldc_w 395
    //   55: ldc_w 397
    //   58: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload_1
    //   63: invokevirtual 332	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   66: pop
    //   67: ldc 43
    //   69: new 154	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   76: aload_1
    //   77: getfield 209	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   80: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 403
    //   86: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 170	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: return
    //   96: astore 9
    //   98: ldc 43
    //   100: new 154	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: getfield 209	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   111: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 405
    //   117: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aload 9
    //   125: invokestatic 408	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: goto -61 -> 67
    //   131: new 131	org/json/JSONObject
    //   134: dup
    //   135: aload_1
    //   136: getfield 388	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   139: invokespecial 224	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   142: ldc_w 410
    //   145: invokevirtual 414	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   148: checkcast 323	org/json/JSONArray
    //   151: astore 10
    //   153: aload 10
    //   155: ifnonnull +438 -> 593
    //   158: new 131	org/json/JSONObject
    //   161: dup
    //   162: invokespecial 393	org/json/JSONObject:<init>	()V
    //   165: ldc_w 395
    //   168: ldc_w 416
    //   171: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload_1
    //   176: invokevirtual 332	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   179: pop
    //   180: ldc 43
    //   182: new 154	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   189: aload_1
    //   190: getfield 209	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   193: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 418
    //   199: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 170	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: return
    //   209: astore 9
    //   211: aload 9
    //   213: invokevirtual 421	org/json/JSONException:printStackTrace	()V
    //   216: ldc 43
    //   218: aload 9
    //   220: invokevirtual 424	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   223: aload 9
    //   225: invokestatic 408	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: invokevirtual 332	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   232: pop
    //   233: return
    //   234: astore 9
    //   236: ldc 43
    //   238: new 154	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   245: aload_1
    //   246: getfield 209	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   249: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc_w 405
    //   255: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: aload 9
    //   263: invokestatic 408	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: goto -86 -> 180
    //   269: iload 6
    //   271: aload 10
    //   273: invokevirtual 326	org/json/JSONArray:length	()I
    //   276: if_icmpge +127 -> 403
    //   279: aload 10
    //   281: iload 6
    //   283: invokevirtual 427	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   286: astore 11
    //   288: aload 11
    //   290: ldc 27
    //   292: invokevirtual 430	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   295: ifeq +20 -> 315
    //   298: aload 9
    //   300: ldc_w 432
    //   303: iload 6
    //   305: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   311: pop
    //   312: iconst_1
    //   313: istore 5
    //   315: aload 11
    //   317: ldc 30
    //   319: invokevirtual 430	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   322: ifeq +20 -> 342
    //   325: aload 9
    //   327: ldc_w 443
    //   330: iload 6
    //   332: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: pop
    //   339: iconst_1
    //   340: istore 4
    //   342: aload 11
    //   344: ldc 33
    //   346: invokevirtual 430	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   349: ifeq +19 -> 368
    //   352: aload 9
    //   354: ldc_w 445
    //   357: iload 6
    //   359: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: iconst_1
    //   367: istore_3
    //   368: aload 11
    //   370: ldc 36
    //   372: invokevirtual 430	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   375: ifeq +19 -> 394
    //   378: aload 9
    //   380: ldc_w 447
    //   383: iload 6
    //   385: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: iconst_1
    //   393: istore_2
    //   394: iload 6
    //   396: iconst_1
    //   397: iadd
    //   398: istore 6
    //   400: goto -131 -> 269
    //   403: iload 5
    //   405: iconst_m1
    //   406: if_icmpne +184 -> 590
    //   409: iconst_0
    //   410: istore 5
    //   412: iload 4
    //   414: istore 6
    //   416: iload 4
    //   418: iconst_m1
    //   419: if_icmpne +6 -> 425
    //   422: iconst_0
    //   423: istore 6
    //   425: iload_3
    //   426: istore 4
    //   428: iload_3
    //   429: iconst_m1
    //   430: if_icmpne +6 -> 436
    //   433: iconst_0
    //   434: istore 4
    //   436: iload_2
    //   437: istore_3
    //   438: iload_2
    //   439: iconst_m1
    //   440: if_icmpne +5 -> 445
    //   443: iconst_0
    //   444: istore_3
    //   445: aload_0
    //   446: getfield 83	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   449: invokestatic 290	com/tencent/qqmini/sdk/action/GetShareState:obtain	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)Lcom/tencent/qqmini/sdk/launcher/model/ShareState;
    //   452: astore 10
    //   454: aload 10
    //   456: iconst_1
    //   457: putfield 450	com/tencent/qqmini/sdk/launcher/model/ShareState:launchFrom	I
    //   460: iload 5
    //   462: iconst_1
    //   463: if_icmpne +109 -> 572
    //   466: iconst_1
    //   467: istore 7
    //   469: aload 10
    //   471: iload 7
    //   473: putfield 453	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQQ	Z
    //   476: iload 6
    //   478: iconst_1
    //   479: if_icmpne +99 -> 578
    //   482: iconst_1
    //   483: istore 7
    //   485: aload 10
    //   487: iload 7
    //   489: putfield 456	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQzone	Z
    //   492: iload 4
    //   494: iconst_1
    //   495: if_icmpne +89 -> 584
    //   498: iconst_1
    //   499: istore 7
    //   501: aload 10
    //   503: iload 7
    //   505: putfield 459	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatFriend	Z
    //   508: iload 8
    //   510: istore 7
    //   512: iload_3
    //   513: iconst_1
    //   514: if_icmpne +6 -> 520
    //   517: iconst_1
    //   518: istore 7
    //   520: aload 10
    //   522: iload 7
    //   524: putfield 462	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatMoment	Z
    //   527: aload 10
    //   529: iconst_1
    //   530: putfield 465	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareOthers	Z
    //   533: aload 10
    //   535: aload 9
    //   537: putfield 469	com/tencent/qqmini/sdk/launcher/model/ShareState:tapIndexMap	Ljava/util/HashMap;
    //   540: aload 10
    //   542: aload_1
    //   543: getfield 209	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   546: putfield 472	com/tencent/qqmini/sdk/launcher/model/ShareState:shareEvent	Ljava/lang/String;
    //   549: aload 10
    //   551: aload_1
    //   552: getfield 475	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:callbackId	I
    //   555: putfield 478	com/tencent/qqmini/sdk/launcher/model/ShareState:shareCallbackId	I
    //   558: aload_0
    //   559: getfield 63	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:mShareProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/ShareProxy;
    //   562: aload_0
    //   563: getfield 83	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   566: invokeinterface 482 2 0
    //   571: return
    //   572: iconst_0
    //   573: istore 7
    //   575: goto -106 -> 469
    //   578: iconst_0
    //   579: istore 7
    //   581: goto -96 -> 485
    //   584: iconst_0
    //   585: istore 7
    //   587: goto -86 -> 501
    //   590: goto -178 -> 412
    //   593: iconst_0
    //   594: istore 6
    //   596: iconst_m1
    //   597: istore_2
    //   598: iconst_m1
    //   599: istore_3
    //   600: iconst_m1
    //   601: istore 4
    //   603: iconst_m1
    //   604: istore 5
    //   606: goto -337 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	ShareJsPlugin
    //   0	609	1	paramRequestEvent	RequestEvent
    //   393	205	2	i	int
    //   367	233	3	j	int
    //   340	262	4	k	int
    //   313	292	5	m	int
    //   269	326	6	n	int
    //   467	119	7	bool1	boolean
    //   1	508	8	bool2	boolean
    //   10	1	9	localHashMap	java.util.HashMap
    //   96	28	9	localJSONException1	JSONException
    //   209	15	9	localJSONException2	JSONException
    //   234	302	9	localJSONException3	JSONException
    //   151	399	10	localObject	Object
    //   286	83	11	str	String
    // Exception table:
    //   from	to	target	type
    //   45	67	96	org/json/JSONException
    //   131	153	209	org/json/JSONException
    //   180	208	209	org/json/JSONException
    //   236	266	209	org/json/JSONException
    //   269	288	209	org/json/JSONException
    //   288	312	209	org/json/JSONException
    //   315	339	209	org/json/JSONException
    //   342	366	209	org/json/JSONException
    //   368	392	209	org/json/JSONException
    //   158	180	234	org/json/JSONException
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
          break label387;
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
          break label392;
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
      label387:
      int i = 0;
      continue;
      label392:
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
    int j;
    ShareState localShareState;
    int i;
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      j = ((JSONObject)localObject).optInt("shareTarget", -1);
      k = getShareType(j);
      localShareState = GetShareState.obtain(this.mMiniAppContext);
      i = j;
      if ("shareAppPictureMessageDirectly".equals(paramRequestEvent.event))
      {
        i = j;
        j = k;
        if (k == -1)
        {
          i = this.mShareProxy.getDefaultShareTarget();
          if (!MoreItem.isValidExtendedItemId(i)) {
            break label448;
          }
          j = 6;
        }
        localShareState.fromShareMenuBtn = j;
      }
      j = localShareState.fromShareMenuBtn;
      localShareState.shareEvent = paramRequestEvent.event;
      localShareState.shareCallbackId = paramRequestEvent.callbackId;
      paramRequestEvent = ((JSONObject)localObject).optString("title");
      localObject = ((JSONObject)localObject).optString("imageUrl");
      if (URLUtil.isHttpUrl((String)localObject)) {
        break label442;
      }
      if (!URLUtil.isHttpsUrl((String)localObject)) {
        break label455;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      Object localObject;
      label153:
      paramRequestEvent.printStackTrace();
      return;
    }
    String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File(str).exists())) {}
    for (int k = 1;; k = 0)
    {
      paramRequestEvent = new InnerShareData.Builder().setShareSource(11).setShareTarget(i).setTitle(this.mMiniAppInfo.name).setSummary(paramRequestEvent).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setShareInMiniProcess(localShareState.isShareInMiniProcess);
      if (j != 0)
      {
        paramRequestEvent.setSharePicPath((String)localObject).build().shareAppPictureMessage(this.mMiniAppContext);
        return;
      }
      if ((StringUtil.isEmpty((String)localObject)) || ((j == 0) && (k == 0)))
      {
        if (this.mMiniAppContext.isMiniGame())
        {
          if (this.mMiniAppInfo != null)
          {
            paramRequestEvent.setSharePicPath(this.mMiniAppInfo.iconUrl).build().shareAppPictureMessage(this.mMiniAppContext);
            return;
          }
          QMLog.e("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
          return;
        }
        localShareState = GetShareState.obtain(this.mMiniAppContext);
        if (localShareState != null)
        {
          if (localShareState.isGettingScreenShot)
          {
            QMLog.e("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.3(this, paramRequestEvent));
        }
      }
      else if ((j == 0) && (k != 0))
      {
        paramRequestEvent.setSharePicPath(str).setIsLocalPic(true).build().shareAppPictureMessage(this.mMiniAppContext);
        return;
        label442:
        j = 1;
        break label153;
      }
      return;
      label448:
      j = 0;
      i = 0;
      break;
      label455:
      j = 0;
      break label153;
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
    new InnerShareData.Builder().setShareSource(11).setShareTarget(7).setTemplateId("657667B4D8C04B3F84E4AAA3D046A903").setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setEvent(paramRequestEvent.event).setCallbackId(paramRequestEvent.callbackId).build().shareAppMessage();
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
    if ((paramRequestEvent.jsonParams == null) || ("null".equals(paramRequestEvent.jsonParams)) || ("{}".equals(paramRequestEvent.jsonParams)))
    {
      i = 1;
      n = 1;
      k = 1;
      j = 1;
      bool1 = false;
      localObject = GetShareState.obtain(this.mMiniAppContext);
      if (j != 1) {
        break label431;
      }
      bool2 = true;
      label66:
      ((ShareState)localObject).withShareQQ = bool2;
      if (k != 1) {
        break label437;
      }
      bool2 = true;
      label82:
      ((ShareState)localObject).withShareQzone = bool2;
      if (n != 1) {
        break label443;
      }
    }
    label267:
    label283:
    label431:
    label437:
    label443:
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
            label341:
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
            break label400;
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
            break label400;
            break label267;
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
            break label400;
            break label283;
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
            break label400;
            i3 = i;
            break label341;
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
        break label504;
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
      localJSONException1.printStackTrace();
      QMLog.e("ShareJsPlugin", localJSONException1.getMessage(), localJSONException1);
      paramRequestEvent.fail();
      n = i;
      i = m;
      break;
      bool2 = false;
      break label66;
      bool2 = false;
      break label82;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */