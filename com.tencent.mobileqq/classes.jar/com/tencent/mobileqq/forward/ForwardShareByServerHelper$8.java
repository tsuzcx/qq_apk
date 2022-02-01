package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;

class ForwardShareByServerHelper$8
  extends BroadcastReceiver
{
  ForwardShareByServerHelper$8(ForwardShareByServerHelper paramForwardShareByServerHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (ForwardShareByServerHelper.a(this.a) != null)
    {
      if (ForwardShareByServerHelper.a(this.a).isFinishing()) {
        return;
      }
      paramContext = ForwardImageDownUpMgr.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
      if (paramContext == null) {
        return;
      }
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = this.a;
        ForwardShareByServerHelper.a(paramContext, ForwardShareByServerHelper.a(paramContext).getIntent().getExtras());
        SdkShareReporter.a(ForwardShareByServerHelper.a(this.a), ForwardShareByServerHelper.a(this.a), ForwardShareByServerHelper.a(this.a));
        return;
      }
      ForwardShareByServerHelper.a(this.a, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.8
 * JD-Core Version:    0.7.0.1
 */