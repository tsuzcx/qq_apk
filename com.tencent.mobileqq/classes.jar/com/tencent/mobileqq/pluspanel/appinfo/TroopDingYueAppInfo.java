package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import ayfu;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopDingYueAppInfo
  extends PlusPanelAppInfo
{
  public TroopDingYueAppInfo() {}
  
  public TroopDingYueAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130842479;
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
    return BaseApplicationImpl.getContext().getString(2131696779);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramayfu.a("chat_tool_dingyue", localQQAppInterface.getCurrentAccountUin());
    paramayfu.b(paramBaseChatPie);
    paramayfu = new Intent(paramBaseChatPie.getActivity(), QQBrowserActivity.class);
    paramayfu.putExtra("url", "https://buluo.qq.com/cgi-bin/bar/group_subscribe/entrance?gid=" + paramSessionInfo.curFriendUin);
    paramBaseChatPie.getActivity().startActivity(paramayfu);
    bcef.b(localQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_sub", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopDingYueAppInfo
 * JD-Core Version:    0.7.0.1
 */