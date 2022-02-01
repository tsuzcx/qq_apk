package com.tencent.mobileqq.kandian.biz.framework;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;

class UserActionCollector$1
  implements Runnable
{
  UserActionCollector$1(UserActionCollector paramUserActionCollector, int paramInt, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i = this.this$0.i;
    try
    {
      int j;
      if (this.jdField_a_of_type_Int == 0)
      {
        j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentWidgetAbsListView.getContext()) - this.jdField_a_of_type_ComTencentWidgetAbsListView.getResources().getDimensionPixelOffset(2131298861);
        i = j;
      }
      else
      {
        j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
        i = j;
      }
    }
    catch (Exception localException)
    {
      AIOUtils.a("UserActionCollector", "calculte height error !", localException);
    }
    if (i > 0) {
      this.this$0.i = i;
    }
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.1
 * JD-Core Version:    0.7.0.1
 */