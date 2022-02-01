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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopTouPiaoAppInfo
  extends PlusPanelAppInfo
{
  TroopTouPiaoAppInfo() {}
  
  public TroopTouPiaoAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130843549;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1104536706;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131895555);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    paramPlusPanelViewModel.a("chat_tool_toupiao", localQQAppInterface.getCurrentAccountUin());
    paramPlusPanelViewModel.b(paramBaseChatPie);
    paramPlusPanelViewModel = new Intent(paramBaseChatPie.aX(), QQBrowserActivity.class);
    paramPlusPanelViewModel.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://client.qun.qq.com/qqweb/m/qun/vote/index.html?_wv=1031&_bid=2035&groupuin=");
    localStringBuilder.append(paramSessionInfo.b);
    localStringBuilder.append("&src=3");
    paramPlusPanelViewModel.putExtra("url", localStringBuilder.toString());
    paramBaseChatPie.aX().startActivity(paramPlusPanelViewModel);
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_vote", 0, 0, "", "", "", "");
    AIOPanelUtiles.a(localQQAppInterface, "0X8005CB9", paramSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopTouPiaoAppInfo
 * JD-Core Version:    0.7.0.1
 */