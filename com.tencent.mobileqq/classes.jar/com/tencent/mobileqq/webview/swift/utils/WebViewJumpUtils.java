package com.tencent.mobileqq.webview.swift.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class WebViewJumpUtils
{
  public static Intent a(Bundle paramBundle, WebViewProvider paramWebViewProvider)
  {
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      Object localObject2 = paramWebViewProvider.getHostActivity();
      CustomWebView localCustomWebView = paramWebViewProvider.getWebView();
      Object localObject1 = paramWebViewProvider.getCurrentUrl();
      if (localObject2 == null) {
        return null;
      }
      localIntent.setClass((Context)localObject2, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.putExtra("fragment_id", 1);
      if (paramBundle.containsKey("banner_activityName")) {
        localIntent.putExtra("banner_activityName", paramBundle.getString("banner_activityName"));
      } else {
        localIntent.putExtra("banner_activityName", QQBrowserActivity.class.getName());
      }
      if (paramBundle.containsKey("banner_activityFlag")) {
        localIntent.putExtra("banner_activityFlag", paramBundle.getInt("banner_activityFlag"));
      }
      if (paramBundle.containsKey("banner_webViewUrl")) {
        localIntent.putExtra("banner_webViewUrl", paramBundle.getString("banner_webViewUrl"));
      } else if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localIntent.putExtra("banner_webViewUrl", (String)localObject1);
      }
      if (paramBundle.containsKey("banner_wording"))
      {
        localIntent.putExtra("banner_wording", paramBundle.getString("banner_wording"));
      }
      else
      {
        paramWebViewProvider = localCustomWebView.getTitle();
        if (!TextUtils.isEmpty(paramWebViewProvider)) {
          paramWebViewProvider = paramWebViewProvider.trim();
        } else {
          paramWebViewProvider = "";
        }
        localObject2 = SwiftWebViewUtils.b(paramWebViewProvider);
        int i;
        if ((!"http".equals(localObject2)) && (!"https".equals(localObject2)) && (!"data".equals(localObject2)) && (!"file".equals(localObject2)) && (!paramWebViewProvider.startsWith("about")) && (!paramWebViewProvider.startsWith("base64"))) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i == 0) && (paramWebViewProvider.length() > 1)) {
          localIntent.putExtra("banner_wording", String.format(HardCodeUtil.a(2131913813), new Object[] { localCustomWebView.getTitle() }));
        } else {
          localIntent.putExtra("banner_wording", HardCodeUtil.a(2131913814));
        }
      }
      if (paramBundle.containsKey("banner_businessCategory"))
      {
        localIntent.putExtra("banner_businessCategory", paramBundle.getString("banner_businessCategory"));
      }
      else if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramWebViewProvider = Uri.parse((String)localObject1);
        if (paramWebViewProvider.isHierarchical())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("WebView_");
          ((StringBuilder)localObject1).append(paramWebViewProvider.getHost());
          localIntent.putExtra("banner_businessCategory", ((StringBuilder)localObject1).toString());
        }
      }
      if (paramBundle.containsKey("banner_webview_extra")) {
        paramBundle = paramBundle.getBundle("banner_webview_extra");
      } else {
        paramBundle = new Bundle();
      }
      if ((localCustomWebView.getView() != null) && (localCustomWebView.getView().getScrollY() > 0)) {
        paramBundle.putInt("AIO_Scroll_Y", localCustomWebView.getView().getScrollY());
      }
      localIntent.putExtra("banner_webview_extra", paramBundle);
      return localIntent;
    }
    QLog.e("WebViewJumpUtils", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
    return null;
  }
  
  public static Bundle a(WebViewProvider paramWebViewProvider)
  {
    Bundle localBundle = new Bundle();
    Object localObject = Uri.parse(paramWebViewProvider.getCurrentUrl());
    if (localObject != null)
    {
      localObject = ((Uri)localObject).getHost();
      if ((Build.VERSION.SDK_INT >= 19) && ((((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianHost((String)localObject)) || ("buluo.qq.com".equalsIgnoreCase((String)localObject))))
      {
        paramWebViewProvider.getWebView().evaluateJavascript("document.querySelector(\"meta[itemprop='name']\").getAttribute('content')", new WebViewJumpUtils.1(paramWebViewProvider));
        return null;
      }
    }
    return localBundle;
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("banner_webViewUrl");
    if (str.contains("minAIOFromMsgList")) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("&minAIOFromMsgList=1");
    paramIntent.putExtra("banner_webViewUrl", localStringBuilder.toString());
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, WebViewProvider paramWebViewProvider)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WebViewSwitchAio gotoConversationForH5SDK ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString3);
    QLog.d("WebViewJumpUtils", 1, ((StringBuilder)localObject).toString());
    if (!paramWebViewProvider.getIntent().getBooleanExtra("from_single_task", false))
    {
      QLog.e("WebViewJumpUtils", 1, "WebViewSwitchAio gotoConversationForH5SDK call from normal activity, ignore.");
      return;
    }
    Bundle localBundle1 = DataFactory.a("ipc_qqbrowser_to_conversation", "", 0, null);
    localBundle1.putInt("banner_msg", 1134049);
    Bundle localBundle2 = new Bundle();
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject = HardCodeUtil.a(2131913810);
    }
    localBundle2.putString("tips", (String)localObject);
    localBundle2.putString("iconURL", paramString2);
    localBundle2.putInt("icon", paramInt);
    localBundle2.putInt("timeout", 900000);
    localBundle2.putString("url", paramWebViewProvider.getCurrentUrl());
    localBundle2.putString("activity", paramString3);
    localBundle2.putInt("flags", 335544320);
    localBundle1.putBundle("barInfo", localBundle2);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(localBundle1);
    paramString1 = new Intent();
    paramString1.setClass(paramWebViewProvider.getHostActivity(), SplashActivity.class);
    paramString1.setFlags(335544320);
    paramString1.putExtra("tab_index", FrameControllerUtil.a);
    paramString1.putExtra("fragment_id", 1);
    paramWebViewProvider.getHostActivity().startActivity(paramString1);
  }
  
  public static final void b(Bundle paramBundle, WebViewProvider paramWebViewProvider)
  {
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)paramWebViewProvider.getComponentProvider().a(2);
    if (localSwiftBrowserUIStyleHandler == null) {
      return;
    }
    if ((localSwiftBrowserUIStyleHandler.f.S) && (paramBundle != null))
    {
      paramBundle = a(paramBundle, paramWebViewProvider);
      if (paramBundle != null) {
        paramWebViewProvider.getHostActivity().startActivity(paramBundle);
      }
    }
    else
    {
      QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
    }
  }
  
  public static void b(WebViewProvider paramWebViewProvider)
  {
    b(a(paramWebViewProvider), paramWebViewProvider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.WebViewJumpUtils
 * JD-Core Version:    0.7.0.1
 */