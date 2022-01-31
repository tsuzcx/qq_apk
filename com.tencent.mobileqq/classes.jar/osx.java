import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class osx
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("AdFeedsProteusBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = osq.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("AdFeedsProteusBidConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "commercialAd_feeds")) {
        bjxj.a("ad_feeds_proteus_offline_bid", str2);
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    bjxj.a("ad_feeds_proteus_offline_bid", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     osx
 * JD-Core Version:    0.7.0.1
 */