package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.util.JsonReader;

public class PathParser
  implements ValueParser<PointF>
{
  public static final PathParser INSTANCE = new PathParser();
  
  public PointF parse(JsonReader paramJsonReader, float paramFloat)
  {
    return JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PathParser
 * JD-Core Version:    0.7.0.1
 */