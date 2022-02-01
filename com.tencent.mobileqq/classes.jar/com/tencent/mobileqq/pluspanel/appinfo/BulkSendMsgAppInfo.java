package com.tencent.mobileqq.pluspanel.appinfo;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class BulkSendMsgAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130844800;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1106729451;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131895051);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("extra.GROUP_UIN", paramSessionInfo.b);
    localBundle.putString("selfSet_leftViewText", HardCodeUtil.a(2131898212));
    BulkSendMessageFragment.a(paramBaseChatPie.aX(), localBundle);
    paramPlusPanelViewModel.a(paramBaseChatPie.d, getAppID(), paramSessionInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.BulkSendMsgAppInfo
 * JD-Core Version:    0.7.0.1
 */