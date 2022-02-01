package com.tencent.smtt.export.external.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

public abstract class X5ProxyWebViewClient
  extends ProxyWebViewClient
{
  public X5ProxyWebViewClient(WebViewWizardBase paramWebViewWizardBase)
  {
    this.mWebViewClient = ((IX5WebViewClient)paramWebViewWizardBase.newInstance("com.tencent.smtt.webkit.WebViewClient"));
  }
  
  public X5ProxyWebViewClient(IX5WebViewClient paramIX5WebViewClient)
  {
    this.mWebViewClient = paramIX5WebViewClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient
 * JD-Core Version:    0.7.0.1
 */