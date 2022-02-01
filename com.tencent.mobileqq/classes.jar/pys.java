import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class pys
  implements View.OnClickListener
{
  pys(pyr parampyr, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleContentUrl;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new Intent(this.jdField_a_of_type_Pyr.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        this.jdField_a_of_type_Pyr.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Pyr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      pvj.a().a(this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
      localObject1 = pih.a(this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Pyr.a(), (ArticleInfo)this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      try
      {
        ((JSONObject)localObject1).put("card_type", 12);
        localObject2 = new pij(this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        ((pij)localObject2).e = String.valueOf(this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
        ((pij)localObject2).f = String.valueOf(this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
        ((pij)localObject2).g = ((JSONObject)localObject1).toString();
        if (this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
          ((pij)localObject2).a = String.valueOf(this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
        }
        ((pij)localObject2).b = "0X8008E2F";
        ((pij)localObject2).c = "0X8008E2F";
        pih.a((pij)localObject2);
        ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1009);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject2 = new Intent(this.jdField_a_of_type_Pyr.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_Pyr.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pys
 * JD-Core Version:    0.7.0.1
 */