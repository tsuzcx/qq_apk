package com.tencent.qqlive.module.videoreport.inject.webview.jsinject;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.HashSet;
import java.util.Set;

public class JsInjector
{
  private static final String JS_PATH = "js/js_api_source.js";
  private static final String TAG = "JsInjector";
  private static final Set<String> hasJsSourceInjectSet = new HashSet();
  private String mJsContent = null;
  
  private void addJsSourceInjectRecord(String paramString)
  {
    hasJsSourceInjectSet.add(paramString);
  }
  
  private void cleanInjectRecord(String paramString)
  {
    hasJsSourceInjectSet.remove(paramString);
  }
  
  private boolean doInjectJsSource(Object paramObject)
  {
    if (!DTConfigConstants.config.webViewReportSupport())
    {
      Log.w("JsInjector", "webView report not support, don't inject js source!");
      return false;
    }
    if (paramObject == null) {
      return false;
    }
    if (TextUtils.isEmpty(getJsContent())) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append(getJsContent());
    loadJsCompat(paramObject, localStringBuilder.toString());
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
  
  private boolean hasJsSourceInjected(String paramString)
  {
    return hasJsSourceInjectSet.contains(paramString);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.hashCode());
    localStringBuilder.append("");
    cleanInjectRecord(localStringBuilder.toString());
  }
  
  public void onProgressChanged(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramObject.hashCode());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    if ((paramInt >= 25) && (!hasJsSourceInjected((String)localObject)) && (doInjectJsSource(paramObject))) {
      addJsSourceInjectRecord((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector
 * JD-Core Version:    0.7.0.1
 */