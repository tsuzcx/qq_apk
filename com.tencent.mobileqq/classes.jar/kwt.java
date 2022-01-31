import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class kwt
  implements Runnable
{
  public kwt(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void run()
  {
    PublicAccountEntityHelper localPublicAccountEntityHelper = AdvertisementVideoPreloadManager.a(this.a);
    if (localPublicAccountEntityHelper != null)
    {
      localPublicAccountEntityHelper.a(PAAdPreloadTask.class.getSimpleName());
      Iterator localIterator = AdvertisementVideoPreloadManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        localPublicAccountEntityHelper.a((PAAdPreloadTask)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kwt
 * JD-Core Version:    0.7.0.1
 */