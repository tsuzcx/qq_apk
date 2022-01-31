package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class SubpackageJsPlugin$3$1
  implements Runnable
{
  SubpackageJsPlugin$3$1(SubpackageJsPlugin.3 param3, int paramInt, String paramString1, String paramString2, IGameLauncher paramIGameLauncher) {}
  
  public void run()
  {
    JsRuntime localJsRuntime = (JsRuntime)this.this$1.val$webviewRef.get();
    if (localJsRuntime == null) {
      return;
    }
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubPackage callback onInitGpkgInfo on JSThread, resCode:" + this.val$resCode + ", dirPath:" + this.val$dirPath + ", error msg=" + this.val$errorMsg);
    Object localObject;
    if (this.val$resCode != 0)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("taskId", this.this$1.val$taskId);
        ((JSONObject)localObject).put("state", "fail");
        localJsRuntime.evaluateSubcribeJS("onLoadSubPackageTaskStateChange", ((JSONObject)localObject).toString(), -1);
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    boolean bool = this.val$gameLauncher.launchSubpackage(this.val$dirPath);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("taskId", this.this$1.val$taskId);
        if (!bool) {
          continue;
        }
        localObject = "success";
        localJSONObject.put("state", localObject);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      GameLog.getInstance().e("SubpackageJsPlugin", "loadSubpackage loadFinish success? " + bool);
      localJsRuntime.evaluateSubcribeJS("onLoadSubPackageTaskStateChange", localJSONObject.toString(), -1);
      return;
      localObject = "fail";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */