package com.tencent.plato.core.utils;

public abstract interface IReporter
{
  public static final String REPORT_TIMECOST_DOM = "timecost_dom";
  public static final String REPORT_TIMECOST_INIT = "timecost_init";
  public static final String REPORT_TIMECOST_LAYOUT = "timecost_layout";
  public static final String REPORT_TIMECOST_RENDER = "timecost_render";
  public static final String REPORT_TIMECOST_TOTAL = "timecost_total";
  public static final int REPORT_TYPE_NOMAL = 0;
  public static final int REPORT_TYPE_OTHER = 2;
  public static final int REPORT_TYPE_TIMECOST = 1;
  
  public abstract void report(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.utils.IReporter
 * JD-Core Version:    0.7.0.1
 */