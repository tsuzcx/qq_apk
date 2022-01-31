package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;

public class PointFParser
  implements ValueParser<PointF>
{
  public static final PointFParser INSTANCE = new PointFParser();
  
  public PointF parse(JsonReader paramJsonReader, float paramFloat)
  {
    Object localObject = paramJsonReader.peek();
    if (localObject == JsonToken.BEGIN_ARRAY)
    {
      localObject = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
      return localObject;
    }
    if (localObject == JsonToken.BEGIN_OBJECT) {
      return JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
    }
    if (localObject == JsonToken.NUMBER)
    {
      PointF localPointF = new PointF((float)paramJsonReader.nextDouble() * paramFloat, (float)paramJsonReader.nextDouble() * paramFloat);
      for (;;)
      {
        localObject = localPointF;
        if (!paramJsonReader.hasNext()) {
          break;
        }
        paramJsonReader.skipValue();
      }
    }
    throw new IllegalArgumentException("Cannot convert json to point. Next token is " + localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PointFParser
 * JD-Core Version:    0.7.0.1
 */