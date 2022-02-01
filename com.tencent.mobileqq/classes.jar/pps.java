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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class pps
  implements View.OnClickListener
{
  pps(ppp paramppp, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Ppp.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8());
    this.jdField_a_of_type_Ppp.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    localObject = pfe.a(this.jdField_a_of_type_Ppp.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Ppp.a(), (ArticleInfo)this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      ((JSONObject)localObject).put("exptime", System.currentTimeMillis());
      ((JSONObject)localObject).put("proxy_bytes", this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData);
      ((JSONObject)localObject).put("operation_id", this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
      pfg localpfg = new pfg(this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localpfg.e = String.valueOf(this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localpfg.f = String.valueOf(this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localpfg.g = ((JSONObject)localObject).toString();
      localpfg.a = String.valueOf(this.jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localpfg.b = "0X8009A7B";
      localpfg.c = "0X8009A7B";
      pfe.a(localpfg);
      label236:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label236;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pps
 * JD-Core Version:    0.7.0.1
 */