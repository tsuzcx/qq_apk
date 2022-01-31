import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class pjf
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bfpc jdField_a_of_type_Bfpc;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private qds jdField_a_of_type_Qds;
  
  public pjf(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramArticleInfo);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)) {
      this.jdField_a_of_type_Qds = ((qds)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = onh.a();
    if (this.jdField_a_of_type_Qds != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "before request0x978 articleInfo articleID = ，isfollow = " + paramBoolean + " businessId = " + this.jdField_a_of_type_Qds.a);
      }
      if (paramBoolean) {
        osg.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qds.a), true, new pji(this, paramBoolean), 3);
      }
    }
    else
    {
      return;
    }
    osg.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qds.a), false, new pjj(this, paramBoolean), 3);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Qds == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Qds.c != 1) {
        break;
      }
    } while (onh.v(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    a();
    return;
    a(true);
    if (!onh.v(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      str1 = onh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      String str2 = onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, bbfj.h(this.jdField_a_of_type_AndroidContentContext), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
      nol.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
      ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (shu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (String str1 = "0X800941D";; str1 = "0X80080EC")
    {
      ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str1, str1, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      osg.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      break;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null));
    this.jdField_a_of_type_Bfpc.a(2131695617, 3);
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.setOnDismissListener(new pjg(this));
    this.jdField_a_of_type_Bfpc.a(new pjh(this));
    if (!this.jdField_a_of_type_Bfpc.isShowing()) {
      this.jdField_a_of_type_Bfpc.show();
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pjf
 * JD-Core Version:    0.7.0.1
 */