import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;

class tbf
{
  private char jdField_a_of_type_Char = '\000';
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final tbh jdField_a_of_type_Tbh;
  private char[] jdField_a_of_type_ArrayOfChar;
  private final tbd[] jdField_a_of_type_ArrayOfTbd;
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
  
  tbf(tbd[] paramArrayOftbd, tbh paramtbh)
  {
    this.jdField_a_of_type_ArrayOfTbd = paramArrayOftbd;
    this.jdField_a_of_type_Tbh = paramtbh;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    String str2 = null;
    this.jdField_a_of_type_ArrayOfChar = null;
    char c2 = this.jdField_b_of_type_Char;
    char c1 = c2;
    if (paramBoolean)
    {
      c1 = c2;
      if (c2 == 0) {
        c1 = '0';
      }
    }
    int i = 0;
    Object localObject;
    while (i < this.jdField_a_of_type_ArrayOfTbd.length)
    {
      localObject = this.jdField_a_of_type_ArrayOfTbd[i].a(this.jdField_a_of_type_Char, c1, this.jdField_a_of_type_Tbh.a());
      if (localObject != null)
      {
        this.jdField_a_of_type_ArrayOfChar = this.jdField_a_of_type_ArrayOfTbd[i].a();
        this.jdField_a_of_type_Int = ((tbe)localObject).jdField_a_of_type_Int;
        this.jdField_b_of_type_Int = ((tbe)localObject).jdField_b_of_type_Int;
        str2 = this.jdField_a_of_type_ArrayOfTbd[i].a();
      }
      i += 1;
    }
    if ((this.jdField_a_of_type_ArrayOfChar != null) && (paramInt > 1) && (!TextUtils.isEmpty(str2)))
    {
      i = Math.min(paramInt - 1, 5);
      String str1 = new String(this.jdField_a_of_type_ArrayOfChar);
      if (this.jdField_a_of_type_Tbh.a() == 1)
      {
        paramInt = 0;
        for (;;)
        {
          localObject = str1;
          if (paramInt >= i) {
            break;
          }
          str1 = str1 + str2;
          this.jdField_a_of_type_Int += str2.length();
          paramInt += 1;
        }
      }
      localObject = str1;
      if (this.jdField_a_of_type_Tbh.a() == 2)
      {
        paramInt = 0;
        for (;;)
        {
          localObject = str1;
          if (paramInt >= i) {
            break;
          }
          str1 = str1 + str2;
          this.jdField_b_of_type_Int += str2.length();
          paramInt += 1;
        }
      }
      this.jdField_a_of_type_ArrayOfChar = ((String)localObject).toCharArray();
    }
    if (this.jdField_a_of_type_ArrayOfChar == null)
    {
      if (this.jdField_a_of_type_Char == this.jdField_b_of_type_Char)
      {
        this.jdField_a_of_type_ArrayOfChar = new char[] { this.jdField_a_of_type_Char };
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ArrayOfChar = new char[] { this.jdField_a_of_type_Char, this.jdField_b_of_type_Char };
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
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
    float f1 = this.jdField_a_of_type_Tbh.a(this.jdField_b_of_type_Char);
    if ((this.jdField_d_of_type_Float == this.e) && (this.e != f1))
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
    float f1 = this.jdField_a_of_type_Tbh.a();
    float f2 = Math.abs(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) * f1 * paramFloat / f1;
    float f3 = (int)f2;
    float f4 = this.h;
    this.jdField_a_of_type_Float = ((f2 - f3) * f1 * this.jdField_d_of_type_Int + f4 * (1.0F - paramFloat));
    int i = this.jdField_a_of_type_Int;
    this.jdField_c_of_type_Int = ((int)f2 * this.jdField_d_of_type_Int + i);
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
      return;
    }
    this.jdField_d_of_type_Float = (this.jdField_c_of_type_Float + (this.e - this.jdField_c_of_type_Float) * paramFloat);
  }
  
  void a(int paramInt, char paramChar, boolean paramBoolean)
  {
    int i = 1;
    this.jdField_b_of_type_Char = paramChar;
    this.jdField_c_of_type_Float = this.jdField_d_of_type_Float;
    this.e = this.jdField_a_of_type_Tbh.a(paramChar);
    this.f = Math.max(this.jdField_c_of_type_Float, this.e);
    a(paramInt, paramBoolean);
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = -1)
    {
      this.jdField_d_of_type_Int = paramInt;
      this.h = this.g;
      this.g = 0.0F;
      return;
      paramInt = 0;
      break;
    }
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (a(paramCanvas, paramPaint, this.jdField_a_of_type_ArrayOfChar, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float))
    {
      if (this.jdField_c_of_type_Int >= 0) {
        this.jdField_a_of_type_Char = this.jdField_a_of_type_ArrayOfChar[this.jdField_c_of_type_Int];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbf
 * JD-Core Version:    0.7.0.1
 */