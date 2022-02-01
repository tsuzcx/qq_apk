package com.tencent.mobileqq.pluspanel.appinfo;

import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkSampleAppInfo
  extends PlusPanelAppInfo
{
  public ArkSampleAppInfo() {}
  
  public ArkSampleAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130842624;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 1000000000;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690709);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ArkSampleAppInfo
 * JD-Core Version:    0.7.0.1
 */