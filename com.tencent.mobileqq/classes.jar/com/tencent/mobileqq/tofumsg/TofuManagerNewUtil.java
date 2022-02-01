package com.tencent.mobileqq.tofumsg;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TofuManagerNewUtil
{
  @SuppressLint({"SimpleDateFormat"})
  public static String a()
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuManagerNewUtil
 * JD-Core Version:    0.7.0.1
 */