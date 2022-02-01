package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanelProvider;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PokeAppInfo
  extends PlusPanelAppInfo
{
  PokeAppInfo() {}
  
  public PokeAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = PokeItemHelper.b(paramQQAppInterface, 0);
    boolean bool1;
    if (paramSharedPreferences != null) {
      bool1 = paramSharedPreferences.getBoolean("chat_tool_poke_clicked", false);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (i == 2)
    {
      bool2 = bool3;
      if (!bool1) {
        bool2 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = PokeItemHelper.a;
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append("plus getPokeNeedRed isPokeNeedRed=");
      paramSharedPreferences.append(bool2);
      paramSharedPreferences.append(" getPokeMsgFoldSwitch=");
      paramSharedPreferences.append(i);
      paramSharedPreferences.append(" hasClicked=");
      paramSharedPreferences.append(bool1);
      QLog.d(paramQQAppInterface, 2, paramSharedPreferences.toString());
    }
    return bool2;
  }
  
  public int defaultDrawableID()
  {
    return 2130839140;
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
    return BaseApplicationImpl.getContext().getString(2131698547);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    SharedPreferences localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0);
    if (a(localQQAppInterface, localSharedPreferences))
    {
      paramPlusPanelViewModel.a("chat_tool_poke", localQQAppInterface.getCurrentAccountUin());
      localSharedPreferences.edit().putBoolean("chat_tool_poke_clicked", true).apply();
      paramPlusPanelViewModel.b(paramBaseChatPie);
    }
    paramPlusPanelViewModel = (PokeAndEmoPanelProvider)paramBaseChatPie.a().a(23);
    if (paramPlusPanelViewModel != null) {
      paramPlusPanelViewModel.a();
    }
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8007F21", "0X8007F21", 0, 0, "", "", "", "");
    if ((paramBaseChatPie instanceof BusinessCmrTmpChatPie)) {
      AIOPanelUtiles.a(localQQAppInterface, "0X8008AAA", "C_Master_PTT", paramSessionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.PokeAppInfo
 * JD-Core Version:    0.7.0.1
 */