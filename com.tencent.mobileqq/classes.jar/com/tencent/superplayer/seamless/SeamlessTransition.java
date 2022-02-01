package com.tencent.superplayer.seamless;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.superplayer.utils.LogUtil;

public class SeamlessTransition
{
  private static final int ANIM_DURATION = 300;
  private static final String TAG = "MediaPlayerMgr.SeamlessTransition";
  public int duration = 300;
  public int endHeight;
  public int endWidth;
  public int endX;
  public int endY;
  private AnimationSet mAnimationSet = new AnimationSet(true);
  public boolean needDoAnimInWindow = true;
  public int startHeight;
  public int startWidth;
  public int startX;
  public int startY;
  
  public SeamlessTransition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 300);
  }
  
  public SeamlessTransition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.startX = paramInt1;
    this.startY = paramInt2;
    this.endX = paramInt3;
    this.endY = paramInt4;
    this.startWidth = paramInt5;
    this.startHeight = paramInt6;
    this.endWidth = paramInt7;
    this.endHeight = paramInt8;
    this.duration = paramInt9;
  }
  
  public void doAnimation(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    LogUtil.d("MediaPlayerMgr.SeamlessTransition", "doAnimation startX:" + this.startX + " startY:" + this.startY + " endX:" + this.endX + " endY:" + this.endY + " y:" + paramView.getY());
    float f1 = this.startWidth / this.endWidth;
    float f2 = this.startHeight / this.endHeight;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.startX, this.endX, this.startY, this.endY);
    localTranslateAnimation.setDuration(this.duration);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(f1, 1.0F, f2, 1.0F, -1, 0.0F, -1, 0.0F);
    localScaleAnimation.setDuration(this.duration);
    this.mAnimationSet.addAnimation(localTranslateAnimation);
    this.mAnimationSet.addAnimation(localScaleAnimation);
    this.mAnimationSet.setFillAfter(false);
    this.mAnimationSet.setDuration(this.duration);
    this.mAnimationSet.setAnimationListener(paramAnimationListener);
    paramView.startAnimation(this.mAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SeamlessTransition
 * JD-Core Version:    0.7.0.1
 */