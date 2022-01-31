package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import java.lang.ref.WeakReference;

class QQMovieFilter$MovieOnFrameAvailableListener
  implements SurfaceTexture.OnFrameAvailableListener
{
  private boolean enable = true;
  private WeakReference<QQMovieFilter> movieFilterWeakReference;
  
  public QQMovieFilter$MovieOnFrameAvailableListener(QQMovieFilter paramQQMovieFilter)
  {
    this.movieFilterWeakReference = new WeakReference(paramQQMovieFilter);
  }
  
  public void disable()
  {
    this.enable = false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.enable)
    {
      QQMovieFilter localQQMovieFilter = (QQMovieFilter)this.movieFilterWeakReference.get();
      if (localQQMovieFilter != null) {
        localQQMovieFilter.setSurfaceTexture(paramSurfaceTexture);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMovieFilter.MovieOnFrameAvailableListener
 * JD-Core Version:    0.7.0.1
 */