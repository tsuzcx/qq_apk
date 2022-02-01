package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

public class HWVideoRecorderBuffer
{
  private int[] a = new int[3];
  private Frame[] b = new Frame[3];
  private GPUBaseFilter c;
  private volatile int d = 0;
  private volatile int e = 0;
  private int f;
  private int g;
  
  public void a()
  {
    int i = 0;
    this.d = 0;
    this.e = 0;
    Object localObject = this.c;
    if (localObject != null) {
      ((GPUBaseFilter)localObject).destroy();
    }
    localObject = this.a;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    while (i < 3)
    {
      localObject = this.b;
      if (localObject[i] != null) {
        localObject[i].clear();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = new GPUBaseFilter();
    this.c.init();
    int[] arrayOfInt = this.a;
    int j = arrayOfInt.length;
    int i = 0;
    GLES20.glGenTextures(j, arrayOfInt, 0);
    while (i < 3)
    {
      this.b[i] = new Frame();
      i += 1;
    }
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      this.d += paramInt;
      break label29;
      this.e += paramInt;
      label29:
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    if (Math.min(1, 3 - (this.d - this.e)) == 1)
    {
      int i = this.d % 3;
      this.b[i].bindFrame(this.a[i], this.f, this.g, 1.0D);
      GlUtil.checkGlError("bindFrame");
      this.c.drawTexture(paramInt, null, null);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glFinish();
      a(true, 1);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (Math.min(1, this.d - this.e) == 1)
    {
      int i = this.e;
      return this.a[(i % 3)];
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorderBuffer
 * JD-Core Version:    0.7.0.1
 */