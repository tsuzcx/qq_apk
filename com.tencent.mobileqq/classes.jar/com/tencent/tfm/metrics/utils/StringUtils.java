package com.tencent.tfm.metrics.utils;

public class StringUtils
{
  public static String dealUploadValue(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replaceAll(";", "_").replaceAll("~", "_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.utils.StringUtils
 * JD-Core Version:    0.7.0.1
 */