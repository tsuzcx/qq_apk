package com.tencent.mobileqq.litelivesdk.utils.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.livesdk.livesdkplayer.utils.NotchUtil;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;

public class ViewTreeHelper
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  
  public ViewTreeHelper(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams());
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ViewTreeHelper.1(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    if (DeviceManager.a(BaseApplicationImpl.getContext())) {
      return localRect.bottom - localRect.top;
    }
    return localRect.bottom;
  }
  
  private int b()
  {
    if (!DeviceManager.a(BaseApplicationImpl.getContext())) {
      return 0;
    }
    int i = NotchUtil.getStatusBarHeight(BaseApplicationImpl.getContext());
    int j = DeviceManager.a(this.jdField_a_of_type_AndroidAppActivity);
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("statusBarHeight = ");
    localStringBuilder.append(i);
    localStringBuilder.append(" navigationBarHeight = ");
    localStringBuilder.append(j);
    localLogInterface.c("ViewTreeHelper", localStringBuilder.toString());
    return i + j;
  }
  
  private void c()
  {
    int i = a();
    if (i != this.jdField_a_of_type_Int)
    {
      int k = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      int j = k - i;
      LogInterface localLogInterface = LogFactory.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("possiblyResizeChildOfContent usableHeightSansKeyboard = ");
      localStringBuilder.append(k);
      localStringBuilder.append(" heightDifference = ");
      localStringBuilder.append(j);
      localLogInterface.c("ViewTreeHelper", localStringBuilder.toString());
      if (j > k / 4)
      {
        k = b();
        this.jdField_a_of_type_AndroidViewViewGroup.scrollTo(0, j - k);
      }
      else if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.scrollTo(0, 0);
      }
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_a_of_type_Int = i;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ui.ViewTreeHelper
 * JD-Core Version:    0.7.0.1
 */