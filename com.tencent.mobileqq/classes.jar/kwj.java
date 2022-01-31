import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import java.util.ArrayList;
import java.util.Iterator;

public class kwj
  implements Runnable
{
  public kwj(AdvertisementRecentUserManager paramAdvertisementRecentUserManager, AdvertisementItem paramAdvertisementItem) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.iterator();
    while (localIterator.hasNext()) {
      AdvertisementVideoPreloadManager.b(((VideoCoverItem)localIterator.next()).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kwj
 * JD-Core Version:    0.7.0.1
 */