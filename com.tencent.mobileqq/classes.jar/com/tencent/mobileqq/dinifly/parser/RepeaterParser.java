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
    AnimatableTransform localAnimatableTransform = null;
    boolean bool = false;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    String str1 = null;
    label14:
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
          break label14;
          if (str2.equals("nm"))
          {
            i = 0;
            continue;
            if (str2.equals("c"))
            {
              i = 1;
              continue;
              if (str2.equals("o"))
              {
                i = 2;
                continue;
                if (str2.equals("tr"))
                {
                  i = 3;
                  continue;
                  if (str2.equals("hd")) {
                    i = 4;
                  }
                }
              }
            }
          }
          break;
        }
      }
      str1 = paramJsonReader.nextString();
      continue;
      localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      localAnimatableTransform = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
      continue;
      bool = paramJsonReader.nextBoolean();
    }
    return new Repeater(str1, localAnimatableFloatValue2, localAnimatableFloatValue1, localAnimatableTransform, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.RepeaterParser
 * JD-Core Version:    0.7.0.1
 */