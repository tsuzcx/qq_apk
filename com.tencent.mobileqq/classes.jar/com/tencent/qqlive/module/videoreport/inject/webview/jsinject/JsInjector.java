package com.tencent.qqlive.module.videoreport.inject.webview.jsinject;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.HashSet;
import java.util.Set;

public class JsInjector
{
  private static final String JS_PATH = "js/js_api_source.js";
  private static final Set<String> hasInjectSet = new HashSet();
  private String mJsContent = null;
  
  private void addInjectRecord(String paramString)
  {
    hasInjectSet.add(paramString);
  }
  
  private void cleanInjectRecord(String paramString)
  {
    hasInjectSet.remove(paramString);
  }
  
  private boolean doInject(Object paramObject)
  {
    if (paramObject == null) {}
    while (TextUtils.isEmpty(getJsContent())) {
      return false;
    }
    loadJsCompat(paramObject, "javascript:" + getJsContent());
    return true;
  }
  
  public static JsInjector getInstance()
  {
    return JsInjector.Instance.sInstance;
  }
  
  private String getJsContent()
  {
    if (TextUtils.isEmpty(this.mJsContent)) {
      this.mJsContent = BaseUtils.readFileFromAssets(ReportUtils.getContext(), "js/js_api_source.js");
    }
    return this.mJsContent;
  }
  
  private boolean hasInjected(String paramString)
  {
    return hasInjectSet.contains(paramString);
  }
  
  private void loadJsCompat(Object paramObject, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      WebViewCompatHelper.onEvaluateJavascript(paramObject, paramString);
      return;
    }
    WebViewCompatHelper.loadUrl(paramObject, paramString);
  }
  
  public void onPageStarted(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    cleanInjectRecord(paramObject.hashCode() + "");
  }
  
  public void onProgressChanged(Object paramObject, int paramInt)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return;
      str = paramObject.hashCode() + "";
    } while ((paramInt < 25) || (hasInjected(str)) || (!doInject(paramObject)));
    addInjectRecord(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector
 * JD-Core Version:    0.7.0.1
 */