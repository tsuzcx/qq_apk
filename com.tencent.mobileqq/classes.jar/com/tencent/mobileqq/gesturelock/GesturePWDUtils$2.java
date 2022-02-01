package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class GesturePWDUtils$2
  implements Runnable
{
  GesturePWDUtils$2(Context paramContext) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("mqq.intent.action.QQ_BACKGROUND");
    localIntent.putExtra("process_name", BaseApplicationImpl.getApplication().getQQProcessName());
    try
    {
      this.a.sendBroadcast(localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("GESTUREPWDUTILS", 1, localException.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.GesturePWDUtils.2
 * JD-Core Version:    0.7.0.1
 */