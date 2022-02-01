package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.automator.IThreadExecutor;
import org.jetbrains.annotations.NotNull;

class RIJUgcVideoPublishManager$3
  implements IThreadExecutor
{
  RIJUgcVideoPublishManager$3(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager) {}
  
  public void a(@NotNull Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.3
 * JD-Core Version:    0.7.0.1
 */