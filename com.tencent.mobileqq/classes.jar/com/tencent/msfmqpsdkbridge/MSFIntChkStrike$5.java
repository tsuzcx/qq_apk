package com.tencent.msfmqpsdkbridge;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class MSFIntChkStrike$5
  extends BroadcastReceiver
{
  MSFIntChkStrike$5(MSFIntChkStrike paramMSFIntChkStrike, DownloadManager paramDownloadManager) {}
  
  @SuppressLint({"NewApi"})
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", -1L);
    if (MSFIntChkStrike.access$200(this.this$0) == l)
    {
      Object localObject = new DownloadManager.Query();
      ((DownloadManager.Query)localObject).setFilterById(new long[] { l });
      paramIntent = null;
      try
      {
        localObject = this.val$downloader.query((DownloadManager.Query)localObject);
        if (localObject != null)
        {
          paramIntent = (Intent)localObject;
          if (((Cursor)localObject).moveToFirst())
          {
            paramIntent = (Intent)localObject;
            String str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("local_filename"));
            paramIntent = str;
            break label105;
          }
        }
        paramIntent = "";
        label105:
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
        if (TextUtils.isEmpty(paramIntent))
        {
          FileManagerUtil.b(paramContext, paramIntent);
          return;
        }
      }
      finally
      {
        if (paramIntent != null) {
          paramIntent.close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFIntChkStrike.5
 * JD-Core Version:    0.7.0.1
 */