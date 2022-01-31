import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.viola.core.ViolaInstance;

public class rxv
  implements rzl
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public rxv(BridgeModule paramBridgeModule) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    ViolaFragment localViolaFragment;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      localViolaFragment = (ViolaFragment)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getFragment();
      if (!paramBoolean) {
        break label85;
      }
      this.jdField_a_of_type_JavaLangString = localViolaFragment.b();
      this.jdField_a_of_type_Boolean = localViolaFragment.a().booleanValue();
      localViolaFragment.a("#FF000000");
      localViolaFragment.b("#FF000000");
      localViolaFragment.a(Boolean.valueOf(true), true);
    }
    label85:
    do
    {
      return;
      localViolaFragment.a(this.jdField_a_of_type_JavaLangString);
      localViolaFragment.b(this.jdField_a_of_type_JavaLangString);
      localViolaFragment.a(Boolean.valueOf(this.jdField_a_of_type_Boolean), true);
    } while ((!localViolaFragment.a()) || (localViolaFragment.a() == null));
    localViolaFragment.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxv
 * JD-Core Version:    0.7.0.1
 */