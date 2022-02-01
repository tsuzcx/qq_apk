package com.tencent.mobileqq.filemanager.fileviewer;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FileBrowserActivity$6
  extends BroadcastReceiver
{
  FileBrowserActivity$6(FileBrowserActivity paramFileBrowserActivity) {}
  
  @TargetApi(5)
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.6
 * JD-Core Version:    0.7.0.1
 */