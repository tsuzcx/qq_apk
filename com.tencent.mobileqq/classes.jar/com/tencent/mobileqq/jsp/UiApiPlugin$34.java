package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftMiniAIOHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewJumpUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UiApiPlugin$34
  implements MiniMsgUser.IMiniMsgActionCallback
{
  UiApiPlugin$34(UiApiPlugin paramUiApiPlugin) {}
  
  public void onFromMiniAIOToAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "onFromMiniAIOToAIO ");
    }
    JSONObject localJSONObject = new JSONObject();
    this.a.a("fromMiniAIOToAIO", localJSONObject);
  }
  
  public void onGoToConversation()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "onGoToConversation ");
      }
      JSONObject localJSONObject = new JSONObject();
      this.a.a("returnMsgList", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    WebViewProvider localWebViewProvider = this.a.mRuntime.f();
    Object localObject2 = ((SwiftMiniAIOHandler)localWebViewProvider.getComponentProvider().a(256)).c();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localWebViewProvider.getWebView().getTitle();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!"‎".equals(localObject1)) {}
    }
    else
    {
      localObject2 = HardCodeUtil.a(2131913099);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    localObject2 = this.a.U.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = WebViewJumpUtils.a((Bundle)localObject1, localWebViewProvider);
    WebViewJumpUtils.a(((MiniMsgUserParam)localObject2).backConversationIntent);
    try
    {
      localObject1 = new JSONObject();
      this.a.a("entryClicked", (JSONObject)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.34
 * JD-Core Version:    0.7.0.1
 */