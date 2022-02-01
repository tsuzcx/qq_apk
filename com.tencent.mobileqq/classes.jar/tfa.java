import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public class tfa
  implements tgo
{
  public tfa(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
  public int a()
  {
    return odz.a().a();
  }
  
  public BaseData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
  }
  
  public void a()
  {
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
  }
  
  public void b() {}
  
  public void c()
  {
    if (AdData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
    {
      AdData localAdData = (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
      if (localAdData.a != null) {
        odz.a().a(Long.valueOf(localAdData.a.mAdAid));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tfa
 * JD-Core Version:    0.7.0.1
 */