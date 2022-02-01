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
    int i;
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJsonReader.beginArray();
    }
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    if (i != 0) {
      paramJsonReader.endArray();
    }
    return new ScaleXY(f1 / 100.0F * paramFloat, f2 / 100.0F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ScaleXYParser
 * JD-Core Version:    0.7.0.1
 */