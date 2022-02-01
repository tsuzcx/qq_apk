package com.tencent.open.agent.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.open.widget.MaxHeightScrollView;

final class AuthUIUtil$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AuthUIUtil$2(Activity paramActivity, MaxHeightScrollView paramMaxHeightScrollView) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity)) && (ScreenUtil.isNavigationBarExist(this.jdField_a_of_type_AndroidAppActivity)))
    {
      i = this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.a();
      int j = DisplayUtils.b(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.setMaxHeight(i - j);
    }
    int i = ((View)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131376809).getParent()).getTop();
    if (i > 0)
    {
      MaxHeightScrollView localMaxHeightScrollView = this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
      localMaxHeightScrollView.setMaxHeight(localMaxHeightScrollView.a() - i);
    }
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthUIUtil.2
 * JD-Core Version:    0.7.0.1
 */