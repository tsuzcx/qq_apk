import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oyl
  implements ViewBase.OnClickListener
{
  oyl(oyk paramoyk) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity() != null)
    {
      oyj.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyl
 * JD-Core Version:    0.7.0.1
 */