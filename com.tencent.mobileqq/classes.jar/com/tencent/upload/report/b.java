package com.tencent.upload.report;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.network.route.RouteFactory.ServerCategory;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static volatile b d;
  private final int a = 1001;
  private final int b = 1002;
  private final int c = 120000;
  private final List<a> e = new ArrayList();
  private Handler f;
  
  private b()
  {
    HandlerThread localHandlerThread = new HandlerThread("upload-report");
    localHandlerThread.start();
    this.f = new Handler(localHandlerThread.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        Object localObject;
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        case 1001: 
          paramAnonymousMessage = (Report)paramAnonymousMessage.obj;
          localObject = b.a(b.this).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!((a)((Iterator)localObject).next()).a(paramAnonymousMessage));
        }
        for (int i = 1; i == 0; i = 0)
        {
          if (paramAnonymousMessage.uploadType.serverCategory.supportFileType == Const.b.b) {}
          for (boolean bool = true;; bool = false)
          {
            localObject = new a(bool);
            ((a)localObject).a(paramAnonymousMessage);
            b.a(b.this).add(localObject);
            return;
          }
          com.tencent.upload.common.b.b("ReportManager", "start group report");
          paramAnonymousMessage = b.a(b.this).iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((a)paramAnonymousMessage.next()).a();
          }
          b.a(b.this).clear();
          return;
        }
      }
    };
  }
  
  public static b a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new b();
      }
      return d;
    }
    finally {}
  }
  
  public static void a(Report paramReport)
  {
    com.tencent.upload.common.a.c().onUploadReport(paramReport);
  }
  
  public void a(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = paramAbstractUploadTask.getReportObj();
    if (paramAbstractUploadTask.retCode != 0)
    {
      a(paramAbstractUploadTask);
      return;
    }
    this.f.removeMessages(1002);
    Message localMessage = Message.obtain(this.f, 1001);
    localMessage.obj = paramAbstractUploadTask;
    this.f.sendMessage(localMessage);
    paramAbstractUploadTask = Message.obtain(this.f, 1002);
    this.f.sendMessageDelayed(paramAbstractUploadTask, 120000L);
  }
  
  public void b(AbstractUploadTask paramAbstractUploadTask)
  {
    Report localReport = new Report();
    localReport.reportType = 1;
    localReport.uploadType = paramAbstractUploadTask.getUploadTaskType();
    localReport.entry = paramAbstractUploadTask.entry;
    localReport.refer = paramAbstractUploadTask.reportRefer;
    com.tencent.upload.common.a.c().onUploadReport(localReport);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.report.b
 * JD-Core Version:    0.7.0.1
 */