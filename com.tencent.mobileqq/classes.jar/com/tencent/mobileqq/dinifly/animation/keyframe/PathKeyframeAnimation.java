package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

public class PathKeyframeAnimation
  extends KeyframeAnimation<PointF>
{
  private PathMeasure pathMeasure = new PathMeasure();
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
      paramKeyframe = (PointF)paramKeyframe.startValue;
    }
    PointF localPointF;
    do
    {
      return paramKeyframe;
      if (this.valueCallback == null) {
        break;
      }
      localPointF = (PointF)this.valueCallback.getValueInternal(localPathKeyframe.startFrame, localPathKeyframe.endFrame.floatValue(), localPathKeyframe.startValue, localPathKeyframe.endValue, getLinearCurrentKeyframeProgress(), paramFloat, getProgress());
      paramKeyframe = localPointF;
    } while (localPointF != null);
    if (this.pathMeasureKeyframe != localPathKeyframe)
    {
      this.pathMeasure.setPath(localPath, false);
      this.pathMeasureKeyframe = localPathKeyframe;
    }
    this.pathMeasure.getPosTan(this.pathMeasure.getLength() * paramFloat, this.pos, null);
    this.point.set(this.pos[0], this.pos[1]);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */