import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class qpn
  implements View.OnClickListener
{
  public qpn(ComponentHeaderNewSocial paramComponentHeaderNewSocial, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ozs.d);
      ((JSONObject)localObject2).put("feeds_source", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a));
      ((JSONObject)localObject2).put("tab_source", ozs.d());
      ((JSONObject)localObject2).put("kandian_mode", ozs.e());
      ((JSONObject)localObject2).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    ocd.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, "0X8007B63", "0X8007B63", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "", (String)localObject1, false);
    localObject1 = oyu.f + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.getContext(), (String)localObject1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpn
 * JD-Core Version:    0.7.0.1
 */