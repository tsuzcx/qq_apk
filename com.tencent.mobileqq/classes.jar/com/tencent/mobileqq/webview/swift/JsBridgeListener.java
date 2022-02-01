package com.tencent.mobileqq.webview.swift;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@Deprecated
public class JsBridgeListener
{
  public long a;
  WeakReference<WebView> a;
  public boolean a;
  
  public JsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public JsBridgeListener(WebView paramWebView, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static String a(int paramInt, Object paramObject, String paramString)
  {
    if (paramInt != 0) {
      return String.format("{'r':%d,'result':'%s'}", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    if (paramObject == null) {
      return String.format("{'r':%d,'result':'%s'}", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    if ((!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)))
    {
      paramString = new StringBuilder();
      paramString.append("'");
      paramString.append(paramObject.toString().replace("\\", "\\\\").replace("'", "\\'"));
      paramString.append("'");
      paramObject = paramString.toString();
    }
    else
    {
      paramObject = paramObject.toString();
    }
    return String.format("{'r':0,'result':%s}", new Object[] { paramObject });
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onPermissionDenied");
    }
    if (this.jdField_a_of_type_Long == -1L) {
      return;
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
  
  @Deprecated
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Long == -1L) {
      return;
    }
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
    if ((!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)))
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
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    if (this.jdField_a_of_type_Long == -1L) {
      return;
    }
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback(");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",{'r':1,'result':'");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'})");
    localWebView.loadUrl(localStringBuilder.toString());
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_Long == -1L) {
      return;
    }
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    if (paramJSONObject == null)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:window.JsBridge&&JsBridge.callback(");
      paramJSONObject.append(this.jdField_a_of_type_Long);
      paramJSONObject.append(",{'r':0});");
      localWebView.loadUrl(paramJSONObject.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback(");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",{'r':0,'result':");
    localStringBuilder.append(paramJSONObject.toString());
    localStringBuilder.append("});");
    localWebView.loadUrl(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.JsBridgeListener
 * JD-Core Version:    0.7.0.1
 */