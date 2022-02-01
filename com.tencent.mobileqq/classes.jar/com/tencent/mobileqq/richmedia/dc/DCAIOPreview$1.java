package com.tencent.mobileqq.richmedia.dc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;

class DCAIOPreview$1
  extends Handler
{
  DCAIOPreview$1(DCAIOPreview paramDCAIOPreview, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = DCAIOPreview.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)DCAIOPreview.a(this.a).valueAt(i);
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview", localAIOPreviewData.a("Pic.AioPreview")));
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview.Preload", localAIOPreviewData.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview.1
 * JD-Core Version:    0.7.0.1
 */