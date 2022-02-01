package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.concurrent.LinkedBlockingDeque;

class FilamentFilter$2
  implements SurfaceTexture.OnFrameAvailableListener
{
  FilamentFilter$2(FilamentFilter paramFilamentFilter) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      FilamentFilter.access$700(this.this$0).put(new FilamentFilter.2.1(this));
    }
    catch (InterruptedException paramSurfaceTexture)
    {
      paramSurfaceTexture.printStackTrace();
    }
    LogUtils.d(FilamentFilter.access$800(), "test for filament render: update finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter.2
 * JD-Core Version:    0.7.0.1
 */