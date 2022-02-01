package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AVGameAppInfo
  extends PlusPanelAppInfo
{
  AVGameAppInfo() {}
  
  public AVGameAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838779;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 222;
    }
    return 101872203;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 641;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130222;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131886558);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    IAvGameManager localIAvGameManager = (IAvGameManager)localQQAppInterface.getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager == null)
    {
      QLog.e("AVGameAppInfo", 2, "AV_GAME_MANAGER NULL");
      return;
    }
    int i;
    if (localIAvGameManager.isAvGameRoomExist()) {
      i = 1;
    } else {
      i = 2;
    }
    if (paramSessionInfo.a == 1)
    {
      if (AvGameEntranceUtils.a(paramBaseChatPie.aX(), paramSessionInfo.b)) {
        return;
      }
      localIAvGameManager.createAvGameRoom(paramBaseChatPie.aX(), 3, paramSessionInfo.b, 0);
      paramBaseChatPie.aw();
      paramBaseChatPie.aX().setCanLock(false);
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B015", "0X800B015", i, 0, "", "", paramSessionInfo.b, "");
      return;
    }
    if (paramSessionInfo.a == 0)
    {
      localIAvGameManager.createAvGameRoom(paramBaseChatPie.aX(), 2, paramSessionInfo.b, 0);
      paramBaseChatPie.aw();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      paramBaseChatPie.aX().setCanLock(false);
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B014", "0X800B014", i, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel())
    {
      paramPlusPanelViewModel = new StringBuilder();
      paramPlusPanelViewModel.append("click gotoAvGame, not support chat, [");
      paramPlusPanelViewModel.append(paramSessionInfo.a);
      paramPlusPanelViewModel.append("]");
      QLog.i("AVGameAppInfo", 2, paramPlusPanelViewModel.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AVGameAppInfo
 * JD-Core Version:    0.7.0.1
 */