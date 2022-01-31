import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class phk
  implements View.OnClickListener
{
  phk(pgz parampgz, pax parampax, Container paramContainer, PgcSmallView paramPgcSmallView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Pax.a();
    paramView.click_area = 11;
    onk.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramView, (int)paramView.mChannelID);
    if (this.jdField_a_of_type_Pax.a().mSocialFeedInfo.a.jdField_a_of_type_Int == 3)
    {
      onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pax.a().mSocialFeedInfo.a.jdField_a_of_type_Qda.h, null);
      return;
    }
    onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pax.a().mSocialFeedInfo.a.jdField_a_of_type_Qch.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phk
 * JD-Core Version:    0.7.0.1
 */