package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.os.Bundle;
import android.text.TextUtils;
import bdla;
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
import com.tencent.qphone.base.util.BaseApplication;

public class SingTogetherAppInfo
  extends PlusPanelAppInfo
{
  public SingTogetherAppInfo() {}
  
  public SingTogetherAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839229;
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
    return BaseApplicationImpl.getContext().getString(2131698254);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i = -1;
    int j = -1;
    Bundle localBundle = new Bundle();
    paramahvi = paramBaseChatPie.app;
    String str = paramahvi.getCurrentAccountUin();
    bejv localbejv = (bejv)paramahvi.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = localbejv.a(4, -1, paramSessionInfo.curFriendUin);
    if (paramSessionInfo.curType == 1)
    {
      j = 0;
      paramahvi = ((TroopManager)paramahvi.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.curFriendUin);
      if (paramahvi != null) {}
    }
    for (;;)
    {
      return;
      localBundle = beki.a(bool, paramahvi.isTroopOwner(str), paramahvi.isAdmin(), paramahvi.troopowneruin, paramSessionInfo.curFriendUin, 0);
      localbejv.a("sing_tab", "clk_panelsing", 0, paramSessionInfo.curFriendUin);
      i = 1;
      paramahvi = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
      while (!TextUtils.isEmpty(paramahvi))
      {
        if (bool)
        {
          localbejv.b(paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, i, 4, j, localBundle);
          return;
          if (paramSessionInfo.curType == 0)
          {
            localBundle = beki.a(bool, 3);
            bdla.b(paramahvi, "dc00899", "c2c_AIO", "", "sing_tab", "clk_panelsing", 0, 0, paramSessionInfo.curFriendUin, "", "", "");
            j = 3;
            i = 2;
            paramahvi = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
          }
        }
        else
        {
          localbejv.a(paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, i, 4, j, localBundle);
          return;
        }
        paramahvi = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.SingTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */