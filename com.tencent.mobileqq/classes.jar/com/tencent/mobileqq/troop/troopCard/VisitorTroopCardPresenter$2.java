package com.tencent.mobileqq.troop.troopCard;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;

class VisitorTroopCardPresenter$2
  extends OpenIdObserver
{
  VisitorTroopCardPresenter$2(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((VisitorTroopCardPresenter.a(this.a) == null) || (VisitorTroopCardPresenter.a(this.a) == null) || (VisitorTroopCardPresenter.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while ((VisitorTroopCardPresenter.a(this.a).isFinishing()) || (VisitorTroopCardPresenter.a(this.a)));
      VisitorTroopCardPresenter.a(this.a).d();
      if (VisitorTroopCardPresenter.a(this.a) != null) {
        VisitorTroopCardPresenter.a(this.a).removeCallbacksAndMessages(null);
      }
    } while ((!paramBoolean) || (paramOpenID == null) || (paramOpenID.openID == null) || (paramOpenID.openID.equals(VisitorTroopCardPresenter.a(this.a))));
    VisitorTroopCardPresenter.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.2
 * JD-Core Version:    0.7.0.1
 */