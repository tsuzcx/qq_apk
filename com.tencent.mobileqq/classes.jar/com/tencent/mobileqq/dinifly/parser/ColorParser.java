package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;

public class ColorParser
  implements ValueParser<Integer>
{
  public static final ColorParser INSTANCE = new ColorParser();
  
  public Integer parse(JsonReader paramJsonReader, float paramFloat)
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
    double d8 = paramJsonReader.nextDouble();
    double d7 = paramJsonReader.nextDouble();
    double d6 = paramJsonReader.nextDouble();
    double d5 = paramJsonReader.nextDouble();
    if (i != 0) {
      paramJsonReader.endArray();
    }
    double d4 = d8;
    double d3 = d7;
    double d2 = d6;
    double d1 = d5;
    if (d8 <= 1.0D)
    {
      d4 = d8;
      d3 = d7;
      d2 = d6;
      d1 = d5;
      if (d7 <= 1.0D)
      {
        d4 = d8;
        d3 = d7;
        d2 = d6;
        d1 = d5;
        if (d6 <= 1.0D)
        {
          d4 = d8;
          d3 = d7;
          d2 = d6;
          d1 = d5;
          if (d5 <= 1.0D)
          {
            d4 = d8 * 255.0D;
            d3 = d7 * 255.0D;
            d2 = d6 * 255.0D;
            d1 = d5 * 255.0D;
          }
        }
      }
    }
    return Integer.valueOf(Color.argb((int)d1, (int)d4, (int)d3, (int)d2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ColorParser
 * JD-Core Version:    0.7.0.1
 */