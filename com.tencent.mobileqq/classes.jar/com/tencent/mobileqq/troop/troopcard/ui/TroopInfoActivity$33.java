package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarManger;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class TroopInfoActivity$33
  implements Observer
{
  TroopInfoActivity$33(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!(paramObject instanceof TroopUploadingThread.UploadState)) {
      return;
    }
    paramObservable = (TroopUploadingThread.UploadState)paramObject;
    if (paramObservable.a == 1)
    {
      boolean bool;
      if (paramObservable.e == 1) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("update isAvatar=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        this.a.f.hasSetNewTroopHead = true;
        if (this.a.f.hasSetNewTroopName) {
          this.a.f.isNewTroop = false;
        }
        if (this.a.f.isUseClassAvatar) {
          this.a.f.isUseClassAvatar = false;
        }
        if (this.a.i != null)
        {
          this.a.i.hasSetNewTroopHead = true;
          this.a.i.isNewTroop = this.a.f.isNewTroop;
          if (this.a.i.isUseClassAvatar()) {
            this.a.i.setUseClassAvatar(false);
          }
          this.a.e();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "pullAvatarList");
        }
        this.a.D.a(this.a.f.troopUin);
      }
      if (this.a.isResume()) {
        this.a.runOnUiThread(new TroopInfoActivity.33.1(this, paramObservable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.33
 * JD-Core Version:    0.7.0.1
 */