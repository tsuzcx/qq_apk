public class lkb
  extends lka
{
  public void a(long paramLong)
  {
    paramLong -= this.a;
    int j = 0;
    float f2 = 1.0F;
    int i;
    float f1;
    if ((paramLong > 3865L) && (paramLong < 4198L))
    {
      i = (int)(255L * (paramLong - 3865L) / 333L);
      f1 = (0.5F * (float)(paramLong + 4198L) - 3865.0F) / 333.0F;
    }
    for (;;)
    {
      a(i);
      b(f1);
      return;
      if ((paramLong >= 4198L) && (paramLong <= 4631L))
      {
        i = 255;
        f1 = f2;
      }
      else
      {
        f1 = f2;
        i = j;
        if (paramLong > 4631L)
        {
          f1 = f2;
          i = j;
          if (paramLong < 4798L)
          {
            i = (int)(255L * (4798L - paramLong) / 167L);
            f1 = (167.0F - (float)(4631L - paramLong) * 0.5F) / 167.0F;
          }
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1 * 548 / 1500, paramInt2 - paramInt1 * 1032 / 1500, paramInt1 * 952 / 1500, paramInt2 - paramInt1 * 472 / 1500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lkb
 * JD-Core Version:    0.7.0.1
 */