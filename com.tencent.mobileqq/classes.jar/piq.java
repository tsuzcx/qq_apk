import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class piq
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public piq(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    noo.a(null, null, "0X80097D7", "0X80097D7", 0, 0, "", "", "", "", false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    String str = "";
    paramViewBase = str;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      paramViewBase = str;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        paramViewBase = str;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
        {
          paramViewBase = str;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.f != null)
          {
            paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.f;
            onk.e(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
          }
        }
      }
    }
    QLog.d("OnFriendsBiuClickListener", 1, "jump channel,  context:" + this.jdField_a_of_type_AndroidContentContext + "  url:" + paramViewBase);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     piq
 * JD-Core Version:    0.7.0.1
 */