import com.tencent.common.app.BaseApplicationImpl;

public class lor
{
  private static lor jdField_a_of_type_Lor;
  int jdField_a_of_type_Int = 0;
  
  public static lor a()
  {
    try
    {
      lor locallor;
      if (jdField_a_of_type_Lor != null)
      {
        locallor = jdField_a_of_type_Lor;
        return locallor;
      }
      return null;
    }
    finally
    {
      try
      {
        jdField_a_of_type_Lor = new lor();
        locallor = jdField_a_of_type_Lor;
        return locallor;
      }
      catch (Exception localException) {}
      localObject = finally;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (lfo.a(BaseApplicationImpl.getContext()).a("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (lfo.a(BaseApplicationImpl.getContext()).a("sharp/qavGestureConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (lfo.a(BaseApplicationImpl.getContext()).a("sharp/qavRedbagConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (lfo.a(BaseApplicationImpl.getContext()).a("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (lfo.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    return lfo.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/enable", 0) == 1;
  }
  
  public boolean g()
  {
    return lfo.a(BaseApplicationImpl.getContext()).a("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1;
  }
  
  public boolean h()
  {
    return 1 == lfo.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDetectInversion/Inversion", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lor
 * JD-Core Version:    0.7.0.1
 */