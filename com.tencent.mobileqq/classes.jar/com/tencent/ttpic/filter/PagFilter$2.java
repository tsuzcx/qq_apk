package com.tencent.ttpic.filter;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;

class PagFilter$2
  implements Runnable
{
  PagFilter$2(PagFilter paramPagFilter) {}
  
  public void run()
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    PagFilter.access$102(this.this$0, localObject[0]);
    localObject = this.this$0;
    PagFilter.access$202((PagFilter)localObject, new SurfaceTexture(PagFilter.access$100((PagFilter)localObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.PagFilter.2
 * JD-Core Version:    0.7.0.1
 */