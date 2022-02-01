package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;

class NearbyLikeLimitManager$2
  implements DialogInterface.OnClickListener
{
  NearbyLikeLimitManager$2(NearbyLikeLimitManager paramNearbyLikeLimitManager, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.d.b;
    if ((paramDialogInterface != null) && (!TextUtils.isEmpty(paramDialogInterface.d)))
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDialogInterface.d);
      this.a.startActivity(localIntent);
    }
    ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.b, "clk_up", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyLikeLimitManager.2
 * JD-Core Version:    0.7.0.1
 */