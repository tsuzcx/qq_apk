package com.tencent.mobileqq.guild.setting.controller;

import android.app.Activity;
import com.tencent.mobileqq.guild.util.GuildCoverUtils;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;

class QQGuildPhotoController$2
  implements Runnable
{
  QQGuildPhotoController$2(QQGuildPhotoController paramQQGuildPhotoController, TroopUploadingThread.UploadState paramUploadState) {}
  
  public void run()
  {
    String str = GuildCoverUtils.b(this.a.b);
    int i;
    if (this.a.b == 0) {
      i = 2;
    } else {
      i = 0;
    }
    TroopPhotoController.a(str, i);
    if (this.this$0.a != null) {
      this.this$0.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.controller.QQGuildPhotoController.2
 * JD-Core Version:    0.7.0.1
 */