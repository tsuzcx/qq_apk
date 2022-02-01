package com.tencent.mobileqq.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.io.IOException;
import mqq.app.MobileQQ;

public class GPUImagePixelationFilter
  extends GPUDrawPartFilter
{
  private static String l = GlUtil.readTextFromRawResource(MobileQQ.getContext(), 2131230832);
  private int a;
  private int b;
  private int c;
  private float d = 30.0F;
  private float e;
  private float f;
  private int g = -1;
  private int h;
  private Bitmap i = null;
  private boolean j = false;
  private boolean k = false;
  
  public GPUImagePixelationFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", l);
    this.mTextureType = 3553;
    this.mFilterType = 106;
  }
  
  public void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.j = true;
    this.i = paramBitmap;
  }
  
  public void a(String paramString)
  {
    this.j = true;
    this.k = true;
    try
    {
      this.i = BitmapUtils.a(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      SLog.c("Q.qqstory.publish.edit GPUImagePixelationFilter", "setMosaicPath OutOfMemoryError", paramString);
    }
  }
  
  protected void onDestroy()
  {
    if (this.k)
    {
      Bitmap localBitmap = this.i;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        this.i.recycle();
        this.i = null;
        SLog.b("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap recycle");
      }
    }
    int m = this.g;
    if (m != -1) {
      GlUtil.deleteTexture(m);
    }
  }
  
  protected void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glUniform1f(this.a, this.e);
    GLES20.glUniform1f(this.b, this.f);
    GLES20.glUniform1f(this.c, this.d);
    if (this.i == null)
    {
      SLog.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.g == -1) || (this.j))
    {
      if (this.i.isRecycled())
      {
        SLog.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap is recycled");
        return;
      }
      int m = this.g;
      if (m != -1) {
        GlUtil.deleteTexture(m);
      }
      this.g = GlUtil.createTexture(3553, this.i);
      this.j = false;
      if (this.k) {
        this.i.recycle();
      }
    }
    GLES20.glBindTexture(3553, this.g);
    GLES20.glUniform1i(this.h, 1);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.a = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
    checkLocation(this.a, "imageWidthFactor");
    this.b = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
    checkLocation(this.b, "imageHeightFactor");
    this.c = GLES20.glGetUniformLocation(getProgram(), "pixel");
    checkLocation(this.c, "mPixelLocation");
    this.h = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
    a(this.d);
    this.j = true;
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    SLog.a("Q.qqstory.publish.edit GPUImagePixelationFilter", "onOutputSizeChanged width=%s, height=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.e = 0.0009259259F;
    this.f = 0.0005208334F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GPUImagePixelationFilter
 * JD-Core Version:    0.7.0.1
 */