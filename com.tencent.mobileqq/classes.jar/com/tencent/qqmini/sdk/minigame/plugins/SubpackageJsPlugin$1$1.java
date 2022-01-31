package com.tencent.qqmini.sdk.minigame.plugins;

import bghn;
import bgkd;
import bgwc;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import org.json.JSONException;
import org.json.JSONObject;

class SubpackageJsPlugin$1$1
  implements Runnable
{
  SubpackageJsPlugin$1$1(SubpackageJsPlugin.1 param1, int paramInt, String paramString1, String paramString2, IGameLauncher paramIGameLauncher) {}
  
  public void run()
  {
    bgwc.a().i("SubpackageJsPlugin", "loadSubPackage callback onInitGpkgInfo on JSThread, resCode:" + this.val$resCode + ", dirPath:" + this.val$dirPath + ", error msg=" + this.val$errorMsg);
    Object localObject;
    if (this.val$resCode != 0)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("taskId", this.this$1.val$loadTaskId);
        ((JSONObject)localObject).put("state", "fail");
        this.this$1.val$req.a.a("onLoadSubPackageTaskStateChange", ((JSONObject)localObject).toString(), -1);
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
        localJSONObject.put("taskId", this.this$1.val$loadTaskId);
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
      bgwc.a().e("SubpackageJsPlugin", "loadSubpackage loadFinish success? " + bool);
      this.this$1.val$req.a.a("onLoadSubPackageTaskStateChange", localJSONObject.toString(), -1);
      return;
      localObject = "fail";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */