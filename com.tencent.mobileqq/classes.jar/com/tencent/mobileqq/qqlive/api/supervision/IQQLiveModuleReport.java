package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.supervision.ReportCallback;

public abstract interface IQQLiveModuleReport
  extends IQQLiveModule
{
  public abstract void report(long paramLong1, long paramLong2, long paramLong3, String paramString, ReportCallback paramReportCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport
 * JD-Core Version:    0.7.0.1
 */