package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;

class ShapeTrimPathParser
{
  static ShapeTrimPath parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str1 = null;
    Object localObject1 = str1;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = str2.hashCode();
      if (i != 101)
      {
        if (i != 109)
        {
          if (i != 111)
          {
            if (i != 115)
            {
              if (i != 3324)
              {
                if ((i == 3519) && (str2.equals("nm")))
                {
                  i = 3;
                  break label173;
                }
              }
              else if (str2.equals("hd"))
              {
                i = 5;
                break label173;
              }
            }
            else if (str2.equals("s"))
            {
              i = 0;
              break label173;
            }
          }
          else if (str2.equals("o"))
          {
            i = 2;
            break label173;
          }
        }
        else if (str2.equals("m"))
        {
          i = 4;
          break label173;
        }
      }
      else if (str2.equals("e"))
      {
        i = 1;
        break label173;
      }
      i = -1;
      label173:
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              if (i != 4) {
                if (i != 5) {
                  paramJsonReader.skipValue();
                }
              }
            }
            for (;;)
            {
              break;
              bool = paramJsonReader.nextBoolean();
              continue;
              localObject1 = ShapeTrimPath.Type.forId(paramJsonReader.nextInt());
              continue;
              str1 = paramJsonReader.nextString();
            }
          }
          localObject4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        }
        else
        {
          localObject3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        }
      }
      else {
        localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      }
    }
    return new ShapeTrimPath(str1, (ShapeTrimPath.Type)localObject1, (AnimatableFloatValue)localObject2, (AnimatableFloatValue)localObject3, (AnimatableFloatValue)localObject4, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeTrimPathParser
 * JD-Core Version:    0.7.0.1
 */