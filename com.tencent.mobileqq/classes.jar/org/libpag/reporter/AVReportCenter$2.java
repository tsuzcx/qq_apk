package org.libpag.reporter;

import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class AVReportCenter$2
  implements Runnable
{
  AVReportCenter$2(AVReportCenter paramAVReportCenter, Map paramMap) {}
  
  public void run()
  {
    if (AVReportCenter.access$200(this.this$0) == null)
    {
      AVReportCenter localAVReportCenter = this.this$0;
      File localFile = new File(AVReportCenter.access$000(localAVReportCenter));
      Boolean localBoolean = AVReportCenter.access$300(this.this$0);
      if (AVReportCenter.access$400(this.this$0)) {
        localObject = AVReportCenter.access$500(this.this$0).getLooper();
      } else {
        localObject = null;
      }
      AVReportCenter.access$202(localAVReportCenter, new Reporter(localFile, localBoolean, (Looper)localObject));
    }
    Object localObject = new HashMap();
    AVReportCenter.access$600(this.this$0, (Map)localObject);
    ((Map)localObject).putAll(this.val$data);
    AVReportCenter.access$700(this.this$0, (Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.reporter.AVReportCenter.2
 * JD-Core Version:    0.7.0.1
 */