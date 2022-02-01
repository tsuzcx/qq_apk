import android.graphics.SurfaceTexture;

public abstract class lja
{
  protected int a;
  protected final liy a;
  protected liz a;
  protected final ljb a;
  protected ljn a;
  
  public lja(liy paramliy, liz paramliz)
  {
    this.jdField_a_of_type_Ljn = new ljn();
    this.jdField_a_of_type_Ljb = new ljb();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Liy = paramliy;
    this.jdField_a_of_type_Liz = paramliz;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return lkq.a(this.jdField_a_of_type_Liy.a, true, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return lkq.b(this.jdField_a_of_type_Liy.a, true, false, b, false) * 90;
  }
  
  public abstract void a();
  
  public abstract void a(long paramLong, SurfaceTexture paramSurfaceTexture);
  
  public void a(ljb paramljb)
  {
    int i = 0;
    int m = this.jdField_a_of_type_Liy.f();
    int j;
    int n;
    label60:
    int k;
    if (this.jdField_a_of_type_Liy.e)
    {
      j = 0;
      n = this.jdField_a_of_type_Liy.g();
      if (this.jdField_a_of_type_Liy.f != 1) {
        break label219;
      }
      i = (360 - (m + j) % 360) % 360;
      k = i + n;
      if ((m != 270) && (m != 90)) {
        break label246;
      }
      i = k;
      if (n % 180 == 0)
      {
        i = k;
        if (this.jdField_a_of_type_Liy.f == 1) {
          if (a())
          {
            i = k;
            if (!this.jdField_a_of_type_Liy.d) {}
          }
          else
          {
            i = k + 180;
          }
        }
      }
      label134:
      if (this.jdField_a_of_type_Liy.f != 1) {
        break label370;
      }
      if (this.jdField_a_of_type_Liy.l <= 0) {
        break label351;
      }
      i += 360 - this.jdField_a_of_type_Liy.l;
    }
    for (;;)
    {
      i = i % 360 / 90;
      if (paramljb != null)
      {
        paramljb.jdField_a_of_type_Int = i;
        paramljb.b = n;
        paramljb.c = m;
        paramljb.d = j;
      }
      return;
      j = this.jdField_a_of_type_Liy.c() * 90;
      break;
      label219:
      if (this.jdField_a_of_type_Liy.f != 2) {
        break label60;
      }
      i = (m - j + 360) % 360;
      break label60;
      label246:
      if (m != 0)
      {
        i = k;
        if (m != 180) {
          break label134;
        }
      }
      if ((n == 90) || (n == 270))
      {
        i = k;
        if (this.jdField_a_of_type_Liy.f != 1) {
          break label134;
        }
        i = k;
        if (this.jdField_a_of_type_Liy.c) {
          break label134;
        }
        i = k + 180;
        break label134;
      }
      i = k;
      if (this.jdField_a_of_type_Liy.f != 1) {
        break label134;
      }
      i = k;
      if (!this.jdField_a_of_type_Liy.c) {
        break label134;
      }
      i = k + 180;
      break label134;
      label351:
      i += a(n, this.jdField_a_of_type_Liy.e);
      continue;
      label370:
      if (this.jdField_a_of_type_Liy.m > 0) {
        i += this.jdField_a_of_type_Liy.m;
      } else {
        i += b(n, this.jdField_a_of_type_Liy.e);
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      if (!msm.a(this.jdField_a_of_type_Liy.a, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
        break label43;
      }
    }
    label43:
    for (this.jdField_a_of_type_Int = 1; this.jdField_a_of_type_Int == 1; this.jdField_a_of_type_Int = 0) {
      return true;
    }
    return false;
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return lkq.a(this.jdField_a_of_type_Liy.a, false, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return lkq.b(this.jdField_a_of_type_Liy.a, false, false, b, false) * 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lja
 * JD-Core Version:    0.7.0.1
 */