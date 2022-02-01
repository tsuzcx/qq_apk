package com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.tkd.R.raw;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil;

public class GPUImagePixelationFilter
  extends GPUDrawPartFilter
{
  private static String c = GlUtil.a(AppContext.a, R.raw.b);
  private int d;
  private int e;
  private int f;
  private float g = 30.0F;
  private float h;
  private float i;
  private int j = -1;
  private int k;
  private Bitmap l = null;
  private boolean m = false;
  private boolean n = false;
  
  GPUImagePixelationFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", c);
    this.a = 3553;
    this.b = 106;
  }
  
  private void a(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void a()
  {
    super.a();
    this.d = GLES20.glGetUniformLocation(e(), "imageWidthFactor");
    a(this.d, "imageWidthFactor");
    this.e = GLES20.glGetUniformLocation(e(), "imageHeightFactor");
    a(this.e, "imageHeightFactor");
    this.f = GLES20.glGetUniformLocation(e(), "pixel");
    a(this.f, "mPixelLocation");
    this.k = GLES20.glGetUniformLocation(e(), "sTexture2");
    a(this.g);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onOutputSizeChanged width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height=%s");
    localStringBuilder.append(paramInt2);
    TLog.b("GPUImagePixelationFilter", localStringBuilder.toString());
    this.h = 0.0009259259F;
    this.i = 0.0005208334F;
  }
  
  protected void b()
  {
    super.b();
    GLES20.glUniform1f(this.d, this.h);
    GLES20.glUniform1f(this.e, this.i);
    GLES20.glUniform1f(this.f, this.g);
    if (this.l == null)
    {
      TLog.d("GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.j == -1) || (this.m))
    {
      if (this.l.isRecycled())
      {
        TLog.d("GPUImagePixelationFilter", "mosaic bitmap is recycled");
        return;
      }
      int i1 = this.j;
      if (i1 != -1) {
        GlUtil.b(i1);
      }
      this.j = GlUtil.a(3553, this.l);
      this.m = false;
      if (this.n) {
        this.l.recycle();
      }
    }
    GLES20.glBindTexture(3553, this.j);
    GLES20.glUniform1i(this.k, 1);
  }
  
  protected void c()
  {
    if (this.n)
    {
      Bitmap localBitmap = this.l;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        this.l.recycle();
        this.l = null;
        TLog.b("GPUImagePixelationFilter", "mosaic bitmap recycle");
      }
    }
    int i1 = this.j;
    if (i1 != -1) {
      GlUtil.b(i1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer.GPUImagePixelationFilter
 * JD-Core Version:    0.7.0.1
 */