import com.tencent.common.app.BaseApplicationImpl;

public class lrg
{
  private static lrg jdField_a_of_type_Lrg;
  int jdField_a_of_type_Int = 0;
  
  public static lrg a()
  {
    try
    {
      lrg locallrg;
      if (jdField_a_of_type_Lrg != null)
      {
        locallrg = jdField_a_of_type_Lrg;
        return locallrg;
      }
      return null;
    }
    finally
    {
      try
      {
        jdField_a_of_type_Lrg = new lrg();
        locallrg = jdField_a_of_type_Lrg;
        return locallrg;
      }
      catch (Exception localException) {}
      localObject = finally;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (lim.a(BaseApplicationImpl.getContext()).a("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (lim.a(BaseApplicationImpl.getContext()).a("sharp/qavGestureConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (lim.a(BaseApplicationImpl.getContext()).a("sharp/qavRedbagConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (lim.a(BaseApplicationImpl.getContext()).a("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (lim.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    return lim.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/enable", 0) == 1;
  }
  
  public boolean g()
  {
    return lim.a(BaseApplicationImpl.getContext()).a("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1;
  }
  
  public boolean h()
  {
    return 1 == lim.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDetectInversion/Inversion", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrg
 * JD-Core Version:    0.7.0.1
 */