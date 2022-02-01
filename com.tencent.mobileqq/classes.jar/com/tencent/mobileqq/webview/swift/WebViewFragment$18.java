package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class WebViewFragment$18
  implements MiniMsgUser.IMiniMsgActionCallback
{
  WebViewFragment$18(WebViewFragment paramWebViewFragment) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      localJSONObject.put("options", paramJSONObject);
      paramString = "javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + localJSONObject.toString() + ");";
      this.a.webView.callJs(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("WebLog_WebViewFragment", 1, paramString, new Object[0]);
    }
  }
  
  public void onFromMiniAIOToAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onFromMiniAIOToAIO ");
    }
    a("fromMiniAIOToAIO", new JSONObject());
  }
  
  public void onGoToConversation()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "onGoToConversation ");
      }
      a("returnMsgList", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WebLog_WebViewFragment", 1, localException, new Object[0]);
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (this.a.mMiniMsgUser == null) {
      return;
    }
    WebViewFragment localWebViewFragment = this.a;
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
      localObject2 = HardCodeUtil.a(2131716722);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    Object localObject2 = this.a.mMiniMsgUser.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = localWebViewFragment.generateGoToConversation((Bundle)localObject1);
    SwiftWebViewUtils.a(((MiniMsgUserParam)localObject2).backConversationIntent);
    try
    {
      a("entryClicked", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WebLog_WebViewFragment", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.18
 * JD-Core Version:    0.7.0.1
 */