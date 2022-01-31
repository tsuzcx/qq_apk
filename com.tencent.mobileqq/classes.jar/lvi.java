public class lvi
  extends lum
{
  public int b;
  public long b;
  public int c;
  public long c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public void a(long paramLong)
  {
    paramLong -= this.a;
    int i1 = 0;
    float f2 = 1.0F;
    int m = this.jdField_b_of_type_Int;
    int n = this.jdField_c_of_type_Int;
    int i;
    float f1;
    int j;
    int k;
    if ((paramLong > 2333L) && (paramLong < 2666L))
    {
      i = (int)(255L * (paramLong - 2333L) / 333L);
      f1 = (0.5F * (float)(2666L + paramLong) - 2333.0F) / 333.0F;
      j = (int)((this.d * paramLong + this.jdField_b_of_type_Long) / 333L);
      k = (int)((paramLong * this.e + this.jdField_c_of_type_Long) / 333L);
    }
    for (;;)
    {
      a(i);
      b(f1);
      a(j, k, this.f + j, this.g + k);
      return;
      if ((paramLong >= 2666L) && (paramLong <= 4631L))
      {
        i = 255;
        k = n;
        j = m;
        f1 = f2;
      }
      else
      {
        k = n;
        j = m;
        f1 = f2;
        i = i1;
        if (paramLong > 4631L)
        {
          k = n;
          j = m;
          f1 = f2;
          i = i1;
          if (paramLong < 4798L)
          {
            i = (int)((paramLong - 4798L) * 255L / -167L);
            k = n;
            j = m;
            f1 = f2;
          }
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 44 / 750);
    this.jdField_c_of_type_Int = (paramInt2 - paramInt1 * 624 / 750);
    paramInt3 = paramInt1 * 154 / 750;
    paramInt4 = paramInt1 * 537 / 750;
    this.f = (paramInt1 * 221 / 750);
    this.g = (paramInt1 * 175 / 750);
    this.d = (paramInt1 * -110 / 750);
    this.e = (paramInt1 * -87 / 750);
    this.jdField_b_of_type_Long = (paramInt3 * 2666L - this.jdField_b_of_type_Int * 2333L);
    this.jdField_c_of_type_Long = ((paramInt2 - paramInt4) * 2666L - this.jdField_c_of_type_Int * 2333L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lvi
 * JD-Core Version:    0.7.0.1
 */