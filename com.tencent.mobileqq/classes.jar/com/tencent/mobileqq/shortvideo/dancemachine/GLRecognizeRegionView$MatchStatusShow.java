package com.tencent.mobileqq.shortvideo.dancemachine;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

public class GLRecognizeRegionView$MatchStatusShow
  implements Animation.AnimationListener
{
  AnimationSet backgroundAnimation;
  boolean haveBackgroundStop;
  boolean haveMongolianStop;
  boolean haveTypefaceStop;
  AnimationSet mongolianAnimation;
  int status;
  AnimationSet typefaceAnimation;
  
  GLRecognizeRegionView$MatchStatusShow()
  {
    resetStatus();
  }
  
  private AnimationSet getMatchedTypeAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(3.0F, 1.5F, 3.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setStartOffset(500L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setStartOffset(500L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  private AnimationSet getMissTypeAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(150L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(3.0F, 1.0F, 3.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setStartOffset(500L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setStartOffset(500L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  private AnimationSet getPerfectTypeAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(3.0F, 1.5F, 3.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setStartOffset(500L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.5F, 2.5F, 1.5F, 0.05F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setStartOffset(500L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  private AnimationSet getTypefaceAnimation()
  {
    this.typefaceAnimation = null;
    int i = this.status;
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        if (i == 3) {
          this.typefaceAnimation = getPerfectTypeAnimation();
        }
      }
      else {
        this.typefaceAnimation = getMatchedTypeAnimation();
      }
    }
    else {
      this.typefaceAnimation = null;
    }
    if (this.typefaceAnimation == null) {
      this.haveTypefaceStop = true;
    }
    return this.typefaceAnimation;
  }
  
  boolean checkHaveStopped()
  {
    return (this.haveMongolianStop) && (this.haveBackgroundStop) && (this.haveTypefaceStop);
  }
  
  String getAnimationLog()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" haveMongolianStop=");
    localStringBuilder.append(this.haveMongolianStop);
    localStringBuilder.append(" haveBackgroundStop=");
    localStringBuilder.append(this.haveBackgroundStop);
    localStringBuilder.append(" haveTypefaceStop=");
    localStringBuilder.append(this.haveTypefaceStop);
    return localStringBuilder.toString();
  }
  
  AnimationSet getBackGroundAnimation()
  {
    this.backgroundAnimation = null;
    int i = this.status;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.backgroundAnimation = newMongolianAnimation();
          }
        }
        else {
          this.backgroundAnimation = newMongolianAnimation();
        }
      }
      else {
        this.backgroundAnimation = newMongolianAnimation();
      }
    }
    else {
      this.backgroundAnimation = getMissTypeAnimation();
    }
    if (this.backgroundAnimation == null) {
      this.haveBackgroundStop = true;
    }
    return this.backgroundAnimation;
  }
  
  String getMessageStatus()
  {
    int i = this.status;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return "unKnown";
          }
          return "PERFECT";
        }
        return "GREAT";
      }
      return "GOOD";
    }
    return "MISS";
  }
  
  AnimationSet getMongolianAnimation()
  {
    this.mongolianAnimation = newMongolianAnimation();
    return this.mongolianAnimation;
  }
  
  AnimationSet newMongolianAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(100L);
    localAlphaAnimation.setStartOffset(500L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(false);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.mongolianAnimation == paramAnimation)
    {
      this.haveMongolianStop = true;
      return;
    }
    if (this.backgroundAnimation == paramAnimation)
    {
      this.haveBackgroundStop = true;
      return;
    }
    if (this.typefaceAnimation == paramAnimation) {
      this.haveTypefaceStop = true;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  void resetStatus()
  {
    this.mongolianAnimation = null;
    this.backgroundAnimation = null;
    this.typefaceAnimation = null;
    this.haveMongolianStop = false;
    this.haveBackgroundStop = false;
    this.haveTypefaceStop = false;
  }
  
  void setHaveStopped()
  {
    this.haveMongolianStop = true;
    this.haveBackgroundStop = true;
    this.haveTypefaceStop = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView.MatchStatusShow
 * JD-Core Version:    0.7.0.1
 */