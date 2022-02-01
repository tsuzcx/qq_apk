import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class qrs
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public qrs(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData))) {}
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData);
      QLog.d("OnSuperTopicClickListener", 2, new Object[] { "mArticleInfo.proteusItemsData = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData });
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("id_super_topic".equals(str))
        {
          localObject = ((JSONObject)localObject).getJSONObject(str).getString("super_topic_jump_url");
          QLog.d("OnSuperTopicClickListener", 2, new Object[] { "jumpToSuperTopic, jumpUrl = ", localObject });
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            pqx.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, null);
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("OnSuperTopicClickListener", 2, "jumpToSuperTopic", localJSONException);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a;
    if (paramArticleInfo != null)
    {
      paramArticleInfo = paramArticleInfo.d;
      pqx.b(paramContext, paramArticleInfo);
      QLog.i("OnSuperTopicClickListener", 2, "jumpToWendaRefer jumpUrl +" + paramArticleInfo);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((pqw.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (pqw.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_AndroidContentContext);
      olh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    a();
    olh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrs
 * JD-Core Version:    0.7.0.1
 */