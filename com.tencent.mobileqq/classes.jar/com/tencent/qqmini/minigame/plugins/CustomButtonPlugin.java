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
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        String str = ((JSONObject)localObject).optString("operateType");
        long l = ((JSONObject)localObject).optLong("compId");
        boolean bool = false;
        if ("create".equals(str)) {
          bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("create", l, (JSONObject)localObject, new CustomButtonPlugin.1(this, (JSONObject)localObject));
        }
        while (bool)
        {
          return paramRequestEvent.ok();
          if ("show".equals(str)) {
            bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("show", l, (JSONObject)localObject, new CustomButtonPlugin.2(this, (JSONObject)localObject));
          } else if ("hide".equals(str)) {
            bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("hide", l, (JSONObject)localObject, null);
          } else if ("destroy".equals(str)) {
            bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("destroy", l, (JSONObject)localObject, null);
          } else if ("update".equals(str)) {
            bool = OperateCustomButton.obtain(this.mMiniAppContext).operate("update", l, (JSONObject)localObject, new CustomButtonPlugin.3(this, (JSONObject)localObject));
          }
        }
        localObject = paramRequestEvent.fail("button not found");
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("CustomButtonPlugin", paramRequestEvent.event + " parse json exception " + paramRequestEvent.jsonParams, localJSONException);
        return paramRequestEvent.fail("json parse error");
      }
    }
    return paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.CustomButtonPlugin
 * JD-Core Version:    0.7.0.1
 */