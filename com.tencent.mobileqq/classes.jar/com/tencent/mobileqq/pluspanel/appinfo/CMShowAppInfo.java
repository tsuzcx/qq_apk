package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import amme;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class CMShowAppInfo
  extends PlusPanelAppInfo
{
  public CMShowAppInfo() {}
  
  public CMShowAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838479;
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
    return BaseApplicationImpl.getContext().getString(2131690488);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    boolean bool = localQQAppInterface.getApplication().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).getBoolean("chat_tool_apollo_" + localQQAppInterface.getCurrentAccountUin(), false);
    paramahvi.a("chat_tool_apollo", localQQAppInterface.getCurrentAccountUin());
    if (bool) {
      paramahvi.b(paramBaseChatPie);
    }
    for (int i = 1;; i = 0)
    {
      paramBaseChatPie.showApolloStatusPanel(0);
      paramahvi = (amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
      paramBaseChatPie = paramSessionInfo.curFriendUin;
      int j = paramahvi.b(localQQAppInterface.getCurrentUin());
      int k = ApolloUtil.h(amme.a(localQQAppInterface));
      String str = "" + i;
      if (paramSessionInfo.curType == 0) {}
      for (paramahvi = "0";; paramahvi = "2")
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "panel_enter_clk", paramBaseChatPie, j, k, new String[] { str, paramahvi, "", String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.CMShowAppInfo
 * JD-Core Version:    0.7.0.1
 */