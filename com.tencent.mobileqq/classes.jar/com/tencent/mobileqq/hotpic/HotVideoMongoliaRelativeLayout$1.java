package com.tencent.mobileqq.hotpic;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HotVideoMongoliaRelativeLayout$1
  implements HotVideoMongoliaRelativeLayout.InnerOnClickListener
{
  HotVideoMongoliaRelativeLayout$1(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    HotPicPageView.b = true;
    if ((this.a.jdField_a_of_type_Int == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(0, paramView);
      return;
    }
    if ((this.a.jdField_a_of_type_Int == 3) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(4, paramView);
    } else if ((this.a.jdField_a_of_type_Int == 4) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(1, paramView);
    } else if ((this.a.jdField_a_of_type_Int == 6) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(2, paramView);
    }
    QLog.d("HotVideoRelativeLayout", 2, "click base view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */