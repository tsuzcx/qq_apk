package com.tencent.mobileqq.location.ui;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class LocationPickController$2
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  
  LocationPickController$2(LocationPickController paramLocationPickController) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramInt = paramAbsListView.getFirstVisiblePosition();
    if (paramInt > this.jdField_a_of_type_Int)
    {
      if (!LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).b()) {
        LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).a();
      }
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("LocationShareController", 4, "onScrollStateChanged");
        }
        LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      if (paramInt >= this.jdField_a_of_type_Int) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.2
 * JD-Core Version:    0.7.0.1
 */