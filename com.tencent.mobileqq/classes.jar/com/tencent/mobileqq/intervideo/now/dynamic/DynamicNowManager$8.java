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
    DynamicNowManager.b(this.c, this.a);
    if (DynamicNowManager.d(this.c).a())
    {
      DynamicNowManager.d(this.c).a(null, new DynamicNowManager.8.1(this, paramIBusinessInitFinish));
      return;
    }
    BizLoginRequest localBizLoginRequest = new BizLoginRequest();
    localBizLoginRequest.a = DynamicNowManager.a(this.c).b(this.a);
    localBizLoginRequest.b = 8;
    localBizLoginRequest.i = DynamicNowManager.d(this.c).c();
    localBizLoginRequest.h = DynamicNowManager.d(this.c).d();
    localBizLoginRequest.c = this.b;
    LiteLiveSDKFactory.a().a(localBizLoginRequest);
    paramIBusinessInitFinish.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.8
 * JD-Core Version:    0.7.0.1
 */