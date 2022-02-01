package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class ShapeTrimPathParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "s", "e", "o", "nm", "m", "hd" });
  
  static ShapeTrimPath parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
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
              if (i != 4)
              {
                if (i != 5) {
                  paramJsonReader.skipValue();
                } else {
                  bool = paramJsonReader.nextBoolean();
                }
              }
              else {
                localObject1 = ShapeTrimPath.Type.forId(paramJsonReader.nextInt());
              }
            }
            else {
              str = paramJsonReader.nextString();
            }
          }
          else {
            localObject4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
          }
        }
        else {
          localObject3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        }
      }
      else {
        localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      }
    }
    return new ShapeTrimPath(str, (ShapeTrimPath.Type)localObject1, (AnimatableFloatValue)localObject2, (AnimatableFloatValue)localObject3, (AnimatableFloatValue)localObject4, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeTrimPathParser
 * JD-Core Version:    0.7.0.1
 */