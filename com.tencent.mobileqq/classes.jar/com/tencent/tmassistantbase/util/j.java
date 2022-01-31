package com.tencent.tmassistantbase.util;

import java.text.SimpleDateFormat;

final class j
  extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyyMMdd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.j
 * JD-Core Version:    0.7.0.1
 */