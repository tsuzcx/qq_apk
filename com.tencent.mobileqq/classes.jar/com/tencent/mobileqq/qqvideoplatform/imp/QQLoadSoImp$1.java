package com.tencent.mobileqq.qqvideoplatform.imp;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

class QQLoadSoImp$1
  implements OnLoadListener
{
  QQLoadSoImp$1(QQLoadSoImp paramQQLoadSoImp, LoadSoCallback paramLoadSoCallback) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "initSDKAsync, onLoadResult, resCode = " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqvideoplatformImpQQLoadSoImp.a = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(false);
    this.jdField_a_of_type_ComTencentMobileqqQqvideoplatformImpQQLoadSoImp.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.imp.QQLoadSoImp.1
 * JD-Core Version:    0.7.0.1
 */