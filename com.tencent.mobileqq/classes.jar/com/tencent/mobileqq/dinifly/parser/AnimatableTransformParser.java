package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableScaleValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableSplitDimensionPathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.ScaleXY;
import java.util.List;

public class AnimatableTransformParser
{
  private static final JsonReader.Options ANIMATABLE_NAMES = JsonReader.Options.of(new String[] { "k" });
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa" });
  
  private static boolean isAnchorPointIdentity(AnimatablePathValue paramAnimatablePathValue)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAnimatablePathValue != null)
    {
      bool1 = bool2;
      if (paramAnimatablePathValue.isStatic())
      {
        bool1 = bool2;
        if (!((PointF)((Keyframe)paramAnimatablePathValue.getKeyframes().get(0)).startValue).equals(0.0F, 0.0F)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> paramAnimatableValue)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAnimatableValue != null)
    {
      bool1 = bool2;
      if (!(paramAnimatableValue instanceof AnimatableSplitDimensionPathValue))
      {
        bool1 = bool2;
        if (paramAnimatableValue.isStatic())
        {
          bool1 = bool2;
          if (!((PointF)((Keyframe)paramAnimatableValue.getKeyframes().get(0)).startValue).equals(0.0F, 0.0F)) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isRotationIdentity(AnimatableFloatValue paramAnimatableFloatValue)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAnimatableFloatValue != null)
    {
      bool1 = bool2;
      if (paramAnimatableFloatValue.isStatic())
      {
        bool1 = bool2;
        if (((Float)((Keyframe)paramAnimatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0F) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isScaleIdentity(AnimatableScaleValue paramAnimatableScaleValue)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAnimatableScaleValue != null)
    {
      bool1 = bool2;
      if (paramAnimatableScaleValue.isStatic())
      {
        bool1 = bool2;
        if (!((ScaleXY)((Keyframe)paramAnimatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0F, 1.0F)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isSkewAngleIdentity(AnimatableFloatValue paramAnimatableFloatValue)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAnimatableFloatValue != null)
    {
      bool1 = bool2;
      if (paramAnimatableFloatValue.isStatic())
      {
        bool1 = bool2;
        if (((Float)((Keyframe)paramAnimatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0F) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isSkewIdentity(AnimatableFloatValue paramAnimatableFloatValue)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAnimatableFloatValue != null)
    {
      bool1 = bool2;
      if (paramAnimatableFloatValue.isStatic())
      {
        bool1 = bool2;
        if (((Float)((Keyframe)paramAnimatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0F) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static AnimatableTransform parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    int i;
    if (paramJsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJsonReader.beginObject();
    }
    Object localObject2 = null;
    Object localObject1 = null;
    AnimatableValue localAnimatableValue = null;
    AnimatableScaleValue localAnimatableScaleValue = null;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    AnimatableFloatValue localAnimatableFloatValue4 = null;
    AnimatableFloatValue localAnimatableFloatValue3 = null;
    if (paramJsonReader.hasNext())
    {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
      }
      for (;;)
      {
        break;
        localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
        localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
        localAnimatableFloatValue3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
        localAnimatableFloatValue4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
        localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
        paramLottieComposition.addWarning("Lottie doesn't support 3D layers.");
        localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        if (((AnimatableFloatValue)localObject2).getKeyframes().isEmpty()) {
          ((AnimatableFloatValue)localObject2).getKeyframes().add(new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramLottieComposition.getEndFrame())));
        } else if (((Keyframe)((AnimatableFloatValue)localObject2).getKeyframes().get(0)).startValue == null) {
          ((AnimatableFloatValue)localObject2).getKeyframes().set(0, new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramLottieComposition.getEndFrame())));
        }
        continue;
        localAnimatableScaleValue = AnimatableValueParser.parseScale(paramJsonReader, paramLottieComposition);
        continue;
        localAnimatableValue = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
        continue;
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext()) {
          if (paramJsonReader.selectName(ANIMATABLE_NAMES) != 0)
          {
            paramJsonReader.skipName();
            paramJsonReader.skipValue();
          }
          else
          {
            localObject1 = AnimatablePathValueParser.parse(paramJsonReader, paramLottieComposition);
          }
        }
        paramJsonReader.endObject();
      }
    }
    if (i != 0) {
      paramJsonReader.endObject();
    }
    if (isAnchorPointIdentity((AnimatablePathValue)localObject1)) {
      paramJsonReader = null;
    } else {
      paramJsonReader = (JsonReader)localObject1;
    }
    if (isPositionIdentity(localAnimatableValue)) {
      paramLottieComposition = null;
    } else {
      paramLottieComposition = localAnimatableValue;
    }
    if (isRotationIdentity((AnimatableFloatValue)localObject2)) {
      localObject1 = null;
    } else {
      localObject1 = localObject2;
    }
    localObject2 = localAnimatableScaleValue;
    if (isScaleIdentity(localAnimatableScaleValue)) {
      localObject2 = null;
    }
    if (isSkewIdentity(localAnimatableFloatValue2)) {
      localAnimatableFloatValue2 = null;
    }
    if (isSkewAngleIdentity(localAnimatableFloatValue1)) {
      localAnimatableFloatValue1 = null;
    }
    return new AnimatableTransform(paramJsonReader, paramLottieComposition, (AnimatableScaleValue)localObject2, (AnimatableFloatValue)localObject1, localAnimatableIntegerValue, localAnimatableFloatValue4, localAnimatableFloatValue3, localAnimatableFloatValue2, localAnimatableFloatValue1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatableTransformParser
 * JD-Core Version:    0.7.0.1
 */