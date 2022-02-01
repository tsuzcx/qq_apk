package com.tencent.qqmini.sdk.launcher.core.model;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONObject;

public class RequestEvent
{
  public int callbackId;
  public String event;
  public IJsService jsService;
  public String jsonParams;
  
  public String cancel()
  {
    return cancel(null);
  }
  
  public String cancel(JSONObject paramJSONObject)
  {
    paramJSONObject = ApiUtil.wrapCallbackCancel(this.event, paramJSONObject).toString();
    evaluateCallbackJs(paramJSONObject);
    return paramJSONObject;
  }
  
  public void evaluateCallbackJs(String paramString)
  {
    if (this.jsService != null) {
      this.jsService.evaluateCallbackJs(this.callbackId, paramString);
    }
  }
  
  public String fail()
  {
    return fail(null);
  }
  
  public String fail(String paramString)
  {
    return fail(null, paramString);
  }
  
  public String fail(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = ApiUtil.wrapCallbackFail(this.event, paramJSONObject, paramString).toString();
    evaluateCallbackJs(paramJSONObject);
    return paramJSONObject;
  }
  
  public String ok()
  {
    return ok(null);
  }
  
  public String ok(JSONObject paramJSONObject)
  {
    paramJSONObject = ApiUtil.wrapCallbackOk(this.event, paramJSONObject).toString();
    evaluateCallbackJs(paramJSONObject);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.RequestEvent
 * JD-Core Version:    0.7.0.1
 */