import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class qbw
  extends ClickableSpan
  implements rvl
{
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  qbs jdField_a_of_type_Qbs;
  boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public qbw(ArticleInfo paramArticleInfo, int paramInt, Context paramContext, Resources paramResources, qbs paramqbs)
  {
    this.jdField_a_of_type_Int = 16;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.b = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_Qbs = paramqbs;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      int j = -1;
      int i = j;
      if (this.jdField_a_of_type_Qbs != null)
      {
        i = j;
        if (this.jdField_a_of_type_Qbs.a != null) {
          i = this.jdField_a_of_type_Qbs.a.e();
        }
      }
      rqj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
      return;
    }
    QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    sds.b("fast_web_show_light_house_1");
    owy.a().a().a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    a(paramArticleInfo, null);
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ors.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramArticleInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidTextTextPaint != null) {
      updateDrawState(this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl))
    {
      if (!ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break label157;
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    for (;;)
    {
      a();
      if ((ors.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ors.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        nrt.a(null, ors.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8008A62", "0X8008A62", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Integer.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), false);
      }
      return;
      label157:
      ors.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-14132075);
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.b;; i = 16777215)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(aekt.a(2, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentResResources));
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qbw
 * JD-Core Version:    0.7.0.1
 */