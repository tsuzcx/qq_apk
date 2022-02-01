package com.tencent.mobileqq.pluspanel.appinfo;

import abgm;
import aftr;
import ahvi;
import aifq;
import bdfk;
import bdla;
import bdvn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nty;

public class ShootAppInfo
  extends PlusPanelAppInfo
{
  public ShootAppInfo() {}
  
  public ShootAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839197;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 218;
    }
    return 1200000003;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 513;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130218;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690792);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((bdfk.b()) || ((paramBaseChatPie instanceof aifq)) || (bdvn.a()))
    {
      paramBaseChatPie.onPanelIconClick(Integer.valueOf(6));
      if (QLog.isColorLevel()) {
        QLog.d("ShootAppInfo", 2, "pluspanel onclick called with plus from simple!");
      }
      if (bdfk.b()) {
        bdla.b(null, "dc00898", "", "", "0X800A114", "0X800A114", 0, 0, "", "", "", "");
      }
      if ((paramBaseChatPie instanceof aifq)) {
        bdla.b(null, "dc00898", "", "", "0X800A488", "0X800A488", 0, 0, "", "", "", "");
      }
      return;
    }
    int i = 0;
    if (paramSessionInfo.curType == 9501) {}
    for (;;)
    {
      try
      {
        paramahvi = abgm.a(paramBaseChatPie.app, Long.parseLong(paramSessionInfo.curFriendUin));
        if (paramahvi != null) {
          i = paramahvi.productId;
        }
        paramahvi = paramBaseChatPie.app;
        aftr.a(paramahvi, paramBaseChatPie.mActivity, paramBaseChatPie.getActivity(), paramSessionInfo, i, 0);
        bdla.b(paramahvi, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
        if (!nty.a().a(paramSessionInfo.curFriendUin)) {
          break;
        }
        bdla.b(paramahvi, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, paramSessionInfo.curFriendUin, "", "", "");
        return;
      }
      catch (Exception paramahvi)
      {
        QLog.d("ShootAppInfo", 1, paramahvi, new Object[0]);
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShootAppInfo
 * JD-Core Version:    0.7.0.1
 */