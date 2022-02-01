package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;

public class ColorParser
  implements ValueParser<Integer>
{
  public static final ColorParser INSTANCE = new ColorParser();
  
  public Integer parse(JsonReader paramJsonReader, float paramFloat)
  {
    int i;
    if (paramJsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
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
    double d1;
    if (paramJsonReader.peek() == JsonReader.Token.NUMBER) {
      d1 = paramJsonReader.nextDouble();
    } else {
      d1 = 1.0D;
    }
    if (i != 0) {
      paramJsonReader.endArray();
    }
    double d2 = d8;
    double d3 = d7;
    double d4 = d6;
    double d5 = d1;
    if (d8 <= 1.0D)
    {
      d2 = d8;
      d3 = d7;
      d4 = d6;
      d5 = d1;
      if (d7 <= 1.0D)
      {
        d2 = d8;
        d3 = d7;
        d4 = d6;
        d5 = d1;
        if (d6 <= 1.0D)
        {
          d8 *= 255.0D;
          d7 *= 255.0D;
          d6 *= 255.0D;
          d2 = d8;
          d3 = d7;
          d4 = d6;
          d5 = d1;
          if (d1 <= 1.0D)
          {
            d5 = d1 * 255.0D;
            d4 = d6;
            d3 = d7;
            d2 = d8;
          }
        }
      }
    }
    return Integer.valueOf(Color.argb((int)d5, (int)d2, (int)d3, (int)d4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ColorParser
 * JD-Core Version:    0.7.0.1
 */