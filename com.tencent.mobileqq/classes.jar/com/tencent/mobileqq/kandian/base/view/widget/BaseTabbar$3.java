package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.View.OnClickListener;

class BaseTabbar$3
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  BaseTabbar$3(BaseTabbar paramBaseTabbar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 300L)
    {
      this.jdField_a_of_type_Long = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar.a.a(this.jdField_a_of_type_Int);
      }
    }
    else
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar.setSelectedTab(this.jdField_a_of_type_Int, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.3
 * JD-Core Version:    0.7.0.1
 */