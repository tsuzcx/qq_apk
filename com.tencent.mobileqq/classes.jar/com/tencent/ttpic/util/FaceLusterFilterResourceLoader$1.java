package com.tencent.ttpic.util;

import com.tencent.aekit.api.standard.AEModule;
import java.util.concurrent.CountDownLatch;

final class FaceLusterFilterResourceLoader$1
  implements Runnable
{
  public void run()
  {
    FaceLusterFilterResourceLoader.access$000(AEModule.getContext(), "assets://realtimeBeauty", "model_indices");
    FaceLusterFilterResourceLoader.access$100().countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceLusterFilterResourceLoader.1
 * JD-Core Version:    0.7.0.1
 */