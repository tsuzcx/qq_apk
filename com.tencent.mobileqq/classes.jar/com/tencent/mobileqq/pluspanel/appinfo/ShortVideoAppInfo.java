package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;

public class ShortVideoAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839296;
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
    return BaseApplicationImpl.getContext().getString(2131720013);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = paramBaseChatPie.a;
    if (!VideoEnvironment.supportShortVideoRecordAndPlay()) {
      DialogUtil.a(paramBaseChatPie.a(), 230).setMessage(HardCodeUtil.a(2131708287)).setPositiveButton(2131694615, new ShortVideoAppInfo.1(this)).show();
    }
    while (!BaseChatpieHelper.a(paramPlusPanelViewModel)) {
      return;
    }
    paramBaseChatPie.t(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShortVideoAppInfo
 * JD-Core Version:    0.7.0.1
 */