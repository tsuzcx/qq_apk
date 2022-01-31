import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class oug
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public static String a = "ViolaPicSerPreloadHandler";
  public static String b = "viola_service_instance";
  
  public static boolean a()
  {
    return ((Boolean)bjxj.a(b, Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d(a, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    Map localMap = osq.a(paramString);
    Object localObject = localMap.keySet();
    for (;;)
    {
      try
      {
        localObject = ((Set)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          String str1 = (String)localMap.get(str2);
          if (!TextUtils.equals(str2, "viola_service_instance_open")) {
            continue;
          }
          str2 = b;
          if (Integer.parseInt(str1) == 1)
          {
            bool = true;
            bjxj.a(str2, Boolean.valueOf(bool));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(a, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString + " , error= " + localThrowable.getMessage());
      }
      boolean bool = false;
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    bjxj.a(b, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oug
 * JD-Core Version:    0.7.0.1
 */