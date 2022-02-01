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
    return 2130839298;
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
    return BaseApplicationImpl.getContext().getString(2131698531);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i = -1;
    int j = -1;
    Bundle localBundle = new Bundle();
    paramPlusPanelViewModel = paramBaseChatPie.a;
    String str = paramPlusPanelViewModel.getCurrentAccountUin();
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)paramPlusPanelViewModel.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = localTogetherControlManager.a(4, -1, paramSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      j = 0;
      paramPlusPanelViewModel = ((TroopManager)paramPlusPanelViewModel.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramPlusPanelViewModel != null) {}
    }
    for (;;)
    {
      return;
      localBundle = TogetherUtils.a(bool, paramPlusPanelViewModel.isTroopOwner(str), paramPlusPanelViewModel.isAdmin(), paramPlusPanelViewModel.troopowneruin, paramSessionInfo.jdField_a_of_type_JavaLangString, 0);
      localTogetherControlManager.a("sing_tab", "clk_panelsing", 0, paramSessionInfo.jdField_a_of_type_JavaLangString);
      i = 1;
      paramPlusPanelViewModel = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
      while (!TextUtils.isEmpty(paramPlusPanelViewModel))
      {
        if (bool)
        {
          localTogetherControlManager.b(paramBaseChatPie.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, i, 4, j, localBundle);
          return;
          if (paramSessionInfo.jdField_a_of_type_Int == 0)
          {
            localBundle = TogetherUtils.a(bool, 3);
            ReportController.b(paramPlusPanelViewModel, "dc00899", "c2c_AIO", "", "sing_tab", "clk_panelsing", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            j = 3;
            i = 2;
            paramPlusPanelViewModel = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
          }
        }
        else
        {
          localTogetherControlManager.a(paramBaseChatPie.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, i, 4, j, localBundle);
          return;
        }
        paramPlusPanelViewModel = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.SingTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */