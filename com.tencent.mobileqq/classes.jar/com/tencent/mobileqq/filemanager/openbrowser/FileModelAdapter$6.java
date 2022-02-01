package com.tencent.mobileqq.filemanager.openbrowser;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnEventListener;

class FileModelAdapter$6
  extends BroadcastReceiver
{
  @TargetApi(5)
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(paramIntent.getAction())) && (FileModelAdapter.b(this.a) != null)) {
      FileModelAdapter.b(this.a).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter.6
 * JD-Core Version:    0.7.0.1
 */