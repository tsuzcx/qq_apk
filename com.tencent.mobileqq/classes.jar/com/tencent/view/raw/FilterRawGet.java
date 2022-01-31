package com.tencent.view.raw;

import java.io.InputStream;

public class FilterRawGet
{
  private static GetInputStream mGetInputStream;
  
  public static void setGetInputStream(GetInputStream paramGetInputStream)
  {
    mGetInputStream = paramGetInputStream;
  }
  
  public InputStream getInpuStream(String paramString)
  {
    try
    {
      if (mGetInputStream != null) {
        paramString = mGetInputStream.getInputStream(paramString);
      } else {
        paramString = getClass().getResourceAsStream(paramString);
      }
    }
    catch (Exception paramString)
    {
      return null;
    }
    return paramString;
  }
  
  public static abstract interface GetInputStream
  {
    public abstract InputStream getInputStream(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.view.raw.FilterRawGet
 * JD-Core Version:    0.7.0.1
 */