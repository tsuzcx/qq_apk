package com.tencent.mobileqq.utils.palette;

final class Palette$1
  implements Palette.Filter
{
  private boolean a(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] <= 0.05F;
  }
  
  private boolean b(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] >= 0.95F;
  }
  
  private boolean c(float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfFloat[0] >= 10.0F)
    {
      bool1 = bool2;
      if (paramArrayOfFloat[0] <= 37.0F)
      {
        bool1 = bool2;
        if (paramArrayOfFloat[1] <= 0.82F) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, float[] paramArrayOfFloat)
  {
    return (!b(paramArrayOfFloat)) && (!a(paramArrayOfFloat)) && (!c(paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette.1
 * JD-Core Version:    0.7.0.1
 */