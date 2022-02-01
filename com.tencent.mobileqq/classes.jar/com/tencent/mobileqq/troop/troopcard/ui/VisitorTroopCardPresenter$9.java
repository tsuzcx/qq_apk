package com.tencent.mobileqq.troop.troopcard.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

class VisitorTroopCardPresenter$9
  extends TroopAvatarObserver
{
  VisitorTroopCardPresenter$9(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  protected void onCmdTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (VisitorTroopCardPresenter.d(this.a) != null)
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      if (!Utils.a(paramString1, VisitorTroopCardPresenter.d(this.a).troopUin)) {
        return;
      }
      if (paramInt1 == 0)
      {
        this.a.a(paramList, true);
        return;
      }
      this.a.a(paramList, true);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        if (paramInt1 == 1) {
          paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131893832);
        } else if (paramInt1 == 2) {
          paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131893830);
        } else if (paramInt1 == 3) {
          paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131893843);
        } else if (paramInt1 == 4) {
          paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131893844);
        } else {
          paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131893841);
        }
      }
      VisitorTroopCardPresenter.b(this.a).a(paramString1);
    }
  }
  
  protected void onGetTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (VisitorTroopCardPresenter.d(this.a) != null)
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      if (paramBoolean)
      {
        if (!Utils.a(paramString1, VisitorTroopCardPresenter.d(this.a).troopUin)) {
          return;
        }
        if (paramInt1 == 0)
        {
          this.a.a(paramList, true);
          return;
        }
        if (paramString2 == null)
        {
          if ((paramInt1 != 1) && (paramInt1 != 2))
          {
            if (paramInt1 == 19) {
              paramString2 = VisitorTroopCardPresenter.a(this.a).getString(2131893830);
            } else if (paramInt1 == 65) {
              paramString2 = VisitorTroopCardPresenter.a(this.a).getString(2131893831);
            }
          }
          else {
            paramString2 = VisitorTroopCardPresenter.a(this.a).getString(2131893832);
          }
          VisitorTroopCardPresenter.b(this.a).a(paramString2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.9
 * JD-Core Version:    0.7.0.1
 */