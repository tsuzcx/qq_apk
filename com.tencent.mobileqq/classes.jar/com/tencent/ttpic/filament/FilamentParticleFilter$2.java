package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import java.util.concurrent.LinkedBlockingDeque;

class FilamentParticleFilter$2
  implements SurfaceTexture.OnFrameAvailableListener
{
  FilamentParticleFilter$2(FilamentParticleFilter paramFilamentParticleFilter) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      FilamentParticleFilter.access$800(this.this$0).put(new FilamentParticleFilter.2.1(this));
      return;
    }
    catch (InterruptedException paramSurfaceTexture)
    {
      paramSurfaceTexture.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentParticleFilter.2
 * JD-Core Version:    0.7.0.1
 */