import android.graphics.SurfaceTexture;

public abstract class ljg
{
  protected int a;
  protected final lje a;
  protected ljf a;
  protected final ljh a;
  protected ljt a;
  
  public ljg(lje paramlje, ljf paramljf)
  {
    this.jdField_a_of_type_Ljt = new ljt();
    this.jdField_a_of_type_Ljh = new ljh();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lje = paramlje;
    this.jdField_a_of_type_Ljf = paramljf;
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
      return lkw.a(this.jdField_a_of_type_Lje.a, true, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return lkw.b(this.jdField_a_of_type_Lje.a, true, false, b, false) * 90;
  }
  
  public abstract void a();
  
  public abstract void a(long paramLong, SurfaceTexture paramSurfaceTexture);
  
  public void a(ljh paramljh)
  {
    int i = 0;
    int m = this.jdField_a_of_type_Lje.f();
    int j;
    int n;
    label60:
    int k;
    if (this.jdField_a_of_type_Lje.e)
    {
      j = 0;
      n = this.jdField_a_of_type_Lje.g();
      if (this.jdField_a_of_type_Lje.f != 1) {
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
        if (this.jdField_a_of_type_Lje.f == 1) {
          if (a())
          {
            i = k;
            if (!this.jdField_a_of_type_Lje.d) {}
          }
          else
          {
            i = k + 180;
          }
        }
      }
      label134:
      if (this.jdField_a_of_type_Lje.f != 1) {
        break label370;
      }
      if (this.jdField_a_of_type_Lje.l <= 0) {
        break label351;
      }
      i += 360 - this.jdField_a_of_type_Lje.l;
    }
    for (;;)
    {
      i = i % 360 / 90;
      if (paramljh != null)
      {
        paramljh.jdField_a_of_type_Int = i;
        paramljh.b = n;
        paramljh.c = m;
        paramljh.d = j;
      }
      return;
      j = this.jdField_a_of_type_Lje.c() * 90;
      break;
      label219:
      if (this.jdField_a_of_type_Lje.f != 2) {
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
        if (this.jdField_a_of_type_Lje.f != 1) {
          break label134;
        }
        i = k;
        if (this.jdField_a_of_type_Lje.c) {
          break label134;
        }
        i = k + 180;
        break label134;
      }
      i = k;
      if (this.jdField_a_of_type_Lje.f != 1) {
        break label134;
      }
      i = k;
      if (!this.jdField_a_of_type_Lje.c) {
        break label134;
      }
      i = k + 180;
      break label134;
      label351:
      i += a(n, this.jdField_a_of_type_Lje.e);
      continue;
      label370:
      if (this.jdField_a_of_type_Lje.m > 0) {
        i += this.jdField_a_of_type_Lje.m;
      } else {
        i += b(n, this.jdField_a_of_type_Lje.e);
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      if (!mtd.a(this.jdField_a_of_type_Lje.a, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
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
      return lkw.a(this.jdField_a_of_type_Lje.a, false, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return lkw.b(this.jdField_a_of_type_Lje.a, false, false, b, false) * 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljg
 * JD-Core Version:    0.7.0.1
 */