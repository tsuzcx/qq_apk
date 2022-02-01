package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class BaseLibManager$2$1$1
  implements Runnable
{
  BaseLibManager$2$1$1(BaseLibManager.2.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(this.a.optJSONObject(BaseLibInfo.getKey(2)));
    Object localObject = this.a.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON((JSONObject)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] gameEngineLib ");
    localStringBuilder.append(localBaseLibInfo2);
    localStringBuilder.append(", miniAppEnginLib ");
    localStringBuilder.append(localObject);
    QMLog.i("miniapp-process_BaseLibManager", localStringBuilder.toString());
    if ((TextUtils.isEmpty(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getSoPath())) || (!"1.29.0.00002".equals(this.b.a)))
    {
      if (!LocalGameEngine.g().isWnsConfigModel())
      {
        if (localBaseLibInfo2 != null) {
          EngineManager.g().installBaseLib(localBaseLibInfo2, null);
        }
      }
      else
      {
        localBaseLibInfo2 = BaseLibManager.getGameBaseLibInfo();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[MiniEng]MiniEng QQSpeed gameEngineLib ");
        ((StringBuilder)localObject).append(localBaseLibInfo2);
        QMLog.i("miniapp-process_BaseLibManager", ((StringBuilder)localObject).toString());
        if ((localBaseLibInfo2 != null) && (localBaseLibInfo2.baseLibType == 2)) {
          EngineManager.g().installBaseLib(localBaseLibInfo2, null);
        }
      }
      if (localBaseLibInfo1 != null) {
        EngineManager.g().installBaseLib(localBaseLibInfo1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.2.1.1
 * JD-Core Version:    0.7.0.1
 */