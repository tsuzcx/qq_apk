package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class EngineManager$EngineChannelReceiver$3
  implements AsyncResult
{
  EngineManager$EngineChannelReceiver$3(EngineManager.EngineChannelReceiver paramEngineChannelReceiver, int paramInt, EngineChannel paramEngineChannel) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] updateBaseLib response. isSuc=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" rsp=");
    localStringBuilder.append(paramJSONObject);
    QMLog.i("EngineManager", localStringBuilder.toString());
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(this.val$baseLibType)));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] engineLibInfo ");
      localStringBuilder.append(paramJSONObject);
      QMLog.i("EngineManager", localStringBuilder.toString());
      EngineManager.access$500(this.this$1.this$0, paramJSONObject, this.val$remote);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver.3
 * JD-Core Version:    0.7.0.1
 */