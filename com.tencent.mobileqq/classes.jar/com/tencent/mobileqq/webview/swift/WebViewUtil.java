package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WebViewUtil
{
  public static int a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin == null) {
      return -1;
    }
    if (WebViewPluginFactory.b.containsKey(paramWebViewPlugin.getClass())) {
      return ((Integer)WebViewPluginFactory.b.get(paramWebViewPlugin.getClass())).intValue();
    }
    if ((paramWebViewPlugin instanceof MultiNameSpacePluginCompact))
    {
      paramWebViewPlugin = ((MultiNameSpacePluginCompact)paramWebViewPlugin).getMultiNameSpace();
      if ((paramWebViewPlugin != null) && (paramWebViewPlugin.length > 0))
      {
        int j = paramWebViewPlugin.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramWebViewPlugin[i];
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (WebViewPluginFactory.a.containsKey(localObject)))
          {
            paramWebViewPlugin = (Class)WebViewPluginFactory.a.get(localObject);
            return ((Integer)WebViewPluginFactory.b.get(paramWebViewPlugin)).intValue();
          }
          i += 1;
        }
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)) {
        break label181;
      }
      if (WebViewPluginFactory.a.containsKey(paramWebViewPlugin.mPluginNameSpace))
      {
        paramWebViewPlugin = (Class)WebViewPluginFactory.a.get(paramWebViewPlugin.mPluginNameSpace);
        return ((Integer)WebViewPluginFactory.b.get(paramWebViewPlugin)).intValue();
      }
    }
    return -1;
    label181:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramWebViewPlugin.toString());
    ((StringBuilder)localObject).append(" have no namespace!!!!");
    a(((StringBuilder)localObject).toString());
    return -1;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("have no namespace!!!!");
      return -1;
    }
    if (WebViewPluginFactory.a.containsKey(paramString))
    {
      paramString = (Class)WebViewPluginFactory.a.get(paramString);
      return ((Integer)WebViewPluginFactory.b.get(paramString)).intValue();
    }
    a("have no namespace!!!!");
    return -1;
  }
  
  public static void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte, WebViewProvider paramWebViewProvider)
  {
    int i = paramWebViewProvider.switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    paramWebViewProvider.getHostActivity().startActivity(paramIntent);
  }
  
  public static void a(WebViewPlugin paramWebViewPlugin, ActivityURIRequest paramActivityURIRequest, byte paramByte, WebViewProvider paramWebViewProvider)
  {
    int i = paramWebViewProvider.switchRequestCode(paramWebViewPlugin, paramByte);
    paramActivityURIRequest.extra().putString("keyAction", "actionSelectPicture");
    paramActivityURIRequest.extra().putInt("requestCode", i);
    QRoute.startUri(paramActivityURIRequest);
  }
  
  private static void a(String paramString)
  {
    QLog.e("WebViewUtil", 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewUtil
 * JD-Core Version:    0.7.0.1
 */