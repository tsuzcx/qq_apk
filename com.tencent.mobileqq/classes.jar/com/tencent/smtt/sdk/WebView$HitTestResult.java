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
  private IX5WebViewBase.HitTestResult mHitTestResultImpl;
  private android.webkit.WebView.HitTestResult mSysHitTestResult = null;
  
  public WebView$HitTestResult()
  {
    this.mHitTestResultImpl = null;
    this.mSysHitTestResult = null;
  }
  
  public WebView$HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
  {
    this.mHitTestResultImpl = null;
    this.mSysHitTestResult = paramHitTestResult;
  }
  
  public WebView$HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
  {
    this.mHitTestResultImpl = paramHitTestResult;
    this.mSysHitTestResult = null;
  }
  
  public String getExtra()
  {
    String str = "";
    if (this.mHitTestResultImpl != null) {
      str = this.mHitTestResultImpl.getExtra();
    }
    while (this.mSysHitTestResult == null) {
      return str;
    }
    return this.mSysHitTestResult.getExtra();
  }
  
  public int getType()
  {
    int i = 0;
    if (this.mHitTestResultImpl != null) {
      i = this.mHitTestResultImpl.getType();
    }
    while (this.mSysHitTestResult == null) {
      return i;
    }
    return this.mSysHitTestResult.getType();
  }
  
  public void setExtra(String paramString)
  {
    if (this.mHitTestResultImpl != null) {
      this.mHitTestResultImpl.setExtra(paramString);
    }
  }
  
  public void setType(int paramInt)
  {
    if (this.mHitTestResultImpl != null) {
      this.mHitTestResultImpl.setType(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.HitTestResult
 * JD-Core Version:    0.7.0.1
 */