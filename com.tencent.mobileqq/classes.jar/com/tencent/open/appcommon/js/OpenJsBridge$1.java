package com.tencent.open.appcommon.js;

import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class OpenJsBridge$1
  implements Runnable
{
  OpenJsBridge$1(OpenJsBridge paramOpenJsBridge, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append("/#");
    localObject1 = ((StringBuilder)localObject1).toString().split("/");
    Object localObject4 = new ArrayList(Arrays.asList((Object[])localObject1));
    if (((ArrayList)localObject4).size() < 3) {
      return;
    }
    String str = (String)((ArrayList)localObject4).get(2);
    if (((ArrayList)localObject4).size() < 5) {
      return;
    }
    Object localObject2;
    Object localObject5;
    Object localObject3;
    int i;
    if (((ArrayList)localObject4).size() == 5)
    {
      localObject2 = localObject1[3].split("#");
      if (localObject2.length > 1) {
        localObject1 = localObject2[1];
      } else {
        localObject1 = "";
      }
      localObject5 = localObject2[0].split("\\?");
      if (localObject5.length > 1)
      {
        localObject3 = localObject5[1].split("&");
        j = localObject3.length;
        i = 0;
        for (;;)
        {
          localObject2 = localObject3;
          if (i >= j) {
            break;
          }
          int k = localObject3[i].indexOf('=');
          if (k != -1) {
            localObject3[i] = localObject3[i].substring(k + 1);
          } else {
            localObject3[i] = "";
          }
          i += 1;
        }
      }
      localObject2 = new String[0];
      localObject4 = new ArrayList();
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        ((List)localObject4).add(localObject2[i]);
        i += 1;
      }
      localObject2 = localObject5[0];
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    else
    {
      localObject2 = (String)((ArrayList)localObject4).get(3);
      localObject3 = (String)((ArrayList)localObject4).get(4);
      if (((String)localObject2).trim().equals("callBatch"))
      {
        localObject1 = (String)((ArrayList)localObject4).get(5);
        localObject5 = (String)((ArrayList)localObject4).get(6);
        localObject4 = (String)((ArrayList)localObject4).get(7);
      }
    }
    try
    {
      l1 = Long.parseLong((String)localObject3);
      long l2 = Long.parseLong((String)localObject5);
      i = Integer.parseInt((String)localObject4);
      localObject3 = (JsBridge.JsHandler)this.this$0.c.get(str);
      if ((localObject3 != null) && ((localObject3 instanceof BaseInterface)))
      {
        ((BaseInterface)localObject3).callBatch(this.b, this.this$0.c, l1, (String)localObject1, Long.valueOf(l2).longValue(), i);
        return;
      }
      localObject1 = this.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("',{guid:");
      ((StringBuilder)localObject3).append(l1);
      ((StringBuilder)localObject3).append(",    'r':-2,'data':'no such method'})};");
      ((WebView)localObject1).loadUrl(((StringBuilder)localObject3).toString());
      return;
    }
    catch (NumberFormatException|Exception localNumberFormatException)
    {
      try
      {
        long l1 = Long.parseLong((String)localObject3);
        if (AsyncMethodMap.a.contains(localObject2)) {
          ((List)localObject1).add(localObject3);
        }
        localObject3 = this.b;
        if (localObject3 != null) {
          this.this$0.a(str, (String)localObject2, (List)localObject1, new OpenJsBridge.OpenJsBridgeListener((WebView)localObject3, l1, this.a));
        }
        return;
      }
      catch (Exception localException) {}
      localNumberFormatException = localNumberFormatException;
      return;
    }
    localObject1 = ((ArrayList)localObject4).subList(5, ((ArrayList)localObject4).size() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.1
 * JD-Core Version:    0.7.0.1
 */