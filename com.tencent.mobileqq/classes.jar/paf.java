import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class paf
  implements View.OnClickListener
{
  paf(pac parampac, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Pac.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8());
    this.jdField_a_of_type_Pac.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = opn.a(this.jdField_a_of_type_Pac.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Pac.a(), (ArticleInfo)this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      paramView.put("exptime", System.currentTimeMillis());
      paramView.put("proxy_bytes", this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData);
      paramView.put("operation_id", this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
      opp localopp = new opp(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localopp.e = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localopp.f = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localopp.g = paramView.toString();
      localopp.a = String.valueOf(this.jdField_a_of_type_Pac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localopp.b = "0X8009A7B";
      localopp.c = "0X8009A7B";
      opn.a(localopp);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     paf
 * JD-Core Version:    0.7.0.1
 */