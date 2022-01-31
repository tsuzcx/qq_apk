package cooperation.qqreader;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloadReportUtils;
import cooperation.comic.PluginPreloadReportUtils.HitRateHelper;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QRJumpAction
{
  private static Intent a(Intent paramIntent, String paramString)
  {
    int i = 0;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramIntent.putExtra("launch_by_splash", true);
    paramIntent.putExtra("isFromSplashActivityToCloseQRbridge", true);
    if ((paramIntent.hasExtra("is_from_leba")) && (paramIntent.getBooleanExtra("is_from_leba", false))) {}
    for (;;)
    {
      paramIntent.putExtra("from_where", i);
      paramIntent.putExtra("params_remote_connect_at_launch", true);
      return paramIntent;
      if ((paramIntent.hasExtra("is_from_webview")) && (paramIntent.getBooleanExtra("is_from_webview", false))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  private static String a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramIntent == null) {
      return "com.qqreader.webview.activity.ReaderBrowserActivity";
    }
    String str1 = paramIntent.getStringExtra("readtype");
    int i;
    if (paramIntent.hasExtra("key_params_qq")) {
      i = 502;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramIntent.putExtra("item_type", 1);
        return "com.qqreader.webview.activity.ReaderBrowserActivity";
        if (paramIntent.getBooleanExtra("is_from_qreader_shortcut", false)) {
          i = 501;
        } else if (!TextUtils.isEmpty(str1)) {
          try
          {
            i = Integer.valueOf(str1).intValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("QRJumpAction", 4, localNumberFormatException.toString());
            }
          }
        } else {
          i = -1;
        }
        break;
      }
    }
    paramIntent.putExtra("openBookDetailByBid", paramIntent.getStringExtra("id"));
    paramIntent.putExtra("item_type", 2);
    return "com.qqreader.webview.activity.ReaderBrowserActivity";
    paramIntent.putExtra("tab_index", Integer.valueOf(paramIntent.getStringExtra("column")).intValue());
    paramIntent.putExtra("item_type", 1);
    return "com.qqreader.webview.activity.ReaderBrowserActivity";
    paramIntent.putExtra("com.qq.reader.WebContent", a(paramIntent.getStringExtra("url")));
    paramIntent.putExtra("item_type", 2);
    String str2 = paramIntent.getStringExtra("stay");
    if ((str2 == null) || (!"1".equals(str2))) {
      bool1 = true;
    }
    paramIntent.putExtra("is_from_splashactivity", bool1);
    return "com.qqreader.webview.activity.ReaderBrowserActivity";
    paramIntent.putExtra("item_type", 3);
    str2 = paramIntent.getStringExtra("stay");
    if (str2 != null)
    {
      bool1 = bool2;
      if ("1".equals(str2)) {}
    }
    else
    {
      bool1 = true;
    }
    paramIntent.putExtra("is_from_splashactivity", bool1);
    paramIntent.putExtra("webview_hide_progress", true);
    return "com.qqreader.webview.activity.ReaderBrowserActivity";
    paramIntent.putExtra("openMoreState", true);
    paramIntent.putExtra("item_type", 2);
    paramIntent.putExtra("com.qq.reader.WebContent.bookshelf", 100001);
    return "com.qqreader.webview.activity.ReaderBrowserActivity";
    return "com.qqreader.SplashActivity";
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("/46")) {
        str = paramString.replaceAll("/46", "&");
      }
    }
    return str;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    if ((paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QRJumpAction", 4, "jumpAction args error");
      }
      return;
    }
    paramIntent = a(paramIntent, paramString);
    a(paramActivity, paramIntent, paramString, a(paramIntent));
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2)
  {
    if ((paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QRJumpAction", 4, "jumpToPlugin args error");
      }
    }
    do
    {
      return;
      paramIntent.putExtra("start_plugin_time", System.currentTimeMillis());
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.b = "qqreaderplugin.apk";
      localPluginParams.d = "阅读中心";
      localPluginParams.jdField_a_of_type_JavaLangString = paramString1;
      PluginCommunicationHandler.getInstance().register(new QRRemoteCommond());
      PluginCommunicationHandler.getInstance().register(new QRRemoteAsynCommond());
      localPluginParams.e = paramString2;
      localPluginParams.jdField_a_of_type_JavaLangClass = QRPluginProxyActivity.class;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
      paramIntent = PluginPreloadReportUtils.a(1);
      if (paramIntent != null)
      {
        paramIntent.a();
        localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = paramIntent.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
      }
      try
      {
        IPluginManager.a(paramActivity, localPluginParams);
        return;
      }
      catch (Exception paramActivity) {}
    } while (!QLog.isDevelopLevel());
    QLog.d("QRJumpAction", 4, paramActivity.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRJumpAction
 * JD-Core Version:    0.7.0.1
 */