package com.tencent.mobileqq.kandian.base.view.widget;

import android.graphics.drawable.Drawable;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

public class ReadinjoyRotate3dAnimation
  extends Rotate3dAnimation
{
  private final float a;
  private final float b;
  private ImageView c;
  private Drawable d;
  private Drawable e;
  private int f;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    float f1 = this.a;
    paramFloat = f1 + (this.b - f1) * paramFloat;
    paramTransformation = this.c;
    if ((paramTransformation != null) && (this.d != null))
    {
      Drawable localDrawable = this.e;
      if (localDrawable != null) {
        if ((paramFloat > 90.0F) && (paramFloat < 270.0F))
        {
          if (this.f != 1)
          {
            paramTransformation.setImageDrawable(localDrawable);
            this.f = 1;
          }
        }
        else if (this.f != 0)
        {
          this.c.setImageDrawable(this.d);
          this.f = 0;
        }
      }
    }
  }
  
  public void cancel()
  {
    super.cancel();
    this.c = null;
    this.d = null;
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadinjoyRotate3dAnimation
 * JD-Core Version:    0.7.0.1
 */