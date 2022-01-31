import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.viola.core.ViolaInstance;

public class rli
  implements rmx
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public rli(BridgeModule paramBridgeModule) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    ViolaLazyFragment localViolaLazyFragment;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getFragment() instanceof ViolaLazyFragment)))
    {
      localViolaLazyFragment = (ViolaLazyFragment)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getFragment();
      if (paramBoolean)
      {
        this.jdField_a_of_type_JavaLangString = localViolaLazyFragment.b();
        this.jdField_a_of_type_Boolean = localViolaLazyFragment.a().booleanValue();
        localViolaLazyFragment.a("#FF000000");
        localViolaLazyFragment.b("#FF000000");
        localViolaLazyFragment.a(Boolean.valueOf(true), true);
      }
    }
    else
    {
      return;
    }
    localViolaLazyFragment.a(this.jdField_a_of_type_JavaLangString);
    localViolaLazyFragment.b(this.jdField_a_of_type_JavaLangString);
    localViolaLazyFragment.a(Boolean.valueOf(this.jdField_a_of_type_Boolean), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rli
 * JD-Core Version:    0.7.0.1
 */