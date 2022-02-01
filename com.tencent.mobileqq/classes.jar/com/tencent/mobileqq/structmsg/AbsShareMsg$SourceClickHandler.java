package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcommon.AppClient;
import com.tencent.qphone.base.util.QLog;

class AbsShareMsg$SourceClickHandler
  extends StructMsgClickHandler
{
  public AbsShareMsg$SourceClickHandler(AbsShareMsg paramAbsShareMsg, QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramQQAppInterface, paramView);
  }
  
  public boolean a(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3)[0];
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("SourceClickHandler click2YYB  appid = ");
      paramString2.append(paramLong);
      paramString2.append("; packageName=");
      paramString2.append(paramString1);
      QLog.d("StructMsg", 2, paramString2.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new Bundle();
    paramString2.putString("packageName", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramLong);
    paramString1.append("");
    paramString2.putString("appId", paramString1.toString());
    paramString2.putString("big_brother_source_key", "biz_src_jc_aio");
    AppClient.b(paramActivity, paramString2);
    return true;
  }
  
  public boolean a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SourceClickHandler clickWebMsg  url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("StructMsg", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      localObject = new Intent(this.c, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("title", this.a.mSourceName);
      ((Intent)localObject).putExtra("url", paramString);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.a.message, (Intent)localObject, paramString);
      this.c.startActivity((Intent)localObject);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString, "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SourceClickHandler clickAppMsg url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", actionData = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", actionDataA = ");
      localStringBuilder.append(paramString3);
      QLog.d("StructMsg", 2, localStringBuilder.toString());
    }
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3);
    paramString2 = this.c.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (paramString2 == null) {
          return false;
        }
        paramString2.putExtra("big_brother_source_key", "biz_src_jc_aio");
        paramString2.addFlags(67108864);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      label230:
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramString1.getMessage());
      }
    }
    try
    {
      paramString3 = (StartAppCheckHandler)this.b.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER);
      paramString2.putExtra("report_open_type", "structmsg_source");
      paramString2.putExtra("report_url", "");
      paramString2.putExtra("report_from", "1");
      paramString2.putExtra("report_click_origin", "AIOTail");
      paramString2.putExtra("report_class_name", this.c.getClass().getName());
      paramString3.b(paramString1[0].trim(), this.c, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      break label230;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
    }
    this.c.startActivity(paramString2);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.SourceClickHandler
 * JD-Core Version:    0.7.0.1
 */