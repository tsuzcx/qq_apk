import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class plf
  implements View.OnClickListener
{
  public plf(ComponentHeaderNewSocial paramComponentHeaderNewSocial, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", obz.d);
      ((JSONObject)localObject).put("feeds_source", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a));
      ((JSONObject)localObject).put("tab_source", obz.d());
      ((JSONObject)localObject).put("kandian_mode", obz.e());
      ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localObject = ((JSONObject)localObject).toString();
      paramView = (View)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    ndn.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, "0X8007B63", "0X8007B63", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "", paramView, false);
    paramView = obb.f + String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
    obz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.getContext(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plf
 * JD-Core Version:    0.7.0.1
 */