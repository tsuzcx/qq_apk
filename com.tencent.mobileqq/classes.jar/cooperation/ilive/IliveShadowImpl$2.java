package cooperation.ilive;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;

class IliveShadowImpl$2
  implements EnterCallback
{
  IliveShadowImpl$2(IliveShadowImpl paramIliveShadowImpl, EnterCallback paramEnterCallback, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    Object localObject = this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback;
    if (localObject != null) {
      ((EnterCallback)localObject).onCloseLoadingView();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onCloseLoadingView] formId = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("IliveAuthShadowImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onEnterComplete()
  {
    Object localObject = this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback;
    if (localObject != null) {
      ((EnterCallback)localObject).onEnterComplete();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onEnterComplete] formId = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("IliveAuthShadowImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onShowLoadingView(View paramView)
  {
    EnterCallback localEnterCallback = this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback;
    if (localEnterCallback != null) {
      localEnterCallback.onShowLoadingView(paramView);
    }
    paramView = new StringBuilder();
    paramView.append("[onShowLoadingView] formId = ");
    paramView.append(this.jdField_a_of_type_Long);
    QLog.i("IliveAuthShadowImpl", 1, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IliveShadowImpl.2
 * JD-Core Version:    0.7.0.1
 */