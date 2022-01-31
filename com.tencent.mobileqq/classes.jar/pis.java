import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class pis
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ram jdField_a_of_type_Ram;
  
  public pis(ArticleInfo paramArticleInfo, Context paramContext, ram paramram)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ram = paramram;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    label210:
    do
    {
      return;
      QLog.d("OnReadArticleClickListener", 2, "jumpToArticle. ");
      int i = ram.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if ((35 == i) || (34 == i) || (85 == i))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl))
        {
          if (!onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
            break label210;
          }
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        }
        for (;;)
        {
          b();
          if ((onh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (onh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            nol.a(null, onh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8008A62", "0X8008A62", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Integer.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), false);
          }
          c();
          return;
          onh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
        }
      }
      if (onh.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        pjb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_AndroidContentContext);
        ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
        c();
        return;
      }
      if (onh.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.f;
        onh.a(this.jdField_a_of_type_AndroidContentContext, str, null);
        QLog.i("OnReadArticleClickListener", 2, "click readArticle answerUrl +" + str);
        ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
        c();
        return;
      }
      if (ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        onh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 4, false, 7, false);
        ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoId);
        return;
      }
      if (ram.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        onh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2, false, 6, false);
        ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
        return;
      }
    } while ((!ram.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ram.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)));
    String str = ((qds)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.a.get(0)).b;
    if (!TextUtils.isEmpty(str)) {
      onh.a(this.jdField_a_of_type_AndroidContentContext, str);
    }
    onh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Ram, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    rnu.b("fast_web_show_light_house_1");
    osg.a().a().a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    a(paramArticleInfo, null);
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    onh.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramArticleInfo);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      ram.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      shu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pis
 * JD-Core Version:    0.7.0.1
 */