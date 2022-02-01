package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import java.util.List;
import java.util.Map;

public abstract interface IFormatter
{
  public abstract Map<String, Object> formatElementParams(@NonNull List<ReportData> paramList, ReportData paramReportData);
  
  public abstract Map<String, Object> formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.IFormatter
 * JD-Core Version:    0.7.0.1
 */