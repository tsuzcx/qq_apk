package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
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
    return 2130838699;
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
    return BaseApplicationImpl.getContext().getString(2131690152);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramBaseChatPie.showArkAppManagerPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ArkAppManagerAppInfo
 * JD-Core Version:    0.7.0.1
 */