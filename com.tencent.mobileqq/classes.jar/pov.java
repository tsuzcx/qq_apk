import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import org.json.JSONObject;

public class pov
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public pov(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private long a()
  {
    long l2 = 0L;
    long l1;
    if ((rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (this.jdField_a_of_type_Int == 77) || (this.jdField_a_of_type_Int == 78))
    {
      l1 = l2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  try
                  {
                    l1 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID);
                    return l1;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    localNumberFormatException.printStackTrace();
                    return 0L;
                  }
                  if ((!rqj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_Int != 72) && (this.jdField_a_of_type_Int != 74)) {
                    break;
                  }
                  l1 = l2;
                } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null);
                l1 = l2;
              } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null);
              return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long;
              if (this.jdField_a_of_type_Int != 76) {
                break;
              }
              l1 = l2;
            } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null);
            l1 = l2;
          } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme == null);
          return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
          if ((rqj.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (this.jdField_a_of_type_Int == 73)) {
            break;
          }
          l1 = l2;
        } while (this.jdField_a_of_type_Int != 75);
        l1 = l2;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null);
      l1 = l2;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme == null);
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
  }
  
  private void a()
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID + "");
        localJSONObject.put("folder_status", ors.d);
        localJSONObject.put("feeds_type", ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
        localJSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
        localJSONObject.put("channel_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
        if (NetworkState.isWifiConn())
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("feeds_source", ors.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
          localJSONObject.put("imei", ors.f());
          localJSONObject.put("imsi", ors.g());
          localJSONObject.put("idfa", "");
          localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          localJSONObject.put("comment", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString);
          if (bjxj.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            continue;
          }
          i = j;
          localJSONObject.put("reddot_style", i);
          localJSONObject.put("tab_source", "" + ors.d());
          localJSONObject.put("kandian_mode", "" + ors.e());
          nrt.a(null, String.valueOf(a()), "0X800953E", "0X800953E", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), localJSONObject.toString(), false);
          return;
        }
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("OnFriendsBiuClickListener", 2, "report error:" + localException.toString());
      }
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiBiuSameContentList;
    if ((paramViewBase != null) && (!paramViewBase.isEmpty()))
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("articleID", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID));
      localBundle.putString("stategyID", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId));
      localBundle.putString("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID + "");
      localBundle.putString("feeds_source", ors.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localBundle.putString("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localBundle.putString("channel_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      localIntent.putParcelableArrayListExtra("friends_biu_list", paramViewBase);
      localIntent.putExtras(localBundle);
      adky.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, ReadInjoyFriendsBiuComponentFragment.class);
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d("OnFriendsBiuClickListener", 2, "onClick:" + paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pov
 * JD-Core Version:    0.7.0.1
 */