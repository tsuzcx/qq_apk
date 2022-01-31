import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.ClickHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class mqv
  implements Runnable
{
  protected View a;
  protected ViewBase a;
  
  public mqv(ClickHelper paramClickHelper) {}
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(ViewBase paramViewBase)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = paramViewBase;
  }
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerClickHelper.a) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerClickHelper.c, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerClickHelper.d, true)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerClickHelper.b = true;
      this.jdField_a_of_type_AndroidViewView.performHapticFeedback(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqv
 * JD-Core Version:    0.7.0.1
 */