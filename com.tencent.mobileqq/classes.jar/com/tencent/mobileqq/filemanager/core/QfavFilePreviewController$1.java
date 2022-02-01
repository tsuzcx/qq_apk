package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;

class QfavFilePreviewController$1
  implements FavoritesRemoteCommand.IRemoteCommandHandler
{
  QfavFilePreviewController$1(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public boolean a(int paramInt, Bundle paramBundle)
  {
    new Handler(Looper.getMainLooper()).post(new QfavFilePreviewController.1.1(this, paramBundle));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1
 * JD-Core Version:    0.7.0.1
 */