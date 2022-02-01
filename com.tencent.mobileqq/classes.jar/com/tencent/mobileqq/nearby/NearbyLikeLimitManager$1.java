package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;

class NearbyLikeLimitManager$1
  implements DialogInterface.OnClickListener
{
  NearbyLikeLimitManager$1(NearbyLikeLimitManager paramNearbyLikeLimitManager, boolean paramBoolean, String paramString1, INearbyLikeLimitManager.onDoVoteListener paramonDoVoteListener, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a) {
      this.g.i();
    } else {
      this.g.j();
    }
    if (this.g.d())
    {
      this.g.a(Long.valueOf(this.b).longValue(), 0, 1);
      this.c.a(this.b, false);
      ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.d, "pay_like", this.b, this.e, "", "", "");
    }
    else
    {
      this.g.a(this.f, this.e);
      ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.d, "exp_pay", this.e);
    }
    ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.d, "clk_no_warm", this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyLikeLimitManager.1
 * JD-Core Version:    0.7.0.1
 */