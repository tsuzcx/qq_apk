package com.tencent.mobileqq.pluspanel.appinfo;

import ahpt;
import ahvi;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class HomeWorkAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843840;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1104445552;
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
    return BaseApplicationImpl.getContext().getString(2131690803);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramahvi = new Intent(paramBaseChatPie.getActivity(), QQBrowserActivity.class);
    if (TextUtils.isEmpty(this.url)) {
      return;
    }
    paramahvi.putExtra("url", this.url.replace("$GCODE$", paramSessionInfo.curFriendUin));
    paramBaseChatPie.getActivity().startActivity(paramahvi);
    ahpt.a(paramBaseChatPie.app, "0X8005CBA", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.HomeWorkAppInfo
 * JD-Core Version:    0.7.0.1
 */