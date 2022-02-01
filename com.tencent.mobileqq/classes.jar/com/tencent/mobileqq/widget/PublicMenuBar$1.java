package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicMenuBar$1
  implements View.OnClickListener
{
  PublicMenuBar$1(PublicMenuBar paramPublicMenuBar, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (PublicMenuBar.a(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar) != null) {
      PublicMenuBar.b(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PublicMenuBar.1
 * JD-Core Version:    0.7.0.1
 */