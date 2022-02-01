package com.tencent.mobileqq.troop.troopcard.ui;

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
    if (VisitorTroopCardPresenter.d(this.a) != null)
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
        if (paramObservable.e == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramObservable = VisitorTroopCardPresenter.j(this.a);
        VisitorTroopCardPresenter.k(this.a).a(VisitorTroopCardPresenter.d(this.a).troopUin);
        if (bool)
        {
          VisitorTroopCardPresenter.d(this.a).hasSetNewTroopHead = true;
          if (VisitorTroopCardPresenter.d(this.a).hasSetNewTroopName) {
            VisitorTroopCardPresenter.d(this.a).isNewTroop = false;
          }
          if (VisitorTroopCardPresenter.d(this.a).isUseClassAvatar) {
            VisitorTroopCardPresenter.d(this.a).isUseClassAvatar = false;
          }
          if ((paramObservable != null) && (paramObservable.X != null))
          {
            paramObservable.X.hasSetNewTroopHead = true;
            paramObservable.X.isNewTroop = VisitorTroopCardPresenter.d(this.a).isNewTroop;
            if (paramObservable.X.isUseClassAvatar()) {
              paramObservable.X.setUseClassAvatar(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.5
 * JD-Core Version:    0.7.0.1
 */