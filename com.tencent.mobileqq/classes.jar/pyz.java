import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class pyz
  implements View.OnClickListener
{
  pyz(pyx parampyx, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment).a(paramView, this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pyx.a());
    JSONObject localJSONObject = pih.a(this.jdField_a_of_type_Pyx.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Pyx.a(), (ArticleInfo)this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      pij localpij = new pij(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localpij.e = String.valueOf(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localpij.f = String.valueOf(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localpij.g = localJSONObject.toString();
      if (this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
        localpij.a = String.valueOf(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localpij.b = "0X8009A78";
      localpij.c = "0X8009A78";
      pih.a(localpij);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a());
      localJSONObject.put("folder_status", prp.a);
      localJSONObject.put("kandian_mode", pqu.a());
      localJSONObject.put("feeds_type", "1008");
      localJSONObject.put("rowkey", uvs.a(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      olh.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
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
 * Qualified Name:     pyz
 * JD-Core Version:    0.7.0.1
 */