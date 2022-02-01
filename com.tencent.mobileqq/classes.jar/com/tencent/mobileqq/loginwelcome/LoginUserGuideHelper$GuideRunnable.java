package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class LoginUserGuideHelper$GuideRunnable
  implements Runnable
{
  private final WeakReference<Activity> a;
  private final WeakReference<QQAppInterface> b;
  private final boolean c;
  private final LoginUserGuideHelper.LocationListener d;
  
  public LoginUserGuideHelper$GuideRunnable(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    this.a = new WeakReference(paramActivity);
    this.b = new WeakReference(paramQQAppInterface);
    this.c = paramBoolean;
    this.d = paramLocationListener;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    Activity localActivity = (Activity)this.a.get();
    if (localQQAppInterface != null)
    {
      if (localActivity == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GuideRunnable : ");
        localStringBuilder.append(this.c);
        QLog.i("LoginUserGuideHelper", 2, localStringBuilder.toString());
      }
      if (this.c) {
        ThreadManager.excute(new LoginUserGuideHelper.GuideRunnable.1(this, localQQAppInterface), 16, null, false);
      }
      LoginUserGuideHelper.a(localActivity, localQQAppInterface, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.GuideRunnable
 * JD-Core Version:    0.7.0.1
 */