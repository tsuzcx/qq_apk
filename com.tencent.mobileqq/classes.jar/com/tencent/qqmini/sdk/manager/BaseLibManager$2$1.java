package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class BaseLibManager$2$1
  implements AsyncResult
{
  BaseLibManager$2$1(BaseLibManager.2 param2, String paramString1, String paramString2) {}
  
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
      ThreadManager.executeOnDiskIOThreadPool(new BaseLibManager.2.1.1(this, paramJSONObject));
      localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (BaseLibManager.access$300(this.c.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] updateBaseLib end : version : ");
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append("; url : ");
        localStringBuilder.append((String)localObject);
        QMLog.i("miniapp-process_BaseLibManager", localStringBuilder.toString());
        this.c.this$0.doDownloadBaselib((String)localObject, paramJSONObject, this.b, this.a, this.c.val$listener);
        return;
      }
      QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
      if (this.c.val$listener != null) {
        this.c.val$listener.onUpdateResult(1);
      }
    }
    else
    {
      QMLog.e("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
      if (this.c.val$listener != null) {
        this.c.val$listener.onUpdateResult(1100);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.2.1
 * JD-Core Version:    0.7.0.1
 */