package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.concurrent.LinkedBlockingDeque;

class FilamentFilter$3
  implements SurfaceTexture.OnFrameAvailableListener
{
  FilamentFilter$3(FilamentFilter paramFilamentFilter) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      FilamentFilter.access$700(this.this$0).put(new FilamentFilter.3.1(this));
      LogUtils.d(FilamentFilter.access$800(), "test for filament render: update finish");
      return;
    }
    catch (InterruptedException paramSurfaceTexture)
    {
      for (;;)
      {
        paramSurfaceTexture.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter.3
 * JD-Core Version:    0.7.0.1
 */