package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class ListenTogetherAppInfo
  extends PlusPanelAppInfo
{
  ListenTogetherAppInfo() {}
  
  public ListenTogetherAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839277;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 207;
    }
    return 101761547;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 508;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130207;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131693688);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null)) {}
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = paramBaseChatPie.a;
      int j;
      int k;
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        j = 0;
        k = 2;
      }
      while (k != 0)
      {
        TroopInfo localTroopInfo;
        String str;
        int i;
        if (j != 0)
        {
          localTroopInfo = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
          str = localQQAppInterface.getCurrentAccountUin();
          if (localTroopInfo.isTroopOwner(str)) {
            i = 0;
          }
        }
        for (;;)
        {
          label81:
          ListenTogetherUtils.b(localQQAppInterface, paramBaseChatPie.a(), k, paramSessionInfo.jdField_a_of_type_JavaLangString, 0);
          if ((j == 0) && (ListenTogetherUtils.a(localQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false)))
          {
            ListenTogetherUtils.a(localQQAppInterface, "listen_together_c2c_aio_red_dot_show", false, false);
            paramPlusPanelViewModel.b(paramBaseChatPie);
          }
          if (j == 0) {}
          for (paramPlusPanelViewModel = "c2c_AIO";; paramPlusPanelViewModel = "Grp_AIO")
          {
            ReportController.b(null, "dc00899", paramPlusPanelViewModel, "", "music_tab", "clk_panelmusic", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, i + "", i + "", "");
            return;
            if (paramSessionInfo.jdField_a_of_type_Int != 1) {
              break label249;
            }
            j = 1;
            k = 1;
            break;
            if (localTroopInfo.isTroopAdmin(str))
            {
              i = 1;
              break label81;
            }
            i = 2;
            break label81;
          }
          i = -1;
        }
        label249:
        j = 0;
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ListenTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */