package com.tencent.mobileqq.filemanager.widget;

import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

class SendBottomBar$7$1
  extends AsyncTask<Object, Object, Integer>
{
  SendBottomBar$7$1(SendBottomBar.7 param7) {}
  
  protected Integer a(Object... paramVarArgs)
  {
    paramVarArgs = FMDataCache.g();
    Iterator localIterator = paramVarArgs.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      if (localFileInfo.j()) {
        break;
      }
      if (!((IQQFileEngine)SendBottomBar.q(this.a.this$0).getRuntimeService(IQQFileEngine.class)).isFileInUploaderQueue(localFileInfo.d())) {
        try
        {
          localObject = new File(localFileInfo.d());
          if (!((File)localObject).exists())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("local file can scan, is not existed? file:");
            ((StringBuilder)localObject).append(localFileInfo.d());
            QLog.e("delDownloadFiles<FileAssistant>", 1, ((StringBuilder)localObject).toString());
          }
          else
          {
            ((File)localObject).delete();
            SendBottomBar.a(this.a.this$0, SendBottomBar.r(this.a.this$0) + localFileInfo.f());
            i += 1;
          }
        }
        catch (Exception localException)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("del file error:");
          ((StringBuilder)localObject).append(localException.toString());
          QLog.e("delDownloadFiles<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
    SendBottomBar.c(this.a.this$0).a(paramVarArgs);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setStorageRptNeedScan(true);
    return Integer.valueOf(i);
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.this$0.e();
    paramInteger = new Intent();
    paramInteger.putExtra("extra_delete_total_file_size", SendBottomBar.r(this.a.this$0));
    SendBottomBar.c(this.a.this$0).setResult(-1, paramInteger);
    FMDataCache.d();
    this.a.this$0.a();
    SendBottomBar.f(this.a.this$0).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.7.1
 * JD-Core Version:    0.7.0.1
 */