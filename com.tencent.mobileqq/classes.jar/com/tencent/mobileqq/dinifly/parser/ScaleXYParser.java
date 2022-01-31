package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.value.ScaleXY;

public class ScaleXYParser
  implements ValueParser<ScaleXY>
{
  public static final ScaleXYParser INSTANCE = new ScaleXYParser();
  
  public ScaleXY parse(JsonReader paramJsonReader, float paramFloat)
  {
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {}
    float f1;
    float f2;
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramJsonReader.beginArray();
      }
      f1 = (float)paramJsonReader.nextDouble();
      f2 = (float)paramJsonReader.nextDouble();
      while (paramJsonReader.hasNext()) {
        paramJsonReader.skipValue();
      }
    }
    if (i != 0) {
      paramJsonReader.endArray();
    }
    return new ScaleXY(f1 / 100.0F * paramFloat, f2 / 100.0F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ScaleXYParser
 * JD-Core Version:    0.7.0.1
 */