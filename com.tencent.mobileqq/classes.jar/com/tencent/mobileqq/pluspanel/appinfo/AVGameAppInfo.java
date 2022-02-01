package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ncz;
import nqi;

public class AVGameAppInfo
  extends PlusPanelAppInfo
{
  public AVGameAppInfo() {}
  
  public AVGameAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838737;
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
    return BaseApplicationImpl.getContext().getString(2131689960);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    ncz localncz = (ncz)localQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localncz == null)
    {
      QLog.e("AVGameAppInfo", 2, "AV_GAME_MANAGER NULL");
      return;
    }
    if (localncz.a()) {}
    for (int i = 1;; i = 2)
    {
      if (paramSessionInfo.curType == 1)
      {
        if (nqi.a(paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin)) {
          break;
        }
        localncz.a(paramBaseChatPie.getActivity(), 3, paramSessionInfo.curFriendUin, 0);
        paramBaseChatPie.hidePanel();
        paramBaseChatPie.getActivity().setCanLock(false);
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X800B015", "0X800B015", i, 0, "", "", paramSessionInfo.curFriendUin, "");
        return;
      }
      if (paramSessionInfo.curType == 0)
      {
        localncz.a(paramBaseChatPie.getActivity(), 2, paramSessionInfo.curFriendUin, 0);
        paramBaseChatPie.hidePanel();
        paramahvi.b(paramBaseChatPie);
        paramBaseChatPie.getActivity().setCanLock(false);
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X800B014", "0X800B014", i, 0, "", "", "", "");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AVGameAppInfo", 2, "click gotoAvGame, not support chat, [" + paramSessionInfo.curType + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AVGameAppInfo
 * JD-Core Version:    0.7.0.1
 */