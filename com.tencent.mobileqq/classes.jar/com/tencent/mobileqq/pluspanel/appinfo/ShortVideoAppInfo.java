package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import anvx;
import azmo;
import bhdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;

public class ShortVideoAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839227;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1104788673;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131719449);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramahvi = paramBaseChatPie.app;
    if (!VideoEnvironment.supportShortVideoRecord(paramahvi)) {
      bhdj.a(paramBaseChatPie.getActivity(), 230).setMessage(anvx.a(2131707760)).setPositiveButton(2131694399, new azmo(this)).show();
    }
    while (!BaseChatpieHelper.a(paramahvi)) {
      return;
    }
    paramBaseChatPie.showCameraPanel(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShortVideoAppInfo
 * JD-Core Version:    0.7.0.1
 */