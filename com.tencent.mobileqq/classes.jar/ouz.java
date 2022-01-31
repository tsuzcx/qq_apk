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

class ouz
  implements View.OnClickListener
{
  ouz(ouy paramouy, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramView))
    {
      onh.a(this.jdField_a_of_type_Ouy.jdField_a_of_type_AndroidContentContext, paramView);
      paramView = old.a(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Ouy.a(), (ArticleInfo)this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      paramView.put("card_type", 8);
      olf localolf = new olf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localolf.e = String.valueOf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localolf.f = String.valueOf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localolf.g = paramView.toString();
      localolf.a = String.valueOf(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localolf.b = "0X8008E2F";
      localolf.c = "0X8008E2F";
      old.a(localolf);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_Ouy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      osg.a().a(this.jdField_a_of_type_Ouy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
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
 * Qualified Name:     ouz
 * JD-Core Version:    0.7.0.1
 */