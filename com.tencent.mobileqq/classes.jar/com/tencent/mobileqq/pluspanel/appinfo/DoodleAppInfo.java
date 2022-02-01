package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import bbxu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.qphone.base.util.BaseApplication;

public class DoodleAppInfo
  extends PlusPanelAppInfo
{
  public DoodleAppInfo() {}
  
  public DoodleAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838232;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 210;
    }
    return 1106114157;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 516;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130210;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698211);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    localQQAppInterface.getScribbleDownloader().a();
    if (((paramSessionInfo.curType == 0) || (paramSessionInfo.curType == 3000)) && (ScribbleResMgr.a(localQQAppInterface.getApp().getBaseContext(), localQQAppInterface.getCurrentAccountUin())))
    {
      ScribbleResMgr.a(localQQAppInterface.getApp().getBaseContext(), localQQAppInterface.getCurrentAccountUin());
      paramahvi.b(paramBaseChatPie);
    }
    paramBaseChatPie.showScribblePanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.DoodleAppInfo
 * JD-Core Version:    0.7.0.1
 */