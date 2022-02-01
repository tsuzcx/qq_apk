package com.tencent.mobileqq.ptt;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class LSRecordAnimations$ChangeBgColorAnimation
  extends Animation
{
  private View a;
  private int b;
  private int c;
  private LSRecordAnimations.TrackInfo d;
  private Animation.AnimationListener e;
  
  public LSRecordAnimations$ChangeBgColorAnimation(View paramView, int paramInt1, int paramInt2, LSRecordAnimations.TrackInfo paramTrackInfo)
  {
    this.a = paramView;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramTrackInfo;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.e;
    if ((paramTransformation != null) && ((paramTransformation instanceof LSRecordAnimations.LSRecordAnimationCallback))) {
      ((LSRecordAnimations.LSRecordAnimationCallback)paramTransformation).a(this, paramFloat);
    }
    paramTransformation = this.a;
    if (paramTransformation == null) {
      return;
    }
    int i = this.c;
    if (paramFloat < 1.0F)
    {
      i = Color.argb((int)(Color.alpha(this.b) + (Color.alpha(this.c) - Color.alpha(this.b)) * paramFloat), (int)(Color.red(this.b) + (Color.red(this.c) - Color.red(this.b)) * paramFloat), (int)(Color.green(this.b) + (Color.green(this.c) - Color.green(this.b)) * paramFloat), (int)(Color.blue(this.b) + (Color.blue(this.c) - Color.blue(this.b)) * paramFloat));
      this.a.setBackgroundColor(i);
    }
    else
    {
      paramTransformation.setBackgroundColor(i);
      this.a = null;
    }
    paramTransformation = this.d;
    if (paramTransformation != null) {
      paramTransformation.b = i;
    }
    if (QLog.isDevelopLevel())
    {
      paramTransformation = new StringBuilder();
      paramTransformation.append("LS applyTransformation: ");
      paramTransformation.append(paramFloat);
      paramTransformation.append(" CLR: ");
      paramTransformation.append(i);
      QLog.d("LsRecord", 4, paramTransformation.toString());
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    super.setAnimationListener(paramAnimationListener);
    this.e = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordAnimations.ChangeBgColorAnimation
 * JD-Core Version:    0.7.0.1
 */