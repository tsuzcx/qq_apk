import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class paw
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("AdNativeProteusBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = pan.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("AdNativeProteusBidConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "commercialAdDetails_feeds")) {
        bnrf.a("ad_native_proteus_offline_bid", str2);
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    bnrf.a("ad_native_proteus_offline_bid", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     paw
 * JD-Core Version:    0.7.0.1
 */