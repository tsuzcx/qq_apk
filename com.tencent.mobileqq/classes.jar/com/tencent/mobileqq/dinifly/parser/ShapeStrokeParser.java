package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ShapeStrokeParser
{
  private static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of(new String[] { "n", "v" });
  private static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d" });
  
  static ShapeStroke parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    String str1 = null;
    Object localObject1 = null;
    AnimatableColorValue localAnimatableColorValue = null;
    AnimatableFloatValue localAnimatableFloatValue = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    float f = 0.0F;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 8: 
        paramJsonReader.beginArray();
        for (Object localObject2 = localObject1; paramJsonReader.hasNext(); localObject2 = localObject1)
        {
          paramJsonReader.beginObject();
          localObject1 = null;
          String str2 = null;
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
              else
              {
                localObject1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
              }
            }
            else {
              str2 = paramJsonReader.nextString();
            }
          }
          paramJsonReader.endObject();
          int i = str2.hashCode();
          if (i != 100)
          {
            if (i != 103)
            {
              if ((i == 111) && (str2.equals("o")))
              {
                i = 0;
                break label264;
              }
            }
            else if (str2.equals("g"))
            {
              i = 2;
              break label264;
            }
          }
          else if (str2.equals("d"))
          {
            i = 1;
            break label264;
          }
          i = -1;
          if (i != 0) {
            if ((i != 1) && (i != 2))
            {
              localObject1 = localObject2;
            }
            else
            {
              paramLottieComposition.setHasDashPattern(true);
              localArrayList.add(localObject1);
              localObject1 = localObject2;
            }
          }
        }
        paramJsonReader.endArray();
        if (localArrayList.size() == 1)
        {
          localArrayList.add(localArrayList.get(0));
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
        }
        break;
      case 7: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 6: 
        f = (float)paramJsonReader.nextDouble();
        break;
      case 5: 
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 4: 
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 3: 
        localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        localAnimatableColorValue = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
        break;
      case 0: 
        label264:
        str1 = paramJsonReader.nextString();
      }
    }
    if (localAnimatableIntegerValue == null) {
      localAnimatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(Integer.valueOf(100))));
    }
    return new ShapeStroke(str1, (AnimatableFloatValue)localObject1, localArrayList, localAnimatableColorValue, localAnimatableIntegerValue, localAnimatableFloatValue, localLineCapType, localLineJoinType, f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeStrokeParser
 * JD-Core Version:    0.7.0.1
 */