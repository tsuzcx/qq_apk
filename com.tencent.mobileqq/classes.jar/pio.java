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

class pio
  implements View.OnClickListener
{
  pio(pin parampin, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ozs.a(this.jdField_a_of_type_Pin.jdField_a_of_type_AndroidContentContext, (String)localObject);
      localObject = oxw.a(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Pin.a(), (ArticleInfo)this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      ((JSONObject)localObject).put("card_type", 8);
      oxy localoxy = new oxy(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localoxy.e = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localoxy.f = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localoxy.g = ((JSONObject)localObject).toString();
      localoxy.a = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localoxy.b = "0X8008E2F";
      localoxy.c = "0X8008E2F";
      oxw.a(localoxy);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_Pin.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      pfa.a().a(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
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
 * Qualified Name:     pio
 * JD-Core Version:    0.7.0.1
 */