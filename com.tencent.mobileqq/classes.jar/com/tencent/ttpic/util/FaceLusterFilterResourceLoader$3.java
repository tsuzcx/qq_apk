package com.tencent.ttpic.util;

import com.tencent.aekit.api.standard.AEModule;
import java.util.concurrent.CountDownLatch;

final class FaceLusterFilterResourceLoader$3
  implements Runnable
{
  public void run()
  {
    FaceLusterFilterResourceLoader.access$300(AEModule.getContext(), "assets://realtimeBeauty", "model_normals");
    FaceLusterFilterResourceLoader.access$100().countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceLusterFilterResourceLoader.3
 * JD-Core Version:    0.7.0.1
 */