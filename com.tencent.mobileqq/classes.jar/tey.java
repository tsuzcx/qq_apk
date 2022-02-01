import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;

public class tey
  implements tgo
{
  public tey(FastWebActivity paramFastWebActivity, int paramInt, BaseData paramBaseData) {}
  
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
    Object localObject = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, ((tgn)localObject).jdField_a_of_type_Float, ((tgn)localObject).jdField_a_of_type_Long, false);
      localObject = "bottomAd";
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.d) {
        break label125;
      }
      localObject = "innerAd";
    }
    for (;;)
    {
      ukq.a("REPORT_LINK", "onShow50percentOneSecond:on fast web ad expose report : type = " + (String)localObject + " title = " + ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).b);
      return;
      ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, false);
      break;
      label125:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData instanceof RecommendAdData)) {
        localObject = "recommendAd";
      }
    }
  }
  
  public void b()
  {
    Object localObject = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, ((tgn)localObject).jdField_a_of_type_Float, ((tgn)localObject).jdField_a_of_type_Long, true);
      localObject = "bottomAd";
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.d) {
        break label125;
      }
      localObject = "innerAd";
    }
    for (;;)
    {
      ukq.a("REPORT_LINK", "onShow1percent:on fast web ad expose report : type = " + (String)localObject + " title = " + ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).b);
      return;
      ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, true);
      break;
      label125:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData instanceof RecommendAdData)) {
        localObject = "recommendAd";
      }
    }
  }
  
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
 * Qualified Name:     tey
 * JD-Core Version:    0.7.0.1
 */