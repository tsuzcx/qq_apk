package com.tencent.qqlive.module.videoreport.report;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.util.Map;

public abstract interface FinalDataTarget$IFinalDataHandleListener
{
  public abstract void onHandleFinalData(Object paramObject, @NonNull FinalData paramFinalData, @NonNull Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget.IFinalDataHandleListener
 * JD-Core Version:    0.7.0.1
 */