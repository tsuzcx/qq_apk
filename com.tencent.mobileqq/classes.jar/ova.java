import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

class ova
  implements View.OnClickListener
{
  ova(ouy paramouy, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment).a(paramView, this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ouy.a());
    paramView = old.a(this.jdField_a_of_type_Ouy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Ouy.a(), (ArticleInfo)this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      paramView.put("card_type", 8);
      olf localolf = new olf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localolf.e = String.valueOf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localolf.f = String.valueOf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localolf.g = paramView.toString();
      if (this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
        localolf.a = String.valueOf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localolf.b = "0X8009A78";
      localolf.c = "0X8009A78";
      old.a(localolf);
      paramView = new JSONObject();
      paramView.put("time", System.currentTimeMillis() / 1000L);
      paramView.put("channel_id", this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a());
      paramView.put("folder_status", onh.d);
      paramView.put("kandian_mode", onh.e());
      paramView.put("feeds_type", "1008");
      paramView.put("rowkey", shu.a(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      nol.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ova
 * JD-Core Version:    0.7.0.1
 */