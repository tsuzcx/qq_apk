package com.tencent.mobileqq.widget;

import android.database.DataSetObserver;

class TabLayoutCompat$PagerAdapterObserver
  extends DataSetObserver
{
  private boolean jdField_a_of_type_Boolean;
  
  TabLayoutCompat$PagerAdapterObserver(TabLayoutCompat paramTabLayoutCompat) {}
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a != null) && (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat) != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a.getCurrentItem();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.b() == i) {
        TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat).b(i, 300);
      }
    }
    if (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat) != null) {
      TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat).a();
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onChanged()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.b();
      return;
    }
    a();
  }
  
  public void onInvalidated()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.PagerAdapterObserver
 * JD-Core Version:    0.7.0.1
 */