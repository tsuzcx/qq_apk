package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientStroke;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GradientStrokeParser
{
  private static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of(new String[] { "n", "v" });
  private static final JsonReader.Options GRADIENT_NAMES;
  private static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d" });
  
  static
  {
    GRADIENT_NAMES = JsonReader.Options.of(new String[] { "p", "k" });
  }
  
  static GradientStroke parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    String str1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    AnimatablePointValue localAnimatablePointValue2 = null;
    AnimatablePointValue localAnimatablePointValue1 = null;
    AnimatableFloatValue localAnimatableFloatValue = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    float f = 0.0F;
    Object localObject1 = null;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      Object localObject2;
      int i;
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 11: 
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginObject();
          String str2 = null;
          localObject2 = null;
          while (paramJsonReader.hasNext())
          {
            i = paramJsonReader.selectName(DASH_PATTERN_NAMES);
            if (i != 0)
            {
              if (i != 1)
              {
                paramJsonReader.skipName();
                paramJsonReader.skipValue();
              }
              for (;;)
              {
                break;
                localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
              }
            }
            str2 = paramJsonReader.nextString();
          }
          paramJsonReader.endObject();
          if (str2.equals("o"))
          {
            localObject1 = localObject2;
          }
          else
          {
            if ((!str2.equals("d")) && (!str2.equals("g"))) {
              break label268;
            }
            paramLottieComposition.setHasDashPattern(true);
            localArrayList.add(localObject2);
          }
        }
        paramJsonReader.endArray();
        if (localArrayList.size() == 1) {
          localArrayList.add(localArrayList.get(0));
        }
        break;
      case 10: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 9: 
        f = (float)paramJsonReader.nextDouble();
        break;
      case 8: 
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 7: 
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 6: 
        localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 5: 
        localAnimatablePointValue1 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        break;
      case 4: 
        localAnimatablePointValue2 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        break;
      case 3: 
        if (paramJsonReader.nextInt() == 1) {
          localObject2 = GradientType.LINEAR;
        } else {
          localObject2 = GradientType.RADIAL;
        }
        localObject4 = localObject2;
        break;
      case 2: 
        localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        i = -1;
        paramJsonReader.beginObject();
        localObject2 = localObject3;
        if (paramJsonReader.hasNext())
        {
          int j = paramJsonReader.selectName(GRADIENT_NAMES);
          if (j != 0) {
            if (j != 1)
            {
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
          }
          for (;;)
          {
            break;
            localObject2 = AnimatableValueParser.parseGradientColor(paramJsonReader, paramLottieComposition, i);
            break;
            i = paramJsonReader.nextInt();
          }
        }
        paramJsonReader.endObject();
        localObject3 = localObject2;
        break;
      case 0: 
        label268:
        str1 = paramJsonReader.nextString();
      }
    }
    paramJsonReader = localAnimatableIntegerValue;
    if (localAnimatableIntegerValue == null) {
      paramJsonReader = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(Integer.valueOf(100))));
    }
    return new GradientStroke(str1, localObject4, localObject3, paramJsonReader, localAnimatablePointValue2, localAnimatablePointValue1, localAnimatableFloatValue, localLineCapType, localLineJoinType, f, localArrayList, localObject1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientStrokeParser
 * JD-Core Version:    0.7.0.1
 */