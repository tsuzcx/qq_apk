import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class pad
  implements View.OnClickListener
{
  pad(pac parampac, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramView))
    {
      ors.a(this.jdField_a_of_type_Pac.jdField_a_of_type_AndroidContentContext, paramView);
      paramView = opn.a(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Pac.a(), (ArticleInfo)this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      paramView.put("card_type", 8);
      opp localopp = new opp(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localopp.e = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localopp.f = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localopp.g = paramView.toString();
      localopp.a = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localopp.b = "0X8008E2F";
      localopp.c = "0X8008E2F";
      opn.a(localopp);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_Pac.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      owy.a().a(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
      return;
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pad
 * JD-Core Version:    0.7.0.1
 */