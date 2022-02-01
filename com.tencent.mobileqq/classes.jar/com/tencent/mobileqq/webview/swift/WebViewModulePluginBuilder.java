package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class WebViewModulePluginBuilder
{
  public static final CommonJsPluginFactory a = new WebViewModulePluginBuilder.1();
  
  public static CommonJsPluginFactory a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("web_view_module_from", -1);
    if (i != 1)
    {
      if (i == 2)
      {
        paramIntent = ((IQQComicWebViewApi)QRoute.api(IQQComicWebViewApi.class)).getCommonJsPluginFactory();
        if ((paramIntent instanceof CommonJsPluginFactory)) {
          return (CommonJsPluginFactory)paramIntent;
        }
        QLog.e("WebViewModulePluginBuilder", 1, "comicFactory not CommonJsPluginFactory");
      }
      return null;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewModulePluginBuilder
 * JD-Core Version:    0.7.0.1
 */