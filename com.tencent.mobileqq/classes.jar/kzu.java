public abstract class kzu
{
  private static kzc a;
  
  public static kzc a()
  {
    try
    {
      if (a == null) {
        a = new kzc();
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
 * Qualified Name:     kzu
 * JD-Core Version:    0.7.0.1
 */