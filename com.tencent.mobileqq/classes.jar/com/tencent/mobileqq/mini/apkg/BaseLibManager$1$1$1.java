package com.tencent.mobileqq.mini.apkg;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.manager.LocalGameEngine;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BaseLibManager$1$1$1
  implements Runnable
{
  BaseLibManager$1$1$1(BaseLibManager.1.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(this.val$obj.optJSONObject(BaseLibInfo.getKey(2)));
    Object localObject = this.val$obj.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON((JSONObject)localObject);
    boolean bool = NetworkUtil.isWifiConnected(BaseApplicationImpl.getApplication());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] gameEngineLib ");
    localStringBuilder.append(localBaseLibInfo2);
    localStringBuilder.append(", miniAppEnginLib ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(" isWifi:");
    localStringBuilder.append(bool);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, localStringBuilder.toString());
    if (!LocalGameEngine.g().isWnsConfigModel())
    {
      if (localBaseLibInfo2 != null) {
        EngineManager.g().installBaseLib(localBaseLibInfo2, null);
      }
    }
    else
    {
      localBaseLibInfo2 = GameWnsUtils.getGameBaseLibInfo();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[MiniEng]MiniEng QQSpeed gameEngineLib ");
      ((StringBuilder)localObject).append(localBaseLibInfo2);
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, ((StringBuilder)localObject).toString());
      if ((localBaseLibInfo2 != null) && (localBaseLibInfo2.baseLibType == 2)) {
        EngineManager.g().installBaseLib(localBaseLibInfo2, null);
      }
    }
    if (localBaseLibInfo1 != null) {
      EngineManager.g().installBaseLib(localBaseLibInfo1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */