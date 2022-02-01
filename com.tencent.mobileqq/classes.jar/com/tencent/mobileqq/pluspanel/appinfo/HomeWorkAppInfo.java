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
    return 2130843931;
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
    return BaseApplicationImpl.getContext().getString(2131690837);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
    if (TextUtils.isEmpty(this.url)) {
      return;
    }
    paramPlusPanelViewModel.putExtra("url", this.url.replace("$GCODE$", paramSessionInfo.jdField_a_of_type_JavaLangString));
    paramBaseChatPie.a().startActivity(paramPlusPanelViewModel);
    AIOPanelUtiles.a(paramBaseChatPie.a, "0X8005CBA", paramSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.HomeWorkAppInfo
 * JD-Core Version:    0.7.0.1
 */