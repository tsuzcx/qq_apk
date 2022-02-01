package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.FavoritesRemoteCommand;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;

public class QfavFilePreviewController
  extends FilePreViewControllerBase
{
  private int b = 0;
  private int c = 80;
  private long d = 0L;
  private String e = null;
  private String f = null;
  private String g = null;
  private Handler h = new Handler(Looper.getMainLooper());
  private FavoritesRemoteCommand.IRemoteCommandHandler i = new QfavFilePreviewController.1(this);
  
  public QfavFilePreviewController(Bundle paramBundle)
  {
    QfavPluginProxyService.b().a(3, this.i);
    this.b = 2;
    this.h.postDelayed(new QfavFilePreviewController.2(this), 300000L);
  }
  
  public boolean a()
  {
    if (3 != this.b)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendCS: oldState = ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(", newState = STATE_REQUESTING.");
        QLog.i("QfavFilePreviewController", 4, localStringBuilder.toString());
      }
      this.b = 1;
      return true;
    }
    this.h.postDelayed(new QfavFilePreviewController.3(this), 2000L);
    return true;
  }
  
  public void b()
  {
    this.h.removeCallbacksAndMessages(null);
    QfavPluginProxyService.b().b(3, this.i);
  }
  
  public int c()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController
 * JD-Core Version:    0.7.0.1
 */