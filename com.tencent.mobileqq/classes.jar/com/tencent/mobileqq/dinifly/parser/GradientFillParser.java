package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Path.FillType;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientFill;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.Collections;

class GradientFillParser
{
  private static final JsonReader.Options GRADIENT_NAMES = JsonReader.Options.of(new String[] { "p", "k" });
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "g", "o", "t", "s", "e", "r", "hd" });
  
  static GradientFill parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    Object localObject6 = Path.FillType.WINDING;
    Object localObject8 = null;
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    boolean bool = false;
    Object localObject5 = localObject2;
    Object localObject7 = localObject1;
    localObject1 = localObject8;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 7: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 6: 
        if (paramJsonReader.nextInt() == 1) {
          localObject2 = Path.FillType.WINDING;
        } else {
          localObject2 = Path.FillType.EVEN_ODD;
        }
        localObject6 = localObject2;
        break;
      case 5: 
        localObject4 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        break;
      case 4: 
        localObject3 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        break;
      case 3: 
        if (paramJsonReader.nextInt() == 1) {
          localObject2 = GradientType.LINEAR;
        } else {
          localObject2 = GradientType.RADIAL;
        }
        localObject7 = localObject2;
        break;
      case 2: 
        localObject1 = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        int i = -1;
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext())
        {
          int j = paramJsonReader.selectName(GRADIENT_NAMES);
          if (j != 0)
          {
            if (j != 1)
            {
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
            else
            {
              localObject5 = AnimatableValueParser.parseGradientColor(paramJsonReader, paramLottieComposition, i);
            }
          }
          else {
            i = paramJsonReader.nextInt();
          }
        }
        paramJsonReader.endObject();
        break;
      case 0: 
        str = paramJsonReader.nextString();
      }
    }
    paramJsonReader = (JsonReader)localObject1;
    if (localObject1 == null) {
      paramJsonReader = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(Integer.valueOf(100))));
    }
    return new GradientFill(str, localObject7, (Path.FillType)localObject6, (AnimatableGradientColorValue)localObject5, paramJsonReader, (AnimatablePointValue)localObject3, (AnimatablePointValue)localObject4, null, null, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientFillParser
 * JD-Core Version:    0.7.0.1
 */