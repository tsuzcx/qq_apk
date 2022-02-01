package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XPanelContainer;

public class DoodleAppInfo
  extends PlusPanelAppInfo
{
  DoodleAppInfo() {}
  
  public DoodleAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130838186;
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
    return BaseApplicationImpl.getContext().getString(2131896499);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    ((IScribbleDownloader)localQQAppInterface.getRuntimeService(IScribbleDownloader.class)).checkBDHsessionkey();
    if (((paramSessionInfo.a == 0) || (paramSessionInfo.a == 3000)) && (ScribbleResMgr.a(localQQAppInterface.getApp().getBaseContext(), localQQAppInterface.getCurrentAccountUin())))
    {
      ScribbleResMgr.b(localQQAppInterface.getApp().getBaseContext(), localQQAppInterface.getCurrentAccountUin());
      paramPlusPanelViewModel.b(paramBaseChatPie);
    }
    if (paramBaseChatPie.bm() != null) {
      paramBaseChatPie.bm().a(18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.DoodleAppInfo
 * JD-Core Version:    0.7.0.1
 */