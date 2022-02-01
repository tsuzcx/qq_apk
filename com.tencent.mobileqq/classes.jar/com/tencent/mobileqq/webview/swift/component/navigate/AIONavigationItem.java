package com.tencent.mobileqq.webview.swift.component.navigate;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.webview.swift.INavigationProcess;
import com.tencent.qphone.base.util.QLog;

public class AIONavigationItem
  implements INavigationProcess
{
  private boolean a(String paramString)
  {
    paramString = Uri.parse(paramString);
    boolean bool = false;
    if ((paramString != null) && (paramString.isHierarchical()))
    {
      paramString = paramString.getQueryParameter("_wwv");
      if (paramString == null) {}
    }
    try
    {
      long l = Long.parseLong(paramString.trim());
      if (0L != (0x800 & l)) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException paramString)
    {
      label51:
      break label51;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
    }
    return false;
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramActivity.getClass() != SingleTaskQQBrowser.class) && (a(paramString)))
    {
      if (AuthorizeConfig.a().f("aio_authorize_config", paramString))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("WebViewSwitchAio canSwitchAIO  url ");
          localStringBuilder.append(paramString);
          QLog.d("AIONavigationItem", 1, localStringBuilder.toString());
        }
        paramIntent = new Intent(paramIntent);
        paramIntent.setComponent(new ComponentName(paramActivity, SingleTaskQQBrowser.class));
        paramIntent.setFlags(402653184);
        paramActivity.startActivity(paramIntent);
        return true;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("WebViewSwitchAio want to switchToAIO, but don't have command right. url : ");
      paramIntent.append(paramString);
      QLog.e("AIONavigationItem", 1, paramIntent.toString());
    }
    return false;
  }
  
  public boolean b(Intent paramIntent, Activity paramActivity, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.navigate.AIONavigationItem
 * JD-Core Version:    0.7.0.1
 */