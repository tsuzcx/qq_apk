package dov.com.qq.im.capture.banner;

import blrk;
import bltq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class QIMCaptureBannerManager$1
  implements Runnable
{
  public QIMCaptureBannerManager$1(blrk paramblrk) {}
  
  public void run()
  {
    QIMCaptureBannerConfig localQIMCaptureBannerConfig = QIMCaptureBannerConfig.getBannerConfigFromFile(this.this$0.a(), blrk.jdField_a_of_type_JavaLangString);
    if ((localQIMCaptureBannerConfig != null) && (localQIMCaptureBannerConfig.mBannerList.size() > 0))
    {
      ??? = localQIMCaptureBannerConfig.mBannerList.entrySet().iterator();
      while (((Iterator)???).hasNext())
      {
        QIMCaptureBannerConfig.BannerItem localBannerItem = (QIMCaptureBannerConfig.BannerItem)((Map.Entry)((Iterator)???).next()).getValue();
        long l = NetConnInfoCenter.getServerTimeMillis();
        if (localBannerItem.mEndTime < l) {
          ((Iterator)???).remove();
        }
      }
    }
    synchronized (blrk.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig = localQIMCaptureBannerConfig;
      if (QLog.isColorLevel()) {
        QLog.d("QIMCaptureBannerManager", 2, "initBannerFromCache= " + localQIMCaptureBannerConfig);
      }
      this.this$0.a().notifyObservers(bltq.class, 6, true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.1
 * JD-Core Version:    0.7.0.1
 */