import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import mqq.os.MqqHandler;

public class mqh
  implements Runnable
{
  public mqh(ServiceAccountFolderActivity paramServiceAccountFolderActivity, ServiceAccountFolderManager paramServiceAccountFolderManager) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.app);
    ServiceAccountFolderActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).sendEmptyMessage(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqh
 * JD-Core Version:    0.7.0.1
 */