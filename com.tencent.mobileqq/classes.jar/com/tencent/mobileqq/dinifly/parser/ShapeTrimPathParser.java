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
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    boolean bool = false;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue3 = null;
    ShapeTrimPath.Type localType = null;
    String str1 = null;
    label17:
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = -1;
      switch (str2.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label17;
          if (str2.equals("s"))
          {
            i = 0;
            continue;
            if (str2.equals("e"))
            {
              i = 1;
              continue;
              if (str2.equals("o"))
              {
                i = 2;
                continue;
                if (str2.equals("nm"))
                {
                  i = 3;
                  continue;
                  if (str2.equals("m"))
                  {
                    i = 4;
                    continue;
                    if (str2.equals("hd")) {
                      i = 5;
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      localAnimatableFloatValue3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      str1 = paramJsonReader.nextString();
      continue;
      localType = ShapeTrimPath.Type.forId(paramJsonReader.nextInt());
      continue;
      bool = paramJsonReader.nextBoolean();
    }
    return new ShapeTrimPath(str1, localType, localAnimatableFloatValue3, localAnimatableFloatValue2, localAnimatableFloatValue1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeTrimPathParser
 * JD-Core Version:    0.7.0.1
 */