package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.io.IOException;

public class GPUImagePixelationFilter
  extends GPUDrawPartFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.a(BaseApplicationImpl.getContext(), 2131230756);
  private float jdField_a_of_type_Float = 30.0F;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  private int e;
  private int f;
  private int g;
  private int h = -1;
  private int i;
  
  public GPUImagePixelationFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.jdField_c_of_type_Int = 3553;
    this.d = 106;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    SLog.a("Q.qqstory.publish.edit GPUImagePixelationFilter", "onOutputSizeChanged width=%s, height=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_b_of_type_Float = 0.0009259259F;
    this.jdField_c_of_type_Float = 0.0005208334F;
  }
  
  public void a(Bitmap paramBitmap)
  {
    a(paramBitmap, 0);
  }
  
  public void a(@NonNull Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 180))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(360 - paramInt);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF1 = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF2 = new RectF();
      localMatrix.mapRect(localRectF2, localRectF1);
      localCanvas.translate(-localRectF2.left, -localRectF2.top);
      localCanvas.concat(localMatrix);
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localCanvas.drawBitmap(paramBitmap, localRect, localRectF1, new Paint());
      localCanvas.setBitmap(null);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.a(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      SLog.c("Q.qqstory.publish.edit GPUImagePixelationFilter", "setMosaicPath OutOfMemoryError", paramString);
    }
  }
  
  public void c()
  {
    super.c();
    this.e = GLES20.glGetUniformLocation(a(), "imageWidthFactor");
    a(this.e, "imageWidthFactor");
    this.f = GLES20.glGetUniformLocation(a(), "imageHeightFactor");
    a(this.f, "imageHeightFactor");
    this.g = GLES20.glGetUniformLocation(a(), "pixel");
    a(this.g, "mPixelLocation");
    this.i = GLES20.glGetUniformLocation(a(), "sTexture2");
    a(this.jdField_a_of_type_Float);
  }
  
  protected void e()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      SLog.b("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap recycle");
    }
    if (this.h != -1) {
      GlUtil.a(this.h);
    }
  }
  
  protected void f()
  {
    super.f();
    GLES20.glUniform1f(this.e, this.jdField_b_of_type_Float);
    GLES20.glUniform1f(this.f, this.jdField_c_of_type_Float);
    GLES20.glUniform1f(this.g, this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      SLog.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.h == -1) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        SLog.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap is recycled");
        return;
      }
      if (this.h != -1) {
        GlUtil.a(this.h);
      }
      this.h = GlUtil.a(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
    }
    GLES20.glBindTexture(3553, this.h);
    GLES20.glUniform1i(this.i, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter
 * JD-Core Version:    0.7.0.1
 */