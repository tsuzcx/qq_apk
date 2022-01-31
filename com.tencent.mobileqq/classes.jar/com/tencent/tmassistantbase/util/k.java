package com.tencent.tmassistantbase.util;

import java.text.SimpleDateFormat;

final class k
  extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyyMMddHH");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.k
 * JD-Core Version:    0.7.0.1
 */