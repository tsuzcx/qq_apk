package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportWebViewClient;

public class ShadowWebView
  extends DtWebView
{
  private final String ANDROID_ASSET_PREFIX = "file:///android_asset/";
  private final String REPLACE_ASSET_PREFIX = "http://android.asset/";
  private Context mContext;
  
  public ShadowWebView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ShadowWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ShadowWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  @TargetApi(21)
  public ShadowWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext);
  }
  
  public ShadowWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt, paramBoolean);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    setWebViewClient(new ReportWebViewClient());
  }
  
  public void loadUrl(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("file:///android_asset/")) {
      str = paramString.replace("file:///android_asset/", "http://android.asset/");
    }
    super.loadUrl(str);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(new ShadowWebView.WarpWebViewClient(this, paramWebViewClient, this.mContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowWebView
 * JD-Core Version:    0.7.0.1
 */