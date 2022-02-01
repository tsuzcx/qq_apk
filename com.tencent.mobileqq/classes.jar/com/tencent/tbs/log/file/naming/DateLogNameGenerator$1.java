package com.tencent.tbs.log.file.naming;

import java.text.SimpleDateFormat;
import java.util.Locale;

class DateLogNameGenerator$1
  extends ThreadLocal<SimpleDateFormat>
{
  DateLogNameGenerator$1(DateLogNameGenerator paramDateLogNameGenerator) {}
  
  protected SimpleDateFormat initialValue()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.US);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.file.naming.DateLogNameGenerator.1
 * JD-Core Version:    0.7.0.1
 */