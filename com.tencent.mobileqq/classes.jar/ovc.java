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

class ovc
  implements View.OnClickListener
{
  ovc(ovb paramovb, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramView))
    {
      onk.a(this.jdField_a_of_type_Ovb.jdField_a_of_type_AndroidContentContext, paramView);
      paramView = olg.a(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Ovb.a(), (ArticleInfo)this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      paramView.put("card_type", 8);
      oli localoli = new oli(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localoli.e = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localoli.f = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localoli.g = paramView.toString();
      localoli.a = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localoli.b = "0X8008E2F";
      localoli.c = "0X8008E2F";
      olg.a(localoli);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_Ovb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      osj.a().a(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
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
 * Qualified Name:     ovc
 * JD-Core Version:    0.7.0.1
 */