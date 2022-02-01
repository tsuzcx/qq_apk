import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class sni
  extends suv
{
  sni(smg paramsmg) {}
  
  private void b(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null) {}
    try
    {
      smg.a(this.a).b(smg.b(this.a));
      paramString = new Intent(smg.a(this.a), ReadInJoyDeliverBiuActivity.class);
      if ((smg.a(this.a).jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        paramString.putExtra("feedsType", smg.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      }
      paramString.putExtra("ARG_VIDEO_ARTICLE_ID", smg.a(this.a).g);
      paramString.putExtra("biu_src", 2);
      paramString.putExtra("arg_from_type", 8);
      paramString.putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      smg.a(this.a).startActivityForResult(paramString, 102);
      smg.a(this.a).overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFeedsShareController", 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
      }
      smg.a(this.a).b(false);
    }
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    qgx.a().a(smg.a(this.a), 2, new snj(this, paramInt, paramVideoInfo, paramString, paramActionSheetItem));
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sni
 * JD-Core Version:    0.7.0.1
 */