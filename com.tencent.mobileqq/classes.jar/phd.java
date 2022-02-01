public class phd
{
  public static String a(long paramLong)
  {
    long l = (paramLong >>> 1) / 5L;
    return Long.toString(l) + (paramLong - 10L * l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phd
 * JD-Core Version:    0.7.0.1
 */