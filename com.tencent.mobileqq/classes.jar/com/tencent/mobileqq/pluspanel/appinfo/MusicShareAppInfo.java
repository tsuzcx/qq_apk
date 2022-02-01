package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class MusicShareAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839292;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 1000000006;
    }
    return 1104864070;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131892037);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramBaseChatPie != null)
    {
      if (paramBaseChatPie.aX() == null) {
        return;
      }
      paramPlusPanelViewModel = AuthorizeConfig.a().c("aio_qqMusicShare", "");
      PlusPanelUtils.a(paramBaseChatPie.d, paramBaseChatPie.aX(), paramSessionInfo, paramPlusPanelViewModel);
      paramBaseChatPie.aX().setCanLock(false);
      AIOPanelUtiles.a(paramBaseChatPie.d, "0X8004083", paramSessionInfo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.MusicShareAppInfo
 * JD-Core Version:    0.7.0.1
 */