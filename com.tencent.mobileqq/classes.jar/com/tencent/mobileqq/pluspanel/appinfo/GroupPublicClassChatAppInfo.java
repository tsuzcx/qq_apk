package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.content.Intent;
import azmf;
import bdla;
import bkzi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GroupPublicClassChatAppInfo
  extends GroupVideoChatAppInfo
{
  private void a(ahvi paramahvi, BaseChatPie paramBaseChatPie)
  {
    bkzi localbkzi = bkzi.a(paramBaseChatPie.getActivity());
    localbkzi.b(2131697028);
    localbkzi.b(2131697029);
    localbkzi.c(2131690697);
    localbkzi.a(new azmf(this, localbkzi, paramahvi, paramBaseChatPie));
    localbkzi.show();
    bdla.b(paramBaseChatPie.app, "dc00898", "", "", "0X800ABC6", "0X800ABC6", 0, 0, "", "", "", "");
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    String str = paramBaseChatPie.sessionInfo.curFriendUin;
    str = "https://qun.qq.com/livework/index?gc=" + str + "&_wv=2";
    Intent localIntent = new Intent(paramBaseChatPie.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    if (QLog.isColorLevel()) {
      QLog.i("GroupVideoChatAppInfo", 2, "showTroopCourseActionSheet replayUrl = " + str);
    }
    paramBaseChatPie.getActivity().startActivity(localIntent);
    bdla.b(paramBaseChatPie.app, "dc00898", "", "", "0X800ABFD", "0X800ABFD", 0, 0, "", "", "", "");
  }
  
  private void b(ahvi paramahvi, BaseChatPie paramBaseChatPie)
  {
    try
    {
      handleTroopLiveOrTroopCourseClick(paramahvi, paramBaseChatPie, paramBaseChatPie.sessionInfo, true);
      bdla.b(paramBaseChatPie.app, "dc00898", "", "", "0X800ABFC", "0X800ABFC", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramahvi)
    {
      for (;;)
      {
        QLog.d("GroupVideoChatAppInfo", 1, "showTroopCourseActionSheet handleTroopLiveOrTroopCourseClick Exception", paramahvi);
      }
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839192;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 101847385;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 0;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131719443);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    try
    {
      a(paramahvi, paramBaseChatPie);
      return;
    }
    catch (Exception paramahvi)
    {
      QLog.d("GroupVideoChatAppInfo", 1, "handleTroopLiveOrTroopCourseClick Exception", paramahvi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupPublicClassChatAppInfo
 * JD-Core Version:    0.7.0.1
 */