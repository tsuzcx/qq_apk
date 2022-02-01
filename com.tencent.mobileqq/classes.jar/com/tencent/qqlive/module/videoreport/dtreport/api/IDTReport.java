package com.tencent.qqlive.module.videoreport.dtreport.api;

import java.util.Map;

public abstract interface IDTReport
{
  public abstract boolean dtEvent(Object paramObject, String paramString, Map<String, String> paramMap, boolean paramBoolean);
  
  public abstract boolean dtEvent(Object paramObject, String paramString1, Map<String, String> paramMap, boolean paramBoolean, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport
 * JD-Core Version:    0.7.0.1
 */