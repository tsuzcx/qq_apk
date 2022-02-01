package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.RectangleShape;

class RectangleShapeParser
{
  static RectangleShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str1 = null;
    Object localObject1 = str1;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = -1;
      int j = str2.hashCode();
      if (j != 112)
      {
        if (j != 3324)
        {
          if (j != 3519)
          {
            if (j != 114)
            {
              if ((j == 115) && (str2.equals("s"))) {
                i = 2;
              }
            }
            else if (str2.equals("r")) {
              i = 3;
            }
          }
          else if (str2.equals("nm")) {
            i = 0;
          }
        }
        else if (str2.equals("hd")) {
          i = 4;
        }
      }
      else if (str2.equals("p")) {
        i = 1;
      }
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
        str1 = paramJsonReader.nextString();
      }
    }
    return new RectangleShape(str1, (AnimatableValue)localObject1, (AnimatablePointValue)localObject2, (AnimatableFloatValue)localObject3, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.RectangleShapeParser
 * JD-Core Version:    0.7.0.1
 */