package com.tencent.mobileqq.webview.swift.injector;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public abstract interface IAbsBaseWebViewActivityInjector
{
  public abstract WebResourceResponse a(String paramString);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent, TouchWebView paramTouchWebView);
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(QBaseActivity paramQBaseActivity);
  
  public abstract boolean a(String paramString);
  
  public abstract void b(QBaseActivity paramQBaseActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.IAbsBaseWebViewActivityInjector
 * JD-Core Version:    0.7.0.1
 */