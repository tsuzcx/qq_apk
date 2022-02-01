package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;

public class PointFParser
  implements ValueParser<PointF>
{
  public static final PointFParser INSTANCE = new PointFParser();
  
  public PointF parse(JsonReader paramJsonReader, float paramFloat)
  {
    Object localObject = paramJsonReader.peek();
    if (localObject == JsonReader.Token.BEGIN_ARRAY) {
      return JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
    }
    if (localObject == JsonReader.Token.BEGIN_OBJECT) {
      return JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
    }
    if (localObject == JsonReader.Token.NUMBER)
    {
      localObject = new PointF((float)paramJsonReader.nextDouble() * paramFloat, (float)paramJsonReader.nextDouble() * paramFloat);
      while (paramJsonReader.hasNext()) {
        paramJsonReader.skipValue();
      }
      return localObject;
    }
    paramJsonReader = new StringBuilder();
    paramJsonReader.append("Cannot convert json to point. Next token is ");
    paramJsonReader.append(localObject);
    paramJsonReader = new IllegalArgumentException(paramJsonReader.toString());
    for (;;)
    {
      throw paramJsonReader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PointFParser
 * JD-Core Version:    0.7.0.1
 */