package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

public class OpenJsBridge$OpenJsBridgeListener
  extends JsBridge.JsBridgeListener
{
  WeakReference<WebView> d;
  long e;
  String f;
  
  public OpenJsBridge$OpenJsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    super(paramWebView, paramLong, paramString);
    this.d = new WeakReference(paramWebView);
    this.e = paramLong;
    this.f = paramString;
  }
  
  public void a(String paramString, Object paramObject)
  {
    WebView localWebView = (WebView)this.d.get();
    if (localWebView != null)
    {
      if (paramObject == null) {
        return;
      }
      if ((paramObject instanceof String))
      {
        paramObject = ((String)paramObject).replace("\\", "\\\\").replace("'", "\\'");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("'");
        localStringBuilder.append(paramObject);
        localStringBuilder.append("'");
        paramObject = localStringBuilder.toString();
      }
      else if ((!(paramObject instanceof Number)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof Float)))
      {
        if ((paramObject instanceof Boolean)) {
          paramObject = paramObject.toString();
        } else {
          paramObject = "'undefined'";
        }
      }
      else
      {
        paramObject = paramObject.toString();
      }
      new Handler(Looper.getMainLooper()).post(new OpenJsBridge.OpenJsBridgeListener.1(this, paramString, paramObject, localWebView));
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("OpenJsBridge", 4, "onNoMatchMethod");
    }
    WebView localWebView = (WebView)this.d.get();
    if (localWebView == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new OpenJsBridge.OpenJsBridgeListener.2(this, paramString, localWebView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener
 * JD-Core Version:    0.7.0.1
 */