package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopPhotoController$3
  implements Runnable
{
  TroopPhotoController$3(TroopPhotoController paramTroopPhotoController, AvatarInfo paramAvatarInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    if (!((TroopPhotoController)localObject).b(((TroopPhotoController)localObject).o.troopuin)) {
      this.this$0.r.a(this.this$0.o.troopuin);
    }
    localObject = this.this$0.z.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)((Iterator)localObject).next();
      if (localTroopClipPic.ts == this.a.n) {
        this.this$0.z.remove(localTroopClipPic);
      }
    }
    this.this$0.y.remove(this.a);
    this.this$0.a(this.a);
    TroopPhotoController.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.3
 * JD-Core Version:    0.7.0.1
 */