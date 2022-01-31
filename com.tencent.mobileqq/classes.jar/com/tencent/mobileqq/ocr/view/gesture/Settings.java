package com.tencent.mobileqq.ocr.view.gesture;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.mobileqq.R.styleable;

public class Settings
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 300L;
  private Settings.Bounds jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Bounds = Settings.Bounds.NORMAL;
  private Settings.ExitType jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$ExitType = Settings.ExitType.ALL;
  private Settings.Fit jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Fit = Settings.Fit.INSIDE;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 2.0F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 2.0F;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 17;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private int i;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Settings.Bounds a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Bounds;
  }
  
  public Settings.Fit a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Fit;
  }
  
  public Settings a()
  {
    this.jdField_h_of_type_Int += 1;
    return this;
  }
  
  public Settings a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    return this;
  }
  
  public Settings a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GestureView);
    this.jdField_c_of_type_Int = paramAttributeSet.getDimensionPixelSize(14, this.jdField_c_of_type_Int);
    this.jdField_d_of_type_Int = paramAttributeSet.getDimensionPixelSize(13, this.jdField_d_of_type_Int);
    boolean bool;
    if ((this.jdField_c_of_type_Int > 0) && (this.jdField_d_of_type_Int > 0))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Float = paramAttributeSet.getFloat(12, this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = paramAttributeSet.getFloat(11, this.jdField_b_of_type_Float);
      this.jdField_c_of_type_Float = paramAttributeSet.getFloat(5, this.jdField_c_of_type_Float);
      this.jdField_d_of_type_Float = paramAttributeSet.getFloat(17, this.jdField_d_of_type_Float);
      this.jdField_e_of_type_Float = paramAttributeSet.getDimension(15, this.jdField_e_of_type_Float);
      this.jdField_f_of_type_Float = paramAttributeSet.getDimension(16, this.jdField_f_of_type_Float);
      this.jdField_b_of_type_Boolean = paramAttributeSet.getBoolean(7, this.jdField_b_of_type_Boolean);
      this.jdField_g_of_type_Int = paramAttributeSet.getInt(10, this.jdField_g_of_type_Int);
      int j = paramAttributeSet.getInteger(8, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Fit.ordinal());
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Fit = Settings.Fit.values()[j];
      j = paramAttributeSet.getInteger(1, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Bounds.ordinal());
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$Bounds = Settings.Bounds.values()[j];
      this.jdField_c_of_type_Boolean = paramAttributeSet.getBoolean(18, this.jdField_c_of_type_Boolean);
      this.jdField_d_of_type_Boolean = paramAttributeSet.getBoolean(9, this.jdField_d_of_type_Boolean);
      this.jdField_e_of_type_Boolean = paramAttributeSet.getBoolean(21, this.jdField_e_of_type_Boolean);
      this.jdField_f_of_type_Boolean = paramAttributeSet.getBoolean(20, this.jdField_f_of_type_Boolean);
      this.jdField_g_of_type_Boolean = paramAttributeSet.getBoolean(19, this.jdField_g_of_type_Boolean);
      this.jdField_h_of_type_Boolean = paramAttributeSet.getBoolean(4, this.jdField_h_of_type_Boolean);
      if (!paramAttributeSet.getBoolean(6, true)) {
        break label378;
      }
    }
    label378:
    for (paramContext = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$ExitType;; paramContext = Settings.ExitType.NONE)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings$ExitType = paramContext;
      this.jdField_a_of_type_Long = paramAttributeSet.getInt(0, (int)this.jdField_a_of_type_Long);
      if (paramAttributeSet.getBoolean(3, false)) {
        a();
      }
      if (paramAttributeSet.getBoolean(2, false)) {
        b();
      }
      paramAttributeSet.recycle();
      return;
      bool = false;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Settings b()
  {
    this.i += 1;
    return this;
  }
  
  public Settings b(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    return this;
  }
  
  public boolean b()
  {
    return (h()) && (this.jdField_c_of_type_Boolean);
  }
  
  public float c()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_c_of_type_Int;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public boolean c()
  {
    return (h()) && (this.jdField_d_of_type_Boolean);
  }
  
  public float d()
  {
    return this.jdField_d_of_type_Float;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_d_of_type_Int;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public boolean d()
  {
    return (h()) && (this.jdField_e_of_type_Boolean);
  }
  
  public float e()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public boolean e()
  {
    return (h()) && (this.jdField_f_of_type_Boolean);
  }
  
  public float f()
  {
    return this.jdField_f_of_type_Float;
  }
  
  public int f()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public boolean f()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public boolean g()
  {
    return (h()) && (this.jdField_h_of_type_Boolean);
  }
  
  public boolean h()
  {
    return this.jdField_h_of_type_Int <= 0;
  }
  
  public boolean i()
  {
    return this.i <= 0;
  }
  
  public boolean j()
  {
    return (h()) && ((this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_h_of_type_Boolean));
  }
  
  public boolean k()
  {
    return (this.jdField_e_of_type_Int != 0) && (this.jdField_f_of_type_Int != 0);
  }
  
  public boolean l()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.Settings
 * JD-Core Version:    0.7.0.1
 */