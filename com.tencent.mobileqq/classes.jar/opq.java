import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class opq
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public static String a = "ViolaPicDetailConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d(a, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    Map localMap = oof.a(paramString);
    Object localObject = localMap.keySet();
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)localMap.get(str1);
        if (TextUtils.equals(str1, "viola_pic_detail_switch")) {
          bhvy.c(Integer.parseInt(str2));
        }
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString + " , error= " + localThrowable.getMessage());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    bhvy.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opq
 * JD-Core Version:    0.7.0.1
 */