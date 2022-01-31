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

class ove
  implements View.OnClickListener
{
  ove(ovb paramovb, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Ovb.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8());
    this.jdField_a_of_type_Ovb.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = olg.a(this.jdField_a_of_type_Ovb.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Ovb.a(), (ArticleInfo)this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      paramView.put("exptime", System.currentTimeMillis());
      paramView.put("proxy_bytes", this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData);
      paramView.put("operation_id", this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
      oli localoli = new oli(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localoli.e = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localoli.f = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localoli.g = paramView.toString();
      localoli.a = String.valueOf(this.jdField_a_of_type_Ovb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localoli.b = "0X8009A7B";
      localoli.c = "0X8009A7B";
      olg.a(localoli);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ove
 * JD-Core Version:    0.7.0.1
 */