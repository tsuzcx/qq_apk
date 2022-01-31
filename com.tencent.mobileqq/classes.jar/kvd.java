import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class kvd
  implements Runnable
{
  public kvd(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager, String paramString) {}
  
  public void run()
  {
    synchronized (AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager))
    {
      AdvertisementVideoPreloadManager.c("loadLocalConfigTask uin:" + this.jdField_a_of_type_JavaLangString);
      Object localObject2 = AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager);
      if (localObject2 != null)
      {
        localObject2 = ((PublicAccountEntityHelper)localObject2).a(PAAdPreloadTask.class, true, "mUserUin = ?", new String[] { this.jdField_a_of_type_JavaLangString }, null, null, "mExpireTime asc", null);
        if (localObject2 != null)
        {
          AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager).clear();
          AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager).addAll((Collection)localObject2);
          AdvertisementVideoPreloadManager.c("loadLocalConfigTask taskSize:" + ((List)localObject2).size());
          ThreadManager.executeOnNetWorkThread(new kve(this));
        }
      }
      else
      {
        return;
      }
      AdvertisementVideoPreloadManager.c("loadLocalConfigTask tasklist null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvd
 * JD-Core Version:    0.7.0.1
 */