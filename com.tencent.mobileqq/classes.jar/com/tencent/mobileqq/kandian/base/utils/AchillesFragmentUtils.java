package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class AchillesFragmentUtils
{
  private static AchillesFragmentUtils.InstallBroadcastReceiver jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsAchillesFragmentUtils$InstallBroadcastReceiver;
  private static String jdField_a_of_type_JavaLangString;
  private static WeakReference<WebViewPlugin.PluginRuntime> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009ECD", "0X8009ECD", 0, 0, paramString1, paramString2, paramString3, localJSONObject.toString(), false);
  }
  
  public static boolean a(String paramString1, String paramString2, WebViewPlugin.PluginRuntime paramPluginRuntime, boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_JavaLangString = paramString1;
      if (jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsAchillesFragmentUtils$InstallBroadcastReceiver == null)
      {
        paramString1 = new IntentFilter();
        paramString1.addAction("android.intent.action.PACKAGE_ADDED");
        paramString1.addAction("android.intent.action.PACKAGE_INSTALL");
        paramString1.addAction("android.intent.action.UNINSTALL_PACKAGE");
        paramString1.addDataScheme("package");
        jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsAchillesFragmentUtils$InstallBroadcastReceiver = new AchillesFragmentUtils.InstallBroadcastReceiver();
        BaseApplication.getContext().registerReceiver(jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsAchillesFragmentUtils$InstallBroadcastReceiver, paramString1);
      }
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPluginRuntime);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.AchillesFragmentUtils
 * JD-Core Version:    0.7.0.1
 */