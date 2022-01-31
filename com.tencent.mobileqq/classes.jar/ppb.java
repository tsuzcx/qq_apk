import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class ppb
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public ppb(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i = 1;
    Object localObject1 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("algorithm_id", paramArticleInfo.mAlgorithmID);
        ((JSONObject)localObject2).put("folder_status", ors.d);
        ((JSONObject)localObject2).put("feeds_type", paramInt);
        ((JSONObject)localObject2).put("time", System.currentTimeMillis());
        ((JSONObject)localObject2).put("channel_id", paramArticleInfo.mChannelID);
        if (!NetworkState.isWifiConn()) {
          continue;
        }
        paramInt = 2;
        ((JSONObject)localObject2).put("network_type", paramInt);
        ((JSONObject)localObject2).put("feeds_source", ors.d(paramArticleInfo));
        ((JSONObject)localObject2).put("imei", ors.f());
        ((JSONObject)localObject2).put("imsi", ors.g());
        if (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)) {
          ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
        }
        ((JSONObject)localObject2).put("comment", paramArticleInfo.mSocialFeedInfo.d);
        if (bjxj.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          continue;
        }
        paramInt = i;
        ((JSONObject)localObject2).put("reddot_style", paramInt);
        ((JSONObject)localObject2).put("tab_source", ors.d());
        ((JSONObject)localObject2).put("kandian_mode", "" + ors.e());
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        String str2;
        localJSONException.printStackTrace();
        continue;
        String str1 = paramArticleInfo.mArticleID + "";
        continue;
      }
      if ((!rqj.b(paramArticleInfo)) && (!rqj.i(paramArticleInfo)) && (!rqj.j(paramArticleInfo)) && (!rqj.k(paramArticleInfo))) {
        continue;
      }
      localObject2 = "0";
      str2 = "0X8009492";
      if (paramArticleInfo.mChannelID == 70L) {
        str2 = "0X8009488";
      }
      nrt.a(null, ors.d(paramArticleInfo), str2, str2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), (String)localObject2, "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      return;
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    owy.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mExtraBiuBriefInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppb
 * JD-Core Version:    0.7.0.1
 */