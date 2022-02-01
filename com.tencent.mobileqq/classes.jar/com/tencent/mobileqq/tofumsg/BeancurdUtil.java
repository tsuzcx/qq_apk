package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.beancurd.IBeancurdBusinessHandler;
import java.util.HashMap;
import java.util.Map;

public class BeancurdUtil
{
  private static Map<Integer, IBeancurdBusinessHandler> a = new HashMap();
  
  static
  {
    b();
  }
  
  public static Map<Integer, IBeancurdBusinessHandler> a()
  {
    return a;
  }
  
  private static void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.BeancurdUtil
 * JD-Core Version:    0.7.0.1
 */