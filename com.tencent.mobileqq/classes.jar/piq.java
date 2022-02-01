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

class piq
  implements View.OnClickListener
{
  piq(pin parampin, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Pin.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8());
    this.jdField_a_of_type_Pin.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    localObject = oxw.a(this.jdField_a_of_type_Pin.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_Pin.a(), (ArticleInfo)this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      ((JSONObject)localObject).put("exptime", System.currentTimeMillis());
      ((JSONObject)localObject).put("proxy_bytes", this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData);
      ((JSONObject)localObject).put("operation_id", this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
      oxy localoxy = new oxy(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localoxy.e = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localoxy.f = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localoxy.g = ((JSONObject)localObject).toString();
      localoxy.a = String.valueOf(this.jdField_a_of_type_Pin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.publishUin);
      localoxy.b = "0X8009A7B";
      localoxy.c = "0X8009A7B";
      oxw.a(localoxy);
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
 * Qualified Name:     piq
 * JD-Core Version:    0.7.0.1
 */