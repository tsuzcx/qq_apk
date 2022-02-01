package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BaseLibManager$2$1
  implements MiniAppCmdInterface
{
  BaseLibManager$2$1(BaseLibManager.2 param2, String paramString1, String paramString2) {}
  
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
      ThreadManagerV2.executeOnFileThread(new BaseLibManager.2.1.1(this, paramJSONObject));
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
        this.this$1.this$0.doDownloadBaselib((String)localObject, paramJSONObject, this.val$baseLibUrl, this.val$baseLibVersion, null);
        paramJSONObject = AppBrandProxy.g().getMiniAppConfig();
        if ((paramJSONObject != null) && (paramJSONObject.config != null) && (!TextUtils.isEmpty(paramJSONObject.config.appId))) {
          MiniAppStartState.setBaseLibDownload(paramJSONObject.config.appId, false);
        }
      }
      else
      {
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib, no update");
        BaseLibManager.access$200(this.this$1.this$0, 1);
        paramJSONObject = AppBrandProxy.g().getMiniAppConfig();
        if ((paramJSONObject != null) && (paramJSONObject.config != null) && (!TextUtils.isEmpty(paramJSONObject.config.appId))) {
          MiniAppStartState.setBaseLibDownload(paramJSONObject.config.appId, true);
        }
      }
    }
    else
    {
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib failed!");
      BaseLibManager.access$200(this.this$1.this$0, 1100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.2.1
 * JD-Core Version:    0.7.0.1
 */