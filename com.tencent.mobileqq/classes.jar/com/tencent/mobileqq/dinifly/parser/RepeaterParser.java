package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.Repeater;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class RepeaterParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "c", "o", "tr", "hd" });
  
  static Repeater parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      int i = paramJsonReader.selectName(NAMES);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                paramJsonReader.skipValue();
              } else {
                bool = paramJsonReader.nextBoolean();
              }
            }
            else {
              localObject3 = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
            }
          }
          else {
            localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
          }
        }
        else {
          localObject1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        }
      }
      else {
        str = paramJsonReader.nextString();
      }
    }
    return new Repeater(str, (AnimatableFloatValue)localObject1, (AnimatableFloatValue)localObject2, (AnimatableTransform)localObject3, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.RepeaterParser
 * JD-Core Version:    0.7.0.1
 */