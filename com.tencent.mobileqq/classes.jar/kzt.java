public abstract class kzt
{
  private static kzb a;
  
  public static kzb a()
  {
    try
    {
      if (a == null) {
        a = new kzb();
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
 * Qualified Name:     kzt
 * JD-Core Version:    0.7.0.1
 */