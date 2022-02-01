package com.tencent.mobileqq.webview.swift;

import android.content.Intent;

public class WebViewModulePluginBuilder
{
  public static final CommonJsPluginFactory a = new WebViewModulePluginBuilder.1();
  
  public static CommonJsPluginFactory a(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("web_view_module_from", -1))
    {
    default: 
      return null;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewModulePluginBuilder
 * JD-Core Version:    0.7.0.1
 */