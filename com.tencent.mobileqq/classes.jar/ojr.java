import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

class ojr
  implements View.OnClickListener
{
  ojr(ojp paramojp, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment).a(paramView, this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ojp.a());
    paramView = nzv.a(this.jdField_a_of_type_Ojp.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Ojp.a(), (ArticleInfo)this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      paramView.put("card_type", 8);
      nzx localnzx = new nzx(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localnzx.e = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localnzx.f = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localnzx.g = paramView.toString();
      if (this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
        localnzx.a = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localnzx.b = "0X8009A78";
      localnzx.c = "0X8009A78";
      nzv.a(localnzx);
      paramView = new JSONObject();
      paramView.put("time", System.currentTimeMillis() / 1000L);
      paramView.put("channel_id", this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a());
      paramView.put("folder_status", obz.d);
      paramView.put("kandian_mode", obz.e());
      paramView.put("feeds_type", "1008");
      paramView.put("rowkey", rvf.a(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      ndn.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojr
 * JD-Core Version:    0.7.0.1
 */