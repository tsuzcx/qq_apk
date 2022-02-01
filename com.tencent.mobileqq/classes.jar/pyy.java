import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class pyy
  implements View.OnClickListener
{
  pyy(pyx parampyx, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      pkh.a(this.jdField_a_of_type_Pyx.jdField_a_of_type_AndroidContentContext, (String)localObject);
      localObject = pih.a(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Pyx.a(), (ArticleInfo)this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      ((JSONObject)localObject).put("card_type", 8);
      pij localpij = new pij(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localpij.e = String.valueOf(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localpij.f = String.valueOf(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localpij.g = ((JSONObject)localObject).toString();
      localpij.a = String.valueOf(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localpij.b = "0X8008E2F";
      localpij.c = "0X8008E2F";
      pih.a(localpij);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_Pyx.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      pvj.a().a(this.jdField_a_of_type_Pyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyy
 * JD-Core Version:    0.7.0.1
 */