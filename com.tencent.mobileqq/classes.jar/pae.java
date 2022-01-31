import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

class pae
  implements View.OnClickListener
{
  pae(pac parampac, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment).a(paramView, this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pac.a());
    paramView = opn.a(this.jdField_a_of_type_Pac.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Pac.a(), (ArticleInfo)this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      paramView.put("card_type", 8);
      opp localopp = new opp(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localopp.e = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localopp.f = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localopp.g = paramView.toString();
      if (this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
        localopp.a = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localopp.b = "0X8009A78";
      localopp.c = "0X8009A78";
      opn.a(localopp);
      paramView = new JSONObject();
      paramView.put("time", System.currentTimeMillis() / 1000L);
      paramView.put("channel_id", this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a());
      paramView.put("folder_status", ors.d);
      paramView.put("kandian_mode", ors.e());
      paramView.put("feeds_type", "1008");
      paramView.put("rowkey", szp.a(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      nrt.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pae
 * JD-Core Version:    0.7.0.1
 */