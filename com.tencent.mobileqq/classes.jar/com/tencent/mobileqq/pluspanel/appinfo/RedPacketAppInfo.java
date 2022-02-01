package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class RedPacketAppInfo
  extends PlusPanelAppInfo
{
  private long mLastClickedTime;
  
  RedPacketAppInfo() {}
  
  public RedPacketAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    if (isGuildLiveChannel()) {
      return 2130840919;
    }
    if (isGuild()) {
      return 2130840992;
    }
    return 2130839286;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 219;
    }
    return 1104864062;
  }
  
  public String getDTElementId()
  {
    if (isGuild()) {
      return "em_sgrp_aio_plus_packet";
    }
    return "";
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 510;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130219;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i;
    if (isGuild()) {
      i = 2131890561;
    } else {
      i = 2131916247;
    }
    return localBaseApplication.getString(i);
  }
  
  public void init()
  {
    super.init();
    this.mLastClickedTime = 0L;
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.mLastClickedTime) < 1000L) {
      return;
    }
    this.mLastClickedTime = l;
    paramPlusPanelViewModel.b(paramBaseChatPie);
    paramBaseChatPie.o(10);
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).setPanelFrom(0);
    if ((paramSessionInfo.a != 0) && (paramSessionInfo.a != 1000) && (paramSessionInfo.a != 1004) && (paramSessionInfo.a != 1001) && (paramSessionInfo.a != 10002) && (paramSessionInfo.a != 10004) && (paramSessionInfo.a != 10008))
    {
      if (paramSessionInfo.a == 3000) {
        paramPlusPanelViewModel = "entrance.click.group.plus";
      } else if (paramSessionInfo.a == 1) {
        paramPlusPanelViewModel = "entrance.click.chatgroup.plus";
      } else {
        paramPlusPanelViewModel = "";
      }
    }
    else {
      paramPlusPanelViewModel = "entrance.click.c2c.plus";
    }
    ReportController.b(paramBaseChatPie.d, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramPlusPanelViewModel, 0, 0, "", "", "", "");
    ((IReportApi)QRoute.api(IReportApi.class)).reportHongbaoTo644(paramBaseChatPie.d, "aio.luckyplus.click", paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.RedPacketAppInfo
 * JD-Core Version:    0.7.0.1
 */