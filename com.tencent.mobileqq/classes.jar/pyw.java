import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class pyw
  extends pzu
{
  public pyw(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  public static Intent a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    paramActivity = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramActivity.putExtra("arg_article_info", paramArticleInfo);
    paramActivity.putExtra("feedsType", paramArticleInfo.mFeedType);
    if (paramArticleInfo.mChannelID == 70L)
    {
      paramActivity.putExtra("biu_src", 9);
      paramActivity.putExtra("arg_from_type", 14);
    }
    for (;;)
    {
      if (pab.a(paramArticleInfo)) {
        paramActivity.putExtra("arg_type", 4);
      }
      return paramActivity;
      paramActivity.putExtra("biu_src", 1);
      paramActivity.putExtra("arg_from_type", 1);
    }
  }
  
  protected int a()
  {
    return 25;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (ubg.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009361";; str1 = "0X8007EE4")
    {
      str2 = ozs.a(paramArticleInfo);
      if ((!sel.i(paramArticleInfo)) && (!sel.g(paramArticleInfo)) && (!sel.j(paramArticleInfo)) && (!sel.k(paramArticleInfo))) {
        break;
      }
      if (!sel.o(paramArticleInfo)) {
        ocd.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!ozs.k(paramArticleInfo)) && (!ozs.l(paramArticleInfo))) {
        sel.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    ocd.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    boolean bool = true;
    QLog.d("OnBiuClickListener", 1, "click biu");
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b())) {
      QQToast.a(BaseApplicationImpl.sApplication, 0, 2131717221, 0).a();
    }
    while ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    paramViewBase = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (omu.a() == 1) {}
    for (;;)
    {
      localIntent.putExtra("fast_biu_type", bool);
      paramViewBase.startActivity(localIntent);
      paramViewBase.overridePendingTransition(0, 0);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyw
 * JD-Core Version:    0.7.0.1
 */