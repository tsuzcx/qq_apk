package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Path.FillType;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeFill;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.Collections;

class ShapeFillParser
{
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "c", "o", "fillEnabled", "r", "hd" });
  
  static ShapeFill parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    String str = null;
    Object localObject = str;
    int i = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    while (paramJsonReader.hasNext())
    {
      int j = paramJsonReader.selectName(NAMES);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j != 5)
                {
                  paramJsonReader.skipName();
                  paramJsonReader.skipValue();
                }
                else
                {
                  bool1 = paramJsonReader.nextBoolean();
                }
              }
              else {
                i = paramJsonReader.nextInt();
              }
            }
            else {
              bool2 = paramJsonReader.nextBoolean();
            }
          }
          else {
            localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
          }
        }
        else {
          localObject = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
        }
      }
      else {
        str = paramJsonReader.nextString();
      }
    }
    paramJsonReader = localAnimatableIntegerValue;
    if (localAnimatableIntegerValue == null) {
      paramJsonReader = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(Integer.valueOf(100))));
    }
    if (i == 1) {
      paramLottieComposition = Path.FillType.WINDING;
    } else {
      paramLottieComposition = Path.FillType.EVEN_ODD;
    }
    return new ShapeFill(str, bool2, paramLottieComposition, (AnimatableColorValue)localObject, paramJsonReader, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeFillParser
 * JD-Core Version:    0.7.0.1
 */