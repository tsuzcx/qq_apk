import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;

public class snm
  implements spf
{
  public snm(FastWebActivity paramFastWebActivity, int paramInt, BaseData paramBaseData) {}
  
  public BaseData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
  }
  
  public void a()
  {
    Object localObject = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, ((spe)localObject).jdField_a_of_type_Float, ((spe)localObject).jdField_a_of_type_Long);
      localObject = "bottomAd";
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.d) {
        break label123;
      }
      localObject = "innerAd";
    }
    for (;;)
    {
      tpx.a("REPORT_LINK", "on fast web ad expose report : type = " + (String)localObject + " title = " + ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).b);
      return;
      ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      break;
      label123:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData instanceof RecommendAdData)) {
        localObject = "recommendAd";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snm
 * JD-Core Version:    0.7.0.1
 */