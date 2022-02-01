package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class ForwardDialogMgr$1
  implements DialogInterface.OnClickListener
{
  ForwardDialogMgr$1(Intent paramIntent, int paramInt, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = this.a.getLongExtra("sdk_mult_share_source_app_id", 0L);
    int i = this.a.getIntExtra("sdk_mult_share_msg_service_id", 0);
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardDialogMgr", 2, "-->showMultShareDialog--stay");
      }
      paramInt = this.b;
      if (paramInt == 901503) {
        ForwardShareByServerHelper.a(this.c, "shareToQQ", l, 0, ForwardShareByServerHelper.a);
      } else if (paramInt == 3) {
        ForwardShareByServerHelper.a(l, i, this.c, null);
      } else {
        ForwardShareByServerHelper.a(l, i, this.c);
      }
      paramInt = this.b;
      if (paramInt == 1)
      {
        ForwardUtils.a(this.d, "0X800A73F", new String[0]);
        return;
      }
      if (paramInt == 0)
      {
        ForwardUtils.a(this.d, "0X800A73B", new String[0]);
        return;
      }
      if ((paramInt == 2) || (paramInt == 901503)) {
        ForwardUtils.a(this.d, "0X800A73D", new String[0]);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardDialogMgr", 2, "-->showMultShareDialog--back");
      }
      if (this.b == 2) {
        ForwardShareByServerHelper.a(this.c, "shareToQQ", l, 0, ForwardShareByServerHelper.a);
      } else {
        ForwardShareByServerHelper.a(l, i, this.c, null);
      }
      paramInt = this.b;
      if (paramInt == 1)
      {
        ForwardUtils.a(this.d, "0X800A740", new String[0]);
        return;
      }
      if (paramInt == 0)
      {
        ForwardUtils.a(this.d, "0X800A73C", new String[0]);
        return;
      }
      if ((paramInt == 2) || (paramInt == 901503)) {
        ForwardUtils.a(this.d, "0X800A73E", new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardDialogMgr.1
 * JD-Core Version:    0.7.0.1
 */