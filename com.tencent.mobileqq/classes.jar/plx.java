import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class plx
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("NativeProteusBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    Map localMap = pku.a(paramString);
    Object localObject2 = localMap.keySet();
    Object localObject1 = "";
    paramString = "";
    Iterator localIterator = ((Set)localObject2).iterator();
    String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject2 = (String)localMap.get(str);
      QLog.d("NativeProteusBidConfigHandler", 2, "[onReceiveConfig] key=" + str + ", value=" + (String)localObject2);
      if (TextUtils.equals(str, "native_article"))
      {
        bmhv.a("native_proteus_offline_bid", (String)localObject2);
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
      break;
      if (TextUtils.equals(str, "native_article_cdn_url"))
      {
        localObject1 = paramString;
        paramString = (String)localObject2;
        continue;
        tnc.a(paramString, (String)localObject1);
        return true;
      }
      else
      {
        localObject2 = paramString;
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bmhv.a("native_proteus_offline_bid", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plx
 * JD-Core Version:    0.7.0.1
 */