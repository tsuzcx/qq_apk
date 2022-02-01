import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class qfh
  implements ViewBase.OnClickListener
{
  qfh(qfa paramqfa, pxk parampxk, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.jdField_a_of_type_Rhn.a) && (this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.jdField_a_of_type_Rhg != null))
      {
        String str = this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.jdField_a_of_type_Rhg.a.h;
        paramViewBase = paramViewBase.getNativeView();
        qfa.a(this.jdField_a_of_type_Qfa, paramViewBase, str);
        paramViewBase = this.jdField_a_of_type_Pxk.a();
        if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
        {
          paramViewBase.clickArea = 11;
          paramViewBase.clickJumpTarget = qib.a(str, "-1");
          pha.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
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
 * Qualified Name:     qfh
 * JD-Core Version:    0.7.0.1
 */