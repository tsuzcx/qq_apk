package cooperation.qzone.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class PanoramaUtil$1
  implements Runnable
{
  PanoramaUtil$1(PanoramaUtil paramPanoramaUtil, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.val$matValue != null) && (!TextUtils.isEmpty(this.val$matValue)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(this.val$matKey, this.val$matValue);
      Context localContext = BaseApplication.getContext();
      if (localContext != null) {
        StatisticCollector.getInstance(localContext).collectPerformance(null, "qzone_panorama", true, this.val$time, 0L, localHashMap, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.PanoramaUtil.1
 * JD-Core Version:    0.7.0.1
 */