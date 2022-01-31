public class lur
  extends lum
{
  public boolean a;
  
  public void a(long paramLong)
  {
    paramLong -= this.jdField_a_of_type_Long;
    int j = 0;
    float f2 = 1.0F;
    int i;
    float f1;
    if (paramLong <= 500L)
    {
      i = 0;
      f1 = f2;
    }
    for (;;)
    {
      a(i);
      b(f1);
      return;
      if ((paramLong > 500L) && (paramLong < 1167L))
      {
        i = (int)(255L * (paramLong - 500L) / 667L);
        f1 = (0.5F * (float)(paramLong + 1167L) - 500.0F) / 667.0F;
      }
      else if (((paramLong >= 1167L) && (paramLong <= 2167L)) || (!this.jdField_a_of_type_Boolean))
      {
        i = 255;
        f1 = f2;
      }
      else
      {
        f1 = f2;
        i = j;
        if (paramLong > 2167L)
        {
          f1 = f2;
          i = j;
          if (paramLong < 2500L)
          {
            i = (int)((paramLong - 2500L) * 255L / -333L);
            f1 = f2;
          }
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1 * 5 / 1500, paramInt2 - paramInt1 * 752 / 750, paramInt1 * 1495 / 1500, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lur
 * JD-Core Version:    0.7.0.1
 */