import com.tencent.common.app.BaseApplicationImpl;

public class lom
{
  private static lom jdField_a_of_type_Lom;
  int jdField_a_of_type_Int = 0;
  
  public static lom a()
  {
    try
    {
      lom locallom;
      if (jdField_a_of_type_Lom != null)
      {
        locallom = jdField_a_of_type_Lom;
        return locallom;
      }
      return null;
    }
    finally
    {
      try
      {
        jdField_a_of_type_Lom = new lom();
        locallom = jdField_a_of_type_Lom;
        return locallom;
      }
      catch (Exception localException) {}
      localObject = finally;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (lfu.a(BaseApplicationImpl.getContext()).a("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (lfu.a(BaseApplicationImpl.getContext()).a("sharp/qavGestureConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (lfu.a(BaseApplicationImpl.getContext()).a("sharp/qavRedbagConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (lfu.a(BaseApplicationImpl.getContext()).a("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (lfu.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    return lfu.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/enable", 0) == 1;
  }
  
  public boolean g()
  {
    return lfu.a(BaseApplicationImpl.getContext()).a("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1;
  }
  
  public boolean h()
  {
    return 1 == lfu.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDetectInversion/Inversion", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lom
 * JD-Core Version:    0.7.0.1
 */