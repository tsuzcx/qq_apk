package com.tencent.msfmqpsdkbridge;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import arrr;

class MSFIntChkStrike$5
  extends BroadcastReceiver
{
  MSFIntChkStrike$5(MSFIntChkStrike paramMSFIntChkStrike, DownloadManager paramDownloadManager) {}
  
  @SuppressLint({"NewApi"})
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", -1L);
    String str;
    Object localObject;
    if (MSFIntChkStrike.access$200(this.this$0) == l)
    {
      str = "";
      localObject = new DownloadManager.Query();
      ((DownloadManager.Query)localObject).setFilterById(new long[] { l });
      paramIntent = null;
    }
    try
    {
      Cursor localCursor = this.val$downloader.query((DownloadManager.Query)localObject);
      localObject = str;
      if (localCursor != null)
      {
        localObject = str;
        paramIntent = localCursor;
        if (localCursor.moveToFirst())
        {
          paramIntent = localCursor;
          localObject = localCursor.getString(localCursor.getColumnIndex("local_filename"));
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        arrr.b(paramContext, (String)localObject);
      }
      return;
    }
    finally
    {
      if (paramIntent != null) {
        paramIntent.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFIntChkStrike.5
 * JD-Core Version:    0.7.0.1
 */