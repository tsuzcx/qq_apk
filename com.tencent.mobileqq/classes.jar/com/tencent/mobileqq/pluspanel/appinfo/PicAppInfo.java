package com.tencent.mobileqq.pluspanel.appinfo;

import aara;
import abdm;
import afcm;
import agwt;
import ahff;
import ahkw;
import anca;
import android.content.Intent;
import android.text.TextUtils;
import ayfu;
import bbyp;
import bcef;
import bcoo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nmy;

public class PicAppInfo
  extends PlusPanelAppInfo
{
  public PicAppInfo() {}
  
  public PicAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839198;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 217;
    }
    return 1104864054;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 511;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130217;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131719042);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i = 0;
    if (paramSessionInfo.curType == 9501) {}
    for (;;)
    {
      try
      {
        paramayfu = aara.a(paramBaseChatPie.app, Long.parseLong(paramSessionInfo.curFriendUin));
        if (paramayfu != null) {
          i = paramayfu.productId;
        }
        if ((!bbyp.b()) && (!(paramBaseChatPie instanceof ahkw)) && (!bcoo.a())) {
          break;
        }
        paramBaseChatPie.onPanelIconClick(Integer.valueOf(4));
        if (QLog.isColorLevel()) {
          QLog.d("PicAppInfo", 2, "report() called with plus from simple!");
        }
        if (bbyp.b()) {
          bcef.b(null, "dc00898", "", "", "0X800A113", "0X800A113", 0, 0, "", "", "", "");
        }
        if ((paramBaseChatPie instanceof ahkw)) {
          bcef.b(null, "dc00898", "", "", "0X800A489", "0X800A489", 0, 0, "", "", "", "");
        }
        return;
      }
      catch (Exception paramayfu)
      {
        QLog.d("PicAppInfo", 1, paramayfu, new Object[0]);
      }
      i = 0;
    }
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramBaseChatPie.onEnterCamera();
    if (paramSessionInfo.curType == 9501)
    {
      paramayfu = new Intent();
      if (!ahff.f) {}
      for (boolean bool = true;; bool = false)
      {
        paramayfu.putExtra("isdevicesupportmultiupload", bool);
        afcm.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo, null, paramayfu);
        abdm.a(localQQAppInterface, Long.parseLong(paramSessionInfo.curFriendUin), "Usr_AIO_SendMsg", 3, 0, i);
        paramayfu = (anca)localQQAppInterface.getBusinessHandler(20);
        if ((!TextUtils.isEmpty(paramSessionInfo.curFriendUin)) && (paramSessionInfo.curType == 1)) {
          paramayfu.e(paramSessionInfo.curFriendUin, true);
        }
        paramBaseChatPie.getActivity().setCanLock(false);
        agwt.a(localQQAppInterface, "0X8004079", paramSessionInfo.curType);
        if (paramSessionInfo.curType == 9501) {
          abdm.a(localQQAppInterface, Long.parseLong(paramSessionInfo.curFriendUin), "Usr_AIO_SendMsg", 3, 0, i);
        }
        if (!nmy.a().a(paramSessionInfo.curFriendUin)) {
          break;
        }
        bcef.b(localQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, paramSessionInfo.curFriendUin, "", "", "");
        return;
      }
    }
    if ((paramSessionInfo.curType == 1) && (((HotChatManager)localQQAppInterface.getManager(60)).b(paramSessionInfo.curFriendUin)))
    {
      paramayfu = new Intent();
      paramayfu.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    for (;;)
    {
      afcm.a(paramBaseChatPie.getActivity(), paramSessionInfo, localQQAppInterface, paramayfu);
      break;
      paramayfu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.PicAppInfo
 * JD-Core Version:    0.7.0.1
 */