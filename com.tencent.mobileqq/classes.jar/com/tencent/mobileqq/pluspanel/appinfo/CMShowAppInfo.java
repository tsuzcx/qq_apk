package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class CMShowAppInfo
  extends PlusPanelAppInfo
{
  CMShowAppInfo() {}
  
  public CMShowAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838552;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 215;
    }
    return 1200000008;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 514;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130215;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690590);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    boolean bool = localQQAppInterface.getApplication().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).getBoolean("chat_tool_apollo_" + localQQAppInterface.getCurrentAccountUin(), false);
    paramPlusPanelViewModel.a("chat_tool_apollo", localQQAppInterface.getCurrentAccountUin());
    if (bool) {
      paramPlusPanelViewModel.b(paramBaseChatPie);
    }
    for (int i = 1;; i = 0)
    {
      paramBaseChatPie.p(0);
      paramPlusPanelViewModel = (IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      paramBaseChatPie = paramSessionInfo.jdField_a_of_type_JavaLangString;
      int j = paramPlusPanelViewModel.getApolloStatus(localQQAppInterface.getCurrentUin());
      int k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportUserResult(paramPlusPanelViewModel.getApolloUserStatus(localQQAppInterface));
      String str = "" + i;
      if (paramSessionInfo.jdField_a_of_type_Int == 0) {}
      for (paramPlusPanelViewModel = "0";; paramPlusPanelViewModel = "2")
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "panel_enter_clk", paramBaseChatPie, j, k, new String[] { str, paramPlusPanelViewModel, "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloDtReportUtil.a("aio", "plus_panel", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(localQQAppInterface)).b(ApolloDtReportUtil.a(paramSessionInfo.jdField_a_of_type_Int)).b(paramSessionInfo.jdField_a_of_type_JavaLangString).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.CMShowAppInfo
 * JD-Core Version:    0.7.0.1
 */