package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Path.FillType;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeFill;

class ShapeFillParser
{
  static ShapeFill parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str1 = null;
    Object localObject1 = str1;
    Object localObject2 = localObject1;
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = -1;
      int k = str2.hashCode();
      if (k != -396065730)
      {
        if (k != 99)
        {
          if (k != 111)
          {
            if (k != 114)
            {
              if (k != 3324)
              {
                if ((k == 3519) && (str2.equals("nm"))) {
                  i = 0;
                }
              }
              else if (str2.equals("hd")) {
                i = 5;
              }
            }
            else if (str2.equals("r")) {
              i = 4;
            }
          }
          else if (str2.equals("o")) {
            i = 2;
          }
        }
        else if (str2.equals("c")) {
          i = 1;
        }
      }
      else if (str2.equals("fillEnabled")) {
        i = 3;
      }
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
                  bool1 = paramJsonReader.nextBoolean();
                }
              }
              else {
                j = paramJsonReader.nextInt();
              }
            }
            else {
              bool2 = paramJsonReader.nextBoolean();
            }
          }
          else {
            localObject2 = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
          }
        }
        else {
          localObject1 = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
        }
      }
      else {
        str1 = paramJsonReader.nextString();
      }
    }
    if (j == 1) {
      paramJsonReader = Path.FillType.WINDING;
    } else {
      paramJsonReader = Path.FillType.EVEN_ODD;
    }
    return new ShapeFill(str1, bool2, paramJsonReader, (AnimatableColorValue)localObject1, (AnimatableIntegerValue)localObject2, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeFillParser
 * JD-Core Version:    0.7.0.1
 */