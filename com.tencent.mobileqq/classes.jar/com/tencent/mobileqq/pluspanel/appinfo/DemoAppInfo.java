package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class DemoAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130845429;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1200000000;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698583);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.DemoAppInfo
 * JD-Core Version:    0.7.0.1
 */