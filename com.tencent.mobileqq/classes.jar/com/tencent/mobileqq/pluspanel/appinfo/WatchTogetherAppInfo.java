package com.tencent.mobileqq.pluspanel.appinfo;

import apub;
import aqde;
import aqea;
import ayfu;
import bdct;
import bddg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
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
    return 2130839213;
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
    return BaseApplicationImpl.getContext().getString(2131697994);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.getActivity() == null)) {}
    aqde localaqde;
    QQAppInterface localQQAppInterface;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
      } while (paramSessionInfo.curType != 1);
      localaqde = (aqde)apub.a().a(535);
      if ((localaqde == null) || (localaqde.a == null))
      {
        QQToast.a(paramBaseChatPie.getActivity(), 0, 2131692889, 0).a();
        return;
      }
      localQQAppInterface = paramBaseChatPie.app;
      localTroopInfo = ((TroopManager)localQQAppInterface.getManager(52)).c(paramSessionInfo.curFriendUin);
    } while (localTroopInfo == null);
    bdct localbdct = (bdct)localQQAppInterface.getManager(339);
    boolean bool = localbdct.a(2, 1, localTroopInfo.uin);
    paramSessionInfo = bddg.a(bool, localTroopInfo.isTroopOwner(localQQAppInterface.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, paramSessionInfo.curFriendUin, 0);
    switch (localaqde.a.a())
    {
    default: 
      if (localbdct.a(paramBaseChatPie.getActivity(), 2, localTroopInfo.troopuin, 0)) {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherAppInfo", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
        }
      }
      break;
    }
    while (bddg.a(localQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false))
    {
      bddg.a(localQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", false, false);
      paramayfu.b(paramBaseChatPie);
      return;
      QQToast.a(paramBaseChatPie.getActivity(), 0, 2131692889, 0).a();
      continue;
      if (bool)
      {
        localbdct.b(paramBaseChatPie.getActivity(), localTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
      }
      else
      {
        localbdct.a(paramBaseChatPie.getActivity(), localTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
        continue;
        localbdct.a("video_tab", "clk_panelvideo", 0, localTroopInfo.troopuin);
        bddg.a(localQQAppInterface, localaqde.a.b(), localaqde.a.a(), localaqde.a.b(), paramSessionInfo, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.WatchTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */