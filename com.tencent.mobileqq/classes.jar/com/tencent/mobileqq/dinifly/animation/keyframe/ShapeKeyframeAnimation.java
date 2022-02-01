package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Path;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation
  extends BaseKeyframeAnimation<ShapeData, Path>
{
  private final Path tempPath = new Path();
  private final ShapeData tempShapeData = new ShapeData();
  
  public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> paramList)
  {
    super(paramList);
  }
  
  public Path getValue(Keyframe<ShapeData> paramKeyframe, float paramFloat)
  {
    ShapeData localShapeData = (ShapeData)paramKeyframe.startValue;
    paramKeyframe = (ShapeData)paramKeyframe.endValue;
    this.tempShapeData.interpolateBetween(localShapeData, paramKeyframe, paramFloat);
    MiscUtils.getPathFromData(this.tempShapeData, this.tempPath);
    return this.tempPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.ShapeKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */