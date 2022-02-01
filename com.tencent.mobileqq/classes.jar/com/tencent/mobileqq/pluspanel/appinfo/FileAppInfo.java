package com.tencent.mobileqq.pluspanel.appinfo;

import aara;
import afcm;
import agwt;
import aszr;
import aszs;
import ayfu;
import ayfx;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.util.BaseApplication;

public class FileAppInfo
  extends PlusPanelAppInfo
{
  public FileAppInfo() {}
  
  public FileAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    localQQAppInterface = paramBaseChatPie.app;
    localObject = (aara)localQQAppInterface.getBusinessHandler(51);
    l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.curFriendUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if ((paramSessionInfo.curType == 9501) && (localObject != null) && (((aara)localObject).c(l1)))
        {
          afcm.c(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo);
        }
        else
        {
          agwt.a(localQQAppInterface, "0X800407C", paramSessionInfo.curType);
          localObject = new aszs();
          ((aszs)localObject).b = "send_file";
          ((aszs)localObject).a = 1;
          aszr.a(localQQAppInterface.getCurrentAccountUin(), (aszs)localObject);
          afcm.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo);
        }
      }
    }
    if (paramSessionInfo.curType == 1)
    {
      bcef.b(localQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
      afcm.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo);
      paramBaseChatPie.getActivity().setCanLock(false);
      return;
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839201;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 206;
    }
    return 1104864066;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 507;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130206;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690719);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (!CheckPermission.isHasStoragePermission(paramBaseChatPie.getActivity()))
    {
      CheckPermission.requestSDCardPermission(paramBaseChatPie.getActivity(), new ayfx(this, paramBaseChatPie, paramSessionInfo));
      return;
    }
    a(paramBaseChatPie, paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.FileAppInfo
 * JD-Core Version:    0.7.0.1
 */