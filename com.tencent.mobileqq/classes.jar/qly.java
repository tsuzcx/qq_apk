import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.7;

public class qly
  implements View.OnClickListener
{
  public qly(MultiVideoNormalItemHolder.7 param7) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      paramView = new Intent(this.a.this$0.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
      VideoInfo localVideoInfo = this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localVideoInfo.jdField_a_of_type_Int == 6) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        paramView.putExtra("feedsType", localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      }
      paramView.putExtra("ARG_VIDEO_ARTICLE_ID", localVideoInfo.g);
      paramView.putExtra("arg_article_info", localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      paramView.putExtra("biu_src", 2);
      paramView.putExtra("arg_from_type", 8);
      paramView.putExtra("is_modified_biu", true);
      long l2 = 0L;
      long l1 = l2;
      if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        l1 = l2;
        if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo != null) {
          l1 = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.a;
        }
      }
      paramView.putExtra("modified_feeds_id", l1);
      paramView.putExtra("should_show_dialog", false);
      this.a.this$0.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      this.a.this$0.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
    this.a.a.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qly
 * JD-Core Version:    0.7.0.1
 */