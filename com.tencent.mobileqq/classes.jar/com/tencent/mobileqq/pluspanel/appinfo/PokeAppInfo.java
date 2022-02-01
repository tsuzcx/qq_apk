package com.tencent.mobileqq.pluspanel.appinfo;

import ahcw;
import ahpt;
import ahvi;
import ahyl;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PokeAppInfo
  extends PlusPanelAppInfo
{
  public PokeAppInfo() {}
  
  public PokeAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = ahcw.b(paramQQAppInterface, 0);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = paramSharedPreferences.getBoolean("chat_tool_poke_clicked", false);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(ahcw.a, 2, "plus getPokeNeedRed isPokeNeedRed=" + bool2 + " getPokeMsgFoldSwitch=" + i + " hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839216;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 203;
    }
    return 0;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 504;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130203;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698205);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    SharedPreferences localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0);
    if (a(localQQAppInterface, localSharedPreferences))
    {
      paramahvi.a("chat_tool_poke", localQQAppInterface.getCurrentAccountUin());
      localSharedPreferences.edit().putBoolean("chat_tool_poke_clicked", true).apply();
      paramahvi.b(paramBaseChatPie);
    }
    paramBaseChatPie.showPokePanel();
    localQQAppInterface.reportClickEvent("CliOper", "0X8007F21");
    if ((paramBaseChatPie instanceof ahyl)) {
      ahpt.a(localQQAppInterface, "0X8008AAA", "C_Master_PTT", paramSessionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.PokeAppInfo
 * JD-Core Version:    0.7.0.1
 */