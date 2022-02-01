import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class pyy
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public pyy(ArticleInfo paramArticleInfo, Context paramContext)
  {
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
    ozs.a(this.jdField_a_of_type_AndroidContentContext, str);
    ocd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
    ocd.a(null, "", "0X8009BA6", "0X8009BA6", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "", "", false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyy
 * JD-Core Version:    0.7.0.1
 */