package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.content.ShapePath;

class ShapePathParser
{
  static ShapePath parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str1 = null;
    AnimatableShapeValue localAnimatableShapeValue = null;
    int j = 0;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = -1;
      int k = str2.hashCode();
      if (k != 3324)
      {
        if (k != 3432)
        {
          if (k != 3519)
          {
            if ((k == 104415) && (str2.equals("ind"))) {
              i = 1;
            }
          }
          else if (str2.equals("nm")) {
            i = 0;
          }
        }
        else if (str2.equals("ks")) {
          i = 2;
        }
      }
      else if (str2.equals("hd")) {
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
              bool = paramJsonReader.nextBoolean();
            }
          }
          else {
            localAnimatableShapeValue = AnimatableValueParser.parseShapeData(paramJsonReader, paramLottieComposition);
          }
        }
        else {
          j = paramJsonReader.nextInt();
        }
      }
      else {
        str1 = paramJsonReader.nextString();
      }
    }
    return new ShapePath(str1, j, localAnimatableShapeValue, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapePathParser
 * JD-Core Version:    0.7.0.1
 */