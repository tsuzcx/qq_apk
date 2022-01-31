import com.tencent.common.app.BaseApplicationImpl;

public class lpd
{
  private static lpd jdField_a_of_type_Lpd;
  int jdField_a_of_type_Int = 0;
  
  public static lpd a()
  {
    try
    {
      lpd locallpd;
      if (jdField_a_of_type_Lpd != null)
      {
        locallpd = jdField_a_of_type_Lpd;
        return locallpd;
      }
      return null;
    }
    finally
    {
      try
      {
        jdField_a_of_type_Lpd = new lpd();
        locallpd = jdField_a_of_type_Lpd;
        return locallpd;
      }
      catch (Exception localException) {}
      localObject = finally;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (lgj.a(BaseApplicationImpl.getContext()).a("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (lgj.a(BaseApplicationImpl.getContext()).a("sharp/qavGestureConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (lgj.a(BaseApplicationImpl.getContext()).a("sharp/qavRedbagConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (lgj.a(BaseApplicationImpl.getContext()).a("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (lgj.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    return lgj.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/enable", 0) == 1;
  }
  
  public boolean g()
  {
    return lgj.a(BaseApplicationImpl.getContext()).a("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1;
  }
  
  public boolean h()
  {
    return 1 == lgj.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDetectInversion/Inversion", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpd
 * JD-Core Version:    0.7.0.1
 */