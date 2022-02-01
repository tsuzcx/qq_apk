package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Bundle;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class IVCommonInterfaceImpl$1
  implements Callable<Bundle>
{
  IVCommonInterfaceImpl$1(IVCommonInterfaceImpl paramIVCommonInterfaceImpl, String paramString) {}
  
  public Bundle call()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    LbsManagerService.startLocation(new IVCommonInterfaceImpl.1.1(this, this.val$businessId, arrayOfBundle, localCountDownLatch));
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl.1
 * JD-Core Version:    0.7.0.1
 */