package com.tencent.mobileqq.winkpublish.uploader;

import android.text.TextUtils;
import com.tencent.mobileqq.winkpublish.uploader.report.AUploadBusinessReport;
import com.tencent.upload.report.Report;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.util.Map;

public class AUploadReport
  implements IUploadReport
{
  public static int a(TaskTypeConfig paramTaskTypeConfig)
  {
    if (TaskTypeConfig.NewQunUploadTaskType.equals(paramTaskTypeConfig)) {
      return 10;
    }
    if (TaskTypeConfig.ImageUploadTaskType.equals(paramTaskTypeConfig)) {
      return 0;
    }
    if (TaskTypeConfig.UppUploadTaskType.equals(paramTaskTypeConfig)) {
      return 8;
    }
    if (TaskTypeConfig.UpsUploadTaskType.equals(paramTaskTypeConfig)) {
      return 12;
    }
    if (TaskTypeConfig.PhotoWallUploadTaskType.equals(paramTaskTypeConfig)) {
      return 14;
    }
    if (TaskTypeConfig.MobileLogUploadTaskType.equals(paramTaskTypeConfig)) {
      return 16;
    }
    if (TaskTypeConfig.VideoUploadTaskType.equals(paramTaskTypeConfig)) {
      return 2;
    }
    return -1;
  }
  
  public static AUploadReport.UploadReportObj a(Report paramReport)
  {
    if (paramReport == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramReport.filePath)) {
      new String(paramReport.filePath);
    }
    Object localObject = paramReport.transfer;
    if (localObject != null)
    {
      TextUtils.isEmpty((String)((Map)localObject).get("task_state"));
      TextUtils.isEmpty((String)((Map)localObject).get("business_refer"));
    }
    localObject = new AUploadReport.UploadReportObj();
    int i = a(paramReport.uploadType);
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 8)
        {
          if (i != 10)
          {
            if (i != 12)
            {
              if (i != 14)
              {
                if (i == 16)
                {
                  localObject = new AUploadReport.UploadReportObj();
                  ((AUploadReport.UploadReportObj)localObject).u = "mobilelog";
                }
              }
              else
              {
                localObject = new AUploadReport.UploadReportObj();
                ((AUploadReport.UploadReportObj)localObject).u = "photowall";
              }
            }
            else
            {
              localObject = new AUploadReport.UploadReportObj();
              ((AUploadReport.UploadReportObj)localObject).u = "ups";
            }
          }
          else
          {
            localObject = new AUploadReport.QQQunReportObj();
            ((AUploadReport.UploadReportObj)localObject).u = "qun";
          }
        }
        else
        {
          localObject = new AUploadReport.UppReportObj();
          ((AUploadReport.UploadReportObj)localObject).u = "upp";
        }
      }
      else
      {
        localObject = new AUploadReport.UploadReportObj();
        ((AUploadReport.UploadReportObj)localObject).u = "video";
      }
    }
    else
    {
      localObject = new AUploadReport.UploadReportObj();
      ((AUploadReport.UploadReportObj)localObject).u = "photo";
    }
    ((AUploadReport.UploadReportObj)localObject).n = paramReport.serverIp;
    ((AUploadReport.UploadReportObj)localObject).a = paramReport.retry;
    ((AUploadReport.UploadReportObj)localObject).b = paramReport.ipsrctype;
    ((AUploadReport.UploadReportObj)localObject).q = paramReport.flowId;
    ((AUploadReport.UploadReportObj)localObject).l = paramReport.networkType;
    ((AUploadReport.UploadReportObj)localObject).m = paramReport.retCode;
    ((AUploadReport.UploadReportObj)localObject).o = paramReport.fileSize;
    ((AUploadReport.UploadReportObj)localObject).s = paramReport.startTime;
    ((AUploadReport.UploadReportObj)localObject).t = paramReport.endTime;
    ((AUploadReport.UploadReportObj)localObject).p = (paramReport.endTime - paramReport.startTime);
    StringBuilder localStringBuilder = ((AUploadReport.UploadReportObj)localObject).r;
    String str;
    if (paramReport.errMsg == null) {
      str = "";
    } else {
      str = paramReport.errMsg;
    }
    localStringBuilder.append(str);
    ((AUploadReport.UploadReportObj)localObject).c = paramReport.entry;
    ((AUploadReport.UploadReportObj)localObject).d = (paramReport.ctrlEnd - paramReport.ctrlStart);
    ((AUploadReport.UploadReportObj)localObject).e = (paramReport.dataEnd - paramReport.dataStart);
    ((AUploadReport.UploadReportObj)localObject).g = paramReport.reportType;
    ((AUploadReport.UploadReportObj)localObject).h = paramReport.isIPV6;
    return localObject;
  }
  
  public void batchComplete()
  {
    AUploadBusinessReport.a(0, 0);
    AUploadBusinessReport.a(2, 0);
  }
  
  public void onUploadReport(Report paramReport)
  {
    AUploadBusinessReport.a(a(paramReport), a(paramReport.uploadType), 0);
  }
  
  public void openSessionReport(int paramInt1, String paramString1, String paramString2, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.AUploadReport
 * JD-Core Version:    0.7.0.1
 */