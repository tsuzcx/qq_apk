package com.tencent.mobileqq.startup.step;

import android.text.TextUtils;
import com.tencent.trackrecordlib.core.IRecordCallback;
import cooperation.qzone.report.wmd.WMDReportManager;

class RecordTracer$2
  implements IRecordCallback
{
  RecordTracer$2(RecordTracer paramRecordTracer) {}
  
  public void onRecordEvent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      WMDReportManager.getInstance().report(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.RecordTracer.2
 * JD-Core Version:    0.7.0.1
 */