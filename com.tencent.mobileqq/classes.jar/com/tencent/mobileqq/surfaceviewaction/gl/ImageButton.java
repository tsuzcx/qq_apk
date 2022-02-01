package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.IImageButton;
import com.tencent.mobileqq.surfaceviewaction.Point;

public class ImageButton
  extends Sprite
  implements IImageButton, Node.Clickable
{
  private ImageButton.OnClickListener a;
  private Point jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint = new Point(0.0F, 0.0F);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public ImageButton(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    this.c = paramBoolean;
  }
  
  public ImageButton(SpriteGLView paramSpriteGLView, boolean paramBoolean, String paramString)
  {
    super(paramSpriteGLView);
    this.c = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = paramOnClickListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a == null) {
        return false;
      }
      paramInt1 = paramMotionEvent.getAction();
      float f3 = paramMotionEvent.getX();
      float f4 = paramMotionEvent.getY();
      a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint);
      float f2 = b();
      float f5 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.a - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.e / 2.0F) * f2;
      float f6 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.a + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.e / 2.0F) * f2;
      float f1;
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_b_of_type_Boolean)
      {
        float f7 = paramInt2;
        f1 = f7 - (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.b + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f2;
        f2 = f7 - (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.b - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f2;
      }
      else
      {
        f1 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.b - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f2;
        f2 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.b + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.e / 2.0F) * f2;
      }
      if (paramInt1 == 0)
      {
        if ((f3 > f5) && (f3 < f6) && (f4 > f1) && (f4 < f2))
        {
          this.jdField_b_of_type_Boolean = true;
          if (this.c) {
            this.jdField_a_of_type_Int = 128;
          }
        }
        else
        {
          this.jdField_b_of_type_Boolean = false;
          if (this.c) {
            this.jdField_a_of_type_Int = 255;
          }
        }
        return this.jdField_b_of_type_Boolean;
      }
      if ((paramInt1 == 1) || (paramInt1 == 3))
      {
        this.jdField_b_of_type_Boolean = false;
        if (this.c) {
          this.jdField_a_of_type_Int = 255;
        }
        if ((f3 > f5) && (f3 < f6) && (f4 > f1) && (f4 < f2))
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(this);
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.ImageButton
 * JD-Core Version:    0.7.0.1
 */