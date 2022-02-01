package com.tencent.mobileqq.pluspanel.appinfo;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class SingTogetherAppInfo
  extends PlusPanelAppInfo
{
  SingTogetherAppInfo() {}
  
  public SingTogetherAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839309;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 220;
    }
    return 101817424;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 560;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130220;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131896544);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    paramPlusPanelViewModel = paramBaseChatPie.d;
    String str = paramPlusPanelViewModel.getCurrentAccountUin();
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)paramPlusPanelViewModel.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = localTogetherControlManager.b(4, -1, paramSessionInfo.b);
    int i;
    int j;
    if (paramSessionInfo.a == 1)
    {
      paramPlusPanelViewModel = ((TroopManager)paramPlusPanelViewModel.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramSessionInfo.b);
      if (paramPlusPanelViewModel == null) {
        return;
      }
      localBundle = TogetherUtils.a(bool, paramPlusPanelViewModel.isTroopOwner(str), paramPlusPanelViewModel.isAdmin(), paramPlusPanelViewModel.troopowneruin, paramSessionInfo.b, 0);
      localTogetherControlManager.a("sing_tab", "clk_panelsing", 0, paramSessionInfo.b);
      paramPlusPanelViewModel = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
      i = 1;
      j = 0;
    }
    else if (paramSessionInfo.a == 0)
    {
      localBundle = TogetherUtils.a(bool, 3);
      ReportController.b(paramPlusPanelViewModel, "dc00899", "c2c_AIO", "", "sing_tab", "clk_panelsing", 0, 0, paramSessionInfo.b, "", "", "");
      paramPlusPanelViewModel = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
      i = 2;
      j = 3;
    }
    else
    {
      paramPlusPanelViewModel = null;
      i = -1;
      j = -1;
    }
    if (TextUtils.isEmpty(paramPlusPanelViewModel)) {
      return;
    }
    if (bool)
    {
      localTogetherControlManager.b(paramBaseChatPie.aX(), paramSessionInfo.b, i, 4, j, localBundle);
      return;
    }
    localTogetherControlManager.a(paramBaseChatPie.aX(), paramSessionInfo.b, i, 4, j, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.SingTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */