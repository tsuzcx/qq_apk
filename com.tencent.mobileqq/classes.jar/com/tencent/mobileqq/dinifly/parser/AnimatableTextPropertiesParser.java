package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;

public class AnimatableTextPropertiesParser
{
  public static AnimatableTextProperties parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    paramJsonReader.beginObject();
    AnimatableTextProperties localAnimatableTextProperties = null;
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      if ((str.hashCode() == 97) && (str.equals("a"))) {
        i = 0;
      }
      if (i != 0) {
        paramJsonReader.skipValue();
      } else {
        localAnimatableTextProperties = parseAnimatableTextProperties(paramJsonReader, paramLottieComposition);
      }
    }
    paramJsonReader.endObject();
    if (localAnimatableTextProperties == null) {
      return new AnimatableTextProperties(null, null, null, null);
    }
    return localAnimatableTextProperties;
  }
  
  private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    paramJsonReader.beginObject();
    AnimatableColorValue localAnimatableColorValue2 = null;
    AnimatableColorValue localAnimatableColorValue1 = null;
    Object localObject1 = localAnimatableColorValue1;
    Object localObject2 = localObject1;
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int j = str.hashCode();
      if (j != 116)
      {
        if (j != 3261)
        {
          if (j != 3664)
          {
            if ((j == 3684) && (str.equals("sw"))) {
              i = 2;
            }
          }
          else if (str.equals("sc")) {
            i = 1;
          }
        }
        else if (str.equals("fc")) {
          i = 0;
        }
      }
      else if (str.equals("t")) {
        i = 3;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
              localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
            }
          }
          else {
            localObject1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
          }
        }
        else {
          localAnimatableColorValue1 = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
        }
      }
      else {
        localAnimatableColorValue2 = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
      }
    }
    paramJsonReader.endObject();
    return new AnimatableTextProperties(localAnimatableColorValue2, localAnimatableColorValue1, (AnimatableFloatValue)localObject1, (AnimatableFloatValue)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatableTextPropertiesParser
 * JD-Core Version:    0.7.0.1
 */