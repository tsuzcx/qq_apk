import com.tencent.common.app.BaseApplicationImpl;

public class lpc
{
  private static lpc a;
  
  public static lpc a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new lpc();
      lpc locallpc = a;
      return locallpc;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    float f;
    try
    {
      f = Float.parseFloat(lgj.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/ratio", "1.0"));
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
    return lgj.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/flag", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpc
 * JD-Core Version:    0.7.0.1
 */