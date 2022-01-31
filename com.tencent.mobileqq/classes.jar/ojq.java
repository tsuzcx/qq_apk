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

class ojq
  implements View.OnClickListener
{
  ojq(ojp paramojp, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramView))
    {
      obz.a(this.jdField_a_of_type_Ojp.jdField_a_of_type_AndroidContentContext, paramView);
      paramView = nzv.a(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Ojp.a(), (ArticleInfo)this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      paramView.put("card_type", 8);
      nzx localnzx = new nzx(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localnzx.e = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localnzx.f = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localnzx.g = paramView.toString();
      localnzx.a = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localnzx.b = "0X8008E2F";
      localnzx.c = "0X8008E2F";
      nzv.a(localnzx);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_Ojp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      ogy.a().a(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojq
 * JD-Core Version:    0.7.0.1
 */