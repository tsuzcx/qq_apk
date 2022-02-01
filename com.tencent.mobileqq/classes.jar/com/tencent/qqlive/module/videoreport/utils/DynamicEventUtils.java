package com.tencent.qqlive.module.videoreport.utils;

import java.util.ArrayList;
import java.util.List;

public class DynamicEventUtils
{
  private static final List<String> FILTER_MAP = new ArrayList();
  
  static
  {
    FILTER_MAP.add("imp");
    FILTER_MAP.add("imp_end");
    FILTER_MAP.add("clck");
    FILTER_MAP.add("pgin");
    FILTER_MAP.add("pgout");
    FILTER_MAP.add("dt_submit");
  }
  
  public static boolean filterDynamicEvent(String paramString)
  {
    return FILTER_MAP.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.DynamicEventUtils
 * JD-Core Version:    0.7.0.1
 */