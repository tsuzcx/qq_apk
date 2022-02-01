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
    Object localObject1 = GameLog.getInstance();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateBaseLib response. isSuc=");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(" rsp=");
    ((StringBuilder)localObject2).append(paramJSONObject);
    ((GameLog)localObject1).i("GameEnvManager[MiniEng]", ((StringBuilder)localObject2).toString());
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(2)));
      localObject1 = GameLog.getInstance();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("targetInfo ");
      ((StringBuilder)localObject2).append(paramJSONObject);
      ((GameLog)localObject1).i("GameEnvManager[MiniEng]", ((StringBuilder)localObject2).toString());
      localObject1 = EnginePackageManager.access$000(paramJSONObject);
      if (EnginePackageManager.access$100((Version)localObject1))
      {
        localObject2 = GameLog.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[安装小游戏新版本so] 开始下载线上最新版本:");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramJSONObject.baseLibUrl);
        ((GameLog)localObject2).i("GameEnvManager[MiniEng]", localStringBuilder.toString());
        EnginePackageManager.access$200(paramJSONObject, (Version)localObject1);
        return;
      }
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 版本检测失败, 本地已有更新版本");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.EnginePackageManager.1.1
 * JD-Core Version:    0.7.0.1
 */