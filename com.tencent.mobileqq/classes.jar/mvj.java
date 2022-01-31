import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.data.OpenID;

class mvj
  implements Runnable
{
  mvj(mvi parammvi, Object paramObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof OpenID))
    {
      OpenID localOpenID = (OpenID)this.jdField_a_of_type_JavaLangObject;
      if (PublicAccountUtil.a(this.jdField_a_of_type_Mvi.jdField_a_of_type_AndroidAppActivity, localOpenID, this.jdField_a_of_type_Mvi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Mvi.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        PublicAccountUtil.b(this.jdField_a_of_type_Mvi.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Mvi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Mvi.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvj
 * JD-Core Version:    0.7.0.1
 */