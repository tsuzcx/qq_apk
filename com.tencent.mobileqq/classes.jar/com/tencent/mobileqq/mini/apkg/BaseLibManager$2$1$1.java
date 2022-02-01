package com.tencent.mobileqq.mini.apkg;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.tissue.TissueWnsConfig;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.utils.NetworkUtil;
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
    boolean bool = NetworkUtil.isWifiConnected(BaseApplicationImpl.getApplication());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] gameEngineLib ");
    localStringBuilder.append(localBaseLibInfo1);
    localStringBuilder.append(", miniAppEnginLib ");
    localStringBuilder.append(localJSONObject);
    localStringBuilder.append(" isWifi:");
    localStringBuilder.append(bool);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.2.1.1
 * JD-Core Version:    0.7.0.1
 */