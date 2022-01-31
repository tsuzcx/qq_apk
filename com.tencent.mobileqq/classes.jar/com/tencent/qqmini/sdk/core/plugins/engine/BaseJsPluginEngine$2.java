package com.tencent.qqmini.sdk.core.plugins.engine;

import bddd;
import bdde;
import bddn;
import bddp;
import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import java.util.List;

class BaseJsPluginEngine$2
  implements ChannelProxy.AuthListResult
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, bdde parambdde, String paramString1, String paramString2, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, List<bddn> paramList, List<bddp> paramList1)
  {
    if (paramBoolean)
    {
      this.val$authState.a(paramList, paramList1);
      this.val$authState.a();
      paramBoolean = this.val$authState.a(this.val$scope);
      if (bddd.a(this.val$appId)) {
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
    bdnw.d("JsPluginEngine[AuthGuard]", "getSetting-getAuthStateList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */