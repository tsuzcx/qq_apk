package com.tencent.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.smtt.sdk.WebView;

public class ProtectedWebView
  extends WebView
{
  private boolean a;
  
  public ProtectedWebView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.a = false;
  }
  
  public boolean canGoBack()
  {
    if (!this.a) {
      return super.canGoBack();
    }
    return false;
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.a) {
      return super.canGoBackOrForward(paramInt);
    }
    return false;
  }
  
  public boolean canGoForward()
  {
    if (!this.a) {
      return super.canGoForward();
    }
    return false;
  }
  
  public void clearView()
  {
    if (!this.a) {
      super.clearView();
    }
  }
  
  public void destroy()
  {
    if (!this.a)
    {
      this.a = true;
      super.destroy();
    }
  }
  
  public void goBack()
  {
    if (!this.a) {
      super.goBack();
    }
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.a) {
      super.goBackOrForward(paramInt);
    }
  }
  
  public void loadUrl(String paramString)
  {
    if (!this.a) {
      super.loadUrl(paramString);
    }
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.a) {
      super.postUrl(paramString, paramArrayOfByte);
    }
  }
  
  public void reload()
  {
    if (!this.a) {
      super.reload();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (!this.a) {
      super.setVisibility(paramInt);
    }
  }
  
  public void stopLoading()
  {
    if (!this.a) {
      super.stopLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.ProtectedWebView
 * JD-Core Version:    0.7.0.1
 */