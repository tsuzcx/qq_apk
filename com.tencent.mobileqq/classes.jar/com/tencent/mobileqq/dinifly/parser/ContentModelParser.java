package com.tencent.mobileqq.dinifly.parser;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;

class ContentModelParser
{
  @Nullable
  static ContentModel parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    paramJsonReader.beginObject();
    int k = 2;
    int j = 2;
    Object localObject2;
    for (;;)
    {
      boolean bool = paramJsonReader.hasNext();
      localObject2 = null;
      if (!bool) {
        break label116;
      }
      localObject1 = paramJsonReader.nextName();
      i = ((String)localObject1).hashCode();
      if (i != 100)
      {
        if ((i == 3717) && (((String)localObject1).equals("ty")))
        {
          i = 0;
          break label83;
        }
      }
      else if (((String)localObject1).equals("d"))
      {
        i = 1;
        break label83;
      }
      i = -1;
      label83:
      if (i == 0) {
        break;
      }
      if (i != 1) {
        paramJsonReader.skipValue();
      } else {
        j = paramJsonReader.nextInt();
      }
    }
    Object localObject1 = paramJsonReader.nextString();
    break label119;
    label116:
    localObject1 = null;
    label119:
    if (localObject1 == null) {
      return null;
    }
    switch (((String)localObject1).hashCode())
    {
    default: 
      break;
    case 3710: 
      if (((String)localObject1).equals("tr")) {
        i = 5;
      }
      break;
    case 3705: 
      if (((String)localObject1).equals("tm")) {
        i = 9;
      }
      break;
    case 3681: 
      if (((String)localObject1).equals("st")) {
        i = 1;
      }
      break;
    case 3679: 
      if (((String)localObject1).equals("sr")) {
        i = 10;
      }
      break;
    case 3669: 
      if (((String)localObject1).equals("sh")) {
        i = 6;
      }
      break;
    case 3646: 
      if (((String)localObject1).equals("rp")) {
        i = 12;
      }
      break;
    case 3633: 
      if (((String)localObject1).equals("rc")) {
        i = 8;
      }
      break;
    case 3488: 
      if (((String)localObject1).equals("mm")) {
        i = 11;
      }
      break;
    case 3308: 
      if (((String)localObject1).equals("gs")) {
        i = k;
      }
      break;
    case 3307: 
      if (((String)localObject1).equals("gr")) {
        i = 0;
      }
      break;
    case 3295: 
      if (((String)localObject1).equals("gf")) {
        i = 4;
      }
      break;
    case 3270: 
      if (((String)localObject1).equals("fl")) {
        i = 3;
      }
      break;
    case 3239: 
      if (((String)localObject1).equals("el")) {
        i = 7;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      paramLottieComposition = new StringBuilder();
      paramLottieComposition.append("Unknown shape type ");
      paramLottieComposition.append((String)localObject1);
      Log.w("LOTTIE", paramLottieComposition.toString());
      paramLottieComposition = localObject2;
      break;
    case 12: 
      paramLottieComposition = RepeaterParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 11: 
      localObject1 = MergePathsParser.parse(paramJsonReader);
      paramLottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
      paramLottieComposition = (LottieComposition)localObject1;
      break;
    case 10: 
      paramLottieComposition = PolystarShapeParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 9: 
      paramLottieComposition = ShapeTrimPathParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 8: 
      paramLottieComposition = RectangleShapeParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 7: 
      paramLottieComposition = CircleShapeParser.parse(paramJsonReader, paramLottieComposition, j);
      break;
    case 6: 
      paramLottieComposition = ShapePathParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 5: 
      paramLottieComposition = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 4: 
      paramLottieComposition = GradientFillParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 3: 
      paramLottieComposition = ShapeFillParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 2: 
      paramLottieComposition = GradientStrokeParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 1: 
      paramLottieComposition = ShapeStrokeParser.parse(paramJsonReader, paramLottieComposition);
      break;
    case 0: 
      paramLottieComposition = ShapeGroupParser.parse(paramJsonReader, paramLottieComposition);
    }
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    paramJsonReader.endObject();
    return paramLottieComposition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ContentModelParser
 * JD-Core Version:    0.7.0.1
 */