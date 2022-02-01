import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class pip
  implements View.OnClickListener
{
  pip(pin parampin, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment).a(paramView, this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pin.a());
    JSONObject localJSONObject = oxw.a(this.jdField_a_of_type_Pin.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Pin.a(), (ArticleInfo)this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      oxy localoxy = new oxy(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localoxy.e = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localoxy.f = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localoxy.g = localJSONObject.toString();
      if (this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
        localoxy.a = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localoxy.b = "0X8009A78";
      localoxy.c = "0X8009A78";
      oxw.a(localoxy);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a());
      localJSONObject.put("folder_status", ozs.d);
      localJSONObject.put("kandian_mode", ozs.e());
      localJSONObject.put("feeds_type", "1008");
      localJSONObject.put("rowkey", ubg.a(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      ocd.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
    }
    catch (Exception localException)
    {
      label296:
      break label296;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pip
 * JD-Core Version:    0.7.0.1
 */