package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FileManagerDataCenter$2$1
  extends BroadcastReceiver
{
  FileManagerDataCenter$2$1(FileManagerDataCenter.2 param2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("com.opensdk.downloadmanager.renameFilename")))
    {
      paramContext = paramIntent.getBundleExtra("extraBundle");
      FileManagerDataCenter.a(this.a.this$0, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.2.1
 * JD-Core Version:    0.7.0.1
 */