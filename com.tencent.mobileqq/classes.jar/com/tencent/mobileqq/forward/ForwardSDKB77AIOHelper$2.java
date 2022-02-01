package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ForwardSDKB77AIOHelper$2
  extends BroadcastReceiver
{
  ForwardSDKB77AIOHelper$2(ForwardSDKB77AIOHelper paramForwardSDKB77AIOHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((ForwardSDKB77AIOHelper.a(this.a) != null) && (!ForwardSDKB77AIOHelper.a(this.a).isFinishing()))
    {
      ForwardSDKB77AIOHelper.d(this.a);
      ForwardSDKB77AIOHelper.e(this.a).removeMessages(93);
      ForwardSDKB77AIOHelper.e(this.a).removeMessages(94);
      paramContext = ((ForwardSdkStatusManager)ForwardSDKB77AIOHelper.c(this.a).d.getManager(QQManagerFactory.SDK_SHARE)).a(ForwardSDKB77AIOHelper.f(this.a));
      if (paramContext == null)
      {
        QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
        return;
      }
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "onReceive parseB77Result key:", ForwardSDKB77AIOHelper.f(this.a) });
      ForwardSDKB77AIOHelper.a(this.a, paramContext);
      return;
    }
    QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.2
 * JD-Core Version:    0.7.0.1
 */