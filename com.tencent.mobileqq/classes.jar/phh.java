import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class phh
  implements View.OnClickListener
{
  phh(pgw parampgw, pau parampau, Container paramContainer, PgcSmallView paramPgcSmallView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Pau.a();
    paramView.click_area = 11;
    onh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramView, (int)paramView.mChannelID);
    if (this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a.jdField_a_of_type_Int == 3)
    {
      onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a.jdField_a_of_type_Qcx.h, null);
      return;
    }
    onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a.jdField_a_of_type_Qce.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phh
 * JD-Core Version:    0.7.0.1
 */