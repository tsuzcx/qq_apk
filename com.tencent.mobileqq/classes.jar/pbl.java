import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class pbl
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("KandianOpenOptConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = pan.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("KandianOpenOptConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "opt_open_cost")) {
        bnrf.a("preload_controller", Boolean.valueOf("1".equals(str2)));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    bnrf.a("preload_controller", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbl
 * JD-Core Version:    0.7.0.1
 */