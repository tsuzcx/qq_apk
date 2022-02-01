package com.tencent.mobileqq.troopshare;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TroopShareUtility$6
  extends QidianBusinessObserver
{
  TroopShareUtility$6(TroopShareUtility paramTroopShareUtility) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.h.removeObserver(this.a.t);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onQidianGroupInfo start");
    }
    if ((this.a.i != null) && (this.a.i.troopUin != null))
    {
      if ((this.a.l != null) && (this.a.l.isShowing()) && (this.a.a != -1) && (this.a.b != -1))
      {
        if ((paramBoolean) && (paramHashMap != null))
        {
          Object localObject = (String)paramHashMap.get("uin");
          if (!this.a.i.troopUin.equals(localObject))
          {
            this.a.b();
            return;
          }
          paramHashMap = (String)paramHashMap.get("url");
          localObject = this.a;
          ((TroopShareUtility)localObject).c = paramHashMap;
          int i = ((TroopShareUtility)localObject).a;
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i != 4) {
                    return;
                  }
                  this.a.b();
                  TroopShareUtility.g(this.a);
                  return;
                }
                this.a.b();
                TroopShareUtility.c(this.a);
                return;
              }
              this.a.b();
              TroopShareUtility.d(this.a);
              return;
            }
            this.a.b();
            TroopShareUtility.f(this.a);
            return;
          }
          paramHashMap = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
          localObject = this.a;
          ((TroopShareUtility)localObject).e = paramHashMap.getAvatarAddress("", ((TroopShareUtility)localObject).i.troopUin, 0);
          this.a.b();
          TroopShareUtility.e(this.a);
          return;
        }
        if (this.a.j != null) {
          this.a.j.a(this.a.a, false);
        }
        this.a.b();
        QQToast.makeText(this.a.h, 1, this.a.h.getString(2131890039), 0).show(this.a.h.getTitleBarHeight());
        paramHashMap = this.a;
        paramHashMap.a = -1;
        paramHashMap.b = -1;
      }
      return;
    }
    if ((this.a.h instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)this.a.h).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.6
 * JD-Core Version:    0.7.0.1
 */