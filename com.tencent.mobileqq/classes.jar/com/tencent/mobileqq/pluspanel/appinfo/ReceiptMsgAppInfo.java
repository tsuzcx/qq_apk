package com.tencent.mobileqq.pluspanel.appinfo;

import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class ReceiptMsgAppInfo
  extends PlusPanelAppInfo
{
  public ReceiptMsgAppInfo() {}
  
  public ReceiptMsgAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838291;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 216;
    }
    return 1106189400;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 512;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130216;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697927);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramBaseChatPie.switchReceiptMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ReceiptMsgAppInfo
 * JD-Core Version:    0.7.0.1
 */