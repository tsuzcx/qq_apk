import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;

public class kul
  implements Runnable
{
  public kul(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      AdvertisementVideoPreloadManager.b(((PAAdPreloadTask)localIterator.next()).mVideoVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kul
 * JD-Core Version:    0.7.0.1
 */