package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class CustomButtonPlugin
  extends BaseJsPlugin
{
  private static final String API_OPERATE_CUSTOM_BUTTON = "operateCustomButton";
  private static final String COMPONENT_ID = "compId";
  private static final String LANG = "lang";
  private static final String ON_CUSTOM_BUTTON_CLICK = "onCustomButtonTap";
  private static final String OPERATE_CREATE = "create";
  private static final String OPERATE_DESTROY = "destroy";
  private static final String OPERATE_HIDE = "hide";
  private static final String OPERATE_SHOW = "show";
  private static final String OPERATE_TYPE = "operateType";
  private static final String OPERATE_UPDATE = "update";
  private static final String TAG = "CustomButtonPlugin";
  private static final String WITH_CREDENTIALS = "withCredentials";
  
  private void handleButtonClick(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("compId", paramJSONObject.opt("compId"));
      localJSONObject.put("withCredentials", paramJSONObject.opt("withCredentials"));
      localJSONObject.put("lang", paramJSONObject.opt("lang"));
      sendSubscribeEvent("onCustomButtonTap", localJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QMLog.e("CustomButtonPlugin", "onClick callback exception", paramJSONObject);
    }
  }
  
  @JsEvent({"operateCustomButton"})
  public String operateCustomButton(RequestEvent paramRequestEvent)
  {
    if (!TextUtils.isEmpty(paramRequestEvent.jsonParams)) {
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        localObject2 = ((JSONObject)localObject1).optString("operateType");
        long l = ((JSONObject)localObject1).optLong("compId");
        boolean bool = false;
        if ("create".equals(localObject2)) {
          bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("create", l, (JSONObject)localObject1, new CustomButtonPlugin.1(this, (JSONObject)localObject1));
        } else if ("show".equals(localObject2)) {
          bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("show", l, (JSONObject)localObject1, new CustomButtonPlugin.2(this, (JSONObject)localObject1));
        } else if ("hide".equals(localObject2)) {
          bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("hide", l, (JSONObject)localObject1, null);
        } else if ("destroy".equals(localObject2)) {
          bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("destroy", l, (JSONObject)localObject1, null);
        } else if ("update".equals(localObject2)) {
          bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("update", l, (JSONObject)localObject1, new CustomButtonPlugin.3(this, (JSONObject)localObject1));
        }
        if (bool) {
          return paramRequestEvent.ok();
        }
        localObject1 = paramRequestEvent.fail("button not found");
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramRequestEvent.event);
        ((StringBuilder)localObject2).append(" parse json exception ");
        ((StringBuilder)localObject2).append(paramRequestEvent.jsonParams);
        QMLog.e("CustomButtonPlugin", ((StringBuilder)localObject2).toString(), localJSONException);
        return paramRequestEvent.fail("json parse error");
      }
    }
    return paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.CustomButtonPlugin
 * JD-Core Version:    0.7.0.1
 */