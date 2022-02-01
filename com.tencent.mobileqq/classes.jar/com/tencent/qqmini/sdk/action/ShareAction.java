package com.tencent.qqmini.sdk.action;

import android.os.Bundle;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
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
  public static final int SHARE_OTHER = 6;
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
        if (paramBaseRuntime.getJsService() != null)
        {
          if (paramShareState.launchFrom != 1) {
            break;
          }
          localObject1 = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
          if (localObject1 == null) {
            break label201;
          }
          localObject1 = ((JSONObject)localObject1).toString();
          paramBaseRuntime.getJsService().evaluateCallbackJs(paramShareState.shareCallbackId, (String)localObject1);
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label186;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 0);
      localObject1 = localObject2;
      continue;
      label186:
      QMLog.e("Action", "on forward aio click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label201:
      localObject1 = "";
    }
    paramBaseRuntime.getJsService().evaluateSubscribeJS(localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
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
        if (paramBaseRuntime.getJsService() == null) {
          break label229;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        localObject1 = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
        if (localObject1 == null) {
          break label201;
        }
        localObject1 = ((JSONObject)localObject1).toString();
        paramBaseRuntime.getJsService().evaluateCallbackJs(paramShareState.shareCallbackId, (String)localObject1);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label186;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 1);
      localObject1 = localObject2;
      continue;
      label186:
      QMLog.e("Action", "on forward qzone click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label201:
      localObject1 = "";
    }
    paramBaseRuntime.getJsService().evaluateSubscribeJS(localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    return;
    label229:
    QMLog.e("Action", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void handleForwardWeChatFriends(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = "onShareAppMessage";
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
        {
          String str = "showActionSheet";
          localObject = str;
          if (paramShareState.tapIndexMap != null)
          {
            localJSONObject.put("tapIndex", paramShareState.tapIndexMap.get("tapIndexWX"));
            localObject = str;
          }
          if ((!paramBaseRuntime.isMiniGame()) && (getCurrPage(paramBaseRuntime) != null)) {
            localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
          }
          paramShareState.fromShareMenuBtn = 3;
          if (paramBaseRuntime.getJsService() == null) {
            break label191;
          }
          if (paramShareState.launchFrom != 1) {
            break;
          }
          localObject = ApiUtil.wrapCallbackOk((String)localObject, localJSONObject);
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).toString();
            paramBaseRuntime.getJsService().evaluateCallbackJs(paramShareState.shareCallbackId, (String)localObject);
          }
        }
        else
        {
          localJSONObject.put("fromShareButton", 0);
          localJSONObject.put("shareTarget", 3);
          continue;
        }
        localObject = "";
      }
      catch (JSONException paramBaseRuntime)
      {
        QMLog.e("Action", "on forward wechat friends click exception ", paramBaseRuntime);
        return;
      }
    }
    paramBaseRuntime.getJsService().evaluateSubscribeJS((String)localObject, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    return;
    label191:
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
        if (paramBaseRuntime.getJsService() == null) {
          break label229;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        localObject1 = ApiUtil.wrapCallbackOk((String)localObject2, localJSONObject);
        if (localObject1 == null) {
          break label201;
        }
        localObject1 = ((JSONObject)localObject1).toString();
        paramBaseRuntime.getJsService().evaluateCallbackJs(paramShareState.shareCallbackId, (String)localObject1);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label186;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 4);
      localObject1 = localObject2;
      continue;
      label186:
      QMLog.e("Action", "on forward wechat moment exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label201:
      localObject1 = "";
    }
    paramBaseRuntime.getJsService().evaluateSubscribeJS(localObject3, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    return;
    label229:
    QMLog.e("Action", "on forward wechat moments click exception js service==null");
  }
  
  private void handleShareChatDirectly(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    if (this.data == null) {
      return;
    }
    Object localObject2 = this.data.getString("key_mini_app_share_chat_uin");
    int i = this.data.getInt("key_mini_app_share_chat_type");
    Object localObject1 = this.data.getString("key_mini_app_share_chat_name");
    long l2 = -1L;
    long l1 = l2;
    if (localObject2 != null) {}
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        l1 = Long.valueOf((String)localObject2).longValue();
        localShareChatModel = new ShareChatModel(i, l1, (String)localObject1);
        localJSONObject = new JSONObject();
        localObject2 = "onShareAppMessage";
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        ShareChatModel localShareChatModel;
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
            localJSONObject.put("tapIndex", -1);
            localObject1 = "showActionSheet";
          }
        }
        catch (JSONException localJSONException1) {}
        try
        {
          if ((!paramBaseRuntime.isMiniGame()) && (getCurrPage(paramBaseRuntime) != null)) {
            localJSONObject.put("webViewUrl", getCurrPage(paramBaseRuntime));
          }
          localJSONObject.put("chatDataHash", localShareChatModel.getEntryHash());
          paramShareState.fromShareMenuBtn = 0;
          paramShareState.shareChatModel = localShareChatModel;
          if (paramBaseRuntime.getJsService() == null) {
            break label337;
          }
          if (paramShareState.launchFrom != 1) {
            break;
          }
          localObject1 = ApiUtil.wrapCallbackOk((String)localObject1, localJSONObject);
          if (localObject1 == null) {
            break label308;
          }
          localObject1 = ((JSONObject)localObject1).toString();
          paramBaseRuntime.getJsService().evaluateCallbackJs(paramShareState.shareCallbackId, (String)localObject1);
          return;
        }
        catch (JSONException localJSONException2)
        {
          break label296;
        }
        localThrowable = localThrowable;
        QMLog.e("Action", "handleShareChatDirectly get an exception ", localThrowable);
        l1 = l2;
        continue;
        localObject1 = localThrowable;
        localJSONObject.put("fromShareButton", 0);
        localObject1 = localThrowable;
        localJSONObject.put("shareTarget", 5);
        localObject1 = localThrowable;
        continue;
      }
      label296:
      QMLog.e("Action", "on forward directly click exception ", localJSONException1);
      continue;
      label308:
      localObject1 = "";
    }
    paramBaseRuntime.getJsService().evaluateSubscribeJS((String)localObject1, localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
    return;
    label337:
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
      paramShareState.fromShareMenuBtn = paramInt;
      if (paramBaseRuntime.getJsService() != null)
      {
        paramBaseRuntime.getJsService().evaluateSubscribeJS("onShareAppMessage", localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("Action", "on forward wechat moment exception ", localJSONException);
      }
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
      if (this.data == null)
      {
        QMLog.e("Action", "Failed to share to other, data is null");
        return Boolean.valueOf(false);
      }
      handleShareOther(paramBaseRuntime, localShareState, this.data.getInt("key_share_item_id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.ShareAction
 * JD-Core Version:    0.7.0.1
 */