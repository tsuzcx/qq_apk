import java.util.List;

public class luu
{
  private float A;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private luj jdField_a_of_type_Luj;
  private luv jdField_a_of_type_Luv;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1000;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j = 1.0F;
  private float k = 1.0F;
  private float l;
  private float m = 1.0F;
  private float n = 1.0F;
  private float o = 1.0F;
  private float p = 1.0F;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w;
  private float x;
  private float y;
  private float z;
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_d_of_type_Boolean = true;
    this.m = paramFloat1;
    this.q = paramFloat1;
    this.n = paramFloat2;
    this.r = paramFloat2;
    this.o = paramFloat3;
    this.p = paramFloat4;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat1;
    this.jdField_d_of_type_Float = paramFloat2;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.i = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_e_of_type_Float = paramFloat5;
    this.h = paramFloat6;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(luj paramluj)
  {
    this.jdField_a_of_type_Luj = paramluj;
  }
  
  public void a(luv paramluv)
  {
    this.jdField_a_of_type_Luv = paramluv;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    long l1 = paramLong - this.jdField_a_of_type_Long;
    if (l1 == 0L) {
      return false;
    }
    paramLong = l1;
    if (l1 >= this.jdField_b_of_type_Int)
    {
      paramLong = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Boolean = true;
      b();
    }
    float f1;
    if (this.jdField_a_of_type_Int == 0) {
      f1 = (float)paramLong * 1.0F / this.jdField_b_of_type_Int;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float + (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float) * f1);
        this.f = (this.jdField_d_of_type_Float + (this.jdField_e_of_type_Float - this.jdField_d_of_type_Float) * f1);
        this.i = (this.g + (this.h - this.g) * f1);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.q = (this.m + (this.o - this.m) * f1);
        this.r = (this.n + (this.p - this.n) * f1);
      }
      if (this.jdField_e_of_type_Boolean)
      {
        this.y = (this.s + (this.t - this.s) * f1);
        this.z = (this.u + (this.v - this.u) * f1);
        this.A = (this.w + (this.x - this.w) * f1);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      float f2 = this.j;
      this.l = (f1 * (this.k - this.j) + f2);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        f1 = (float)paramLong;
        f1 = (float)paramLong * (1.0F * f1) / this.jdField_b_of_type_Int / this.jdField_b_of_type_Int;
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        l1 = this.jdField_b_of_type_Int;
        if (paramLong == 0L)
        {
          f1 = 0.0F;
        }
        else
        {
          f1 = (float)paramLong * 1.0F * (float)paramLong / (float)l1 / (float)l1;
          f1 = ((float)l1 * 2.0F / (float)paramLong - 1.0F) * f1;
        }
      }
      else
      {
        f1 = 1.0F;
      }
    }
  }
  
  public float b()
  {
    return this.f;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Luj != null) {}
    synchronized (this.jdField_a_of_type_Luj.a())
    {
      this.jdField_a_of_type_Luj.a().remove(this);
      if (this.jdField_a_of_type_Luv != null)
      {
        this.jdField_a_of_type_Luv.a();
        this.jdField_a_of_type_Luv = null;
      }
      return;
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_e_of_type_Boolean = true;
    this.s = paramFloat1;
    this.y = paramFloat1;
    this.t = paramFloat2;
    this.u = paramFloat3;
    this.z = paramFloat3;
    this.v = paramFloat4;
    this.w = paramFloat5;
    this.A = paramFloat5;
    this.x = paramFloat6;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = Math.abs(paramInt);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public float c()
  {
    return this.i;
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public float d()
  {
    return this.q;
  }
  
  public float e()
  {
    return this.r;
  }
  
  public float f()
  {
    return this.y;
  }
  
  public float g()
  {
    return this.z;
  }
  
  public float h()
  {
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     luu
 * JD-Core Version:    0.7.0.1
 */