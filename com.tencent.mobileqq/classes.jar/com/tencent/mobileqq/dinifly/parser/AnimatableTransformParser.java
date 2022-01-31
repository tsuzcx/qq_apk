package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
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
    return (paramAnimatablePathValue == null) || ((paramAnimatablePathValue.isStatic()) && (((PointF)((Keyframe)paramAnimatablePathValue.getKeyframes().get(0)).startValue).equals(0.0F, 0.0F)));
  }
  
  private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> paramAnimatableValue)
  {
    return (paramAnimatableValue == null) || ((!(paramAnimatableValue instanceof AnimatableSplitDimensionPathValue)) && (paramAnimatableValue.isStatic()) && (((PointF)((Keyframe)paramAnimatableValue.getKeyframes().get(0)).startValue).equals(0.0F, 0.0F)));
  }
  
  private static boolean isRotationIdentity(AnimatableFloatValue paramAnimatableFloatValue)
  {
    return (paramAnimatableFloatValue == null) || ((paramAnimatableFloatValue.isStatic()) && (((Float)((Keyframe)paramAnimatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0F));
  }
  
  private static boolean isScaleIdentity(AnimatableScaleValue paramAnimatableScaleValue)
  {
    return (paramAnimatableScaleValue == null) || ((paramAnimatableScaleValue.isStatic()) && (((ScaleXY)((Keyframe)paramAnimatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0F, 1.0F)));
  }
  
  private static boolean isSkewAngleIdentity(AnimatableFloatValue paramAnimatableFloatValue)
  {
    return (paramAnimatableFloatValue == null) || ((paramAnimatableFloatValue.isStatic()) && (((Float)((Keyframe)paramAnimatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0F));
  }
  
  private static boolean isSkewIdentity(AnimatableFloatValue paramAnimatableFloatValue)
  {
    return (paramAnimatableFloatValue == null) || ((paramAnimatableFloatValue.isStatic()) && (((Float)((Keyframe)paramAnimatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0F));
  }
  
  public static AnimatableTransform parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    Object localObject17 = null;
    Object localObject18 = null;
    int j;
    Object localObject8;
    Object localObject9;
    Object localObject5;
    Object localObject2;
    Object localObject7;
    Object localObject6;
    Object localObject4;
    Object localObject3;
    Object localObject1;
    label119:
    int i;
    if (paramJsonReader.peek() == JsonToken.BEGIN_OBJECT)
    {
      j = 1;
      localObject8 = localObject13;
      localObject9 = localObject16;
      localObject5 = localObject17;
      localObject2 = localObject18;
      localObject7 = localObject15;
      localObject6 = localObject14;
      localObject4 = localObject12;
      localObject3 = localObject11;
      localObject1 = localObject10;
      if (j != 0)
      {
        paramJsonReader.beginObject();
        localObject1 = localObject10;
        localObject3 = localObject11;
        localObject4 = localObject12;
        localObject6 = localObject14;
        localObject7 = localObject15;
        localObject2 = localObject18;
        localObject5 = localObject17;
        localObject9 = localObject16;
        localObject8 = localObject13;
      }
      if (!paramJsonReader.hasNext()) {
        break label1265;
      }
      localObject10 = paramJsonReader.nextName();
      i = -1;
      switch (((String)localObject10).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label228:
          paramJsonReader.skipValue();
          localObject10 = localObject2;
          localObject2 = localObject5;
          localObject11 = localObject7;
          localObject5 = localObject8;
          localObject7 = localObject3;
          localObject3 = localObject6;
          localObject8 = localObject1;
          localObject6 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject11;
          localObject1 = localObject10;
        }
        break;
      }
    }
    for (;;)
    {
      localObject10 = localObject6;
      localObject11 = localObject7;
      localObject12 = localObject8;
      localObject8 = localObject5;
      localObject5 = localObject2;
      localObject2 = localObject1;
      localObject7 = localObject3;
      localObject6 = localObject4;
      localObject4 = localObject10;
      localObject3 = localObject11;
      localObject1 = localObject12;
      break label119;
      j = 0;
      break;
      if (!((String)localObject10).equals("a")) {
        break label228;
      }
      i = 0;
      break label228;
      if (!((String)localObject10).equals("p")) {
        break label228;
      }
      i = 1;
      break label228;
      if (!((String)localObject10).equals("s")) {
        break label228;
      }
      i = 2;
      break label228;
      if (!((String)localObject10).equals("rz")) {
        break label228;
      }
      i = 3;
      break label228;
      if (!((String)localObject10).equals("r")) {
        break label228;
      }
      i = 4;
      break label228;
      if (!((String)localObject10).equals("o")) {
        break label228;
      }
      i = 5;
      break label228;
      if (!((String)localObject10).equals("so")) {
        break label228;
      }
      i = 6;
      break label228;
      if (!((String)localObject10).equals("eo")) {
        break label228;
      }
      i = 7;
      break label228;
      if (!((String)localObject10).equals("sk")) {
        break label228;
      }
      i = 8;
      break label228;
      if (!((String)localObject10).equals("sa")) {
        break label228;
      }
      i = 9;
      break label228;
      paramJsonReader.beginObject();
      while (paramJsonReader.hasNext()) {
        if (paramJsonReader.nextName().equals("k")) {
          localObject1 = AnimatablePathValueParser.parse(paramJsonReader, paramLottieComposition);
        } else {
          paramJsonReader.skipValue();
        }
      }
      paramJsonReader.endObject();
      localObject11 = localObject5;
      localObject12 = localObject7;
      localObject5 = localObject8;
      localObject7 = localObject4;
      localObject8 = localObject3;
      localObject4 = localObject6;
      localObject10 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject11;
      localObject3 = localObject12;
      localObject6 = localObject7;
      localObject7 = localObject8;
      localObject8 = localObject10;
      continue;
      localObject11 = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
      localObject3 = localObject5;
      localObject10 = localObject7;
      localObject5 = localObject8;
      localObject7 = localObject4;
      localObject8 = localObject11;
      localObject4 = localObject6;
      localObject11 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject10;
      localObject6 = localObject7;
      localObject7 = localObject8;
      localObject8 = localObject11;
      continue;
      localObject11 = AnimatableValueParser.parseScale(paramJsonReader, paramLottieComposition);
      localObject4 = localObject5;
      localObject10 = localObject7;
      localObject5 = localObject8;
      localObject7 = localObject11;
      localObject8 = localObject3;
      localObject11 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      localObject3 = localObject10;
      localObject4 = localObject6;
      localObject6 = localObject7;
      localObject7 = localObject8;
      localObject8 = localObject11;
      continue;
      paramLottieComposition.addWarning("Lottie doesn't support 3D layers.");
      localObject8 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      if (((AnimatableFloatValue)localObject8).getKeyframes().isEmpty())
      {
        ((AnimatableFloatValue)localObject8).getKeyframes().add(new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramLottieComposition.getEndFrame())));
        localObject10 = localObject8;
        localObject11 = localObject4;
        localObject12 = localObject3;
        localObject8 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject5;
        localObject3 = localObject7;
        localObject4 = localObject6;
        localObject5 = localObject10;
        localObject6 = localObject11;
        localObject7 = localObject12;
      }
      else if (((Keyframe)((AnimatableFloatValue)localObject8).getKeyframes().get(0)).startValue == null)
      {
        ((AnimatableFloatValue)localObject8).getKeyframes().set(0, new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramLottieComposition.getEndFrame())));
        localObject10 = localObject8;
        localObject11 = localObject4;
        localObject12 = localObject3;
        localObject8 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject5;
        localObject3 = localObject7;
        localObject4 = localObject6;
        localObject5 = localObject10;
        localObject6 = localObject11;
        localObject7 = localObject12;
        continue;
        localObject12 = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        localObject10 = localObject5;
        localObject11 = localObject7;
        localObject5 = localObject8;
        localObject6 = localObject4;
        localObject7 = localObject3;
        localObject4 = localObject12;
        localObject8 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject10;
        localObject3 = localObject11;
        continue;
        localObject11 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        localObject10 = localObject5;
        localObject5 = localObject8;
        localObject7 = localObject4;
        localObject8 = localObject3;
        localObject4 = localObject6;
        localObject12 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject10;
        localObject3 = localObject11;
        localObject6 = localObject7;
        localObject7 = localObject8;
        localObject8 = localObject12;
        continue;
        localObject12 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        localObject9 = localObject5;
        localObject11 = localObject7;
        localObject5 = localObject8;
        localObject7 = localObject4;
        localObject8 = localObject3;
        localObject4 = localObject6;
        localObject10 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject9;
        localObject3 = localObject11;
        localObject6 = localObject7;
        localObject7 = localObject8;
        localObject9 = localObject12;
        localObject8 = localObject10;
        continue;
        localObject12 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        localObject11 = localObject7;
        localObject5 = localObject8;
        localObject7 = localObject4;
        localObject10 = localObject3;
        localObject8 = localObject1;
        localObject1 = localObject2;
        localObject4 = localObject6;
        localObject2 = localObject12;
        localObject3 = localObject11;
        localObject6 = localObject7;
        localObject7 = localObject10;
        continue;
        localObject12 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        localObject2 = localObject5;
        localObject11 = localObject7;
        localObject5 = localObject8;
        localObject7 = localObject4;
        localObject8 = localObject3;
        localObject4 = localObject6;
        localObject10 = localObject1;
        localObject1 = localObject12;
        localObject3 = localObject11;
        localObject6 = localObject7;
        localObject7 = localObject8;
        localObject8 = localObject10;
        continue;
        label1265:
        if (j != 0) {
          paramJsonReader.endObject();
        }
        if (isAnchorPointIdentity((AnimatablePathValue)localObject1)) {}
        for (paramJsonReader = null;; paramJsonReader = (JsonReader)localObject1)
        {
          if (isPositionIdentity(localObject3)) {}
          for (paramLottieComposition = null;; paramLottieComposition = localObject3)
          {
            if (isRotationIdentity((AnimatableFloatValue)localObject8)) {}
            for (localObject1 = null;; localObject1 = localObject8)
            {
              if (isScaleIdentity(localObject4)) {}
              for (localObject3 = null;; localObject3 = localObject4)
              {
                localObject4 = localObject5;
                if (isSkewIdentity(localObject5)) {
                  localObject4 = null;
                }
                localObject5 = localObject2;
                if (isSkewAngleIdentity(localObject2)) {
                  localObject5 = null;
                }
                return new AnimatableTransform(paramJsonReader, paramLottieComposition, localObject3, (AnimatableFloatValue)localObject1, localObject6, localObject7, localObject9, localObject4, localObject5);
              }
            }
          }
        }
      }
      else
      {
        localObject10 = localObject8;
        localObject11 = localObject4;
        localObject12 = localObject3;
        localObject8 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject5;
        localObject3 = localObject7;
        localObject4 = localObject6;
        localObject5 = localObject10;
        localObject6 = localObject11;
        localObject7 = localObject12;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatableTransformParser
 * JD-Core Version:    0.7.0.1
 */