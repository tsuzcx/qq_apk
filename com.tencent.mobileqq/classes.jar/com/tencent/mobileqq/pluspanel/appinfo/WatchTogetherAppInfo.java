package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import aqxe;
import argl;
import arhh;
import bejv;
import beki;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839234;
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
    return BaseApplicationImpl.getContext().getString(2131698279);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.getActivity() == null)) {}
    argl localargl;
    QQAppInterface localQQAppInterface;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
      } while (paramSessionInfo.curType != 1);
      localargl = (argl)aqxe.a().a(535);
      if ((localargl == null) || (localargl.a == null))
      {
        QQToast.a(paramBaseChatPie.getActivity(), 0, 2131692995, 0).a();
        return;
      }
      localQQAppInterface = paramBaseChatPie.app;
      localTroopInfo = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.curFriendUin);
    } while (localTroopInfo == null);
    bejv localbejv = (bejv)localQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = localbejv.a(2, 1, localTroopInfo.uin);
    paramSessionInfo = beki.a(bool, localTroopInfo.isTroopOwner(localQQAppInterface.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, paramSessionInfo.curFriendUin, 0);
    switch (localargl.a.a())
    {
    default: 
      if (localbejv.a(paramBaseChatPie.getActivity(), 2, localTroopInfo.troopuin, 0)) {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherAppInfo", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
        }
      }
      break;
    }
    while (beki.a(localQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false))
    {
      beki.a(localQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", false, false);
      paramahvi.b(paramBaseChatPie);
      return;
      QQToast.a(paramBaseChatPie.getActivity(), 0, 2131692995, 0).a();
      continue;
      if (bool)
      {
        localbejv.b(paramBaseChatPie.getActivity(), localTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
      }
      else
      {
        localbejv.a(paramBaseChatPie.getActivity(), localTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
        continue;
        localbejv.a("video_tab", "clk_panelvideo", 0, localTroopInfo.troopuin);
        beki.a(localQQAppInterface, localargl.a.b(), localargl.a.a(), localargl.a.b(), paramSessionInfo, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.WatchTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */