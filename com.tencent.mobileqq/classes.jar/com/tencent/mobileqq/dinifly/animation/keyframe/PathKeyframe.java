package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;

public class PathKeyframe
  extends Keyframe<PointF>
{
  @Nullable
  private Path path;
  private final Keyframe<PointF> pointKeyFrame;
  
  public PathKeyframe(LottieComposition paramLottieComposition, Keyframe<PointF> paramKeyframe)
  {
    super(paramLottieComposition, paramKeyframe.startValue, paramKeyframe.endValue, paramKeyframe.interpolator, paramKeyframe.startFrame, paramKeyframe.endFrame);
    this.pointKeyFrame = paramKeyframe;
    createPath();
  }
  
  public void createPath()
  {
    if ((this.endValue != null) && (this.startValue != null) && (((PointF)this.startValue).equals(((PointF)this.endValue).x, ((PointF)this.endValue).y))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.endValue != null) && (i == 0) && (this.startValue != null)) {
        this.path = Utils.createPath((PointF)this.startValue, (PointF)this.endValue, this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
      }
      return;
    }
  }
  
  @Nullable
  Path getPath()
  {
    return this.path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe
 * JD-Core Version:    0.7.0.1
 */