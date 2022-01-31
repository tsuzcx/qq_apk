package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableSplitDimensionPathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

public class AnimatablePathValueParser
{
  public static AnimatablePathValue parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY)
    {
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext()) {
        localArrayList.add(PathKeyframeParser.parse(paramJsonReader, paramLottieComposition));
      }
      paramJsonReader.endArray();
      KeyframesParser.setEndFrames(localArrayList);
    }
    for (;;)
    {
      return new AnimatablePathValue(localArrayList);
      localArrayList.add(new Keyframe(JsonUtils.jsonToPoint(paramJsonReader, Utils.dpScale())));
    }
  }
  
  static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    paramJsonReader.beginObject();
    int j = 0;
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    AnimatablePathValue localAnimatablePathValue = null;
    label15:
    while (paramJsonReader.peek() != JsonToken.END_OBJECT)
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label15;
          if (str.equals("k"))
          {
            i = 0;
            continue;
            if (str.equals("x"))
            {
              i = 1;
              continue;
              if (str.equals("y")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      localAnimatablePathValue = parse(paramJsonReader, paramLottieComposition);
      continue;
      if (paramJsonReader.peek() == JsonToken.STRING)
      {
        paramJsonReader.skipValue();
        j = 1;
      }
      else
      {
        localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        continue;
        if (paramJsonReader.peek() == JsonToken.STRING)
        {
          paramJsonReader.skipValue();
          j = 1;
        }
        else
        {
          localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        }
      }
    }
    paramJsonReader.endObject();
    if (j != 0) {
      paramLottieComposition.addWarning("Lottie doesn't support expressions.");
    }
    if (localAnimatablePathValue != null) {
      return localAnimatablePathValue;
    }
    return new AnimatableSplitDimensionPathValue(localAnimatableFloatValue1, localAnimatableFloatValue2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatablePathValueParser
 * JD-Core Version:    0.7.0.1
 */