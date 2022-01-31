import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class pno
  implements ViewBase.OnClickListener
{
  pno(pnh parampnh, pgd parampgd, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.jdField_a_of_type_Qmr.a) && (this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.jdField_a_of_type_Qmk != null))
      {
        String str = this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.jdField_a_of_type_Qmk.a.h;
        paramViewBase = paramViewBase.getNativeView();
        pnh.a(this.jdField_a_of_type_Pnh, paramViewBase, str);
        paramViewBase = this.jdField_a_of_type_Pgd.a();
        if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
        {
          paramViewBase.click_area = 11;
          paramViewBase.click_jump_target = pqd.a(str, "-1");
          ors.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pno
 * JD-Core Version:    0.7.0.1
 */