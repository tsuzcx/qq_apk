package com.tencent.qapmsdk.qqbattery.config;

abstract class BaseMeta<T>
{
  public static final String MIN_SEPERATOR = ",";
  public static final String SUB_SEPERATOR = ";";
  
  public abstract T parse(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.config.BaseMeta
 * JD-Core Version:    0.7.0.1
 */