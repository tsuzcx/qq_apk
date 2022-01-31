import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class pit
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public pit(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private String a()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      localObject1 = "";
      return localObject1;
    }
    Object localObject3 = "";
    long l2 = 0L;
    long l1;
    if ((ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (this.jdField_a_of_type_Int == 77) || (this.jdField_a_of_type_Int == 78))
    {
      l1 = l2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID);
        localObject1 = omj.k + bbco.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        localObject3 = localObject1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID))) {
          break label587;
        }
        try
        {
          l2 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          Object localObject2;
          localNumberFormatException2.printStackTrace();
          continue;
        }
        localObject3 = omj.k + bbco.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        this.jdField_a_of_type_Long = l2;
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OnSocialAvatarClickListener", 2, "uin = " + l2 + " url =  articleID = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID);
        return localObject3;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
        l1 = l2;
        continue;
      }
      if ((ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (this.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_Int == 74))
      {
        l1 = l2;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          localObject2 = localObject3;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null)
          {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
            localObject2 = omj.g + bbco.encodeToString(String.valueOf(l1).getBytes(), 2);
          }
        }
      }
      else if (this.jdField_a_of_type_Int == 76)
      {
        l1 = l2;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          localObject2 = localObject3;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null)
          {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
            localObject2 = omj.g + bbco.encodeToString(String.valueOf(l1).getBytes(), 2);
          }
        }
      }
      else if ((!ram.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_Int != 73))
      {
        l1 = l2;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Int != 75) {}
      }
      else
      {
        l1 = l2;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          localObject2 = localObject3;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null)
          {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
            localObject2 = omj.g + bbco.encodeToString(String.valueOf(l1).getBytes(), 2);
            continue;
            label587:
            if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null))
            {
              l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
              localObject3 = omj.g + bbco.encodeToString(String.valueOf(l2).getBytes(), 2);
            }
            else
            {
              l2 = l1;
              localObject3 = localNumberFormatException2;
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
              {
                l2 = l1;
                localObject3 = localNumberFormatException2;
                if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null)
                {
                  l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
                  localObject3 = omj.g + bbco.encodeToString(String.valueOf(l2).getBytes(), 2);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localArticleInfo == null) {
      return;
    }
    Object localObject = "1";
    String str;
    if (ram.a(localArticleInfo))
    {
      localObject = "3";
      str = onh.a((String)localObject, localArticleInfo, this.jdField_a_of_type_Long);
      if (!shu.a(localArticleInfo.mChannelID)) {
        break label190;
      }
      localObject = "0X800935C";
      label47:
      nol.a(null, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, (String)localObject, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str, false);
    }
    for (;;)
    {
      try
      {
        localObject = onh.a();
        ((JSONObject)localObject).put("feeds_source", paramString);
        ((JSONObject)localObject).put("kandian_mode", onh.e());
        str = onh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (!shu.a(localArticleInfo.mChannelID)) {
          break label196;
        }
        paramString = "0X8009357";
        nol.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (!ram.a(localArticleInfo)) {
        break;
      }
      localObject = "4";
      break;
      label190:
      localObject = "0X8007BA3";
      break label47;
      label196:
      paramString = "0X800744D";
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = a();
    if (!TextUtils.isEmpty(paramViewBase))
    {
      onh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      onh.a(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
      a(onh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pit
 * JD-Core Version:    0.7.0.1
 */