package com.tencent.mobileqq.filemanager.widget;

import android.os.AsyncTask;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Iterator;

class SendBottomBar$16$1
  extends AsyncTask<Void, Void, Void>
{
  SendBottomBar$16$1(SendBottomBar.16 param16) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a.this$0).a();
    int i = SendBottomBar.a(this.a.this$0).a();
    Object localObject = SendBottomBar.a(this.a.this$0).b();
    if (i == 5)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendLocalFileToTroop(FMDataCache.a());
      return null;
    }
    if (paramVarArgs.equals(AppConstants.DATALINE_PC_UIN))
    {
      paramVarArgs = new ArrayList();
      paramVarArgs.addAll(FMDataCache.a());
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendFiles(paramVarArgs);
      paramVarArgs = FMDataCache.b().iterator();
      while (paramVarArgs.hasNext())
      {
        localObject = (FileManagerEntity)paramVarArgs.next();
        if (((FileManagerEntity)localObject).nFileType == 13) {
          ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendTencentDocEntity((FileManagerEntity)localObject);
        } else if ((((FileManagerEntity)localObject).getCloudType() == 2) && (((FileManagerEntity)localObject).WeiYunFileId != null)) {
          ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendWeiYunFile((FileManagerEntity)localObject);
        } else {
          ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).forwardFileManagerEntity((FileManagerEntity)localObject);
        }
      }
      paramVarArgs = FMDataCache.d().iterator();
      while (paramVarArgs.hasNext())
      {
        localObject = (WeiYunFileInfo)paramVarArgs.next();
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendWeiYunFile((WeiYunFileInfo)localObject);
      }
      if (FMDataCache.e().size() > 0)
      {
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendFavFiles(FMDataCache.e(), AppConstants.DATALINE_PC_UIN, 6000, null);
        return null;
      }
    }
    else
    {
      if (i == 6002)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).addAll(FMDataCache.a());
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendFilesWithService((ArrayList)localObject, null, null, Long.parseLong(paramVarArgs));
        return null;
      }
      if (i == 9501)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).addAll(FMDataCache.a());
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendFilesToDevice(paramVarArgs, (ArrayList)localObject);
        return null;
      }
      boolean bool = SendBottomBar.a(this.a.this$0).i();
      ((IQQFileEngine)SendBottomBar.a(this.a.this$0).getRuntimeService(IQQFileEngine.class)).sendAllSelectedFiles(bool, (String)localObject, paramVarArgs, i);
      int j = 0;
      paramVarArgs = FMDataCache.b().iterator();
      do
      {
        i = j;
        if (!paramVarArgs.hasNext()) {
          break;
        }
      } while (((FileManagerEntity)paramVarArgs.next()).nFileType != 13);
      i = 1;
      if (i != 0)
      {
        if (SendBottomBar.a(this.a.this$0) == 3)
        {
          ReportController.b(SendBottomBar.a(this.a.this$0).a, "dc00898", "", "", "0X800A088", "0X800A088", 0, 0, "", "", "", "");
          return null;
        }
        if (SendBottomBar.a(this.a.this$0) == 21) {
          ReportController.b(SendBottomBar.a(this.a.this$0).a, "dc00898", "", "", "0X800A08D", "0X800A08D", 0, 0, "", "", "", "");
        }
      }
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.this$0.e();
    FMDataCache.b();
    SendBottomBar.j(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.16.1
 * JD-Core Version:    0.7.0.1
 */