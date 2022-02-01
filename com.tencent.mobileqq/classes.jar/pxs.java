import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class pxs
  implements ViewBase.OnClickListener
{
  pxs(pxl parampxl, ppu paramppu, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.jdField_a_of_type_Qyg.a) && (this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.jdField_a_of_type_Qxz != null))
      {
        String str = this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.jdField_a_of_type_Qxz.a.h;
        paramViewBase = paramViewBase.getNativeView();
        pxl.a(this.jdField_a_of_type_Pxl, paramViewBase, str);
        paramViewBase = this.jdField_a_of_type_Ppu.a();
        if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
        {
          paramViewBase.clickArea = 11;
          paramViewBase.clickJumpTarget = qam.a(str, "-1");
          ozs.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
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
 * Qualified Name:     pxs
 * JD-Core Version:    0.7.0.1
 */