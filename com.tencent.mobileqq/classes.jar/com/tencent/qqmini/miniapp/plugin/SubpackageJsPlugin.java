package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.annotation.Restriction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@JsPlugin(restriction=Restriction.RESTRICT_TO_MINI_APP)
public class SubpackageJsPlugin
  extends BaseJsPlugin
{
  public static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
  public static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
  private static final String TAG = "SubpackageJsPlugin";
  private AtomicInteger subpackageTaskId = new AtomicInteger(0);
  
  @JsEvent({"createLoadSubPackageTask"})
  public String createLoadSubPackageTask(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("moduleName");
      int i = this.subpackageTaskId.getAndIncrement();
      JSONObject localJSONObject = new JSONObject();
      ApkgManager.getInstance().downloadSubPack(this.mApkgInfo, this.mMiniAppInfo, str, new SubpackageJsPlugin.1(this, i, str, paramRequestEvent));
      localJSONObject.put("loadTaskId", i);
      str = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, new JSONObject()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */