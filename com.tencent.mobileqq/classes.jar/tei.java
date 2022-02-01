import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.viola.core.ViolaInstance;

public class tei
  implements tiy
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public tei(BridgeModule paramBridgeModule) {}
  
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
      this.jdField_a_of_type_JavaLangString = localViolaFragment.getStatusBarColor();
      this.jdField_a_of_type_Boolean = localViolaFragment.getStatusBarFontColorWhite().booleanValue();
      localViolaFragment.setStatusBarColor("#FF000000");
      localViolaFragment.initStatusBarColor("#FF000000");
      localViolaFragment.setStatusBarFontColor(Boolean.valueOf(true), true);
    }
    label85:
    do
    {
      return;
      localViolaFragment.setStatusBarColor(this.jdField_a_of_type_JavaLangString);
      localViolaFragment.initStatusBarColor(this.jdField_a_of_type_JavaLangString);
      localViolaFragment.setStatusBarFontColor(Boolean.valueOf(this.jdField_a_of_type_Boolean), true);
    } while ((!localViolaFragment.isSuspension()) || (localViolaFragment.getCommonSuspensionGestureLayout() == null));
    localViolaFragment.getCommonSuspensionGestureLayout().g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tei
 * JD-Core Version:    0.7.0.1
 */