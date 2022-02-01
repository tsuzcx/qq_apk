import android.graphics.SurfaceTexture;

public abstract class ljm
{
  protected int a;
  protected final ljk a;
  protected ljl a;
  protected final ljn a;
  protected ljz a;
  
  public ljm(ljk paramljk, ljl paramljl)
  {
    this.jdField_a_of_type_Ljz = new ljz();
    this.jdField_a_of_type_Ljn = new ljn();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ljk = paramljk;
    this.jdField_a_of_type_Ljl = paramljl;
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
      return llc.a(this.jdField_a_of_type_Ljk.a, true, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return llc.b(this.jdField_a_of_type_Ljk.a, true, false, b, false) * 90;
  }
  
  public abstract void a();
  
  public abstract void a(long paramLong, SurfaceTexture paramSurfaceTexture);
  
  public void a(ljn paramljn)
  {
    int i = 0;
    int m = this.jdField_a_of_type_Ljk.f();
    int j;
    int n;
    label60:
    int k;
    if (this.jdField_a_of_type_Ljk.e)
    {
      j = 0;
      n = this.jdField_a_of_type_Ljk.g();
      if (this.jdField_a_of_type_Ljk.f != 1) {
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
        if (this.jdField_a_of_type_Ljk.f == 1) {
          if (a())
          {
            i = k;
            if (!this.jdField_a_of_type_Ljk.d) {}
          }
          else
          {
            i = k + 180;
          }
        }
      }
      label134:
      if (this.jdField_a_of_type_Ljk.f != 1) {
        break label370;
      }
      if (this.jdField_a_of_type_Ljk.l <= 0) {
        break label351;
      }
      i += 360 - this.jdField_a_of_type_Ljk.l;
    }
    for (;;)
    {
      i = i % 360 / 90;
      if (paramljn != null)
      {
        paramljn.jdField_a_of_type_Int = i;
        paramljn.b = n;
        paramljn.c = m;
        paramljn.d = j;
      }
      return;
      j = this.jdField_a_of_type_Ljk.c() * 90;
      break;
      label219:
      if (this.jdField_a_of_type_Ljk.f != 2) {
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
        if (this.jdField_a_of_type_Ljk.f != 1) {
          break label134;
        }
        i = k;
        if (this.jdField_a_of_type_Ljk.c) {
          break label134;
        }
        i = k + 180;
        break label134;
      }
      i = k;
      if (this.jdField_a_of_type_Ljk.f != 1) {
        break label134;
      }
      i = k;
      if (!this.jdField_a_of_type_Ljk.c) {
        break label134;
      }
      i = k + 180;
      break label134;
      label351:
      i += a(n, this.jdField_a_of_type_Ljk.e);
      continue;
      label370:
      if (this.jdField_a_of_type_Ljk.m > 0) {
        i += this.jdField_a_of_type_Ljk.m;
      } else {
        i += b(n, this.jdField_a_of_type_Ljk.e);
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      if (!mtj.a(this.jdField_a_of_type_Ljk.a, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
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
      return llc.a(this.jdField_a_of_type_Ljk.a, false, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return llc.b(this.jdField_a_of_type_Ljk.a, false, false, b, false) * 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljm
 * JD-Core Version:    0.7.0.1
 */