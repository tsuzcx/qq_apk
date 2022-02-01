package com.tencent.ttpic.filter;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import java.util.concurrent.Semaphore;

class PagFilter$3
  implements SurfaceTexture.OnFrameAvailableListener
{
  PagFilter$3(PagFilter paramPagFilter) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    PagFilter.access$200(this.this$0).updateTexImage();
    PagFilter.access$200(this.this$0).getTransformMatrix(PagFilter.access$300(this.this$0));
    if (!PagFilter.access$400(this.this$0)) {
      PagFilter.access$500(this.this$0).release();
    }
    PagFilter.access$402(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.PagFilter.3
 * JD-Core Version:    0.7.0.1
 */