import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ppq
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bhpy jdField_a_of_type_Bhpy;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private qno jdField_a_of_type_Qno;
  
  public ppq(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramArticleInfo);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)) {
      this.jdField_a_of_type_Qno = ((qno)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = ors.a();
    if (this.jdField_a_of_type_Qno != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "before request0x978 articleInfo articleID = ，isfollow = " + paramBoolean + " businessId = " + this.jdField_a_of_type_Qno.a);
      }
      if (paramBoolean) {
        owy.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qno.a), true, new ppt(this, paramBoolean), 3);
      }
    }
    else
    {
      return;
    }
    owy.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qno.a), false, new ppu(this, paramBoolean), 3);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Qno == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Qno.c != 1) {
        break;
      }
    } while (ors.v(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    a();
    return;
    a(true);
    if (!ors.v(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      str1 = ors.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      String str2 = ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, bdee.h(this.jdField_a_of_type_AndroidContentContext), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
      nrt.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
      rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (szp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (String str1 = "0X800941D";; str1 = "0X80080EC")
    {
      rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str1, str1, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      owy.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      break;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null));
    this.jdField_a_of_type_Bhpy.a(2131695775, 3);
    this.jdField_a_of_type_Bhpy.c(2131690648);
    this.jdField_a_of_type_Bhpy.setOnDismissListener(new ppr(this));
    this.jdField_a_of_type_Bhpy.a(new pps(this));
    if (!this.jdField_a_of_type_Bhpy.isShowing()) {
      this.jdField_a_of_type_Bhpy.show();
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppq
 * JD-Core Version:    0.7.0.1
 */