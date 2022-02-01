package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class QQWinkUtil$1
  implements Runnable
{
  QQWinkUtil$1(Context paramContext) {}
  
  public void run()
  {
    if (QQWinkUtil.b(this.a)) {
      return;
    }
    Intent localIntent = new Intent(this.a, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getPeakServiceClass());
    localIntent.putExtra("ServiceAction", 6);
    try
    {
      this.a.startService(localIntent);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWinkUtil", 2, "preLoadPeakProcess, ", localThrowable);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWinkUtil", 2, "preLoadPeakProcess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.QQWinkUtil.1
 * JD-Core Version:    0.7.0.1
 */