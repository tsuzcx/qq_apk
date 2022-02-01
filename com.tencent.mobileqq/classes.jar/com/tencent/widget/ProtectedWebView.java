package com.tencent.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.smtt.sdk.WebView;

public class ProtectedWebView
  extends DtX5WebView
{
  private boolean b;
  
  public ProtectedWebView(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  private void h()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    this.b = false;
  }
  
  public boolean canGoBack()
  {
    if (!this.b) {
      return super.canGoBack();
    }
    return false;
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.b) {
      return super.canGoBackOrForward(paramInt);
    }
    return false;
  }
  
  public boolean canGoForward()
  {
    if (!this.b) {
      return super.canGoForward();
    }
    return false;
  }
  
  public void clearView()
  {
    if (!this.b) {
      super.clearView();
    }
  }
  
  public void destroy()
  {
    if (!this.b)
    {
      this.b = true;
      super.destroy();
    }
  }
  
  public void goBack()
  {
    if (!this.b) {
      super.goBack();
    }
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.b) {
      super.goBackOrForward(paramInt);
    }
  }
  
  public void loadUrl(String paramString)
  {
    if (!this.b) {
      super.loadUrl(paramString);
    }
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.b) {
      super.postUrl(paramString, paramArrayOfByte);
    }
  }
  
  public void reload()
  {
    if (!this.b) {
      super.reload();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (!this.b) {
      super.setVisibility(paramInt);
    }
  }
  
  public void stopLoading()
  {
    if (!this.b) {
      super.stopLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ProtectedWebView
 * JD-Core Version:    0.7.0.1
 */