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
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class ozx
  implements View.OnClickListener
{
  ozx(ozw paramozw, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    Object localObject;
    if (TextUtils.isEmpty(paramView))
    {
      localObject = this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleContentUrl;
      if (!TextUtils.isEmpty(paramView))
      {
        paramView = new Intent(this.jdField_a_of_type_Ozw.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", (String)localObject);
        this.jdField_a_of_type_Ozw.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ozw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ReadInJoyPicWaterFallFragment.c);
      owy.a().a(this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
      paramView = opn.a(this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 16, this.jdField_a_of_type_Ozw.a(), (ArticleInfo)this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      try
      {
        paramView.put("card_type", 12);
        localObject = new opp(this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        ((opp)localObject).e = String.valueOf(this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
        ((opp)localObject).f = String.valueOf(this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
        ((opp)localObject).g = paramView.toString();
        if (this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
          ((opp)localObject).a = String.valueOf(this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
        }
        ((opp)localObject).b = "0X8008E2F";
        ((opp)localObject).c = "0X8008E2F";
        opn.a((opp)localObject);
        ReadInJoyPicWaterFallFragment.a((ArticleInfo)this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 1009);
        return;
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
      localObject = new Intent(this.jdField_a_of_type_Ozw.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Ozw.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ozx
 * JD-Core Version:    0.7.0.1
 */