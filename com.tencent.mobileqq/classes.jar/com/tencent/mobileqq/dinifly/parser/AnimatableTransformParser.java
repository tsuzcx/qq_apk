package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableScaleValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableSplitDimensionPathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.ScaleXY;
import java.util.List;

public class AnimatableTransformParser
{
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
    int j;
    if (paramJsonReader.peek() == JsonToken.BEGIN_OBJECT) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      paramJsonReader.beginObject();
    }
    AnimatableFloatValue localAnimatableFloatValue3 = null;
    AnimatablePathValue localAnimatablePathValue = null;
    AnimatableValue localAnimatableValue = null;
    AnimatableScaleValue localAnimatableScaleValue = null;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    AnimatableFloatValue localAnimatableFloatValue5 = null;
    AnimatableFloatValue localAnimatableFloatValue4 = null;
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = str.hashCode();
      if (i != 97)
      {
        if (i != 3242)
        {
          if (i != 3656)
          {
            if (i != 3662)
            {
              if (i != 3672)
              {
                if (i != 3676)
                {
                  if (i != 111)
                  {
                    if (i != 112)
                    {
                      if (i != 114)
                      {
                        if ((i == 115) && (str.equals("s")))
                        {
                          i = 2;
                          break label295;
                        }
                      }
                      else if (str.equals("r"))
                      {
                        i = 4;
                        break label295;
                      }
                    }
                    else if (str.equals("p"))
                    {
                      i = 1;
                      break label295;
                    }
                  }
                  else if (str.equals("o"))
                  {
                    i = 5;
                    break label295;
                  }
                }
                else if (str.equals("so"))
                {
                  i = 6;
                  break label295;
                }
              }
              else if (str.equals("sk"))
              {
                i = 8;
                break label295;
              }
            }
            else if (str.equals("sa"))
            {
              i = 9;
              break label295;
            }
          }
          else if (str.equals("rz"))
          {
            i = 3;
            break label295;
          }
        }
        else if (str.equals("eo"))
        {
          i = 7;
          break label295;
        }
      }
      else if (str.equals("a"))
      {
        i = 0;
        break label295;
      }
      i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 9: 
        localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 8: 
        localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 7: 
        localAnimatableFloatValue4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 6: 
        localAnimatableFloatValue5 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 5: 
        localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
      case 3: 
        paramLottieComposition.addWarning("Lottie doesn't support 3D layers.");
      case 4: 
        localAnimatableFloatValue3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        if (localAnimatableFloatValue3.getKeyframes().isEmpty()) {
          localAnimatableFloatValue3.getKeyframes().add(new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramLottieComposition.getEndFrame())));
        } else if (((Keyframe)localAnimatableFloatValue3.getKeyframes().get(0)).startValue == null) {
          localAnimatableFloatValue3.getKeyframes().set(0, new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramLottieComposition.getEndFrame())));
        }
        break;
      case 2: 
        localAnimatableScaleValue = AnimatableValueParser.parseScale(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        localAnimatableValue = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
        break;
      case 0: 
        label295:
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext()) {
          if (paramJsonReader.nextName().equals("k")) {
            localAnimatablePathValue = AnimatablePathValueParser.parse(paramJsonReader, paramLottieComposition);
          } else {
            paramJsonReader.skipValue();
          }
        }
        paramJsonReader.endObject();
      }
    }
    if (j != 0) {
      paramJsonReader.endObject();
    }
    paramJsonReader = localAnimatablePathValue;
    if (isAnchorPointIdentity(localAnimatablePathValue)) {
      paramJsonReader = null;
    }
    if (isPositionIdentity(localAnimatableValue)) {
      paramLottieComposition = null;
    } else {
      paramLottieComposition = localAnimatableValue;
    }
    if (isRotationIdentity(localAnimatableFloatValue3)) {
      localAnimatableFloatValue3 = null;
    }
    if (isScaleIdentity(localAnimatableScaleValue)) {
      localAnimatableScaleValue = null;
    }
    if (isSkewIdentity(localAnimatableFloatValue2)) {
      localAnimatableFloatValue2 = null;
    }
    if (isSkewAngleIdentity(localAnimatableFloatValue1)) {
      localAnimatableFloatValue1 = null;
    }
    return new AnimatableTransform(paramJsonReader, paramLottieComposition, localAnimatableScaleValue, localAnimatableFloatValue3, localAnimatableIntegerValue, localAnimatableFloatValue5, localAnimatableFloatValue4, localAnimatableFloatValue2, localAnimatableFloatValue1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatableTransformParser
 * JD-Core Version:    0.7.0.1
 */