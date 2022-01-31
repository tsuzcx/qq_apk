public abstract class lax
{
  private static laf a;
  
  public static laf a()
  {
    try
    {
      if (a == null) {
        a = new laf();
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     lax
 * JD-Core Version:    0.7.0.1
 */