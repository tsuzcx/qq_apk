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
  private final PathMeasure pathMeasure = new PathMeasure();
  private PathKeyframe pathMeasureKeyframe;
  private final PointF point = new PointF();
  private final float[] pos = new float[2];
  
  public PathKeyframeAnimation(List<? extends Keyframe<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF getValue(Keyframe<PointF> paramKeyframe, float paramFloat)
  {
    Object localObject = (PathKeyframe)paramKeyframe;
    Path localPath = ((PathKeyframe)localObject).getPath();
    if (localPath == null) {
      return (PointF)paramKeyframe.startValue;
    }
    if (this.valueCallback != null)
    {
      paramKeyframe = (PointF)this.valueCallback.getValueInternal(((PathKeyframe)localObject).startFrame, ((PathKeyframe)localObject).endFrame.floatValue(), ((PathKeyframe)localObject).startValue, ((PathKeyframe)localObject).endValue, getLinearCurrentKeyframeProgress(), paramFloat, getProgress());
      if (paramKeyframe != null) {
        return paramKeyframe;
      }
    }
    if (this.pathMeasureKeyframe != localObject)
    {
      this.pathMeasure.setPath(localPath, false);
      this.pathMeasureKeyframe = ((PathKeyframe)localObject);
    }
    paramKeyframe = this.pathMeasure;
    paramKeyframe.getPosTan(paramFloat * paramKeyframe.getLength(), this.pos, null);
    paramKeyframe = this.point;
    localObject = this.pos;
    paramKeyframe.set(localObject[0], localObject[1]);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */