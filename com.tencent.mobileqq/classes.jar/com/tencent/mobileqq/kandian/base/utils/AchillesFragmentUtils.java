package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class AchillesFragmentUtils
{
  private static WeakReference<WebViewPlugin.PluginRuntime> a;
  private static AchillesFragmentUtils.InstallBroadcastReceiver b;
  private static String c;
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    PublicAccountReportUtils.a(null, "", "0X8009ECD", "0X8009ECD", 0, 0, paramString1, paramString2, paramString3, new JSONObject().toString(), false);
  }
  
  public static boolean a(String paramString1, String paramString2, WebViewPlugin.PluginRuntime paramPluginRuntime, boolean paramBoolean)
  {
    try
    {
      c = paramString1;
      if (b == null)
      {
        paramString1 = new IntentFilter();
        paramString1.addAction("android.intent.action.PACKAGE_ADDED");
        paramString1.addAction("android.intent.action.PACKAGE_INSTALL");
        paramString1.addAction("android.intent.action.UNINSTALL_PACKAGE");
        paramString1.addDataScheme("package");
        b = new AchillesFragmentUtils.InstallBroadcastReceiver();
        BaseApplication.getContext().registerReceiver(b, paramString1);
      }
      a = new WeakReference(paramPluginRuntime);
    }
    catch (Exception paramString1)
    {
      label74:
      break label74;
    }
    paramString1 = new StringBuilder();
    paramString1.append("installFile:");
    paramString1.append(paramString2);
    paramString1.append(" installSuccess:");
    paramString1.append(paramBoolean);
    QLog.i("AchillesFragmentUtils", 1, paramString1.toString());
    if (paramBoolean) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    }
    a("install", paramString1, paramString2);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.AchillesFragmentUtils
 * JD-Core Version:    0.7.0.1
 */