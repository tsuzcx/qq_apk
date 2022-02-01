package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;

public class CpuUtils
{
  static
  {
    try
    {
      System.loadLibrary("cpu_v1.1");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("CpuUtils", 1, "loadLibrary error.", localUnsatisfiedLinkError);
    }
  }
  
  private static native long getCpuFeatures();
  
  public static long getCpuProperty()
  {
    try
    {
      long l = getCpuFeatures();
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("CpuUtils", 1, "getCpuFeatures error. ", localUnsatisfiedLinkError);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.CpuUtils
 * JD-Core Version:    0.7.0.1
 */