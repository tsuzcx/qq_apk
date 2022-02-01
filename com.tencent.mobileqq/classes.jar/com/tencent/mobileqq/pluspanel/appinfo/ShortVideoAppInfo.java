package com.tencent.mobileqq.pluspanel.appinfo;

import amtj;
import ayfu;
import aygi;
import bfur;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseChatpieHelper;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;

public class ShortVideoAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839206;
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
    return BaseApplicationImpl.getContext().getString(2131719044);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramayfu = paramBaseChatPie.app;
    if (!VideoEnvironment.supportShortVideoRecord(paramayfu)) {
      bfur.a(paramBaseChatPie.getActivity(), 230).setMessage(amtj.a(2131707413)).setPositiveButton(2131694201, new aygi(this)).show();
    }
    while (!BaseChatpieHelper.a(paramayfu)) {
      return;
    }
    paramBaseChatPie.showCameraPanel(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShortVideoAppInfo
 * JD-Core Version:    0.7.0.1
 */