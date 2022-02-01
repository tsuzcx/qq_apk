package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.jetbrains.annotations.NotNull;

public class ViolaVideoUpdateController
{
  @NotNull
  private Runnable a;
  private boolean b = false;
  private long c = 500L;
  private Runnable d = new ViolaVideoUpdateController.1(this);
  
  public ViolaVideoUpdateController(@NotNull Runnable paramRunnable, long paramLong)
  {
    this.a = paramRunnable;
    this.c = paramLong;
  }
  
  public void a()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    ThreadManagerV2.getUIHandlerV2().post(this.d);
  }
  
  public void b()
  {
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.d);
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.ViolaVideoUpdateController
 * JD-Core Version:    0.7.0.1
 */