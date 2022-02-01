import com.tencent.common.app.BaseApplicationImpl;

public class lol
{
  private static lol a;
  
  public static lol a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new lol();
      lol locallol = a;
      return locallol;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    float f;
    try
    {
      f = Float.parseFloat(lfu.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/ratio", "1.0"));
      if (f <= 0.0F) {
        return 1.0F;
      }
    }
    catch (Exception localException)
    {
      return 1.0F;
    }
    return f;
  }
  
  public boolean a()
  {
    return lfu.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/flag", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lol
 * JD-Core Version:    0.7.0.1
 */