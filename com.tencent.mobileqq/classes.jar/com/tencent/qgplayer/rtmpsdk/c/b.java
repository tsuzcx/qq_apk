package com.tencent.qgplayer.rtmpsdk.c;

public final class b
{
  public static final int a;
  
  static
  {
    if (e.a < 23) {}
    for (int i = 1020;; i = 6396)
    {
      a = i;
      return;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "MediaCodec exception unavailable input";
    case 2: 
      return "MediaCodec exception unavailable output";
    case 3: 
      return "init MediaCodec exception";
    case 4: 
      return "MediaCodec not support hevc";
    }
    return "render frame Exception";
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    }
    return "init soft decoder error";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.c.b
 * JD-Core Version:    0.7.0.1
 */