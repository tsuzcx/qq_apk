package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.apollo.aio.panel.api.IApolloPanelProvider;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
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
    return 2130838452;
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
    return BaseApplicationImpl.getContext().getString(2131887429);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    Object localObject = localQQAppInterface.getApplication().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chat_tool_apollo_");
    localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    paramPlusPanelViewModel.a("chat_tool_apollo", localQQAppInterface.getCurrentAccountUin());
    int i;
    if (bool)
    {
      paramPlusPanelViewModel.b(paramBaseChatPie);
      i = 1;
    }
    else
    {
      i = 0;
    }
    paramPlusPanelViewModel = paramBaseChatPie.bq();
    if (paramPlusPanelViewModel != null)
    {
      paramPlusPanelViewModel = (IApolloPanelProvider)paramPlusPanelViewModel.f(21);
      if (paramPlusPanelViewModel != null) {
        paramPlusPanelViewModel.showApolloStatusPanel(0);
      }
    }
    paramPlusPanelViewModel = (IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    paramBaseChatPie = paramSessionInfo.b;
    int j = paramPlusPanelViewModel.getApolloStatus(localQQAppInterface.getCurrentUin());
    int k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportUserResult(paramPlusPanelViewModel.getApolloUserStatus());
    paramPlusPanelViewModel = new StringBuilder();
    paramPlusPanelViewModel.append("");
    paramPlusPanelViewModel.append(i);
    localObject = paramPlusPanelViewModel.toString();
    if (paramSessionInfo.a == 0) {
      paramPlusPanelViewModel = "0";
    } else {
      paramPlusPanelViewModel = "2";
    }
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "panel_enter_clk", paramBaseChatPie, j, k, new String[] { localObject, paramPlusPanelViewModel, "", String.valueOf(System.currentTimeMillis() / 1000L) });
    paramPlusPanelViewModel = (IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class);
    paramPlusPanelViewModel.report("aio", "plus_panel", "click", new DtReportParamsBuilder().a(paramPlusPanelViewModel.getApolloMode(localQQAppInterface)).b(paramPlusPanelViewModel.getReportSessionType(paramSessionInfo.a)).c(paramSessionInfo.b).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.CMShowAppInfo
 * JD-Core Version:    0.7.0.1
 */