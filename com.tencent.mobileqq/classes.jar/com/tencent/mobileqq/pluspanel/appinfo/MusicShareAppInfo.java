package com.tencent.mobileqq.pluspanel.appinfo;

import afcm;
import agwt;
import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import nko;

public class MusicShareAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839192;
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
    return BaseApplicationImpl.getContext().getString(2131694002);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.getActivity() == null)) {
      return;
    }
    paramayfu = nko.a().a("aio_qqMusicShare", "");
    afcm.a(paramBaseChatPie.app, paramBaseChatPie.getActivity(), paramSessionInfo, paramayfu);
    paramBaseChatPie.getActivity().setCanLock(false);
    agwt.a(paramBaseChatPie.app, "0X8004083", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.MusicShareAppInfo
 * JD-Core Version:    0.7.0.1
 */