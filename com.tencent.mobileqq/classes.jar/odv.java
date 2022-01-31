import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class odv
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("KingcardConfigHandler", 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    paramString = ocx.a(paramString);
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
            bgmq.o(Integer.parseInt(str2));
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
        bgmq.i(str2);
      } else if (TextUtils.equals(str1, "kingcard_tiptext")) {
        bgmq.j(str2);
      } else if (TextUtils.equals(str1, "kingcard_jumptext")) {
        bgmq.k(str2);
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bgmq.o(0);
    bgmq.i("");
    bgmq.j("");
    bgmq.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odv
 * JD-Core Version:    0.7.0.1
 */