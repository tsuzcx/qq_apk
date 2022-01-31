package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import java.util.List;

public class PathKeyframeAnimation
  extends KeyframeAnimation<PointF>
{
  private PathMeasure pathMeasure;
  private PathKeyframe pathMeasureKeyframe;
  private final PointF point = new PointF();
  private final float[] pos = new float[2];
  
  public PathKeyframeAnimation(List<? extends Keyframe<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF getValue(Keyframe<PointF> paramKeyframe, float paramFloat)
  {
    PathKeyframe localPathKeyframe = (PathKeyframe)paramKeyframe;
    Path localPath = localPathKeyframe.getPath();
    if (localPath == null) {
      return (PointF)paramKeyframe.startValue;
    }
    if (this.pathMeasureKeyframe != localPathKeyframe)
    {
      this.pathMeasure = new PathMeasure(localPath, false);
      this.pathMeasureKeyframe = localPathKeyframe;
    }
    this.pathMeasure.getPosTan(this.pathMeasure.getLength() * paramFloat, this.pos, null);
    this.point.set(this.pos[0], this.pos[1]);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */