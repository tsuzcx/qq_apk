package com.tencent.mobileqq.pluspanel.appinfo;

import abgm;
import absy;
import aftr;
import ahpt;
import ahvi;
import ahzx;
import aifq;
import android.content.Intent;
import android.text.TextUtils;
import aoep;
import bdfk;
import bdla;
import bdvn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nty;

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
    return 2130839218;
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
    return BaseApplicationImpl.getContext().getString(2131719447);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
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
        if ((!bdfk.b()) && (!(paramBaseChatPie instanceof aifq)) && (!bdvn.a())) {
          break;
        }
        paramBaseChatPie.onPanelIconClick(Integer.valueOf(4));
        if (QLog.isColorLevel()) {
          QLog.d("PicAppInfo", 2, "report() called with plus from simple!");
        }
        if (bdfk.b()) {
          bdla.b(null, "dc00898", "", "", "0X800A113", "0X800A113", 0, 0, "", "", "", "");
        }
        if ((paramBaseChatPie instanceof aifq)) {
          bdla.b(null, "dc00898", "", "", "0X800A489", "0X800A489", 0, 0, "", "", "", "");
        }
        return;
      }
      catch (Exception paramahvi)
      {
        QLog.d("PicAppInfo", 1, paramahvi, new Object[0]);
      }
      i = 0;
    }
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    if (paramSessionInfo.curType == 9501)
    {
      paramahvi = new Intent();
      if (!ahzx.f) {}
      for (boolean bool = true;; bool = false)
      {
        paramahvi.putExtra("isdevicesupportmultiupload", bool);
        aftr.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo, null, paramahvi);
        absy.a(localQQAppInterface, Long.parseLong(paramSessionInfo.curFriendUin), "Usr_AIO_SendMsg", 3, 0, i);
        paramahvi = (aoep)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if ((!TextUtils.isEmpty(paramSessionInfo.curFriendUin)) && (paramSessionInfo.curType == 1)) {
          paramahvi.e(paramSessionInfo.curFriendUin, true);
        }
        paramBaseChatPie.getActivity().setCanLock(false);
        ahpt.a(localQQAppInterface, "0X8004079", paramSessionInfo.curType);
        if (paramSessionInfo.curType == 9501) {
          absy.a(localQQAppInterface, Long.parseLong(paramSessionInfo.curFriendUin), "Usr_AIO_SendMsg", 3, 0, i);
        }
        if (!nty.a().a(paramSessionInfo.curFriendUin)) {
          break;
        }
        bdla.b(localQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, paramSessionInfo.curFriendUin, "", "", "");
        return;
      }
    }
    if ((paramSessionInfo.curType == 1) && (((HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramSessionInfo.curFriendUin)))
    {
      paramahvi = new Intent();
      paramahvi.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    for (;;)
    {
      aftr.a(paramBaseChatPie.getActivity(), paramSessionInfo, localQQAppInterface, paramahvi);
      break;
      paramahvi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.PicAppInfo
 * JD-Core Version:    0.7.0.1
 */