package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

final class ReportLogUtil$2
  implements Runnable
{
  ReportLogUtil$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = new File(this.val$logPath).listFiles();
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = localObject1.length;
      int i = 0;
      Object localObject2;
      while (i < j)
      {
        localObject2 = localObject1[i];
        Object localObject3;
        if (((File)localObject2).length() == 0L)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("file:");
            ((StringBuilder)localObject3).append(((File)localObject2).getName());
            ((StringBuilder)localObject3).append(" size is 0");
            QLog.d("ReportLogUtil", 2, ((StringBuilder)localObject3).toString());
          }
          ((File)localObject2).delete();
        }
        else
        {
          localObject3 = ((File)localObject2).getName();
          if ((((String)localObject3).contains("log")) && (!((String)localObject3).endsWith(".zip"))) {
            localArrayList.add(new MiniLogManager.LogFile(((File)localObject2).getPath()));
          }
        }
        i += 1;
      }
      try
      {
        localObject1 = ReportLogUtil.access$000().format(Long.valueOf(System.currentTimeMillis()));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.val$logPath);
        ((StringBuilder)localObject2).append("miniLog_");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".zip");
        localObject1 = ((StringBuilder)localObject2).toString();
        if (localArrayList.size() > 0)
        {
          localObject2 = new File((String)localObject1);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          ((File)localObject2).createNewFile();
          ReportLogUtil.zipFiles(localArrayList, (String)localObject1);
          ReportLogUtil.uploadLogAndReport(this.val$appId, (String)localObject1);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("compressAndUploadLog error ");
          ((StringBuilder)localObject1).append(localThrowable);
          QLog.e("ReportLogUtil", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.2
 * JD-Core Version:    0.7.0.1
 */