package com.tencent.mobileqq.pluspanel.appinfo;

import agwt;
import amtj;
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

public class TroopTouPiaoAppInfo
  extends PlusPanelAppInfo
{
  public TroopTouPiaoAppInfo() {}
  
  public TroopTouPiaoAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130842521;
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
    return BaseApplicationImpl.getContext().getString(2131697245);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramayfu.a("chat_tool_toupiao", localQQAppInterface.getCurrentAccountUin());
    paramayfu.b(paramBaseChatPie);
    paramayfu = new Intent(paramBaseChatPie.getActivity(), QQBrowserActivity.class);
    paramayfu.putExtra("selfSet_leftViewText", amtj.a(2131707411));
    paramayfu.putExtra("url", "https://client.qun.qq.com/qqweb/m/qun/vote/index.html?_wv=1031&_bid=2035&groupuin=" + paramSessionInfo.curFriendUin + "&src=3");
    paramBaseChatPie.getActivity().startActivity(paramayfu);
    bcef.b(localQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_vote", 0, 0, "", "", "", "");
    agwt.a(localQQAppInterface, "0X8005CB9", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopTouPiaoAppInfo
 * JD-Core Version:    0.7.0.1
 */