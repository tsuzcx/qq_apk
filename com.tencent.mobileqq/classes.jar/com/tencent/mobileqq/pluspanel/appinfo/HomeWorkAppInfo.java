package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class HomeWorkAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130844886;
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
    return BaseApplicationImpl.getContext().getString(2131887772);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = new Intent(paramBaseChatPie.aX(), QQBrowserActivity.class);
    if (TextUtils.isEmpty(this.url)) {
      return;
    }
    paramPlusPanelViewModel.putExtra("url", this.url.replace("$GCODE$", paramSessionInfo.b));
    paramBaseChatPie.aX().startActivity(paramPlusPanelViewModel);
    AIOPanelUtiles.a(paramBaseChatPie.d, "0X8005CBA", paramSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.HomeWorkAppInfo
 * JD-Core Version:    0.7.0.1
 */