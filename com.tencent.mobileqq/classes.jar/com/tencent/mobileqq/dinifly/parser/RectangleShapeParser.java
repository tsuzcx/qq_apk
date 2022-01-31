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
    AnimatableFloatValue localAnimatableFloatValue = null;
    boolean bool = false;
    AnimatablePointValue localAnimatablePointValue = null;
    AnimatableValue localAnimatableValue = null;
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
            if (str2.equals("p"))
            {
              i = 1;
              continue;
              if (str2.equals("s"))
              {
                i = 2;
                continue;
                if (str2.equals("r"))
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
      localAnimatableValue = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatablePointValue = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
      continue;
      bool = paramJsonReader.nextBoolean();
    }
    return new RectangleShape(str1, localAnimatableValue, localAnimatablePointValue, localAnimatableFloatValue, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.RectangleShapeParser
 * JD-Core Version:    0.7.0.1
 */