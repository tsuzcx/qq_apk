package com.tencent.mobileqq.location;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class LocationMessageModule
  implements View.OnClickListener
{
  private MessageForLocationShare a;
  public boolean a;
  
  public LocationMessageModule()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageModule", 2, new Object[] { "realClick: invoked. 屏蔽消息双击事件 messageForLocationShare: ", this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare });
    }
    LocationShareServiceHolder.a(MobileQQ.sMobileQQ.waitAppRuntime(null)).launchShareUi(QBaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare.frienduin, 2);
    ReportController.b(null, "CliOper", "", "", "0X800A766", "0X800A766", 0, 0, "", "0", "0", "");
  }
  
  public void a(MessageForLocationShare paramMessageForLocationShare)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare = paramMessageForLocationShare;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. ", " v: ", paramView, " messageForLocationShare: ", this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare });
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. disable click in chat history", " v: ", paramView });
      }
    }
    else if (FastClickUtils.a("LocationMessageModule"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. 屏蔽消息双击事件", " v: ", paramView });
      }
    }
    else if (QBaseActivity.sTopActivity != null)
    {
      MessageForLocationShare localMessageForLocationShare = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare;
      if ((localMessageForLocationShare != null) && (localMessageForLocationShare.isSharingLocation)) {
        a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationMessageModule
 * JD-Core Version:    0.7.0.1
 */