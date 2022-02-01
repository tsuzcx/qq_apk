import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class syh
  implements Comparable<syh>
{
  public float a;
  public int a;
  public long a;
  public AdvertisementInfo a;
  public long b;
  
  public int a(syh paramsyh)
  {
    if (this.jdField_a_of_type_Int < paramsyh.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramsyh.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((!(paramObject instanceof syh)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (((syh)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return false;
    }
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == ((syh)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo) && (this.jdField_a_of_type_Int == ((syh)paramObject).jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    int i = 17;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.hashCode() + 527;
    }
    return i * 31 + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syh
 * JD-Core Version:    0.7.0.1
 */