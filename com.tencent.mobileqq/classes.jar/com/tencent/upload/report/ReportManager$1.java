package com.tencent.upload.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.UploadLog;
import java.util.Iterator;
import java.util.List;

class ReportManager$1
  extends Handler
{
  ReportManager$1(ReportManager paramReportManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      paramMessage = (Report)paramMessage.obj;
      localObject = ReportManager.access$000(this.this$0).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ReportEvent)((Iterator)localObject).next()).add(paramMessage));
    }
    for (int i = 1; i == 0; i = 0)
    {
      if (paramMessage.uploadType.serverRouteTable.supportFileType == Const.FileType.Photo) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = new ReportEvent(bool);
        ((ReportEvent)localObject).add(paramMessage);
        ReportManager.access$000(this.this$0).add(localObject);
        return;
      }
      UploadLog.d("ReportManager", "start group report");
      paramMessage = ReportManager.access$000(this.this$0).iterator();
      while (paramMessage.hasNext()) {
        ((ReportEvent)paramMessage.next()).report();
      }
      ReportManager.access$000(this.this$0).clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.report.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */