import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class oto
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("KingcardConfigHandler", 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    paramString = osq.a(paramString);
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
            bjxj.o(Integer.parseInt(str2));
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
        bjxj.i(str2);
      } else if (TextUtils.equals(str1, "kingcard_tiptext")) {
        bjxj.j(str2);
      } else if (TextUtils.equals(str1, "kingcard_jumptext")) {
        bjxj.k(str2);
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bjxj.o(0);
    bjxj.i("");
    bjxj.j("");
    bjxj.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oto
 * JD-Core Version:    0.7.0.1
 */