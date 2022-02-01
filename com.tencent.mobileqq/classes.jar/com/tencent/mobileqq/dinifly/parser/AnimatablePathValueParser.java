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
    else
    {
      localArrayList.add(new Keyframe(JsonUtils.jsonToPoint(paramJsonReader, Utils.dpScale())));
    }
    return new AnimatablePathValue(localArrayList);
  }
  
  static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    paramJsonReader.beginObject();
    AnimatablePathValue localAnimatablePathValue = null;
    Object localObject1 = localAnimatablePathValue;
    Object localObject2 = localObject1;
    int j = 0;
    while (paramJsonReader.peek() != JsonToken.END_OBJECT)
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int k = str.hashCode();
      if (k != 107)
      {
        if (k != 120)
        {
          if ((k == 121) && (str.equals("y"))) {
            i = 2;
          }
        }
        else if (str.equals("x")) {
          i = 1;
        }
      }
      else if (str.equals("k")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            paramJsonReader.skipValue();
            continue;
          }
          if (paramJsonReader.peek() == JsonToken.STRING) {
            paramJsonReader.skipValue();
          } else {
            localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
          }
        }
        else
        {
          if (paramJsonReader.peek() != JsonToken.STRING) {
            break label175;
          }
          paramJsonReader.skipValue();
        }
        j = 1;
        continue;
        label175:
        localObject1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
      }
      else
      {
        localAnimatablePathValue = parse(paramJsonReader, paramLottieComposition);
      }
    }
    paramJsonReader.endObject();
    if (j != 0) {
      paramLottieComposition.addWarning("Lottie doesn't support expressions.");
    }
    if (localAnimatablePathValue != null) {
      return localAnimatablePathValue;
    }
    return new AnimatableSplitDimensionPathValue((AnimatableFloatValue)localObject1, (AnimatableFloatValue)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatablePathValueParser
 * JD-Core Version:    0.7.0.1
 */