package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;

public class Label
  extends Sprite
{
  private int jdField_a_of_type_Int = 20;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private String b = "";
  private int c = -1;
  
  public Label(SpriteGLView paramSpriteGLView, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    a(paramInt1);
    b(paramInt2);
    a(paramSpriteGLView, paramString);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
  }
  
  public void a(SpriteGLView paramSpriteGLView, String paramString)
  {
    if (paramString.equals(this.b)) {
      return;
    }
    this.b = paramString;
    paramString = Bitmap.createBitmap((int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString), this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramString);
    localCanvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
    localCanvas.drawText(this.b, 0.0F, this.jdField_a_of_type_Int * 0.8F, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(paramSpriteGLView, paramString);
    g();
    f();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Label
 * JD-Core Version:    0.7.0.1
 */