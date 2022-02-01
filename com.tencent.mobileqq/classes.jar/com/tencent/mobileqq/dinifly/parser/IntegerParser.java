package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;

public class IntegerParser
  implements ValueParser<Integer>
{
  public static final IntegerParser INSTANCE = new IntegerParser();
  
  public Integer parse(JsonReader paramJsonReader, float paramFloat)
  {
    return Integer.valueOf(Math.round(JsonUtils.valueFromObject(paramJsonReader) * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.IntegerParser
 * JD-Core Version:    0.7.0.1
 */