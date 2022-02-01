package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewCallback;

public abstract interface WebViewKernelCallBack
  extends WebViewCallback
{
  public abstract boolean interceptInitUIFrame();
  
  public abstract boolean interceptStartLoadUrl();
  
  public abstract boolean interceptTouchEvent(View paramView, MotionEvent paramMotionEvent);
  
  public abstract void loadUrlFinish();
  
  public abstract void onDataInit(Bundle paramBundle);
  
  public abstract void onFinalState(Bundle paramBundle);
  
  public abstract void onInitBottomBar(Bundle paramBundle);
  
  public abstract void onInitTitleBar(Bundle paramBundle);
  
  public abstract void onInitUIContent(Bundle paramBundle);
  
  public abstract void onShowPreview(Bundle paramBundle);
  
  public abstract void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack
 * JD-Core Version:    0.7.0.1
 */