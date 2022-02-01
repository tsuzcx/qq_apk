package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
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
    super(paramLottieComposition, paramKeyframe.startValue, paramKeyframe.endValue, paramKeyframe.interpolator, paramKeyframe.xInterpolator, paramKeyframe.yInterpolator, paramKeyframe.startFrame, paramKeyframe.endFrame);
    this.pointKeyFrame = paramKeyframe;
    createPath();
  }
  
  public void createPath()
  {
    int i;
    if ((this.endValue != null) && (this.startValue != null) && (((PointF)this.startValue).equals(((PointF)this.endValue).x, ((PointF)this.endValue).y))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.startValue != null) && (this.endValue != null) && (i == 0)) {
      this.path = Utils.createPath((PointF)this.startValue, (PointF)this.endValue, this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
    }
  }
  
  @Nullable
  Path getPath()
  {
    return this.path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe
 * JD-Core Version:    0.7.0.1
 */