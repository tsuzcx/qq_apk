package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import java.util.ArrayList;
import java.util.Iterator;

class TroopPhotoController$2
  implements Runnable
{
  TroopPhotoController$2(TroopPhotoController paramTroopPhotoController, TroopUploadingThread.UploadState paramUploadState, AvatarInfo paramAvatarInfo, int paramInt) {}
  
  public void run()
  {
    int i = this.a.c;
    Object localObject = this.b;
    ((AvatarInfo)localObject).g = false;
    ((AvatarInfo)localObject).e = 1;
    ((AvatarInfo)localObject).j = false;
    this.this$0.c((AvatarInfo)localObject);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i >= 1)) {
      this.this$0.a(this.c, this.b);
    }
    localObject = this.this$0.z.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)((Iterator)localObject).next();
      if (localTroopClipPic.ts == this.b.n) {
        this.this$0.z.remove(localTroopClipPic);
      }
    }
    this.this$0.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.2
 * JD-Core Version:    0.7.0.1
 */