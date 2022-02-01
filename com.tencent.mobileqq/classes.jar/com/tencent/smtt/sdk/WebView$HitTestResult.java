package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;

public class WebView$HitTestResult
{
  @Deprecated
  public static final int ANCHOR_TYPE = 1;
  public static final int EDIT_TEXT_TYPE = 9;
  public static final int EMAIL_TYPE = 4;
  public static final int GEO_TYPE = 3;
  @Deprecated
  public static final int IMAGE_ANCHOR_TYPE = 6;
  public static final int IMAGE_TYPE = 5;
  public static final int PHONE_TYPE = 2;
  public static final int SRC_ANCHOR_TYPE = 7;
  public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
  public static final int UNKNOWN_TYPE = 0;
  private IX5WebViewBase.HitTestResult a;
  private android.webkit.WebView.HitTestResult b = null;
  
  public WebView$HitTestResult()
  {
    this.a = null;
    this.b = null;
  }
  
  public WebView$HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
  {
    this.a = null;
    this.b = paramHitTestResult;
  }
  
  public WebView$HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
  {
    this.a = paramHitTestResult;
    this.b = null;
  }
  
  public String getExtra()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((IX5WebViewBase.HitTestResult)localObject).getExtra();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((android.webkit.WebView.HitTestResult)localObject).getExtra();
    }
    return "";
  }
  
  public int getType()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((IX5WebViewBase.HitTestResult)localObject).getType();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((android.webkit.WebView.HitTestResult)localObject).getType();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.HitTestResult
 * JD-Core Version:    0.7.0.1
 */