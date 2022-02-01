package com.tencent.open.appcommon.js;

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
  HashMap<String, JsBridge.JsHandler> c = new HashMap();
  
  public HashMap<String, JsBridge.JsHandler> a()
  {
    return this.c;
  }
  
  public void a(JsBridge.JsHandler paramJsHandler, String paramString)
  {
    this.c.put(paramString, paramJsHandler);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.c.clear();
      return;
    }
    this.c.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    long l1 = System.currentTimeMillis();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[getResult]decode failed: ");
          localStringBuilder.append((String)paramList.get(i));
          QLog.i("OpenJsBridge", 4, localStringBuilder.toString());
        }
      }
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getResult]time4-time3=");
    localStringBuilder.append(l2 - l1);
    LogUtility.b("OpenJsBridge", localStringBuilder.toString());
    paramString1 = (JsBridge.JsHandler)this.c.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.call(paramString2, paramList, paramJsBridgeListener);
      return;
    }
    if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
      ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString2);
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = Uri.parse(paramString);
    if ((localObject != null) && (((Uri)localObject).getScheme() != null))
    {
      if (!((Uri)localObject).getScheme().equals("jsbridge")) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[canHandleUrl] AsyncInterface_start:");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.b("OpenJsBridge", ((StringBuilder)localObject).toString());
      ThreadManager.executeOnSubThread(new OpenJsBridge.1(this, paramString, paramWebView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge
 * JD-Core Version:    0.7.0.1
 */