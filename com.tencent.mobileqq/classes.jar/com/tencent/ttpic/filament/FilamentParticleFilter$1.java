package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import java.util.concurrent.CountDownLatch;

class FilamentParticleFilter$1
  implements Runnable
{
  FilamentParticleFilter$1(FilamentParticleFilter paramFilamentParticleFilter) {}
  
  public void run()
  {
    FilamentParticleFilter.access$002(this.this$0, new SurfaceTexture(FilamentParticleFilter.access$100(this.this$0)[0]));
    FilamentParticleFilter.access$200(this.this$0).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentParticleFilter.1
 * JD-Core Version:    0.7.0.1
 */