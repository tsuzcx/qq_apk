import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;

class tfi
{
  private char jdField_a_of_type_Char = '\000';
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final tfk jdField_a_of_type_Tfk;
  private char[] jdField_a_of_type_ArrayOfChar;
  private final tfg[] jdField_a_of_type_ArrayOfTfg;
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
  
  tfi(tfg[] paramArrayOftfg, tfk paramtfk)
  {
    this.jdField_a_of_type_ArrayOfTfg = paramArrayOftfg;
    this.jdField_a_of_type_Tfk = paramtfk;
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
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
    int i = 0;
    Object localObject1;
    if (i < this.jdField_a_of_type_ArrayOfTfg.length)
    {
      tfh localtfh = this.jdField_a_of_type_ArrayOfTfg[i].a(this.jdField_a_of_type_Char, c1, this.jdField_a_of_type_Tfk.a());
      localObject1 = localObject2;
      if (localtfh != null)
      {
        if (!paramBoolean2) {
          break label121;
        }
        this.jdField_a_of_type_ArrayOfChar = paramArrayOfChar;
        this.jdField_a_of_type_Int = paramInt2;
        this.jdField_b_of_type_Int = paramInt3;
      }
      for (localObject1 = localObject2;; localObject1 = this.jdField_a_of_type_ArrayOfTfg[i].a())
      {
        i += 1;
        localObject2 = localObject1;
        break;
        label121:
        this.jdField_a_of_type_ArrayOfChar = this.jdField_a_of_type_ArrayOfTfg[i].a();
        this.jdField_a_of_type_Int = localtfh.jdField_a_of_type_Int;
        this.jdField_b_of_type_Int = localtfh.jdField_b_of_type_Int;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfChar != null) && (paramInt1 > 1) && (!TextUtils.isEmpty(localObject2)))
    {
      paramInt2 = Math.min(paramInt1 - 1, 5);
      localObject1 = new String(this.jdField_a_of_type_ArrayOfChar);
      if (this.jdField_a_of_type_Tfk.a() == 1)
      {
        paramInt1 = 0;
        for (;;)
        {
          paramArrayOfChar = (char[])localObject1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject1 = (String)localObject1 + localObject2;
          this.jdField_a_of_type_Int += localObject2.length();
          paramInt1 += 1;
        }
      }
      paramArrayOfChar = (char[])localObject1;
      if (this.jdField_a_of_type_Tfk.a() == 2)
      {
        paramInt1 = 0;
        for (;;)
        {
          paramArrayOfChar = (char[])localObject1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject1 = (String)localObject1 + localObject2;
          this.jdField_b_of_type_Int += localObject2.length();
          paramInt1 += 1;
        }
      }
      this.jdField_a_of_type_ArrayOfChar = paramArrayOfChar.toCharArray();
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
    float f1 = this.jdField_a_of_type_Tfk.a(this.jdField_b_of_type_Char);
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
    float f1 = this.jdField_a_of_type_Tfk.a();
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
    int i = 0;
    this.jdField_b_of_type_Char = paramChar;
    this.jdField_c_of_type_Float = this.jdField_d_of_type_Float;
    this.e = this.jdField_a_of_type_Tfk.a(paramChar);
    this.f = Math.max(this.jdField_c_of_type_Float, this.e);
    a(paramInt, paramBoolean, false, null, 0, 0);
    paramInt = i;
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int) {
      paramInt = 1;
    }
    if (paramInt != 0) {}
    for (paramInt = 1;; paramInt = -1)
    {
      this.jdField_d_of_type_Int = paramInt;
      this.h = this.g;
      this.g = 0.0F;
      return;
    }
  }
  
  void a(int paramInt1, char paramChar, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Char = paramChar;
    this.jdField_c_of_type_Float = this.jdField_d_of_type_Float;
    this.e = this.jdField_a_of_type_Tfk.a(paramChar);
    this.f = Math.max(this.jdField_c_of_type_Float, this.e);
    a(paramInt1, paramBoolean1, paramBoolean2, paramArrayOfChar, paramInt2, paramInt3);
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label97;
      }
    }
    label97:
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      this.jdField_d_of_type_Int = paramInt1;
      this.h = this.g;
      this.g = 0.0F;
      return;
      paramInt1 = 0;
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
 * Qualified Name:     tfi
 * JD-Core Version:    0.7.0.1
 */