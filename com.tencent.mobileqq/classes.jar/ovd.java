import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

class ovd
  implements View.OnClickListener
{
  ovd(ovb paramovb, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment).a(paramView, this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ovb.a());
    paramView = olg.a(this.jdField_a_of_type_Ovb.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Ovb.a(), (ArticleInfo)this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      paramView.put("card_type", 8);
      oli localoli = new oli(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localoli.e = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localoli.f = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localoli.g = paramView.toString();
      if (this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
        localoli.a = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localoli.b = "0X8009A78";
      localoli.c = "0X8009A78";
      olg.a(localoli);
      paramView = new JSONObject();
      paramView.put("time", System.currentTimeMillis() / 1000L);
      paramView.put("channel_id", this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a());
      paramView.put("folder_status", onk.d);
      paramView.put("kandian_mode", onk.e());
      paramView.put("feeds_type", "1008");
      paramView.put("rowkey", shx.a(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      noo.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovd
 * JD-Core Version:    0.7.0.1
 */