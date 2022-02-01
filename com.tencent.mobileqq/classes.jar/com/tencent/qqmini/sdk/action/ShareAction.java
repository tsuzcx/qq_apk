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
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
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
    Object localObject = PageAction.obtain(paramIMiniAppContext).getWebViewUrlForShare();
    if (localObject != null)
    {
      paramIMiniAppContext = new StringBuilder();
      paramIMiniAppContext.append("getCurrPage with webViewUrl:");
      paramIMiniAppContext.append((String)localObject);
      QMLog.e("Action", paramIMiniAppContext.toString());
      return localObject;
    }
    paramIMiniAppContext = PageAction.obtain(paramIMiniAppContext).getPageUrl();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCurrPage with PageUrl:");
    ((StringBuilder)localObject).append(paramIMiniAppContext);
    QMLog.e("Action", ((StringBuilder)localObject).toString());
    return paramIMiniAppContext;
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
    Object localObject3;
    try
    {
      if (paramShareState.launchFrom == 1)
      {
        localObject3 = "showActionSheet";
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (paramShareState.tapIndexMap != null)
        {
          localObject1 = localObject3;
          localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexQQ"));
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject1 = localObject2;
        localJSONObject.put("fromShareButton", 0);
        localObject1 = localObject2;
        localJSONObject.put("shareTarget", 0);
      }
      localObject1 = localObject2;
      localObject3 = localObject2;
      if (!paramBaseRuntime.isMiniGame())
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (getCurrPage(paramBaseRuntime) != null)
        {
          localObject1 = localObject2;
          localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
          localObject3 = localObject2;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("Action", "on forward aio click exception ", localJSONException);
      localObject3 = localObject1;
    }
    paramShareState.fromShareMenuBtn = 0;
    if (paramShareState.requestEvent != null) {
      localObject1 = paramShareState.requestEvent.jsService;
    } else {
      localObject1 = paramBaseRuntime.getJsService();
    }
    if (localObject1 != null)
    {
      if (paramShareState.launchFrom == 1)
      {
        paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject3, localJSONObject);
        if (paramBaseRuntime != null) {
          paramBaseRuntime = paramBaseRuntime.toString();
        } else {
          paramBaseRuntime = "";
        }
        ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
        return;
      }
      ((IJsService)localObject1).evaluateSubscribeJS((String)localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    }
  }
  
  private void handleForwardQZone(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    Object localObject3;
    try
    {
      if (paramShareState.launchFrom == 1)
      {
        localObject3 = "showActionSheet";
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (paramShareState.tapIndexMap != null)
        {
          localObject1 = localObject3;
          localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexQZONE"));
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject1 = localObject2;
        localJSONObject.put("fromShareButton", 0);
        localObject1 = localObject2;
        localJSONObject.put("shareTarget", 1);
      }
      localObject1 = localObject2;
      localObject3 = localObject2;
      if (!paramBaseRuntime.isMiniGame())
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (getCurrPage(paramBaseRuntime) != null)
        {
          localObject1 = localObject2;
          localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
          localObject3 = localObject2;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("Action", "on forward qzone click exception ", localJSONException);
      localObject3 = localObject1;
    }
    paramShareState.fromShareMenuBtn = 1;
    if (paramShareState.requestEvent != null) {
      localObject1 = paramShareState.requestEvent.jsService;
    } else {
      localObject1 = paramBaseRuntime.getJsService();
    }
    if (localObject1 != null)
    {
      if (paramShareState.launchFrom == 1)
      {
        paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject3, localJSONObject);
        if (paramBaseRuntime != null) {
          paramBaseRuntime = paramBaseRuntime.toString();
        } else {
          paramBaseRuntime = "";
        }
        ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
        return;
      }
      ((IJsService)localObject1).evaluateSubscribeJS((String)localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
      return;
    }
    QMLog.e("Action", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void handleForwardWeChatFriends(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject1;
      Object localObject2;
      if (paramShareState.launchFrom == 1)
      {
        localObject1 = "showActionSheet";
        localObject2 = localObject1;
        if (paramShareState.tapIndexMap != null)
        {
          localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexWX"));
          localObject2 = localObject1;
        }
      }
      else
      {
        localJSONObject.put("fromShareButton", 0);
        localJSONObject.put("shareTarget", 3);
        localObject2 = "onShareAppMessage";
      }
      if ((!paramBaseRuntime.isMiniGame()) && (getCurrPage(paramBaseRuntime) != null)) {
        localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
      }
      paramShareState.fromShareMenuBtn = 3;
      if (paramShareState.requestEvent != null) {
        localObject1 = paramShareState.requestEvent.jsService;
      } else {
        localObject1 = paramBaseRuntime.getJsService();
      }
      if (localObject1 != null)
      {
        if (paramShareState.launchFrom == 1)
        {
          paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
          if (paramBaseRuntime != null) {
            paramBaseRuntime = paramBaseRuntime.toString();
          } else {
            paramBaseRuntime = "";
          }
          ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
          return;
        }
        ((IJsService)localObject1).evaluateSubscribeJS((String)localObject2, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
        return;
      }
      QMLog.e("Action", "on forward wx friends click exception js service==null");
      return;
    }
    catch (JSONException paramBaseRuntime)
    {
      QMLog.e("Action", "on forward wechat friends click exception ", paramBaseRuntime);
    }
  }
  
  private void handleForwardWeChatMoment(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    Object localObject3;
    try
    {
      if (paramShareState.launchFrom == 1)
      {
        localObject3 = "showActionSheet";
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (paramShareState.tapIndexMap != null)
        {
          localObject1 = localObject3;
          localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexWXMoments"));
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject1 = localObject2;
        localJSONObject.put("fromShareButton", 0);
        localObject1 = localObject2;
        localJSONObject.put("shareTarget", 4);
      }
      localObject1 = localObject2;
      localObject3 = localObject2;
      if (!paramBaseRuntime.isMiniGame())
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (getCurrPage(paramBaseRuntime) != null)
        {
          localObject1 = localObject2;
          localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
          localObject3 = localObject2;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("Action", "on forward wechat moment exception ", localJSONException);
      localObject3 = localObject1;
    }
    paramShareState.fromShareMenuBtn = 4;
    if (paramShareState.requestEvent != null) {
      localObject1 = paramShareState.requestEvent.jsService;
    } else {
      localObject1 = paramBaseRuntime.getJsService();
    }
    if (localObject1 != null)
    {
      if (paramShareState.launchFrom == 1)
      {
        paramBaseRuntime = ApiUtil.wrapCallbackOk((String)localObject3, localJSONObject);
        if (paramBaseRuntime != null) {
          paramBaseRuntime = paramBaseRuntime.toString();
        } else {
          paramBaseRuntime = "";
        }
        ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
        return;
      }
      ((IJsService)localObject1).evaluateSubscribeJS((String)localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
      return;
    }
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
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("Action", "handleRaffleShare", localJSONException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRaffleShare param: ");
    localStringBuilder.append(localJSONObject.toString());
    QMLog.d("Action", localStringBuilder.toString());
    paramShareState.fromShareMenuBtn = 0;
    paramBaseRuntime = paramBaseRuntime.getJsService();
    if (paramBaseRuntime != null) {
      paramBaseRuntime.evaluateSubscribeJS("onShareAppMessage", localJSONObject.toString(), 0);
    }
  }
  
  private void handleShareChatDirectly(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    Object localObject1 = this.data;
    if (localObject1 == null) {
      return;
    }
    String str1 = ((Bundle)localObject1).getString("key_mini_app_share_chat_uin");
    int i = this.data.getInt("key_mini_app_share_chat_type");
    localObject1 = this.data.getString("key_mini_app_share_chat_name");
    long l2 = -1L;
    long l1 = l2;
    if (str1 != null) {
      try
      {
        l1 = Long.valueOf(str1).longValue();
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("Action", "handleShareChatDirectly get an exception ", localThrowable);
        l1 = l2;
      }
    }
    ShareChatModel localShareChatModel = new ShareChatModel(i, l1, (String)localObject1);
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    localObject1 = localObject2;
    Object localObject3;
    try
    {
      if (paramShareState.launchFrom == 1)
      {
        String str2 = "showActionSheet";
        localObject2 = str2;
        localObject1 = str2;
        if (paramShareState.tapIndexMap != null)
        {
          localObject1 = str2;
          localJSONObject.put("tapIndex", -1);
          localObject2 = str2;
        }
      }
      else
      {
        localObject1 = localObject2;
        localJSONObject.put("fromShareButton", 0);
        localObject1 = localObject2;
        localJSONObject.put("shareTarget", 5);
      }
      localObject1 = localObject2;
      if (!paramBaseRuntime.isMiniGame())
      {
        localObject1 = localObject2;
        if (getCurrPage(paramBaseRuntime) != null)
        {
          localObject1 = localObject2;
          localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
        }
      }
      localObject1 = localObject2;
      localJSONObject.put("chatDataHash", localShareChatModel.getEntryHash());
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("Action", "on forward directly click exception ", localJSONException);
      localObject3 = localObject1;
    }
    paramShareState.fromShareMenuBtn = 0;
    paramShareState.shareChatModel = localShareChatModel;
    if (paramShareState.requestEvent != null) {
      localObject1 = paramShareState.requestEvent.jsService;
    } else {
      localObject1 = paramBaseRuntime.getJsService();
    }
    if (localObject1 != null)
    {
      if (paramShareState.launchFrom == 1)
      {
        paramBaseRuntime = ApiUtil.wrapCallbackOk(localObject3, localJSONObject);
        if (paramBaseRuntime != null) {
          paramBaseRuntime = paramBaseRuntime.toString();
        } else {
          paramBaseRuntime = "";
        }
        ((IJsService)localObject1).evaluateCallbackJs(paramShareState.shareCallbackId, paramBaseRuntime);
        return;
      }
      ((IJsService)localObject1).evaluateSubscribeJS(localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
      return;
    }
    QMLog.e("Action", "on forward directly click exception js service==null");
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
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("Action", "on forward wechat moment exception ", localJSONException);
    }
    paramShareState.fromShareMenuBtn = paramInt;
    if (paramShareState.requestEvent != null) {
      paramShareState = paramShareState.requestEvent.jsService;
    } else {
      paramShareState = paramBaseRuntime.getJsService();
    }
    if (paramShareState != null)
    {
      paramShareState.evaluateSubscribeJS("onShareAppMessage", localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
      return;
    }
    QMLog.e("Action", "on forward wechat moments click exception js service==null");
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
    Boolean localBoolean = Boolean.valueOf(false);
    if (localShareState == null)
    {
      paramBaseRuntime = new StringBuilder();
      paramBaseRuntime.append("Failed to perform ");
      paramBaseRuntime.append(this);
      paramBaseRuntime.append(". shareState is null");
      QMLog.e("Action", paramBaseRuntime.toString());
      return localBoolean;
    }
    if (paramBaseRuntime.getPage() == null)
    {
      paramBaseRuntime = new StringBuilder();
      paramBaseRuntime.append("Failed to perform ");
      paramBaseRuntime.append(this);
      paramBaseRuntime.append(". page is null");
      QMLog.e("Action", paramBaseRuntime.toString());
      return localBoolean;
    }
    switch (this.what)
    {
    default: 
      break;
    case 7: 
      Bundle localBundle = this.data;
      if (localBundle == null)
      {
        QMLog.e("Action", "Failed to share to other, data is null");
        return localBoolean;
      }
      handleShareOther(paramBaseRuntime, localShareState, localBundle.getInt("key_share_item_id", 0));
      break;
    case 6: 
      handleRaffleShare(paramBaseRuntime, localShareState);
      break;
    case 5: 
      handleShareChatDirectly(paramBaseRuntime, localShareState);
      break;
    case 4: 
      handleForwardWeChatMoment(paramBaseRuntime, localShareState);
      break;
    case 3: 
      handleForwardWeChatFriends(paramBaseRuntime, localShareState);
      break;
    case 2: 
      handleForwardQZone(paramBaseRuntime, localShareState);
      break;
    case 1: 
      handleForward(paramBaseRuntime, localShareState);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.ShareAction
 * JD-Core Version:    0.7.0.1
 */