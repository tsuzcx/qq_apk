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
      ForwardIMByThirdPartyHelper.a(this.a).g(true);
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = AIOUtils.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", ForwardIMByThirdPartyHelper.class.getSimpleName());
      paramDialogInterface.putExtra("uin", ForwardIMByThirdPartyHelper.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", ForwardIMByThirdPartyHelper.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", ForwardIMByThirdPartyHelper.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", ForwardIMByThirdPartyHelper.b(this.a));
      paramDialogInterface.putExtra("openid", ForwardIMByThirdPartyHelper.a(this.a));
      paramDialogInterface.putExtra("appid", ForwardIMByThirdPartyHelper.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", ForwardIMByThirdPartyHelper.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", ForwardIMByThirdPartyHelper.b(this.a));
      paramDialogInterface.putExtra("uinname", ForwardIMByThirdPartyHelper.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      ForwardIMByThirdPartyHelper.a(this.a).dismiss();
      RouteUtils.a(ForwardIMByThirdPartyHelper.a(this.a), paramDialogInterface, "/base/login");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper.2
 * JD-Core Version:    0.7.0.1
 */