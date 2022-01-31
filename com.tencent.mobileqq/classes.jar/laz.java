import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import mqq.observer.BusinessObserver;

class laz
  implements Runnable
{
  laz(lay paramlay, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_Lay.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_Lay.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Lay.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountMenuResponse);
    if (this.jdField_a_of_type_Lay.jdField_a_of_type_MqqObserverBusinessObserver != null) {
      this.jdField_a_of_type_Lay.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     laz
 * JD-Core Version:    0.7.0.1
 */