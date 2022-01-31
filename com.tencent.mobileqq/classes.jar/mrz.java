import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mrz
  implements Runnable
{
  public mrz(ServiceAccountFolderManager paramServiceAccountFolderManager, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed, false);
    }
    localArrayList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrz
 * JD-Core Version:    0.7.0.1
 */