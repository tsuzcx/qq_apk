public class lov
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("point"))) {}
    do
    {
      return 0;
      if (paramString.equals("line")) {
        return 1;
      }
      if (paramString.equals("square")) {
        return 2;
      }
    } while (!paramString.equals("ellipse"));
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lov
 * JD-Core Version:    0.7.0.1
 */