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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramLong));
      localStringBuilder.append(a[i]);
      return localStringBuilder.toString();
    }
    f1 /= 1024.0F;
    float f2 = (float)paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("%.2f", new Object[] { Float.valueOf(f1 + f2) }));
    localStringBuilder.append(a[i]);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.ByteUnitTransformUtil
 * JD-Core Version:    0.7.0.1
 */