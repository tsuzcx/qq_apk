package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class ViewUtils
{
  private static double a;
  public static float a;
  public static int a;
  private static float jdField_b_of_type_Float;
  private static int jdField_b_of_type_Int;
  private static float jdField_c_of_type_Float;
  private static int jdField_c_of_type_Int;
  private static float jdField_d_of_type_Float;
  private static int jdField_d_of_type_Int;
  private static int e = 0;
  
  static
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    jdField_a_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Int = localDisplayMetrics.densityDpi;
    jdField_c_of_type_Float = -1.0F;
    jdField_d_of_type_Float = -1.0F;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_a_of_type_Double = 0.0D;
  }
  
  public static double a()
  {
    if (jdField_a_of_type_Double <= 0.0D)
    {
      DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      double d1 = Math.sqrt(Math.pow(localDisplayMetrics.widthPixels, 2.0D) + Math.pow(localDisplayMetrics.heightPixels, 2.0D));
      double d2 = c();
      Double.isNaN(d2);
      jdField_a_of_type_Double = d1 / d2;
    }
    return jdField_a_of_type_Double;
  }
  
  public static float a()
  {
    if (jdField_c_of_type_Float < 0.0F) {
      jdField_c_of_type_Float = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_c_of_type_Float;
  }
  
  public static float a(float paramFloat)
  {
    if (jdField_b_of_type_Float == 0.0F) {
      jdField_b_of_type_Float = jdField_a_of_type_Int;
    }
    return paramFloat * jdField_b_of_type_Float / 160.0F;
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
        jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      } else {
        jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      }
    }
    return jdField_c_of_type_Int;
  }
  
  public static int a(float paramFloat)
  {
    return (int)(paramFloat * jdField_a_of_type_Float + 0.5F);
  }
  
  public static int a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int a(Paint paramPaint, CharSequence paramCharSequence)
  {
    int j = 0;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      int m = paramCharSequence.length();
      float[] arrayOfFloat = new float[m];
      paramPaint.getTextWidths(paramCharSequence.toString(), arrayOfFloat);
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += (int)Math.ceil(arrayOfFloat[j]);
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramInt2);
    localGradientDrawable.setColor(paramInt1);
    return localGradientDrawable;
  }
  
  public static void a()
  {
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
  }
  
  public static void a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha((int)(paramFloat * 255.0F));
    }
  }
  
  @TargetApi(11)
  public static void a(View paramView, int paramInt)
  {
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha(paramInt);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramView.getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  @TargetApi(16)
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
  
  public static void a(View paramView1, View paramView2, int[] paramArrayOfInt)
  {
    int j;
    int i;
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length < 2) {
        return;
      }
      j = 0;
      i = 0;
    }
    for (;;)
    {
      int n = j;
      int i1 = i;
      int k;
      int m;
      if (paramView1.getParent() != null)
      {
        k = j + paramView1.getLeft();
        m = i + paramView1.getTop();
        if (paramView1.getParent() == paramView2)
        {
          paramArrayOfInt[0] = k;
          paramArrayOfInt[1] = m;
          n = k;
          i1 = m;
          if (paramArrayOfInt.length < 4) {
            break label158;
          }
          paramArrayOfInt[2] = paramView1.getMeasuredWidth();
          paramArrayOfInt[3] = paramView1.getMeasuredHeight();
          n = k;
          i1 = m;
        }
      }
      try
      {
        View localView = (View)paramView1.getParent();
        j = k;
        i = m;
        paramView1 = localView;
        if (paramArrayOfInt.length >= 4)
        {
          paramArrayOfInt[2] = localView.getMeasuredWidth();
          paramArrayOfInt[3] = localView.getMeasuredHeight();
          j = k;
          i = m;
          paramView1 = localView;
        }
      }
      catch (ClassCastException paramView1)
      {
        for (;;)
        {
          label158:
          n = k;
          i1 = m;
        }
      }
    }
    if (paramView2 == null)
    {
      paramArrayOfInt[0] = n;
      paramArrayOfInt[1] = i1;
    }
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView.setVisibility(paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    if ((paramView2 instanceof ViewGroup))
    {
      paramView2 = (ViewGroup)paramView2;
      int j = paramView2.getChildCount();
      int i = 0;
      while (i < j)
      {
        if (a(paramView1, paramView2.getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static float b()
  {
    if (jdField_d_of_type_Float < 0.0F) {
      jdField_d_of_type_Float = BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity;
    }
    return jdField_d_of_type_Float;
  }
  
  public static int b()
  {
    if (jdField_d_of_type_Int < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
        jdField_d_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      } else {
        jdField_d_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      }
    }
    return jdField_d_of_type_Int;
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(paramFloat * a());
  }
  
  @TargetApi(11)
  public static void b(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setScaleX(paramFloat);
    }
  }
  
  public static void b(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public static float c()
  {
    if (jdField_b_of_type_Int < 0) {
      jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    }
    return jdField_b_of_type_Int;
  }
  
  public static int c()
  {
    if (e <= 0)
    {
      double d1 = BaseApplication.getContext().getResources().getDisplayMetrics().xdpi;
      Double.isNaN(d1);
      e = (int)(d1 / 2.54D);
    }
    return e;
  }
  
  public static int c(float paramFloat)
  {
    return Math.round(paramFloat / a());
  }
  
  @TargetApi(11)
  public static void c(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setScaleY(paramFloat);
    }
  }
  
  public static int d(float paramFloat)
  {
    return (int)(paramFloat * BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  @TargetApi(11)
  public static void d(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setPivotX(paramFloat);
    }
  }
  
  public static int e(float paramFloat)
  {
    return (int)(paramFloat / BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  @TargetApi(11)
  public static void e(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setPivotY(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void f(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setTranslationX(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void g(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setTranslationY(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void h(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setRotation(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ViewUtils
 * JD-Core Version:    0.7.0.1
 */