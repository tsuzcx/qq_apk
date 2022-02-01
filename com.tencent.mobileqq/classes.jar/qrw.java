import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class qrw
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bkzi jdField_a_of_type_Bkzi;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private rsj jdField_a_of_type_Rsj;
  
  public qrw(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramArticleInfo);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)) {
      this.jdField_a_of_type_Rsj = ((rsj)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = pkh.a();
    if (this.jdField_a_of_type_Rsj != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "before request0x978 articleInfo articleID = ，isfollow = " + paramBoolean + " businessId = " + this.jdField_a_of_type_Rsj.a);
      }
      if (paramBoolean) {
        pvj.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Rsj.a), true, "", new qrz(this, paramBoolean), 3);
      }
    }
    else
    {
      return;
    }
    pvj.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Rsj.a), false, "", new qsa(this, paramBoolean), 3);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Rsj == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Rsj.c != 1) {
        break;
      }
    } while (pqw.u(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    a();
    return;
    a(true);
    if (!pqw.u(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      str1 = pqw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      String str2 = pqf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, pqw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
      olh.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
      pqb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (uvs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (String str1 = "0X800941D";; str1 = "0X80080EC")
    {
      pqb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str1, str1, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      pvj.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      break;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null));
    this.jdField_a_of_type_Bkzi.a(2131695029, 3);
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.setOnDismissListener(new qrx(this));
    this.jdField_a_of_type_Bkzi.a(new qry(this));
    if (!this.jdField_a_of_type_Bkzi.isShowing()) {
      this.jdField_a_of_type_Bkzi.show();
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrw
 * JD-Core Version:    0.7.0.1
 */