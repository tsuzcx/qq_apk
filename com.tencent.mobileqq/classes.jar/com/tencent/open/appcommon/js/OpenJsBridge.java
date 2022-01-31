package com.tencent.open.appcommon.js;

import alem;
import android.net.Uri;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener;
import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

public class OpenJsBridge
  extends JsBridge
{
  public HashMap b = new HashMap();
  
  public HashMap a()
  {
    return this.b;
  }
  
  public void a(JsBridge.JsHandler paramJsHandler, String paramString)
  {
    this.b.put(paramString, paramJsHandler);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.b.clear();
      return;
    }
    this.b.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, List paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    long l1 = System.currentTimeMillis();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.i("JB", 4, "decode failed: " + (String)paramList.get(i));
            }
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    LogUtility.b("TIME", "time4-time3=" + (l2 - l1));
    paramString1 = (JsBridge.JsHandler)this.b.get(paramString1);
    if (paramString1 != null) {
      paramString1.call(paramString2, paramList, paramJsBridgeListener);
    }
    while (!(paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
      return;
    }
    ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString2);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (paramString == null) {}
    Uri localUri;
    do
    {
      return false;
      localUri = Uri.parse(paramString);
    } while ((localUri == null) || (localUri.getScheme() == null) || (!localUri.getScheme().equals("jsbridge")));
    LogUtility.b("Request", "canHandleBatchUrl AsyncInterface_start:" + paramString);
    ThreadManager.executeOnSubThread(new alem(this, paramString, paramWebView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge
 * JD-Core Version:    0.7.0.1
 */