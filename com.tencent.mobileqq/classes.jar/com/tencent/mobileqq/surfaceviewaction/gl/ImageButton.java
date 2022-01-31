package com.tencent.mobileqq.surfaceviewaction.gl;

import ailh;
import android.graphics.Bitmap;
import android.view.MotionEvent;

public class ImageButton
  extends Sprite
  implements ailh
{
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean c;
  
  public ImageButton(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    this.c = paramBoolean;
  }
  
  public ImageButton(SpriteGLView paramSpriteGLView, boolean paramBoolean)
  {
    super(paramSpriteGLView);
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
    paramMotionEvent = a();
    float f1 = a();
    float f5 = (paramMotionEvent.a - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.e / 2.0F) * f1;
    float f6 = (paramMotionEvent.a + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.e / 2.0F) * f1;
    float f2;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b)
    {
      f2 = paramInt2 - (paramMotionEvent.b + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f1;
      f1 = paramInt2 - (paramMotionEvent.b - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f1;
      if (paramInt1 != 0) {
        break label316;
      }
      if ((f3 <= f5) || (f3 >= f6) || (f4 <= f2) || (f4 >= f1)) {
        break label294;
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.c) {
        this.b = 128;
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      f2 = (paramMotionEvent.b - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f1;
      f1 = (paramMotionEvent.b + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f1;
      break;
      label294:
      this.jdField_a_of_type_Boolean = false;
      if (this.c) {
        this.b = 255;
      }
    }
    label316:
    if ((paramInt1 == 1) || (paramInt1 == 3))
    {
      if ((f3 > f5) && (f3 < f6) && (f4 > f2) && (f4 < f1) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener.a(this);
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.c) {
        this.b = 255;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.ImageButton
 * JD-Core Version:    0.7.0.1
 */