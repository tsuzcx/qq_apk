import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class otw
  implements AladdinConfigHandler
{
  private final String a = "reset_kandian_configuration";
  private final String b = "reset_version";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("ResetAllConfigHandler", 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    Map localMap = osq.a(paramString);
    Object localObject2 = localMap.keySet();
    Object localObject1 = "";
    paramString = "";
    Iterator localIterator = ((Set)localObject2).iterator();
    String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject2 = (String)localMap.get(str);
      QLog.d("ResetAllConfigHandler", 2, "[onReceiveConfig] key=" + str + ", value=" + (String)localObject2);
      if (TextUtils.equals(str, "reset_kandian_configuration"))
      {
        localObject1 = paramString;
        paramString = (String)localObject2;
      }
    }
    for (;;)
    {
      localObject2 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
      break;
      if (TextUtils.equals(str, "reset_version"))
      {
        paramString = (String)localObject1;
        localObject1 = localObject2;
        continue;
        if ((TextUtils.equals("1", (CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString))) {}
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          bdne.q(BaseApplicationImpl.getApplication(), paramInt1, ors.a());
          return true;
        }
        catch (NumberFormatException paramString)
        {
          QLog.e("ResetAllConfigHandler", 1, "[onReceiveConfig] e = " + paramString);
          return true;
        }
      }
      localObject2 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("ResetAllConfigHandler", 2, "[onWipeConfig] id=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     otw
 * JD-Core Version:    0.7.0.1
 */