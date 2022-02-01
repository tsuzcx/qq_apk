package com.tencent.mobileqq.pluspanel.appinfo;

import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkAppManagerAppInfo
  extends PlusPanelAppInfo
{
  public ArkAppManagerAppInfo() {}
  
  public ArkAppManagerAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838683;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 1000000001;
    }
    return 1200000009;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690114);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramBaseChatPie.showArkAppManagerPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ArkAppManagerAppInfo
 * JD-Core Version:    0.7.0.1
 */