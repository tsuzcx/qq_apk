package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class EncodeInputSurface
{
  private EglSurfaceBase a;
  private EglCore b;
  private TextureRender c;
  private Surface d;
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.d = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).a();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((EglCore)localObject).a();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.c = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.c.drawTexture(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
    this.a.a(paramLong);
    this.a.c();
  }
  
  public void a(EncodeConfig paramEncodeConfig, Surface paramSurface)
  {
    this.d = paramSurface;
    this.b = new EglCore(paramEncodeConfig.a(), 1);
    this.a = new EglSurfaceBase(this.b);
    this.a.a(paramSurface);
    this.a.b();
    this.c = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeInputSurface
 * JD-Core Version:    0.7.0.1
 */