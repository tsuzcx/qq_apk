package com.tencent.mobileqq.troopgift;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;

class TroopGiftAnimationController$2
  extends TroopGiftCallback
{
  TroopGiftAnimationController$2(TroopGiftAnimationController paramTroopGiftAnimationController) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.a == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.a.a)
      {
        if ((TroopGiftAnimationController.a(this.a) != null) && (this.a.a != null))
        {
          if (paramInt == 20005)
          {
            TroopGiftAnimationController.a(this.a).a = 3;
            paramString = (TroopGiftManager)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
            if (this.a.i > 3) {
              paramString.a("OidbSvc.0x7f7", 2039, this.a.i, TroopGiftAnimationController.e(this.a).frienduin, TroopGiftAnimationController.e(this.a).bagId, 3000L, TroopGiftAnimationController.f(this.a));
            } else {
              paramString.a("OidbSvc.0x6b5", 1717, this.a.i, TroopGiftAnimationController.e(this.a).frienduin, TroopGiftAnimationController.e(this.a).bagId, 3000L, TroopGiftAnimationController.f(this.a));
            }
          }
          else
          {
            if (paramInt == -1)
            {
              String str1 = TroopGiftAnimationController.d(this.a).getResources().getString(2131895533);
              String str2 = com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[com.tencent.mobileqq.utils.NetworkUtil.getSystemNetwork(TroopGiftAnimationController.d(this.a))];
              Object localObject;
              if (this.a.i >= 4)
              {
                paramString = TroopGiftAnimationController.e(this.a).frienduin;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(TroopGiftUtil.b(TroopGiftAnimationController.e(this.a)));
                ((StringBuilder)localObject).append(str2);
                NearbyFlowerManager.a("cartoon", "timeout", paramString, ((StringBuilder)localObject).toString(), "", "");
                paramString = str1;
              }
              else
              {
                if (TroopGiftAnimationController.g(this.a) == null) {
                  break label590;
                }
                paramString = "0";
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("");
                ((StringBuilder)localObject).append(TroopGiftAnimationController.e(this.a).frienduin);
                localObject = ((StringBuilder)localObject).toString();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("");
                localStringBuilder.append(TroopGiftUtil.b(TroopGiftAnimationController.e(this.a)));
                ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, (String)localObject, localStringBuilder.toString(), paramString, str2);
                paramString = str1;
              }
            }
            else
            {
              paramString = TroopGiftAnimationController.d(this.a).getResources().getString(2131895532);
            }
            if ((this.a.a instanceof TroopGiftToAllSurfaceView))
            {
              ((TroopGiftToAllSurfaceView)this.a.a).a(paramString, TroopGiftAnimationController.c(this.a).E, DisplayUtil.a(TroopGiftAnimationController.d(this.a), 16.0F));
              TroopGiftAnimationController.a(this.a).a = 2;
              if (TroopGiftAnimationController.a(this.a).d > 0L)
              {
                if (TroopGiftAnimationController.a(this.a).c > TroopGiftAnimationController.a(this.a).d + 3000L) {
                  return;
                }
                this.a.f.removeCallbacks(TroopGiftAnimationController.b(this.a));
                this.a.a(2000L);
              }
            }
          }
        }
        else {
          return;
        }
      }
      label590:
      paramString = "1";
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      if ((TroopGiftAnimationController.a(this.a) != null) && (this.a.a != null))
      {
        TroopGiftAnimationController.a(this.a).c = NetConnInfoCenter.getServerTimeMillis();
        TroopGiftAnimationController.a(this.a).a = 2;
        if (TroopGiftAnimationController.a(this.a).d > 0L)
        {
          if (TroopGiftAnimationController.a(this.a).c > TroopGiftAnimationController.a(this.a).d + 3000L) {
            return;
          }
          this.a.f.removeCallbacks(TroopGiftAnimationController.b(this.a));
          this.a.a(2000L);
        }
        if (!TextUtils.isEmpty(paramString))
        {
          if (paramInt1 > 0) {
            paramInt1 = TroopGiftAnimationController.c(this.a).D;
          } else {
            paramInt1 = TroopGiftAnimationController.c(this.a).E;
          }
          ((TroopGiftToAllSurfaceView)this.a.a).a(paramString, paramInt1, DisplayUtil.a(TroopGiftAnimationController.d(this.a), 16.0F));
        }
        ((TroopGiftToAllSurfaceView)this.a.a).a();
        return;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.2
 * JD-Core Version:    0.7.0.1
 */