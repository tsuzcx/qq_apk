package com.tencent.mobileqq.pluspanel.appinfo;

import android.os.Bundle;
import android.text.TextUtils;
import ayfu;
import bcef;
import bdct;
import bddg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
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
    return 2130839208;
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
    return BaseApplicationImpl.getContext().getString(2131697970);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i = -1;
    int j = -1;
    Bundle localBundle = new Bundle();
    paramayfu = paramBaseChatPie.app;
    String str = paramayfu.getCurrentAccountUin();
    bdct localbdct = (bdct)paramayfu.getManager(339);
    boolean bool = localbdct.a(4, -1, paramSessionInfo.curFriendUin);
    if (paramSessionInfo.curType == 1)
    {
      j = 0;
      paramayfu = ((TroopManager)paramayfu.getManager(52)).c(paramSessionInfo.curFriendUin);
      if (paramayfu != null) {}
    }
    for (;;)
    {
      return;
      localBundle = bddg.a(bool, paramayfu.isTroopOwner(str), paramayfu.isAdmin(), paramayfu.troopowneruin, paramSessionInfo.curFriendUin, 0);
      localbdct.a("sing_tab", "clk_panelsing", 0, paramSessionInfo.curFriendUin);
      i = 1;
      paramayfu = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
      while (!TextUtils.isEmpty(paramayfu))
      {
        if (bool)
        {
          localbdct.b(paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, i, 4, j, localBundle);
          return;
          if (paramSessionInfo.curType == 0)
          {
            localBundle = bddg.a(bool, 3);
            bcef.b(paramayfu, "dc00899", "c2c_AIO", "", "sing_tab", "clk_panelsing", 0, 0, paramSessionInfo.curFriendUin, "", "", "");
            j = 3;
            i = 2;
            paramayfu = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
          }
        }
        else
        {
          localbdct.a(paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, i, 4, j, localBundle);
          return;
        }
        paramayfu = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.SingTogetherAppInfo
 * JD-Core Version:    0.7.0.1
 */