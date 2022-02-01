package com.tencent.mobileqq.microapp.sdk;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.lang.ref.WeakReference;

public class BridgeInfo
{
  public int callbackId;
  private WeakReference webviewRef;
  
  public BridgeInfo(BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    this.webviewRef = new WeakReference(paramBaseAppBrandWebview);
    this.callbackId = paramInt;
  }
  
  public BaseAppBrandWebview getWebView()
  {
    if (this.webviewRef != null) {
      return (BaseAppBrandWebview)this.webviewRef.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.BridgeInfo
 * JD-Core Version:    0.7.0.1
 */