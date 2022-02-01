package com.tencent.mobileqq.troop.avatar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TroopAvatarManger$1
  implements Runnable
{
  TroopAvatarManger$1(TroopAvatarManger paramTroopAvatarManger, Bundle paramBundle, AppInterface paramAppInterface, UploadingTask paramUploadingTask, Class paramClass, ArrayList paramArrayList, HashMap paramHashMap) {}
  
  public void run()
  {
    TroopAvatarManger.a(this.this$0).a(this.a);
    TroopAvatarManger.a(this.this$0).b(this.b);
    List localList = TroopAvatarManger.a(this.this$0).a(this.b);
    this.c.a(this.d, this.e, this.f, localList, TroopAvatarManger.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarManger.1
 * JD-Core Version:    0.7.0.1
 */