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
  private static int g;
  private boolean a = true;
  private int b;
  private int c;
  private View d;
  private SoftKeyboardHeight.OnGetSoftHeightListener e;
  private ViewTreeObserver.OnGlobalLayoutListener f;
  
  public SoftKeyboardHeight(View paramView, int paramInt, SoftKeyboardHeight.OnGetSoftHeightListener paramOnGetSoftHeightListener)
  {
    this.b = paramInt;
    this.d = paramView;
    this.e = paramOnGetSoftHeightListener;
    c();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 0) {
      return DisplayUtil.a(BaseApplication.getContext(), 210.0F);
    }
    if (g == 0) {
      g = d();
    }
    int i = g;
    if (paramInt > i) {
      return i;
    }
    return paramInt;
  }
  
  private void c()
  {
    this.f = new SoftKeyboardHeight.1(this);
  }
  
  private static int d()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    double d1;
    if (SystemBarTintManager.hasNavBar(localBaseApplication))
    {
      d1 = SystemBarTintManager.getNavigationBarHeight(localBaseApplication) + localBaseApplication.getResources().getDisplayMetrics().heightPixels;
      Double.isNaN(d1);
    }
    else
    {
      d1 = localBaseApplication.getResources().getDisplayMetrics().heightPixels;
      Double.isNaN(d1);
    }
    int i = (int)(d1 * 0.4D);
    if (QLog.isColorLevel()) {
      QLog.d("SoftKeyboardHeight", 2, new Object[] { "getMaxEmotionPanelHeight, max keyboard height:", Integer.valueOf(i) });
    }
    return i;
  }
  
  public int a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_soft_keyboard", 0);
    int i;
    if (localSharedPreferences.contains("key_height"))
    {
      i = localSharedPreferences.getInt("key_height", 0);
      this.e.a(i, true);
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SoftKeyboardHeight", 2, new Object[] { "getSoftKeyboardHeight, keyboard height:", Integer.valueOf(i) });
    }
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    return i;
  }
  
  public void b()
  {
    if (this.f != null)
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f);
        return;
      }
      this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoftKeyboardHeight
 * JD-Core Version:    0.7.0.1
 */