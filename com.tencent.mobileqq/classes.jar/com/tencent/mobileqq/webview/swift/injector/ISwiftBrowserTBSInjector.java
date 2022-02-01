package com.tencent.mobileqq.webview.swift.injector;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;

public abstract interface ISwiftBrowserTBSInjector
{
  public abstract void a(SwiftBrowserComponentsProvider.SwiftBrowserComponentContext paramSwiftBrowserComponentContext);
  
  public abstract void a(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserTBSInjector
 * JD-Core Version:    0.7.0.1
 */