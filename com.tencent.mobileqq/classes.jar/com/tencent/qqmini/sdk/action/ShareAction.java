package com.tencent.qqmini.sdk.action;

import android.os.Bundle;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class ShareAction
  implements Action<Boolean>
{
  public static final String KEY_MINI_APP_SHARE_CHAT_NAME = "key_mini_app_share_chat_name";
  public static final String KEY_MINI_APP_SHARE_CHAT_TYPE = "key_mini_app_share_chat_type";
  public static final String KEY_MINI_APP_SHARE_CHAT_UIN = "key_mini_app_share_chat_uin";
  public static final String KEY_SHARE_ITEM_ID = "key_share_item_id";
  public static final int SHARE_GAME_RAFFLE = 6;
  public static final int SHARE_OTHER = 7;
  public static final int SHARE_QQ = 1;
  public static final int SHARE_QQ_CHAT = 5;
  public static final int SHARE_QZONE = 2;
  public static final int SHARE_WX_FRIEND = 3;
  public static final int SHARE_WX_MOMENT = 4;
  private Bundle data;
  private int what;
  
  private String getCurrPage(IMiniAppContext paramIMiniAppContext)
  {
    return PageAction.obtain(paramIMiniAppContext).getPageUrl();
  }
  
  private int getCurrPageId(IMiniAppContext paramIMiniAppContext)
  {
    return PageAction.obtain(paramIMiniAppContext).getPageId();
  }
  
  private void handleForward(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
        {
          String str = "showActionSheet";
          localObject2 = str;
          localObject1 = str;
          if (paramShareState.tapIndexMap == null) {
            continue;
          }
          localObject1 = str;
          localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexQQ"));
          localObject1 = "showActionSheet";
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException1) {}
      try
      {
        if (!paramBaseRuntime.isMiniGame())
        {
          localObject2 = localObject1;
          if (getCurrPage(paramBaseRuntime) != null)
          {
            localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 0;
        if (paramShareState.requestEvent == null) {
          break label210;
        }
        localObject1 = paramShareState.requestEvent.jsService;
        if (localObject1 != null)
        {
          if (paramShareState.launchFrom != 1) {
            break;
          }
          paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
          if (paramBaseRuntime == null) {
            break label218;
          }
          paramBaseRuntime = paramBaseRuntime.toString();
          ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label195;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 0);
      localObject1 = localObject2;
      continue;
      label195:
      QMLog.e("Action", "on forward aio click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label210:
      localObject1 = paramBaseRuntime.getJsService();
      continue;
      label218:
      paramBaseRuntime = "";
    }
    ((IJsService)localObject1).evaluateSubscribeJS(localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
  }
  
  private void handleForwardQZone(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
        {
          String str = "showActionSheet";
          localObject2 = str;
          localObject1 = str;
          if (paramShareState.tapIndexMap == null) {
            continue;
          }
          localObject1 = str;
          localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexQZONE"));
          localObject1 = "showActionSheet";
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException1) {}
      try
      {
        if (!paramBaseRuntime.isMiniGame())
        {
          localObject2 = localObject1;
          if (getCurrPage(paramBaseRuntime) != null)
          {
            localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 1;
        if (paramShareState.requestEvent == null) {
          break label210;
        }
        localObject1 = paramShareState.requestEvent.jsService;
        if (localObject1 == null) {
          break label243;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
        if (paramBaseRuntime == null) {
          break label218;
        }
        paramBaseRuntime = paramBaseRuntime.toString();
        ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label195;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 1);
      localObject1 = localObject2;
      continue;
      label195:
      QMLog.e("Action", "on forward qzone click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label210:
      localObject1 = paramBaseRuntime.getJsService();
      continue;
      label218:
      paramBaseRuntime = "";
    }
    ((IJsService)localObject1).evaluateSubscribeJS(localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    return;
    label243:
    QMLog.e("Action", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void handleForwardWeChatFriends(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = "onShareAppMessage";
    Object localObject2;
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
        {
          localObject1 = "showActionSheet";
          if (paramShareState.tapIndexMap != null)
          {
            localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexWX"));
            localObject2 = "showActionSheet";
            if ((!paramBaseRuntime.isMiniGame()) && (getCurrPage(paramBaseRuntime) != null)) {
              localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
            }
            paramShareState.fromShareMenuBtn = 3;
            if (paramShareState.requestEvent == null) {
              break label174;
            }
            localObject1 = paramShareState.requestEvent.jsService;
            if (localObject1 == null) {
              break label207;
            }
            if (paramShareState.launchFrom != 1) {
              break;
            }
            paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
            if (paramBaseRuntime == null) {
              break label182;
            }
            paramBaseRuntime = paramBaseRuntime.toString();
            ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
          }
        }
        else
        {
          localJSONObject.put("fromShareButton", 0);
          localJSONObject.put("shareTarget", 3);
        }
        localObject2 = localObject1;
        continue;
        localObject1 = paramBaseRuntime.getJsService();
      }
      catch (JSONException paramBaseRuntime)
      {
        QMLog.e("Action", "on forward wechat friends click exception ", paramBaseRuntime);
        return;
      }
      label174:
      continue;
      label182:
      paramBaseRuntime = "";
    }
    ((IJsService)localObject1).evaluateSubscribeJS((String)localObject2, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    return;
    label207:
    QMLog.e("Action", "on forward wx friends click exception js service==null");
  }
  
  private void handleForwardWeChatMoment(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
        {
          String str = "showActionSheet";
          localObject2 = str;
          localObject1 = str;
          if (paramShareState.tapIndexMap == null) {
            continue;
          }
          localObject1 = str;
          localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexWXMoments"));
          localObject1 = "showActionSheet";
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException1) {}
      try
      {
        if (!paramBaseRuntime.isMiniGame())
        {
          localObject2 = localObject1;
          if (getCurrPage(paramBaseRuntime) != null)
          {
            localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 4;
        if (paramShareState.requestEvent == null) {
          break label210;
        }
        localObject1 = paramShareState.requestEvent.jsService;
        if (localObject1 == null) {
          break label243;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
        if (paramBaseRuntime == null) {
          break label218;
        }
        paramBaseRuntime = paramBaseRuntime.toString();
        ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label195;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 4);
      localObject1 = localObject2;
      continue;
      label195:
      QMLog.e("Action", "on forward wechat moment exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label210:
      localObject1 = paramBaseRuntime.getJsService();
      continue;
      label218:
      paramBaseRuntime = "";
    }
    ((IJsService)localObject1).evaluateSubscribeJS(localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    return;
    label243:
    QMLog.e("Action", "on forward wechat moments click exception js service==null");
  }
  
  private void handleRaffleShare(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fromShareButton", 0);
      localJSONObject.put("shareTarget", 0);
      localJSONObject.put("shareActionName", "raffleShare");
      QMLog.d("Action", "handleRaffleShare param: " + localJSONObject.toString());
      paramShareState.fromShareMenuBtn = 0;
      paramBaseRuntime = paramBaseRuntime.getJsService();
      if (paramBaseRuntime != null) {
        paramBaseRuntime.evaluateSubscribeJS("onShareAppMessage", localJSONObject.toString(), 0);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("Action", "handleRaffleShare", localJSONException);
      }
    }
  }
  
  /* Error */
  private void handleShareChatDirectly(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 214	com/tencent/qqmini/sdk/action/ShareAction:data	Landroid/os/Bundle;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 214	com/tencent/qqmini/sdk/action/ShareAction:data	Landroid/os/Bundle;
    //   12: ldc 18
    //   14: invokevirtual 220	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 9
    //   19: aload_0
    //   20: getfield 214	com/tencent/qqmini/sdk/action/ShareAction:data	Landroid/os/Bundle;
    //   23: ldc 15
    //   25: invokevirtual 224	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: aload_0
    //   30: getfield 214	com/tencent/qqmini/sdk/action/ShareAction:data	Landroid/os/Bundle;
    //   33: ldc 12
    //   35: invokevirtual 220	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 8
    //   40: ldc2_w 225
    //   43: lstore 6
    //   45: lload 6
    //   47: lstore 4
    //   49: aload 9
    //   51: ifnull +13 -> 64
    //   54: aload 9
    //   56: invokestatic 232	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   59: invokevirtual 236	java/lang/Long:longValue	()J
    //   62: lstore 4
    //   64: new 238	com/tencent/qqmini/sdk/launcher/model/ShareChatModel
    //   67: dup
    //   68: iload_3
    //   69: lload 4
    //   71: aload 8
    //   73: invokespecial 241	com/tencent/qqmini/sdk/launcher/model/ShareChatModel:<init>	(IJLjava/lang/String;)V
    //   76: astore 12
    //   78: new 68	org/json/JSONObject
    //   81: dup
    //   82: invokespecial 69	org/json/JSONObject:<init>	()V
    //   85: astore 11
    //   87: ldc 71
    //   89: astore 9
    //   91: aload 9
    //   93: astore 8
    //   95: aload_2
    //   96: getfield 76	com/tencent/qqmini/sdk/launcher/model/ShareState:launchFrom	I
    //   99: iconst_1
    //   100: if_icmpne +172 -> 272
    //   103: ldc 78
    //   105: astore 10
    //   107: aload 10
    //   109: astore 9
    //   111: aload 10
    //   113: astore 8
    //   115: aload_2
    //   116: getfield 82	com/tencent/qqmini/sdk/launcher/model/ShareState:tapIndexMap	Ljava/util/HashMap;
    //   119: ifnull +179 -> 298
    //   122: aload 10
    //   124: astore 8
    //   126: aload 11
    //   128: ldc 84
    //   130: iconst_m1
    //   131: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   134: pop
    //   135: ldc 78
    //   137: astore 8
    //   139: aload_1
    //   140: invokevirtual 102	com/tencent/qqmini/sdk/launcher/core/BaseRuntime:isMiniGame	()Z
    //   143: ifne +24 -> 167
    //   146: aload_0
    //   147: aload_1
    //   148: invokespecial 104	com/tencent/qqmini/sdk/action/ShareAction:getCurrPage	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)Ljava/lang/String;
    //   151: ifnull +16 -> 167
    //   154: aload 11
    //   156: ldc 106
    //   158: aload_0
    //   159: aload_1
    //   160: invokespecial 104	com/tencent/qqmini/sdk/action/ShareAction:getCurrPage	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)Ljava/lang/String;
    //   163: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload 11
    //   169: ldc 243
    //   171: aload 12
    //   173: invokevirtual 246	com/tencent/qqmini/sdk/launcher/model/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   176: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload 8
    //   182: astore 9
    //   184: aload_2
    //   185: iconst_0
    //   186: putfield 109	com/tencent/qqmini/sdk/launcher/model/ShareState:fromShareMenuBtn	I
    //   189: aload_2
    //   190: aload 12
    //   192: putfield 250	com/tencent/qqmini/sdk/launcher/model/ShareState:shareChatModel	Lcom/tencent/qqmini/sdk/launcher/model/ShareChatModel;
    //   195: aload_2
    //   196: getfield 113	com/tencent/qqmini/sdk/launcher/model/ShareState:requestEvent	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   199: ifnull +124 -> 323
    //   202: aload_2
    //   203: getfield 113	com/tencent/qqmini/sdk/launcher/model/ShareState:requestEvent	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   206: getfield 119	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   209: astore 8
    //   211: aload 8
    //   213: ifnull +145 -> 358
    //   216: aload_2
    //   217: getfield 76	com/tencent/qqmini/sdk/launcher/model/ShareState:launchFrom	I
    //   220: iconst_1
    //   221: if_icmpne +117 -> 338
    //   224: aload 9
    //   226: aload 11
    //   228: invokestatic 125	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   231: astore_1
    //   232: aload_1
    //   233: ifnull +99 -> 332
    //   236: aload_1
    //   237: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   240: astore_1
    //   241: aload 8
    //   243: aload_2
    //   244: getfield 131	com/tencent/qqmini/sdk/launcher/model/ShareState:shareCallbackId	I
    //   247: aload_1
    //   248: invokeinterface 137 3 0
    //   253: return
    //   254: astore 9
    //   256: ldc 146
    //   258: ldc 252
    //   260: aload 9
    //   262: invokestatic 154	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: lload 6
    //   267: lstore 4
    //   269: goto -205 -> 64
    //   272: aload 9
    //   274: astore 8
    //   276: aload 11
    //   278: ldc 139
    //   280: iconst_0
    //   281: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   284: pop
    //   285: aload 9
    //   287: astore 8
    //   289: aload 11
    //   291: ldc 144
    //   293: iconst_5
    //   294: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   297: pop
    //   298: aload 9
    //   300: astore 8
    //   302: goto -163 -> 139
    //   305: astore 9
    //   307: ldc 146
    //   309: ldc 254
    //   311: aload 9
    //   313: invokestatic 154	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload 8
    //   318: astore 9
    //   320: goto -136 -> 184
    //   323: aload_1
    //   324: invokevirtual 158	com/tencent/qqmini/sdk/launcher/core/BaseRuntime:getJsService	()Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   327: astore 8
    //   329: goto -118 -> 211
    //   332: ldc 160
    //   334: astore_1
    //   335: goto -94 -> 241
    //   338: aload 8
    //   340: aload 9
    //   342: aload 11
    //   344: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   347: aload_0
    //   348: aload_1
    //   349: invokespecial 162	com/tencent/qqmini/sdk/action/ShareAction:getCurrPageId	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)I
    //   352: invokeinterface 166 4 0
    //   357: return
    //   358: ldc 146
    //   360: ldc_w 256
    //   363: invokestatic 176	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: return
    //   367: astore 9
    //   369: goto -62 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	ShareAction
    //   0	372	1	paramBaseRuntime	BaseRuntime
    //   0	372	2	paramShareState	ShareState
    //   28	41	3	i	int
    //   47	221	4	l1	long
    //   43	223	6	l2	long
    //   38	301	8	localObject1	Object
    //   17	208	9	localObject2	Object
    //   254	45	9	localThrowable	java.lang.Throwable
    //   305	7	9	localJSONException1	JSONException
    //   318	23	9	localObject3	Object
    //   367	1	9	localJSONException2	JSONException
    //   105	18	10	str	String
    //   85	258	11	localJSONObject	JSONObject
    //   76	115	12	localShareChatModel	com.tencent.qqmini.sdk.launcher.model.ShareChatModel
    // Exception table:
    //   from	to	target	type
    //   54	64	254	java/lang/Throwable
    //   95	103	305	org/json/JSONException
    //   115	122	305	org/json/JSONException
    //   126	135	305	org/json/JSONException
    //   276	285	305	org/json/JSONException
    //   289	298	305	org/json/JSONException
    //   139	167	367	org/json/JSONException
    //   167	180	367	org/json/JSONException
  }
  
  private void handleShareOther(BaseRuntime paramBaseRuntime, ShareState paramShareState, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fromShareButton", 0);
      localJSONObject.put("shareTarget", paramInt);
      if ((!paramBaseRuntime.isMiniGame()) && (getCurrPage(paramBaseRuntime) != null)) {
        localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
      }
      paramShareState.fromShareMenuBtn = paramInt;
      if (paramShareState.requestEvent != null)
      {
        paramShareState = paramShareState.requestEvent.jsService;
        if (paramShareState == null) {
          break label120;
        }
        paramShareState.evaluateSubscribeJS("onShareAppMessage", localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("Action", "on forward wechat moment exception ", localJSONException);
        continue;
        paramShareState = paramBaseRuntime.getJsService();
      }
      label120:
      QMLog.e("Action", "on forward wechat moments click exception js service==null");
    }
  }
  
  public static ShareAction obtain(int paramInt)
  {
    return obtain(paramInt, null);
  }
  
  public static ShareAction obtain(int paramInt, Bundle paramBundle)
  {
    ShareAction localShareAction = new ShareAction();
    localShareAction.what = paramInt;
    localShareAction.data = paramBundle;
    return localShareAction;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    ShareState localShareState = paramBaseRuntime.getShareState();
    if (localShareState == null)
    {
      QMLog.e("Action", "Failed to perform " + this + ". shareState is null");
      return Boolean.valueOf(false);
    }
    if (paramBaseRuntime.getPage() == null)
    {
      QMLog.e("Action", "Failed to perform " + this + ". page is null");
      return Boolean.valueOf(false);
    }
    switch (this.what)
    {
    }
    for (;;)
    {
      return Boolean.valueOf(true);
      handleForward(paramBaseRuntime, localShareState);
      continue;
      handleForwardQZone(paramBaseRuntime, localShareState);
      continue;
      handleForwardWeChatFriends(paramBaseRuntime, localShareState);
      continue;
      handleForwardWeChatMoment(paramBaseRuntime, localShareState);
      continue;
      handleShareChatDirectly(paramBaseRuntime, localShareState);
      continue;
      handleRaffleShare(paramBaseRuntime, localShareState);
      continue;
      if (this.data == null)
      {
        QMLog.e("Action", "Failed to share to other, data is null");
        return Boolean.valueOf(false);
      }
      handleShareOther(paramBaseRuntime, localShareState, this.data.getInt("key_share_item_id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.ShareAction
 * JD-Core Version:    0.7.0.1
 */