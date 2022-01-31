import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class opd
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("KingcardConfigHandler", 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    paramString = oof.a(paramString);
    Object localObject = paramString.keySet();
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        localObject = ((Set)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = (String)paramString.get(str1);
          if (TextUtils.equals(str1, "kingcard_switch")) {
            bhvy.o(Integer.parseInt(str2));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      if (TextUtils.equals(str1, "kingcard_guide_url")) {
        bhvy.i(str2);
      } else if (TextUtils.equals(str1, "kingcard_tiptext")) {
        bhvy.j(str2);
      } else if (TextUtils.equals(str1, "kingcard_jumptext")) {
        bhvy.k(str2);
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bhvy.o(0);
    bhvy.i("");
    bhvy.j("");
    bhvy.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opd
 * JD-Core Version:    0.7.0.1
 */