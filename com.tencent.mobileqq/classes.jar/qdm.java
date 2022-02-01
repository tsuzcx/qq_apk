import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class qdm
  implements ViewBase.OnClickListener
{
  qdm(qdf paramqdf, pvc parampvc, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.jdField_a_of_type_Rfe.a) && (this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.jdField_a_of_type_Rex != null))
      {
        String str = this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.jdField_a_of_type_Rex.a.h;
        paramViewBase = paramViewBase.getNativeView();
        qdf.a(this.jdField_a_of_type_Qdf, paramViewBase, str);
        paramViewBase = this.jdField_a_of_type_Pvc.a();
        if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
        {
          paramViewBase.clickArea = 11;
          paramViewBase.clickJumpTarget = qgg.a(str, "-1");
          pay.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
        }
      }
      return;
    }
    catch (NullPointerException paramViewBase)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramViewBase.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdm
 * JD-Core Version:    0.7.0.1
 */