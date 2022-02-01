package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class EngineManager$EngineChannelReceiver$3
  implements MiniAppCmdInterface
{
  EngineManager$EngineChannelReceiver$3(EngineManager.EngineChannelReceiver paramEngineChannelReceiver, int paramInt, EngineChannel paramEngineChannel) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] updateBaseLib response. isSuc=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" rsp=");
    localStringBuilder.append(paramJSONObject);
    QLog.i("EngineManager", 1, localStringBuilder.toString());
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(this.val$baseLibType)));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] engineLibInfo ");
      localStringBuilder.append(paramJSONObject);
      QLog.i("EngineManager", 1, localStringBuilder.toString());
      EngineManager.access$400(this.this$1.this$0, paramJSONObject, this.val$remote);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver.3
 * JD-Core Version:    0.7.0.1
 */