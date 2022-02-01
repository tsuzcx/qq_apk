package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.IImageButton;
import com.tencent.mobileqq.surfaceviewaction.Point;

public class ImageButton
  extends Sprite
  implements IImageButton, Node.Clickable
{
  private Point E = new Point(0.0F, 0.0F);
  private String F;
  private boolean s = false;
  private ImageButton.OnClickListener t;
  private boolean u = false;
  
  public ImageButton(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    this.u = paramBoolean;
  }
  
  public ImageButton(SpriteGLView paramSpriteGLView, boolean paramBoolean, String paramString)
  {
    super(paramSpriteGLView);
    this.u = paramBoolean;
    this.F = paramString;
  }
  
  public String a()
  {
    return this.F;
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    this.t = paramOnClickListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if (this.w != null)
    {
      if (this.w.b == null) {
        return false;
      }
      paramInt1 = paramMotionEvent.getAction();
      float f3 = paramMotionEvent.getX();
      float f4 = paramMotionEvent.getY();
      a(this.E);
      float f2 = d();
      float f5 = (this.E.a - this.w.b.getWidth() * this.f / 2.0F) * f2;
      float f6 = (this.E.a + this.w.b.getWidth() * this.f / 2.0F) * f2;
      float f1;
      if (this.v.v)
      {
        float f7 = paramInt2;
        f1 = f7 - (this.E.b + this.w.b.getHeight() * this.f / 2.0F) * f2;
        f2 = f7 - (this.E.b - this.w.b.getHeight() * this.f / 2.0F) * f2;
      }
      else
      {
        f1 = (this.E.b - this.w.b.getHeight() * this.f / 2.0F) * f2;
        f2 = (this.E.b + this.w.b.getHeight() * this.f / 2.0F) * f2;
      }
      if (paramInt1 == 0)
      {
        if ((f3 > f5) && (f3 < f6) && (f4 > f1) && (f4 < f2))
        {
          this.s = true;
          if (this.u) {
            this.i = 128;
          }
        }
        else
        {
          this.s = false;
          if (this.u) {
            this.i = 255;
          }
        }
        return this.s;
      }
      if ((paramInt1 == 1) || (paramInt1 == 3))
      {
        this.s = false;
        if (this.u) {
          this.i = 255;
        }
        if ((f3 > f5) && (f3 < f6) && (f4 > f1) && (f4 < f2))
        {
          paramMotionEvent = this.t;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.ImageButton
 * JD-Core Version:    0.7.0.1
 */