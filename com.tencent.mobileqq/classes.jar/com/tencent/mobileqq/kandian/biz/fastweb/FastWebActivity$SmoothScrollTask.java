package com.tencent.mobileqq.kandian.biz.fastweb;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class FastWebActivity$SmoothScrollTask
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  private final boolean jdField_a_of_type_Boolean;
  private final int b;
  
  public FastWebActivity$SmoothScrollTask(FastWebActivity paramFastWebActivity, View paramView, AbsListView paramAbsListView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getBottom() + this.jdField_a_of_type_ComTencentWidgetAbsListView.getTop() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getBottom() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getPaddingBottom();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setInterpolator(FastWebActivity.a(this.this$0));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjust scroll Before:");
      localStringBuilder.append(this.jdField_a_of_type_Int - i);
      localStringBuilder.append(", After:");
      localStringBuilder.append(this.b / 2);
      QLog.d("FastWebActivity", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      i -= this.b / 2;
    } else {
      i += this.b / 2;
    }
    int j = i + 1;
    float f1 = FastWebActivity.a(this.this$0);
    float f2 = j;
    i = (int)(f1 * 1000.0F * 2.0F * f2 / this.jdField_a_of_type_ComTencentWidgetAbsListView.getFlingVelocityY());
    if (this.jdField_a_of_type_Boolean) {
      i = (int)(FastWebActivity.a(this.this$0) * 1000.0F * 2.0F * f2 / FastWebActivity.b(this.this$0));
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollByImmediately(j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.SmoothScrollTask
 * JD-Core Version:    0.7.0.1
 */