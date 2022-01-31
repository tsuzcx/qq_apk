package com.tencent.upload.report;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;

public class ReportManager
{
  private static final String TAG = "ReportManager";
  private static volatile ReportManager sInstance;
  private final int TIME_REPORT_DELAY = 5000;
  private final int WHAT_ADD_TO_CACHE = 1001;
  private final int WHAT_REPORT_DELAY = 1002;
  private final List<ReportEvent> mReportEvents = new ArrayList();
  private Handler mReportHandler;
  
  private ReportManager()
  {
    HandlerThread localHandlerThread = new HandlerThread("upload-report");
    localHandlerThread.start();
    this.mReportHandler = new ReportManager.1(this, localHandlerThread.getLooper());
  }
  
  public static ReportManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ReportManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void report(Report paramReport)
  {
    long l1 = paramReport.endTime;
    long l2 = paramReport.startTime;
    float f = (float)paramReport.fileSize * 1.0F * 1000.0F / (float)((l1 - l2) * 1024L);
    UploadLog.d("ReportManager", "[speed]" + f + "kb/s");
    UploadGlobalConfig.getUploadReport().onUploadReport(paramReport);
  }
  
  public void report(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = paramAbstractUploadTask.getReportObj();
    if (paramAbstractUploadTask.retCode != 0)
    {
      report(paramAbstractUploadTask);
      return;
    }
    this.mReportHandler.removeMessages(1002);
    Message localMessage = Message.obtain(this.mReportHandler, 1001);
    localMessage.obj = paramAbstractUploadTask;
    this.mReportHandler.sendMessage(localMessage);
    paramAbstractUploadTask = Message.obtain(this.mReportHandler, 1002);
    this.mReportHandler.sendMessageDelayed(paramAbstractUploadTask, 5000L);
  }
  
  public void reportTaskStart(AbstractUploadTask paramAbstractUploadTask)
  {
    Report localReport = new Report();
    localReport.reportType = 1;
    localReport.uploadType = paramAbstractUploadTask.getUploadTaskType();
    localReport.entry = paramAbstractUploadTask.entry;
    localReport.refer = paramAbstractUploadTask.reportRefer;
    UploadGlobalConfig.getUploadReport().onUploadReport(localReport);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.report.ReportManager
 * JD-Core Version:    0.7.0.1
 */