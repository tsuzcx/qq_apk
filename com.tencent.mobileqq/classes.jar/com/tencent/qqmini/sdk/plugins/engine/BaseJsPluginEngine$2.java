package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import java.util.List;
import org.json.JSONObject;

class BaseJsPluginEngine$2
  implements AsyncResult
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, boolean paramBoolean1, List paramList1, List paramList2, List paramList3, boolean paramBoolean2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (BaseJsPluginEngine.access$100(this.this$0) != null))
    {
      if (this.val$isConfirm)
      {
        paramJSONObject = this.this$0;
        paramJSONObject.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$100(paramJSONObject), this.val$allSubMsg, this.val$subMsgNoMaintainAuth, this.val$subMsgIgnoreAuth, false);
        this.this$0.authDialog = null;
        return;
      }
      if (this.val$isRefuse)
      {
        paramJSONObject = this.this$0;
        paramJSONObject.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$100(paramJSONObject), this.val$allSubMsg, this.val$subMsgNoMaintainAuth, this.val$subMsgIgnoreAuth, true);
        this.this$0.authDialog = null;
        return;
      }
      paramJSONObject = this.this$0;
      paramJSONObject.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$100(paramJSONObject), this.val$allSubMsg);
      this.this$0.authDialog = null;
      return;
    }
    if (BaseJsPluginEngine.access$100(this.this$0) != null)
    {
      paramJSONObject = this.this$0;
      paramJSONObject.onceSubMsgCallbackFail(BaseJsPluginEngine.access$100(paramJSONObject), "Request subscribe fail", 10003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */