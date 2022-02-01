package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;

class SwiftBrowserShareMenuHandler$2
  implements ITroopMemberApiClientApi.Callback
{
  SwiftBrowserShareMenuHandler$2(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getInt("type") == TroopAppObserver.c)
    {
      boolean bool = paramBundle.getBoolean("isSuccess");
      if ((this.a.d.isFinishing()) && (this.a.e.isDestroyed())) {
        return;
      }
      if (Boolean.valueOf(bool).booleanValue())
      {
        QQToast.makeText(BaseApplicationImpl.getApplication(), 2, 2131917370, 0).show(this.a.e.getWebTitleBarInterface().m());
        return;
      }
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, 2131917367, 0).show(this.a.e.getWebTitleBarInterface().m());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.2
 * JD-Core Version:    0.7.0.1
 */