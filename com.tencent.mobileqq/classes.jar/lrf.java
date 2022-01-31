import com.tencent.common.app.BaseApplicationImpl;

public class lrf
{
  private static lrf a;
  
  public static lrf a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new lrf();
      lrf locallrf = a;
      return locallrf;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    float f;
    try
    {
      f = Float.parseFloat(lim.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/ratio", "1.0"));
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
    return lim.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/flag", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrf
 * JD-Core Version:    0.7.0.1
 */