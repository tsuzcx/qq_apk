package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.AccountObserver;

class TroopPhotoController$8
  extends AccountObserver
{
  TroopPhotoController$8(TroopPhotoController paramTroopPhotoController) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.a.z.size();
    if (paramString1 == null)
    {
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        paramString1 = this.a;
        paramString1 = TroopPhotoController.a(paramString1, ((TroopClipPic)paramString1.z.get(j)).ts);
        if (paramString1 != null)
        {
          this.a.y.remove(paramString1);
          this.a.a(paramString1);
        }
        i = j;
      }
      this.a.z.clear();
      return;
    }
    paramString2 = this.a;
    paramString2.u = paramString1;
    paramString2.a(paramString2.z, this.a.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.8
 * JD-Core Version:    0.7.0.1
 */