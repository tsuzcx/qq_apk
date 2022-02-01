package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

class KeyframesParser
{
  static <T> List<Keyframe<T>> parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, float paramFloat, ValueParser<T> paramValueParser)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonToken.STRING)
    {
      paramLottieComposition.addWarning("Lottie doesn't support expressions.");
      return localArrayList;
    }
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      if ((str.hashCode() == 107) && (str.equals("k"))) {
        i = 0;
      }
      if (i != 0)
      {
        paramJsonReader.skipValue();
      }
      else if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY)
      {
        paramJsonReader.beginArray();
        if (paramJsonReader.peek() == JsonToken.NUMBER) {
          localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
        } else {
          while (paramJsonReader.hasNext()) {
            localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, true));
          }
        }
        paramJsonReader.endArray();
      }
      else
      {
        localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
      }
    }
    paramJsonReader.endObject();
    setEndFrames(localArrayList);
    return localArrayList;
  }
  
  public static <T> void setEndFrames(List<? extends Keyframe<T>> paramList)
  {
    int k = paramList.size();
    int i = 0;
    int j;
    for (;;)
    {
      j = k - 1;
      if (i >= j) {
        break;
      }
      localKeyframe1 = (Keyframe)paramList.get(i);
      j = i + 1;
      Keyframe localKeyframe2 = (Keyframe)paramList.get(j);
      localKeyframe1.endFrame = Float.valueOf(localKeyframe2.startFrame);
      i = j;
      if (localKeyframe1.endValue == null)
      {
        i = j;
        if (localKeyframe2.startValue != null)
        {
          localKeyframe1.endValue = localKeyframe2.startValue;
          i = j;
          if ((localKeyframe1 instanceof PathKeyframe))
          {
            ((PathKeyframe)localKeyframe1).createPath();
            i = j;
          }
        }
      }
    }
    Keyframe localKeyframe1 = (Keyframe)paramList.get(j);
    if (((localKeyframe1.startValue == null) || (localKeyframe1.endValue == null)) && (paramList.size() > 1)) {
      paramList.remove(localKeyframe1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.KeyframesParser
 * JD-Core Version:    0.7.0.1
 */