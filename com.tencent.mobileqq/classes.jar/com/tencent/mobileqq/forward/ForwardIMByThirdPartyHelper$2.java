package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardIMByThirdPartyHelper$2
  implements DialogInterface.OnClickListener
{
  ForwardIMByThirdPartyHelper$2(ForwardIMByThirdPartyHelper paramForwardIMByThirdPartyHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardIMByThirdPartyHelper.a(this.a).j(true);
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = AIOUtils.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", ForwardIMByThirdPartyHelper.class.getSimpleName());
      paramDialogInterface.putExtra("uin", ForwardIMByThirdPartyHelper.b(this.a).b);
      paramDialogInterface.putExtra("uintype", ForwardIMByThirdPartyHelper.b(this.a).a);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", ForwardIMByThirdPartyHelper.c(this.a));
      paramDialogInterface.putExtra("pull_aio_video", ForwardIMByThirdPartyHelper.d(this.a));
      paramDialogInterface.putExtra("openid", ForwardIMByThirdPartyHelper.e(this.a));
      paramDialogInterface.putExtra("appid", ForwardIMByThirdPartyHelper.f(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", ForwardIMByThirdPartyHelper.c(this.a));
      paramDialogInterface.putExtra("pull_aio_video", ForwardIMByThirdPartyHelper.d(this.a));
      paramDialogInterface.putExtra("uinname", ForwardIMByThirdPartyHelper.b(this.a).e);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      ForwardIMByThirdPartyHelper.g(this.a).dismiss();
      RouteUtils.a(ForwardIMByThirdPartyHelper.h(this.a), paramDialogInterface, "/base/login");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper.2
 * JD-Core Version:    0.7.0.1
 */