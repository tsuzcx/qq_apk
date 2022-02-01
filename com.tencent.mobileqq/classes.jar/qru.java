import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class qru
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public qru(ArticleInfo paramArticleInfo, Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    bheh localbheh = bhey.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    if (localbheh != null) {
      localbheh.a();
    }
  }
  
  private void a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID + "");
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("feeds_type", pqw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localJSONObject.put("channel_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      localJSONObject.put("feeds_source", pqw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localJSONObject.put("imei", pkh.b());
      localJSONObject.put("imsi", pkh.c());
      localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localJSONObject.put("comment", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("topic_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId);
      localJSONObject.put("kandian_mode", "" + pqu.a());
      localJSONObject.put("mark_type", paramString);
      olh.a(null, String.valueOf(ppe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int)), "0X80097CB", "0X80097CB", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("OnTopicDeliverClickListener", 2, "report error:" + paramString.toString());
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru != null) && ((this.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_Int == 73)))
      {
        a("4");
        return;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    a();
    try
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData)) {
        break label130;
      }
      paramViewBase = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData).optString("biz_type", "");
      boolean bool = TextUtils.isEmpty(paramViewBase);
      if (bool) {
        break label130;
      }
    }
    catch (Exception paramViewBase)
    {
      for (;;)
      {
        QLog.d("OnTopicDeliverClickListener", 2, "OnTopicDeliverClickListener", paramViewBase);
        paramViewBase = "1";
      }
    }
    a(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qru
 * JD-Core Version:    0.7.0.1
 */