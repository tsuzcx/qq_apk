package com.tencent.wstt.SSCM;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

public class SSCM
{
  protected double a;
  protected float a;
  public int a;
  protected long a;
  protected boolean a;
  private float jdField_b_of_type_Float;
  protected int b;
  protected long b;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  protected int c;
  private float d;
  protected int d;
  private float e;
  protected int e;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private int h;
  private int i;
  
  public SSCM()
  {
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private long a()
  {
    return new Date().getTime();
  }
  
  private long b()
  {
    return new Date().getTime();
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.jdField_b_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (!this.jdField_a_of_type_Boolean)
    {
      j = this.jdField_b_of_type_Int;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            this.jdField_c_of_type_Int = 4096;
          } else {
            this.jdField_c_of_type_Int = 16384;
          }
        }
        else {
          this.jdField_c_of_type_Int = 8192;
        }
      }
      else {
        this.jdField_c_of_type_Int = 32768;
      }
    }
    if (paramLong < 102400L) {
      this.jdField_c_of_type_Int *= 4;
    }
    int j = this.jdField_c_of_type_Int;
    if (paramLong - j <= j / 2) {
      this.jdField_c_of_type_Int = ((int)paramLong);
    }
    return this.jdField_c_of_type_Int;
  }
  
  public int a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Long = a();
    if (paramLong1 < 102400L) {
      this.h = 1;
    } else {
      this.h = 2;
    }
    if (true == this.jdField_b_of_type_Boolean)
    {
      a();
      this.jdField_d_of_type_Int = a(paramContext, paramLong1);
      this.jdField_b_of_type_Boolean = false;
      return this.jdField_d_of_type_Int;
    }
    double d1 = this.jdField_d_of_type_Int;
    double d2 = this.jdField_a_of_type_Double;
    Double.isNaN(d1);
    this.jdField_c_of_type_Float = ((float)(d1 / d2));
    float f1 = this.jdField_e_of_type_Float;
    if (0.0F == f1)
    {
      this.jdField_e_of_type_Float = this.jdField_c_of_type_Float;
    }
    else
    {
      d1 = this.jdField_c_of_type_Float;
      Double.isNaN(d1);
      d2 = f1;
      Double.isNaN(d2);
      this.jdField_e_of_type_Float = ((float)(d1 * 0.8D + d2 * 0.2D));
    }
    if (this.jdField_a_of_type_Int != 2)
    {
      this.i += 1;
      f1 = this.jdField_d_of_type_Float;
      if (f1 == 0.0F)
      {
        this.jdField_a_of_type_Float = 1.0F;
        if (this.i == this.h) {
          this.jdField_b_of_type_Float = this.jdField_e_of_type_Float;
        }
      }
      else if (this.i == this.h)
      {
        d1 = (this.jdField_e_of_type_Float - f1) / this.jdField_b_of_type_Float;
        d2 = this.jdField_d_of_type_Int - this.jdField_e_of_type_Int;
        double d3 = this.jdField_c_of_type_Int;
        Double.isNaN(d3);
        Double.isNaN(d2);
        d2 /= (d3 + 0.0D);
        Double.isNaN(d1);
        this.jdField_a_of_type_Float = ((float)(d1 / d2));
      }
    }
    int j = this.jdField_a_of_type_Int;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j == 2)
        {
          d1 = Math.abs(this.jdField_e_of_type_Float - this.jdField_f_of_type_Float);
          d2 = this.jdField_f_of_type_Float;
          Double.isNaN(d2);
          if (d1 > d2 * 0.2D) {
            this.jdField_f_of_type_Int += 1;
          } else {
            this.jdField_f_of_type_Int = 0;
          }
          if (this.jdField_f_of_type_Int < this.jdField_g_of_type_Int)
          {
            this.jdField_a_of_type_Int = 2;
          }
          else
          {
            this.jdField_f_of_type_Int = 0;
            this.jdField_a_of_type_Int = 0;
            this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
            this.jdField_d_of_type_Float = 0.0F;
            this.jdField_e_of_type_Int = 0;
            this.jdField_e_of_type_Float = 0.0F;
            this.i = 0;
          }
        }
      }
      else if (this.i == this.h) {
        if (this.jdField_a_of_type_Float < 0.09D)
        {
          this.jdField_a_of_type_Int = 2;
          f1 = this.jdField_e_of_type_Float;
          this.jdField_f_of_type_Float = f1;
          this.jdField_d_of_type_Float = 0.0F;
          this.jdField_e_of_type_Int = 0;
          this.jdField_g_of_type_Float = f1;
        }
        else
        {
          this.jdField_a_of_type_Int = 1;
          this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
          d1 = this.jdField_e_of_type_Int;
          Double.isNaN(d1);
          this.jdField_d_of_type_Int = ((int)(d1 * 1.05D));
          f1 = this.jdField_e_of_type_Float;
          this.jdField_d_of_type_Float = f1;
          this.jdField_g_of_type_Float = f1;
          this.jdField_e_of_type_Float = 0.0F;
          this.i = 0;
        }
      }
    }
    else if (this.i == this.h)
    {
      if (this.jdField_a_of_type_Float < 0.09D)
      {
        this.jdField_a_of_type_Int = 1;
        d1 = this.jdField_e_of_type_Int;
        Double.isNaN(d1);
        this.jdField_d_of_type_Int = ((int)(d1 * 1.05D));
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
        this.jdField_d_of_type_Int = (this.jdField_e_of_type_Int * 2);
        this.jdField_d_of_type_Float = this.jdField_e_of_type_Float;
      }
      this.jdField_e_of_type_Float = 0.0F;
      this.i = 0;
    }
    paramLong1 -= paramLong2;
    j = this.jdField_d_of_type_Int;
    if (paramLong1 - j <= j / 2) {
      this.jdField_d_of_type_Int = ((int)paramLong1);
    }
    if (this.i == 0) {
      f1 = this.jdField_d_of_type_Float;
    } else {
      f1 = this.jdField_e_of_type_Float;
    }
    if (paramInt > 0)
    {
      j = this.jdField_d_of_type_Int;
      if ((j < 0) || (j > paramInt))
      {
        this.jdField_d_of_type_Int = paramInt;
        break label793;
      }
    }
    if (this.jdField_d_of_type_Int < 0)
    {
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_d_of_type_Float = 0.0F;
      this.jdField_e_of_type_Int = 0;
      this.jdField_e_of_type_Float = 0.0F;
      this.i = 0;
    }
    label793:
    return this.jdField_d_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_g_of_type_Float = 0.0F;
    this.jdField_f_of_type_Int = 0;
    this.i = 0;
    this.jdField_g_of_type_Int = 3;
    this.h = 2;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = b();
    double d1 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    Double.isNaN(d1);
    this.jdField_a_of_type_Double = (d1 / 1000.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendFilePakage time:");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    QLog.d("upload", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCM
 * JD-Core Version:    0.7.0.1
 */