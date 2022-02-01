package com.tencent.mobileqq.troopshare;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.troopshare.TroopShareResp;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopShareUtility$5
  extends TroopManagerBizObserver
{
  TroopShareUtility$5(TroopShareUtility paramTroopShareUtility) {}
  
  public void onTroopShareLink(boolean paramBoolean, TroopShareResp paramTroopShareResp)
  {
    this.a.h.removeObserver(this.a.s);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((this.a.i != null) && (this.a.i.troopUin != null) && (paramTroopShareResp != null) && (this.a.i.troopUin.equals(paramTroopShareResp.a)))
    {
      if ((this.a.l != null) && (this.a.l.isShowing()) && (this.a.a != -1) && (this.a.b != -1)) {
        if ((paramBoolean) && (paramTroopShareResp.b == 0))
        {
          if (paramTroopShareResp.c)
          {
            this.a.c = paramTroopShareResp.d;
            if (this.a.b != 0) {
              if ((this.a.h instanceof TroopCreateLogicActivity)) {
                ((TroopCreateLogicActivity)this.a.h).finish();
              }
            }
          }
          else
          {
            this.a.d = paramTroopShareResp.d;
            if (this.a.b != 1)
            {
              if ((this.a.h instanceof TroopCreateLogicActivity)) {
                ((TroopCreateLogicActivity)this.a.h).finish();
              }
              return;
            }
          }
          int i = this.a.a;
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4)
                  {
                    this.a.b();
                    TroopShareUtility.g(this.a);
                  }
                }
                else
                {
                  this.a.b();
                  TroopShareUtility.c(this.a);
                }
              }
              else
              {
                this.a.b();
                TroopShareUtility.d(this.a);
              }
            }
            else
            {
              this.a.b();
              TroopShareUtility.f(this.a);
            }
          }
          else
          {
            paramTroopShareResp = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
            TroopShareUtility localTroopShareUtility = this.a;
            localTroopShareUtility.e = paramTroopShareResp.getAvatarAddress("", localTroopShareUtility.i.troopUin, 0);
            this.a.b();
            TroopShareUtility.e(this.a);
          }
        }
        else
        {
          if ((paramTroopShareResp.c) && (this.a.b != 0))
          {
            if ((this.a.h instanceof TroopCreateLogicActivity)) {
              ((TroopCreateLogicActivity)this.a.h).finish();
            }
            return;
          }
          if ((!paramTroopShareResp.c) && (this.a.b != 1))
          {
            if ((this.a.h instanceof TroopCreateLogicActivity)) {
              ((TroopCreateLogicActivity)this.a.h).finish();
            }
            return;
          }
          if (this.a.j != null) {
            this.a.j.a(this.a.a, false);
          }
          this.a.b();
          QQToast.makeText(this.a.h, 1, this.a.h.getString(2131890039), 0).show(this.a.h.getTitleBarHeight());
          paramTroopShareResp = this.a;
          paramTroopShareResp.a = -1;
          paramTroopShareResp.b = -1;
        }
      }
      if ((this.a.h instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.h).finish();
      }
      return;
    }
    if ((this.a.h instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)this.a.h).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.5
 * JD-Core Version:    0.7.0.1
 */