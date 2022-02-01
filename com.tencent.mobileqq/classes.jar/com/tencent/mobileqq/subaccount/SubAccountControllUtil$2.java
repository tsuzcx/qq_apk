package com.tencent.mobileqq.subaccount;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import mqq.app.AppRuntime;

final class SubAccountControllUtil$2
  implements DialogInterface.OnClickListener
{
  SubAccountControllUtil$2(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SubAccountAssistantForward.b(this.a);
    SubAccountAssistantForward.a(this.a);
    SubAccountAssistantForward.c(this.a);
    SubAccountAssistantForward.d(this.a);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("tab_index", FrameControllerUtil.a);
    paramDialogInterface.setFlags(67108864);
    RouteUtils.a(this.b, paramDialogInterface, "/base/start/splash");
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControllUtil.2
 * JD-Core Version:    0.7.0.1
 */