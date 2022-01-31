import android.content.Context;
import android.content.Intent;
import com.tencent.av.screenshare.floatingwindow.ScreenShareFloatingWindowService;
import com.tencent.qphone.base.util.QLog;

public final class lyo
{
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ScreenShareFloatingWindowService.class);
    try
    {
      paramContext.stopService(localIntent);
      paramContext.startService(localIntent);
      if ((!a(paramContext)) && (QLog.isColorLevel())) {
        QLog.d("ScreenShareFloatingWindowUtils", 2, "requestScreenSharePermissionDialog fail");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShareFloatingWindowUtils", 2, "actionOn e = " + localException);
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return mbt.a(paramContext, true, null, false);
  }
  
  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ScreenShareFloatingWindowService.class);
    try
    {
      paramContext.stopService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ScreenShareFloatingWindowUtils", 2, "tryStopScreenRecordFloatingWindowService= " + paramContext);
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return mbt.c(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyo
 * JD-Core Version:    0.7.0.1
 */