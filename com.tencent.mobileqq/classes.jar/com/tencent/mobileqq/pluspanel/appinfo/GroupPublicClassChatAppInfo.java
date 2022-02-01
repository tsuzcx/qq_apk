package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class GroupPublicClassChatAppInfo
  extends GroupVideoChatAppInfo
{
  private void a(BaseChatPie paramBaseChatPie)
  {
    String str = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://qun.qq.com/livework/index?gc=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("&_wv=2");
    str = ((StringBuilder)localObject).toString();
    localObject = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", str);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTroopCourseActionSheet replayUrl = ");
      localStringBuilder.append(str);
      QLog.i("GroupVideoChatAppInfo", 2, localStringBuilder.toString());
    }
    paramBaseChatPie.a().startActivity((Intent)localObject);
    ReportController.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ABFD", "0X800ABFD", 0, 0, "", "", "", "");
  }
  
  private void a(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramBaseChatPie.a());
    localActionSheet.addButton(2131697301);
    localActionSheet.addButton(2131697302);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new GroupPublicClassChatAppInfo.1(this, localActionSheet, paramPlusPanelViewModel, paramBaseChatPie));
    localActionSheet.show();
    ReportController.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ABC6", "0X800ABC6", 0, 0, "", "", "", "");
  }
  
  private void b(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie)
  {
    try
    {
      SessionInfo localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      try
      {
        handleTroopLiveOrTroopCourseClick(paramPlusPanelViewModel, paramBaseChatPie, localSessionInfo, true);
      }
      catch (Exception paramPlusPanelViewModel) {}
      QLog.d("GroupVideoChatAppInfo", 1, "showTroopCourseActionSheet handleTroopLiveOrTroopCourseClick Exception", paramPlusPanelViewModel);
    }
    catch (Exception paramPlusPanelViewModel) {}
    ReportController.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ABFC", "0X800ABFC", 0, 0, "", "", "", "");
  }
  
  public int defaultDrawableID()
  {
    return 2130839115;
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
    return BaseApplicationImpl.getContext().getString(2131719739);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    try
    {
      a(paramPlusPanelViewModel, paramBaseChatPie);
      return;
    }
    catch (Exception paramPlusPanelViewModel)
    {
      QLog.d("GroupVideoChatAppInfo", 1, "handleTroopLiveOrTroopCourseClick Exception", paramPlusPanelViewModel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupPublicClassChatAppInfo
 * JD-Core Version:    0.7.0.1
 */