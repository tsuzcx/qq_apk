package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarManger;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

class VisitorTroopCardPresenter$5
  implements Observer
{
  VisitorTroopCardPresenter$5(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (VisitorTroopCardPresenter.a(this.a) != null)
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      if (!(paramObject instanceof TroopUploadingThread.UploadState)) {
        return;
      }
      paramObservable = (TroopUploadingThread.UploadState)paramObject;
      if (paramObservable.a == 1)
      {
        boolean bool;
        if (paramObservable.d == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramObservable = VisitorTroopCardPresenter.a(this.a);
        VisitorTroopCardPresenter.a(this.a).a(VisitorTroopCardPresenter.a(this.a).troopUin);
        if (bool)
        {
          VisitorTroopCardPresenter.a(this.a).hasSetNewTroopHead = true;
          if (VisitorTroopCardPresenter.a(this.a).hasSetNewTroopName) {
            VisitorTroopCardPresenter.a(this.a).isNewTroop = false;
          }
          if (VisitorTroopCardPresenter.a(this.a).isUseClassAvatar) {
            VisitorTroopCardPresenter.a(this.a).isUseClassAvatar = false;
          }
          if ((paramObservable != null) && (paramObservable.a != null))
          {
            paramObservable.a.hasSetNewTroopHead = true;
            paramObservable.a.isNewTroop = VisitorTroopCardPresenter.a(this.a).isNewTroop;
            if (paramObservable.a.isUseClassAvatar()) {
              paramObservable.a.setUseClassAvatar(false);
            }
            this.a.c();
          }
        }
        if (VisitorTroopCardPresenter.a(this.a).isResume()) {
          VisitorTroopCardPresenter.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter.5
 * JD-Core Version:    0.7.0.1
 */