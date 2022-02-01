package com.tencent.mobileqq.leba.business.mgr;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.leba.business.ILebaTableMgrTitleBiz;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconProcessor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import mqq.app.AppRuntime;

public class LebaDiyIconTableMgTitle
  implements ILebaTableMgrTitleBiz
{
  public String a()
  {
    String str2 = QVipPersonalIconProcessor.e().a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface))
    {
      QLog.i("LebaDiyIconTableMgTitle", 1, "jumpToThemeShop appRuntime !instanceof QQAppInterface");
      return;
    }
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    String str = a();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str.replace("[uid]", "").replace("[lType]", "1"));
    paramContext.startActivity(localIntent);
    ReportController.b(paramAppRuntime, "dc00898", "", "", "0X800AE51", "0X800AE51", VipInfoHandler.a(paramAppRuntime, paramAppRuntime.getCurrentUin(), false), 0, "0", "0", "", "");
    ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("150000.150100");
    MobileReportManager.getInstance().reportAction("Theme", "4", "platform898", "1", null, 102, 1, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mgr.LebaDiyIconTableMgTitle
 * JD-Core Version:    0.7.0.1
 */