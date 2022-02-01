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
    int i = 0;
    if ("preVerifyJSAPI".equals(paramString1)) {
      InnerWebView.access$1700(this.this$0, paramString1, null, paramInt);
    }
    for (;;)
    {
      return "";
      if ("invokeMiniProgramAPI".equals(paramString1))
      {
        try
        {
          paramString2 = new JSONObject(paramString2);
          if (InnerWebView.access$600(this.this$0) == null) {
            break label104;
          }
          InnerWebView.access$600(this.this$0).performAction(ServiceSubscribeEvent.obtain("onWebInvokeAppService", paramString2.toString(), 0));
          InnerWebView.access$1700(this.this$0, paramString1, null, paramInt);
        }
        catch (Exception paramString2)
        {
          InnerWebView.access$1800(this.this$0, paramString1, null, null, paramInt);
        }
        continue;
        label104:
        InnerWebView.access$1800(this.this$0, paramString1, null, null, paramInt);
      }
      else if ("checkJsApi".equals(paramString1))
      {
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
          InnerWebView.access$1800(this.this$0, paramString1, null, null, paramInt);
        }
      }
      else if (InnerWebView.access$600(this.this$0) != null)
      {
        InnerWebView.access$600(this.this$0).performAction(new InnerWebView.QQJSCoreInterface.1(this, paramString1, paramString2, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.QQJSCoreInterface
 * JD-Core Version:    0.7.0.1
 */