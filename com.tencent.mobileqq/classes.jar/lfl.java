import android.content.Context;
import android.media.AudioManager;
import java.lang.reflect.Method;

public class lfl
{
  static int a = 0;
  static int b = 0;
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      boolean bool = Boolean.parseBoolean(paramContext.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(paramContext, (Object[])null).toString());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfl
 * JD-Core Version:    0.7.0.1
 */