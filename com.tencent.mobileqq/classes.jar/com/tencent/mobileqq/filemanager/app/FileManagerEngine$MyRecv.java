package com.tencent.mobileqq.filemanager.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper;
import com.tencent.qphone.base.util.QLog;

class FileManagerEngine$MyRecv
  extends BroadcastReceiver
{
  private FileManagerEngine$MyRecv(FileManagerEngine paramFileManagerEngine) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("!!!extCard changed[");
    paramContext.append(paramIntent.getAction());
    paramContext.append("]!!!");
    QLog.i("FileManagerEngine<FileAssistant>", 1, paramContext.toString());
    paramContext = paramIntent.getAction();
    if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTABLE")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_EJECT")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED"))) {
      FMSettings.a().remove("externalSdCard");
    }
    try
    {
      this.a.a.getFileManagerRSCenter().a(true);
      this.a.a.getFileManagerEngine().j().b();
      this.a.a.getFileManagerEngine().l().b();
    }
    catch (Exception paramIntent)
    {
      label141:
      break label141;
    }
    if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_MOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_SCANNER_STARTED"))) {
      FMSettings.a().refreshInfos();
    }
    this.a.a.getFileManagerNotifyCenter().a(true, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.MyRecv
 * JD-Core Version:    0.7.0.1
 */