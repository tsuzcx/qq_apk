package com.tencent.widget.pull2refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;

class PagerSnapHelper$OnLayoutChangedListenerImpl
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean = false;
  
  private PagerSnapHelper$OnLayoutChangedListenerImpl(PagerSnapHelper paramPagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).removeOnLayoutChangeListener(this);
    if (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getItemCount() > PagerSnapHelper.d(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper) + PagerSnapHelper.e(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
      paramView = paramView.a(PagerSnapHelper.a(paramView));
      if ((!this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.OnLayoutChangedListenerImpl
 * JD-Core Version:    0.7.0.1
 */