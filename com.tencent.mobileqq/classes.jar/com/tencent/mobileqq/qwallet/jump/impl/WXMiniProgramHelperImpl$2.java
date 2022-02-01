package com.tencent.mobileqq.qwallet.jump.impl;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class WXMiniProgramHelperImpl$2
  implements PendingIntent.OnFinished
{
  WXMiniProgramHelperImpl$2(WXMiniProgramHelperImpl paramWXMiniProgramHelperImpl) {}
  
  public void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramPendingIntent = new StringBuilder();
      paramPendingIntent.append("onSendFinished resultCode: ");
      paramPendingIntent.append(paramInt);
      paramPendingIntent.append(", resultData: ");
      paramPendingIntent.append(paramString);
      QLog.d("WXMiniProgramHelperImpl", 2, paramPendingIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.jump.impl.WXMiniProgramHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */