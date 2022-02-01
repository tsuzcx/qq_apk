import com.tencent.common.app.BaseApplicationImpl;

public class lon
{
  private static lon a;
  
  public static lon a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new lon();
      lon locallon = a;
      return locallon;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    try
    {
      float f1 = Float.parseFloat(lfu.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseratio", "15.0"));
      float f2;
      if (f1 <= 0.0D) {
        f2 = 0.0F;
      }
      do
      {
        return f2;
        f2 = f1;
      } while (f1 < 30.0D);
      return 30.0F;
    }
    catch (Exception localException) {}
    return 15.0F;
  }
  
  public boolean a()
  {
    return lfu.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/lowlightflag", 0) == 1;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (lfu.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/lowlightflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return lfu.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseflag", 0) == 1;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (lfu.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lon
 * JD-Core Version:    0.7.0.1
 */