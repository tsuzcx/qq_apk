package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.gdtad.web.GdtWebReportQQ;
import com.tencent.mobileqq.activity.springfestival.js.SpringHbUrlInterceptor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.IWebViewWrapperInjector;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public class WebViewWrapperInjector
  implements IWebViewWrapperInjector
{
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
      localTroopMemberApiClient.e();
      Bundle localBundle = SwiftBrowserStatistics.h(paramString2);
      localBundle.putString("uin", paramString4);
      if (!TextUtils.isEmpty(paramString3)) {
        localBundle.putString("title", paramString3);
      }
      localTroopMemberApiClient.a(2, paramString2, paramString1, localBundle);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebViewWrapperInjector", 1, paramString1, new Object[0]);
    }
  }
  
  public WebResourceResponse a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1.startsWith("mqqpa://resourceid/")) {
      return (WebResourceResponse)((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebResponse(paramString1);
    }
    if (GdtWebReportQQ.a(paramString1))
    {
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView == null) {
        return null;
      }
      if (paramBoolean) {
        paramWebView.a(paramString1, 8589934593L, null);
      }
      try
      {
        paramWebView = paramWebView.a(paramString1, 8L);
        if ((paramWebView instanceof WebResourceResponse))
        {
          paramWebView = (WebResourceResponse)paramWebView;
          return paramWebView;
        }
      }
      catch (Exception paramWebView)
      {
        paramString1 = new StringBuilder();
        paramString1.append("shouldInterceptRequest error:");
        paramString1.append(paramWebView.getMessage());
        QLog.e("WebViewWrapperInjector", 1, paramString1.toString());
      }
      return null;
    }
    return SpringHbUrlInterceptor.b(paramString1);
  }
  
  public void a(Bundle paramBundle, WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)paramBundle.get("recognised-text");
        boolean bool1 = paramBundle.getBoolean("virtual-keyboard", false);
        String str2 = paramBundle.getString("normal-input-value-change");
        boolean bool2 = paramBundle.getBoolean("password-start-input", false);
        boolean bool3 = paramBundle.getBoolean("password-input-show", false);
        Object localObject2 = new StringBuilder(128);
        if (localArrayList != null)
        {
          paramBundle = localArrayList.iterator();
          if (paramBundle.hasNext())
          {
            ((StringBuilder)localObject2).append((String)paramBundle.next());
            ((StringBuilder)localObject2).append(",");
            continue;
          }
        }
        String str1 = "";
        if (paramWebView == null) {
          break label303;
        }
        paramBundle = paramWebView.getOriginalUrl();
        localObject1 = paramWebView.getUrl();
        SwiftBrowserStatistics.a(paramBundle, (String)localObject1, ((StringBuilder)localObject2).toString(), str2, bool2, bool3, bool1);
        Object localObject3 = localObject2;
        if (((localArrayList != null) && (localArrayList.size() > 0)) || (bool1) || (!TextUtils.isEmpty(str2)))
        {
          localObject2 = str1;
          if (paramWebView != null) {
            localObject2 = paramWebView.getTitle();
          }
          a(paramBundle, (String)localObject1, (String)localObject2, paramString);
        }
        localObject3.append(" hasVirtualKB:");
        localObject3.append(bool1);
        localObject3.append(" inputText:");
        localObject3.append(str2);
        localObject3.append(" passwdTyped:");
        localObject3.append(bool2);
        localObject3.append(" showPasswdInput:");
        localObject3.append(bool3);
        if (QLog.isColorLevel())
        {
          QLog.d("WebViewWrapperInjector", 2, new Object[] { "onFakeLoginRecognised ", localObject3.toString() });
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("WebViewWrapperInjector", 2, "onFakeLoginRecognised ", paramBundle);
      }
      return;
      label303:
      paramBundle = "";
      Object localObject1 = paramBundle;
    }
  }
  
  public boolean a(String paramString)
  {
    return (paramString.startsWith("mqqpa://resourceid/")) || (SpringHbUrlInterceptor.a(paramString)) || (GdtWebReportQQ.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewWrapperInjector
 * JD-Core Version:    0.7.0.1
 */