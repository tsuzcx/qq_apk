package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableSplitDimensionPathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

public class AnimatablePathValueParser
{
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "k", "x", "y" });
  
  public static AnimatablePathValue parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonReader.Token.BEGIN_ARRAY)
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
    int i = 0;
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    AnimatableFloatValue localAnimatableFloatValue1 = localAnimatableFloatValue2;
    while (paramJsonReader.peek() != JsonReader.Token.END_OBJECT)
    {
      int j = paramJsonReader.selectName(NAMES);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            paramJsonReader.skipName();
            paramJsonReader.skipValue();
            continue;
          }
          if (paramJsonReader.peek() == JsonReader.Token.STRING) {
            paramJsonReader.skipValue();
          } else {
            localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
          }
        }
        else
        {
          if (paramJsonReader.peek() != JsonReader.Token.STRING) {
            break label105;
          }
          paramJsonReader.skipValue();
        }
        i = 1;
        continue;
        label105:
        localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
      }
      else
      {
        localAnimatablePathValue = parse(paramJsonReader, paramLottieComposition);
      }
    }
    paramJsonReader.endObject();
    if (i != 0) {
      paramLottieComposition.addWarning("Lottie doesn't support expressions.");
    }
    if (localAnimatablePathValue != null) {
      return localAnimatablePathValue;
    }
    return new AnimatableSplitDimensionPathValue(localAnimatableFloatValue2, localAnimatableFloatValue1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatablePathValueParser
 * JD-Core Version:    0.7.0.1
 */