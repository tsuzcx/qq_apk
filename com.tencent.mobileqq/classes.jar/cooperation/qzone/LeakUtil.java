package cooperation.qzone;

import android.app.Activity;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class LeakUtil
{
  public static void a(Activity paramActivity)
  {
    if (Build.MANUFACTURER.contains("samsung")) {
      if (QLog.isColorLevel()) {
        QLog.i("LeakUtil", 2, "removeLeakOn_SpenGestureManager samsung device");
      }
    }
    try
    {
      paramActivity = Class.forName("com.samsung.android.smartclip.SpenGestureManager").getDeclaredField("mContext");
      paramActivity.setAccessible(true);
      paramActivity.set(null, null);
      return;
    }
    catch (ClassNotFoundException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (NoSuchFieldException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.LeakUtil
 * JD-Core Version:    0.7.0.1
 */