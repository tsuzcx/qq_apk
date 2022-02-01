import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class spg
  implements Comparable<spg>
{
  public float a;
  public int a;
  public long a;
  public AdvertisementInfo a;
  public long b;
  
  public int a(spg paramspg)
  {
    if (this.jdField_a_of_type_Int < paramspg.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramspg.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((!(paramObject instanceof spg)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (((spg)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return false;
    }
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == ((spg)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo) && (this.jdField_a_of_type_Int == ((spg)paramObject).jdField_a_of_type_Int);
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
 * Qualified Name:     spg
 * JD-Core Version:    0.7.0.1
 */