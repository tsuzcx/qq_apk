package cooperation.vip.common;

import android.app.Activity;
import java.lang.reflect.Method;

public abstract class VipHandler
{
  public static VipHandler a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("cooperation.vip.common.VipClass").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (VipHandler)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    VipHandler localVipHandler = a;
    if (localVipHandler != null) {
      localVipHandler.a(paramActivity, paramString);
    }
  }
  
  public abstract void a(Activity paramActivity, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.common.VipHandler
 * JD-Core Version:    0.7.0.1
 */