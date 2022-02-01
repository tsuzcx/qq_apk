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
    int i = paramMessage.what;
    if (i != 1001)
    {
      if (i != 1002) {
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
    paramMessage = (Report)paramMessage.obj;
    Object localObject = ReportManager.access$000(this.this$0).iterator();
    boolean bool1;
    do
    {
      boolean bool2 = ((Iterator)localObject).hasNext();
      bool1 = true;
      if (!bool2) {
        break;
      }
    } while (!((ReportEvent)((Iterator)localObject).next()).add(paramMessage));
    i = 1;
    break label139;
    i = 0;
    label139:
    if (i == 0)
    {
      if (paramMessage.uploadType.serverRouteTable.supportFileType != Const.FileType.Photo) {
        bool1 = false;
      }
      localObject = new ReportEvent(bool1);
      ((ReportEvent)localObject).add(paramMessage);
      ReportManager.access$000(this.this$0).add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.report.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */