package com.tencent.mobileqq.guild.setting.controller;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarManger;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QQGuildPhotoController$3
  implements Runnable
{
  QQGuildPhotoController$3(QQGuildPhotoController paramQQGuildPhotoController, AvatarInfo paramAvatarInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    if (!QQGuildPhotoController.a((QQGuildPhotoController)localObject, ((QQGuildPhotoController)localObject).e.troopuin)) {
      this.this$0.h.a(this.this$0.e.troopuin);
    }
    localObject = this.this$0.z.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)((Iterator)localObject).next();
      if (localTroopClipPic.ts == this.a.n) {
        this.this$0.z.remove(localTroopClipPic);
      }
    }
    this.this$0.i.remove(this.a);
    this.this$0.a(this.a);
    TroopPhotoController.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.controller.QQGuildPhotoController.3
 * JD-Core Version:    0.7.0.1
 */