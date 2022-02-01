package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class BaseLibManager$3
  implements AsyncResult
{
  BaseLibManager$3(BaseLibManager paramBaseLibManager, String paramString1, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng] updateBaseLib response. isSuc=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" rsp=");
    ((StringBuilder)localObject).append(paramJSONObject);
    QMLog.i("miniapp-process_BaseLibManager", ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (paramJSONObject != null))
    {
      ThreadManager.executeOnDiskIOThreadPool(new BaseLibManager.3.1(this, paramJSONObject));
      localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (BaseLibManager.access$300(this.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] updateBaseLib end : version : ");
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append("; url : ");
        localStringBuilder.append((String)localObject);
        QMLog.i("miniapp-process_BaseLibManager", localStringBuilder.toString());
        this.this$0.doDownloadBaselib((String)localObject, paramJSONObject, this.val$baseLibUrl, this.val$baseLibVersion, null);
        return;
      }
      QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
      BaseLibManager.access$400(this.this$0, 1);
      return;
    }
    QMLog.e("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
    BaseLibManager.access$400(this.this$0, 1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.3
 * JD-Core Version:    0.7.0.1
 */