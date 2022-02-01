package com.tencent.mobileqq.pluspanel.appinfo;

import amtj;
import android.os.Bundle;
import ayfu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class BulkSendMsgAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843717;
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
    return BaseApplicationImpl.getContext().getString(2131696738);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("extra.GROUP_UIN", paramSessionInfo.curFriendUin);
    localBundle.putString("selfSet_leftViewText", amtj.a(2131714733));
    BulkSendMessageFragment.a(paramBaseChatPie.getActivity(), localBundle);
    paramayfu.a(paramBaseChatPie.app, getAppID(), paramSessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.BulkSendMsgAppInfo
 * JD-Core Version:    0.7.0.1
 */