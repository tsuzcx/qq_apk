import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;

public class tco
  implements HippyQQEngine.HippyQQEngineListener
{
  public tco(ViolaFragment paramViolaFragment, Bundle paramBundle, ViewGroup paramViewGroup) {}
  
  public void onError(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.b();
    if (paramInt != -11) {
      ViolaFragment.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidViewViewGroup);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    }
  }
  
  public void onSuccess()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.d();
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, "Hippy: initHippy success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tco
 * JD-Core Version:    0.7.0.1
 */