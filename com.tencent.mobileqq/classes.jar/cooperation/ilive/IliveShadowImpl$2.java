package cooperation.ilive;

import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.utils.Log;

class IliveShadowImpl$2
  implements EnterCallback
{
  IliveShadowImpl$2(IliveShadowImpl paramIliveShadowImpl, EnterCallback paramEnterCallback, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
    Log.c("IliveAuthShadowImpl", "[onCloseLoadingView] formId = " + this.jdField_a_of_type_Long);
  }
  
  public void onEnterComplete()
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    Log.c("IliveAuthShadowImpl", "[onEnterComplete] formId = " + this.jdField_a_of_type_Long);
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
    Log.c("IliveAuthShadowImpl", "[onShowLoadingView] formId = " + this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveShadowImpl.2
 * JD-Core Version:    0.7.0.1
 */