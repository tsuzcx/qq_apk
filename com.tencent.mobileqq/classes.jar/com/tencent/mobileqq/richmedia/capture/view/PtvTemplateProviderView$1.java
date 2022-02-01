package com.tencent.mobileqq.richmedia.capture.view;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.List;

class PtvTemplateProviderView$1
  implements Runnable
{
  PtvTemplateProviderView$1(PtvTemplateProviderView paramPtvTemplateProviderView) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)) && (this.this$0.jdField_a_of_type_JavaUtilList.size() > 1) && (!this.this$0.jdField_a_of_type_Boolean))
    {
      this.this$0.jdField_a_of_type_Boolean = true;
      this.this$0.setTab(this.this$0.jdField_a_of_type_JavaLangString);
      this.this$0.jdField_a_of_type_JavaLangString = "";
      this.this$0.e = -1;
    }
    do
    {
      return;
      if ((this.this$0.e > 0) && (this.this$0.jdField_a_of_type_JavaUtilList.size() > 1) && (!this.this$0.jdField_a_of_type_Boolean))
      {
        this.this$0.jdField_a_of_type_Boolean = true;
        this.this$0.setTab(this.this$0.e);
        this.this$0.jdField_a_of_type_JavaLangString = "";
        this.this$0.e = -1;
        return;
      }
    } while ((this.this$0.jdField_a_of_type_Boolean) || (this.this$0.jdField_a_of_type_JavaUtilList.size() <= this.this$0.d) || (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() != 0));
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.this$0.d);
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(this.this$0.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView.1
 * JD-Core Version:    0.7.0.1
 */