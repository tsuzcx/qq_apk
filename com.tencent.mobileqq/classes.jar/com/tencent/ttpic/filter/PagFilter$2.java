package com.tencent.ttpic.filter;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;

class PagFilter$2
  implements Runnable
{
  PagFilter$2(PagFilter paramPagFilter) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    PagFilter.access$102(this.this$0, arrayOfInt[0]);
    PagFilter.access$202(this.this$0, new SurfaceTexture(PagFilter.access$100(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.PagFilter.2
 * JD-Core Version:    0.7.0.1
 */