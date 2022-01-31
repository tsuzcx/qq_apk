import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class phg
  implements ViewBase.OnClickListener
{
  phg(pgz parampgz, pax parampax, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_Pax.a().mSocialFeedInfo.jdField_a_of_type_Qcy.a) && (this.jdField_a_of_type_Pax.a().mSocialFeedInfo.jdField_a_of_type_Qcr != null)) {
        onk.a(paramViewBase.getNativeView().getContext(), this.jdField_a_of_type_Pax.a().mSocialFeedInfo.jdField_a_of_type_Qcr.a.h, null);
      }
      paramViewBase = this.jdField_a_of_type_Pax.a();
      if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
      {
        paramViewBase.click_area = 11;
        onk.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
      }
      return;
    }
    catch (NullPointerException paramViewBase)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramViewBase.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phg
 * JD-Core Version:    0.7.0.1
 */