import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pxw
  implements View.OnClickListener
{
  pxw(pxl parampxl, ppu paramppu, PgcSmallView paramPgcSmallView, Container paramContainer) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Ppu.a();
    localArticleInfo.clickArea = 11;
    QLog.d("PgcShortContentProteusItem", 1, "click short content small image");
    if (this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a.jdField_a_of_type_Int == 3)
    {
      localArticleInfo.clickJumpTarget = qam.a(this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a.jdField_a_of_type_Qyi.h, "-1");
      ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a.jdField_a_of_type_Qyi.h, null);
    }
    for (;;)
    {
      ozs.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localArticleInfo.clickJumpTarget = qam.a(this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a.jdField_a_of_type_Qxp.c, "-1");
      ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a.jdField_a_of_type_Qxp.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxw
 * JD-Core Version:    0.7.0.1
 */