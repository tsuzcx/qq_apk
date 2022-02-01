import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class pzf
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public pzf(Context paramContext, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a == null)) {}
    do
    {
      do
      {
        return;
        paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a;
      } while (ozs.a() != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long);
      QLog.d("OnPivacyClickListener", 2, "privacy type is  " + paramViewBase.jdField_a_of_type_Int + "| feedsid is " + paramViewBase.b);
    } while (paramViewBase.jdField_a_of_type_Int != 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("feeds_id", paramViewBase.b);
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, ReadInJoyPrivacyListFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzf
 * JD-Core Version:    0.7.0.1
 */