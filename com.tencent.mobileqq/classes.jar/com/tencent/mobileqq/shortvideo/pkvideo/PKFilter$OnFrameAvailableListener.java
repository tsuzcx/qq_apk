package com.tencent.mobileqq.shortvideo.pkvideo;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import java.lang.ref.WeakReference;

class PKFilter$OnFrameAvailableListener
  implements SurfaceTexture.OnFrameAvailableListener
{
  private WeakReference<PKFilter> mFilter;
  private boolean mIsEnabled = true;
  
  public PKFilter$OnFrameAvailableListener(PKFilter paramPKFilter)
  {
    this.mFilter = new WeakReference(paramPKFilter);
  }
  
  public void disable()
  {
    this.mIsEnabled = false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mIsEnabled)
    {
      PKFilter localPKFilter = (PKFilter)this.mFilter.get();
      if (localPKFilter != null) {
        localPKFilter.setSurfaceTexture(paramSurfaceTexture);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.pkvideo.PKFilter.OnFrameAvailableListener
 * JD-Core Version:    0.7.0.1
 */