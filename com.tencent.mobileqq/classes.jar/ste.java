import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class ste
  implements Comparable<ste>
{
  public float a;
  public int a;
  public long a;
  public AdvertisementInfo a;
  
  public int a(ste paramste)
  {
    if (this.jdField_a_of_type_Int < paramste.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramste.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((!(paramObject instanceof ste)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (((ste)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return false;
    }
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == ((ste)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo) && (this.jdField_a_of_type_Int == ((ste)paramObject).jdField_a_of_type_Int);
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
 * Qualified Name:     ste
 * JD-Core Version:    0.7.0.1
 */