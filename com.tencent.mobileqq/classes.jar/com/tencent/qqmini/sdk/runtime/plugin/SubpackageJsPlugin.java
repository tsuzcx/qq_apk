package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import bgop;
import bgvi;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class SubpackageJsPlugin
  extends BaseJsPlugin
{
  public static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
  public static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
  private static final String TAG = "SubpackageJsPlugin";
  private AtomicInteger subpackageTaskId = new AtomicInteger(0);
  
  public String createLoadSubPackageTask(bgok parambgok)
  {
    try
    {
      String str = new JSONObject(parambgok.b).optString("moduleName");
      int i = this.subpackageTaskId.getAndIncrement();
      JSONObject localJSONObject = new JSONObject();
      bgvi.a().a(this.mApkgInfo, this.mMiniAppInfo, str, new SubpackageJsPlugin.1(this, i, str, parambgok));
      localJSONObject.put("loadTaskId", i);
      str = bgop.a(parambgok.a, localJSONObject).toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return bgop.b(parambgok.a, new JSONObject()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */