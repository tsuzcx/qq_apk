package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

public class AnimatableTextPropertiesParser
{
  private static JsonReader.Options ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.of(new String[] { "fc", "sc", "sw", "t" });
  private static JsonReader.Options PROPERTIES_NAMES = JsonReader.Options.of(new String[] { "a" });
  
  public static AnimatableTextProperties parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    paramJsonReader.beginObject();
    AnimatableTextProperties localAnimatableTextProperties = null;
    while (paramJsonReader.hasNext()) {
      if (paramJsonReader.selectName(PROPERTIES_NAMES) != 0)
      {
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
      }
      else
      {
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
      int i = paramJsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
            else
            {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatableTextPropertiesParser
 * JD-Core Version:    0.7.0.1
 */