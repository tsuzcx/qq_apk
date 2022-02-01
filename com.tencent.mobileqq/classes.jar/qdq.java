import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qdq
  implements View.OnClickListener
{
  qdq(qdf paramqdf, pvc parampvc, PgcSmallView paramPgcSmallView, Container paramContainer) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvc.a();
    localArticleInfo.clickArea = 11;
    QLog.d("PgcShortContentProteusItem", 1, "click short content small image");
    if (this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a.jdField_a_of_type_Int == 3)
    {
      localArticleInfo.clickJumpTarget = qgg.a(this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a.jdField_a_of_type_Rfg.h, "-1");
      pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a.jdField_a_of_type_Rfg.h, null);
    }
    for (;;)
    {
      pay.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localArticleInfo.clickJumpTarget = qgg.a(this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a.jdField_a_of_type_Ren.c, "-1");
      pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a.jdField_a_of_type_Ren.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdq
 * JD-Core Version:    0.7.0.1
 */