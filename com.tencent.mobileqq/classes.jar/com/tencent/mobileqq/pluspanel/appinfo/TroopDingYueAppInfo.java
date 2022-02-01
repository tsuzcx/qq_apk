package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopDingYueAppInfo
  extends PlusPanelAppInfo
{
  TroopDingYueAppInfo() {}
  
  public TroopDingYueAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130842554;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 1000000003;
    }
    return 1200000001;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697319);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    paramPlusPanelViewModel.a("chat_tool_dingyue", localQQAppInterface.getCurrentAccountUin());
    paramPlusPanelViewModel.b(paramBaseChatPie);
    paramPlusPanelViewModel = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://buluo.qq.com/cgi-bin/bar/group_subscribe/entrance?gid=");
    localStringBuilder.append(paramSessionInfo.a);
    paramPlusPanelViewModel.putExtra("url", localStringBuilder.toString());
    paramBaseChatPie.a().startActivity(paramPlusPanelViewModel);
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_sub", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopDingYueAppInfo
 * JD-Core Version:    0.7.0.1
 */