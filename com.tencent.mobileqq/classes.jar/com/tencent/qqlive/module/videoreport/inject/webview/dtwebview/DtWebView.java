package com.tencent.qqlive.module.videoreport.inject.webview.dtwebview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.BridgeInterface;
import java.util.Map;

public class DtWebView
  extends WebView
{
  private JsBinderHelper mJsBinderHelper;
  
  public DtWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DtWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DtWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public DtWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public DtWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt, paramBoolean);
  }
  
  private JsBinderHelper getJsBinderHelper()
  {
    if (this.mJsBinderHelper == null) {
      this.mJsBinderHelper = new JsBinderHelper();
    }
    return this.mJsBinderHelper;
  }
  
  private void onLoad()
  {
    if (!getJsBinderHelper().allowInjectOnLoad()) {
      return;
    }
    addJavascriptInterface(new BridgeInterface(this), "DTJsBridgeInterface");
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (getJsBinderHelper().interceptOnAddJavascriptInterface(paramString)) {
      return;
    }
    super.addJavascriptInterface(paramObject, paramString);
  }
  
  public void loadData(String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    super.loadData(paramString1, paramString2, paramString3);
    onLoad();
  }
  
  public void loadDataWithBaseURL(@Nullable String paramString1, String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5)
  {
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    onLoad();
  }
  
  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
    onLoad();
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    super.loadUrl(paramString, paramMap);
    onLoad();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView
 * JD-Core Version:    0.7.0.1
 */