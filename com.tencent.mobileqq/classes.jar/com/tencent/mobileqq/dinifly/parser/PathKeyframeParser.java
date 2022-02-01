package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe;
import com.tencent.mobileqq.dinifly.utils.Utils;

class PathKeyframeParser
{
  static PathKeyframe parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    if (paramJsonReader.peek() == JsonToken.BEGIN_OBJECT) {}
    for (boolean bool = true;; bool = false) {
      return new PathKeyframe(paramLottieComposition, KeyframeParser.parse(paramJsonReader, paramLottieComposition, Utils.dpScale(), PathParser.INSTANCE, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PathKeyframeParser
 * JD-Core Version:    0.7.0.1
 */