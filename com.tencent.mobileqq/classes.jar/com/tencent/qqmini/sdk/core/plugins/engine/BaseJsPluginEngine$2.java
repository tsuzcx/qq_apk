package com.tencent.qqmini.sdk.core.plugins.engine;

import behv;
import behw;
import beif;
import beih;
import bekr;
import betc;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import java.util.List;

class BaseJsPluginEngine$2
  implements ChannelProxy.AuthListResult
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, behw parambehw, String paramString1, String paramString2, bekr parambekr) {}
  
  public void onReceiveResult(boolean paramBoolean, List<beif> paramList, List<beih> paramList1)
  {
    if (paramBoolean)
    {
      this.val$authState.a(paramList, paramList1);
      this.val$authState.a();
      paramBoolean = this.val$authState.a(this.val$scope);
      if (behv.a(this.val$appId)) {
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
    betc.d("JsPluginEngine[AuthGuard]", "getSetting-getAuthStateList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */