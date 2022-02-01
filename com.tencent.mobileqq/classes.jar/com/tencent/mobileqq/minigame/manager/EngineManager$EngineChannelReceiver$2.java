package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class EngineManager$EngineChannelReceiver$2
  implements MiniAppCmdInterface
{
  EngineManager$EngineChannelReceiver$2(EngineManager.EngineChannelReceiver paramEngineChannelReceiver, int paramInt, EngineChannel paramEngineChannel) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.i("EngineManager", 1, "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(this.val$baseLibType)));
      QLog.i("EngineManager", 1, "[MiniEng] engineLibInfo " + paramJSONObject);
      EngineManager.access$300(this.this$1.this$0, paramJSONObject, this.val$remote);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver.2
 * JD-Core Version:    0.7.0.1
 */