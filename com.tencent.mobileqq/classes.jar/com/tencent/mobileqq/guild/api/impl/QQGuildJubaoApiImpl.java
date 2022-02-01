package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import mqq.app.AppRuntime;

public class QQGuildJubaoApiImpl
  implements IQQGuildJubaoApi
{
  public void reportGuild(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    paramString2 = NewReportPlugin.a(paramString2, 10014);
    paramString2.putString("groupcode", paramString1);
    NewReportPlugin.a(paramQBaseActivity, paramString3, paramString1, paramString4, paramQBaseActivity.getAppRuntime().getAccount(), paramInt, null, paramString2);
  }
  
  public void reportGuild(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString2 = NewReportPlugin.a(paramString2, 10014);
    } else {
      paramString2 = null;
    }
    NewReportPlugin.a(paramQBaseActivity, paramString1, null, null, paramString1, paramQBaseActivity.getAppRuntime().getAccount(), paramInt, null, paramString2);
  }
  
  public void reportGuild(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = NewReportPlugin.a(paramString2, 10014);
    paramString2.putString("groupcode", paramString1);
    NewReportPlugin.a(paramQBaseActivity, paramString3, null, "0", paramString1, paramQBaseActivity.getAppRuntime().getAccount(), 25082, null, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.QQGuildJubaoApiImpl
 * JD-Core Version:    0.7.0.1
 */