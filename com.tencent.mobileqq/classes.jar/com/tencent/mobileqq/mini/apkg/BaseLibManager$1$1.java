package com.tencent.mobileqq.mini.apkg;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BaseLibManager$1$1
  implements MiniAppCmdInterface
{
  BaseLibManager$1$1(BaseLibManager.1 param1, String paramString1, String paramString2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng] updateBaseLib response. isSuc=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" rsp=");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (paramJSONObject != null))
    {
      ThreadManagerV2.executeOnFileThread(new BaseLibManager.1.1.1(this, paramJSONObject));
      localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (BaseLibManager.access$000(this.this$1.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] updateBaseLib end : version : ");
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append("; url : ");
        localStringBuilder.append((String)localObject);
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, localStringBuilder.toString());
        this.this$1.this$0.doDownloadBaselib((String)localObject, paramJSONObject, this.val$baseLibUrl, this.val$baseLibVersion, this.this$1.val$listener);
        return;
      }
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib, no update");
      if (this.this$1.val$listener != null) {
        this.this$1.val$listener.onUpdateResult(1);
      }
    }
    else
    {
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib failed!");
      if (this.this$1.val$listener != null) {
        this.this$1.val$listener.onUpdateResult(1100);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.1.1
 * JD-Core Version:    0.7.0.1
 */