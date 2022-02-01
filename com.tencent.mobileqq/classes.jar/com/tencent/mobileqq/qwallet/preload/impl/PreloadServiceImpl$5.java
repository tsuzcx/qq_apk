package com.tencent.mobileqq.qwallet.preload.impl;

import java.lang.ref.WeakReference;

class PreloadServiceImpl$5
  implements Runnable
{
  PreloadServiceImpl$5(PreloadServiceImpl paramPreloadServiceImpl, WeakReference paramWeakReference, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (PreloadServiceImpl)((WeakReference)localObject).get();
      if ((localObject != null) && (!((PreloadServiceImpl)localObject).mIsOnDestroy)) {
        PreloadServiceImpl.access$300((PreloadServiceImpl)localObject, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */