package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONObject;

public class ServiceEvaluateCallbackAction
  implements Action<String>
{
  private int mCallbackId = -1;
  private IMiniAppContext mMiniAppContext;
  private JSONObject mRet;
  
  public static ServiceEvaluateCallbackAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    ServiceEvaluateCallbackAction localServiceEvaluateCallbackAction = new ServiceEvaluateCallbackAction();
    localServiceEvaluateCallbackAction.mMiniAppContext = paramIMiniAppContext;
    return localServiceEvaluateCallbackAction;
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    this.mRet = ApiUtil.wrapCallbackFail(paramString, paramJSONObject);
    this.mCallbackId = paramInt;
    this.mMiniAppContext.performAction(this);
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    this.mRet = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
    this.mCallbackId = paramInt;
    this.mMiniAppContext.performAction(this);
  }
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getJsService();
    if (paramBaseRuntime != null) {
      paramBaseRuntime.evaluateCallbackJs(this.mCallbackId, this.mRet.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.ServiceEvaluateCallbackAction
 * JD-Core Version:    0.7.0.1
 */