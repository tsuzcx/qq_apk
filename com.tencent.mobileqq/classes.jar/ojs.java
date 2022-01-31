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

class ojs
  implements View.OnClickListener
{
  ojs(ojp paramojp, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Ojp.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8());
    this.jdField_a_of_type_Ojp.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = nzv.a(this.jdField_a_of_type_Ojp.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Ojp.a(), (ArticleInfo)this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      paramView.put("exptime", System.currentTimeMillis());
      paramView.put("proxy_bytes", this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData);
      paramView.put("operation_id", this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
      nzx localnzx = new nzx(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localnzx.e = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localnzx.f = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localnzx.g = paramView.toString();
      localnzx.a = String.valueOf(this.jdField_a_of_type_Ojp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localnzx.b = "0X8009A7B";
      localnzx.c = "0X8009A7B";
      nzv.a(localnzx);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojs
 * JD-Core Version:    0.7.0.1
 */