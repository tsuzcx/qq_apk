package com.tencent.mobileqq.surfaceviewaction.nv;

import android.graphics.Bitmap;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.Point;

public class Sprite
  extends Node
  implements ISprite<SpriteNativeView>
{
  private Bitmap s;
  protected ImageView v;
  
  public Sprite(SpriteNativeView paramSpriteNativeView)
  {
    this.t = paramSpriteNativeView;
    this.v = dt_();
  }
  
  public void a(SpriteNativeView paramSpriteNativeView, Bitmap paramBitmap)
  {
    this.s = paramBitmap;
    paramSpriteNativeView = new FrameLayout.LayoutParams(this.s.getWidth(), this.s.getHeight());
    this.v.setImageBitmap(this.s);
    this.v.setLayoutParams(paramSpriteNativeView);
    this.v.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.v.setPivotX(this.s.getWidth() / 2);
    this.v.setPivotY(this.s.getHeight() / 2);
  }
  
  protected ImageView dt_()
  {
    return new ImageView(this.t.getContext());
  }
  
  public boolean k()
  {
    if (this.v.getVisibility() != 0) {
      this.v.setVisibility(0);
    }
    boolean bool = super.k();
    if (this.s != null)
    {
      a(this.u);
      float f1 = this.u.a;
      float f2 = d();
      float f3 = this.s.getWidth() / 2;
      float f4 = this.r;
      float f5 = this.u.b;
      float f6 = d();
      float f7 = this.s.getHeight() / 2;
      this.v.setX(f1 * f2 - f3);
      this.v.setY(f4 - f5 * f6 - f7);
    }
    this.v.setScaleX(this.f * d());
    this.v.setScaleY(this.f * d());
    this.v.setRotation(this.h);
    this.v.setAlpha(this.i * (e() / 255.0F) / 255.0F);
    return bool;
  }
  
  public void l()
  {
    this.t.addView(this.v);
    this.v.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.Sprite
 * JD-Core Version:    0.7.0.1
 */