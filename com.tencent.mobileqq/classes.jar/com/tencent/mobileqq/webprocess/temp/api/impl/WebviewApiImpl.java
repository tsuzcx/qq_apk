package com.tencent.mobileqq.webprocess.temp.api.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import java.util.List;
import mqq.app.AppRuntime;

public class WebviewApiImpl
  implements IWebviewApi
{
  public Object createShare(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    return new Share(paramAppRuntime, paramActivity);
  }
  
  public List<String> getMenuHideNameList(Object paramObject)
  {
    if ((paramObject instanceof SwiftBrowserShareMenuHandler)) {
      return ((SwiftBrowserShareMenuHandler)paramObject).i;
    }
    return null;
  }
  
  public Object getSharePd(Object paramObject)
  {
    if ((paramObject instanceof WebViewFragment)) {
      return ((Share)((WebViewFragment)paramObject).getShare()).u();
    }
    return null;
  }
  
  public int getWebViewDialogMultiLineLayout()
  {
    return 2131624612;
  }
  
  public boolean onQRFromX5(Object paramObject)
  {
    paramObject = (SwiftBrowserLongClickHandler)paramObject;
    if (paramObject != null) {
      return paramObject.b();
    }
    return false;
  }
  
  public void removeLastUinCookies(String paramString)
  {
    BrowserAppInterface.a(paramString);
  }
  
  public boolean shouldOverrideLongClick(View paramView, Object paramObject)
  {
    paramObject = (SwiftBrowserLongClickHandler)paramObject;
    return (paramObject != null) && (paramObject.a(paramView));
  }
  
  public void showActionSheet(long paramLong, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (SwiftBrowserShareMenuHandler)paramObject1;
    if (paramObject1 != null) {
      paramObject1.a((Share)paramObject2, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.temp.api.impl.WebviewApiImpl
 * JD-Core Version:    0.7.0.1
 */