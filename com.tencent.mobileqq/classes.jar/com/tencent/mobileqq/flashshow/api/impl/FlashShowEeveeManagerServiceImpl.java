package com.tencent.mobileqq.flashshow.api.impl;

import com.tencent.mobileqq.flashshow.api.IFlashShowEeveeManagerService;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper;
import com.tencent.mobileqq.flashshow.redpoint.FSEeveeManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.atomic.AtomicInteger;

public class FlashShowEeveeManagerServiceImpl
  implements IFlashShowEeveeManagerService
{
  public AtomicInteger getAtomicInteger()
  {
    return FSEeveeManager.a().b();
  }
  
  public void onSend(int paramInt, String paramString1, String paramString2)
  {
    FSEeveeManager.a().a(paramInt, paramString1, paramString2);
  }
  
  public void release()
  {
    FSEeveeManager.c();
    FSEeveeRedPointHelper.releaseInstance();
    ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).clearPedPoint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.impl.FlashShowEeveeManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */