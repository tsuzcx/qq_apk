package rx.internal.util;

import java.lang.reflect.Field;
import java.security.AccessController;

public final class PlatformDependent
{
  private static final int ANDROID_API_VERSION = ;
  public static final int ANDROID_API_VERSION_IS_NOT_ANDROID = 0;
  private static final boolean IS_ANDROID;
  
  static
  {
    boolean bool;
    if (ANDROID_API_VERSION != 0) {
      bool = true;
    } else {
      bool = false;
    }
    IS_ANDROID = bool;
  }
  
  public static int getAndroidApiVersion()
  {
    return ANDROID_API_VERSION;
  }
  
  static ClassLoader getSystemClassLoader()
  {
    if (System.getSecurityManager() == null) {
      return ClassLoader.getSystemClassLoader();
    }
    return (ClassLoader)AccessController.doPrivileged(new PlatformDependent.1());
  }
  
  public static boolean isAndroid()
  {
    return IS_ANDROID;
  }
  
  private static int resolveAndroidApiVersion()
  {
    try
    {
      int i = ((Integer)Class.forName("android.os.Build$VERSION", true, getSystemClassLoader()).getField("SDK_INT").get(null)).intValue();
      return i;
    }
    catch (Exception localException)
    {
      label27:
      break label27;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.PlatformDependent
 * JD-Core Version:    0.7.0.1
 */