package com.tencent.mobileqq.leba.business.mgr;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.leba.business.ILebaTableMgrTitleBiz;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconProcessor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import mqq.app.AppRuntime;

public class LebaDiyIconTableMgTitle
  implements ILebaTableMgrTitleBiz
{
  private void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("150000.150100");
    if (paramRedTouch == null) {
      return;
    }
    paramRedTouch.b(53).a().a(localAppInfo);
    a(localAppInfo, paramQQAppInterface);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onReportRedPointExposure(paramAppInfo);
  }
  
  public String a()
  {
    String str2 = QVipPersonalIconProcessor.c().a();
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
  
  public void a(Context paramContext, AppRuntime paramAppRuntime, RelativeLayout paramRelativeLayout)
  {
    if (!(paramAppRuntime instanceof QQAppInterface))
    {
      QLog.i("LebaDiyIconTableMgTitle", 1, "jumpToThemeShop appRuntime !instanceof QQAppInterface");
      return;
    }
    paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131369223);
    if (paramRelativeLayout == null)
    {
      QLog.i("LebaDiyIconTableMgTitle", 1, "rightIcon == null");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
    QVipPersonalIconConfig localQVipPersonalIconConfig = QVipPersonalIconProcessor.c();
    boolean bool = StudyModeManager.a();
    if ((localQVipPersonalIconConfig.a()) && (!bool))
    {
      paramRelativeLayout.setOnClickListener(new LebaDiyIconTableMgTitle.1(this, paramContext, paramAppRuntime));
      paramRelativeLayout.setImageResource(2130850565);
      paramRelativeLayout.setClickable(true);
      paramRelativeLayout.setVisibility(0);
      a(localQQAppInterface, new RedTouch(paramContext, paramRelativeLayout).b(53).a());
      if (AppSetting.d) {
        AccessibilityUtil.a(paramRelativeLayout, paramContext.getResources().getString(2131719623), Button.class.getName());
      }
      MobileReportManager.getInstance().reportAction("Theme", "4", "platform898", "1", null, 101, 1, System.currentTimeMillis());
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("hide mRightIcon isShowIconEntry=");
    paramContext.append(localQVipPersonalIconConfig.a());
    paramContext.append(",isStudyMode=");
    paramContext.append(bool);
    QLog.d("LebaDiyIconTableMgTitle", 1, paramContext.toString());
    paramRelativeLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mgr.LebaDiyIconTableMgTitle
 * JD-Core Version:    0.7.0.1
 */