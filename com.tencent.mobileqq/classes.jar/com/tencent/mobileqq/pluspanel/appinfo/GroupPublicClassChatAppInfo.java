package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import ayfu;
import ayfy;
import bcef;
import bjnw;
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
  private void a(ayfu paramayfu, BaseChatPie paramBaseChatPie)
  {
    bjnw localbjnw = bjnw.a(paramBaseChatPie.getActivity());
    localbjnw.b(2131696761);
    localbjnw.b(2131696762);
    localbjnw.c(2131690620);
    localbjnw.a(new ayfy(this, localbjnw, paramayfu, paramBaseChatPie));
    localbjnw.show();
    bcef.b(paramBaseChatPie.app, "dc00898", "", "", "0X800ABC6", "0X800ABC6", 0, 0, "", "", "", "");
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
    bcef.b(paramBaseChatPie.app, "dc00898", "", "", "0X800ABFD", "0X800ABFD", 0, 0, "", "", "", "");
  }
  
  private void b(ayfu paramayfu, BaseChatPie paramBaseChatPie)
  {
    try
    {
      handleTroopLiveOrTroopCourseClick(paramayfu, paramBaseChatPie, paramBaseChatPie.sessionInfo, true);
      bcef.b(paramBaseChatPie.app, "dc00898", "", "", "0X800ABFC", "0X800ABFC", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramayfu)
    {
      for (;;)
      {
        QLog.d("GroupVideoChatAppInfo", 1, "showTroopCourseActionSheet handleTroopLiveOrTroopCourseClick Exception", paramayfu);
      }
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839172;
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
    return BaseApplicationImpl.getContext().getString(2131719038);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    try
    {
      a(paramayfu, paramBaseChatPie);
      return;
    }
    catch (Exception paramayfu)
    {
      QLog.d("GroupVideoChatAppInfo", 1, "handleTroopLiveOrTroopCourseClick Exception", paramayfu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupPublicClassChatAppInfo
 * JD-Core Version:    0.7.0.1
 */