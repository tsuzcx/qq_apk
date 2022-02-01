package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WebViewUtil
{
  public static int a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin == null) {}
    label67:
    label90:
    do
    {
      do
      {
        return -1;
        if (WebViewPluginFactory.b.containsKey(paramWebViewPlugin.getClass())) {
          return ((Integer)WebViewPluginFactory.b.get(paramWebViewPlugin.getClass())).intValue();
        }
        if (!(paramWebViewPlugin instanceof MultiNameSpacePluginCompact)) {
          break;
        }
        paramWebViewPlugin = ((MultiNameSpacePluginCompact)paramWebViewPlugin).getMultiNameSpace();
      } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.length <= 0));
      int j = paramWebViewPlugin.length;
      int i = 0;
      CharSequence localCharSequence;
      if (i < j)
      {
        localCharSequence = paramWebViewPlugin[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          break label90;
        }
      }
      while (!WebViewPluginFactory.a.containsKey(localCharSequence))
      {
        i += 1;
        break label67;
        break;
      }
      paramWebViewPlugin = (Class)WebViewPluginFactory.a.get(localCharSequence);
      return ((Integer)WebViewPluginFactory.b.get(paramWebViewPlugin)).intValue();
      if (TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)) {
        break;
      }
    } while (!WebViewPluginFactory.a.containsKey(paramWebViewPlugin.mPluginNameSpace));
    paramWebViewPlugin = (Class)WebViewPluginFactory.a.get(paramWebViewPlugin.mPluginNameSpace);
    return ((Integer)WebViewPluginFactory.b.get(paramWebViewPlugin)).intValue();
    a(paramWebViewPlugin.toString() + " have no namespace!!!!");
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
  
  private static void a(String paramString)
  {
    QLog.e("WebViewUtil", 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewUtil
 * JD-Core Version:    0.7.0.1
 */