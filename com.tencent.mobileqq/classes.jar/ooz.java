import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ooz
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public static String a = "HomePageConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d(a, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    paramString = oof.a(paramString);
    Object localObject = paramString.keySet();
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)paramString.get(str1);
        if (TextUtils.equals(str1, "rij_person_info_page_use_viola")) {
          bhvy.m(Integer.parseInt(str2));
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    bhvy.m(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooz
 * JD-Core Version:    0.7.0.1
 */