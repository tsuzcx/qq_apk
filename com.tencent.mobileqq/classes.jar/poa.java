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

class poa
  implements View.OnClickListener
{
  poa(pnz parampnz, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      pay.a(this.jdField_a_of_type_Pnz.jdField_a_of_type_AndroidContentContext, (String)localObject);
      localObject = ozb.a(this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Pnz.a(), (ArticleInfo)this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    try
    {
      ((JSONObject)localObject).put("card_type", 8);
      ozd localozd = new ozd(this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localozd.e = String.valueOf(this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localozd.f = String.valueOf(this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localozd.g = ((JSONObject)localObject).toString();
      localozd.a = String.valueOf(this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localozd.b = "0X8008E2F";
      localozd.c = "0X8008E2F";
      ozb.a(localozd);
      ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1008);
      this.jdField_a_of_type_Pnz.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      pkm.a().a(this.jdField_a_of_type_Pnz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
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
 * Qualified Name:     poa
 * JD-Core Version:    0.7.0.1
 */