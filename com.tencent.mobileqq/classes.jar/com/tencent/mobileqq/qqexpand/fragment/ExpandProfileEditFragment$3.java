package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExpandProfileEditFragment$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  ExpandProfileEditFragment$3(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public void onGlobalLayout()
  {
    ExpandProfileEditFragment.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = ExpandProfileEditFragment.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment).getRootView().getHeight();
      int k = j - i;
      if (k > j / 4)
      {
        ExpandProfileEditFragment.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment, k);
        this.jdField_a_of_type_Boolean = true;
        ExpandProfileEditFragment.c(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment);
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        ExpandProfileEditFragment.d(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment);
      }
      this.jdField_a_of_type_Int = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.3
 * JD-Core Version:    0.7.0.1
 */