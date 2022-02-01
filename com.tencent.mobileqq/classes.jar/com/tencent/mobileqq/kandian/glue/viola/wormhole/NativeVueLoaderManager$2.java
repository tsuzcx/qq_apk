package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.nativevue.NativeVuePreconditionAdapter.LoadSoResult;
import com.tencent.qphone.base.util.QLog;

class NativeVueLoaderManager$2
  implements OnLoadListener
{
  NativeVueLoaderManager$2(NativeVueLoaderManager paramNativeVueLoaderManager, NativeVuePreconditionAdapter.LoadSoResult paramLoadSoResult) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentNativevueNativeVuePreconditionAdapter$LoadSoResult.onLoadSuccess();
      QLog.d("NativeVueLoaderManager", 1, "load NativeVue Success");
      return;
    }
    this.jdField_a_of_type_ComTencentNativevueNativeVuePreconditionAdapter$LoadSoResult.onLoadError();
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("load NativeVue Error: ");
    paramLoadExtResult.append(paramInt);
    QLog.e("NativeVueLoaderManager", 1, paramLoadExtResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager.2
 * JD-Core Version:    0.7.0.1
 */