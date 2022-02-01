package com.tencent.tmassistantbase.util;

import java.text.SimpleDateFormat;

final class i
  extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyyMMdd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.i
 * JD-Core Version:    0.7.0.1
 */