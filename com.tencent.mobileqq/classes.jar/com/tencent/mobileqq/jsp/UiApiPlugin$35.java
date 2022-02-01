package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UiApiPlugin$35
  implements MiniMsgUser.IMiniMsgActionCallback
{
  UiApiPlugin$35(UiApiPlugin paramUiApiPlugin) {}
  
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
    WebViewFragment localWebViewFragment = (WebViewFragment)this.a.mRuntime.a();
    Object localObject1 = localWebViewFragment.mKeyWording;
    if (TextUtils.isEmpty(localWebViewFragment.mKeyWording)) {
      localObject1 = localWebViewFragment.webView.getTitle();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!"‎".equals(localObject1)) {}
    }
    else
    {
      localObject2 = HardCodeUtil.a(2131715703);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    Object localObject2 = this.a.a.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = localWebViewFragment.generateGoToConversation((Bundle)localObject1);
    SwiftWebViewUtils.a(((MiniMsgUserParam)localObject2).backConversationIntent);
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
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.35
 * JD-Core Version:    0.7.0.1
 */