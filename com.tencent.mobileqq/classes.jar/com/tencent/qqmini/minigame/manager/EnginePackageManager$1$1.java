package com.tencent.qqmini.minigame.manager;

import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class EnginePackageManager$1$1
  implements AsyncResult
{
  EnginePackageManager$1$1(EnginePackageManager.1 param1) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(2)));
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "targetInfo " + paramJSONObject);
      Version localVersion = EnginePackageManager.access$000(paramJSONObject);
      if (EnginePackageManager.access$100(localVersion))
      {
        GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 开始下载线上最新版本:" + localVersion + ", " + paramJSONObject.baseLibUrl);
        EnginePackageManager.access$200(paramJSONObject, localVersion);
      }
    }
    else
    {
      return;
    }
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 版本检测失败, 本地已有更新版本");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.EnginePackageManager.1.1
 * JD-Core Version:    0.7.0.1
 */