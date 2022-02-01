package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.CircleShape;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class CircleShapeParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "p", "s", "hd", "d" });
  
  static CircleShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, int paramInt)
  {
    boolean bool1;
    if (paramInt == 3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    boolean bool2 = false;
    while (paramJsonReader.hasNext())
    {
      paramInt = paramJsonReader.selectName(NAMES);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                paramJsonReader.skipName();
                paramJsonReader.skipValue();
              }
              else if (paramJsonReader.nextInt() == 3)
              {
                bool1 = true;
              }
              else
              {
                bool1 = false;
              }
            }
            else {
              bool2 = paramJsonReader.nextBoolean();
            }
          }
          else {
            localObject2 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
          }
        }
        else {
          localObject1 = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
        }
      }
      else {
        str = paramJsonReader.nextString();
      }
    }
    return new CircleShape(str, (AnimatableValue)localObject1, (AnimatablePointValue)localObject2, bool1, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.CircleShapeParser
 * JD-Core Version:    0.7.0.1
 */