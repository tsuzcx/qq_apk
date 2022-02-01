package com.tencent.mobileqq.ptt;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class LSRecordAnimations$ChangeBgAndScaleAnimation
  extends ScaleAnimation
{
  private GradientDrawable a;
  private int b;
  private int c;
  private float d;
  private float e;
  private LSRecordAnimations.TrackInfo f;
  private Animation.AnimationListener g;
  
  public LSRecordAnimations$ChangeBgAndScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, float paramFloat5, int paramInt2, float paramFloat6, LSRecordAnimations.TrackInfo paramTrackInfo)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramFloat5, paramInt2, paramFloat6);
    this.d = paramFloat1;
    this.e = (paramFloat2 - paramFloat1);
    this.f = paramTrackInfo;
  }
  
  public void a(GradientDrawable paramGradientDrawable, int paramInt1, int paramInt2)
  {
    this.a = paramGradientDrawable;
    this.b = paramInt1;
    this.c = paramInt2;
    if (QLog.isDevelopLevel())
    {
      paramGradientDrawable = new StringBuilder();
      paramGradientDrawable.append("LS setColorChanger: ");
      paramGradientDrawable.append(paramInt1);
      paramGradientDrawable.append(" --> ");
      paramGradientDrawable.append(paramInt2);
      QLog.d("LsRecord", 4, paramGradientDrawable.toString());
    }
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.g;
    if ((paramTransformation != null) && ((paramTransformation instanceof LSRecordAnimations.LSRecordAnimationCallback))) {
      ((LSRecordAnimations.LSRecordAnimationCallback)paramTransformation).a(this, paramFloat);
    }
    this.f.a = (this.d + this.e * paramFloat);
    if (QLog.isDevelopLevel())
    {
      paramTransformation = new StringBuilder();
      paramTransformation.append("LS applyTransformation: ");
      paramTransformation.append(paramFloat);
      paramTransformation.append(" F: ");
      paramTransformation.append(this.f.a);
      QLog.d("LsRecord", 4, paramTransformation.toString());
    }
    paramTransformation = this.a;
    if (paramTransformation != null)
    {
      int i = this.c;
      if (paramFloat < 1.0F)
      {
        i = Color.argb((int)(Color.alpha(this.b) + (Color.alpha(this.c) - Color.alpha(this.b)) * paramFloat), (int)(Color.red(this.b) + (Color.red(this.c) - Color.red(this.b)) * paramFloat), (int)(Color.green(this.b) + (Color.green(this.c) - Color.green(this.b)) * paramFloat), (int)(Color.blue(this.b) + (Color.blue(this.c) - Color.blue(this.b)) * paramFloat));
        this.a.setColor(i);
      }
      else
      {
        paramTransformation.setColor(i);
        this.a = null;
      }
      this.f.b = i;
    }
    if (QLog.isDevelopLevel())
    {
      paramTransformation = new StringBuilder();
      paramTransformation.append("LS applyTransformation: ");
      paramTransformation.append(paramFloat);
      paramTransformation.append(" CLR: ");
      paramTransformation.append(this.f.b);
      QLog.d("LsRecord", 4, paramTransformation.toString());
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    super.setAnimationListener(paramAnimationListener);
    this.g = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordAnimations.ChangeBgAndScaleAnimation
 * JD-Core Version:    0.7.0.1
 */