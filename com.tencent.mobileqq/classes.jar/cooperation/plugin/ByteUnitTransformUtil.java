package cooperation.plugin;

public class ByteUnitTransformUtil
{
  private static final String[] a = { "B", "K", "M", "G" };
  
  public static final String a(long paramLong)
  {
    float f1 = 0.0F;
    int i = 0;
    while (paramLong >= 1024L)
    {
      paramLong /= 1024L;
      f1 = (float)(paramLong % 1024L);
      i += 1;
    }
    if (f1 == 0.0F)
    {
      f1 = (float)paramLong;
      return String.valueOf(paramLong) + a[i];
    }
    f1 /= 1024.0F;
    float f2 = (float)paramLong;
    return String.format("%.2f", new Object[] { Float.valueOf(f1 + f2) }) + a[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.ByteUnitTransformUtil
 * JD-Core Version:    0.7.0.1
 */