import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeTopicMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import org.json.JSONException;
import org.json.JSONObject;

public class lyd
  implements View.OnClickListener
{
  public lyd(FeedItemCellTypeTopicMulti paramFeedItemCellTypeTopicMulti, ArticleInfo paramArticleInfo, TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCellTypeTopicMulti.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b.b);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", ReadInJoyUtils.d);
      paramView.put("kandian_mode", "" + ReadInJoyUtils.e());
      paramView.put("tab_source", "" + ReadInJoyUtils.d());
      PublicAccountReportUtils.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyd
 * JD-Core Version:    0.7.0.1
 */