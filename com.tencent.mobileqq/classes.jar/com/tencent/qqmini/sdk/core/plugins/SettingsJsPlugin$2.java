package com.tencent.qqmini.sdk.core.plugins;

import bdde;
import bddn;
import bddp;
import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import java.util.List;

class SettingsJsPlugin$2
  implements ChannelProxy.AuthListResult
{
  SettingsJsPlugin$2(SettingsJsPlugin paramSettingsJsPlugin, bdde parambdde, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, List<bddn> paramList, List<bddp> paramList1)
  {
    if (paramBoolean)
    {
      this.val$authorizeCenter.a(paramList, paramList1);
      this.val$authorizeCenter.a();
      SettingsJsPlugin.access$100(this.this$0, this.val$authorizeCenter, this.val$req);
      return;
    }
    bdnw.d("SettingsJsPlugin", "getSetting-getAuthStateList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SettingsJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */