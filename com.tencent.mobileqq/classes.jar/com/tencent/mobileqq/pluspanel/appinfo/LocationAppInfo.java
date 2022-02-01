package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.location.pluspanel.LocationSheet;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.util.BaseApplication;

public class LocationAppInfo
  extends PlusPanelAppInfo
{
  LocationAppInfo() {}
  
  public LocationAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839288;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 205;
    }
    return 1104864068;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 506;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130205;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131917343);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (!CheckPermission.isHasStoragePermission(paramBaseChatPie.aX()))
    {
      CheckPermission.requestSDCardPermission(paramBaseChatPie.aX(), null);
      return;
    }
    new LocationSheet(paramBaseChatPie.d, paramBaseChatPie).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.LocationAppInfo
 * JD-Core Version:    0.7.0.1
 */