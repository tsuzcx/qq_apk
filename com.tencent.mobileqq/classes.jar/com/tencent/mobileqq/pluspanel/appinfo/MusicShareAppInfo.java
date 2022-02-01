package com.tencent.mobileqq.pluspanel.appinfo;

import aftr;
import ahpt;
import ahvi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import nro;

public class MusicShareAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839212;
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
    return BaseApplicationImpl.getContext().getString(2131694193);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.getActivity() == null)) {
      return;
    }
    paramahvi = nro.a().a("aio_qqMusicShare", "");
    aftr.a(paramBaseChatPie.app, paramBaseChatPie.getActivity(), paramSessionInfo, paramahvi);
    paramBaseChatPie.getActivity().setCanLock(false);
    ahpt.a(paramBaseChatPie.app, "0X8004083", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.MusicShareAppInfo
 * JD-Core Version:    0.7.0.1
 */