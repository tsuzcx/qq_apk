package com.tencent.mobileqq.webview.swift;

import android.content.Intent;

public abstract interface SwiftWebViewFragmentSupporter
{
  public abstract WebViewFragment createFragment(Intent paramIntent);
  
  public abstract WebViewFragment getCurrentWebViewFragment();
  
  public abstract boolean setBottomBarVisibility(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter
 * JD-Core Version:    0.7.0.1
 */