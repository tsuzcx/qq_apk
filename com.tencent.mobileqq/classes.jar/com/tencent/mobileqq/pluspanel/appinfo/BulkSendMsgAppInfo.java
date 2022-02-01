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
    return 2130843846;
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
    return BaseApplicationImpl.getContext().getString(2131697278);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("extra.GROUP_UIN", paramSessionInfo.a);
    localBundle.putString("selfSet_leftViewText", HardCodeUtil.a(2131715497));
    BulkSendMessageFragment.a(paramBaseChatPie.a(), localBundle);
    paramPlusPanelViewModel.a(paramBaseChatPie.a, getAppID(), paramSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.BulkSendMsgAppInfo
 * JD-Core Version:    0.7.0.1
 */