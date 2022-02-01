package de.robv.android.xposed;

import android.os.SELinux;
import de.robv.android.xposed.services.BaseService;
import de.robv.android.xposed.services.BinderService;
import de.robv.android.xposed.services.DirectAccessService;
import de.robv.android.xposed.services.ZygoteService;

public final class SELinuxHelper
{
  private static boolean sIsSELinuxEnabled = false;
  private static BaseService sServiceAppDataFile = null;
  
  public static BaseService getAppDataFileService()
  {
    if (sServiceAppDataFile != null) {
      return sServiceAppDataFile;
    }
    throw new UnsupportedOperationException();
  }
  
  public static String getContext()
  {
    if (sIsSELinuxEnabled) {
      return SELinux.getContext();
    }
    return null;
  }
  
  static void initForProcess(String paramString)
  {
    if (sIsSELinuxEnabled)
    {
      if (paramString == null)
      {
        sServiceAppDataFile = new ZygoteService();
        return;
      }
      if (paramString.equals("android"))
      {
        sServiceAppDataFile = BinderService.getService(0);
        return;
      }
      sServiceAppDataFile = new DirectAccessService();
      return;
    }
    sServiceAppDataFile = new DirectAccessService();
  }
  
  static void initOnce()
  {
    try
    {
      sIsSELinuxEnabled = SELinux.isSELinuxEnabled();
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}
  }
  
  public static boolean isSELinuxEnabled()
  {
    return sIsSELinuxEnabled;
  }
  
  public static boolean isSELinuxEnforced()
  {
    return (sIsSELinuxEnabled) && (SELinux.isSELinuxEnforced());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.SELinuxHelper
 * JD-Core Version:    0.7.0.1
 */