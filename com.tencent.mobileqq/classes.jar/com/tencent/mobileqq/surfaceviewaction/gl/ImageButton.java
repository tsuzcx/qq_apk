package com.tencent.mobileqq.surfaceviewaction.gl;

import aiqc;
import android.graphics.Bitmap;
import android.view.MotionEvent;

public class ImageButton
  extends Sprite
  implements aiqc
{
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private Point b;
  private boolean c;
  
  public ImageButton(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint = new Point(0.0F, 0.0F);
    this.c = paramBoolean;
  }
  
  public ImageButton(SpriteGLView paramSpriteGLView, boolean paramBoolean)
  {
    super(paramSpriteGLView);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint = new Point(0.0F, 0.0F);
    this.c = paramBoolean;
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = paramOnClickListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a == null)) {
      return false;
    }
    paramInt1 = paramMotionEvent.getAction();
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint);
    float f1 = a();
    float f5 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint.a - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.e / 2.0F) * f1;
    float f6 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint.a + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.e / 2.0F) * f1;
    float f2;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b)
    {
      f2 = paramInt2 - (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint.b + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f1;
      f1 = paramInt2 - f1 * (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint.b - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F);
      if (paramInt1 != 0) {
        break label337;
      }
      if ((f3 <= f5) || (f3 >= f6) || (f4 <= f2) || (f4 >= f1)) {
        break label315;
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.c) {
        this.jdField_b_of_type_Int = 128;
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      f2 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint.b - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f1;
      f1 *= (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlPoint.b + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F);
      break;
      label315:
      this.jdField_a_of_type_Boolean = false;
      if (this.c) {
        this.jdField_b_of_type_Int = 255;
      }
    }
    label337:
    if ((paramInt1 == 1) || (paramInt1 == 3))
    {
      if ((f3 > f5) && (f3 < f6) && (f4 > f2) && (f4 < f1) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener.a(this);
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.c) {
        this.jdField_b_of_type_Int = 255;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.ImageButton
 * JD-Core Version:    0.7.0.1
 */