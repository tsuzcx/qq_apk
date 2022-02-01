package com.tencent.mobileqq.hotpic;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class PresenceInterfaceImpl$5
  implements Runnable
{
  PresenceInterfaceImpl$5(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView);
    boolean bool;
    if ((this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && ((HotPicPageView)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      bool = HotPicPageView.a;
    } else {
      bool = false;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.c, this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.d, 0L, this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.a, bool);
    String str;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a()) {
      str = "0X8007ED5";
    } else {
      str = "0X8007ED6";
    }
    ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    QLog.d("PresenceInterfaceImpl", 2, "have run mVideoPlayControl.startPlay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.5
 * JD-Core Version:    0.7.0.1
 */