package com.tencent.mobileqq.jsbridge;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class JsBridge$JsBridgeListener
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  WeakReference<WebView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public JsBridge$JsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback(");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",{'r':1,'result':'no such method'})");
    localWebView.loadUrl(localStringBuilder.toString());
  }
  
  public void a(Object paramObject)
  {
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    if (paramObject == null)
    {
      paramObject = new StringBuilder();
      paramObject.append("javascript:window.JsBridge&&JsBridge.callback(");
      paramObject.append(this.jdField_a_of_type_Long);
      paramObject.append(",{'r':0});");
      localWebView.loadUrl(paramObject.toString());
      return;
    }
    if ((!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof JSONObject)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append(paramObject.toString().replace("\\", "\\\\").replace("'", "\\'"));
      localStringBuilder.append("'");
      paramObject = localStringBuilder.toString();
    }
    else
    {
      paramObject = paramObject.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback(");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",{'r':0,'result':");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("});");
    localWebView.loadUrl(localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(paramString);
      localWebView.loadUrl(localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onPermissionDenied");
    }
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback(");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(",{'r':2,'result':'Permission denied'})");
      localWebView.loadUrl(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener
 * JD-Core Version:    0.7.0.1
 */