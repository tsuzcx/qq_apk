package com.tencent.mobileqq.hotpic;

import augt;
import auhb;
import bhig;

class HotPicPageView$4$1$1
  implements Runnable
{
  HotPicPageView$4$1$1(HotPicPageView.4.1 param1) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = this.a.a.jdField_a_of_type_Auhb.a();
    if ((localHotVideoData == null) || (this.a.a.jdField_a_of_type_Auhb.jdField_a_of_type_Int != 1) || (localHotVideoData.picIndex != this.a.a.jdField_a_of_type_Int))
    {
      new bhig(this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a).a(HotVideoMongoliaRelativeLayout.d, 100, 0, 2);
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.c(this.a.a.jdField_a_of_type_Auhb, this.a.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.1.1
 * JD-Core Version:    0.7.0.1
 */