package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class AAShouKuanAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839256;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1200000010;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 0;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131717131);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
    paramPlusPanelViewModel.putExtra("url", "https://mqq.tenpay.com/v2/hybrid/www/mobile_qq/aareceive/index.shtml" + "?_wv=1793&f=6&uintype=3000&touin=" + paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramPlusPanelViewModel.putExtra("app_info", "appid#20000002|bargainor_id#1000026801|channel#aio");
    paramBaseChatPie.a().startActivity(paramPlusPanelViewModel);
    ReportController.b(paramBaseChatPie.a, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "shoukuan_AIOclick", 0, 0, "", "", "", "");
    AIOPanelUtiles.a(paramBaseChatPie.a, "0X8005CBB", paramSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AAShouKuanAppInfo
 * JD-Core Version:    0.7.0.1
 */