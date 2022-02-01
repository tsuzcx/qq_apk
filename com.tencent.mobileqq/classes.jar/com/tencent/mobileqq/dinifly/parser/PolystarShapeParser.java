package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape.Type;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class PolystarShapeParser
{
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd" });
  
  static PolystarShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    Object localObject6 = localObject5;
    Object localObject7 = localObject6;
    Object localObject8 = localObject7;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 9: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 8: 
        localObject7 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 7: 
        localObject5 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 6: 
        localObject8 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 5: 
        localObject6 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 4: 
        localObject4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 3: 
        localObject3 = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 1: 
        localObject1 = PolystarShape.Type.forValue(paramJsonReader.nextInt());
        break;
      case 0: 
        str = paramJsonReader.nextString();
      }
    }
    return new PolystarShape(str, (PolystarShape.Type)localObject1, (AnimatableFloatValue)localObject2, (AnimatableValue)localObject3, (AnimatableFloatValue)localObject4, (AnimatableFloatValue)localObject5, (AnimatableFloatValue)localObject6, (AnimatableFloatValue)localObject7, (AnimatableFloatValue)localObject8, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PolystarShapeParser
 * JD-Core Version:    0.7.0.1
 */