package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resCode", "", "<anonymous parameter 1>", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "kotlin.jvm.PlatformType", "onLoadResult"}, k=3, mv={1, 1, 16})
final class ViolaSoLoader$loadLibrary$1
  implements OnLoadListener
{
  ViolaSoLoader$loadLibrary$1(ViolaSoLoader paramViolaSoLoader, LoadLibCallback paramLoadLibCallback, String paramString) {}
  
  public final void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      ViolaSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader, true);
      paramLoadExtResult = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebLoadLibCallback;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.onFinish(ReadInJoyWebRenderEngine.f);
      }
      ViolaSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader, 0);
      paramLoadExtResult = new StringBuilder();
      paramLoadExtResult.append("load viola so success, from: ");
      paramLoadExtResult.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ViolaSoLoader", 1, paramLoadExtResult.toString());
      return;
    }
    ViolaSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader, false);
    if (ViolaSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader) < 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebLoadLibCallback);
      paramLoadExtResult = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader;
      ViolaSoLoader.a(paramLoadExtResult, ViolaSoLoader.a(paramLoadExtResult) + 1);
      paramLoadExtResult = new StringBuilder();
      paramLoadExtResult.append("load viola so error, from: ");
      paramLoadExtResult.append(this.jdField_a_of_type_JavaLangString);
      paramLoadExtResult.append(", retryCount: ");
      paramLoadExtResult.append(ViolaSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader));
      QLog.e("ViolaSoLoader", 1, paramLoadExtResult.toString());
      return;
    }
    ViolaSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader, 0);
    paramLoadExtResult = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebLoadLibCallback;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.onError(paramInt);
    }
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("load viola so error, from: ");
    paramLoadExtResult.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("ViolaSoLoader", 1, paramLoadExtResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoader.loadLibrary.1
 * JD-Core Version:    0.7.0.1
 */