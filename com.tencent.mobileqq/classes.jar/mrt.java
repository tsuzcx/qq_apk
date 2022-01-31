import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;

public class mrt
  implements Runnable
{
  public mrt(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, ServiceAccountFolderFeed paramServiceAccountFolderFeed) {}
  
  public void run()
  {
    ServiceAccountFolderManager.a().a(ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter), this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrt
 * JD-Core Version:    0.7.0.1
 */