package com.tencent.weseevideo.common.utils;

import com.google.gson.stream.JsonReader;
import com.tencent.tavcut.util.Logger;
import java.io.Reader;

public class GsonUtils$ProxyJsonReader
  extends JsonReader
{
  private static final String TAG = "ProxyJsonReader";
  
  public GsonUtils$ProxyJsonReader(Reader paramReader)
  {
    super(paramReader);
  }
  
  public boolean nextBoolean()
  {
    try
    {
      boolean bool = super.nextBoolean();
      return bool;
    }
    catch (Exception localException)
    {
      Logger.e("ProxyJsonReader", "nextBoolean", localException);
    }
    return false;
  }
  
  public double nextDouble()
  {
    try
    {
      double d = super.nextDouble();
      return d;
    }
    catch (Exception localException)
    {
      Logger.e("ProxyJsonReader", "nextDouble", localException);
    }
    return 0.0D;
  }
  
  public int nextInt()
  {
    try
    {
      int i = super.nextInt();
      return i;
    }
    catch (Exception localException)
    {
      Logger.e("ProxyJsonReader", "nextInt", localException);
    }
    return 0;
  }
  
  public long nextLong()
  {
    try
    {
      long l = super.nextLong();
      return l;
    }
    catch (Exception localException)
    {
      Logger.e("ProxyJsonReader", "nextLong", localException);
    }
    return 0L;
  }
  
  public String nextName()
  {
    try
    {
      String str = super.nextName();
      return str;
    }
    catch (Exception localException)
    {
      Logger.e("ProxyJsonReader", "nextName", localException);
    }
    return "";
  }
  
  public String nextString()
  {
    try
    {
      String str = super.nextString();
      return str;
    }
    catch (Exception localException)
    {
      Logger.e("ProxyJsonReader", "nextString", localException);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.common.utils.GsonUtils.ProxyJsonReader
 * JD-Core Version:    0.7.0.1
 */