package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

class SwiftBrowserShareMenuHandler$6
  implements ITroopMemberApiClientApi.Callback
{
  SwiftBrowserShareMenuHandler$6(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("fontSize", 1);
    QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "adjustFontSize curFontSizeIndex=", Integer.valueOf(this.a.w), " globalFontSizeIndex=", Integer.valueOf(i) });
    if (i != this.a.w)
    {
      paramBundle = this.a;
      paramBundle.w = i;
      paramBundle.b(paramBundle.w);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.6
 * JD-Core Version:    0.7.0.1
 */