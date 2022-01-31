package com.tencent.mobileqq.mini.apkg;

import bbfj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.tissue.TissueWnsConfig;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BaseLibManager$2$1$1
  implements Runnable
{
  BaseLibManager$2$1$1(BaseLibManager.2.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON(this.val$obj.optJSONObject(BaseLibInfo.getKey(2)));
    JSONObject localJSONObject = this.val$obj.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(localJSONObject);
    boolean bool = bbfj.h(BaseApplicationImpl.getApplication());
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] gameEngineLib " + localBaseLibInfo1 + ", miniAppEnginLib " + localJSONObject + " isWifi:" + bool);
    if (localBaseLibInfo1 != null) {
      EngineManager.g().installBaseLib(localBaseLibInfo1, null);
    }
    if (localBaseLibInfo2 != null)
    {
      localBaseLibInfo2.updateFor64IfNeed();
      EngineManager.g().installBaseLib(localBaseLibInfo2, null);
    }
    localBaseLibInfo1 = TissueWnsConfig.getBaseLibInfo();
    if (localBaseLibInfo1 != null) {
      EngineManager.g().installBaseLib(localBaseLibInfo1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.2.1.1
 * JD-Core Version:    0.7.0.1
 */