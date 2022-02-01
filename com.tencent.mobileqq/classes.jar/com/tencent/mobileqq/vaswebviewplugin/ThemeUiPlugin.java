package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import org.json.JSONObject;

public class ThemeUiPlugin
  extends VasWebviewUiPlugin
{
  public static final String EXTRA_THEME_ID = "extra_theme_id";
  public static final String REPORT_COPYCAT_THEME_DOWNLOAD_TAG = "report_copycat_theme_file_download";
  public static final int REPORT_THEME_DOWNLOAD_CONTENT_RANGE_IILEGAL = 89065;
  public static final int REPORT_THEME_DOWNLOAD_DATA_WRONG = 89068;
  public static final int REPORT_THEME_DOWNLOAD_MKDIR_FAILED = 89069;
  public static final int REPORT_THEME_DOWNLOAD_NOT_EQUAL = 89066;
  public static final int REPORT_THEME_DOWNLOAD_RENAME_FAILED = 89067;
  public static final String REPORT_THEME_DOWNLOAD_TAG = "report_theme_file_download";
  static final int REPORT_THEME_INFO = 1;
  private static final String TAG = "ThemeUiPlugin";
  static String initCurrThemeNameForReport;
  static int initDownloadedThemeNumForReport;
  static Handler reportHandler;
  static int reportTimes;
  
  public static void destroy(QQAppInterface paramQQAppInterface)
  {
    initDownloadedThemeNumForReport = 0;
    initCurrThemeNameForReport = null;
    reportTimes = 0;
    paramQQAppInterface = reportHandler;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.removeMessages(1);
    }
  }
  
  public static String getReportCurrThemeName()
  {
    String str = SkinEngine.getInstances().getSkinRootPath();
    if ((str != null) && (str.trim().length() != 0)) {
      return ThemeUtil.getCurrentThemeId();
    }
    return "default_theme";
  }
  
  public static void reportThemeNumAndCurrThemeName(QQAppInterface paramQQAppInterface, String paramString)
  {
    reportTimes = 0;
    if (reportHandler == null) {
      reportHandler = new ThemeUiPlugin.ReportThemeInfoHandler(BaseApplication.getContext().getMainLooper());
    }
    reportHandler.removeMessages(1);
    initDownloadedThemeNumForReport = 0;
    initCurrThemeNameForReport = null;
    paramQQAppInterface.execute(new ThemeUiPlugin.1(paramQQAppInterface, paramString));
  }
  
  void OnActivityResume()
  {
    this.activity.setTitle(HardCodeUtil.a(2131912237));
  }
  
  protected long getPluginBusiness()
  {
    return 32L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 3L;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("BaseWebActivity onActivityResult requestCode=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",resultCode=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.i("ThemeUiPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        break;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        try
        {
          localObject1 = paramIntent.getStringExtra("callbackSn");
          Object localObject2 = paramIntent.getStringExtra("result");
          paramIntent = new JSONObject();
          paramIntent.put("responseId", localObject1);
          paramIntent.put("responseData", new JSONObject((String)localObject2));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("BaseWebActivity loadUrl setMessage =");
            ((StringBuilder)localObject1).append(paramIntent.toString());
            QLog.i("ThemeUiPlugin", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = this.mRuntime.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("javascript:window.qqJSBridge&&qqJSBridge.setMessage('");
          ((StringBuilder)localObject2).append(paramIntent.toString());
          ((StringBuilder)localObject2).append("');");
          ((CustomWebView)localObject1).loadUrl(((StringBuilder)localObject2).toString());
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin
 * JD-Core Version:    0.7.0.1
 */