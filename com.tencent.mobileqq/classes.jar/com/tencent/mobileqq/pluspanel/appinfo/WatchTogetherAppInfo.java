package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherConfigureBean;
import com.tencent.mobileqq.config.business.WatchTogetherBean;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839158;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 101793773;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 0;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698622);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramBaseChatPie != null)
    {
      if (paramBaseChatPie.a() == null) {
        return;
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 1) {
        return;
      }
      TogetherConfigureBean localTogetherConfigureBean = (TogetherConfigureBean)QConfigManager.a().a(535);
      if ((localTogetherConfigureBean != null) && (localTogetherConfigureBean.a != null))
      {
        QQAppInterface localQQAppInterface = paramBaseChatPie.a;
        TroopInfo localTroopInfo = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (localTroopInfo == null) {
          return;
        }
        TogetherControlManager localTogetherControlManager = (TogetherControlManager)localQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        boolean bool = localTogetherControlManager.a(2, 1, localTroopInfo.uin);
        paramSessionInfo = TogetherUtils.a(bool, localTroopInfo.isTroopOwner(localQQAppInterface.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, paramSessionInfo.jdField_a_of_type_JavaLangString, 0);
        int i = localTogetherConfigureBean.a.a();
        if (i != 0)
        {
          if (i != 1)
          {
            if (localTogetherControlManager.a(paramBaseChatPie.a(), 2, localTroopInfo.troopuin, 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("WatchTogetherAppInfo", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
              }
            }
            else
            {
              localTogetherControlManager.a("video_tab", "clk_panelvideo", 0, localTroopInfo.troopuin);
              TogetherUtils.a(localQQAppInterface, localTogetherConfigureBean.a.b(), localTogetherConfigureBean.a.a(), localTogetherConfigureBean.a.b(), paramSessionInfo, 1);
            }
          }
          else if (bool) {
            localTogetherControlManager.b(paramBaseChatPie.a(), localTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
          } else {
            localTogetherControlManager.a(paramBaseChatPie.a(), localTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
          }
        }
        else {
          QQToast.a(paramBaseChatPie.a(), 0, 2131693100, 0).a();
        }
        if (TogetherUtils.a(localQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false))
        {
          TogetherUtils.a(localQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", false, false);
          paramPlusPanelViewModel.b(paramBaseChatPie);
        }
        return;
      }
      QQToast.a(paramBaseChatPie.a(), 0, 2131693100, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.WatchTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */