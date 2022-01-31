import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class lou
  implements Runnable
{
  public lou(AdvertisementInfoModule paramAdvertisementInfoModule, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("DELETE FROM " + AdvertisementInfo.class.getSimpleName() + " WHERE mChannelID = " + this.jdField_a_of_type_Int);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(localAdvertisementInfo);
      if (QLog.isColorLevel()) {
        QLog.d("adAppModule", 2, "info type = " + localAdvertisementInfo.mAdJumpMode);
      }
      if ((localAdvertisementInfo.mAdJumpMode == 4) && (TextUtils.isEmpty(localAdvertisementInfo.mAdAppJson))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.jdField_a_of_type_ComTencentCommonAppAppInterface, localAdvertisementInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lou
 * JD-Core Version:    0.7.0.1
 */