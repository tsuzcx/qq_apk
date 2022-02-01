package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.IVACDReportService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VACDReportReceiver
  extends BroadcastReceiver
{
  public void a(ReportItem paramReportItem)
  {
    Object localObject1;
    Object localObject2;
    String str1;
    String str2;
    String str3;
    String str4;
    if ((paramReportItem != null) && (!TextUtils.isEmpty(paramReportItem.failReason)) && (paramReportItem.step != null) && (paramReportItem.step.equals("crash")) && ((paramReportItem.result == 668814) || (paramReportItem.result == 668815)))
    {
      localObject1 = QWalletTools.a();
      if (localObject1 == null) {
        return;
      }
      localObject2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).BridgeHelper$mConfigContents(((BaseQQAppInterface)localObject1).getApp(), ((BaseQQAppInterface)localObject1).getCurrentAccountUin());
      if (localObject2 == null) {
        return;
      }
      localObject1 = (String)((HashMap)localObject2).get("crash_title");
      str1 = (String)((HashMap)localObject2).get("crash_content");
      str2 = (String)((HashMap)localObject2).get("crash_btn");
      str3 = (String)((HashMap)localObject2).get("crash_url");
      str4 = (String)((HashMap)localObject2).get("crash_modelRegex");
      localObject2 = (String)((HashMap)localObject2).get("crash_crashRegex");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1))) {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
      }
    }
    try
    {
      if (!TextUtils.isEmpty(str4))
      {
        String str5 = Build.MODEL;
        if (TextUtils.isEmpty(str5)) {
          return;
        }
        if (!Pattern.compile(str4).matcher(str5).matches()) {
          return;
        }
      }
      boolean bool = Pattern.compile((String)localObject2).matcher(paramReportItem.failReason).matches();
      if (!bool) {
        return;
      }
      paramReportItem = new Intent();
      paramReportItem.addFlags(268435456);
      paramReportItem.putExtra("title", (String)localObject1);
      paramReportItem.putExtra("content", str1);
      paramReportItem.putExtra("btn", str2);
      paramReportItem.putExtra("url", str3);
      paramReportItem.putExtra("pay_requestcode", 201);
      RouteUtils.a(BaseApplication.getContext(), paramReportItem, "/base/payBridge");
      return;
    }
    catch (Exception paramReportItem) {}
  }
  
  public void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("vacdReport_extra:step");
    long l = paramIntent.getLongExtra("vacdReport_extra:seqno", -1L);
    ReportItem localReportItem = (ReportItem)paramIntent.getSerializableExtra("vacdReport_extra:item");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive: step=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", seqno=");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", item=");
      ((StringBuilder)localObject).append(localReportItem);
      QLog.i("VACDReport", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = QWalletHelperImpl.getAppRuntime();
    if ((localObject instanceof BaseQQAppInterface))
    {
      localObject = (IVACDReportService)((BaseQQAppInterface)localObject).getRuntimeService(IVACDReportService.class, "");
      if (localObject == null) {
        return;
      }
      if ("vacdReport_step:start".equals(str)) {
        ((IVACDReportService)localObject).startReport(paramIntent.getStringExtra("vacdReport_extra:sKey"), (ReportHeader)paramIntent.getSerializableExtra("vacdReport_extra:header"), localReportItem);
      } else if ("vacdReport_step:add".equals(str)) {
        ((IVACDReportService)localObject).addReportItem(l, paramIntent.getStringExtra("vacdReport_extra:sKey"), localReportItem);
      } else if ("vacdReport_step:end".equals(str)) {
        ((IVACDReportService)localObject).endReport(l, localReportItem);
      } else if ("vacdReport_step:single".equals(str)) {
        ((IVACDReportService)localObject).singleReport(paramIntent.getStringExtra("vacdReport_extra:sKey"), (ReportHeader)paramIntent.getSerializableExtra("vacdReport_extra:header"), localReportItem);
      }
    }
    a(localReportItem);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (QWalletTools.a() == null) {
      return;
    }
    boolean bool = paramBundle.getBoolean("isRealName", false);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onRealName isRealName:");
      paramBundle.append(bool);
      QLog.i("VACDReport", 2, paramBundle.toString());
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      int i = paramIntent.getIntExtra("type", 0);
      paramContext = paramIntent.getBundleExtra("params");
      if (i != 1)
      {
        a(paramIntent);
        return;
      }
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("VACDReportReceiver", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportReceiver
 * JD-Core Version:    0.7.0.1
 */