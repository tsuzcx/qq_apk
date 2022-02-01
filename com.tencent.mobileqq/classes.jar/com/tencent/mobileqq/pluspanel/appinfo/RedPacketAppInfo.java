package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.qwallet.utils.ReportUtils;
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
    return 2130839276;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 219;
    }
    return 1104864062;
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
    return BaseApplicationImpl.getContext().getString(2131719025);
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
    paramBaseChatPie.q(10);
    PlusPanelUtils.a(0);
    paramPlusPanelViewModel = "";
    if ((paramSessionInfo.a == 0) || (paramSessionInfo.a == 1000) || (paramSessionInfo.a == 1004) || (paramSessionInfo.a == 1001) || (paramSessionInfo.a == 10002) || (paramSessionInfo.a == 10004) || (paramSessionInfo.a == 10008)) {
      paramPlusPanelViewModel = "entrance.click.c2c.plus";
    }
    for (;;)
    {
      ReportController.b(paramBaseChatPie.a, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramPlusPanelViewModel, 0, 0, "", "", "", "");
      ReportUtils.a(paramBaseChatPie.a, "aio.luckyplus.click", paramSessionInfo);
      return;
      if (paramSessionInfo.a == 3000) {
        paramPlusPanelViewModel = "entrance.click.group.plus";
      } else if (paramSessionInfo.a == 1) {
        paramPlusPanelViewModel = "entrance.click.chatgroup.plus";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.RedPacketAppInfo
 * JD-Core Version:    0.7.0.1
 */