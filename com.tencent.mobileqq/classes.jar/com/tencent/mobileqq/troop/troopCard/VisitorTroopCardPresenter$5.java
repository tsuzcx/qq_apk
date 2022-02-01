package com.tencent.mobileqq.troop.troopCard;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

class VisitorTroopCardPresenter$5
  implements Observer
{
  VisitorTroopCardPresenter$5(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((VisitorTroopCardPresenter.a(this.a) == null) || (VisitorTroopCardPresenter.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof TroopUploadingThread.UploadState));
      paramObservable = (TroopUploadingThread.UploadState)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
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
      if (!VisitorTroopCardPresenter.a(this.a).isResume()) {
        break;
      }
      VisitorTroopCardPresenter.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5
 * JD-Core Version:    0.7.0.1
 */