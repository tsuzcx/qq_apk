package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.content.ShapePath;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class ShapePathParser
{
  static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "ind", "ks", "hd" });
  
  static ShapePath parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    int i = 0;
    String str = null;
    AnimatableShapeValue localAnimatableShapeValue = null;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      int j = paramJsonReader.selectName(NAMES);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3) {
              paramJsonReader.skipValue();
            } else {
              bool = paramJsonReader.nextBoolean();
            }
          }
          else {
            localAnimatableShapeValue = AnimatableValueParser.parseShapeData(paramJsonReader, paramLottieComposition);
          }
        }
        else {
          i = paramJsonReader.nextInt();
        }
      }
      else {
        str = paramJsonReader.nextString();
      }
    }
    return new ShapePath(str, i, localAnimatableShapeValue, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapePathParser
 * JD-Core Version:    0.7.0.1
 */