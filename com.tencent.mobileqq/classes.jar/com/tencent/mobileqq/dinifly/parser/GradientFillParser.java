package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Path.FillType;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientFill;
import com.tencent.mobileqq.dinifly.model.content.GradientType;

class GradientFillParser
{
  static GradientFill parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str1 = null;
    AnimatableGradientColorValue localAnimatableGradientColorValue = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    GradientType localGradientType = null;
    AnimatablePointValue localAnimatablePointValue2 = null;
    AnimatablePointValue localAnimatablePointValue1 = null;
    Path.FillType localFillType = Path.FillType.WINDING;
    boolean bool = false;
    label26:
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
          break label26;
          if (str2.equals("nm"))
          {
            i = 0;
            continue;
            if (str2.equals("g"))
            {
              i = 1;
              continue;
              if (str2.equals("o"))
              {
                i = 2;
                continue;
                if (str2.equals("t"))
                {
                  i = 3;
                  continue;
                  if (str2.equals("s"))
                  {
                    i = 4;
                    continue;
                    if (str2.equals("e"))
                    {
                      i = 5;
                      continue;
                      if (str2.equals("r"))
                      {
                        i = 6;
                        continue;
                        if (str2.equals("hd")) {
                          i = 7;
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
      int j = -1;
      paramJsonReader.beginObject();
      label312:
      while (paramJsonReader.hasNext())
      {
        str2 = paramJsonReader.nextName();
        i = -1;
        switch (str2.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramJsonReader.skipValue();
            break label312;
            if (str2.equals("p"))
            {
              i = 0;
              continue;
              if (str2.equals("k")) {
                i = 1;
              }
            }
            break;
          }
        }
        j = paramJsonReader.nextInt();
        continue;
        localAnimatableGradientColorValue = AnimatableValueParser.parseGradientColor(paramJsonReader, paramLottieComposition, j);
      }
      paramJsonReader.endObject();
      continue;
      localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
      continue;
      if (paramJsonReader.nextInt() == 1)
      {
        localGradientType = GradientType.LINEAR;
      }
      else
      {
        localGradientType = GradientType.RADIAL;
        continue;
        localAnimatablePointValue2 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        continue;
        localAnimatablePointValue1 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        continue;
        if (paramJsonReader.nextInt() == 1)
        {
          localFillType = Path.FillType.WINDING;
        }
        else
        {
          localFillType = Path.FillType.EVEN_ODD;
          continue;
          bool = paramJsonReader.nextBoolean();
        }
      }
    }
    return new GradientFill(str1, localGradientType, localFillType, localAnimatableGradientColorValue, localAnimatableIntegerValue, localAnimatablePointValue2, localAnimatablePointValue1, null, null, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientFillParser
 * JD-Core Version:    0.7.0.1
 */