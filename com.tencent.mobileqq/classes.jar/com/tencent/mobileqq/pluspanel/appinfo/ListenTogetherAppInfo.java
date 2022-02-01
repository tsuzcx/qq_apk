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
    return 2130839131;
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
    return BaseApplicationImpl.getContext().getString(2131693641);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramBaseChatPie != null)
    {
      if (paramBaseChatPie.a() == null) {
        return;
      }
      Object localObject = paramBaseChatPie.a;
      int i;
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        i = 2;
      }
      else
      {
        if (paramSessionInfo.jdField_a_of_type_Int == 1)
        {
          j = 1;
          k = 1;
          break label58;
        }
        i = 0;
      }
      int k = 0;
      int j = i;
      label58:
      if (j != 0)
      {
        i = -1;
        if (k != 0)
        {
          TroopInfo localTroopInfo = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
          String str = ((QQAppInterface)localObject).getCurrentAccountUin();
          if (localTroopInfo.isTroopOwner(str)) {
            i = 0;
          } else if (localTroopInfo.isTroopAdmin(str)) {
            i = 1;
          } else {
            i = 2;
          }
        }
        ListenTogetherUtils.b((QQAppInterface)localObject, paramBaseChatPie.a(), j, paramSessionInfo.jdField_a_of_type_JavaLangString, 0);
        if ((k == 0) && (ListenTogetherUtils.a((QQAppInterface)localObject, "listen_together_c2c_aio_red_dot_show", true, false)))
        {
          ListenTogetherUtils.a((QQAppInterface)localObject, "listen_together_c2c_aio_red_dot_show", false, false);
          paramPlusPanelViewModel.b(paramBaseChatPie);
        }
        if (k == 0) {
          paramPlusPanelViewModel = "c2c_AIO";
        } else {
          paramPlusPanelViewModel = "Grp_AIO";
        }
        paramBaseChatPie = paramSessionInfo.jdField_a_of_type_JavaLangString;
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append(i);
        paramSessionInfo.append("");
        paramSessionInfo = paramSessionInfo.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("");
        ReportController.b(null, "dc00899", paramPlusPanelViewModel, "", "music_tab", "clk_panelmusic", 0, 0, paramBaseChatPie, paramSessionInfo, ((StringBuilder)localObject).toString(), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ListenTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */