package com.tencent.mobileqq.filemanager.widget;

import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

class SendBottomBar$7$1
  extends AsyncTask<Object, Object, Integer>
{
  SendBottomBar$7$1(SendBottomBar.7 param7) {}
  
  protected Integer a(Object... paramVarArgs)
  {
    paramVarArgs = FMDataCache.a();
    Iterator localIterator = paramVarArgs.iterator();
    int i = 0;
    VFSFile localVFSFile;
    for (;;)
    {
      FileInfo localFileInfo;
      if (localIterator.hasNext())
      {
        localFileInfo = (FileInfo)localIterator.next();
        if (!localFileInfo.b()) {}
      }
      else
      {
        SendBottomBar.a(this.a.this$0).a(paramVarArgs);
        StorageReport.a().a(true);
        return Integer.valueOf(i);
      }
      if (!SendBottomBar.a(this.a.this$0).getFileManagerRSCenter().a(localFileInfo.c())) {
        try
        {
          localVFSFile = new VFSFile(localFileInfo.c());
          if (!localVFSFile.exists()) {
            QLog.e("delDownloadFiles<FileAssistant>", 1, "local file can scan, is not existed? file:" + localFileInfo.c());
          }
        }
        catch (Exception localException)
        {
          QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + localException.toString());
        }
      }
    }
    for (;;)
    {
      break;
      localVFSFile.delete();
      SendBottomBar.a(this.a.this$0, SendBottomBar.a(this.a.this$0) + localException.a());
      i += 1;
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.this$0.e();
    paramInteger = new Intent();
    paramInteger.putExtra("extra_delete_total_file_size", SendBottomBar.a(this.a.this$0));
    SendBottomBar.a(this.a.this$0).setResult(-1, paramInteger);
    FMDataCache.b();
    this.a.this$0.a();
    SendBottomBar.a(this.a.this$0).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.7.1
 * JD-Core Version:    0.7.0.1
 */