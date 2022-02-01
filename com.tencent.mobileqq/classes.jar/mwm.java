public class mwm
{
  public static int a(int paramInt1, int paramInt2)
  {
    return (paramInt1 % paramInt2 + paramInt2) % paramInt2;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt1 = a(paramInt1, paramInt3);
    paramInt2 = a(paramInt2, paramInt3);
    if (paramBoolean)
    {
      if (paramInt1 > paramInt2) {
        return paramInt1 - paramInt2;
      }
      return paramInt1 + (paramInt3 - paramInt2);
    }
    if (paramInt1 > paramInt2) {
      return paramInt3 - paramInt1 + paramInt2;
    }
    return paramInt2 - paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mwm
 * JD-Core Version:    0.7.0.1
 */