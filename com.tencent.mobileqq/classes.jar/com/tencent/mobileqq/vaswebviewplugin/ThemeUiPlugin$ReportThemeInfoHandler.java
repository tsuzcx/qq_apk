package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ThemeUiPlugin$ReportThemeInfoHandler
  extends Handler
{
  public ThemeUiPlugin$ReportThemeInfoHandler() {}
  
  public ThemeUiPlugin$ReportThemeInfoHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (ThemeUiPlugin.reportHandler == null) {
      ThemeUiPlugin.reportHandler = new ReportThemeInfoHandler(BaseApplication.getContext().getMainLooper());
    }
    int i = paramMessage.what;
    Object localObject1 = (Object[])paramMessage.obj;
    if (i == 1)
    {
      if (ThemeUiPlugin.reportTimes < 3)
      {
        paramMessage = (String)localObject1[0];
        localObject1 = (QQAppInterface)localObject1[1];
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(ThemeUiPlugin.initDownloadedThemeNumForReport);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(ThemeUiPlugin.initCurrThemeNameForReport);
          QLog.i("ThemeUiPlugin", 2, ((StringBuilder)localObject2).toString());
        }
        VasWebviewUtil.a("ThemeMall", "ThemeCount", "0", 0, 0, ThemeUiPlugin.initDownloadedThemeNumForReport, 0, "", "");
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("theme_");
        ((StringBuilder)localObject2).append(ThemeUiPlugin.initCurrThemeNameForReport);
        VasWebviewUtil.a("ThemeMall", "ThemeOn", "0", 0, 0, 0, 0, ((StringBuilder)localObject2).toString(), "");
        ThemeUiPlugin.reportTimes += 1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportTimes is:");
          ((StringBuilder)localObject2).append(ThemeUiPlugin.reportTimes);
          QLog.d("ThemeUiPlugin", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = ThemeUiPlugin.reportHandler.obtainMessage();
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = new Object[] { paramMessage, localObject1 };
        ThemeUiPlugin.reportHandler.sendMessageDelayed((Message)localObject2, 120000L);
        return;
      }
      ThemeUiPlugin.reportTimes = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin.ReportThemeInfoHandler
 * JD-Core Version:    0.7.0.1
 */