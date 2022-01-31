package com.tencent.qqmini.sdk.minigame.plugins;

import bgkd;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class GameDataJsPlugin$1
  implements AsyncResult
{
  GameDataJsPlugin$1(GameDataJsPlugin paramGameDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.a(paramJSONObject);
      return;
    }
    this.val$req.a(paramJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.GameDataJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */