package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarTintManager;

public class SoftKeyboardHeight
{
  private static int c;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private SoftKeyboardHeight.OnGetSoftHeightListener jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight$OnGetSoftHeightListener;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public SoftKeyboardHeight(View paramView, int paramInt, SoftKeyboardHeight.OnGetSoftHeightListener paramOnGetSoftHeightListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight$OnGetSoftHeightListener = paramOnGetSoftHeightListener;
    b();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 0) {
      return DisplayUtil.a(BaseApplication.getContext(), 210.0F);
    }
    if (c == 0) {
      c = b();
    }
    int i = c;
    if (paramInt > i) {
      return i;
    }
    return paramInt;
  }
  
  private static int b()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    double d;
    if (SystemBarTintManager.hasNavBar(localBaseApplication))
    {
      d = SystemBarTintManager.getNavigationBarHeight(localBaseApplication) + localBaseApplication.getResources().getDisplayMetrics().heightPixels;
      Double.isNaN(d);
    }
    else
    {
      d = localBaseApplication.getResources().getDisplayMetrics().heightPixels;
      Double.isNaN(d);
    }
    int i = (int)(d * 0.4D);
    if (QLog.isColorLevel()) {
      QLog.d("SoftKeyboardHeight", 2, new Object[] { "getMaxEmotionPanelHeight, max keyboard height:", Integer.valueOf(i) });
    }
    return i;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new SoftKeyboardHeight.1(this);
  }
  
  public int a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_soft_keyboard", 0);
    int i;
    if (localSharedPreferences.contains("key_height"))
    {
      i = localSharedPreferences.getInt("key_height", 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight$OnGetSoftHeightListener.a(i, true);
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SoftKeyboardHeight", 2, new Object[] { "getSoftKeyboardHeight, keyboard height:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoftKeyboardHeight
 * JD-Core Version:    0.7.0.1
 */