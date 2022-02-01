package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;

public class AnonymousChatSettingAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843903;
  }
  
  public int getAppID()
  {
    if (isTroop()) {
      return 1200000005;
    }
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131696042);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface;
    Object localObject;
    int i;
    if (AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localQQAppInterface = paramBaseChatPie.a;
      paramPlusPanelViewModel = localQQAppInterface.getCurrentAccountUin();
      localObject = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(paramPlusPanelViewModel))) {
        break label270;
      }
      if ((((TroopInfo)localObject).Administrator == null) || (!((TroopInfo)localObject).Administrator.contains(paramPlusPanelViewModel))) {
        break label235;
      }
      i = 3;
    }
    for (;;)
    {
      paramPlusPanelViewModel = AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(paramSessionInfo.jdField_a_of_type_JavaLangString).append("&avatar=").append(AnonymousChatHelper.a(paramPlusPanelViewModel.jdField_a_of_type_Int)).append("&nick=");
      if (TextUtils.isEmpty(paramPlusPanelViewModel.jdField_a_of_type_JavaLangString)) {}
      for (paramPlusPanelViewModel = "";; paramPlusPanelViewModel = URLEncoder.encode(paramPlusPanelViewModel.jdField_a_of_type_JavaLangString))
      {
        ((Intent)localObject).putExtra("url", paramPlusPanelViewModel + "&role=" + String.valueOf(i) + "&self=1");
        paramBaseChatPie.a().startActivity((Intent)localObject);
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
        return;
        label235:
        if (paramPlusPanelViewModel.equals(((TroopInfo)localObject).troopowneruin))
        {
          i = 2;
          break;
        }
        i = 1;
        break;
      }
      label270:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatSettingAppInfo
 * JD-Core Version:    0.7.0.1
 */