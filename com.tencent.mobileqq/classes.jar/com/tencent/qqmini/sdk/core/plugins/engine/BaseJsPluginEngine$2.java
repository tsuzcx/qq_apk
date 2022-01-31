package com.tencent.qqmini.sdk.core.plugins.engine;

import behe;
import behf;
import beho;
import behq;
import beka;
import besl;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import java.util.List;

class BaseJsPluginEngine$2
  implements ChannelProxy.AuthListResult
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, behf parambehf, String paramString1, String paramString2, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, List<beho> paramList, List<behq> paramList1)
  {
    if (paramBoolean)
    {
      this.val$authState.a(paramList, paramList1);
      this.val$authState.a();
      paramBoolean = this.val$authState.a(this.val$scope);
      if (behe.a(this.val$appId)) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        this.val$req.a();
        return;
      }
      BaseJsPluginEngine.access$300(this.this$0, this.val$req, this.val$scope);
      return;
    }
    besl.d("JsPluginEngine[AuthGuard]", "getSetting-getAuthStateList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */