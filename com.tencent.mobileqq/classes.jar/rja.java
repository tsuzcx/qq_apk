import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class rja
  implements View.OnClickListener
{
  public rja(ComponentPolymericPullAnimatorView paramComponentPolymericPullAnimatorView, ArticleInfo paramArticleInfo, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    pqx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericPullAnimatorView.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.d);
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId + "";
    if (pqw.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (String str1 = "1";; str1 = "2")
    {
      olh.a(null, "CliOper", "", "", "0X800982B", "0X800982B", 0, 0, str2, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId + "", this.jdField_a_of_type_OrgJsonJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rja
 * JD-Core Version:    0.7.0.1
 */