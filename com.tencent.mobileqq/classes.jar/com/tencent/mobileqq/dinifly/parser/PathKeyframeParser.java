package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;
import com.tencent.mobileqq.dinifly.utils.Utils;

class PathKeyframeParser
{
  static PathKeyframe parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    boolean bool;
    if (paramJsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
      bool = true;
    } else {
      bool = false;
    }
    return new PathKeyframe(paramLottieComposition, KeyframeParser.parse(paramJsonReader, paramLottieComposition, Utils.dpScale(), PathParser.INSTANCE, bool, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PathKeyframeParser
 * JD-Core Version:    0.7.0.1
 */