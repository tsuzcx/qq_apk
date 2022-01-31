package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.Path;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ShapeKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import com.tencent.mobileqq.dinifly.model.content.ShapeData.Factory;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.List;
import org.json.JSONObject;

public class AnimatableShapeValue
  extends BaseAnimatableValue<ShapeData, Path>
{
  private final Path convertTypePath = new Path();
  
  private AnimatableShapeValue(List<Keyframe<ShapeData>> paramList, ShapeData paramShapeData)
  {
    super(paramList, paramShapeData);
  }
  
  Path convertType(ShapeData paramShapeData)
  {
    this.convertTypePath.reset();
    MiscUtils.getPathFromData(paramShapeData, this.convertTypePath);
    return this.convertTypePath;
  }
  
  public BaseKeyframeAnimation<ShapeData, Path> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(convertType((ShapeData)this.initialValue));
    }
    return new ShapeKeyframeAnimation(this.keyframes);
  }
  
  public static final class Factory
  {
    public static AnimatableShapeValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, paramLottieComposition.getDpScale(), paramLottieComposition, ShapeData.Factory.INSTANCE).parseJson();
      return new AnimatableShapeValue(paramJSONObject.keyframes, (ShapeData)paramJSONObject.initialValue, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue
 * JD-Core Version:    0.7.0.1
 */