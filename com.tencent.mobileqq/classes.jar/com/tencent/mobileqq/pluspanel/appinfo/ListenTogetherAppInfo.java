package com.tencent.mobileqq.pluspanel.appinfo;

import auzn;
import ayfu;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class ListenTogetherAppInfo
  extends PlusPanelAppInfo
{
  public ListenTogetherAppInfo() {}
  
  public ListenTogetherAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839188;
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
    return BaseApplicationImpl.getContext().getString(2131693351);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.getActivity() == null)) {}
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = paramBaseChatPie.app;
      int j;
      int k;
      if (paramSessionInfo.curType == 0)
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
          localTroopInfo = ((TroopManager)localQQAppInterface.getManager(52)).c(paramSessionInfo.curFriendUin);
          str = localQQAppInterface.getCurrentAccountUin();
          if (localTroopInfo.isTroopOwner(str)) {
            i = 0;
          }
        }
        for (;;)
        {
          label80:
          auzn.b(localQQAppInterface, paramBaseChatPie.getActivity(), k, paramSessionInfo.curFriendUin, 0);
          if ((j == 0) && (auzn.a(localQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false)))
          {
            auzn.a(localQQAppInterface, "listen_together_c2c_aio_red_dot_show", false, false);
            paramayfu.b(paramBaseChatPie);
          }
          if (j == 0) {}
          for (paramayfu = "c2c_AIO";; paramayfu = "Grp_AIO")
          {
            bcef.b(null, "dc00899", paramayfu, "", "music_tab", "clk_panelmusic", 0, 0, paramSessionInfo.curFriendUin, i + "", i + "", "");
            return;
            if (paramSessionInfo.curType != 1) {
              break label248;
            }
            j = 1;
            k = 1;
            break;
            if (localTroopInfo.isTroopAdmin(str))
            {
              i = 1;
              break label80;
            }
            i = 2;
            break label80;
          }
          i = -1;
        }
        label248:
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