package com.tencent.mobileqq.together.ui;

import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.clockin.ClockInViewHelper;

class TogetherPopupDialog$1
  extends TogetherObserver
{
  TogetherPopupDialog$1(TogetherPopupDialog paramTogetherPopupDialog) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper == null) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper.a())
    {
      if (TogetherPopupDialog.a(this.a) != null) {
        TogetherPopupDialog.a(this.a).postDelayed(new TogetherPopupDialog.1.1(this), 5000L);
      }
    }
    else if ((this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter != null) && (this.a.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter.a();
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.bringToFront();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.1
 * JD-Core Version:    0.7.0.1
 */