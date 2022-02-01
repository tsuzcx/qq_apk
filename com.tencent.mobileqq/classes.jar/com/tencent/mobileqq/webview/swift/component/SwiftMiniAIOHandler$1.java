package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.utils.WebViewJumpUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

class SwiftMiniAIOHandler$1
  implements MiniMsgUser.IMiniMsgActionCallback
{
  SwiftMiniAIOHandler$1(SwiftMiniAIOHandler paramSwiftMiniAIOHandler) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      localJSONObject.put("options", paramJSONObject);
      paramString = new StringBuilder();
      paramString.append("javascript:mqq.dispatchEvent(\"miniAIOEvent\",");
      paramString.append(localJSONObject.toString());
      paramString.append(");");
      paramString = paramString.toString();
      ((TouchWebView)this.a.b.a()).callJs(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("SwiftMiniAIOHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void onFromMiniAIOToAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftMiniAIOHandler", 2, "onFromMiniAIOToAIO ");
    }
    a("fromMiniAIOToAIO", new JSONObject());
  }
  
  public void onGoToConversation()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftMiniAIOHandler", 2, "onGoToConversation ");
      }
      a("returnMsgList", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("SwiftMiniAIOHandler", 1, localException, new Object[0]);
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (this.a.a == null) {
      return;
    }
    SwiftMiniAIOHandler localSwiftMiniAIOHandler = this.a;
    Object localObject2 = localSwiftMiniAIOHandler.c();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localSwiftMiniAIOHandler.b.a().getTitle();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!"‎".equals(localObject1)) {}
    }
    else
    {
      localObject2 = HardCodeUtil.a(2131913812);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    localObject2 = this.a.a.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = WebViewJumpUtils.a((Bundle)localObject1, localSwiftMiniAIOHandler.b.c());
    WebViewJumpUtils.a(((MiniMsgUserParam)localObject2).backConversationIntent);
    try
    {
      a("entryClicked", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("SwiftMiniAIOHandler", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftMiniAIOHandler.1
 * JD-Core Version:    0.7.0.1
 */