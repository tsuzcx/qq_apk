import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class phd
  implements ViewBase.OnClickListener
{
  phd(pgw parampgw, pau parampau, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_Pau.a().mSocialFeedInfo.jdField_a_of_type_Qcv.a) && (this.jdField_a_of_type_Pau.a().mSocialFeedInfo.jdField_a_of_type_Qco != null)) {
        onh.a(paramViewBase.getNativeView().getContext(), this.jdField_a_of_type_Pau.a().mSocialFeedInfo.jdField_a_of_type_Qco.a.h, null);
      }
      paramViewBase = this.jdField_a_of_type_Pau.a();
      if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
      {
        paramViewBase.click_area = 11;
        onh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
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
 * Qualified Name:     phd
 * JD-Core Version:    0.7.0.1
 */