package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.RectangleShape;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class RectangleShapeParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "p", "s", "r", "hd" });
  
  static RectangleShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
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
              localObject3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
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
    return new RectangleShape(str, (AnimatableValue)localObject1, (AnimatableValue)localObject2, (AnimatableFloatValue)localObject3, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.RectangleShapeParser
 * JD-Core Version:    0.7.0.1
 */