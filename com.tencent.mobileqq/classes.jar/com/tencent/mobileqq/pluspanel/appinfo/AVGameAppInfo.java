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
    return 2130838650;
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
    return BaseApplicationImpl.getContext().getString(2131689917);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
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
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (AvGameEntranceUtils.a(paramBaseChatPie.a(), paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      localIAvGameManager.createAvGameRoom(paramBaseChatPie.a(), 3, paramSessionInfo.jdField_a_of_type_JavaLangString, 0);
      paramBaseChatPie.Q();
      paramBaseChatPie.a().setCanLock(false);
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B015", "0X800B015", i, 0, "", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "");
      return;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      localIAvGameManager.createAvGameRoom(paramBaseChatPie.a(), 2, paramSessionInfo.jdField_a_of_type_JavaLangString, 0);
      paramBaseChatPie.Q();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      paramBaseChatPie.a().setCanLock(false);
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B014", "0X800B014", i, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel())
    {
      paramPlusPanelViewModel = new StringBuilder();
      paramPlusPanelViewModel.append("click gotoAvGame, not support chat, [");
      paramPlusPanelViewModel.append(paramSessionInfo.jdField_a_of_type_Int);
      paramPlusPanelViewModel.append("]");
      QLog.i("AVGameAppInfo", 2, paramPlusPanelViewModel.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AVGameAppInfo
 * JD-Core Version:    0.7.0.1
 */