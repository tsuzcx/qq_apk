package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.qroute.QRoute;

final class ReadInJoyDialogUtil$1
  implements DialogInterface.OnClickListener
{
  ReadInJoyDialogUtil$1(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      RIJShowKanDianTabSp.a(1);
      RIJShowKanDianTabSp.a(true);
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyTab(this.a, 9);
    }
    else
    {
      paramDialogInterface = new Intent(this.a, SplashActivity.class);
      paramDialogInterface.putExtra("fragment_id", 1);
      paramDialogInterface.putExtra("open_kandian_tab_fragment", true);
      paramDialogInterface.putExtra("arg_channel_cover_id", 0);
      paramDialogInterface.setFlags(335544320);
      this.a.startActivity(paramDialogInterface);
    }
    paramDialogInterface = this.a;
    if ((paramDialogInterface instanceof Activity)) {
      ((Activity)paramDialogInterface).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyDialogUtil.1
 * JD-Core Version:    0.7.0.1
 */