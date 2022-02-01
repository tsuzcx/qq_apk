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
    AnimatablePointValue localAnimatablePointValue = null;
    boolean bool1;
    label10:
    boolean bool2;
    AnimatableValue localAnimatableValue;
    String str1;
    if (paramInt == 3)
    {
      bool1 = true;
      bool2 = false;
      localAnimatableValue = null;
      str1 = null;
    }
    for (;;)
    {
      label19:
      if (!paramJsonReader.hasNext()) {
        break label267;
      }
      String str2 = paramJsonReader.nextName();
      paramInt = -1;
      switch (str2.hashCode())
      {
      }
      for (;;)
      {
        switch (paramInt)
        {
        default: 
          paramJsonReader.skipValue();
          break label19;
          bool1 = false;
          break label10;
          if (str2.equals("nm"))
          {
            paramInt = 0;
            continue;
            if (str2.equals("p"))
            {
              paramInt = 1;
              continue;
              if (str2.equals("s"))
              {
                paramInt = 2;
                continue;
                if (str2.equals("hd"))
                {
                  paramInt = 3;
                  continue;
                  if (str2.equals("d")) {
                    paramInt = 4;
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
      bool2 = paramJsonReader.nextBoolean();
      continue;
      if (paramJsonReader.nextInt() == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label267:
    return new CircleShape(str1, localAnimatableValue, localAnimatablePointValue, bool1, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.CircleShapeParser
 * JD-Core Version:    0.7.0.1
 */