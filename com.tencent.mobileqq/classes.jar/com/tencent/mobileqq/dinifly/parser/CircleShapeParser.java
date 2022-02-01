package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.CircleShape;

class CircleShapeParser
{
  static CircleShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, int paramInt)
  {
    boolean bool1;
    if (paramInt == 3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    String str1 = null;
    Object localObject1 = str1;
    Object localObject2 = localObject1;
    boolean bool2 = false;
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      paramInt = -1;
      int i = str2.hashCode();
      if (i != 100)
      {
        if (i != 112)
        {
          if (i != 115)
          {
            if (i != 3324)
            {
              if ((i == 3519) && (str2.equals("nm"))) {
                paramInt = 0;
              }
            }
            else if (str2.equals("hd")) {
              paramInt = 3;
            }
          }
          else if (str2.equals("s")) {
            paramInt = 2;
          }
        }
        else if (str2.equals("p")) {
          paramInt = 1;
        }
      }
      else if (str2.equals("d")) {
        paramInt = 4;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4) {
                paramJsonReader.skipValue();
              } else if (paramJsonReader.nextInt() == 3) {
                bool1 = true;
              } else {
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
        str1 = paramJsonReader.nextString();
      }
    }
    return new CircleShape(str1, (AnimatableValue)localObject1, (AnimatablePointValue)localObject2, bool1, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.CircleShapeParser
 * JD-Core Version:    0.7.0.1
 */