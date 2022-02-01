package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.Repeater;

class RepeaterParser
{
  static Repeater parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
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
      if (j != 99)
      {
        if (j != 111)
        {
          if (j != 3324)
          {
            if (j != 3519)
            {
              if ((j == 3710) && (str2.equals("tr"))) {
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
        else if (str2.equals("o")) {
          i = 2;
        }
      }
      else if (str2.equals("c")) {
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
        str1 = paramJsonReader.nextString();
      }
    }
    return new Repeater(str1, (AnimatableFloatValue)localObject1, (AnimatableFloatValue)localObject2, (AnimatableTransform)localObject3, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.RepeaterParser
 * JD-Core Version:    0.7.0.1
 */