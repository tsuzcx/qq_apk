import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;

public class lah
  implements View.OnClickListener
{
  public lah(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool != null) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.b(this.a.getActivity(), this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    }
    try
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a.a(134248548, null, null, null, null, 0L, false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lah
 * JD-Core Version:    0.7.0.1
 */