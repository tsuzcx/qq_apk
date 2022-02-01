package com.tencent.qqmini.miniapp.widget;

import android.webkit.JavascriptInterface;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import org.json.JSONArray;
import org.json.JSONObject;

class InnerWebView$QQJSCoreInterface
{
  private InnerWebView$QQJSCoreInterface(InnerWebView paramInnerWebView) {}
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    int i;
    if ("preVerifyJSAPI".equals(paramString1))
    {
      InnerWebView.access$1700(this.this$0, paramString1, null, paramInt);
    }
    else
    {
      boolean bool = "invokeMiniProgramAPI".equals(paramString1);
      i = 0;
      if (!bool) {}
    }
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (InnerWebView.access$600(this.this$0) != null)
      {
        InnerWebView.access$600(this.this$0).performAction(ServiceSubscribeEvent.obtain("onWebInvokeAppService", paramString2.toString(), 0));
        InnerWebView.access$1700(this.this$0, paramString1, null, paramInt);
      }
      else
      {
        InnerWebView.access$1800(this.this$0, paramString1, null, null, paramInt);
      }
    }
    catch (Exception paramString2)
    {
      label107:
      break label107;
    }
    InnerWebView.access$1800(this.this$0, paramString1, null, null, paramInt);
    break label283;
    if ("checkJsApi".equals(paramString1)) {}
    try
    {
      Object localObject = new JSONObject(paramString2);
      paramString2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localObject = ((JSONObject)localObject).optJSONArray("jsApiList");
      if (((JSONArray)localObject).length() > 0) {
        while (i < ((JSONArray)localObject).length())
        {
          localJSONObject.put(((JSONArray)localObject).get(i).toString(), true);
          i += 1;
        }
      }
      paramString2.put("checkResult", localJSONObject.toString());
      InnerWebView.access$1700(this.this$0, paramString1, paramString2, paramInt);
    }
    catch (Exception paramString2)
    {
      label235:
      break label235;
    }
    InnerWebView.access$1800(this.this$0, paramString1, null, null, paramInt);
    break label283;
    if (InnerWebView.access$600(this.this$0) != null) {
      InnerWebView.access$600(this.this$0).performAction(new InnerWebView.QQJSCoreInterface.1(this, paramString1, paramString2, paramInt));
    }
    label283:
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.QQJSCoreInterface
 * JD-Core Version:    0.7.0.1
 */