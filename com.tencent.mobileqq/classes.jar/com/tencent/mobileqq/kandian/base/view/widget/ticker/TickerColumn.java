package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;

class TickerColumn
{
  private char jdField_a_of_type_Char = '\000';
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final TickerDrawMetrics jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics;
  private char[] jdField_a_of_type_ArrayOfChar;
  private final TickerCharacterList[] jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList;
  private char jdField_b_of_type_Char = '\000';
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float e;
  private float f;
  private float g;
  private float h;
  
  TickerColumn(TickerCharacterList[] paramArrayOfTickerCharacterList, TickerDrawMetrics paramTickerDrawMetrics)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList = paramArrayOfTickerCharacterList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics = paramTickerDrawMetrics;
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ArrayOfChar = null;
    char c2 = this.jdField_b_of_type_Char;
    char c1 = c2;
    if (paramBoolean1)
    {
      c1 = c2;
      if (c2 == 0) {
        c1 = '0';
      }
    }
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList;
      if (i >= localObject1.length) {
        break;
      }
      TickerCharacterList.CharacterIndices localCharacterIndices = localObject1[i].a(this.jdField_a_of_type_Char, c1, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a());
      localObject1 = localObject2;
      if (localCharacterIndices != null) {
        if (paramBoolean2)
        {
          this.jdField_a_of_type_ArrayOfChar = paramArrayOfChar;
          this.jdField_a_of_type_Int = paramInt2;
          this.jdField_b_of_type_Int = paramInt3;
          localObject1 = localObject2;
        }
        else
        {
          this.jdField_a_of_type_ArrayOfChar = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList[i].a();
          this.jdField_a_of_type_Int = localCharacterIndices.jdField_a_of_type_Int;
          this.jdField_b_of_type_Int = localCharacterIndices.jdField_b_of_type_Int;
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList[i].a();
        }
      }
      i += 1;
      localObject2 = localObject1;
    }
    if ((this.jdField_a_of_type_ArrayOfChar != null) && (paramInt1 > 1) && (!TextUtils.isEmpty(localObject2)))
    {
      paramInt2 = Math.min(paramInt1 - 1, 5);
      paramArrayOfChar = new String(this.jdField_a_of_type_ArrayOfChar);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a() == 1)
      {
        paramInt1 = 0;
        for (;;)
        {
          localObject1 = paramArrayOfChar;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramArrayOfChar);
          ((StringBuilder)localObject1).append(localObject2);
          paramArrayOfChar = ((StringBuilder)localObject1).toString();
          this.jdField_a_of_type_Int += localObject2.length();
          paramInt1 += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a() == 2)
      {
        paramInt1 = 0;
        for (;;)
        {
          localObject1 = paramArrayOfChar;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramArrayOfChar);
          ((StringBuilder)localObject1).append(localObject2);
          paramArrayOfChar = ((StringBuilder)localObject1).toString();
          this.jdField_b_of_type_Int += localObject2.length();
          paramInt1 += 1;
        }
      }
      localObject1 = paramArrayOfChar;
      this.jdField_a_of_type_ArrayOfChar = ((String)localObject1).toCharArray();
    }
    if (this.jdField_a_of_type_ArrayOfChar == null)
    {
      c1 = this.jdField_a_of_type_Char;
      c2 = this.jdField_b_of_type_Char;
      if (c1 == c2)
      {
        this.jdField_a_of_type_ArrayOfChar = new char[] { c1 };
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        return;
      }
      this.jdField_a_of_type_ArrayOfChar = new char[] { c1, c2 };
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  private boolean a(Canvas paramCanvas, Paint paramPaint, char[] paramArrayOfChar, int paramInt, float paramFloat)
  {
    if ((paramInt >= 0) && (paramInt < paramArrayOfChar.length))
    {
      paramCanvas.drawText(paramArrayOfChar, paramInt, 1, 0.0F, paramFloat, paramPaint);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a(this.jdField_b_of_type_Char);
    float f2 = this.jdField_d_of_type_Float;
    float f3 = this.e;
    if ((f2 == f3) && (f3 != f1))
    {
      this.e = f1;
      this.jdField_d_of_type_Float = f1;
      this.f = f1;
    }
  }
  
  char a()
  {
    return this.jdField_a_of_type_Char;
  }
  
  float a()
  {
    b();
    return this.jdField_d_of_type_Float;
  }
  
  void a()
  {
    b();
    this.f = this.jdField_d_of_type_Float;
  }
  
  void a(float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == 1.0F)
    {
      this.jdField_a_of_type_Char = this.jdField_b_of_type_Char;
      this.g = 0.0F;
      this.h = 0.0F;
    }
    float f1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a();
    float f2 = Math.abs(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) * f1 * paramFloat / f1;
    int i = (int)f2;
    float f3 = i;
    float f4 = this.h;
    int j = this.jdField_d_of_type_Int;
    this.jdField_a_of_type_Float = ((f2 - f3) * f1 * j + f4 * (1.0F - paramFloat));
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int + i * j);
    this.jdField_b_of_type_Float = f1;
    if (paramBoolean)
    {
      this.jdField_d_of_type_Float = Math.max(this.e, this.jdField_c_of_type_Float);
      if (paramFloat > 0.999F)
      {
        this.jdField_d_of_type_Float = this.e;
        if (this.jdField_b_of_type_Char == 0) {
          this.jdField_c_of_type_Int = 0;
        }
      }
    }
    else
    {
      f1 = this.jdField_c_of_type_Float;
      this.jdField_d_of_type_Float = (f1 + (this.e - f1) * paramFloat);
    }
  }
  
  void a(int paramInt, char paramChar, boolean paramBoolean)
  {
    this.jdField_b_of_type_Char = paramChar;
    this.jdField_c_of_type_Float = this.jdField_d_of_type_Float;
    this.e = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a(paramChar);
    this.f = Math.max(this.jdField_c_of_type_Float, this.e);
    a(paramInt, paramBoolean, false, null, 0, 0);
    paramInt = this.jdField_b_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    int i = 1;
    if (paramInt >= j) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramInt = i;
    } else {
      paramInt = -1;
    }
    this.jdField_d_of_type_Int = paramInt;
    this.h = this.g;
    this.g = 0.0F;
  }
  
  void a(int paramInt1, char paramChar, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Char = paramChar;
    this.jdField_c_of_type_Float = this.jdField_d_of_type_Float;
    this.e = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a(paramChar);
    this.f = Math.max(this.jdField_c_of_type_Float, this.e);
    a(paramInt1, paramBoolean1, paramBoolean2, paramArrayOfChar, paramInt2, paramInt3);
    paramInt1 = this.jdField_b_of_type_Int;
    paramInt3 = this.jdField_a_of_type_Int;
    paramInt2 = 1;
    if (paramInt1 >= paramInt3) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      paramInt1 = paramInt2;
    } else {
      paramInt1 = -1;
    }
    this.jdField_d_of_type_Int = paramInt1;
    this.h = this.g;
    this.g = 0.0F;
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (a(paramCanvas, paramPaint, this.jdField_a_of_type_ArrayOfChar, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float))
    {
      int i = this.jdField_c_of_type_Int;
      if (i >= 0) {
        this.jdField_a_of_type_Char = this.jdField_a_of_type_ArrayOfChar[i];
      }
      this.g = this.jdField_a_of_type_Float;
    }
    a(paramCanvas, paramPaint, this.jdField_a_of_type_ArrayOfChar, this.jdField_c_of_type_Int + 1, this.jdField_a_of_type_Float - this.jdField_b_of_type_Float);
    a(paramCanvas, paramPaint, this.jdField_a_of_type_ArrayOfChar, this.jdField_c_of_type_Int - 1, this.jdField_a_of_type_Float + this.jdField_b_of_type_Float);
  }
  
  char b()
  {
    return this.jdField_b_of_type_Char;
  }
  
  float b()
  {
    b();
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerColumn
 * JD-Core Version:    0.7.0.1
 */