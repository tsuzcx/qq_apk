public abstract class kzr
{
  private static kyz a;
  
  public static kyz a()
  {
    try
    {
      if (a == null) {
        a = new kyz();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kzr
 * JD-Core Version:    0.7.0.1
 */