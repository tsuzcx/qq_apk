package com.tencent.qqmini.proxyimpl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class MediaChooseJsProxyImpl$1
  extends BroadcastReceiver
{
  MediaChooseJsProxyImpl$1(MediaChooseJsProxyImpl paramMediaChooseJsProxyImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!MediaChooseJsProxyImpl.a(this.a)) {
      return;
    }
    MediaChooseJsProxyImpl.a(this.a, false);
    paramContext = paramIntent.getAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAvatarReceiver.onReceive action=");
    localStringBuilder.append(paramContext);
    QLog.d("MediaChooseJsProxyImpl", 2, localStringBuilder.toString());
    if ("get_media_info".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaChooseJsProxyImpl", 2, new Object[] { paramIntent });
      }
      ThreadManagerV2.executeOnSubThread(new MediaChooseJsProxyImpl.1.1(this, paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */