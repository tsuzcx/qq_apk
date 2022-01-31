package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape.Type;

class PolystarShapeParser
{
  static PolystarShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    boolean bool = false;
    AnimatableFloatValue localAnimatableFloatValue4 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    AnimatableFloatValue localAnimatableFloatValue3 = null;
    AnimatableFloatValue localAnimatableFloatValue5 = null;
    AnimatableValue localAnimatableValue = null;
    AnimatableFloatValue localAnimatableFloatValue6 = null;
    PolystarShape.Type localType = null;
    String str1 = null;
    label29:
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
          break label29;
          if (str2.equals("nm"))
          {
            i = 0;
            continue;
            if (str2.equals("sy"))
            {
              i = 1;
              continue;
              if (str2.equals("pt"))
              {
                i = 2;
                continue;
                if (str2.equals("p"))
                {
                  i = 3;
                  continue;
                  if (str2.equals("r"))
                  {
                    i = 4;
                    continue;
                    if (str2.equals("or"))
                    {
                      i = 5;
                      continue;
                      if (str2.equals("os"))
                      {
                        i = 6;
                        continue;
                        if (str2.equals("ir"))
                        {
                          i = 7;
                          continue;
                          if (str2.equals("is"))
                          {
                            i = 8;
                            continue;
                            if (str2.equals("hd")) {
                              i = 9;
                            }
                          }
                        }
                      }
                    }
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
      localType = PolystarShape.Type.forValue(paramJsonReader.nextInt());
      continue;
      localAnimatableFloatValue6 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      localAnimatableValue = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableFloatValue5 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      localAnimatableFloatValue3 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      localAnimatableFloatValue4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
      continue;
      bool = paramJsonReader.nextBoolean();
    }
    return new PolystarShape(str1, localType, localAnimatableFloatValue6, localAnimatableValue, localAnimatableFloatValue5, localAnimatableFloatValue4, localAnimatableFloatValue3, localAnimatableFloatValue2, localAnimatableFloatValue1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PolystarShapeParser
 * JD-Core Version:    0.7.0.1
 */