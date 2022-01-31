import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class pij
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  public final String a;
  
  public pij(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "OnCommunityCapsuleClickListener";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.b;
      if (QLog.isColorLevel()) {
        QLog.d("OnCommunityCapsuleClickListener", 2, "business url is " + str);
      }
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_AndroidContentContext == null));
    onh.a(this.jdField_a_of_type_AndroidContentContext, str);
    nol.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
    nol.a(null, "", "0X8009BA6", "0X8009BA6", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "", "", false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pij
 * JD-Core Version:    0.7.0.1
 */