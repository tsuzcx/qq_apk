package com.tencent.mobileqq.litelivesdk.utils.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;

public class ViewUtils$InputMethodShowHelper
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ViewUtils.InputMethodShowHelper.1(this);
  public ViewUtils.OnInputMethodChangeListener a;
  
  public ViewUtils$InputMethodShowHelper(ViewUtils paramViewUtils, Activity paramActivity)
  {
    paramViewUtils = (FrameLayout)paramActivity.findViewById(16908290);
    if (paramViewUtils != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewUtils.getChildAt(0);
      paramViewUtils = this.jdField_a_of_type_AndroidViewView;
      if (paramViewUtils != null) {
        paramViewUtils.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    else
    {
      Log.e("ViewUtils", "获取android.R.id.content为空！！！！");
    }
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void a()
  {
    int i = a();
    if (i != this.jdField_a_of_type_Int)
    {
      int j = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      if (j - i > j / 4) {
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$OnInputMethodChangeListener.a(true);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$OnInputMethodChangeListener.a(false);
      }
      this.jdField_a_of_type_Int = i;
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewView = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    paramActivity = this.jdField_a_of_type_AndroidViewView;
    if (paramActivity != null) {
      paramActivity.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$OnInputMethodChangeListener = null;
  }
  
  public void a(ViewUtils.OnInputMethodChangeListener paramOnInputMethodChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$OnInputMethodChangeListener = paramOnInputMethodChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils.InputMethodShowHelper
 * JD-Core Version:    0.7.0.1
 */