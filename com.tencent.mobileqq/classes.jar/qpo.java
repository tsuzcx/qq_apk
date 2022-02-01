import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class qpo
  implements ViewBase.OnClickListener
{
  qpo(qph paramqph, qfw paramqfw, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_Qfw.a().mSocialFeedInfo.jdField_a_of_type_Rrl.a) && (this.jdField_a_of_type_Qfw.a().mSocialFeedInfo.jdField_a_of_type_Rre != null))
      {
        String str = this.jdField_a_of_type_Qfw.a().mSocialFeedInfo.jdField_a_of_type_Rre.a.h;
        paramViewBase = paramViewBase.getNativeView();
        qph.a(this.jdField_a_of_type_Qph, paramViewBase, str);
        paramViewBase = this.jdField_a_of_type_Qfw.a();
        if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
        {
          paramViewBase.clickArea = 11;
          paramViewBase.clickJumpTarget = qsj.a(str, "-1");
          pqb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
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
 * Qualified Name:     qpo
 * JD-Core Version:    0.7.0.1
 */