package cooperation.qqreader.shadow;

import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.utils.Log;
import cooperation.qqreader.utils.ReportUtils;

class ReaderShadowImpl$1$1
  implements EnterCallback
{
  ReaderShadowImpl$1$1(ReaderShadowImpl.1 param1, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
    Log.c("ReaderShadowImpl", "[onCloseLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
  
  public void onEnterComplete()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1002L) {
      ReportUtils.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "0");
    }
    for (;;)
    {
      Log.c("ReaderShadowImpl", "[onEnterComplete] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1003L) {
        ReportUtils.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "1");
      }
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
    Log.c("ReaderShadowImpl", "[onShowLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderShadowImpl.1.1
 * JD-Core Version:    0.7.0.1
 */