import com.tencent.common.app.BaseApplicationImpl;

public class los
{
  private static los a;
  
  public static los a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new los();
      los locallos = a;
      return locallos;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    try
    {
      float f1 = Float.parseFloat(lfo.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseratio", "15.0"));
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
    return lfo.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/lowlightflag", 0) == 1;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (lfo.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/lowlightflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return lfo.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseflag", 0) == 1;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (lfo.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     los
 * JD-Core Version:    0.7.0.1
 */