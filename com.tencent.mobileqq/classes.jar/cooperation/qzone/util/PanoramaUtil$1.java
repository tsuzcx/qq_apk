package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import mqq.app.MobileQQ;

class PanoramaUtil$1
  implements Runnable
{
  PanoramaUtil$1(PanoramaUtil paramPanoramaUtil, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.val$matValue;
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(this.val$matKey, this.val$matValue);
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      if (localMobileQQ != null) {
        StatisticCollector.getInstance(localMobileQQ).collectPerformance(null, "qzone_panorama", true, this.val$time, 0L, (HashMap)localObject, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.util.PanoramaUtil.1
 * JD-Core Version:    0.7.0.1
 */