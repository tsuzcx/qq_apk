package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;

abstract interface ValueParser<V>
{
  public abstract V parse(JsonReader paramJsonReader, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ValueParser
 * JD-Core Version:    0.7.0.1
 */