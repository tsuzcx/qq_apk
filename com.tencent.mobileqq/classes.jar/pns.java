import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;

class pns
  implements View.OnClickListener
{
  pns(pnh parampnh, pgd parampgd, PgcSmallView paramPgcSmallView, Container paramContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Pgd.a();
    paramView.click_area = 11;
    QLog.d("PgcShortContentProteusItem", 1, "click short content small image");
    if (this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a.jdField_a_of_type_Int == 3)
    {
      paramView.click_jump_target = pqd.a(this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a.jdField_a_of_type_Qmt.h, "-1");
      ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a.jdField_a_of_type_Qmt.h, null);
    }
    for (;;)
    {
      ors.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramView, (int)paramView.mChannelID);
      return;
      paramView.click_jump_target = pqd.a(this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a.jdField_a_of_type_Qma.c, "-1");
      ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a.jdField_a_of_type_Qma.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pns
 * JD-Core Version:    0.7.0.1
 */