package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver.IBusinessInitFinish;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.qphone.base.util.QLog;

class DynamicNowManager$8
  implements IBusinessExpireObserver
{
  DynamicNowManager$8(DynamicNowManager paramDynamicNowManager, Bundle paramBundle, String paramString) {}
  
  public void a(IBusinessExpireObserver.IBusinessInitFinish paramIBusinessInitFinish)
  {
    QLog.i("DynamicNowManager", 1, "Recv Business Expire");
    DynamicNowManager.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager, this.jdField_a_of_type_AndroidOsBundle);
    if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a())
    {
      DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(null, new DynamicNowManager.8.1(this, paramIBusinessInitFinish));
      return;
    }
    BizLoginRequest localBizLoginRequest = new BizLoginRequest();
    localBizLoginRequest.jdField_a_of_type_JavaLangString = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(this.jdField_a_of_type_AndroidOsBundle);
    localBizLoginRequest.jdField_a_of_type_Int = 8;
    localBizLoginRequest.g = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a();
    localBizLoginRequest.f = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).b();
    localBizLoginRequest.b = this.jdField_a_of_type_JavaLangString;
    LiteLiveSDKFactory.a().a(localBizLoginRequest);
    paramIBusinessInitFinish.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.8
 * JD-Core Version:    0.7.0.1
 */