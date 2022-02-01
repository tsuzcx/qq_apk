package com.tencent.mobileqq.pluspanel.appinfo;

import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class HotPicAppInfo
  extends PlusPanelAppInfo
{
  public HotPicAppInfo() {}
  
  public HotPicAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838185;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 204;
    }
    return 1107930043;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 505;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130204;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697913);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramBaseChatPie != null) {
      paramBaseChatPie.showPlusItemPanel(24);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.HotPicAppInfo
 * JD-Core Version:    0.7.0.1
 */